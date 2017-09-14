package laicode_java;

import java.util.*;

//    Missing Number II
//    Given an integer array of size N - 1 sorted by ascending order, containing all the numbers from 1 to N except one, find the missing number.
//
//    Assumptions
//
//    The given array is not null, and N >= 1
//    Examples
//
//    A = {1, 2, 4}, the missing number is 3
//    A = {1, 2, 3}, the missing number is 4
//    A = {}, the missing number is 1
public class Solution069 {
	public int missing(int[] array) {
		int leng=array.length;
		if(leng==0) {
			return -1;
		}
		for(int i=0; i<leng; i++) {
			if(array[i]!=i+1) {
				return i+1;
			}
		}
		return leng+1;
	}
	
	public static void main(String[] args) {


	}
}
