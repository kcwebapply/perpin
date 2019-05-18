package jp.springbootreference.perpin.usecase;


import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;
import jp.springbootreference.perpin.domain.model.PerpinViewDto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PerpinDataCalculator {

    public static PerpinViewDto calc(HashMap<Integer, AppStatus> appStatusHashMap){



        List<PerpinPerformanceDto> dtoList = appStatusHashMap.entrySet().stream().map(
                e -> generateDto(e.getValue())
        ).collect(Collectors.toList());


        // execution time .
        final long executionIime = getTime(appStatusHashMap);

        // max value of memory used percentage.
        final double maxUsedMemoryPercentage= getMaxUsedMemoryPercentage(dtoList);

        // max value of cpu used percentage.
        final double maxCpuPercentage = getMaxCpuPercentage(dtoList);

        // max value of cpu used percentage.
        final double averageCpuPercentage = getAverageCpuPercentage(dtoList);
        return new PerpinViewDto(dtoList,executionIime,maxUsedMemoryPercentage,maxCpuPercentage,averageCpuPercentage);
    }

    /**
     * getTime return  application execution time .
     * @param appStatusHashMap
     * @return exexutionTime
     */
    private static long getTime(HashMap<Integer, AppStatus> appStatusHashMap){
        return appStatusHashMap.get(appStatusHashMap.size()-1).getExecutedTime();
    }


    /**
     * getMaxUsedMemoryRatio return max value of all of memory used ration data.
     * @param dtoList
     * @return maxusedMemoryRationValue
     */
    private static double getMaxUsedMemoryPercentage(List<PerpinPerformanceDto> dtoList){
        PerpinPerformanceDto perpinPerformanceDto = dtoList.stream().sorted((o1, o2) -> {
            if(o1.getMemoryUsedPercentage() > o2.getMemoryUsedPercentage()){
                return -1;
            }else{
                return 1;
            }
        }).findFirst().orElse(null);
        return perpinPerformanceDto.getMemoryUsedPercentage();
    }

    /**
     * getMaxUsedMemoryRatio return max value of all of memory used ration data.
     * @param dtoList
     * @return maxusedMemoryRationValue
     */
    private static double getMaxCpuPercentage(List<PerpinPerformanceDto> dtoList){
        PerpinPerformanceDto perpinPerformanceDto = dtoList.stream().sorted((o1, o2) -> {
            if(o1.getCpuPercentage() > o2.getCpuPercentage()){
                return -1;
            }else{
                return 1;
            }
        }).findFirst().orElse(null);
        return perpinPerformanceDto.getCpuPercentage();
    }

    /**
     * getMaxUsedMemoryRatio return max value of all of memory used ration data.
     * @param dtoList
     * @return maxusedMemoryRationValue
     */
    private static double getAverageCpuPercentage(List<PerpinPerformanceDto> dtoList){
        return dtoList.stream().mapToDouble(dto -> dto.getCpuPercentage()).sum()/dtoList.size();
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
