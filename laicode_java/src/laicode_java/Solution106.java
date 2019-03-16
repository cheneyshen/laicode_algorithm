package laicode_java;

import java.util.*;

//    Largest SubMatrix Sum
//    Given a matrix that contains integers, find the submatrix with the largest sum.
//
//    Return the sum of the submatrix.
//    Assumptions
//
//    The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
//    Examples
//
//      { {1, -2, -1, 4},
//        {1, -1,  1, 1},
//        {0, -1, -1, 1},
//        {0,  0,  1, 1} }
//
//    the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
public class Solution106 {
	public int largest(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0;
		}
		int rows=matrix.length, cols=matrix[0].length;
		int res=Integer.MIN_VALUE;
		for(int i=0; i<rows; i++) {
			int[] cur = new int[cols];
			for(int j=i; j<rows; j++) {
				add(cur, matrix[j]);
				res = Math.max(res, max(cur));
			}
		}
		return res;
	}
	
	private void add(int[] cur, int[] cols) {
		for(int i=0; i<cur.length; i++) {
			cur[i]+=cols[i];
		}
	}
	
	private int max(int[] cur) {
		int res = cur[0], tmp = cur[0];
		for(int i=1; i<cur.length; i++) {
			tmp = Math.max(tmp+cur[i], cur[i]);
			res = Math.max(tmp, res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution106 ss = new Solution106();
		int[][] matrix = {	{1, -2, -1, 4},
							{1, -1,  1, 1},
							{0, -1, -1, 1},
							{0,  0,  1, 1} };
		System.out.println(ss.largest(matrix));
	}
}
