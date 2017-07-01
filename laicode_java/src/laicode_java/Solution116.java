package laicode_java;
import java.util.*;

//Median Of Two Arrays
//Given two arrays of integers, find the median value.
//
//Assumptions
//
//The two given array are not null and at least one of them is not empty
//The two given array are not guaranteed to be sorted
//Examples
//
//A = {4, 1, 6}, B = {2, 3}, median is 3
//A = {1, 4}, B = {3, 2}, median is 2.5
public class Solution116 {
	
	public double median(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int total=a.length+b.length;
	    if(total%2!=0) {
	    	return findKth(a, 0, b, 0, total/2+1);
	    }
	    else {
	    	return (findKth(a, 0, b, 0, total/2) + 
	    			findKth(a, 0, b, 0, total/2+1))/2.0;
	    }
	}
	
	private double findKth(int[] a, int ai, int[] b, int bi, int k) {
		if(ai>=a.length) {
			return b[bi+k-1];
		}
		if(bi>=b.length) {
			return a[ai+k-1];
		}
		if(k==1) {
			return Math.min(a[ai], b[bi]);
		}
		int amid=ai+k/2-1;
		int bmid=bi+k/2-1;
		int aval=amid>=a.length?Integer.MAX_VALUE:a[amid];
		int bval=bmid>=b.length?Integer.MAX_VALUE:b[bmid];
		if(aval<=bval) {
			return findKth(a, amid+1, b, bi, k-k/2);
		}
		else {
			return findKth(a, ai, b,  bmid+1, k-k/2);
		}
		
	}
	public static void main(String[] args) {
		Solution116 s116 = new Solution116();
		int[] a={4,1,6};
		int[] b={2,3};
		a=new int[]{1,4};
		b=new int[]{3,2};
		double result=s116.median(a, b);
		System.out.println(result);
		a=new int[]{3,4,2};
		b=new int[]{9,11,8};
		result=s116.median(a, b);
		System.out.println(result);
		a=new int[]{4,2,6,4,1,1};
		b=new int[]{9,2,1,5,3};
		result=s116.median(a, b);
		System.out.println(result);
	}
}