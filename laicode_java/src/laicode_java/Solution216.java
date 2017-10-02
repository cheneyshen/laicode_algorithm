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
	class SortbyX implements Comparator<List<Integer>> {
		public int compare(List<Integer> a, List<Integer> b){
			return a.get(0)-b.get(0);
		}
	}
	class SortbyY implements Comparator<List<Integer>> {
		public int compare(List<Integer> a, List<Integer> b){
			return a.get(1)-b.get(1);
		}
	}
	
	public int most(List<List<Integer>> points) {
		if(points==null || points.size()==0) {
			return 0;
		}
		if(points.size()==1) {
			return 1;
		}
		int result=1;
		Collections.sort(points, new SortbyX());
		for(int i=0; i<points.size(); i++) {
			HashMap<Double, Integer> degrees = new HashMap<>();
			int sameX=1;
			int sameOne=1;
			for(int j=i+1; j<points.size(); j++) {
				if(points.get(j).get(0)==points.get(i).get(0)) {
					if(points.get(j).get(1)==points.get(i).get(1)) {
						sameOne++;
						result = Math.max(result, sameOne);
					}
					else {
						sameX++;
						result = Math.max(result, sameX);
					}
				}
				else {
					double curr = (double)(points.get(j).get(1)-points.get(i).get(1)) / (points.get(j).get(0)-points.get(i).get(0));
					if(degrees.containsKey(curr)) {
						degrees.put(curr, degrees.get(curr)+1);
					}
					else {
						degrees.put(curr, 1);
					}
					result=Math.max(result, degrees.get(curr));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution216 ss = new Solution216();
		List<Integer> a = new ArrayList<>();
		a.add(0);a.add(0);
		List<Integer> b = new ArrayList<>();
		b.add(1);b.add(1);
		List<Integer> c = new ArrayList<>();
		c.add(2);c.add(2);
		List<Integer> d = new ArrayList<>();
		d.add(2);d.add(3);
		List<Integer> e = new ArrayList<>();
		e.add(3);e.add(3);
		List<List<Integer>> array=new ArrayList<>();
		array.add(a);
		array.add(b);
		array.add(c);
		array.add(d);
		array.add(e);
		System.out.println(ss.most(array));
	}
}
