package laicode_java;

import java.util.*;

//All Valid Permutations Of Parentheses I
//Given N pairs of parentheses “()”, return a list with all the valid permutations.
//
//Assumptions
//
//N >= 0
//Examples
//
//N = 1, all valid permutations are ["()"]
//N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
//N = 0, all valid permutations are [""]
public class Solution066 {
	public List<String> validParentheses(int k) {
		List<String> result=new ArrayList<>();
		if(k<0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(sb, k, k, result);
		return result;
	}
	private void helper(StringBuilder sb, int left, int right, List<String> result) {
		if(left==0 && right==0) {
			result.add(sb.toString());
			return;
		}
		if(left>0) {
			sb.append("(");
			helper(sb, left-1, right, result);
			sb.setLength(sb.length()-1);
		}
		if(right>left) {
			sb.append(")");
			helper(sb, left, right-1, result);
			sb.setLength(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {


	}
}
