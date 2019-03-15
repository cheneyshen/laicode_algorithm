package laicode_java;

import java.util.*;

//Merge Sort
//Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.
//
//Examples
//
//{1} is sorted to {1}
//{1, 2, 3} is sorted to {1, 2, 3}
//{3, 2, 1} is sorted to {1, 2, 3}
//{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
public class Solution009 {
	public int[] mergeSort(int[] array) {
		if(array==null || array.length<1) {
			return array;
		}

		return helper(array, 0, array.length-1);
	}
	
	private int[] helper(int[] array, int left, int right) {
		int[] res = new int[right-left+1];
		if(left==right) {
			res[0] = array[left];
			return res;
		}
		int mid=left+(right-left)/2;
		int[] lefter = helper(array, left, mid);
		int[] righter = helper(array, mid+1, right);
		return mergeHelper(lefter, righter);
	}
	
	private int[] mergeHelper(int[] left, int[] right) {
		int[] res = new int[left.length+right.length];
		int i=0, j=0, k=0;
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				res[k++] = left[i++];
			} else {
				res[k++] = right[j++];
			}
		}
		while(i<left.length) {
			res[k++] = left[i++];
		}
		while(j<right.length) {
			res[k++] = right[j++];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] array=new int[]{2,4,1,5,3};
		Solution009 ss = new Solution009();
		array = ss.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
