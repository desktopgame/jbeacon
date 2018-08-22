package jp.koya.jbeacon;

/**
 * まだ実装されていない挙動を示す例外.
 * @author koya
 */
public class BCNotSupportedException extends BCException {
    public BCNotSupportedException() {
    }
    
    public BCNotSupportedException(String message) {
	super(message);
    }
}
