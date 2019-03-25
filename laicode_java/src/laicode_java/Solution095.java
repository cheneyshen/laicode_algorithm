package laicode_java;

import java.util.*;
/*Buy Stock IV
Given an array of integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total.Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2
Examples

{ 2, 3, 2, 1, 4, 5, 2, 11 }, K = 3, the maximum profit you can make is(3 - 2) + (5 - 1) + (11 - 2) = 14*/

public class Solution095 {
	public static int maxProfit(int[] array, int k) {
		if(array==null || array.length<=1 || k<1) {
			return 0;
		}
		int[][] buysell = new int[k+1][array.length];
		int result = 0;
		for(int kk=1; kk<=k; kk++) {
			//当前次的第一手买
			int prevbuy = buysell[kk-1][0]-array[0];
			for(int ii=1; ii<array.length; ii++) {
				//当前次的卖
				buysell[kk][ii] = Math.max(buysell[kk][ii-1], prevbuy + array[ii]);
				//当前次的第二次买 再用上一次的卖-array[i]去更新
				prevbuy = Math.max(prevbuy, buysell[kk-1][ii]-array[ii]);
				result = Math.max(result, buysell[kk][ii]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{2, 3, 2, 1, 4, 5, 2, 11};
		System.out.println(maxProfit(array, 3));

	}
}
