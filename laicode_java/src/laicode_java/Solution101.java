package laicode_java;

import java.util.*;

//Largest Square Of 1s
//	Determine the largest square of 1s in a binary matrix(a binary matrix only contains 0 and 1), return the length of the largest square.

//	Assumptions

//	The given matrix is not null and guaranteed to be of size N * N, N >= 0
//	Examples

//{ { 0, 0, 0, 0 },       0 0 0 0
//{ 1, 1, 1, 1 },         1 1 1 1 
//{ 0, 1, 1, 1 },         0 1 2 2
//{ 1, 0, 1, 1 } }        1 0 1 1

//	the largest square of 1s has length of 2
public class Solution101 {
	public int largest(int[][] matrix) {
		if(matrix==null) {
			return 0;
		}
		int rows=matrix.length, cols=matrix[0].length;
		if(rows==0 || cols==0) {
			return 0;
		}
		int result=0;
		int[][] func = new int[rows][cols];
		for(int i=0; i<rows; i++) {
			Arrays.fill(func[i], 0);
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i==0 || j==0) {
					func[i][j]=matrix[i][j];
				}
				else if(matrix[i][j]==1) {
					func[i][j] =  Math.min(func[i-1][j-1], Math.min(func[i-1][j], func[i][j-1])) + 1;
				}
				result=Math.max(result, func[i][j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution101 ss = new Solution101();
		int[][] matrix= { { 0, 0, 0, 0 }, 
				{ 1, 1, 1, 1 },
				{ 0, 1, 1, 1 },
				{ 1, 0, 1, 1 } };
		System.out.println(ss.largest(matrix));
		int[][] matrix1 = {{1,1,1,1},
				{0,1,1,1},
				{1,1,1,1},
				{1,1,1,1}};
		System.out.println(ss.largest(matrix1));
	}
}
