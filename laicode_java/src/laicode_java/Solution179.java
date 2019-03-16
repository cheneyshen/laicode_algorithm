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
	public List<String> validParentheses(int l, int m, int n) {
		
		List<String> res = new ArrayList<>();
		Stack<Character> stk = new Stack<>();
		helper(l, l, m, m, n, n, "", res, stk);
		return res;
	}
	
	private void helper(int left1, int right1, int left2, int right2, int left3, int right3, String cur, List<String> res, Stack<Character> stk) {
		if(left1==0 && right1==0 && left2==0 && right2==0 && left3==0 && right3==0) {
			res.add(cur);
			return;
		}
		if(left1>0) {
			stk.push('(');
			helper(left1-1, right1, left2, right2, left3, right3, cur+'(', res, stk);
			stk.pop();
		}
		if(left2>0) {
			stk.push('<');
			helper(left1, right1, left2, right2, left3, right3, cur+'<', res, stk);
			stk.pop();
		}
		if(left3>0) {
			stk.push('{');
			helper(left1, right1, left2, right2, left3-1, right3, cur+'{', res, stk);
			stk.pop();
		}
		if(right1>left1) {
			if(!stk.isEmpty() && stk.peek()=='(') {
				stk.pop();
				helper(left1, right1-1, left2, right2, left3, right3, cur+')', res, stk);
				stk.push('(');
			}
		}
		if(right2>left2) {
			if(!stk.isEmpty() && stk.peek()=='<') {
				stk.pop();
				helper(left1, right1, left2, right2-1, left3, right3, cur+'>', res, stk);
				stk.push('<');
			}
		}
		if(right3>left3) {
			if(!stk.isEmpty() && stk.peek()=='{') {
				stk.pop();
				helper(left1, right1, left2, right2, left3, right3-1, cur+'}', res, stk);
				stk.push('{');
			}
		}
	}
	
	public static void main(String[] args) {
		Solution179 ss = new Solution179();
		List<String> result = ss.validParentheses(1, 1, 0);
		System.out.println(result);
	}
}
