package laicode_java;

import java.util.*;

//    Spiral Order Generate I
//    Generate an N * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, 鈥�, N * N in increasing order.
//
//    Assumptions
//
//    N >= 0
//    Examples
//
//    N = 3, the generated matrix is
//
//    { {1,  2,  3}
//
//        {8,  9,  4},
//
//        {7,  6,  5} }
public class Solution123 {
	public int[][] spiralGenerate(int n) {
		int[][] result=null;
		if(n==1) {
			result=new int[1][1];
			result[0][0]=1;
			return result;
		}
	    result = new int[n][n];
	    helper(0, n, 1, result);
	    return result;
	}
	
	private void helper(int offset, int size, int curr, int[][] result) {
		if (size==0) {
			return;
		} else if (size==1) {
			result[offset][offset]=curr++;
			return;
		}
		for (int i=0; i<size-1; i++) {
			result[0+offset][i+offset]=curr++;
		}
		for (int i=0; i<size-1; i++) {
			result[i+offset][size-1+offset]=curr++;
		}
		for (int i=size-1; i>0; i--) {
			result[size-1+offset][i+offset]=curr++;
		}
		for (int i=size-1; i>0; i--) {
			result[i+offset][0+offset]=curr++;
		}
		helper(offset+1, size-2, curr, result);
	}
	
	public static void main(String[] args) {
		Solution123 ss = new Solution123();
		int[][] result=ss.spiralGenerate(3);
		System.out.println(Arrays.toString(result));
	}
}
