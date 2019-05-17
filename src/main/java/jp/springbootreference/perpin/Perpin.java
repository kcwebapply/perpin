package jp.springbootreference.perpin;


import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;
import jp.springbootreference.perpin.library.CpuLibraryWrapper;
import jp.springbootreference.perpin.library.MemoryLibraryWrapper;
import jp.springbootreference.perpin.usecase.PerpinDataCalculator;
import jp.springbootreference.perpin.view.PerPinView;


public class Perpin {

    public static void setPin(Integer id){
        long startTime = System.currentTimeMillis();
        long freeMemory = MemoryLibraryWrapper.getFreeMemory();
        long usedMemory = MemoryLibraryWrapper.getUsedMemory();
        double cpuPercentage = CpuLibraryWrapper.getProcessCpuPercentage();

        AppStatus initialStatus = new AppStatus(startTime,freeMemory,usedMemory,cpuPercentage);

        PerpinContext.setStatus(id,initialStatus);
    }


    public static void getPin(Integer id){
        long endTime = System.currentTimeMillis();
        long freeMemory = MemoryLibraryWrapper.getFreeMemory();
        long usedMemory = MemoryLibraryWrapper.getUsedMemory();
        double cpuPercentage = CpuLibraryWrapper.getProcessCpuPercentage();

        AppStatus lastStatus = new AppStatus(endTime, freeMemory,usedMemory,cpuPercentage);

        AppStatus initialStatus = PerpinContext.getStatus(id);

        PerpinContext.deleteContext(id);

        PerpinPerformanceDto performanceDto = PerpinDataCalculator.calc(initialStatus,lastStatus);

        PerPinView.PerPinView(id,performanceDto);
    }
}
