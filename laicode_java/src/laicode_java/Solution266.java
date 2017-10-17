package laicode_java;

import java.util.*;

//Merge Intervals
//Given a set of time intervals in any order, return the total length of the area covered by those intervals.
//
//Assumptions:
//
//The given array of intervals is not null.
//None of the intervals in the array is null.
//Examples:
//
//{<1,3>, <2,4>, <5,7>, <6,8> }. The total length returned is 6(<1,4> is covered and <5,8> is covered).
public class Solution266 {
	static class Interval {
		int start, end;
		Interval() {
			this.start = 0;
			this.end = 0;
		}
		Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals==null || intervals.size()<2) {
			return intervals;
		}
		List<Interval> result=new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				return a.start-b.start;
			}
		});
		int leng = intervals.size();
//		1 2 5 6
//		3 4 7 8
		Interval prev = new Interval();
		for(int i=0; i<leng; i++) {
			if(intervals.get(i).start>prev.end) {
				result.add(intervals.get(i));
				prev = intervals.get(i);
			} else {
				//intervals.get(i).start<=prev.end
				if(intervals.get(i).end>prev.end) {
					prev.end=intervals.get(i).end;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution266 ss = new Solution266();
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(8,8));
		intervals.add(new Interval(15,18));
		List<Interval> result = ss.merge(intervals);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).start+" "+result.get(i).end);
		}
	}
}
