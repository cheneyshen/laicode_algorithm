package laicode_java;

import java.util.*;

//    Array Deduplication III
//    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.
//        
//        Assumptions
//        
//        The given array is not null
//        Examples
//        
//    {1, 2, 2, 3, 3, 3} -> {1}
/*        s
 *              f1
 *                      f2
 */
public class Solution117 {
	public int[] dedup(int[] array) {
		if(array==null || array.length<=1) {
			return array;
		}
		int slow=0;
		for(int fast1=0, fast2=0; fast2<array.length;) {
			if(array[fast2]==array[fast1]) {
				while(fast2<array.length && array[fast2]==array[fast1]) {
					fast2++;
				}
			}
			if(fast2>fast1+1) {
				fast1=fast2;
			}
			else {
				array[slow++] = array[fast1++];
			}
		}
		return Arrays.copyOf(array, slow);
	}
	
	public static void main(String[] args) {
		Solution117 ss = new Solution117();
		int[] array={1,2,2,3,3,3,4};
		array = ss.dedup(array);
		System.out.println(Arrays.toString(array));
	}
}
