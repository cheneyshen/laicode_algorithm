package laicode_java;

import java.util.*;

//Selection Sort
//Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.
//
//Examples
//
//{1} is sorted to {1}
//{1, 2, 3} is sorted to {1, 2, 3}
//{3, 2, 1} is sorted to {1, 2, 3}
//{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

public class Solution004 {
	public int[] selectionSort(int[] array) {
		if(array==null || array.length<=1) {
			return array;
		}
		for(int i=0; i < array.length - 1; i++) {
			int min=i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j]>array[min]) {
					min=j;
				}
			}
			swap(array, i, min);
		}
		return array;
	}
	private void swap(int[] array, int left, int right) {
		int temp=array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	public static void main(String[] args) {
		Solution004 ss = new Solution004();
		int[] array=new int[]{5, 1,2,3,4};
		System.out.println(Arrays.toString(ss.selectionSort(array)));
	}
}
