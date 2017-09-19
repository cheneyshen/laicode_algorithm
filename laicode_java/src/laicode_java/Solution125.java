package laicode_java;

import java.util.*;

//    Rotate Matrix
//    Rotate an N * N matrix clockwise 90 degrees.
//
//    Assumptions
//
//    The matrix is not null and N >= 0
//    Examples
//
//    { {1,  2,  3}
//
//        {8,  9,  4},
//
//        {7,  6,  5} }
//
//    after rotation is
//
//    { {7,  8,  1}
//
//        {6,  9,  2},
//
//        {5,  4,  3} }
public class Solution125 {
	public void solve(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return;
		}
		int leng=matrix.length;
		helper(matrix, 0, leng);
	}
	
	private void helper(int[][] matrix, int offset, int size) {
		if(size<=1) {
			return;
		}
		for(int i=0; i<size-1; i++) {
	        //0 0       -> 0 n-1       -> n-1 n-1       -> n-1 0
	        //0 1       -> 1 n-1       -> n-1 n-2       -> n-2 1
	        //0 2       -> 2 n-1       -> n-1 n-3       -> n-3 2
	        //....
	        //0 n-2     -> n-2 n-1     -> n-1 1         -> 1 0
	        // 1  2  3  4
	        // 5  6  7  8
	        // 9  10 11 12
	        // 13 14 15 16
	        // 13  9 5 1
	        // 14 10 6 2
	        // 15 11 7 3
	        // 16 12 8 4
			int temp = matrix[0+offset][i+offset];
			matrix[0+offset][i+offset] = matrix[size-1+offset-i][0+offset];
			matrix[size-1+offset-i][0+offset] = matrix[size-1+offset][size-1+offset-i];
			matrix[size-1+offset][size-1+offset-i] = matrix[i+offset][size-1+offset];
			matrix[i+offset][size-1+offset] = temp;
		}
	}
	
	public static void main(String[] args) {
		Solution125 ss = new Solution125();
		int[][] array = {{1,2,3},{8,9,4}, {7,6,5}};
		ss.solve(array);
		System.out.println(array);
	}
}
