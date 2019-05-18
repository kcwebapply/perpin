package jp.springbootreference.perpin;


import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinViewDto;

import jp.springbootreference.perpin.usecase.PerpinDataCalculator;
import jp.springbootreference.perpin.usecase.PerpinPerformanceMonitor;
import jp.springbootreference.perpin.view.PerPinView;

import java.util.HashMap;



public class Perpin {

    public static void setPin(Integer id){
        PerpinPerformanceMonitor.monitor(id);
    }


    public static void getPin(Integer id){
        final HashMap<Integer, AppStatus> statusChart = PerpinPerformanceMonitor.getStatusAndStopMonitoring(id);
        final PerpinViewDto perpinViewDto = PerpinDataCalculator.calc(statusChart);
        PerPinView.PerPinView(id,perpinViewDto);
    }
}
