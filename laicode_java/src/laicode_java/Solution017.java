package laicode;

import java.util.*;

//Closest In Sorted Array
//	Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

//	Assumptions

//	There can be duplicate elements in the array, and we can return any of the indices with same value.
//	Examples

//	A = { 1, 2, 3 }, T = 2, return 1
//	A = { 1, 4, 6 }, T = 3, return 1
//	A = { 1, 4, 6 }, T = 5, return 1 or 2
//	A = { 1, 3, 3, 4 }, T = 2, return 0 or 1 or 2
public class Solution017 {
	public int closest(int[] array, int target) {
		if(array==null || array.length==0) {
			return -1;
		}
		int left=0, right=array.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]==target) {
				return mid;
			}
			else if(array[mid]<target) {
				left=mid;
			}
			else {
				right=mid;
			}
		}
		if(Math.abs(array[left]-target)<=Math.abs(array[right]-target)) {
			return left;
		}
		else {
			return right;
		}
	}
	public static void main(String[] args) {


	}
}
