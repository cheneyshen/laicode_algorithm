package laicode_java;

import java.util.Map;

/*
 * 
 */
public interface NestedMapNode {
	boolean isInteger();
	Integer getInteger();
	Map<String, NestedMapNode> getMap();
}
