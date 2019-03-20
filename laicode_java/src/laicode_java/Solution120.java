package laicode_java;

import java.util.*;

//    Largest And Second Largest
//    Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.
//    
//    Assumptions
//    
//    The given array is not null and has length of at least 2
//    Examples
//    
//    {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
//     0 1 2 3 4 5 6 7 8 9
//    -1 5 4 5 4 2 1 5 4 3
public class Solution120 {
	public int[] largestAndSecond(int[] array) {
		if(array.length==2) {
			return new int[] {Math.max(array[0], array[1]), Math.min(array[0], array[1])};
		}
		int l1=Integer.MIN_VALUE, l2=Integer.MAX_VALUE;
		for(int i:array) {
			if(i>l1) {
				l2=l1;l1=i;
			} else if(i>l2) {
				l2=i;
			}
		}
		return new int[] {l1, l2};
	}
	
	public static void main(String[] args) {
		Solution120 ss = new Solution120();
		int[] array =  {2, 1, 5, 4, 3};
		array = ss.largestAndSecond(array);
		System.out.println(Arrays.toString(array));
	}
}
