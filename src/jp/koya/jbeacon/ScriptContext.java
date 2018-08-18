package jp.koya.jbeacon;

import java.util.Optional;
import java.util.Stack;

/**
 * jbeacon の ScriptContext を表します.
 * @author koya
 */
public class ScriptContext {
    private ScriptContext prev;
    private ScriptContext next;
    private byte[] cptr;
    
    private static final Stack<ScriptContext> contextStack = new Stack<>();
    private static final Object mutex = new Object();
    
    private ScriptContext(byte[] cptr) {
	this.cptr = cptr;
	this.prev = null;
	this.next = null;
    }
    
    /**
     * 新しいスクリプトコンテキストを作成します.
     * @return 
     */
    public static ScriptContext open() {
	synchronized(mutex) {
	    ScriptContext ret = nativeOpen();
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
    public static Optional<ScriptContext> current() {
	synchronized(mutex) {
	    if(contextStack.empty()) {
		return Optional.empty();
	    } else {
		return Optional.ofNullable(contextStack.peek());
	    }
	}
    }
    
    
    private static native ScriptContext nativeOpen();
    private static native void nativeClose();
}
