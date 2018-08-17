package jp.koya.jbeacon.util;

/**
 * プラットフォームによって異なる処理のラッパー.
 * @author koya
 */
public class Platform {
    private Platform() { }
    
    public static void loadLibrary(String path) {
	if(isWindows()) {
	    System.load(path + ".dll");
	} else if(isLinux() || isMac()) {
	    System.load(path + ".so");
	} else {
	    throw new RuntimeException();
	}
    }
    
    public static boolean isWindows() {
	return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }
    
    public static boolean isMac() {
	return System.getProperty("os.name").toLowerCase().startsWith("mac");
    }
    
    public static boolean isLinux() {
	return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }
    
    public static boolean isSun() {
	return System.getProperty("os.name").toLowerCase().startsWith("sunos");
    }
}
