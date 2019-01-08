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
		int [] result=new int[2];
		result[0]=0;
		result[1]=0;
		if(array==null || array.length==0) {
			return result;
		}
		int leng=array.length;
		if(leng==1) {
			result[0]=array[0];
			result[1]=array[1];
			return result;
		}
		int [] vector = new int[leng*2];
		for(int i=leng*2-1; i>=leng; i--) {
			vector[i]=array[i-leng];
		}
		for(int i=leng-1; i>0; i--) {
			vector[i] = Math.max(vector[i*2], vector[i*2+1]);
		}
		result[0]=vector[1];
		for(int i=1; i<leng; ) {
			if(vector[i]==vector[2*i]) {
				if(result[1]<vector[2*i+1]) {
					result[1]=vector[2*i+1];
				}
				i=2*i;
			} else {
				if(result[1]<vector[2*i]) {
					result[1]=vector[2*i];
				}
				i=2*i+1;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Solution120 ss = new Solution120();
		int[] array =  {2, 1, 5, 4, 3};
		array = ss.largestAndSecond(array);
		System.out.println(Arrays.toString(array));
	}
}
