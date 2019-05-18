package jp.springbootreference.perpin.view;

import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class PerPinView {

    public static Logger logger = LoggerFactory.getLogger(PerPinView.class);


    private static final String format = "\n####################################### \n" +
                          "contextId:%d\n"+
                          "time:%d ms\n"+
                          "memory:\n" +
                          "   used:%d KB\n"+
                          "   max :%d KB\n"+
                          "   used percentage:%f %%\n"+
                          "cpu percentage:%f %%\n"+
                          "####################################### \n";

    private static final String dataFormat =
            "{ 'time':'%d ms',"+
            " 'memory' : {" +
            "'used':'%d KB',"+
            "'max':'%d KB',"+
            "'used percentage':'%f %%'},"+
            "'cpu percentage':'%f %%'}\n";

    /*public static void PerPinView(int id, PerpinPerformanceDto dto){
        logger.info(String.format(format,id,dto.getElapsedTime(),
                dto.getUsedMemory(),
                dto.getMaxMemory(),
                dto.getMemoryUsedRation(),
                dto.getCpuUpDownPercentage()*100
        ));
    }*/


    public static void PerPinView(int id , List<PerpinPerformanceDto> appStatusHashMap){
        appStatusHashMap.forEach((performanceDto) -> {

            final String format = String.format(dataFormat,performanceDto.getElapsedTime(),
                    performanceDto.getUsedMemory(),
                    performanceDto.getMaxMemory(),
                    performanceDto.getMemoryUsedRation(),
                    performanceDto.getCpuUpDownPercentage()*100
            );

            System.out.println(format);

        });
    }
}
