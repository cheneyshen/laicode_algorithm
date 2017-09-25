package laicode_java;

import java.util.*;

//Kth Smallest In Two Sorted Arrays
//Given two sorted arrays of integers, find the Kth smallest number.
//
//Assumptions
//The two given arrays are not null and at least one of them is not empty
//K >= 1, K <= total lengths of the two sorted arrays
//Examples
//A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
//A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
public class Solution202 {
	private int helper(int[] a, int i, int[] b, int j, int k) {
		if(i>=a.length) {
			return b[j+k-1];
		}
		if(j>=b.length) {
			return a[i+k-1];
		}
		if(k==1) {
			return Math.min(a[i], b[j]);
		}
		int amid = i+k/2-1;
		int bmid = j+k/2-1;
		int aval = amid>=a.length?Integer.MAX_VALUE:a[amid];
		int bval = bmid>=b.length?Integer.MAX_VALUE:b[bmid];
		if(aval>=bval) {
			return helper(a, i, b, bmid+1, k-k/2);
		}
		else {
			return helper(a, amid+1, b, j, k-k/2);
		}
	}
	
	public int Kth(int[] a, int[] b, int k) {
		return helper(a, 0, b, 0, k);
	}
	
	public static void main(String[] args) {
		Solution202 ss = new Solution202();
		int[] a = new int[]{1,4,6};
		int[] b = new int[]{2,3};
		System.out.println(ss.Kth(a, b, 3));
	}
}
