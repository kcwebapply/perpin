package jp.springbootreference.perpin.domain.model;

import java.util.List;

public class PerpinViewDto {

    public PerpinViewDto(List<PerpinPerformanceDto> perpinPerformanceDtoList,long executionTime,
                         double maxUsedMemoryPercentage, double maxCpuPercentage,double averageCpuPercentage){
        this.perpinPerformanceDtoList = perpinPerformanceDtoList;
        this.executionTime = executionTime;
        this.maxUsedMemoryPercentage = maxUsedMemoryPercentage;
        this.maxCpuPercentage = maxCpuPercentage;
        this.averageCpuPercentage = averageCpuPercentage;
    }

    private List<PerpinPerformanceDto> perpinPerformanceDtoList;

    private long executionTime;

    private double maxUsedMemoryPercentage;

    private double maxCpuPercentage;

    private double averageCpuPercentage;

    public List<PerpinPerformanceDto> getPerpinPerformanceDtoList(){
        return perpinPerformanceDtoList;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public double getMaxUsedMemoryPercentage(){
        return this.maxUsedMemoryPercentage;
    }

    public double getMaxCpuPercentage(){
        return this.maxCpuPercentage;
    }

    public double getAverageCpuPercentage(){
        return this.averageCpuPercentage;
    }



}
