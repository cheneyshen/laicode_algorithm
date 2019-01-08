package laicode_java;

import java.util.*;

//Largest Sum Of Valid Numbers
//Given a 2D array A[8][8] with all integer numbers if we take a number a[i][j], then we cannot take its 8 neighboring cells. How should we take the numbers to make their sum as large as possible.
//Assumptions
//  
//The given matrix is 8 * 8
//4 3 2 1 9 6 5 2
//5 8 7 6 7 4 3 1
//8 7 6 5 4 3 2 1
//5 6 7 8 9 4 3 8
//8 7 6 5 3 4 8 9
//2 3 4 5 6 5 2 8
//6 5 8 9 5 4 2 3
//5 8 7 1 4 3 5 8
public class Solution220 {
	public int largestSummary(int[][] matrix) {
		if(matrix==null || matrix.length!=8) {
			return 0;
		}
		int result=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				int[] current=new int[1];
				boolean[][] visited=new boolean[matrix.length][matrix[0].length];
				dfsHelper(matrix, i, j, visited, current);
				result = Math.max(result, current[0]);
			}
		}
		return result;
	}
	
	private void dfsHelper(int[][] matrix, int i, int j, boolean[][] visited, int[] current) {
		if(visited[i][j]==true) {
			return;
		}
		visited[i][j]=true;
		if(i-2>=0 && visited[i-2][j]==false) {
			current[0]+=matrix[i-2][j];
			dfsHelper(matrix, i-2, j, visited, current);
		}
		if(j-2>=0 && visited[i][j-2]==false) {
			current[0]+=matrix[i][j-2];
			dfsHelper(matrix, i, j-2, visited, current);
		}
		if(i+2<matrix.length && visited[i+2][j]==false) {
			current[0]+=matrix[i+2][j];
			dfsHelper(matrix, i+2, j, visited, current);
		}
		if(j+2<matrix[0].length && visited[i][j+2]==false) {
			current[0]+=matrix[i][j+2];
			dfsHelper(matrix, i, j+2, visited, current);
		}
 	}
	
	private long getID(long x, long w) {
		return x<0 ? (x+1)/w-1 : x/w;
	}
	
	public boolean containsNearByAlmostDuplicate(int[] nums, int k, int t) {
		if(t<0)	return false;
		Map<Long, Long> d = new HashMap<>();
		long w = (long)t+1;
		for(int i=0; i<nums.length; i++) {
			long m = getID(nums[i], w);
			if(d.containsKey(m)) {
				return true;
			}
			if(d.containsKey(m-1) && Math.abs(nums[i]-d.get(m-1))<w) {
				return true;
			}
			if(d.containsKey(m+1) && Math.abs(nums[i]-d.get(m+1))<w) {
				return true;
			}
			d.put(m, (long)nums[i]);
			if(i>=k) {
				d.remove(getID(nums[i-k], w));
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution220 ss = new Solution220();
		int[][] matrix = {{4, 3, 2, 1, 9, 6, 5, 2},
				{5, 8, 7, 6, 7, 4, 3, 1},
				{8, 7, 6, 5, 4, 3, 2, 1},
				{5, 6, 7, 8, 9, 4, 3, 8},
				{8, 7, 6, 5, 3, 4, 8, 9},
				{2, 3, 4, 5, 6, 5, 2, 8},
				{6, 5, 8, 9, 5, 4, 2, 3},
				{5, 8, 7, 1, 4, 3, 5, 8}};
		int result = ss.largestSummary(matrix);
		
		System.out.println(result);
		System.out.println(-0/5-1);
		System.out.println(3/5);
	}
}
