package laicode_java;

import java.util.*;

//Longest Valid Parentheses
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//Example
//
//")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class Solution237 {
	public String longestValid(String str) {
		if(str==null || str.length()<2) {
			return str;
		}
		Stack<Integer> stk=new Stack<>();
		int result=0;
		String output="";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==')' && stk.isEmpty()==false && str.charAt(stk.peek())=='(') {
				stk.pop();
				if(stk.isEmpty()) {
					result=i+1;
					output=str.substring(0, i+1);
				}
				else if(result<i-stk.peek()) {
					result=i-stk.peek();
					output=str.substring(stk.peek()+1, i+1);
				}
			}
			else {
				stk.push(i);
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Solution237 ss = new Solution237();
		System.out.println(ss.longestValid("((()"));
		System.out.println(ss.longestValid(")()())"));
		System.out.println(ss.longestValid("()(()))))"));
	}
}
