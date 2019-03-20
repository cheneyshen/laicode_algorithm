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
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if(matrix==null || matrix.length==0) {
			return res;
		}
		spiralHelper(matrix, res, 0, matrix.length, matrix[0].length);
		return res;
	}
	
	private void spiralHelper(int[][] matrix, List<Integer> result, int offset, int m, int n) {
		if(m==0 || n==0) {
			return;
		}
		if (m==1 && n==1) {
			result.add(matrix[offset+m-1][offset+n-1]);
			return;
		}
		if (m==1) {
			for(int i=0; i<n; i++) {
				result.add(matrix[offset+m-1][offset+i]);
			}
			return;
		}
		if (n==1) {
			for(int i=0; i<m; i++) {
				result.add(matrix[offset+i][offset+n-1]);
			}
			return;
		}
		for(int i=0; i<n-1; i++) {
			result.add(matrix[0+offset][i+offset]);
		}
		for(int i=0; i<m-1; i++) {
			result.add(matrix[i+offset][n-1+offset]);
		}
		for(int j=n-1; j>0; j--) {
			result.add(matrix[m-1+offset][j+offset]);
		}
		for(int j=m-1; j>0; j--) {
			result.add(matrix[j+offset][0+offset]);
		}
		spiralHelper(matrix, result, offset+1, m-2, n-2);
	}
	public static void main(String[] args) {
		Solution122 ss = new Solution122();
		int[][] matrix = {
					{1,  2,  3,  4},
					{5,  6,  7,  8},
					{9, 10, 11, 12} };
		List<Integer> result = ss.spiral(matrix);
		System.out.println(result);
	}
}
