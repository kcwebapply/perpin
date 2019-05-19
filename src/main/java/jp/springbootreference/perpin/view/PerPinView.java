package jp.springbootreference.perpin.view;


import jp.springbootreference.perpin.domain.model.PerpinViewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PerPinView {

    public static Logger logger = LoggerFactory.getLogger(PerPinView.class);

    private static final String unitsExpression = "{" +
            "\"time\":\"ms\","+
            "\"used\":\"KB\"," +
            "\"percentage:\":\"%\""+
            "}";

    private static final String dataFormat =
            "{ \"id\": %d, \"time\":\"%d \","+
            " \"memory\" : {" +
            "\"used\":\"%d\","+
            "\"max\":\"%d\","+
            "\"used percentage\":\"%f\"},"+
            "\"cpu percentage\":\"%f\"}";

    private static final String SummaryLog =
                    "{ \"id\": %d, \"time\":\"%d\","+
                    "\"memoryMaxpercentage\":\"%f\","+
                    "\"cpuMaxPercentage\":\"%f\","+
                    "\"cpuAverage\":\"%f\"}";

    public static void PerPinView(int id , PerpinViewDto perpinViewDto){


        final List<String> dtoLogs = perpinViewDto.getPerpinPerformanceDtoList().stream().map(performanceDto -> {
            return String.format(dataFormat,id,performanceDto.getElapsedTime(),
                    performanceDto.getUsedMemory(),
                    performanceDto.getMaxMemory(),
                    performanceDto.getMemoryUsedPercentage(),
                    performanceDto.getCpuPercentage()*100
            );
        }).collect(Collectors.toList());
        final String statusLogss = String.join(",\n",dtoLogs);
        final String summaryLog = String.format(SummaryLog, id, perpinViewDto.getExecutionTime(),
                perpinViewDto.getMaxUsedMemoryPercentage(),
                perpinViewDto.getMaxCpuPercentage()*100,
                perpinViewDto.getAverageCpuPercentage()*100);

        final String outputLog = String.format(
                "{ \"statuses\":\n[%s], \n\"overall\":%s, \n\"units\":%s}",
                statusLogss,summaryLog,unitsExpression
        );
        logger.info(outputLog);

    }
}
