package laicode_java;

import java.util.*;

//    Largest Rectangle In Histogram
//    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
//
//    Assumptions
//
//    The given array is not null or empty
//    Examples

/*
 { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
 2  3  4
 2*1  2*(1-0+1)  3*1 3*(3-2+1) 4*()
 
 */
public class Solution198 {
	//O(N^2)
	public int largest(int[] array) {
		if(array==null || array.length<1) {
			return 0;
		}
		int leng=array.length;
		int result=0;
		for(int i=0; i<leng; i++) {
			int height=array[i];
			for(int j=i; j>=0; j--) {
				height = Math.min(height, array[j]);
				int width = i-j+1;
				int area = height*width;
				result = Math.max(result, area);
			}
		}
		return result;
	}
	
	//O(N)
	public int largest(int[] array, int n) {
		if(array==null || array.length<1) {
			return 0;
		}
		int leng=array.length;
		Stack<Integer> stk = new Stack<Integer>();
		int result=0;
		for(int i=0; i<=leng; i++) {
			int height = (i==leng ? 0:array[i]);
			if(stk.isEmpty() || height>=array[stk.peek()]) {
				stk.push(i);
			} else {
				int index = stk.pop();
				result = Math.max(result, array[index]*(stk.isEmpty() ? i : i-1-stk.peek()));
				i--;	//
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution198 ss = new Solution198();
		int[] array = new int[]{2,1,3,3,4};
		System.out.println(ss.largest(array));
		System.out.println(ss.largest(array, 5));
	}
}
