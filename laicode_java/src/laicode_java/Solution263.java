package laicode_java;

import java.util.*;

//Two Subsets With Min Difference
//Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
//
//Return the minimum difference(absolute value).
//
//Assumptions:
//
//The given integer array is not null and it has length of >= 2.
//Examples:
//
//{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
public class Solution263 {
	public int minDifference(int[] array) {
		int sum=0;
		int leng=array.length;
		for(int i=0; i<leng; i++) {
			sum+=array[i];
		}
        // Compute result using recursive function
		return findMinRec(array, leng, 0, sum);
	}
	
	private int findMinRec(int[] array, int i, int curr, int sum) {
		if(i==0) {
			//we reached last element, compare the difference
			return Math.abs(sum-curr-curr);
		}
		// For every item array[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
		return Math.min(findMinRec(array, i-1, curr+array[i-1], sum), 
						findMinRec(array, i-1, curr, sum));
	}
	public static void main(String[] args) {
		Solution263 ss = new Solution263();
		int[] array = new int[]{3, 1, 4, 2, 2, 1};
		System.out.println(ss.minDifference(array));
	}
}
