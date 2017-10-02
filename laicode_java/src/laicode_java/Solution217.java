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
	class SortbyX implements Comparator<List<Integer>> {
		public int compare(List<Integer> a, List<Integer> b) {
			return a.get(0)-b.get(0);
		}
	}
	
	class SortbyY implements Comparator<List<Integer>> {
		public int compare(List<Integer> a, List<Integer> b) {
			return a.get(1)-b.get(1);
		}
	}
	
	public int most(List<List<Integer>> points) {
		if(points==null || points.size()<1) {
			return 0;
		}
		if(points.size()==1) {
			return 1;
		}
		int result=1;
		Collections.sort(points, new SortbyX());
		for(int i=0; i<points.size(); i++) {
			HashMap<Double, Integer> slope = new HashMap<>();
			int sameX=1;
			for(int j=i+1; j<points.size(); j++) {
				if(points.get(j).get(0)==points.get(i).get(0)) {
					sameX++;
					result = Math.max(result, sameX);
				}
				else if(points.get(j).get(1)>points.get(i).get(1)) {
					double degree = (points.get(j).get(1)-points.get(i).get(1)) / (points.get(j).get(0)-points.get(i).get(0));
					if(slope.containsKey(degree)) {
						slope.put(degree, slope.get(degree)+1);
					} else {
						slope.put(degree, 1);
					}
					result = Math.max(result, slope.get(degree));
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution217 ss = new Solution217();
		List<Integer> a = new ArrayList<>();
		a.add(0);a.add(0);
		List<Integer> b = new ArrayList<>();
		b.add(1);b.add(1);
//		List<Integer> c = new ArrayList<>();
//		c.add(2);c.add(2);
		List<Integer> d = new ArrayList<>();
		d.add(2);d.add(3);
		List<Integer> e = new ArrayList<>();
		e.add(3);e.add(3);
		List<List<Integer>> array=new ArrayList<>();
		array.add(a);
		array.add(b);
//		array.add(c);
		array.add(d);
		array.add(e);
		System.out.println(ss.most(array));
	}
}
