package laicode_java;

import java.util.*;

//Longest consecutive sequence
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [95, 5, 3, 93, 2, 91, 92, 4]
//The longest consecutive elements sequence is [2, 3, 4, 5]. Return its length: 4.
//

public class Solution447 {
	public int longestConsecutive(int[] num) {
		int res=0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n:num) {
			if(!map.containsKey(n)) {
				int left=(map.containsKey(n-1))?map.get(n-1):0;
				int right = (map.containsKey(n+1))?map.get(n+1):0;
				// sum: length of the sequence n is in
				int sum = left+right+1;
				map.put(n, sum);
				// keep track of the max length
				res = Math.max(res, sum);
				// extend the length to the boundary of the sequence
				// will do nothing if n has no neighbors
				map.put(n-left, sum);
				map.put(n+right, sum);
			} else {
				continue;
			}
		}
		return res;
	}
	public static void main(String[] args) {


	}
}
