package laicode_java;

import java.util.*;
//Largest Rectangle Of 1s
//	Determine the largest rectangle of 1s in a binary matrix(a binary matrix only contains 0 and 1), return the area.

//	Assumptions

//	The given matrix is not null and has size of M * N, M >= 0 and N >= 0
//	Examples

//{ { 0, 0, 0, 0 },           

//{ 1, 1, 1, 1 },

//{ 0, 1, 1, 1 },

//{ 1, 0, 1, 1 } }
/*
 * left show where is left most 1 
 * 0 0 0 0 
 * 0 0 0 0
 * 0 1 1 1
 * 0 0 2 2
 * right show where is right most 1 
 * 4 4 4 4
 * 4 4 4 4
 * 0 4 4 4
 * 1 0 4 4
 * height has how many 1s 
 * 0 0 0 0
 * 1 1 1 1
 * 0 2 2 2
 * 1 0 3 3
 */
//	the largest rectangle of 1s has area of 2 * 3 = 6
public class Solution102 {
	public int largest(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0;
		}
		int result=0;
		int m=matrix.length, n=matrix[0].length;
		int [] left=new int[n];
		int [] right=new int[n];
		int [] height=new int[n];
		Arrays.fill(left, 0);
		Arrays.fill(right, n);
		Arrays.fill(height, 0);
		for(int i=0; i<m; i++) {
			int curleft=0, curright=n;
			for(int j=0; j<n; j++) {
				if(matrix[i][j]==1) {
					left[j]=Math.max(curleft, left[j]);
					height[j]++;
				} else {
					left[j]=0; curleft=j+1;
					height[j]=0;
				}
			}
			for(int j=n-1; j>=0; j--) {
				if(matrix[i][j]==1) {
					right[j]=Math.max(curright, right[j]);
				} else {
					right[j]=n; curright=j;
				}
			}
			for(int j=0; j<n; j++) {
				result=Math.max(result, (right[j]-left[j])*height[j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution102 ss = new Solution102();
		int[][] matrix = { { 0, 0, 0, 0 },           
						   { 1, 1, 1, 1 },
						   { 0, 1, 1, 1 },
						   { 1, 0, 1, 1 }};
		System.out.println(ss.largest(matrix));
	}
}
