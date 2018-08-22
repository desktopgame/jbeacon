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
     * @return  
     */
    public static SymbolTable file(String filename) {
	if(!BCScriptContext.current().isPresent()) {
	    throw new IllegalStateException();
	}
	return nativeFile(filename);
    }
    
    /**
     * 文字列を入力として実行します.
     * @param sourceCode 
     * @return  
     */
    public static SymbolTable string(String sourceCode) {
	if(!BCScriptContext.current().isPresent()) {
	    throw new IllegalStateException();
	}
	return nativeString(sourceCode);
    }
    
    private static native SymbolTable nativeFile(String filename);
    private static native SymbolTable nativeString(String sourceCode);
}
