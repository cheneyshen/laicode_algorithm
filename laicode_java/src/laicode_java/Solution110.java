package laicode_java;

import java.util.*;

//    Generalized Reservoir Sampling
//    Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far.
//
//        Assumptions
//
//        k >= 1
//        You will implement two methods for a sampling class:
//
//            read(int value) - read one number from the flow
//            sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
//            You may need to add more fields for the class.
public class Solution110 {
	private int count;
	private int k;
	private List<Integer> set;
	public Solution110(int k) {
		if(k<=0) {
			throw new IllegalArgumentException("k<=0");
		}
		this.k = k;
		this.count = 0;
		this.set = new ArrayList<>();
	}
	
	public void read(int value) {
		count++;
		if(count<=k) {
			set.add(value);
		} else {
			int prob = (int)(Math.random()*count);
			if(prob < k) {
				set.set(prob, value);
			}
		}
	}
	
	public List<Integer> sample() {
		return this.set;
	}
	
	public static void main(String[] args) {


	}
}
