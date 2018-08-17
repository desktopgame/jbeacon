package jp.koya.jbeacon;

import jp.koya.jbeacon.util.Platform;

/**
 * Beacon言語のためのユーティリティ.
 * @author koya
 */
public class Beacon {
    static {
	Platform.loadLibrary(System.getProperty("user.dir") + "/beacon");
    }
    
    public static void init() {
	nativeInit();
    }
    
    public static void execute(String filename) {
	nativeExecute(filename);
    }
    
    public static void destroy() {
	nativeDestroy();
    }
    
    private native static void nativeInit();
    private native static void nativeExecute(String filename);
    private native static void nativeDestroy();
}
