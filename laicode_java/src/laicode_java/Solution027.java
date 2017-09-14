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
	class Pair {
		int first, second;
		public Pair(int first, int second) {
			this.first=first;
			this.second=second;
		}
	}
	
	class Combo {
		int a,b;
		public Combo(int a, int b) {
			this.a=a;
			this.b=b;
		}
		public String toString() {
			return String.valueOf(a)+" "+String.valueOf(b);
		}
	}
	
	class Node {
		Pair pa;
		Pair pb;
		public Node(Pair pa, Pair pb) {
			this.pa=pa;
			this.pb=pb;
		}
	}
	
	int kthSum(int[] a, int[] b, int k) {
		PriorityQueue<Node> myque=new PriorityQueue<Node>(k, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int a1=o1.pa.first+o1.pa.first;
				int b1=o2.pa.first+o2.pa.first;
				if(a1==b1) {
					return 0;
				}
				return a1>b1?1:-1;
			}
		});
		Set<String> myset=new HashSet<String>();
		int aleng=a.length;
		int bleng=b.length;
		int loop=k;
		if(aleng==0 || bleng==0) {
			return 0;
		}
		if(k<=0 || k>aleng*bleng) {
			return 0;
		}
		Pair aone=new Pair(a[0], 0);
		Pair bone=new Pair(b[0], 0);
		Node one=new Node(aone, bone);
		Combo newbo=new Combo(0, 0);
		myque.add(one);
		myset.add(newbo.toString());
		while(!myque.isEmpty()) {
			Node now=myque.poll();
			loop--;
			if(loop==0) {
				return now.pa.first+now.pb.first;
			}
			int aindex=now.pa.second;
			int bindex=now.pb.second;
			newbo=new Combo(aindex+1, bindex);
			if(aindex+1<aleng && myset.contains(newbo.toString())==false) {
				aone=new Pair(a[aindex+1], aindex+1);
				Node newone=new Node(aone, now.pb);
				myque.add(newone);
				myset.add(newbo.toString());
			}
			newbo=new Combo(aindex, bindex+1);
			if(bindex+1<bleng && myset.contains(newbo.toString())==false) {
				bone=new Pair(b[bindex+1], bindex+1);
				Node newtwo=new Node(now.pa, bone);
				myque.add(newtwo);
				myset.add(newbo.toString());
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {


	}
}
