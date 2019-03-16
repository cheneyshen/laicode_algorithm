package laicode_java;

import java.util.*;

//Generate Random Maze
//Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.
//
//Assumptions
//
//N = 2K + 1 and K >= 0
//the top left corner must be corridor
//there should be as many corridor cells as possible
//for each pair of cells on the corridor, there must exist one and only one path between them
//  Examples
//  
//  N = 5, one possible maze generated is
//  0  0  0  1  0
//  1  1  0  1  0
//  0  1  0  0  0
//  0  1  1  1  0
//  0  0  0  0  0

/*  0  1  0  1  0
 *  0  0  
 *  1  
 */
public class Solution218 {
	int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	
	public int[][] maze(int n) {
		
		int[][] result=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 && j==0) {
					result[i][j]=0;
				}
				else {
					result[i][j]=1;
				}
			}
		}
		generate(result, 0, 0);
		return result;
	}
	
	private void generate(int[][] matrix, int x, int y) {
		int[][] newdirs = dirs;
		shuffle(newdirs);
		for(int[] dir : newdirs) {
			int newx = dir[0]*2+x;
			int newy = dir[1]*2+y;
			if(isValidWall(matrix, newx, newy)) {
				matrix[dir[0]+x][dir[1]+y] = 0;
				matrix[newx][newy] = 0;
				generate(matrix, newx, newy);
			}
		}
	}
	
	private void shuffle(int[][] array) {
		int leng = array.length;
		for(int i=0; i<leng; i++) {
			int cur = (int)(Math.random()*(leng-i));
			int[] tmp = array[i];
			array[i] = array[i+cur];
			array[cur+i] = tmp;
		}
	}
	
	private boolean isValidWall(int[][] matrix, int x, int y) {
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]==1;
	}
	
	public static void main(String[] args) {
		Solution218 ss = new Solution218();
		int[][] result = ss.maze(5);
		for(int i=0; i<5; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
