package laicode_java;

import java.util.*;

//Array Hopper III
//	Given an array of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from that position(you can only jump towards the end of the array).Determine the minimum number of jumps you need to jump out of the array.

//	By jump out, it means you can not stay at the end of the array.Return - 1 if you can not do so.

//	Assumptions

//	The given array is not null and has length of at least 1.
//	Examples

//{ 1, 3, 2, 0, 2 }, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)

//{ 3, 2, 1, 1, 0 }, you are not able to jump out of array, return -1 in this case.
public class Solution090 {
	public int minJump(int[] array) {
		if(array.length==0) {
			return -1;
		}
		//记录跳到i所需要的最小的步数
		int len = array.length;
		int[] jumps = new int[len];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		for(int i=0; i<len; i++) {
			for(int j=array[i]; j>=0; j--) {
				//从当前i能跳到i+array[i]，那i+array[i]的步数就是i的+1
				if(jumps[i]!=Integer.MAX_VALUE) {
					if(i+j<len) {
						//没达到最后一个元素，刷新步数
						jumps[i+j]=Math.min(jumps[i+j], jumps[i]+1);
					} else {
						//直接返回
						return jumps[i]+1;
					}
				}
			}
		}
		//最后需要检查是不是Integer.MAX_VALUE
		if(array[len-1] != 0 && jumps[len-1]!=Integer.MAX_VALUE) {
			return jumps[len-1]+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,3,2,0,2};
		Solution090 solution = new Solution090();
		System.out.println(solution.minJump(array));
		
	}
}
