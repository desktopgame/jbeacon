package jp.koya.jbeacon;

/**
 * beacon言語の実行に関する例外のサブクラス.
 * @author koya
 */
public class BCException extends RuntimeException {  
    public BCException() {
    }

    public BCException(String message) {
	super(message);
    }
}
