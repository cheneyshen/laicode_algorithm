package laicode_java;

import java.util.*;

//Possible Paths with Obstacles
//There is a robot on top left corner of the matrix, it can only move down or right. The matrix is represented by either 0(path) or 1(obstacle). For obstacle, robot can not move through. Find the number of possible ways for robot to move to right down corner.
//  
//  Input:    [
//             
//             [0,0,0],
//             
//             [0,1,0],
//             
//             [0,0,0]
//             
//             ]
//  
//  Output: 2
public class Solution165 {
	public int paths(int[][] grid) {
		if(grid==null || grid.length==0) {
			return 0;
		}
		int m=grid.length, n=grid[0].length;
		int[][] path = new int[m][n];
		for(int i=0; i<m; i++) {
			Arrays.fill(path[i], 0);
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]==0) {
					if(i==0 && j==0) {
						path[i][j]=1;
					} else if(i==0) {
						path[i][j]=path[i][j-1];
					} else if(j==0) {
						path[i][j]=path[i-1][j];
					} else {
						path[i][j]=path[i-1][j]+path[i][j-1];
					}
				}
			}
		}
		return path[m-1][n-1];
	}
	
	public static void main(String[] args) {
		Solution165 ss = new Solution165();
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(ss.paths(grid));
	}
}
