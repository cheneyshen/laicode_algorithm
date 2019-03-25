package laicode_java;

import java.util.*;

//Disjoint White Objects
//In a 2D black image there are some disjoint white objects with arbitrary shapes, find the number of disjoint white objects in an efficient way.
//
//By disjoint, it means there is no white pixels that can connect the two objects, there are four directions to move to a neighbor pixel (left, right, up, down).
//
//Black is represented by 1’s and white is represented by 0’s.
//
//Assumptions
//
//The given image is represented by a integer matrix and all the values in the matrix are 0 or 1
//The given matrix is not null
//Examples
//
//the given image is
//
//0  0  0  1
//1  0  1  1
//1  1  0  0
//0  1  0  0
//
//there are 3 disjoint white objects.
public class Solution219 {
	final int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
	public int whiteObjects(int[][] matrix) {
		if(matrix==null || matrix.length<1 || matrix[0].length<1) {
			return 0;
		}
		int result=0, m=matrix.length, n=matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j]==0 && visited[i][j]==false) {
					result++;
					dfsHelper(matrix, i, j, m, n, visited);
				}
			}
		}
		return result;
	}
	
	private void dfsHelper(int[][] matrix, int i, int j, int m, int n, boolean[][] visited) {
		if(visited[i][j]==true) {
			return;
		}
		visited[i][j]=true;
		for(int[] dir:dirs) {
			int newi = dir[0]+i;
			int newj = dir[1]+j;
			if(newi>=0 && newi<m && newj>=0 && newj<n && visited[newi][newj]==false) {
				dfsHelper(matrix, newi, newj, m, n, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution219 ss = new Solution219();
		int[][] matrix = {{0,0,0,1},{1,0,1,1},{1,1,0,0},{0,1,0,1}};
		int result = ss.whiteObjects(matrix);
		System.out.println(result);
	}
}
