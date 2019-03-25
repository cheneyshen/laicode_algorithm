package laicode_java;
//Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum and the indices of the left and right boundaries of the subarray. If there are multiple solutions, return the leftmost subarray.
//
//Assumptions
//
//The given array is not null and has length of at least 1.
//Examples
//
//{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5. The indices of the left and right boundaries are 0 and 2, respectively.
//
//{-2, -1, -3}, the largest subarray sum is -1. The indices of the left and right boundaries are both 1
//
//
//Return the result in a array as [sum, left, right]
public class Solution489 {
	public int[] largestSum(int[] array) {
	    if(array==null || array.length<1) {
	      return null;
	    }
	    int leng = array.length;
	    int[][] sumarray = new int[leng][leng];
	    
	    int[] res = new int[3];
	    res[0] = array[0];res[1] = 0;res[2] = 0;
	    /*
	      2 1  5  3 4
	        -1 3  1 2
	           4  2 3
	             -2 -1
	                1
	    */
	    for(int i=0;i<leng; i++) {
	      for(int j=i; j<leng; j++) {
	        if(j==i) {
	          sumarray[i][j] = array[i];
	        } else {
	          sumarray[i][j] = sumarray[i][j-1]+array[j];
	        }
	        if(sumarray[i][j] > res[0]) {
	          res[1] = i;
	          res[2] = j;
	          res[0] = sumarray[i][j];
	        }
	      }
	    }
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
