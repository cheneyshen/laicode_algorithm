package laicode_java;

import java.util.*;

//    Missing Number I
//    Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
//
//    Assumptions
//
//    The given array is not null, and N >= 1
//    Examples
//
//    A = {2, 1, 4}, the missing number is 3
//    A = {1, 2, 3}, the missing number is 4
//    A = {}, the missing number is 1
public class Solution068 {
	public int missing(int[] array){
		long result = 0;
		int i;
		for(i=0; i<array.length; i++) {
			result+=array[i];
		}
		return (int)((long)(i+2)*(i+1)/2-result);
	}
	
	public static void main(String[] args) {


	}
}
