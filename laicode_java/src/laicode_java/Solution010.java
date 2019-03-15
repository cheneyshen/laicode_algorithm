package laicode_java;

import java.util.*;

//Quick Sort
//Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.
//
//Examples
//
//{1} is sorted to {1}
//{1, 2, 3} is sorted to {1, 2, 3}
//{3, 2, 1} is sorted to {1, 2, 3}
//{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
public class Solution010 {
	public int[] quickSort(int[] array) {
		if(array==null || array.length<2) {
			return array;
		}
		quickSortHelper(array, 0, array.length-1);
		return array;
	}
	
	private void quickSortHelper(int[] array, int left, int right) {
		if(left>=right) {
			return;
		}
		int pivot=partition(array, left, right);
		quickSortHelper(array, left, pivot-1);
		quickSortHelper(array, pivot+1, right);
	}
	
	private int partition(int[] array, int left, int right) {
		int i=left, j=right-1;
		while(i<=j) {
			if(array[i]<array[right]) {
				i++;
			} else if(array[j]>=array[right]) {
				j--;
			} else {
				swap(array, i++, j--);
			}
		}
		swap(array, i, right);
		return i;
	}
	
	private void swap(int[] array, int left, int right) {
		int temp=array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	
	public static void main(String[] args) {
		Solution010 ss=new Solution010();
		int[] array={2,5,3,1,4};
		array=ss.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
