package laicode_java;

import java.util.*;

//Move 0s To The End II
//Given an array of integers, move all the 0s to the right end of the array.
//
//The relative order of the elements in the original array need to be maintained.
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
public class Solution259 {
	public void moveZeros(int[] nums) {
		int low=0, high=nums.length;
		//move all the nonzero elements advance
		for(int i=0; i<high; i++) {
			if(nums[i]!=0) {
				nums[low++]=nums[i];
			}
		}
		for(; low<high; low++) {
			nums[low]=0;
		}
		return;
	}
	
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i=0; i<nums.length-2; i++) {
			sum +=twoSumSmaller(nums, i+1, target-nums[i]);
		}
		return sum;
	}
	
	private int twoSumSmaller(int[] nums, int start, int target) {
		int sum=0;
		int left=start, right = nums.length-1;
		while(left<right) {
			if(nums[left] + nums[right] < target) {
				sum+=right-left;
				left++;
			} else {
				right--;
			}
		}
		return sum;
	}
	public static void main(String[] args) {


	}
}
