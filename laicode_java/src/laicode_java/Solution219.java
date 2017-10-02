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
	public int disJoints(int[][] matrix) {
		if(matrix==null || matrix.length<1) {
			return 0;
		}
		int result=0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j]==0 && visited[i][j]==false) {
					result++;
					dfsHelper(matrix, i, j, visited);
				}
			}
		}
		return result;
	}
	
	private void dfsHelper(int[][] matrix, int i, int j, boolean[][] visited) {
		if(visited[i][j]==true) {
			return;
		}
		visited[i][j]=true;
		if(i+1<matrix.length && matrix[i+1][j]==0 && visited[i+1][j]==false) {
			dfsHelper(matrix, i+1, j, visited);
		}
		if(i-1>=0 && matrix[i-1][j]==0 && visited[i-1][j]==false) {
			dfsHelper(matrix, i-1, j, visited);
		}
		if(j+1<matrix[0].length && matrix[i][j+1]==0 && visited[i][j+1]==false) {
			dfsHelper(matrix, i, j+1, visited);
		}
		if(j-1>=0 && matrix[i][j-1]==0 && visited[i][j-1]==false) {
			dfsHelper(matrix, i, j-1, visited);
		}
	}
	
	public static void main(String[] args) {
		Solution219 ss = new Solution219();
		int[][] matrix = {{0,0,0,1},{1,0,1,1},{1,1,0,0},{0,1,0,1}};
		int result = ss.disJoints(matrix);
		System.out.println(result);
	}
}
