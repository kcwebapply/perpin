package jp.springbootreference.perpin.library;



import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class CpuLibraryWrapper {

    private static OperatingSystemMXBean osMx = (com.sun.management.OperatingSystemMXBean)
            ManagementFactory.getOperatingSystemMXBean();

    /**
     * this method return cpu using percentage.
     * @return
     */
    public static double getProcessCpuPercentage(){
        return ((com.sun.management.OperatingSystemMXBean) osMx).getProcessCpuLoad();
    }



}
