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
//S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
public class Solution177 {
	public int longest(String s, String t) {
	   /*
            a a a a a
	     a  1 1 1 1 1
	     b  1 1 1 1 1
	     b  1 1 1 1 1
	     a  1 2 2 2 2
	     b  1 2 2 2 2
	     a  1 2 3 3 3
	    */
		if(s==null || t==null || s.length()==0 || t.length()==0) {
			return 0;
		}
		//我们需要初始化长度+1的二维数组，当i==0&&j==0的时候默认为0
		//因为我们的induction rule依赖于matrix[i-1][j-1]
		int[][] matrix = new int[s.length()+1][t.length()+1];
		for(int i=0; i<=s.length(); i++) {
			for(int j=0; j<=t.length(); j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
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
