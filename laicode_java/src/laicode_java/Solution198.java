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
	/*
	 * 1 2 3 4 5
	 * 5 * (5-3-1)
	 * 4 * (5-2-1)
	 * 3 * (5-1-1)
	 * 2 * (5-0-1)
	 * 1 * (5-0)
	 * 5 4 3 2 1
	 * 5 
	 * 5 * (1-0)
	 * 4
	 * 4 * (2-0)
	 * 3
	 * 3 * (3-0)
	 * 2 
	 * 2 * (4-0)
	 * 1
	 * 1 * (5-0)
	 * 碰到这种序列题可以从递增或者递减序列推导
	 */
	public int largest(int[] array, int n) {
		int res = 0;
		//用来保存递增序列
		Deque<Integer> stk = new LinkedList<>();
		//如果是递增序列，i==array.length触发弹栈动作
		for(int i=0; i<=array.length; i++) {
			//cur用来比较，因为array[i]始终为非负数，所以可设置为0
			int cur = (i==array.length?0:array[i]);
			//弹栈动作直到遇到小于当前数的数
			while(!stk.isEmpty() && cur<=array[stk.peekFirst()]) {
				//长方形高度为栈顶元素，并且弹栈
				int height = array[stk.pollFirst()];
				//长方形左边为0或者栈顶+1
				int left = stk.isEmpty()?0:stk.peekFirst()+1;
				res = Math.max(res, height*(i-left));
			}
			//把当前元素压栈
			stk.push(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution198 ss = new Solution198();
		int[] array = new int[]{2,1,3,3,4};
		System.out.println(ss.largest(array));
		System.out.println(ss.largest(array, 5));
	}
}
