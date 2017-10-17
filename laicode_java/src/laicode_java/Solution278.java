package laicode_java;

import java.util.*;

//2 Difference In Sorted Array
//Given a sorted array A, find a pair (i, j) such that A[j] - A[i] is identical to a target number(i != j).
//If there does not exist such pair, return a zero length array.
//Assumptions:
//The given array is not null and has length of at least 2.
//Examples:
//A = {1, 2, 3, 6, 9}, target = 2, return {0, 2} since A[2] - A[0] == 2.
//A = {1, 2, 3, 6, 9}, target = -2, return {2, 0} since A[0] - A[2] == 2.
public class Solution278 {
	public List<Integer> getPairsWithDiff2(int[] arr, int target) {
		int i=0, j=0;
		List<Integer> result=new ArrayList<>();
		while(i<arr.length && j<arr.length) {
			if (i!=j && arr[j]-arr[i]==Math.abs(target)) {
				if(target<0) {
					result.add(arr[j]);
					result.add(arr[i]);
				} else {
					result.add(arr[i]);
					result.add(arr[j]);
				}
				break;
			} else if (arr[j]-arr[i]<Math.abs(target)) {
				j++;
			} else {
				i++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution278 ss = new Solution278();
		System.out.println(ss.getPairsWithDiff2(new int[]{1, 2, 3, 6, 9}, -2));
	}
}
