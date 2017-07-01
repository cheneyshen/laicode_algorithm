package laicode_java;
import java.util.*;

//Kth smallest in two sorted arrays
public class Solution115 {
	public int kth(int[] a, int[] b, int k) {
		return helper(a, 0, b, 0, k);
	}
	
	private int helper(int[] a, int ai, int[] b, int bi, int k) {
		if(ai>=a.length) {
			return b[bi+k-1];
		}
		if(bi>=b.length) {
			return a[ai+k-1];
		}
		if(k==1) {
			return Math.min(a[ai], b[bi]);
		}
		int amid=ai+k/2-1;
		int bmid=bi+k/2-1;
		int aval=amid>=a.length?Integer.MAX_VALUE:a[amid];
		int bval=bmid>=b.length?Integer.MAX_VALUE:b[bmid];
		if(aval<bval) {
			return helper(a, amid+1, b, bi, k-k/2);
		}
		else {
			return helper(a, ai, b, bmid+1, k-k/2);
		}
	}
	
	public static void main(String[] args) {
		Solution115 s115 = new Solution115();
		int[] a={1, 4, 6};
		int[] b={2, 3};
		int result=s115.kth(a, b, 3);
		System.out.println(result);
		a=new int[]{1,2,3,4};
		b=new int[]{5};
		result=s115.kth(a, b, 5);
		System.out.println(result);
	}
}