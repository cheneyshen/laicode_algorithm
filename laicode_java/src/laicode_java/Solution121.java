package laicode_java;

import java.util.*;

//    Spiral Order Traverse I
//    Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
//
//    Assumptions
//
//    The 2D array is not null and has size of N * N where N >= 0
//    Examples
//
//    { {1,  2,  3},
//
//        {4,  5,  6},
//
//        {7,  8,  9} }
//
//    the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
public class Solution121 {
	public int[] spiral(int[][] input) {
		if(input==null || input.length==0) {
			return new int[0];
		}
		int[] result=new int[input.length*input[0].length];
		spiralHelper(input, result, 0, 0, input.length);
		return result;
	}
	
	private void spiralHelper(int[][] input, int[] result, int curr, int offset, int size) {
		if(size==1) {
			result[curr++]=input[0+offset][0+offset];
			return;
		} else if(size==0) {
			return;
		}
		for(int i=0; i<size-1; i++) {
			result[curr++] = input[0+offset][i+offset];
		}
		for(int i=0; i<size-1; i++) {
			result[curr++] = input[i+offset][size-1+offset];
		}
		for(int j=size-1; j>0; j--) {
			result[curr++] = input[size-1+offset][j+offset];
		}
		for(int j=size-1; j>0; j--) {
			result[curr++] = input[j+offset][0+offset];
		}
		spiralHelper(input, result, curr, offset+1, size-2);
	}
	
	public static void main(String[] args) {
		Solution121 ss = new Solution121();
		int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] result = ss.spiral(input);
		System.out.println(Arrays.toString(result));
	}
}
