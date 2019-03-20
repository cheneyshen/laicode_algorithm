package laicode_java;

import java.util.*;

//Kth Closest Point To <0,0,0>
//Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.
//
//We are using euclidean distance here.
//
//Assumptions
//The three given arrays are not null or empty
//K >= 1 and K <= a.length * b.length * c.length
//Return
//a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
//Examples
//
//A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
//
//The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
//
//The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
public class Solution194 {
	class Triple implements Comparable<Triple> {
		private int i1, i2, i3;
		public Triple(int x, int y, int z) {
			this.i1 = x;
			this.i2 = y;
			this.i3 = z;
		}
		@Override
		public int compareTo(Triple o) {
			// TODO Auto-generated method stub
			long ea = this.i1*this.i1+this.i2*this.i2+this.i3*this.i3;
			long eb = o.i1*o.i1 + o.i2*o.i2 + o.i3*o.i3;
			return (int)(ea-eb);
		}
	}
	
	public List<Integer> closet(int[] a, int[] b, int[] c, int k) {
		if(a==null || b==null || c==null || a.length<1 || b.length<1 || c.length<1) {
			return null;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		Queue<Triple> que = new PriorityQueue<Triple>();
		for(int i=0; i<a.length && i<k; i++) {
			for(int j=0; j<b.length && j<k; j++) {
				for(int m=0; m<c.length && m<k; m++) {
					que.add(new Triple(a[i], b[j], c[m]));
				}
			}
		}
		Triple cur = null;
		List<Integer> res = new ArrayList<>();
		while(!que.isEmpty() && k>0) {
			cur = que.poll();
			k--;
		}
		if(k==0) {
			res.addAll(Arrays.asList(cur.i1, cur.i2, cur.i3));
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution194 ss = new Solution194();
		int[] a = new int[]{1,3,5};
		int[] b = new int[]{2,4};
		int[] c = new int[]{3,6};
		System.out.println(ss.closet(a, b, c, 2));
	}
}
