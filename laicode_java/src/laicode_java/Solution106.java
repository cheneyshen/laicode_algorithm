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
		int[][] sumMatrix=new int[rows][cols];
		int result=Integer.MIN_VALUE;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(j==0) {
					sumMatrix[i][j]=matrix[i][j];
				}
				else {
					sumMatrix[i][j]=sumMatrix[i][j-1]+matrix[i][j];
				}
			}
		}
		for(int i=0; i<cols; i++) {
			for(int j=i; j<cols; j++) {
				int[] current = new int[rows];
				for(int k=0; k<rows; k++) {
					current[k] = sumMatrix[k][j]-sumMatrix[k][i];
				}
				result=Math.max(result, helper(current));
			}
		}
		return result;
	}
	
	private int helper(int[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		int[] sum = new int[array.length];
		int result=0;
		for(int i=0; i<array.length; i++) {
			if(i==0) {
				sum[i]=array[i];
			}
			else if(sum[i-1]>0){
				sum[i]=array[i]+sum[i-1];
			}
			result=Math.max(result, sum[i]);
		}
		return result;
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
