package laicode_java;

import java.util.*;
//Scramble String
//	Given a string s1, we may represent it as a binary tree by partitioning it to two non - empty substrings recursively.

//	Below is one possible representation of s1 = "great":

//great

//	/ \

//	gr    eat

//	/ \ / \

//	g   r  e   at

//	/ \

//	a   t

//	To scramble the string, we may choose any non - leaf node and swap its two children.For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

//	rgeat

//	/ \

//	rg    eat

//	/ \ / \

//	r   g   e   at

//	/ \

//	a   t

//	We say that "rgeat" is a scrambled string of "great".Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

//	rgtae

//	/ \

//	rg    tae

//	/ \ / \

//	r   g  ta  e

//	/ \

//	t   a

//	We say that "rgtae" is a scrambled string of "great".Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

public class Solution150 {
	public boolean isScramble(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int leng=s1.length();
		int[][][] memo=new int[leng][leng][leng];
		for(int i=0; i<leng; i++) {
			for(int j=0; j<leng; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return helper(s1, 0, s2, 0, leng, memo);
	}
	
	private boolean helper(String s1, int i, String s2, int j, int leng, int[][][] memo) {
		if(leng==1) {
			return s1.charAt(i)==s2.charAt(j);
		}
		int result=memo[i][j][leng-1];
		if(result!=-1) {
			return result==1?true:false;
		}
		result = 0;
		for(int m=1; m<leng; m++) {
			if(helper(s1, i, s2, j, m, memo) && helper(s1, i+m, s2, j+m, leng-m, memo)) {
				result = 1;
				break;
			}
			if(helper(s1, i, s2, j+leng-m, m, memo) && helper(s1, i+m, s2, j, leng-m, memo)) {
				result = 1;
				break;
			}
		}
		memo[i][j][leng-1] = result;
		return result==1 ? true : false;
	}
	
	public static void main(String[] args) {
		String s1 = "gre0at";
		String s2 = "0egrta";
		Solution150 ss = new Solution150();
		boolean result = ss.isScramble(s1, s2);
		System.out.println(result);
	}
}
