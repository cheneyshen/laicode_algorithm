package laicode_java;

import java.util.Arrays;

//Largest Rectangle Of 1s
//Determine the largest rectangle of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the area.
//
//Assumptions
//
//The given matrix is not null and has size of M * N, M >= 0 and N >= 0
//Examples
//
//{ {0, 0, 0, 0},
//
//  {1, 1, 1, 1},
//
//  {0, 1, 1, 1},
//
//  {1, 0, 1, 1} }
//
//the largest rectangle of 1s has area of 2 * 3 = 6

public class Solution155 {
	public int largest(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0;
		}
		int result=0, m=matrix.length, n=matrix[0].length;
		int[] left=new int[n];
		int[] right=new int[n];
		int[] height=new int[n];
		Arrays.fill(left, 0);
		Arrays.fill(right, n);
		Arrays.fill(height, 0);
		for(int i=0;i<m;i++) {
			int curleft=0, curright=n;
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==1) {
					height[j]++;
				}
				else {
					height[j]=0;
				}
			}
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==1) {
					left[j]=Math.max(curleft, left[j]);
				}
				else {
					left[j]=0;curleft=j+1;
				}
			}
			for(int j=n-1;j>=0;j--) {
				if(matrix[i][j]==1) {
					right[j]=Math.min(right[j], curright);
				}
				else {
					right[j]=n;curright=j;
				}
			}
			for(int j=0;j<n;j++) {
				result=Math.max(result, (right[j]-left[j])*height[j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution155 s155 = new Solution155();
		int[][] matrix = new int[][]{ {0, 0, 1, 0} };
		int result=s155.largest(matrix);
		System.out.println(result);
		matrix = new int[][]{ {0}, {1}, {1}, {0}};
		result=s155.largest(matrix);
		System.out.println(result);
		matrix = new int[][]{	{0, 0, 0, 0},
								{1, 1, 1, 1},
								{0, 1, 1, 1},
								{1, 0, 1, 1}	};
		result=s155.largest(matrix);
		System.out.println(result);
		matrix = new int[][]{{0,1,1,1},
							 {1,1,0,1},
							 {0,1,0,1},
							 {1,1,1,1}};
		result=s155.largest(matrix);
		System.out.println(result);

	}
}
