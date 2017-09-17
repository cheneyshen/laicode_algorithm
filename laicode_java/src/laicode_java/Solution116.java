package laicode_java;

import java.util.*;

//    Array Deduplication II
//    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
//    
//    Assumptions
//    
//    The given array is not null
//    Examples
//    
//    {1, 2, 2, 3, 3, 3} -> {1, 2, 2, 3, 3}
/*	               s
 *                      f
 */
public class Solution116 {
	public int[] dedup(int[] array) {
		if(array==null || array.length<=2) {
			return array;
		}
		int slow=1;
		for(int fast=2; fast<array.length; fast++) {
			if(array[fast]!=array[slow-1]) {
				array[++slow]=array[fast];
			}
		}
		return Arrays.copyOf(array, slow+1);
	}
	
	public static void main(String[] args) {
		Solution116 ss = new Solution116();
		int[] array = {1, 2, 2, 3, 3, 3};
		array = ss.dedup(array);
		System.out.println(Arrays.toString(array));
	}
}
