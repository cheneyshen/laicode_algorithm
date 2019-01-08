package laicode_java;
import java.util.*;

public class NestedIntegerImpl implements NestedInteger {
	boolean isInteger;
	Integer value;
	List<NestedInteger> list;

	public void setInteger(Integer value) {
		this.value = value;
		this.isInteger = true;
	}

	public void setList(List<NestedInteger> list) {
		this.list = list;
		this.isInteger = false;
	}
	
	public boolean addInteger(NestedInteger ni) {
		if(this.isInteger) {
			return false;
		}
		if(this.list==null) {
			this.list = new ArrayList<>();
		}
		this.list.add(ni);
		return true;
	}
	
	@Override
	public boolean isInteger() {
		return this.isInteger;
	}

	@Override
	public Integer getInteger() {
		return this.value;
	}

	@Override
	public List<NestedInteger> getList() {
		return this.list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
