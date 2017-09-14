package laicode;

import java.util.*;

//First Occurrence
//	Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.
//	Assumptions

//	There can be duplicate elements in the array.
//	Examples
//	A = { 1, 2, 3 }, T = 2, return 1
//	A = { 1, 2, 3 }, T = 4, return -1
//	A = { 1, 2, 2, 2, 3 }, T = 2, return 1
public class Solution015 {
	public int firstOccur(int[] array, int target) {
		if(array==null || array.length==0) {
			return -1;
		}
		int left=0, right=array.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]>=target) {
				right=mid;
			}
			else {
				left=mid;
			}
		}
		if(array[left]==target) {
			return left;
		}
		else if(array[right]==target) {
			return right;
		}
		return -1;
	}
	
	public static void main(String[] args) {


	}
}
