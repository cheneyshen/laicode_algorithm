package laicode_java;

import java.util.*;

//Buy Stock III
//	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total.Determine the maximum profit you can make.

//	Assumptions

//	The give array is not null and is length of at least 2
//	Examples

//{ 2, 3, 2, 1, 4, 5, 2, 11 }, the maximum profit you can make is(5 - 1) + (11 - 2) = 13

public class Solution094 {
	public int maxProfit(int[] array) {
		if(array==null || array.length<=1) {
			return 0;
		}
		int result=0;
		for(int i=1; i<array.length; i++) {
			int leftmax=maxHelper(array, 0, i);
			int rightmax=maxHelper(array, i+1, array.length-1);
			result=Math.max(result, leftmax+rightmax);
		}
		return result;
	}
	
	public int maxProfit1(int[] array) {
		if(array==null || array.length<=1) {
			return 0;
		}
		return maxHelper1(array, 2);
	}
	
	private int maxHelper(int[] array, int left, int right) {
		if(right<=left) {
			return 0;
		}
		int minprice=array[left];
		int result=0;
		for(int i=left; i<=right; i++) {
			minprice=Math.min(minprice, array[i]);
			result=Math.max(result, array[i]-minprice);
		}
		return result;
	}
	
	private int maxHelper1(int[] array, int k) {
	    // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
		if(array==null || array.length<=1) {
			return 0;
		}
		int result=0;
		int[][] matrix=new int[k+1][array.length];
		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(matrix[i], 0);
		}
		for(int kk=1; kk<=k; kk++) {
			int temp=matrix[kk-1][0]-array[0];
			for(int ii=1; ii<array.length; ii++) {
				matrix[kk][ii]=Math.max(matrix[kk][ii-1], array[ii]+temp);
				temp=Math.max(matrix[kk-1][ii]-array[ii], temp);
				result=Math.max(result, matrix[kk][ii]);
			}
		}
		return result;
        // zero time	0 0 0 0 0 0 0 0  
        //	1st time	0 1 1 1 3 4 4 10    tmp:-2, -2, -2, -1, -1, -1, -1
        //	2nd time	0 1 1 1 6 7 7 13	tmp:-2, -1,  2,  2,  2,  2, 2
	}
	public static void main(String[] args) {


	}
}
