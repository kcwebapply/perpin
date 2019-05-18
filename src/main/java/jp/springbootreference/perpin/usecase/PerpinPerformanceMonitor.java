package jp.springbootreference.perpin.usecase;

import jp.springbootreference.perpin.domain.model.AppStatus;

import java.util.HashMap;

public class PerpinPerformanceMonitor {

    public static HashMap<Integer, PerpinPerformanceThread> perpinThreadMap = new HashMap<>();


    public static void monitor(int id){
        PerpinPerformanceThread t = new PerpinPerformanceThread();
        perpinThreadMap.put(id,t);
        t.start();
    }


    public static HashMap<Integer,AppStatus> getStatusAndStopMonitoring(int id){
        PerpinPerformanceThread thread = perpinThreadMap.get(id);
        thread.stop();
        HashMap<Integer, AppStatus> statusChart = thread.getStatusChart();
        /*statusChart.forEach((key, value) -> {
            System.out.println(key + ":"+value.toString());
        });*/
        return statusChart;
    }


}
