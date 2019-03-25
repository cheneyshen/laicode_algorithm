package laicode_java;

import java.util.*;

//    Kth Smallest Sum In Two Sorted Arrays
//    Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.
//
//    Assumptions
//
//    A is not null and A is not of zero length, so as B
//    K > 0 and K <= m * n
//    Examples
//
//    A = {1, 3, 5}, B = {4, 8}
//
//    1st smallest s is 1 + 4 = 5
//    2nd smallest s is 3 + 4 = 7
//    3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
//    5th smallest s is 3 + 8 = 11
public class Solution027 {
	class Node {
		int x, y, val;
		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	int kthSum(int[] a, int[] b, int k) {
		PriorityQueue<Node> myque=new PriorityQueue<Node>(k, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int a1=o1.val;
				int b1=o2.val;
				if(a1==b1) {
					return 0;
				}
				return a1>b1?1:-1;
			}
		});
		//一次性把A的所有元素都扔到优先队列里
		//为什么这样做？可以一次性初始化很多
		for(int i=0; i<a.length; i++) {
			myque.offer(new Node(i, 0, a[i]+b[0]));
		}
		while(!myque.isEmpty()) {
			k--;
			Node cur = myque.poll();
			if(k==0) {
				return cur.val;
			}
			//这时根据弹出的A中元素再去组合新的Node
			if(cur.y+1 < b.length) {
				myque.offer(new Node(cur.x, cur.y+1, a[cur.x]+b[cur.y+1]));
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {


	}
}
