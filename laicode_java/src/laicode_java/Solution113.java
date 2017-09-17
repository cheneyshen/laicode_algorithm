package laicode_java;

import java.util.*;

//    Median Tracker
//    Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
//
//    You will have to implement the following two methods for the class
//
//        read(int value) - read one value from the flow
//        median() - return the median at any time, return null if there is no value read so far
//            Examples
//
//            read(1), median is 1
//            read(2), median is 1.5
//            read(3), median is 2
//            read(10), median is 2.5
//            ......
public class Solution113 {
	private PriorityQueue<Integer> smaller;
	private PriorityQueue<Integer> bigger;
	
	public Solution113() {
		bigger = new PriorityQueue<Integer>();
		smaller = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	}
	
	public void read(int value) {
		if(smaller.isEmpty() || value<= smaller.peek()) {
			smaller.offer(value);
		} else {
			bigger.offer(value);
		}
		if(smaller.size() - bigger.size() >= 2) {
			int temp = smaller.poll();
			bigger.offer(temp);
		} else if (bigger.size() > smaller.size()) {
			int temp = bigger.poll();
			smaller.offer(temp);
		}
	}
	
	public Double median() {
		int size=size();
		if(size==0) {
			return null;
		} else if(size%2 == 0) {
			return (double)(smaller.peek() + bigger.peek())/2.0;
		} else {
			return (double)(smaller.peek());
		}
	}
	
	private int size() {
		return smaller.size() + bigger.size();
	}
	
	public static void main(String[] args) {


	}
}
