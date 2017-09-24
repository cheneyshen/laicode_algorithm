package laicode_java;

import java.util.*;

//Kth Smallest With Only 3, 5, 7 As Factors
//Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
//
//Assumptions
//K >= 1
//Examples
//the smallest is 3 * 5 * 7 = 105
//the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
//the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
//the 5th smallest is 3 ^ 3 * 5 * 7 = 945
public class Solution193 {
	public long Kth(int k) {
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		queue.add((long) (3*5*7));
		HashSet<Long> visited = new HashSet<Long>();
		visited.add((long)3*5*7);
		int index=k;
		while(index>1) {
			long curr = queue.poll();
			if(visited.contains(curr*3)==false) {
				queue.add(curr*3);
				visited.add((long)curr*3);
			}
			if(visited.contains(curr*5)==false) {
				queue.add(curr*5);
				visited.add((long)curr*5);
			}
			if(visited.contains(curr*7)==false) {
				queue.add(curr*7);
				visited.add((long)curr*7);
			}
			index--;
		}
		return queue.peek();
	}
	
	public static void main(String[] args) {
		Solution193 ss = new Solution193();
		System.out.println(ss.Kth(2));
		System.out.println(ss.Kth(3));
		System.out.println(ss.Kth(5));
	}
}
