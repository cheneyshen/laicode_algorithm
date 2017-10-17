package laicode_java;

import java.util.*;

//Max Sum Of Two Indices
//Given an array with integers, find two indices i and j  (j>=i),  such that the value of A[i]+A[j]+ (j - i) is maximized.
//Return (i, j).
//Assumptions:
//The given array is not null and it has length of > 0.
//Examples
//array = {1, 5, 3}, the max sum is array[1] + array[1] + (1 - 1) = 10, return {1, 1}
public class Solution270 {
	public int[] maxSum(int[] array) {
		if(array==null) {
			return array;
		}
		int result=0;
		for(int i=1; i<array.length; i++) {
			if(array[i]>array[result]) {
				result=i;
			}
		}
		return new int[]{result,result};
	}
	
	public static void main(String[] args) {


	}
}
