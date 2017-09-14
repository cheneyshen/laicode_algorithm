package laicode_java;

import java.util.*;
public class Solution023 {
//  Shift Position
//  Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.
//  
//  Assumptions
//  
//  There are no duplicate elements in the array
//  Examples
//  
//  A = {3, 4, 5, 1, 2}, return 3
//  A = {1, 2, 3, 4, 5}, return 0
//  Corner Cases
//  
//  What if A is null or A is of zero length? We should return -1 in this case.
	public int shiftPosition(int[] array) {
		if(array==null || array.length==0) {
			return -1;
		}
		int left=0, right=array.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(array[mid]>=array[right]) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		return left;
	}
	public static void main(String[] args) {


	}
}
