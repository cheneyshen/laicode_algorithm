package laicode_java;

import java.util.*;

//    Common Numbers Of Two Sorted Arrays
//    Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
//
//    Assumptions
//    
//    In each of the two sorted arrays, there could be duplicate numbers.
//    Both two arrays are not null.
//    Examples
//    
//    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]

public class Solution072 {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> result=new ArrayList<>();
		int i=0, j=0;
		while(i<A.size() && j<B.size()) {
			if(A.get(i)== B.get(j)) {
				result.add(A.get(i));
				i++;j++;
			} else if(A.get(i)<B.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
