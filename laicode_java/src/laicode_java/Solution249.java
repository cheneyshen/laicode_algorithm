package laicode_java;

import java.util.*;

//Regular Expression Matching
//Implement regular expression matching with support for '.' and '*'. '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).
//
//Example
//isMatch("aa", "a") → false
//isMatch("aa", "aa") → true
//isMatch("aaa", "aa") → false
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true
/* T[s][p] = T[s-1][p-1]	if b[p] = '.' || a[s] == b[p]
 * 			 T[s][p-2]		if b[p] = '*' && a[s] != b[p-1]
 * 			 T[s-1][p]		if b[p] = '*' && (a[s] == b[p-1] 匹配一个及以上	||	b[p-1] == '.'	匹配0个及以上)	
 * 			 false
 */
public class Solution249 {
	public boolean isMatch(String s, String p) {
		boolean T[][] = new boolean[s.length()+1][p.length()+1];
		T[0][0]=true;
		for(int i=1; i<T[0].length; i++) {
			if(p.charAt(i-1)=='*') {
				T[0][i] = T[0][i-2];
			}
		}
		for(int i=1; i<T.length; i++) {
			for(int j=1; j<T[0].length; j++) {
				if(p.charAt(j-1) == '.' || p.charAt(j-1)==s.charAt(i-1)) {
					T[i][j]=T[i-1][j-1];
				} else if(p.charAt(j-1)=='*') {
					T[i][j]=T[i][j-2];
					if(p.charAt(j-2)=='.' || p.charAt(j-2)==s.charAt(i-1)) {
						T[i][j]|=T[i-1][j];
					}
				} else {
					return true;
				}
			}
		}
		
		return T[s.length()][p.length()];
	}
	public static void main(String[] args) {
		Solution249 ss = new Solution249();
		System.out.println(ss.isMatch("aa","a"));
		System.out.println(ss.isMatch("aa","aa"));
		System.out.println(ss.isMatch("aaa","aa"));
		System.out.println(ss.isMatch("aa", "a*"));
		System.out.println(ss.isMatch("aa", ".*"));
		System.out.println(ss.isMatch("ab", ".*"));
		System.out.println(ss.isMatch("aab", "c*a*b"));
	}
}
