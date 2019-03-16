package laicode_java;

import java.util.*;
/*	Edit Distance
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions

Both strings are not null
Examples

string one : “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).*/
public class Solution100 {
	public int editDistance(String s1, String s2) {
	    /*
	        s i g h
	      a 1 2 3 4
	      s 1 2 3 4
	      i 2 1 3 4
	      t 3 2 2 3
	      h 4 3 3 2
	    */
		if((s1==null || s1.length()<1) && (s2==null || s2.length()<1)) {
			return 0;
		}
		if(s1==null || s1.length()<1) {
			return s2.length();
		}
		if(s2==null || s2.length()<1) {
			return s1.length();
		}
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int cur = (s1.charAt(i) == s2.charAt(j) ? 0 : 1);
				if(i==0 && j==0) {
					dp[i][j] = cur;
				} else if(i==0) {
					dp[i][j] = cur + dp[i][j-1];
				} else if(j==0) {
					dp[i][j] = cur + dp[i-1][j];
				} else {
					if(cur==1) {
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])+1);						
					} else {
						dp[i][j] = dp[i-1][j-1];
					}
				}
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		Solution100 solution = new Solution100();
		System.out.println(solution.editDistance("jk", "kj"));

	}
}
