package laicode_java;

import java.util.*;

//Interval Subtraction
//Given two intervals i1 and i2, return the subtraction of i1 - i2.
//
//i1 - i2 is defined as the interval partitions in i1 but not in i2.
//
//Assumptions:
//
//The two given intervals are not null.
//Examples:
//
//i1 = [1, 10), i2 = [2, 5), i1 - i2 = [[1, 2), [5, 10)]
//
//i1 = [4, 6), i2 = [5, 8), i1 - i2 = [[4, 5)]
//

class Interval {
	public int start;
	public int end;
 	public Interval(int start, int end) {
 		this.start = start;
 		this.end = end;
	}
}

public class Solution362 {

	  public List<Interval> subtract(Interval i1, Interval i2) {
	    // Write your solution here.
	    return new ArrayList<Interval>();
	  }
	public static void main(String[] args) {


	}
}
