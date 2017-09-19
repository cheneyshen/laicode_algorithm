package laicode_java;

import java.util.*;

//    Spiral Order Traverse II
//    Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
//
//    Assumptions
//
//    The 2D array is not null and has size of M * N where M, N >= 0
//    Examples
//
//    { {1,  2,  3,  4},
//
//        {5,  6,  7,  8},
//
//        {9, 10, 11, 12} }
//
//    the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
public class Solution122 {
	public int[] spiral(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return new int[0];
		}
		int[] result=new int[matrix.length*matrix[0].length];
		spiralHelper(matrix, result, 0, 0, matrix.length, matrix[0].length);
		return result;
	}
	
	private void spiralHelper(int[][] matrix, int[] result, int curr, int offset, int m, int n) {
		if(m==0 || n==0) {
			return;
		}
		else if (m==1 && n==1) {
			result[curr++] = matrix[offset+m-1][offset+n-1];
			return;
		}
		else if (m==1) {
			for(int i=0; i<n; i++) {
				result[curr++] = matrix[offset+m-1][offset+i];
			}
			return;
		}
		else if (n==1) {
			for(int i=0; i<m; i++) {
				result[curr++] = matrix[offset+i][offset+n-1];
			}
			return;
		}
		for(int i=0; i<n-1; i++) {
			result[curr++] = matrix[0+offset][i+offset];
		}
		for(int i=0; i<m-1; i++) {
			result[curr++] = matrix[i+offset][n-1+offset];
		}
		for(int j=n-1; j>0; j--) {
			result[curr++] = matrix[m-1+offset][j+offset];
		}
		for(int j=m-1; j>0; j--) {
			result[curr++] = matrix[j+offset][0+offset];
		}
		spiralHelper(matrix, result, curr, offset+1, m-2, n-2);
	}
	public static void main(String[] args) {
		Solution122 ss = new Solution122();
		int[][] matrix = {
					{1,  2,  3,  4},
					{5,  6,  7,  8},
					{9, 10, 11, 12} };
		int[] result = ss.spiral(matrix);
		System.out.println(Arrays.toString(result));
	}
}
