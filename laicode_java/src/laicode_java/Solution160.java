package laicode_java;

import java.util.*;

//Climbing Stairs
//There are in total n steps to climb until you can reach the top. You can climb 1 or 2 steps a time. Determine the number of ways you can do that.
//  
//  Example:
//  
//  Input: n = 4, Return 5.
public class Solution160 {
	/* 0 1 
	 * 1
	 * 0 1 2 
	 * 1 1 0
	 * 2 0 0
	 * 0 1 2 3
	 * 1 1 1 0
	 * 2 0 1 0
	 * 1 2 0 0
	 * 0 1 2 3 4 
	 * 1 1 1 1 0
	 * 1 2 0 1 0
	 * 1 1 2 0 0 
	 * 2 0 2 0 0
	 * 2 0 1 1 0
	 */
	public int stairs(int n) {
		if(n<=0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else if(n==2) {
			return 2;
		}
		/*
		 * 动态规划，依赖于前两个结果
		 * table[i] = table[i-1]+table[i-2]
		 */
		int[] table = new int[n];
		table[0]=1;
		table[1]=2;
		for(int i=2; i<n; i++) {
			table[i]=table[i-1]+table[i-2];
		}
		return table[n-1];
	}
	
	public static void main(String[] args) {
		Solution160 ss = new Solution160();
		System.out.println(ss.stairs(4));
		System.out.println(ss.stairs(5));
	}
}
