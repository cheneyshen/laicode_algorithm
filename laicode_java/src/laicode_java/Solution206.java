package laicode_java;

import java.util.*;

//Majority Number I
//Given an integer array of length L, find the number that occurs more than 0.5 * L times.
//
//Assumptions
//
//The given array is not null or empty
//It is guaranteed there exists such a majority number
//Examples
//
//A = {1, 2, 1, 2, 1}, return 1
public class Solution206 {
	public int majority(int[] array) {
		int result=array[0];
		int count=1;
		for(int i=1; i<array.length; i++) {
			if(count==0) {
				result=array[i];
				count++;
			}
			else if(array[i]!=result) {
				count--;
			}
			else {
				count++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution206 ss = new Solution206();
		int[] array = new int[]{1,2,3,3,2,1,1,1,1};
		System.out.println(ss.majority(array));
	}
}
