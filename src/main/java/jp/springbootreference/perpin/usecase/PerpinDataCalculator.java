package jp.springbootreference.perpin.usecase;


import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PerpinDataCalculator {

    public static List<PerpinPerformanceDto> calc(HashMap<Integer, AppStatus> appStatusHashMap){

        return appStatusHashMap.entrySet().stream().map(
                e -> generateDto(e.getValue())
        ).collect(Collectors.toList());
    }

    private static PerpinPerformanceDto generateDto(AppStatus status){
        long Time = status.getExecutedTime();

        long usedDuring =  status.getUsedMemory();

        long maxMemory = status.getFreeMemory() + status.getUsedMemory();

        double ratio = (usedDuring  * 100 / (double)(maxMemory));

        double cpuPercentage = status.getCpuPercentage();

        return new PerpinPerformanceDto(Time,usedDuring,maxMemory,ratio,cpuPercentage);
    }

}
