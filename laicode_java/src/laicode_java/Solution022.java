package laicode_java;

import java.util.*;
//Search In Shifted Sorted Array II
//Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//
//For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//  
//  Assumptions
//  
//  There could be duplicate elements in the array.
//  Examples
//  
//A = {3, 4, 5, 1, 2}, T = 4, return 1
//A = {3, 3, 3, 1, 3}, T = 1, return 3
//A = {3, 1, 3, 3, 3}, T = 1, return 1
//​Corner Cases
//
//What if A is null or A is of zero length? We should return -1 in this case.

public class Solution022 {
	public int solve(int[] input, int target) {
		if(input==null || input.length==0) {
			return -1;
		}
		int left=0, right=input.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(input[mid]==target) {
				return mid;
			}
			else if(input[mid]==input[left]) {
				left++;
			}
			else if(input[mid]>input[left]) {
				if(input[mid]>=target && target>=input[left]) {
					right=mid-1;
				}
				else {
					left=mid+1;
				}
			}
			else {
				if(input[mid]<=target && input[right]>=target) {
					left=mid+1;
				}
				else {
					right=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {


	}
}
