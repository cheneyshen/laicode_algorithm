package laicode_java;

//Generalized Reservoir Sampling
//Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 
//
//Assumptions
//
//k >= 1
//You will implement two methods for a sampling class:
//
//read(int value) - read one number from the flow
//sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
//You may need to add more fields for the class.
import java.util.*;
public class Solution157 {
	  private final int k;
	  
	  public Solution157(int k) {
	    // Complete the constructor if necessary.
	    this.k = k;
	  }
	  
	  public void read(int value) {
	    // Write your implementation here.
	  }
	  
	  public List<Integer> sample() {
	    // Write your implementation here.
	    return new ArrayList<Integer>();
	  }
	}