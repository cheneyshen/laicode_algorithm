package laicode_java;

import java.util.*;

//    Array Deduplication IV
//    Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.
//        
//        Do this in-place, using the left side of the original array. Return the array after deduplication.
//        
//        Assumptions
//        
//        The given array is not null
//        Examples
//        
//    {1, 2, 3, 3, 3, 2, 2} -> {1, 2, 2, 2} -> {1}, return {1}
/*           s
 *                    f         
 */
public class Solution118 {
	public int[] dedup(int[] array) {
		if(array==null || array.length<=1) {
			return array;
		}
		Stack<Integer> stk=new Stack<Integer>();
		for(int fast=0; fast<array.length; ) {
			if(stk.size()>0 && stk.peek()==array[fast]) {
				while(fast<array.length && stk.peek()==array[fast]) {
					fast++;
				}
				stk.pop();
			}
			else {
				stk.push(array[fast++]);
			}
		}
		if(stk.isEmpty()) {
			return new int[0];
		}
		int[] result = new int[stk.size()];
		for(int i=stk.size()-1; i>=0; i--) {
			result[i]=stk.pop();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution118 ss = new Solution118();
		int [] array = {1,2,3,3,3,2,2,1};
		array = ss.dedup(array);
		System.out.println(Arrays.toString(array));
	}
}
