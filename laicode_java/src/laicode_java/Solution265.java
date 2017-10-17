package laicode_java;

import java.util.*;

//Subarray Sum To Target
//Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums to a target number.
//
//Assumptions:
//
//The given array is not null and its length is > 0.
//Examples:
//
//array = {1, 5, 2, 3}, target = 10, return true since the sum of subarray {5, 2, 3} is 10.
//array = {1, 5, 2, 3}, target = 4, return false.
public class Solution265 {
	public boolean sumToTarget(int[] array, int target) {
		if(array==null || array.length<1) {
			return false;
		}
		//T O(n)  S O(1)
		int curr=0, start=0, i;
		for(i=0; i<array.length; i++) {
			curr=curr+array[i];
			while(curr>target && start<i) {
				curr=curr-array[start];
				start++;
			}
			if(curr==target) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 2, 3};
		boolean result = true;
		Solution265 ss = new Solution265();
		result = ss.sumToTarget(array, 1);
		System.out.println(result);
		result = ss.sumToTarget(array, 2);
		System.out.println(result);
		result = ss.sumToTarget(array, 3);
		System.out.println(result);
		result = ss.sumToTarget(array, 4);
		System.out.println(result);
		result = ss.sumToTarget(array, 5);
		System.out.println(result);
		result = ss.sumToTarget(array, 6);
		System.out.println(result);
		result = ss.sumToTarget(array, 7);
		System.out.println(result);
		result = ss.sumToTarget(array, 8);
		System.out.println(result);
		result = ss.sumToTarget(array, 9);
		System.out.println(result);
		result = ss.sumToTarget(array, 10);
		System.out.println(result);
		result = ss.sumToTarget(array, 11);
		System.out.println(result);
	}
}
