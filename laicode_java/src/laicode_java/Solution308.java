package laicode_java;

import java.util.*;

//Least Insertions To Form A Palindrome
//Insert the least number of characters to a string in order to make the new string a palindrome. Return the least number of characters should be inserted.
//Assumptions:
//The given string is not null.
public class Solution308 {

	static int findMinInsertions(String str, int l, int h) {
		if (l>h)
		    return Integer.MAX_VALUE;
		if (l==h) {
		    return 0;
        }
        if (l==h-1) {
		    return str.charAt(l)==str.charAt(h)?0:1;
        }
        return (str.charAt(l)==str.charAt(h))?
                findMinInsertions(str, l+1, h-1) : (
                        Integer.min(findMinInsertions(str, l, h-1),
                                findMinInsertions(str, l+1, h))+1
                );
	}
	class NumMatrix {
		private int[][] colSums;
		private int[][] matrix;
		
		public NumMatrix(int[][] matrix) {
			if(matrix == null || matrix.length == 0 || matrix[0].length==0) {
				return;
			}
			this.matrix = matrix;
			int m = matrix.length;
			int n = matrix[0].length;
			colSums = new int[m+1][n];
			for(int i=1; i<=m; i++) {
				for(int j=0; j<n; j++) {
					colSums[i][j] = colSums[i-1][j] + matrix[i-1][j];
				}
			}
		}
		
		public void update(int row, int col, int val) {
			for(int i=row+1; i<colSums.length; i++) {
				colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
			}
			matrix[row][col] = val;
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			int ret = 0;
			for(int j=col1; j<=col2; j++) {
				ret+=colSums[row2+1][j] - colSums[row1][j];
			}
			return ret;
		}
	}
	public static void main(String[] args) {

        Solution308 ss = new Solution308();
        String str = "javaja";
        System.out.println("Least Insertions is "+ ss.findMinInsertions(str, 0, str.length()-1));

	}
}
