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
	public void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		sort(s1, s2, s3, s1.size());
	}
	
	private void sort(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3, int length) {
		if(length<=1) {
			return;
		}
		int mid1 = length/2;
		int mid2 = length-mid1;
		for(int i=0; i<mid1; i++) {
			s2.push(s1.pop());
		}
		// use the other stacks to sort s2/s1.
		// after sorting the numbers in s2/s1 are in ascending order
		// from top to bottom in the two stacks
		sort(s2, s1, s3, mid1);
		sort(s1, s2, s3, mid2);
		int i=0, j=0;
		while(i<mid1 && j<mid2) {
			if(s2.peek() < s1.peek()) {
				s3.push(s2.pop());
				i++;
			} else {
				s3.push(s1.pop());
				j++;
			}
		}
		while(i<mid1) {
			s3.push(s2.pop());
			i++;
		}
		while(j<mid2) {
			s3.push(s1.pop());
			j++;
		}
		// after merging, the numbers are in descending order from top to bottom in s3,
		// we need to push them back to s1 so that they are in ascending order
		for(int index=0; index<length; index++) {
			s1.push(s3.pop());
		}
	}
	
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		for(int i=0; i<=n; i++) {
			dp[i] = i;
			for(int j=0; i-j*j>=0; j++) {
				if(dp[i-j*j] + 1 < dp[i]) {
					dp[i] = dp[i-j*j]+1;
				}
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Solution279 ss = new Solution279();
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(7);
		st.push(6);
		st.push(1);
		st.push(4);
		st.push(2);
		st.push(3);
		ss.sort(st);
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}
}
