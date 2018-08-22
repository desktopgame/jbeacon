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
	return file(filename, new SymbolTable());
    }
    
    /**
     * ファイルを入力として実行します.
     * @param filename
     * @param table
     * @return 
     */
    public static SymbolTable file(String filename, SymbolTable table) {
	if(!BCScriptContext.current().isPresent()) {
	    throw new IllegalStateException();
	}
	return nativeFile(filename, table);
    }
    
    /**
     * 文字列を入力として実行します.
     * @param sourceCode 
     * @return  
     */
    public static SymbolTable string(String sourceCode) {
	return string(sourceCode, new SymbolTable());
    }
    
    /**
     * 文字列を入力として実行します.
     * @param sourceCode
     * @param table
     * @return 
     */
    public static SymbolTable string(String sourceCode, SymbolTable table) {
	if(!BCScriptContext.current().isPresent()) {
	    throw new IllegalStateException();
	}
	return nativeString(sourceCode, table);
    }
    
    private static native SymbolTable nativeFile(String filename, SymbolTable table);
    private static native SymbolTable nativeString(String sourceCode, SymbolTable table);
}
