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
//S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
public class Solution176 {
	public String longestCommon(String source, String target) {
		/*
		 *   a b c d e
		 * c 0 0 1 1 1
		 * d 0 0 0 2 2
		 * f 0 0 0 0 2
		 */
		if(source==null || target==null) {
			return null;
		}
		if(source.length()<1 || source.length()<1) {
			return "";
		}
		
		int slen = source.length(), tlen = target.length();
		int max = 0; //最后的长度最大值
		int start = 0;	//最长的目标字符串起始处
		int[][] dp = new int[slen][tlen];	//二维DP
		for(int i=0; i<slen; i++) {
			for(int j=0; j<tlen; j++) {
				//只有当两个字符相等时才进行操作
				if(source.charAt(i) == target.charAt(j)) {
					if(i==0) {
						dp[i][j] = 1;
					} else if(j==0) {
						dp[i][j] = 1;
					} else {
						//当前=前面的值+1
						dp[i][j] = 1 + dp[i-1][j-1];
					}
					//刷新max,start位置
					if(dp[i][j] > max) {
						max = dp[i][j];
						start = i - max + 1;
					}
				}
			}
		}
		return source.substring(start, start+max);
	}
	
	public static void main(String[] args) {
		Solution176 ss = new Solution176();
		System.out.println(ss.longestCommon("", "cdf"));
		System.out.println(ss.longestCommon("abcde", "cdf"));;
	}
}
