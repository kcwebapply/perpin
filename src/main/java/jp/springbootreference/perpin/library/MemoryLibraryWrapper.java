package jp.springbootreference.perpin.library;

public class MemoryLibraryWrapper {

    /**
     * get Free Memory returns how much memory application are afford.
     * @return memory value.
     */
    public static long getFreeMemory(){
        return Runtime.getRuntime().freeMemory() / 1024;
    }

    /**
     * get Used Memory returns how much memory application using now by kiro-bite..
     * @return memory value.
     */
    public static long getUsedMemory(){
        long freeMemory =  Runtime.getRuntime().freeMemory() / (1024);
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024);
        return  totalMemory - freeMemory;
    }

}
