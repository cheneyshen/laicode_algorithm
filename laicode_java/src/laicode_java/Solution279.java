package laicode_java;

import java.util.*;

//Sort With 3 Stacks
//Given one stack with integers, sort it with two additional stacks (total 3 stacks).
//
//After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
//Assumptions:
//The given stack is not null.
//Requirements:
//No additional memory, time complexity = O(nlog(n)).
public class Solution279 {
	/*	
	 * 	5 6
	 *  1 4 2 3
	 */
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		sort(s1, s2, s3, s1.size());
	}
	
	private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
		if(length<=1) {
			return;
		}
		int mid1 = length/2;
		int mid2 = length-mid1;
		for(int i=0; i<mid1; i++) {
			s2.offerFirst(s1.pollFirst());
		}
		// use other stacks to sort s2/s1.
		// after sorting the numbers in s2/s1 are in ascending order
		// from top to bottom in the two stacks
		sort(s2, s1, s3, mid1);
		sort(s1, s2, s3, mid2);
		int i=0, j=0;
		while(i<mid1 && j<mid2) {
			if(s2.peekFirst() < s1.peekFirst()) {
				s3.offerFirst(s2.pollFirst());
				i++;
			} else {
				s3.offerFirst(s1.pollFirst());
				j++;
			}
		}
		while(i<mid1) {
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		while(j<mid2) {
			s3.offerFirst(s1.pollFirst());
			j++;
		}
		// after merging, the numbers are in descending order from top to bottom in s3,
		// we need to push them back to s1 so that they are in ascending order
		for(int index=0; index<length; index++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
