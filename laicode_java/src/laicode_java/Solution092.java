package laicode_java;

import java.util.*;

//Buy Stock I
//	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock and you can make at most 1 transaction.Determine the maximum profit you can make.

//	Assumptions

//	The given array is not null and is length of at least 2.
//	Examples

//{ 2, 3, 2, 1, 4, 5 }, the maximum profit you can make is 5 - 1 = 4
public class Solution092 {

	public int maxProfit(int[] array) {
		if(array==null || array.length<2) {
			return 0;
		}
		int leng=array.length;
		int minprice = array[0];
		int maxprofit = 0;
		//O(n)时间复杂度，刷新minprice, 再根据array[i]得出maxprofit
		for(int i=0; i<leng; i++) {
			minprice = Math.min(minprice, array[i]);
			maxprofit = Math.max(maxprofit, array[i]-minprice);
		}
		return maxprofit;
	}
	
	public static void main(String[] args) {


	}
}
