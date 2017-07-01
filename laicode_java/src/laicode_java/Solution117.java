package laicode_java;
import java.util.*;

//Maximum Values Of Size K Sliding Windows
//Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.
//
//Assumptions
//
//The given array is not null and is not empty
//
//K >= 1, K <= A.length
//
//Examples
//
//A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
//
//and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
public class Solution117 {
	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> max=new ArrayList<Integer>();
		Deque<Integer> deque=new LinkedList<Integer>();
		for(int i=0;i<array.length;i++) {
			while(!deque.isEmpty() && array[deque.peekLast()]<=array[i]) {
				deque.pollLast();
			}
			while(!deque.isEmpty() && deque.peekFirst()<=i-k) {
				deque.pollFirst();
			}
			deque.offer(i);
			if(i>=k-1) {
				max.add(array[deque.peekFirst()]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Solution117 s117 = new Solution117();
		int[] array={1, 2, 3, 2, 4, 2, 1};
		List<Integer> result=s117.maxWindows(array, 3);
		System.out.println(result);
		array=new int[]{2,1,3,6,2,3,2,4,1,5,2,7,6,8,1,4};
		result=s117.maxWindows(array, 3);
		System.out.println(result);
	}
}