package laicode_java;

import java.util.*;

//Search Insert Position
//Given a sorted array and a target value, return the index where it would be if it were inserted in order.
//  Assumptions
//  If there are multiple elements with value same as target, we should insert the target before the first existing element.
//  
//  Examples
//  [1,3,5,6], 5 → 2
//  [1,3,5,6], 2 → 1
//  [1,3,5,6], 7 → 4
//  [1,3,3,3,5,6], 3 → 1
//  [1,3,5,6], 0 → 0
public class Solution236 {
	public int findPlace(int[] array, int i) {
		if(array==null || array.length<1) {
			return 0;
		}
		int idx=-1;
		while(array[idx+1]<i) {
			idx++;
		}
		return idx+1; 
	}
	
	public static void main(String[] args) {
		Solution236 ss = new Solution236();
		int[] array = {1,3,5,6};
		int result = ss.findPlace(array, 0);
		System.out.println(result);
	}
}
