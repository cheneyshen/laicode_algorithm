package laicode_java;

import java.util.*;

//Search In Sorted Matrix II
//Given a 2D matrix that contains integers only, which each row is sorted in ascending order and each column is also sorted in ascending order.
//
//Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
//
//Assumptions:
//
//The given matrix is not null.
//Examples:
/*	matrix = { {1, 2, 3}, 
 * 			   {2, 4, 5}, 
 * 			   {6, 8, 10} }
 */
//target = 5, return {1, 2}
//target = 7, return {-1, -1}
public class Solution268 {
	public List<Integer> search(int[][] matrix, int target) {
		if(matrix==null || matrix.length<1) {
			return null;
		}
		int rows = matrix.length, cols = matrix[0].length;
		List<Integer> result=new ArrayList<>();
		int i=0, j=cols-1;
		while(i<rows && j>=0) {
			int curr=matrix[i][j];
			if(curr==target) {
				result.add(i);
				result.add(j);
				return result;
			} else if(curr<target) {
				i++;
			} else {
				j--;
			}
		}
		result.add(-1); result.add(-1);
		return result;
	}
	
	public static void main(String[] args) {
		Solution268 ss = new Solution268();
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{2, 4, 5},
				{6, 8, 10}
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
