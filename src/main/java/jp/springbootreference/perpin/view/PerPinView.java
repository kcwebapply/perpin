package jp.springbootreference.perpin.view;

import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static void PerPinView(int id, PerpinPerformanceDto dto){
        logger.info(String.format(format,id,dto.getElapsedTime(),
                dto.getUsedMemory(),
                dto.getMaxMemory(),
                dto.getMemoryUsedRation(),
                dto.getCpuUpDownPercentage()*100
        ));
    }
}
