package laicode_java;

import java.util.*;

//Wiggle Sort II
//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//Example:
//(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
//(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//
//Note:
//You may assume all input has valid answer.
//
//This question does not have unique answer, and the correctness check may be not working.
//
//Follow Up:
//Can you do it in O(n) time and/or in-place with O(1) extra space?
public class Solution458 {
	public void wiggleSort(int[] nums) {
		int median = findKthLargest(nums, (nums.length+1)/2);
		int n =nums.length;
		int left=0, i=0, right=n-1;
		while(i<=right) {
			if(nums[newIndex(i, n)] > median) {
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			} else if(nums[newIndex(i, n)] < median){
				swap(nums, newIndex(right--, n), newIndex(i, n));
			} else {
				i++;
			}
		}
	}
	
	private int findKthLargest(int[] nums, int i) {
		// TODO Auto-generated method stub
		final int N = nums.length;
		Arrays.sort(nums);
		return nums[N-i];
	}

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
;		nums[j] = temp;
	}

	private int newIndex(int index, int n) {
		return (1+2*index) % (n|1);
	}
	
	public static void main(String[] args) {


	}
}
