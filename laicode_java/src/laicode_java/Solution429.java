package laicode_java;

import java.util.*;
//Minimum Size Subarray Sum
//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
public class Solution429 {
	public int minSubArrayLen(int s, int[] nums) {
		int i=0, j=0, sum=0, min=Integer.MAX_VALUE;
		while (j<nums.length) {
			while(sum<s && j<nums.length) {
				sum +=nums[j++];
			}
			if(sum>=s) {
				while(sum>=s && i<j) {
					sum-=nums[i++];
				}
				min = Math.min(min, j-i+1);
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	public static void main(String[] args) {


	}
}
