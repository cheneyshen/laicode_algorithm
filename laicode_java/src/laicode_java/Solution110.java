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
	private Integer sample;
	
	public Solution110() {
		this.count=0;
		this.sample=null;
	}
	
	public void read(int value) {
		count++;
		int prob = (int)(Math.random()*count);
		if(prob==0) {
			sample = value;
		}
	}
	
	public Integer sample() {
		return sample;
	}
	
	public static void main(String[] args) {


	}
}
