package jp.springbootreference.perpin.usecase;


import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.domain.model.PerpinPerformanceDto;

public class PerpinDataCalculator {

    public static PerpinPerformanceDto calc(AppStatus firstStatus, AppStatus lastStatus){

        long elapsedTime = lastStatus.getExecutedTime() - firstStatus.getExecutedTime();

        long usedDuring = lastStatus.getUsedMemory() - firstStatus.getUsedMemory();

        long maxMemory = lastStatus.getFreeMemory() + lastStatus.getUsedMemory();

        double ratio = (usedDuring  * 100 / (double)(maxMemory));

        double cpuUpDownPercentage = lastStatus.getCpuPercentage() - firstStatus.getCpuPercentage();

        return new PerpinPerformanceDto(elapsedTime,usedDuring,maxMemory,ratio,cpuUpDownPercentage);
    }

}
