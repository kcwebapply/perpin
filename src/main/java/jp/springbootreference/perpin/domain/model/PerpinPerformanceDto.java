package jp.springbootreference.perpin.domain.model;

public class PerpinPerformanceDto {


    public PerpinPerformanceDto(long elapsedTime, long usedMemory, long maxMemory, double memoryUsedPercentage, double cpuPercentage){
        this.elapsedTime = elapsedTime;
        this.usedMemory = usedMemory;
        this.maxMemory = maxMemory;
        this.memoryUsedPercentage = memoryUsedPercentage;
        this.cpuPercentage = cpuPercentage;
    }

    private long elapsedTime;

    private long usedMemory;

    private long maxMemory;

    private double memoryUsedPercentage;

    private double cpuPercentage;

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public double getMemoryUsedPercentage() {
        return memoryUsedPercentage;
    }

    public void setMemoryUsedPercentage(double memoryUsedPercentage) {
        this.memoryUsedPercentage = memoryUsedPercentage;
    }

    public double getCpuPercentage() {
        return cpuPercentage;
    }

    public void setCpuPercentage(double cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }
}
