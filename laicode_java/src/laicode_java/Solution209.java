package laicode_java;

import java.util.*;

//Interleave Strings
//Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.
//
//Assumptions
//
//none of A, B, C is null
//Examples
//
//C = "abcde", A = "acd", B = "be", return true
//C = "abcde", A = "adc", B = "be", return false
public class Solution209 {
	public boolean canMerge(String a, String b, String c) {
		int x=a.length();
		int y=b.length();
		int z=c.length();
		if(x+y!=z) {
			return false;
		}
		boolean[][] common = new boolean[x+1][y+1];
		common[0][0]=true;
//		1<=i<=x
//		1<=j<=y
//		c[i+j-1] == a[i-1] && common[i-1][j] || c[i+j-1] == b[j-1] && common[i][j-1]
//		1 0 0
//		1 1 0
//		0 1 0
//		0 1 1
		for(int i=1; i<=x; i++) {
			if(c.charAt(i-1) == a.charAt(i-1)) {
				common[i][0]=true;
			}
		}
		for(int j=1; j<=y; j++) {
			if(c.charAt(j-1) == b.charAt(j-1)) {
				common[0][j]=true;
			}
		}
		for(int i=1; i<=x; i++) {
			for(int j=1; j<=y; j++) {
				if ((c.charAt(i+j-1)==a.charAt(i-1) && common[i-1][j]) || (c.charAt(i+j-1)==b.charAt(j-1) && common[i][j-1])) {
					common[i][j]=true;
				}
			}
		}
		return common[x][y];
	}
	
	public static void main(String[] args) {
		Solution209 ss = new Solution209();
		String a = "acd";
		String b = "bce";
		String c = "abccde";
		System.out.println(ss.canMerge(a, b, c));
	}
}
