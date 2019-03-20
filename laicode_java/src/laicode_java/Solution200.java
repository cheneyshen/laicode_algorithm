package laicode_java;

import java.util.*;

import laicode_java.Solution194.Triple;

//    Max Water Trapped II
//    Given a non-negative integer 2D array representing the heights of bars in a matrix. Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.
//
//        Assumptions
//        The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values are non-negative integers in the matrix.
//        Examples
//
//      { { 2, 3, 4, 2 },
//        { 3, 1, 2, 3 },
//        { 4, 3, 5, 4 } }
//    the amount of water can be trapped is 3,
//
//    at position (1, 1) there is 2 units of water trapped,
//
//    at position (1, 2) there is 1 unit of water trapped.
public class Solution200 {
	//implements Comparable方便PriorityQueue
	static class Element implements Comparable<Element> {
		public int i, j, height;
		public Element(int i, int j, int height) {
			this.i=i;
			this.j=j;
			this.height=height;
		}
		@Override
		public int compareTo(Element arg0) {
			return (int) (this.height-arg0.height);
		}
	}
	int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
	public int maxTrapped(int[][] matrix) {
		if(matrix==null || matrix.length<1 || matrix[0].length<1) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		//用优先队列存最低水位
		Queue<Element> que = new PriorityQueue<>();
		boolean[][] seen = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				//周围四周所有点全部入队列, 同时访问标记
				if(i==0 || i==m-1 || j==0 || j==n-1) {
					que.offer(new Element(i, j, matrix[i][j]));
					seen[i][j] = true;
				}
			}
		}
		int res = 0;
		while(!que.isEmpty()) {
			Element cur = que.poll();
			for(int[] dir:dirs) {
				//算周围邻居，如果没被访问则更新水位
				int newx = dir[0]+cur.i;
				int newy = dir[1]+cur.j;
				if(seen[newx][newy] == false) {
					if(matrix[newx][newy]<cur.height) {
						res += Math.abs(matrix[newx][newy]-cur.height);
						matrix[newx][newy] = cur.height;
					}
				}
				seen[newx][newy] = true;
				//邻居入优先队列
				que.offer(new Element(newx, newy, matrix[newx][newy]));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution200 ss = new Solution200();
		int[][] matrix = new int[][] {
			{ 2, 3, 4, 2 },
			{ 3, 1, 2, 3 },
			{ 4, 3, 5, 4 }
		};
		System.out.println(ss.maxTrapped(matrix));
	}
}
