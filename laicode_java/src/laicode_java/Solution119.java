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
		int[] result=new int[2];
		result[0]=0; result[1]=0;
		if(array==null || array.length==0) {
			return result;
		}
		int leng=array.length;
		if(leng==1) {
			result[0]=result[1]=array[0];
			return result;
		}
		int[] larger = new int[array.length/2+1];
		int[] smaller = new int[array.length/2+1];
		result[0]=Integer.MIN_VALUE;
		result[1]=Integer.MAX_VALUE;
		int il=0, is=0;
		for(int i=0; i<leng; i+=2) {
			if(i+1<leng) {
				larger[il]=Math.max(array[i], array[i+1]);
				smaller[is]=Math.min(array[i], array[i+1]);
			}
			else {
				larger[il]=array[i];
				smaller[is]=array[i];
			}
			result[0]=Math.max(result[0], larger[il]);
			il++;
			result[1]=Math.min(result[1], smaller[is]);
			is++;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution119 ss = new Solution119();
		int[] array = {2, 1, 5, 4, 3};
		array = ss.largestAndSmallest(array);
		System.out.println(Arrays.toString(array));
	}
}
