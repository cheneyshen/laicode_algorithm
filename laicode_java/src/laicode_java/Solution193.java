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
		Queue<Long> minheap = new PriorityQueue<Long>();
		Set<Long> seen = new HashSet<>();
		minheap.offer(3*5*7L);
		seen.add(3*5*7L);
		while(k>1) {
			long cur = minheap.poll();
			if(seen.add(cur*3)) {
				minheap.offer(cur*3);
			}
			if(seen.add(cur*5)) {
				minheap.offer(cur*5);
			}
			if(seen.add(cur*7)) {
				minheap.offer(cur*7);
			}
			k--;
		}
		return minheap.peek();
	}
	
	public static void main(String[] args) {
		Solution193 ss = new Solution193();
		System.out.println(ss.Kth(2));
		System.out.println(ss.Kth(3));
		System.out.println(ss.Kth(5));
	}
}
