package laicode_java;

import java.util.*;
//Rainbow Sort III
//Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.
//
//Examples
//
//k=1, {1} is sorted to {1}
//k=3, {1, 3, 2, 1, 2} is sorted to {1, 1, 2, 2, 3}
//k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
//Assumptions
//
//The input array is not null.
//k is guaranteed to be >= 1.
//k << logn.

public class Solution400 {
	public int[] rainbowSortIII(int[] array, int k) {
	    if(array==null || array.length<2) {
	      return array;
	    }
	    int right = array.length-1;
	    sortHelper(array, 0, right, 1, k);
	    return array;
	  }
	  void sortHelper(int[] array, int left, int right, int from, int to) {
	    if(from==to || left>=right) {
	      return;
	    }
	    int mid = from +(to-from)/2;
	    int l=left, r=right;
	    while(l<=r) {
	      while(l<=r && array[l] <= mid) {
	        l++;
	      }
	      while(l<=r && array[r] > mid) {
	        r--;
	      }
	      if(l<=r) {
	        int t=array[l];
	        array[l]=array[r];
	        array[r]=t;
	        l++;r--;
	      }
	    }
	    sortHelper(array, left, r, from, mid);
	    sortHelper(array, l, right, mid+1, to);
	  }
	public static void main(String[] args) {


	}
}
