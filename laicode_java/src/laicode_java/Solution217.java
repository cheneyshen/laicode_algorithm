package laicode_java;

import java.util.*;
//Largest Set Of Points With Positive Slope
//Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.
//
//Assumptions
//The given array is not null
//Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
//Examples
//<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
public class Solution217 {
	static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int largest(Point[] points) {
		if(points==null || points.length<1) {
			return 0;
		}
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.x == o2.x) {
					return o1.y-o2.y;
				} else {
					return o1.x-o2.x;
				}
			}
			
		});
		//每个点都给记录一个最大的Positive Slope
		int[] longest = new int[points.length];
		int res = 0;
		//为什么从0开始？我们规定1个点也是合理的解,最后结果如果是1则返回0，做特殊处理
		for(int i=0; i<points.length; i++) {
			int max = 0;
			//对每个点从左边开始算斜率，induction rule是依赖左边的点的
			for(int j=0; j<i; j++) {
				if(points[i].x>points[j].x && points[i].y>points[j].y) {
					max = Math.max(max, longest[i]);
				}
			}
			//所以找出最左边的最大的值，再+1得到新的值
			longest[i] = max+1;
			res = Math.max(res, longest[i]);
		}
		//结果只有一个点就返回0
		return res==1 ? 0 : res;
	}
	
	public static void main(String[] args) {
	}
}
