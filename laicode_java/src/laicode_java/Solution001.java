package laicode_java;

import java.util.*;

//Longest Ascending Subsequence
//Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//
//Assumptions
//
//A is not null
//Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//Because [2, 3, 4, 5] is the longest ascending subsequence.
public class Solution001 {
	public int longest(int[] array) {
		if(array.length==0) {
			return 0;
		}
		int[] table=new int[array.length];
		int result=1;
		table[1]=array[0];
		for(int i=1; i<array.length; i++) {
			int index=find(table, 1, result, array[i]);
			if(index==result) {
				table[++result]=array[i];
			}
			else {
				table[index+1]=array[i];
			}
		}
		return result;
	}
	private int find(int[] table, int left, int right, int target) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(table[mid]==target) {
				right=mid-1;
			}
			else if(table[mid]>target) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) {
		Solution001 ss = new Solution001();
		int[] array = {5, 2, 6, 3, 4, 7, 5};
		System.out.println(ss.longest(array));
	}
}
