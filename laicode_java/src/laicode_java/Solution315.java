package laicode_java;

import java.util.*;

//Array Deduplication V
//Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the final array.
//
//Assumptions
//
//The given array is not null
//Examples
//{1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}
//{2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3}
public class Solution315 {
	public int[] dedup(int[] array) {
		if(array == null || array.length<3) {
			return array;
		}
		int end = -1;
		for(int i=0; i<array.length; i++) {
			if(end==-1 || array[end]!=array[i]) {
				array[++end] = array[i];
			} else {
				//otherwise, we ignore all consecutive duplicates and 
				//remove the top element of the stack
				while(i+1<array.length && array[i+1]==array[end]) {
					i++;
				}
				end--;
			}
		}
		return Arrays.copyOf(array, end+1);
	}

	public static void main(String[] args) {


	}
}
