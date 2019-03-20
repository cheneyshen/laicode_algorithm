package laicode_java;

import java.util.*;

//Longest Ascending Subsequence
//Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//
//Assumptions
//
//A is not null
//Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//Because [2, 3, 4, 5] is the longest ascending subsequence.
public class Solution001 {
	public int longest(int[] array) {
		if(array.length==0) {
			return 0;
		}
		//the smallest ending value of all the ascending subsequence with length i
		int[] table = new int[array.length+1];
		int result = 1; // current max ascending length
		table[1] = array[0];
		for(int i=1; i<array.length; i++) {
			// return the biggest index less than array[i]
			// left is 1, right is updated result
			int index=find(table, 1, result, array[i]);
			/*
			 * two cases:
			 * 1. index is right side, result, so we need to put array[i] to new corner
			 * 2. if index==0, or not right side, so update current position with new value
			 */
			if(index==result) {
				table[++result]=array[i];
			} else {
				table[index+1]=array[i];
			}
		}
		return result;
	}
	/*
	 * 返回小于当前数的最大数的index, table升序排列
	 */
	private int find(int[] table, int left, int right, int target) {
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(table[mid]>=target) {
				right=mid-1;
			} else {
				left=mid+1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) {
		Solution001 ss = new Solution001();
		int[] array = {5, 2, 6, 3, 4, 7, 5};
		System.out.println(ss.longest(array));
	}
}
