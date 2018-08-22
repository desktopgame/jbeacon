package jp.koya.jbeacon;

import java.util.HashMap;
import java.util.Map;

/**
 * 変数と格納されている値を紐付けるテーブル.
 * @author koya
 */
public class SymbolTable {
    private Map<String, Object> map;
    
    public SymbolTable() {
	this.map = new HashMap<>();
    }
    
    /**
     * 指定のキーと値を紐付けます.
     * @param name
     * @param value 
     */
    public void put(String name, Object value) {
	map.put(name, value);
    }
    /**
     * 指定のキーと値を紐付けます.
     * @param name
     * @param value 
     */
    public void putInteger(String name, int value) {
	put(name, value);
    }
    /**
     * 指定のキーと値を紐付けます.
     * @param name
     * @param value 
     */
    public void putChar(String name, char value) {
	put(name, value);
    }
    /**
     * 指定のキーと値を紐付けます.
     * @param name
     * @param value 
     */
    public void putDouble(String name, double value) {
	put(name, value);
    }
    /**
     * 指定のキーと値を紐付けます.
     * @param name
     * @param value 
     */
    public void putString(String name, String value) {
	put(name, value);
    }


    /**
     * 指定のキーに対応する値を返します.
     * @param name
     * @return 
     */
    public Object get(String name) {
	return map.get(name);
    }
    /**
     * 指定のキーに対応する値を整数型で返します.
     * @param name
     * @return 
     */
    public int getInteger(String name) {
	return (int)get(name);
    }
    /**
     * 指定のキーに対応する値を文字型で返します.
     * @param name
     * @return 
     */
    public char getChar(String name) {
	return (char)get(name);
    }
    /**
     * 指定のキーに対応する値を整数型で返します.
     * @param name
     * @return 
     */
    public double getDouble(String name) {
	return (double)get(name);
    }
    /**
     * 指定のキーに対応する値を文字列型で返します.
     * @param name
     * @return 
     */
    public String getString(String name) {
	return (String)get(name);
    }
}
