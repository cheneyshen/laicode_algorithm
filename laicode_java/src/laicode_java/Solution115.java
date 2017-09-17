package laicode_java;

import java.util.*;

//    Array Deduplication I
//    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
//
//    Assumptions
//
//    The array is not null
//    Examples
//
//    {1, 2, 2, 3, 3, 3} - > {1, 2, 3}
/*           s
 * 	                     f 
 */
public class Solution115 {
	public int[] dedup(int[] array) {
		if(array==null || array.length<=1) {
			return array;
		}
		int slow=0;
		for(int fast=0; fast<array.length; fast++) {
			if(array[fast]!=array[slow]) {
				array[++slow]=array[fast];
			}
		}
		return Arrays.copyOf(array, slow+1);
	}
	
	public static void main(String[] args) {
		Solution115 ss = new Solution115();
		int[] array = {1,2,2,3,3,3};
		array = ss.dedup(array);
		System.out.println(Arrays.toString(array));
	}
}
