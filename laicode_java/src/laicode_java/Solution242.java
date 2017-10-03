package laicode_java;

import java.util.*;

//Valid Parentheses
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order.
//  
//  Examples
//  
//  "()" and "()[]{}", "[{()}()]" are all valid but "(]" and "([)]" are not.
public class Solution242 {
	public boolean validParentheses(String array) {
		if(array==null || array.length()<2) {
			return false;
		}
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<array.length(); i++) {
			if(array.charAt(i)=='(') {
				stk.push('(');
			}
			else if(array.charAt(i)=='[') {
				stk.push('[');
			}
			else if(array.charAt(i)=='{') {
				stk.push('{');
			}
			else if(array.charAt(i)==')') {
				if(stk.peek()=='(') {
					stk.pop();
				} else {
					return false;
				}
			}
			else if(array.charAt(i)==']') {
				if(stk.peek()=='[') {
					stk.pop();
				} else {
					return false;
				}
			}
			else if(array.charAt(i)=='}') {
				if(stk.peek()=='{') {
					stk.pop();
				} else {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		Solution242 ss = new Solution242();
		System.out.println(ss.validParentheses("()"));
		System.out.println(ss.validParentheses("()[]{}"));
		System.out.println(ss.validParentheses("[{()}()]"));
		System.out.println(ss.validParentheses("(]"));
		System.out.println(ss.validParentheses("([)]"));

	}
}
