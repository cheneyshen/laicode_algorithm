package laicode_java;

import java.util.*;

//Median Of Two Arrays
//Given two arrays of integers, find the median value.
//Assumptions
//The two given array are not null and at least one of them is not empty
//The two given array are not guaranteed to be sorted
//Examples
//A = {4, 1, 6}, B = {2, 3}, median is 3
//A = {1, 4}, B = {3, 2}, median is 2.5
public class Solution203 {
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
		int aval = amid>=a.length ? Integer.MAX_VALUE : a[amid];
		int bval = bmid>=b.length ? Integer.MAX_VALUE : b[bmid];
		if(aval>=bval) {
			return helper(a, i, b, bmid+1, k-k/2);
		}
		else {
			return helper(a, amid+1, b, j, k-k/2);
		}
	}
	
	public double median(int[] a, int[] b) {
		int leng=a.length+b.length;
		Arrays.sort(a);
		Arrays.sort(b);
		if(leng%2==0) {
			return (helper(a, 0, b, 0, leng/2) + helper(a, 0, b, 0, leng/2+1))/2.0;
		}
		return helper(a, 0, b, 0, leng/2+1);
	}
	
	public static void main(String[] args) {
		Solution203 ss = new Solution203();
		int[] a = new int[]{4,1,6};
		int[] b = new int[]{2,3};
		System.out.println(ss.median(a, b));
	}
}
