package laicode_java;

import java.util.*;

//Most Points On A Line
//Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can be crossed by a single line in 2D space.
//
//Assumptions
//
//The given array is not null and it has at least 2 points
//Examples
//
//<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
public class Solution216 {
	class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public int most(Point[] points) {
		int res = 0;
		//对所有点进行排序，从左往右扫
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				if(a.x == b.x) {
					return a.y-b.y;
				} else {
					return a.x-b.x;
				}
			}
		});
		for(int i=0; i<points.length-1; i++) {
			Point seed = points[i];
			int same = 1; // 同一个点
			int sameX = 1; //同一个X坐标的点
			int most = 0; //用一个斜率的点
			Map<Double, Integer> map = new HashMap<>();
			for(int j=i+1; j<points.length; j++) {
				if(points[j].x == seed.x && points[j].y == seed.y) {
					same++;	//同一个点
				} else if(points[j].x == seed.x) {
					sameX++;	//同一个X坐标
				} else {
					//算斜率
					double cur = (points[j].y-seed.y+0.0)/(points[j].x-seed.x+0.0);
					map.put(cur, map.getOrDefault(cur, 0)+1);
					most = Math.max(most, map.get(cur));
				}
			}
			//刷新most， 因为same既可以被归为sameX, 也可以被归为某斜率中,所以单独算
			most = Math.max(most, sameX) + same;
			//刷新结果值
			res = Math.max(res, most);
		}
		return res;
	}
	
	public static void main(String[] args) {
	}
}
