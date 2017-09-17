package laicode_java;

import java.util.*;
/*  Longest Consecutive 1s
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{ 0, 1, 0, 1, 1, 1, 0 }, the longest consecutive 1s is 3.
  0  1  0  1  2  3  0
*/
public class Solution103 {
	public int longest(int[] input) {
		if(input==null || input.length==0) {
			return 0;
		}
		int[] longest = new int[input.length];
		Arrays.fill(longest, 0);
		int result=0;
		for(int i=0; i<input.length; i++) {
			if(i==0) {
				longest[i]=input[i];
			}
			else if(input[i]==1) {
				longest[i]=longest[i-1]+1;
				result=Math.max(result, longest[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution103 ss = new Solution103();
		int[] input={ 0, 1, 0, 1, 1, 1, 0 };
		System.out.println(ss.longest(input));
	}
}
