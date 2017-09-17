package laicode_java;

import java.util.*;
//Longest Cross Of 1s
//    Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
//
//    Return the arm length of the largest cross.
//
//    Assumptions
//
//    The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
//    Examples
//
//    { {0, 0, 0, 0},
//
//        {1, 1, 1, 1},
//
//        {0, 1, 1, 1},
//
//        {1, 0, 1, 1} }
//	   ups
/*     0 0 0 0
 *     1 1 1 1
 *     0 2 2 2
 *     1 0 3 3
 *     downs
 *     0 0 0 0
 *     1 2 3 3
 *     0 1 2 2
 *     1 0 1 1
 *     lefts
 *     0 0 0 0
 *     1 2 3 4
 *     0 1 2 3
 *     1 0 1 2
 *     rights
 *     0 0 0 0
 *     4 3 2 1
 *     0 3 2 1
 *     1 0 2 1  
 */
//    the largest cross of 1s has arm length 2.
public class Solution104 {
	public int longestCross(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0;
		}
		int rows=matrix.length, cols=matrix[0].length;
		int[][] ups=new int[rows][cols];
		int[][] downs=new int[rows][cols];
		int[][] lefts=new int[rows][cols];
		int[][] rights=new int[rows][cols];
		int result=0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(j==0) {
					lefts[i][j]=matrix[i][j];
				}
				else if(matrix[i][j]==1) {
					lefts[i][j]=lefts[i][j-1]+1;
				}
				if(i==0) {
					ups[i][j]=matrix[i][j];
				}
				else if(matrix[i][j]==1) {
					ups[i][j]=ups[i-1][j]+1;
				}
			}
		}
		for(int i=rows-1; i>=0; i--) {
			for(int j=cols-1; j>=0; j--) {
				if(j==cols-1) {
					rights[i][j]=matrix[i][j];
				}
				else if(matrix[i][j]==1){
					rights[i][j]=rights[i][j+1]+1;
				}
				if(rows-1==i) {
					downs[i][j]=matrix[i][j];
				}
				else if(matrix[i][j]==1) {
					downs[i][j]=downs[i+1][j]+1;
				}
			}
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				result=Math.max(result, Math.min(Math.min(lefts[i][j], rights[i][j]), Math.min(ups[i][j], downs[i][j])));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution104 ss = new Solution104();

		int[][] matrix = { {0, 0, 0, 0},
					{1, 1, 1, 1},
					{0, 1, 1, 1},
					{1, 0, 1, 1} };
		System.out.println(ss.longestCross(matrix));
	}
}
