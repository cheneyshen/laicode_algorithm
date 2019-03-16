package laicode_java;

import java.util.*;

//    Reservoir Sampling
//    Consider an unlimited flow of data elements. How do you sample one element from this flow, such that at any point during the processing of the flow, you can return a random element from the n elements read so far.
//
//        You will implement two methods for a sampling class:
//
//            read(int value) - read one number from the flow
//            sample() - return at any time the sample, if n values have been read, the probability of returning any one of the n values is 1/n, return null(Java)/INT_MIN(C++) if there is no value read so far
//                You may need to add more fields for the class.
public class Solution109 {
	private int count=0;
	private int result;	
	public Integer sample() {
		return this.result;
	}
	
	public void read(int i) {
		count++;
		int randomor = (int)(Math.random()*count);
        //randomor has the probability 1/count to be the 0th current sample
		if(randomor==0) {
			result=i;
		}
	}
	
	public static void main(String[] args) {


	}
}
