package laicode_java;

import java.util.*;

//Minimum Path Sum
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//Input: [
//  
//  [5, 1, 2, 4],
//  
//  [4, 1, 0, 1],
//  
//  [0, 3, 7, 6]
//  
//  ]    
//
//Output: 14
public class Solution164 {
	public int minPathSum(int[][] grid) {
		if(grid==null || grid.length==0) {
			return 0;
		}
		int m=grid.length, n=grid[0].length;
		int[][] result = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 && j==0) {
					result[i][j]=grid[i][j];
				} else if(i==0) {
					result[i][j] = grid[i][j] + result[i][j-1];
				} else if(j==0) {
					result[i][j] = grid[i][j] + result[i-1][j];
				} else {
					result[i][j]=Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
				}
			}
		}
		return result[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] result = 
			{ {5, 1, 2, 4},
			 {4, 1, 0, 1},
			 {0, 3, 7, 6} };
		Solution164 ss = new Solution164();
		System.out.println(ss.minPathSum(result));
	}
}
