package laicode_java;

import java.util.*;

//    Largest And Smallest
//    Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.
//    
//    Assumptions
//    
//    The given array is not null and has length of at least 1
//    Examples
//    
//    {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
//
public class Solution119 {
	public int[] largestAndSmallest(int[] array) {
		if(array==null || array.length<1) {
			return array;
		}
		int min = array[0], max = array[0];
		for(int i=0; i<array.length; i++) {
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i]);
		}
		return new int[] {max, min};
	}
	
	public static void main(String[] args) {
		Solution119 ss = new Solution119();
		int[] array = {2, 1, 5, 4, 3};
		array = ss.largestAndSmallest(array);
		System.out.println(Arrays.toString(array));
	}
}
