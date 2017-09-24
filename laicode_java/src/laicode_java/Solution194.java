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
	class Triple implements Comparable<Triple>{
		public int i1, i2, i3;
		Triple(int i1, int i2, int i3) {
			this.i1=i1;
			this.i2=i2;
			this.i3=i3;
		}
		@Override
		public int compareTo(Triple arg0) {
			long ea = this.i1*this.i1+this.i2*this.i2+this.i3*this.i3;
			long eb = arg0.i1*arg0.i1+arg0.i2*arg0.i2+arg0.i3*arg0.i3;
			return (int) (ea-eb);
		}
	}
	
	public List<Integer> closet(int[] a, int[] b, int[] c, int k) {
		if(a==null || b==null || c==null) {
			return null;
		}
		int aleng=a.length;
		int bleng=b.length;
		int cleng=c.length;
		if(aleng<1 || bleng<1 || cleng<1) {
			return null;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		PriorityQueue<Triple> queue = new PriorityQueue<Triple>(11);
		for(int x=0; x<aleng && x<k; x++) {
			for(int y=0; y<bleng && y<k; y++) {
				for(int z=0; z<cleng && z<k; z++) {
					Triple curr = new Triple(a[x], b[y], c[z]);
					queue.add(curr);
				}
			}
		}
		Triple curr = null;
		while(!queue.isEmpty() && k>0) {
			curr = queue.poll();
			k--;
		}
		List<Integer> result=new ArrayList<Integer>();
		result.add(curr.i1);
		result.add(curr.i2);
		result.add(curr.i3);
		return result;
	}
	
	public static void main(String[] args) {
		Solution194 ss = new Solution194();
		int[] a = new int[]{1,3,5};
		int[] b = new int[]{2,4};
		int[] c = new int[]{3,6};
		System.out.println(ss.closet(a, b, c, 2));
	}
}
