package laicode_java;

import java.util.*;
//Longest Common Substring
//Find the longest common substring of two given strings.
//
//Assumptions
//
//The two given strings are not null
//Examples
//
//S = ¡°abcde¡±, T = ¡°cdf¡±, the longest common substring of S and T is ¡°cd¡±

public class Solution176 {
	public String longestCommon(String s, String t) {
		if(s==null || t==null || s.length()==0 || t.length()==0) {
			return "";
		}
		return helper(s, s.length(), t, t.length());
	}
	
	private String helper(String s, int m, String t, int n) {
		int[][] matrix = new int[m+1][n+1];
		int result=0;
		String output="";
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) {
					matrix[i][j]=0;
				}
				else if(s.charAt(i-1) == t.charAt(j-1)) {
					matrix[i][j]=matrix[i-1][j-1]+1;
					if(matrix[i][j]>result) {
						output = s.substring(i-matrix[i][j], i);
						result = matrix[i][j];
					}
				}
				else {
					matrix[i][j]=0;
				}
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Solution176 ss = new Solution176();
		System.out.println(ss.longestCommon("", "cdf"));
		System.out.println(ss.longestCommon("abcde", "cdf"));;
	}
}
