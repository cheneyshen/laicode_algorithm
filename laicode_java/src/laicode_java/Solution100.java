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
		int m=(int)s1.length(); 
		int n=(int)s2.length();
		int[][] matrix=new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0) {
					matrix[i][j]=j;
				} else if(j==0) {
					matrix[i][j]=i;
				} else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					matrix[i][j]=matrix[i-1][j-1];
				} else {
					matrix[i][j]=Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1);
					matrix[i][j]=Math.min(matrix[i-1][j-1]+1, matrix[i][j]);
				}
			}
		}
		return matrix[m][n];
	}
	
	public static void main(String[] args) {


	}
}
