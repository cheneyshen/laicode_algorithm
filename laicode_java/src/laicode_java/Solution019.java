package laicode;

import java.util.*;
//K Closest In Sorted Array
//	Given a target integer T, a non - negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

//	Assumptions

//	A is not null
//	K is guranteed to be >= 0 and K is guranteed to be <= A.length
//	Return

//	A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
public class Solution019 {
	public int[] kCloset(int[] array, int target, int k) {
		if(array==null || array.length==0) {
			return array;
		}
		if(k==0) {
			return new int[0];
		}
		int left=largestSmallerEqual(array, target) ;
		int right=left+1;
		int[] result=new int[k];
		for(int i=0; i<k; i++) {
			if(right>=array.length || left>=0 &&
					target-array[left]<=array[right]-target) {
				result[i]=array[left--];
			}
			else {
				result[i]=array[right++];
			}
		}
		return result;
	}
	
	private int largestSmallerEqual(int[] array, int target) {
		int left=0, right=array.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]<=target) {
				left=mid;
			}
			else {
				right=mid;
			}
		}
		if(array[right]<=target) {
			return right;
		}
		if(array[left]<=target) {
			return left;
		}
		return -1;
	}
	
	public static void main(String[] args) {


	}
}
