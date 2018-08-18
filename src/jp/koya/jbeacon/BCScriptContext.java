package jp.koya.jbeacon;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

/**
 * jbeacon の BCScriptContext を表します.
 * @author koya
 */
public class BCScriptContext {
    private byte[] cptr;
    
    private static final Stack<BCScriptContext> contextStack = new Stack<>();
    private static final Object mutex = new Object();
    
    private BCScriptContext(byte[] cptr) {
	this.cptr = cptr;
    }
    
    /**
     * 新しいスクリプトコンテキストを作成します.
     * @return 
     */
    public static BCScriptContext open() {
	synchronized(mutex) {
	    BCScriptContext ret = nativeOpen();
	    contextStack.push(ret);
	    return ret;
	}
    }
    
    /**
     * 最後に作成したスクリプトコンテキストを削除します.
     */
    public static void close() {
	synchronized(mutex) {
	    nativeClose();
	    contextStack.pop();
	}
    }
    
    /**
     * 現在のスクリプトコンテキストを返します.
     * @return 
     */
    public static Optional<BCScriptContext> current() {
	synchronized(mutex) {
	    if(contextStack.empty()) {
		return Optional.empty();
	    } else {
		return Optional.ofNullable(contextStack.peek());
	    }
	}
    }

    private static native BCScriptContext nativeOpen();
    private static native void nativeClose();
}
