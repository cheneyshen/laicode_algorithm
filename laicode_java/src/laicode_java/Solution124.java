package laicode_java;

import java.util.*;

//    Spiral Order Generate II
//    Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, 鈥�, M * N in increasing order.
//
//    Assumptions
//
//    M >= 0, N >= 0
//    Examples
//
//    M = 3, N = 4, the generated matrix is
//
//    { {1,  2,  3,  4}
//
//        {10, 11, 12, 5},
//
//        {9,  8,  7,  6} }
public class Solution124 {
	public int[][] solve(int m, int n) {
		if(m<=0 || n<=0) {
			return null;
		}
		else if(m==1) {
			int[][] result=new int[1][n];
			for(int i=0; i<n; i++) {
				result[0][i]=i+1;
			}
			return result;
		}
		else if(n==1) {
			int [][] result=new int[m][1];
			for(int i=0; i<m; i++) {
				result[i][0]=i+1;
			}
			return result;
		}
		int[][] result=new int[m][n];
		helper(result, 1, 0, m, n);
		return result;
	}
	
	private void helper(int[][] result, int curr, int offset, int m, int n) {
		if(m==0 || n==0) {
			return;
		}
		else if(m==1) {
			for(int i=0; i<n; i++) {
				result[m-1+offset][i+offset]=curr++;
			}
			return;
		}
		else if(n==1) {
			for(int i=0; i<m; i++) {
				result[i+offset][n-1+offset]=curr++;
			}
			return;
		}
		for(int i=0; i<n-1; i++) {
			result[0+offset][i+offset]=curr++;
		}
		for(int i=0; i<m-1; i++) {
			result[i+offset][n-1+offset]=curr++;
		}
		for(int j=n-1; j>0; j--) {
			result[m-1+offset][j+offset]=curr++;
		}
		for(int j=m-1; j>0; j--) {
			result[j+offset][0+offset]=curr++;
		}
		helper(result, curr, offset+1, m-2, n-2);
	}
	
	public static void main(String[] args) {
		Solution124 ss = new Solution124();
		int[][] result = ss.solve(3, 4);
		System.out.println(Arrays.toString(result));
	}
}
