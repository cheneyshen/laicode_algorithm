package laicode_java;

import java.util.*;

//Increasing Triplet Subsequence
//Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
//
//Formally the function should:
//
//Return true if there exists i, j, k 
//such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
//Your algorithm should run in O(n) time complexity and O(1) space complexity.
//
//Examples:
//Given [1, 2, 3, 4, 5],
//return true.
//
//Given [5, 4, 3, 2, 1],
//return false.
public class Solution468 {
	// This problem can be converted to be finding if there is a sequence such that 
	// the_smallest_so_far < the_second_smallest_so_far < current. We use x, y and z to denote the 3 number respectively.
	public boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
	 
		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
	 
			if (x >= z) {
				x = z;// update x to be a smaller value
			} else if (y >= z) {
				y = z; // update y to be a smaller value
			} else {
				return true;
			}
		}
	 
		return false;
	}
	
	public static void main(String[] args) {


	}
}
