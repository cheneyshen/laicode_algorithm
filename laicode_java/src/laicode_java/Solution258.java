package laicode_java;

import java.util.*;

//Move 0s To The End I
//Given an array of integers, move all the 0s to the right end of the array.
//
//The relative order of the elements in the original array does not need to be maintained.
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
public class Solution258 {
	public int[] moveZeros(int[] array) {
		if(array==null || array.length<1) {
			return array;
		}
		int slow=0, fast=0;
		//move all the nonzero elements advance
		while(fast<array.length) {
			if(array[fast]!=0) {
				array[slow++] = array[fast];
			}
			fast++;
		}
		while(slow<array.length) {
			array[slow++] = 0;
		}
		return array;
	}
	
	public static void main(String[] args) {


	}
}
