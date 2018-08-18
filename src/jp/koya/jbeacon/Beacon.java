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
    /**
     * 現在の jbeacon の状態.
     */
    public enum State {
	None,
	Initialized,
	Destroyed
    }
    private static State state = State.None;
    
    /**
     * jbeacon を初期化します.
     */
    public static void init() {
	if(state != State.None) {
	    throw new IllegalStateException();
	}
	nativeInit();
	state = State.Initialized;
    }

    /**
     * jbeacon を終了します.
     */
    public static void destroy() {
	if(state != State.Initialized) {
	    throw new IllegalStateException();
	}
	nativeDestroy();
	state = State.Destroyed;
    }
    
    private native static void nativeInit();
    private native static void nativeDestroy();
}
