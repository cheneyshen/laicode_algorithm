package laicode_java;

import java.util.*;

//Unique paths
//A robot is located at the top-left corner of a m x n grid(where m > 0 and n > 0).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
//
//How many possible unique paths are there?

public class Solution439 {
	public int uniquePaths(int m, int n) {
		Integer[][] map = new Integer[m][n];
		for(int i=0; i<m; i++) {
			map[i][0]=1;
		}
		for(int j=0; j<n; j++) {
			map[0][j]=1;
		}
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		return map[m-1][n-1];
	}
	
	public static void main(String[] args) {


	}
}
