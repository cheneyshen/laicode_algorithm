package laicode_java;

import java.util.*;
//All Valid Permutations Of Parentheses II
//Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
//
//Assumptions
//
//l, m, n >= 0
//Examples
//
//l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]

public class Solution179 {
	public List<String> solve(int l, int m, int n) {
		int leng=2*(l+m+n);
		List<Integer> counts = new ArrayList<Integer>();
		counts.add(l);
		counts.add(l);
		counts.add(m);
		counts.add(m);
		counts.add(n);
		counts.add(n);
		String combo="";
		Stack<Character> stk = new Stack<Character>();
		List<String> result = new ArrayList<String>();
		helper(leng, counts, combo, stk, result);
		return result;
	}
	
	private void helper(int leng, List<Integer> remains, String prefix, Stack<Character> stk, List<String> result) {
		for(int i=0; i<remains.size(); i++) {
			if(remains.get(i)<0) {
				return;
			}
		}
		if(prefix.length()==leng) {
			result.add(prefix);
		}
		if(remains.get(0)>0) {
			prefix+='(';
			stk.push('(');
			remains.set(0, remains.get(0)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(0, remains.get(0)+1);
			stk.pop();
			prefix = prefix.substring(0, prefix.length()-1);
		}
		if(remains.get(2)>0) {
			prefix+='[';
			stk.push('[');
			remains.set(2, remains.get(2)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(2, remains.get(2)+1);
			stk.pop();
			prefix = prefix.substring(0, prefix.length()-1);
		}
		if(remains.get(4)>0) {
			prefix+='{';
			stk.push('{');
			remains.set(4, remains.get(4)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(4, remains.get(4)+1);
			stk.pop();
			prefix = prefix.substring(0, prefix.length()-1);
		}
		if(remains.get(1)>remains.get(0) && stk.peek()=='(') {
			prefix+=')';
			stk.pop();
			remains.set(1, remains.get(1)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(1, remains.get(1)+1);
			stk.push('(');
			prefix = prefix.substring(0, prefix.length()-1);
		}
		if(remains.get(3)>remains.get(2) && stk.peek()=='[') {
			prefix+=']';
			stk.pop();
			remains.set(3, remains.get(3)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(3, remains.get(3)+1);
			stk.push('[');
			prefix = prefix.substring(0, prefix.length()-1);
		}
		if(remains.get(5)>remains.get(4) && stk.peek()=='{') {
			prefix+='}';
			stk.pop();
			remains.set(5, remains.get(5)-1);
			helper(leng, remains, prefix, stk, result);
			remains.set(5, remains.get(5)+1);
			stk.push('{');
			prefix= prefix.substring(0, prefix.length()-1);
		}
	}
	
	public static void main(String[] args) {
		Solution179 ss = new Solution179();
		List<String> result = ss.solve(1, 1, 0);
		System.out.println(result);
	}
}
