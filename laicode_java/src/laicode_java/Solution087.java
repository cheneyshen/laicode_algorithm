package laicode_java;

import java.util.*;
/*Max Product Of Cutting Rope
Given a rope with positive integer - length n, how to cut the rope into m integer - length parts with length p[0], p[1], ..., p[m - 1], in order to get the maximal product of p[0] * p[1] * ... *p[m - 1] ? m is determined by you and must be greater than 0 (at least one cut must be made).Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).*/

public class Solution087 {

	public int maxProduct(int n) {
		if(n<2) {
			return 0;
		}
		int result=0;
		for(int i=1; i<n; i++) {
			int best=Math.max(n-i, maxProduct(n-i));
			result=Math.max(best*i, result);
		}
		return result;
	}
	
	public int maxProduct(int n, int b) {
		int[] product=new int[n+1];
		product[0]=0;
		product[1]=0;  //at least one cut must be made
		for(int i=1; i<=n; i++) {
			int temp=0;
			for(int j=1; j<=i/2; j++) {
				temp=Math.max(temp, Math.max(j, product[j])*Math.max(i-j, product[i-j]));
			}
			product[i]=temp;
		}
		return product[n];
	}
	
	public static void main(String[] args) {


	}
}
