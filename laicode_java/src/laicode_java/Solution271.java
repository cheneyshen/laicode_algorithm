package laicode_java;

import java.util.*;

//Smallest Non-Existed Subsequence Sum
//Given a sorted array of positive numbers in ascending order, find the smallest positive integer value that cannot be represented as sum of elements of any sub-sequence of the input array.
//Assumptions:
//The given array is not null.
//Examples:
//array = {1, 3, 6, 10, 11, 15}, result is 2
//array = {1, 1, 1, 1}, result is 5
public class Solution271 {
	public int firstMissing(int[] array) {
		int res = 0;
		for(int i=0; i<array.length && array[i]<=res+1; i++) {
			if(array[i]<=res+1) {
				res+=array[i];
			} else {
				return res+1;
			}
		}
		return res+1;
	}
	
	public static void main(String[] args) {
		Solution271 ss = new Solution271();
		int[] array = null;
		int result = 0;
		array = new int[]{1,1,1,1};
		result = ss.firstMissing(array);
		System.out.println(result);
		array = new int[]{1,1,1,3};
		result = ss.firstMissing(array);
		System.out.println(result);
	}
}
