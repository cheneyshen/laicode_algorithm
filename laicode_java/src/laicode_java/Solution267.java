package laicode_java;

import java.util.*;

//Search In Sorted Matrix I
//Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.
//
//Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
//
//Assumptions:
//
//The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
//Examples:
/*matrix = {{1, 2, 3},
 *  		{4, 5, 7}, 
 *  		{8, 9, 10} }
 */
//target = 7, return {1, 2}
//target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
public class Solution267 {
	public int[] search(int[][] matrix, int target) {
		if(matrix==null || matrix.length<1 || matrix[0].length<1) {
			return new int[2];
		}
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m*n-1;
		int[] res = new int[2];
		res[0] = -1; res[1] = -1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			int row = mid/n, col = mid%n;
			if(matrix[row][col]==target) {
				res[0]=row;res[1]=col;
				return res;
			} else if(matrix[row][col]>target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution267 ss = new Solution267();
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 7},
				{8, 9, 10}
		};
		System.out.println(ss.search(matrix, 1));
		System.out.println(ss.search(matrix, 2));
		System.out.println(ss.search(matrix, 3));
		System.out.println(ss.search(matrix, 4));
		System.out.println(ss.search(matrix, 5));
		System.out.println(ss.search(matrix, 6));
		System.out.println(ss.search(matrix, 7));
		System.out.println(ss.search(matrix, 8));
		System.out.println(ss.search(matrix, 9));
		System.out.println(ss.search(matrix, 10));
		System.out.println(ss.search(matrix, 11));

	}
}
