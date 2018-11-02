package laicode_java;

import java.util.*;

//Longest Bitonic Sequence
//Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order, then sorted in a descending order. How can you find the length of the longest bitonic subsequence.
//  
//  Assumptions:
//  The given array is not null.
//  Corner Cases:
//  A subsequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
//  Examples:
//{1, 3, 2, 1, 4, 6, 1}, the longest bitonic sub sequence is {1, 3, 4, 6, 1}, length is 5.
public class Solution309 {

	static int lbs(int arr[], int n) {
		int i, j;
		int[] lis = new int[n];
		for (i=0; i<n; i++) {
		    lis[i]=1;
        }
        for(i=1; i<n; i++) {
		    for(j=0; j<i; j++) {
		        if(arr[i]>arr[j] && lis[i]<lis[j]+1) {
		            lis[i]=lis[j]+1;
                }
            }
        }
        int[] lds = new int[n];
		for(i=0; i<n; i++) {
		    lds[i] = 1;
        }
        for(i=n-2; i>=0; i--) {
		    for (j=n-1; j>1; j--) {
		        if(arr[i]>arr[j] && lds[i]<lds[j]+1) {
		            lds[i]=lds[j]+1;
                }
            }
        }
        int max = lis[0]+lds[0]-1;
		for(i=1; i<n; i++) {
		    if(lis[i]+lds[i]-1>max) {
		        max = lis[i]+lds[i]-1;
            }
        }
        return max;
	}
	
	/*
	 * 	buy[i]  = max(rest[i-1]-price, buy[i-1]) 
	 *	sell[i] = max(buy[i-1]+price, sell[i-1])
	 *	rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
	 *
	 *  because rest[i] <= sell[i]  buy[i] <= rest[i]
	 *  so rest[i] = sell[i-1]
	 *	buy[i] = max(sell[i-2]-price, buy[i-1])
	 *	sell[i] = max(buy[i-1]+price, sell[i-1])
	 */
	public int maxProfit(int[] prices) {
	    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
	    for (int price : prices) {
	        prev_buy = buy;
	        buy = Math.max(prev_sell - price, prev_buy);
	        prev_sell = sell;
	        sell = Math.max(prev_buy + price, prev_sell);
	    }
	    return sell;
	}
	
	public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        int n = arr.length;
        Solution309 ss = new Solution309();
        System.out.println("Length of LBS is "+ ss.lbs( arr, n ));

	}
}
