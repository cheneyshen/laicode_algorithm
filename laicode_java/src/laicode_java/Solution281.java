package laicode_java;

import java.util.*;

//Remove Spaces
//Given a string, remove all leading/trailing/duplicated empty spaces.
//Assumptions:
//The given string is not null.
//Examples:
//“  a” --> “a”
//“   I     love MTV ” --> “I love MTV"
public class Solution281 {
	public String removeSpace(String input) {
		String result="";
		int fast=0;
		for(; fast<input.length(); ) {
			while(input.charAt(fast)==' ') {
				fast++;
			}
			while(fast<input.length() && input.charAt(fast)!=' ') {
				result+=input.charAt(fast++);
			}
			while(fast<input.length() && input.charAt(fast)==' ') {
				fast++;
			}
			result+=' ';
		}
		return result;
	}
	
	public class ZigzagIterator {
		LinkedList<Iterator> list;
		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			list = new LinkedList<Iterator>();
			if(!v1.isEmpty())	list.add(v1.iterator());
			if(!v2.isEmpty())	list.add(v2.iterator());
		}
		
		public int next() {
			Iterator curr = list.remove();
			int result = (Integer)curr.next();
			if(curr.hasNext()) {
				list.add(curr);
			}
			return result;
		}
		
		public boolean hasNext() {
			return !list.isEmpty();
		}
	}
	
	List<String> addOperator(String num, int target) {
		List<String> result = new ArrayList<>();
		helper(result, num, target, "", 0, 0);
		return result;
	}
	
	void helper(List<String> result, String num, int target, String tmp, int curr, int prev) {
		if(curr==target && num.length()==0) {
			result.add(tmp);
			return;
		}
		for(int i=1; i<=num.length(); i++) {
			String cur = num.substring(0, i);
			if(cur.length()>1 && cur.charAt(0)=='0') {
				return;
			}
			int currNum = Integer.valueOf(cur);
			String next = num.substring(i);
			if(tmp.length()!=0) {
				helper(result, next, target, tmp + "*" +cur, curr-prev+prev*currNum, prev*currNum);
				helper(result, next, target, tmp + "+" +cur, curr+currNum, currNum);
				helper(result, next, target, tmp + "-" +cur, curr-currNum, -currNum);
				
			} else {
				helper(result, next, target, cur, currNum, currNum);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution281 ss = new Solution281();
		System.out.println(ss.removeSpace("   I     love MTV "));
	}
}
