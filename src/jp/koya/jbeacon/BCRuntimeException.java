package jp.koya.jbeacon;

/**
 * beacon内部で発生したエラー.
 * @author koya
 */
public class BCRuntimeException extends BCException {
    public BCRuntimeException() {
    }
    
    public BCRuntimeException(String message) {
	super(message);
    }
}
