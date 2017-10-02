package laicode_java;

import java.util.*;

//First Missing Positive II
//Given an unsorted integer array, find the first missing positive integer.
//
//Example
//Given [0, 2, 3, 1], return 4,
//and [3, 4, -2, 1, -4] return 2.
/*  0 2 3 1
 *  0 3 2 1
 *  0 1 2 3
	3  4 -2 1 -4
	-2 4  3 1 -4
    -2 1  3	4 -4
    1 -2  3 4 -4
 */
public class Solution227 {
    public int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length<1) {
			return 1;
		}
		for(int i=0; i<nums.length; i++) {
			while(nums[i]>=1 && nums[i]<=nums.length && nums[i]-1!=i && nums[nums[i]-1]!=nums[i]) {
				swap(nums, nums[i]-1, i);
			}
		}
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
		// System.out.println(Arrays.toString(nums));
		return nums.length+1;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		Solution227 ss = new Solution227();
		int[] nums = null;
		int result=0;
//		nums = new int[]{0, 2, 3, 1};
//		result = ss.firstMissingPositive(nums);
//		System.out.println(result);
		nums = new int[]{3, 4, -2, 1, -4};
		result = ss.firstMissingPositive(nums);
		System.out.println(result);
	}
}
