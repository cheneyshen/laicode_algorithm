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
		int result=0, slow=0, fast=0;
		while(fast<input.length) {
			if(input[fast]==1) {
				slow=fast;
				while(fast<input.length && input[fast]==1) {
					fast++;
				}
				result = Math.max(result, fast-slow);
			} else {
				fast++;
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
