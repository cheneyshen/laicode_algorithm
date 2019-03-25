package laicode_java;

import java.util.*;

//Median Of Two Arrays
//Given two arrays of integers, find the median value.
//Assumptions
//The two given array are not null and at least one of them is not empty
//The two given array are not guaranteed to be sorted
//Examples
//A = {4, 1, 6}, B = {2, 3}, median is 3
//A = {1, 4}, B = {3, 2}, median is 2.5
public class Solution203 {
	private int helper(int[] a, int i, int[] b, int j, int k) {
		//三个corner case
		//如果a走完了,直接求b[j+k-1]
		//如果b走完了,直接求a[i+k-1]
		//如果k为第一个,直接求min(a[i], b[j])
		if(i>=a.length) {
			return b[j+k-1];
		}
		if(j>=b.length) {
			return a[i+k-1];
		}
		if(k==1) {
			return Math.min(a[i], b[j]);
		}
		//广义二分法，求amid, bmid
		//如果amid 越界了,那就赋值aval 为最大,方便比较
		//如果bmid 越界了,那就赋值bval 为最大,方便比较
		int amid = i+k/2-1;
		int bmid = j+k/2-1;
		int aval = amid>=a.length ? Integer.MAX_VALUE : a[amid];
		int bval = bmid>=b.length ? Integer.MAX_VALUE : b[bmid];
		//aval大的话，把B的前半部分忽略，指针移动到bmid+1
		//bval大的话，把A的前半部分忽略，指针移动到amid+1
		if(aval>=bval) {
			return helper(a, i, b, bmid+1, k-k/2);
		}
		else {
			return helper(a, amid+1, b, j, k-k/2);
		}
	}
	
	public double median(int[] a, int[] b) {
		int leng=a.length+b.length;
		Arrays.sort(a);
		Arrays.sort(b);
		//如果是偶数，求leng/2 跟 leng/2+1,再算平均数
		if(leng%2==0) {
			return (helper(a, 0, b, 0, leng/2) + helper(a, 0, b, 0, leng/2+1))/2.0;
		}
		//如果是奇数，求leng/2+1
		return helper(a, 0, b, 0, leng/2+1);
	}
	
	public static void main(String[] args) {
		Solution203 ss = new Solution203();
		int[] a = new int[]{4,1,6};
		int[] b = new int[]{2,3};
		System.out.println(ss.median(a, b));
	}
}
