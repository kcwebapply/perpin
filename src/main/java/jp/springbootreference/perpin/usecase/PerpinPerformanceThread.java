package jp.springbootreference.perpin.usecase;

import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.library.CpuLibraryWrapper;
import jp.springbootreference.perpin.library.MemoryLibraryWrapper;

import java.util.HashMap;

public class PerpinPerformanceThread extends Thread {


    private boolean running = true;

    private HashMap<Integer, AppStatus> appStatusChart = new HashMap<>();

    private int statusIndex = 0;

    long intialTime = System.currentTimeMillis();

    @Override
    public void run(){

        while(running){
            try {
                AppStatus status = getStatus();
                appStatusChart.put(statusIndex,status);
                statusIndex++;
                this.sleep(100);
            } catch (InterruptedException e) {
                // to stop performance measurance.
               running = false;
            }
        }

    }


    public HashMap<Integer, AppStatus> getStatusChart() {
        AppStatus status = getStatus();
        appStatusChart.put(statusIndex,status);
        return appStatusChart;
    }

    private AppStatus getStatus(){
        long startTime = System.currentTimeMillis() - intialTime;
        long freeMemory = MemoryLibraryWrapper.getFreeMemory();
        long usedMemory = MemoryLibraryWrapper.getUsedMemory();
        double cpuPercentage = CpuLibraryWrapper.getProcessCpuPercentage();
        AppStatus status = new AppStatus(startTime,freeMemory,usedMemory,cpuPercentage);
        return status;
    }



}
