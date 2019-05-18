package jp.springbootreference.perpin.view;

import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;
import jp.springbootreference.perpin.domain.model.PerpinViewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PerPinView {

    public static Logger logger = LoggerFactory.getLogger(PerPinView.class);


    private static final String dataFormat =
            "{ 'id': %d, 'time':'%d ms',"+
            " 'memory' : {" +
            "'used':'%d KB',"+
            "'max':'%d KB',"+
            "'used percentage':'%f %%'},"+
            "'cpu percentage':'%f %%'}";

    private static final String SummaryLog =
            "{{ 'id': %d, 'time':'%d ms',"+
                    "'memoryMaxpercentage':'%f %%',"+
                    "'cpuMaxPercentage':'%f %%',"+
                    "'cpuAverage':'%f %%'}";

    public static void PerPinView(int id , PerpinViewDto perpinViewDto){


        final List<String> dtoLogs = perpinViewDto.getPerpinPerformanceDtoList().stream().map(performanceDto -> {
            return String.format(dataFormat,id,performanceDto.getElapsedTime(),
                    performanceDto.getUsedMemory(),
                    performanceDto.getMaxMemory(),
                    performanceDto.getMemoryUsedPercentage(),
                    performanceDto.getCpuPercentage()*100
            );
        }).collect(Collectors.toList());
        final String logStrings = String.join("\n",dtoLogs);
        final String summary = String.format(SummaryLog, id, perpinViewDto.getExecutionTime(),
                perpinViewDto.getMaxUsedMemoryPercentage(),
                perpinViewDto.getMaxCpuPercentage(),
                perpinViewDto.getAverageCpuPercentage()*100);

        logger.info(logStrings +"\n"+ summary);

    }
}
