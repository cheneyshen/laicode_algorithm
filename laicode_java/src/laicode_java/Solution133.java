package laicode_java;

import java.util.*;

//    Merge K Sorted Array
//    Merge K sorted array into one big sorted array in ascending order.
//
//    Assumptions
//
//    The input arrayOfArrays is not null, none of the arrays is null either.
public class Solution133 {
	static class Node {
		int x, y, value;
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public int[] merge(int[][] arrayOfArrays) {
		if(arrayOfArrays==null || arrayOfArrays.length<1) {
			return new int[0];
		}
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new MyComparator());
		for(int i=0; i<arrayOfArrays.length; i++) {
			if(arrayOfArrays[i].length>0) {
				minHeap.offer(new Node(arrayOfArrays[i][0], i, 0));
			}
		}
		List<Integer> res = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			Node cur = minHeap.poll();
			res.add(cur.value);
			if(cur.y+1<arrayOfArrays[cur.x].length) {
				minHeap.offer(new Node(arrayOfArrays[cur.x][cur.y+1], cur.x, cur.y+1));
			}
		}
		int[] output = new int[res.size()];
		for(int i=0; i<res.size(); i++) {
			output[i] = res.get(i);
		}
		return output;
	}
	
	private static class MyComparator implements Comparator<Node> {
		@Override
		public int compare(Node e1, Node e2) {
			if (e1.value==e2.value) {
				return 0;
			}
			return e1.value<e2.value?-1:1;
		}
	}
	
	public static void main(String[] args) {


	}
}
