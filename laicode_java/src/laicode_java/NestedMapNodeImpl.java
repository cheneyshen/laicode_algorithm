package laicode_java;

import java.util.Map;

public class NestedMapNodeImpl implements NestedMapNode {
	private boolean isInteger;
	private Integer intValue;
	private Map<String, NestedMapNode> mapper;
	
	@Override
	public boolean isInteger() {
		return this.isInteger;
	}

	@Override
	public Integer getInteger() {
		if(this.isInteger)
			return this.intValue;
		return null;
	}

	@Override
	public Map<String, NestedMapNode> getMap() {
		if(this.isInteger) {
			return null;
		}
		return mapper;
	}
	
	public boolean setInteger(int v) {
		this.intValue = v;
		this.isInteger = true;
		return true;
	}

	public boolean setMap(Map<String, NestedMapNode> map) {
		this.mapper = map;
		this.isInteger = false;
		return true;
	}
	
	public boolean addMapNode(String key, int value) {
		if(this.isInteger) {
			return false;
		}
		NestedMapNodeImpl nmn = new NestedMapNodeImpl();
		nmn.setInteger(value);
		this.mapper.put(key, nmn);
		return true;
	}
}
