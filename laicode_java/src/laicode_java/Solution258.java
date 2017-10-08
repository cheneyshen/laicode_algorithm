package laicode_java;

import java.util.*;

//Move 0s To The End I
//Given an array of integers, move all the 0s to the right end of the array.
//
//The relative order of the elements in the original array does not need to be maintained.
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
public class Solution258 {
	public void moveZeros(int[] nums) {
		int low=0, high=nums.length;
		//move all the nonzero elements advance
		for(int i=0; i<high; i++) {
			if(nums[i]!=0) {
				nums[low++]=nums[i];
			}
		}
		for(; low<high; low++) {
			nums[low]=0;
		}
		return;
	}
	
	public static void main(String[] args) {


	}
}
