package laicode_java;

import java.util.*;

//Square Root I
//Given an integer number n, find its integer square root.
//
//Assumption:
//
//n is guaranteed to be >= 0.
//Example:
//
//Input: 18, Return: 4
//
//Input: 4, Return: 2
public class Solution161 {
	public int sqrt(int x) {
		if(x<=0) {
			return 0;
		}
		if (x==1) {
			return 1;
		}
		if (x==2) {
			return 1;
		}
		int left=2, right=x/2;
		// log(n)的时间复杂度
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(x/mid==mid) {
				return mid;
			} else if(x/mid > mid) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return right;
	}
	public static void main(String[] args) {


	}
}
