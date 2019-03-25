package laicode_java;

import java.util.*;

//Rainbow Sort II
//Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, sort the balls such that all balls with same color are grouped together and from left to right the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3).
//
//Examples
//
//{0} is sorted to {0}
//{1, 0} is sorted to {0, 1}
//{1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}
//Assumptions
//
//The input array is not null.
public class Solution399 {
	public int[] rainbowSortII(int[] array) {
	    if(array==null || array.length<2) {
	        return array;
	      }
	      int zero = 0, one = 0, two = array.length-1, three = array.length-1;
	      while(one<=two) {
	    	//如果是0, one zero交换, zero,one变
	        if(array[one]==0) {
	          swap(array, one, zero);
	          zero++;
	          one++;
	          //如果是1，one变
	        } else if(array[one]==1) {
	          one++;
	          //如果是2,one,two变
	        } else if(array[one]==2) {
	          swap(array, one, two);
	          two--;
	          //如果是3,one,three变
	        } else {
	          swap(array, one, three);
	          three--;
	          if(two>three) {
	            two=three;
	          }
	        }
	      }
	      return array;
	}
	private void swap(int[] array, int a, int b) {
		int t=array[a];
		array[a] = array[b];
		array[b] = t;
	}
   
	public static void main(String[] args) {

	}
}
