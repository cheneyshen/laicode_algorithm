package laicode;

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
	List<String> validParen(int k) {
		List<String> result=new ArrayList<String>();
		char[] cur=new char[k*2];
		helper(cur, k, k, 0, result);
		return result;
	}
	void helper(char[] cur, int left, int right, int index, List<String> result) {
		if(left==0 && right==0) {
			result.add(new String(cur));
			return;
		}
		if(left>0) {
			cur[index]='(';
			helper(cur, left-1, right, index+1, result);
		}
		if(right>left) {
			cur[index]=')';
			helper(cur, left, right-1, index+1, result);
		}
	}
	
	public static void main(String[] args) {


	}
}
