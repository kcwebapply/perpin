package jp.springbootreference.perpin.domain.model;


public class AppStatus {

    public AppStatus(long time,long freeMemory, long usedMemory,double cpuPercentage){
        this.executedTime = time;
        this.usedMemory = usedMemory;
        this.freeMemory = freeMemory;
        this.cpuPercentage = cpuPercentage;
    }

    private long executedTime;

    private long usedMemory;

    private long freeMemory;

    private double cpuPercentage;

    public long getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(long executedTime) {
        this.executedTime = executedTime;
    }

    public long getUsedMemory(){
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public long getFreeMemory(){
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public double getCpuPercentage() {
        return cpuPercentage;
    }

    public void setCpuPercentage(double cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }
}
