package laicode_java;

import java.util.*;
//Total Occurrence
//Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.
//
//Examples
//
//A = {1, 2, 3, 4, 5}, T = 3, return 1
//A = {1, 2, 2, 2, 3}, T = 2, return 3
//A = {1, 2, 2, 2, 3}, T = 4, return 0
//Corner Cases
//
//What if A is null? We should return 0 in this case.

public class Solution024 {
	public int totalOccurrence(int[] input, int target) {
		if(input==null || input.length==0) {
			return 0;
		}
		int left=0, right=input.length-1;
		//第一次出现的位置为first,最后一次出现的为last
		int first=-1, last=-1;
		//用Version3 Binary Search进行二分搜索
		//left+1 < right
		while(left<right-1) {
			int mid=left+(right-left)/2;
			//大于等于当前数,则right左移
			if(input[mid]>=target) {
				right=mid;
			} else {
				left=mid+1;
			}
		}
		//目前left+1=right,只需要看这两个元素是不是等于target
		if(input[left]==target) {
			first=left;
		} else if(input[right]==target) {
			first=right;
		}
		if (first==-1) {
			return 0;
		}
		//重置left, right再次搜索
		left=0;
		right=input.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			//小于等于当前数，则left右移
			if(input[mid]<=target) {
				left=mid;
			} else {
				right=mid-1;
			}
		}
		if(input[right]==target) {
			last=right;
		} else if(input[left]==target) {
			last=left;
		}
		return last-first+1;
	}
	
	public static void main(String[] args) {


	}
}
