package laicode_java;

import java.util.*;

//    Minimum Cuts For Palindromes
//    Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.
//
//        Assumptions
//
//        The given string is not null
//        Examples
//
//        “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”
//
//        The minimum number of cuts needed is 3.
public class Solution143 {
	public int minCuts(String input) {
		if(input==null || input.length()<2) {
			return 0;
		}
		int leng = input.length();
		boolean[][] huiwen = new boolean[leng][leng];
		//为什么用leng+1呢？因为需要用到mincuts[0]==0的性质
		int[] mincuts = new int[leng+1];
		for(int i=0; i<=leng; i++) {
			mincuts[i] = i-1;
		}
		/*
		 * j是右,i是左
		 * for(int j=1; j<leng; j++) {
		 * 	for(int i=j; i>=0; i--) {
		 * 		一个往左，一个往右，判断字符是否相等
		 *  }
		 * }
		 */
		
		for(int j=1; j<leng; j++) {
			for(int i=j; i>=0; i--) {
				if(input.charAt(i) == input.charAt(j) && (j-i<2 || huiwen[i+1][j-1]==true)) {
					huiwen[i][j] = true;
					
					mincuts[j+1] = Math.min(mincuts[j+1], mincuts[i]+1);
				}
			}
		}
		return mincuts[leng];
	}
	
	public static void main(String[] args) {
		Solution143 ss = new Solution143();
		System.out.println(ss.minCuts("ababbbabbababa"));
	}
}
