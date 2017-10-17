package laicode_java;

import java.util.*;

//Longest Subarray With Equal Number Of 1s And 0s
//Given an unsorted array with all 0 or 1s. Return the length of the longest contiguous sub-array that contains equal numbers of 0s and 1s.
//Assumptions:
//The given array is not null.
//Examples:
//array = {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0}, the answer is 6 (the subarray is highlighted).
public class Solution275 {
	public int findMaxLength(int[] nums) {
		int result=0, count=0;
		HashMap<Integer, Integer> dict=new HashMap<>();
		dict.put(0, -1); // {0,1} should return 2, otherwise is 0
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==0) {
				--count;
			} else {
				++count;
			}
			if(dict.containsKey(count)==false) {
				dict.put(count, i);
			} else {
				result = Math.max(result, i - dict.get(count));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution275 ss = new Solution275();
		int[] nums = {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0};
		System.out.println(ss.findMaxLength(nums));
	}
}
