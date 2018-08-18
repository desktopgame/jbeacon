package jp.koya.jbeacon;

/**
 * beaconを実行するためのユーティリティ関数群.
 * @author koya
 */
public class BCEval {
    private BCEval() {
    }
    
    /**
     * ファイルを入力として実行します.
     * @param filename 
     */
    public static void file(String filename) {
	nativeFile(filename);
    }
    
    /**
     * 文字列を入力として実行します.
     * @param sourceCode 
     */
    public static void string(String sourceCode) {
	nativeString(sourceCode);
    }
    
    private static native void nativeFile(String filename);
    private static native void nativeString(String sourceCode);
}
