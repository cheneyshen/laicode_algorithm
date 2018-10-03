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
		if(array==null) {
			return array;
		}
		int[] helper=new int[array.length];
		mergeSort(array, helper, 0, array.length-1);
		return array;
	}
	
	private void mergeSort(int[] array, int[] helper, int left, int right) {
		if(left>=right) {
			return;
		}
		int mid=left+(right-left)/2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid+1, right);
		merge(array, helper, left, mid, right);
	}
	
	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		for (int i=left; i<=right; i++) {
			// shallow copy
			helper[i]=array[i];
		}
		int leftIndex=left;
		int rightIndex=mid+1;
		while(leftIndex<=mid && rightIndex<=right) {
			if(helper[leftIndex]<=helper[rightIndex]) {
				array[left++]=helper[leftIndex++];
			}
			else {
				array[left++]=helper[rightIndex++];
			}
		}
		while(leftIndex<=mid) {
			array[left++]=helper[leftIndex++];
		}
	}
	public static void main(String[] args) {
		int[] array=new int[]{2,4,1,5,3};
		Solution009 ss = new Solution009();
		array = ss.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
