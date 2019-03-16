package laicode_java;

import java.util.*;

//    Longest Ascending SubArray
//    Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
//
//    Assumptions
//
//    The given array is not null
//    Examples
//
//    {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
//
//    {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
public class Solution086 {
	public int longest(int[] input) {
		if(input == null || input.length==0) {
			return 0;
		}
		int res = 1;
		int[] set = new int[input.length];
		set[0] = 1;
		for(int i=1; i<input.length; i++) {
			if(input[i] > input[i-1]) {
				set[i] = set[i-1]+1;
			} else {
				set[i] = 1;
			}
			res = Math.max(res, set[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {


	}
}
