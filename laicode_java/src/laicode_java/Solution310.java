package laicode_java;

import java.util.*;

//Max Subarray Sum Difference
//Given an array of integers. Find two disjoint contiguous subarrays in it such that the absolute value of the difference between the sums of two subarray is maximum.  Return the maximum difference.
//
//Assumptions:
//The given array is not null and has length of at least 2.
//Examples:
//Input: { 1, -3, 1, -4, 3, 4 }
//Two subarrays: {-3, 1, -4 }, { 3, 4 }
//Maximum difference = 13
public class Solution310 {
	int maxDiffSubArrays(int[] nums) {
		int size = nums.length;
		int[] left_max = new int[size];
		int[] left_min = new int[size];
		int[] right_max = new int[size];
		int[] right_min = new int[size];
		int[] copy = new int[size];
		//get negative copy
		for(int i=0; i<size; i++) {
			copy[i] = -1*nums[i];
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minsum = 0;
		//forward get max subarray
		for(int i=0; i<size; i++) {
			sum +=nums[i];
			max = Math.max(max, sum-minsum);
			minsum = Math.max(sum, minsum);
			left_max[i] = max;
		}
		//backward: get max subarray
		max = Integer.MIN_VALUE;
		sum = 0;
		minsum = 0;
		for(int i=size-1; i>=0; i--) {
			sum += nums[i];
			max = Math.max(max, sum-minsum);
			minsum = Math.max(sum, minsum);
			right_max[i] = max;
		}
		//forward: get min subarray
		max = Integer.MIN_VALUE;
		sum = 0;
		minsum = 0;
		for(int i=0; i<size; i++) {
			sum += copy[i];
			max = Math.max(max, sum-minsum);
			minsum = Math.min(sum, minsum);
			left_min[i] = -1*max;
		}
		//backward: get min subarray
		max = Integer.MIN_VALUE;
		sum = 0;
		minsum = 0;
		for(int i=size-1; i>=0; i--) {
			sum += copy[i];
			max = Math.max(max, sum-minsum);
			minsum = Math.min(sum, minsum);
			right_min[i] = -1*max;
		}
		int diff = 0;
		for(int i=0; i<size-1; i++) {
			diff = Math.max(diff, Math.abs(left_max[i]-right_min[i+1]));
			diff = Math.max(diff, Math.abs(left_min[i]-right_max[i+1]));
		}
		return diff;
	}
	
	public static void main(String[] args) {


	}
}
