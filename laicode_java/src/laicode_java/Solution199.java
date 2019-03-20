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
		if(array==null || array.length<2) {
			return result;
		}
		//需要两个变量根据短板效应从左右开始移动
		int left=0,right=array.length-1;
		//记录当前较小的高度值
		int curheight=0;
		while(left<right) {
			//如果左边小些
			if(array[left]<=array[right]) {
				//不断刷新短板高度，用较大的值好去计算盛的水
				curheight = Math.max(array[left], curheight);
				//送高度差给结果
				result += curheight-array[left];
				//移动左半部分
				left++;
			} else {
				//不断刷新短板高度，用较大的值好去计算盛的水
				curheight = Math.max(array[right], curheight);
				//送高度差给结果
				result += curheight-array[right];
				//移动右半部分				
				right--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution199 ss = new Solution199();
		int[] array = new int[]{1,3,2,4,1,3,2,4,3,2};
		System.out.println(ss.maxTrapped(array));
	}
}
