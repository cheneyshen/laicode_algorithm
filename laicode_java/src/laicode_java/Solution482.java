package laicode_java;

import java.util.*;

//Meeting Rooms
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//
//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return false.
public class Solution482 {
	class Interval {
		int start;
		int end;
		Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		for(int i=0; i<intervals.length-1; i++) {
			if(intervals[i].end >intervals[i+1].start) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
