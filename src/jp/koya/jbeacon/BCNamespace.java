package jp.koya.jbeacon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * beacon の名前空間を表す.
 * @author koya
 */
public class BCNamespace {
    private String name;
    private byte[] cptr;
    private Optional<BCNamespace> parentOpt;
    private Map<String, BCNamespace> namespaceMap;
    
    private BCNamespace(String name, byte[] cptr) {
	this.name = name;
	this.cptr = cptr;
	this.parentOpt = Optional.empty();
	this.namespaceMap = new HashMap<>();
    }
    
    /**
     * この名前空間の子要素を返します.
     * @param name
     * @return 
     */
    public BCNamespace getNamespace(String name) {
	Objects.requireNonNull(name);
	if(namespaceMap.containsKey(name)) {
	    return namespaceMap.get(name);
	}
	BCNamespace ret = nativeGetNamespace(name);
	namespaceMap.put(name, ret);
	ret.parentOpt = Optional.of(this);
	return ret;
    }
    
    /**
     * この名前空間を含む名前空間を返します.
     * @return 
     */
    public Optional<BCNamespace> getParent() {
	return parentOpt;
    }
    
    public void dump() {
	dumpImpl(this, 0);
    }
    
    private void dumpImpl(BCNamespace root, int depth) {
	for(int i=0; i<depth; i++) {
	    System.out.print("    ");
	}
	System.out.println(root.name);
	root.namespaceMap.forEach((k, v) -> dumpImpl(v, depth + 1));
    }
    
    /**
     * トップレベルの名前空間を返します.
     * @param name
     * @return 
     */
    public static BCNamespace getRootNamespace(String name) {
	Optional<BCScriptContext> sctxOpt = BCScriptContext.current();
	if(sctxOpt.isPresent()) {
	    return sctxOpt.get().getRootNamespace(name);
	} else {
	    throw new IllegalStateException();
	}
    }
    
    private native BCNamespace nativeGetNamespace(String name);
}
