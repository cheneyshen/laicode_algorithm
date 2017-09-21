package laicode_java;

import java.util.*;
//Longest Common Subsequence
//Find the length of longest common subsequence of two given strings.
//
//Assumptions
//
//The two given strings are not null
//Examples
//
//S = ¡°abcde¡±, T = ¡°cbabdfe¡±, the longest common subsequence of s and t is {¡®a¡¯, ¡®b¡¯, ¡®d¡¯, ¡®e¡¯}, the length is 4.
public class Solution177 {
	public int longest(String s, String t) {
		if(s==null || t==null || s.length()==0 || t.length()==0) {
			return 0;
		}
		int[][] matrix = new int[s.length()+1][t.length()+1];
		for(int i=0; i<=s.length(); i++) {
			for(int j=0; j<=t.length(); j++) {
				if(i==0 || j==0) {
					matrix[i][j]=0;
				} else if(s.charAt(i-1) == t.charAt(j-1)) {
					matrix[i][j]=matrix[i-1][j-1]+1;
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		return matrix[s.length()][t.length()];
	}
	
	public static void main(String[] args) {
		Solution177 ss = new Solution177();
		System.out.println(ss.longest("abcde", "cbabdfe"));
	}
}
