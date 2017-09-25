package laicode_java;

import java.util.*;

//    Max Water Trapped I
//    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.
//
//    Assumptions
//
//    The given array is not null
//    Examples
//
//    { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
/*    2 1 3 2 4
 *    0 1 0 1 |
 *            4
 */
public class Solution199 {
	public int maxTrapped(int[] array) {
		int result=0;
		int i=0, j=array.length-1;
		int leftmost=array[i];
		int rightmost=array[j];
		while(i<=j) {
			if(leftmost<=rightmost) {
				if(leftmost<array[i]) {
					leftmost=array[i];
				}
				result+=leftmost-array[i];
				i++;
			} else {
				if(rightmost<array[j]) {
					rightmost=array[j];
				}
				result+=rightmost-array[j];
				j--;
			}
		}
		return result;
	}

	public int maxTrapped(int[] array, int k) {
		int result=0;
		int i=0, j=array.length-1;
		int leftmost=0;
		int rightmost=0;
		while(i<=j) {
			if(leftmost<array[i]) {
				leftmost=array[i];
			}
			if(rightmost<array[j]) {
				rightmost=array[j];
			}
			if(leftmost<=rightmost) {
				result+=leftmost-array[i];
				i++;
			} else {
				result+=rightmost-array[j];
				j--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution199 ss = new Solution199();
		int[] array = new int[]{1,3,2,4,1,3,2,4,3,2};
		System.out.println(ss.maxTrapped(array));
		System.out.println(ss.maxTrapped(array, 2));
	}
}
