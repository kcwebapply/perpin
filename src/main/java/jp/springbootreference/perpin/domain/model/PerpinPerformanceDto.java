package jp.springbootreference.perpin.domain.model;

public class PerpinPerformanceDto {


    public PerpinPerformanceDto(long elapsedTime, long usedMemory, long maxMemory, double memoryUsedRation, double cpuUpDownPercentage){
        this.elapsedTime = elapsedTime;
        this.usedMemory = usedMemory;
        this.maxMemory = maxMemory;
        this.memoryUsedRation = memoryUsedRation;
        this.cpuUpDownPercentage = cpuUpDownPercentage;
    }

    private long elapsedTime;

    private long usedMemory;

    private long maxMemory;

    private double memoryUsedRation;

    private double cpuUpDownPercentage;

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

    public double getMemoryUsedRation() {
        return memoryUsedRation;
    }

    public void setMemoryUsedRation(double memoryUsedRation) {
        this.memoryUsedRation = memoryUsedRation;
    }

    public double getCpuUpDownPercentage() {
        return cpuUpDownPercentage;
    }

    public void setCpuUpDownPercentage(double cpuUpDownPercentage) {
        this.cpuUpDownPercentage = cpuUpDownPercentage;
    }
}
