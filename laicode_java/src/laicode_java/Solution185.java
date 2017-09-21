package laicode_java;

import java.util.*;

//2 Sum 2 Arrays
//Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.
//
//Assumptions
//The two given arrays are not null and have length of at least 1
//Examples
//A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)
//A = {1, 3, 5}, B = {2, 8}, target = 6, return false
public class Solution185 {
	public boolean existSum(int[] a, int[] b, int target) {
		if(a==null || b==null || a.length<1 || b.length<1) {
			return false;
		}
		Arrays.sort(b);
		for(int i=0; i<a.length; i++) {
			int other = target-a[i];
			int start=0, end=b.length-1;
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(b[mid]==other) {
					return true;
				} else if(b[mid]>other) {
					end=mid-1;
				} else {
					start=mid+1;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		

	}
}
