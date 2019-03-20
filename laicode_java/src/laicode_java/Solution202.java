package laicode_java;

import java.util.*;

//Kth Smallest In Two Sorted Arrays
//Given two sorted arrays of integers, find the Kth smallest number.
//
//Assumptions
//The two given arrays are not null and at least one of them is not empty
//K >= 1, K <= total lengths of the two sorted arrays
//Examples
//A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
//A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
public class Solution202 {
	//我们需要用广义二分查找方法
	private int helper(int[] a, int i, int[] b, int j, int k) {
		//基本判断1.如果a搜索完，则直接返回b[j+k-1]
		if(i>=a.length) {
			return b[j+k-1];
		}
		//基本判断2.如果b搜索完，则直接返回a[i+k-1]
		if(j>=b.length) {
			return a[i+k-1];
		}
		//基本判断3.如果k为1，则直接返回a[i],b[j]中较小的那个
		if(k==1) {
			return Math.min(a[i], b[j]);
		}
		//分别计算amid, bmid两个中位数
		int amid = i+k/2-1;
		int bmid = j+k/2-1;
		//如果A到头了，则设置aval为最大值
		int aval = amid>=a.length?Integer.MAX_VALUE:a[amid];
		//如果B到头了，则设置bval为最大值
		int bval = bmid>=b.length?Integer.MAX_VALUE:b[bmid];
		//如果a中位数较大，则把b数组左半部分砍掉,更新k为k-k/2
		if(aval>=bval) {
			return helper(a, i, b, bmid+1, k-k/2);
		}
		//如果b中位数较大，则把a数组左半部分砍掉,更新k为k-k/2
		else {
			return helper(a, amid+1, b, j, k-k/2);
		}
	}
	
	public int Kth(int[] a, int[] b, int k) {
		return helper(a, 0, b, 0, k);
	}
	
	public static void main(String[] args) {
		Solution202 ss = new Solution202();
		int[] a = new int[]{1,4,6};
		int[] b = new int[]{2,3};
		System.out.println(ss.Kth(a, b, 3));
	}
}
