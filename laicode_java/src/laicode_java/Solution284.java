package laicode_java;

import java.util.*;

//Nested Value
//	Given a string, calcualte the nested integer weighted sum.
//	Weight is + 1 for each deeper level of "{}".
//	Assumptions:
//The given string is not null
//	The only characters in the string is either '0' - '9' or '{', '}'
//	Each digit character is calculated separately.
//	Examples :
//	input = “{ 2{4{6}} }”.output = 2×1 + 4×2 + 6×3 = 28.
//	input = "{34{5}6}".output = 3 + 4 + 5x2 + 6 = 23.
public class Solution284 {
	public int nestedValue(String str) {
		if(str==null || str.length()<1) {
			return 0;
		}
		Stack<Character> stk = new Stack<>();
		int result=0;
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i)=='{') {
				stk.push(str.charAt(i));
			} else if (str.charAt(i)>='0' && str.charAt(i)<='9') {
				result += (str.charAt(i)-'0')*stk.size();
			} else if (str.charAt(i)=='}') {
				stk.pop();
			}
		}
		return result;
	}
	
	class PeekingIterator implements Iterator<Integer> {
		List<Integer> list;
		public PeekingIterator(Iterator<Integer> iterator) {
			list = new LinkedList();
			while(iterator.hasNext()) {
				list.add(iterator.next());
			}
		}
		
		public Integer peek() {
			return list.get(0);
		}
		
		@Override
		public Integer next() {
			return list.remove(0);
		}
		
		@Override
		public boolean hasNext() {
			return !(list.size()==0);
		}
	}
	public static void main(String[] args) {
		Solution284 ss = new Solution284();
		String str = "{ 2{4{6}} }";
		System.out.println(ss.nestedValue(str));
		str = "{34{5}6}";
		System.out.println(ss.nestedValue(str));

	}
}
