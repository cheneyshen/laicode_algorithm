package laicode_java;

import java.util.*;

//Buy Stock II
//	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock.Determine the maximum profit you can make.

//	Assumptions

//	The give array is not null and is length of at least 2
//	Examples

//{ 2, 3, 2, 1, 4, 5 }, the maximum profit you can make is(3 - 2) + (5 - 1) = 5
//		if array[2]>array[1]
//				profit[2][1]=array[2]-array[1]
//				else
//					profit[2][1]=0;
//
//		if array[j]-array[i]>0
//			profit[j][i] = array[j]-array[i]
//			else
//				profit[j][i]=0
//
//				profit[j][i]=profit[j][k]+profit[k][i];
//		return profit[5][0];
//		0 0 0 0 0 0
//		1 0 0 0 0 0
//		0 1 0 0 0 0
//		0 0 1 0 0 0
//		0 0 0 4 0 0
//		0 0 0 0 5 0
public class Solution093 {
	public int maxProfit(int[] array) {
		int leng=array.length;
		if(leng<=1) {
			return 0;
		}
		int result=0;
		for(int i=0; i<leng; i++) {
			if(array[i]>array[i-1]) {
				result+=array[i]-array[i-1];
			}
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
