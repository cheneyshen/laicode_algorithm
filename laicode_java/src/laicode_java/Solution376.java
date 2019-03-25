package laicode_java;

import java.util.*;
//Ascending Triple I
//Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1, 5, 2, 4}, return true since i = 0, j = 2, k = 3
//
//{4, 3, 2, 1}, return false
public class Solution376 {

	public boolean existIJK(int[] array) {
		if(array==null || array.length<3) {
			return false;
	    }
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		// 第一第二元素进行更新
		for(int i:array) {
			if (i <= first) {
				second = first;
				first = i;
			} else if (i <= second) {
				second = i;
			} else {
				return true;
			}
	  }
	  return false;
}
	
	public static void main(String[] args) {


	}
}
