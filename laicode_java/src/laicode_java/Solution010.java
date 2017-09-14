package laicode;

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
		if(array==null) {
			return array;
		}
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	private void quickSort(int[] array, int left, int right) {
		if(left>=right) {
			return;
		}
		int pivot=partition(array, left, right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}
	
	private int partition(int[] array, int left, int right) {
		int index=pivotIndex(left, right);
		int pivot=array[index];
		swap(array, index, right);
		int lefti=left, rightj=right;
		while(lefti<=rightj) {
			if(array[lefti]<pivot) {
				lefti++;
			}
			else if(array[rightj]>=pivot) {
				rightj--;
			}
			else {
				swap(array, lefti++, rightj--);
			}
		}
		swap(array, lefti, right);
		return lefti;
	}
	
	private int pivotIndex(int left, int right) {
		return left+(right-left)/2;
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
