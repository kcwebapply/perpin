package jp.springbootreference.perpin.usecase;

import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.library.CpuLibraryWrapper;
import jp.springbootreference.perpin.library.MemoryLibraryWrapper;

import java.util.HashMap;

public class PerpinPerformanceThread extends Thread {


    private boolean running = true;

    private HashMap<Integer, AppStatus> appStatusChart = new HashMap<>();

    private int statusIndex = 0;

    private long initialTime = System.currentTimeMillis();

    private static int SLEEP_TIME = 100;


    @Override
    public void run(){

        while(running){
            try {
                AppStatus status = getStatus();
                appStatusChart.put(statusIndex,status);
                statusIndex++;
                this.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                // to stop performance measurance.
               running = false;
            }
        }

    }

    public void stopMonitoring(){
        this.running = false;
        this.stop();
    }

    public HashMap<Integer, AppStatus> getStatusChart() {
        AppStatus status = getStatus();
        appStatusChart.put(statusIndex,status);
        return appStatusChart;
    }

    private AppStatus getStatus(){
        long startTime = System.currentTimeMillis() - initialTime;
        long freeMemory = MemoryLibraryWrapper.getFreeMemory();
        long usedMemory = MemoryLibraryWrapper.getUsedMemory();
        double cpuPercentage = CpuLibraryWrapper.getProcessCpuPercentage();
        AppStatus status = new AppStatus(startTime,freeMemory,usedMemory,cpuPercentage);
        return status;
    }



}
