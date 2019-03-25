package laicode_java;

import java.util.*;

//Buy Stock III
//	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total.Determine the maximum profit you can make.

//	Assumptions

//	The give array is not null and is length of at least 2
//	Examples

//{ 2, 3, 2, 1, 4, 5, 2, 11 }, the maximum profit you can make is(5 - 1) + (11 - 2) = 13

public class Solution094 {
	//根据Buy StockI把数组分成两部分，然后就能O(N^2)完成计算
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
	
	public int maxProfit1(int[] array) {
		//第一次买，卖，第二次买，卖，最后返回卖一次或者卖两次的最大值
		int buy1=Integer.MIN_VALUE, sell1=0, buy2=buy1, sell2=sell1;
		for(int i=0; i<array.length; i++) {
			buy1 = Math.max(buy1, -array[i]);	//花了第一笔钱，所以要－
			sell1 = Math.max(sell1, array[i] + buy1);	//挣得第一笔钱
			buy2 = Math.max(buy2, -array[i] + sell1);	//再花了一笔钱
			sell2 = Math.max(sell2, array[i] + buy2);	//再挣了一笔钱
		}
		return Math.max(sell1, sell2);
	}
	
	public static void main(String[] args) {


	}
}
