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
		return getMinHelper(input);
	}
	
	private int getMinHelper(String input) {
		if(input==null || input.length()<=1) {
			return 0;
		}
		int leng = input.length();
		boolean[][] huiwen = new boolean[leng+1][leng+1];
		int[] mincuts = new int[leng+1];
		for(int end=1; end<leng+1; end++) {
			mincuts[end]=end;
			for(int start=end; start>=1; start--) {
				if(input.charAt(start-1) == input.charAt(end-1)) {
					huiwen[start][end] = end-start<2 || huiwen[start+1][end-1];
				}
				if(huiwen[start][end]==true) {
					mincuts[end] = Math.min(mincuts[end], mincuts[start-1]+1);
				}
			}
		}
		return mincuts[leng]-1;
	}
	
	public static void main(String[] args) {
		Solution143 ss = new Solution143();
		System.out.println(ss.minCuts("ababbbabbababa"));
	}
}
