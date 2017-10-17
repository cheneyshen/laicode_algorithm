package laicode_java;

import java.util.*;

//Sort In Pair
//Given an array A with integers, sort the array such that  A[0] < A[1]  > A[2] < A[3] >  A[4] < A[5] > … A[N-1].
//
//Assumptions:
//
//A is guaranteed to be not null.
//There are no duplicate elements in A.
//Examples:
//
//{1, 4, 2, 3, 5, 6} --> {1, 4, 2, 5, 3, 6}
//{1, 2, 3, 4, 5} --> {1, 3, 2, 5, 4}
//       m
public class Solution262 {
	public void sortInPair(int[] array) {
		if(array==null || array.length<2) {
			return;
		}
		int leng=array.length;
		for(int i=0; i<leng; i+=2) {
            // If current even element is smaller than previous
			if(i>0 && array[i-1]<array[i]) {
				swap(array, i, i-1);
			}
            // If current even element is smaller than next
			if(i<leng-1 && array[i]>array[i+1]) {
				swap(array, i, i+1);
			}
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		Solution262 ss = new Solution262();
		int[] array = new int[]{1, 4, 2, 3, 5, 6};
		ss.sortInPair(array);
		System.out.println(Arrays.toString(array));
	}
}
