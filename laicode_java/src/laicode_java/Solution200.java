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
	static class Element implements Comparable<Element> {
		public int i, j, height;
		public Element(int i, int j, int height) {
			this.i=i;
			this.j=j;
			this.height=height;
		}
		public Element() {
			this.i=0;
			this.j=0;
			this.height=0;
		}
		@Override
		public int compareTo(Element arg0) {
			return (int) (this.height-arg0.height);
		}
	}
	
	public int maxTrapped(int[][] matrix) {
		int m=matrix.length, n=matrix[0].length;
		if(m<3 || n<3) {
			return 0;
		}
		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Element> queue = new PriorityQueue<Element>();
		int result=0;
		Element ele = new Element();
		for(int i=0; i<m; i++) {
			ele = new Element(i, 0, matrix[i][0]);
			queue.add(ele);
			visited[i][0]=true;
			ele = new Element(i, n-1, matrix[i][n-1]);
			queue.add(ele);
			visited[i][n-1]=true;
		}
		for(int j=0; j<n; j++) {
			ele = new Element(0, j, matrix[0][j]);
			queue.add(ele);
			visited[0][j]=true;
			ele = new Element(m-1, j, matrix[m-1][j]);
			queue.add(ele);
			visited[m-1][j]=true;
		}
		while(!queue.isEmpty()) {
			ele = queue.poll();
			List<Element> neis = getNeis(ele, matrix, m, n, visited);
			for(int k=0; k<neis.size(); k++) {
				if(visited[neis.get(k).i][neis.get(k).j]==true) {
					continue;
				}
				visited[neis.get(k).i][neis.get(k).j]=true;
				result+=Math.max(ele.height-neis.get(k).height, 0);
				neis.get(k).height = Math.max(ele.height, neis.get(k).height);
				queue.add(neis.get(k));
			}
		}
		return result;
	}
	
	private List<Element> getNeis(Element ele, int[][] matrix, int m, int n, boolean[][] visited) {
		int i = ele.i;
		int j = ele.j;
		List<Element> result = new ArrayList<Element>();
		if(i+1<m) {
			result.add(new Element(i+1, j, matrix[i+1][j]));
		}
		if(j+1<n) {
			result.add(new Element(i, j+1, matrix[i][j+1]));
		}
		if(i-1>=0) {
			result.add(new Element(i-1, j, matrix[i-1][j]));
		}
		if(j-1>=0) {
			result.add(new Element(i, j-1, matrix[i][j-1]));
		}
		return result;
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
