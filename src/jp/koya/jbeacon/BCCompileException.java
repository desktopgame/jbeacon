package jp.koya.jbeacon;

/**
 * beaconをバイトコードに変換する段階で発生した例外を示します.
 * @author koya
 */
public class BCCompileException extends BCException {
    public BCCompileException() {
    }
    
    public BCCompileException(String message) {
	super(message);
    }
}
