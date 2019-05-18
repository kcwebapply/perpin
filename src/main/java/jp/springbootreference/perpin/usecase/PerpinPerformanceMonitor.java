package jp.springbootreference.perpin.usecase;

import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.exception.PerpinException;

import java.util.HashMap;

public class PerpinPerformanceMonitor {

    private static HashMap<Integer, PerpinPerformanceThread> perpinThreadMap = new HashMap<>();


    public static void monitor(int id){
        if(perpinThreadMap.containsKey(id)){
            throw new PerpinException(String.format("Perpin Context Error! thread with context-id &d already exists.",id));
        }
        PerpinPerformanceThread t = new PerpinPerformanceThread();
        perpinThreadMap.put(id,t);
        t.start();
    }


    public static HashMap<Integer,AppStatus> getStatusAndStopMonitoring(int id){
        PerpinPerformanceThread thread = perpinThreadMap.get(id);
        if(thread==null){
            throw new PerpinException(String.format("Perpin Context Error! thread with context-id &d doesn'texists.",id));
        }
        thread.stop();
        perpinThreadMap.remove(id);
        HashMap<Integer, AppStatus> statusChart = thread.getStatusChart();
        return statusChart;
    }


}
