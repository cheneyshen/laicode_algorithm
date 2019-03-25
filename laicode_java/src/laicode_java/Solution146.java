package laicode_java;

import java.util.*;

//    Find Number of BSTs Generated
//    Find the number of different Binary Search Trees generated from 1-n.
//
//Example:
//
//Input: 3, Return: 5
/* M[i]����i����������ɶ��ٸ�BST
 * M[i]=sum(M[j-1]*M[i-j])
 *    1       2       3
 *  M1  M3  M1  M3  M2  M1
 */
public class Solution146 {
	public int numOfTrees(int n) {
		/*
		 * 动态规划
		 * 0 -> 0
		 * 1 -> 1
		 * 如果2个以上，抽出一个做root,
		 * 那么 func(i) += func(j) + func(i-j-1)
		 */
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int[] result= new int[n+1];
		result[0]=1;
		result[1]=1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				result[i] += result[j]*result[i-j-1];
			}
		}
		return result[n];
	}

	public static void main(String[] args) {
		Solution146 ss = new Solution146();
		System.out.println(ss.numOfTrees(3));
	}
}
