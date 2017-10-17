package laicode_java;

import java.util.*;

//Get Count Array
//Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
//Assumptions:
//The given array A is not null.
//Examples:
//A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
//Requirement:
//time complexity = O(nlogn).
/*	1 2 3 4
 * 
 */
public class Solution276 {
	public List<Integer> countSmaller(int[] nums) {
		Integer[] result = new Integer[nums.length];
		List<Integer> sorted = new ArrayList<>();
		for(int i=nums.length-1; i>=0; i--) {
			int index = findIndex(sorted, nums[i]);
			result[i] = index;
			sorted.add(index, nums[i]);
		}
		return Arrays.asList(result);
	}
	
	private int findIndex(List<Integer> sorted, int target) {
		if(sorted.size()==0) {
			return 0;
		}
		int start=0;
		int end=sorted.size()-1;
		if(sorted.get(start)>=target) {
			return 0;
		}
		if(sorted.get(end)<target) {
			return end+1;
		}
		while(start+1<end) {
			int mid = start+(end-start)/2;
			if(sorted.get(mid)==target) {
				end=mid;
			} else if(sorted.get(mid)>target) {
				end=mid;
			} else {
				start=mid;
			}
		}
		if(sorted.get(start)>=target) {
			return start;
		} else {
			return end;
		}
	}
	
	public static void main(String[] args) {
		Solution276 ss = new Solution276();
		List<Integer> result = new ArrayList<>();
		int[] nums = new int[]{5,2,3,3,3,6,1};
		result = ss.countSmaller(nums);
		System.out.println(result);
	}
}
