package laicode_java;
import java.util.*;

//Design an iterator of a nested Map:
//{a:1, b:2, c: {d: 3, e: 4}}
//→ [a:1, b: 2, cd: 3, ce: 4]

public class Solution3411 implements Iterator<Entry> {
	private Deque<Entry> array;
	
	public Solution3411(Map<String, NestedMapNode> dict) {
		this.array = new LinkedList<>();
		StringBuilder sb = new StringBuilder("aa");
		sb.reverse().length();
		helper(dict, "");
	}
	//Time O(n) Space O(n)
	public void helper(Map<String, NestedMapNode> dict, String parent) {
		if(dict==null || dict.size()==0) {
			return;
		}
		for(String str:dict.keySet()) {
			if(dict.get(str).isInteger()) {
				Entry cur = new Entry(parent+str, dict.get(str).getInteger());
				array.offerLast(cur);
			} else {
				helper(dict.get(str).getMap(), parent+str);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, NestedMapNode> dict = new HashMap<>();
		NestedMapNodeImpl nma = new NestedMapNodeImpl();
		nma.setInteger(1);
		//dict.put("a", nma);
		NestedMapNodeImpl nmb = new NestedMapNodeImpl();
		nmb.setInteger(2);
		//dict.put("b", nmb);
		Map<String, NestedMapNode> dict1 = new HashMap<>();
		NestedMapNodeImpl nmd = new NestedMapNodeImpl();
		nmd.setInteger(3);
		dict1.put("d", nmd);
		NestedMapNodeImpl nme = new NestedMapNodeImpl();
		nme.setInteger(4);
		dict1.put("e", nme);
		NestedMapNodeImpl nmc = new NestedMapNodeImpl();
		nmc.setMap(dict1);
		//dict.put("c", nmc);
		Solution3411 s = new Solution3411(dict);
		while(s.hasNext()) {
			Entry cur = s.next();
			System.out.println(cur.key + " " + cur.value);
		}
	}

	@Override
	public boolean hasNext() {
		return this.array.size()>0;
	}

	@Override
	public Entry next() {
		if(this.array.isEmpty()) {
			return null;
		}
		return this.array.pollFirst();
	}
}
