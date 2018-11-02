package laicode_java;

import java.util.*;

//Longest Substring Without Repeating Characters
//Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
//
//For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
public class Solution253 {
	public int longest(String input) {
		int leng=input.length();
		if(leng<=1) {
			return leng;
		}
		int result=0;
		HashMap<Character, Integer> dict = new HashMap<>();
		for(int slow=0, fast=0; fast<leng; fast++) {
			char curr = input.charAt(fast);
			if(dict.containsKey(curr)==false) {
				dict.put(curr, 1);
			} else {
				dict.put(curr, dict.get(curr));
			}
			if(dict.get(curr)>1) {
				while(dict.get(curr)>1) {
					dict.put(input.charAt(slow), dict.get(input.charAt(slow)));
					slow++;
				}
			} else {
				result = Math.max(result, fast-slow+1);
			}
		}
		return result;
	}
	
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0) {
        	return 0;
        }
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for(int i=0; i<intervals.length; i++) {
        	start[i] = intervals[i].start;
        	end[i] = intervals[i].end;
        }
        Arrays.sort(end, new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return a-b;
        	}
        });
        Arrays.sort(start, new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return a-b;
        	}
        });
        int starts = 0, ends = 0;
        int used = 0;
        while(starts<intervals.length) {
        	if(start[starts] >= end[ends]) {
        		used -=1;
        		ends +=1;
        	}
        	used += 1;
        	starts += 1;
        }
        return used;
    }
	
	public static void main(String[] args) {


	}
}
