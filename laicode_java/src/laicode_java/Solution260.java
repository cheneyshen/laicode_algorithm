package laicode_java;

import java.util.*;

//Interleave Positive And Negative Elements
//Given an array with both positive and negative numbers in random order. Shuffle the array so that positive and negative numbers are put in position with even and odd indices, respectively.
//
//If there are more positive/negative numbers, put them at the end of the array. The ordering of positive/negative numbers does not matter.
//
//Assumptions:
//
//The given array is not null.
//There is no 0 in the array.
//Examples:
//
//{1, 2, 3, 4, 5, -1, -1, -1} --> {1, -1, 2, -1, 3, -1, 4, 5}  (The ordering of positive/negative numbers do not matter)
public class Solution260 {
	public int[] rerange(int[] A) {
		if(A==null || A.length<=2) {
			return A;
		}
		int leng=A.length;
		int positive=0;
		int slow=0;
		//sort, left pos, right neg
		//{1, 2, 3, 4, 5, -1, -1, -1}
		for(int fast=0; fast<leng; fast++) {
			if(A[fast]>0) {
				positive++;
				swap(A, slow++, fast);
			}
		}
		int negIndex=0;
		int posIndex=1;
		if(positive>leng/2) {
			posIndex=0;
			negIndex=1;
			int left=0;
			int right=leng-1;
			//if pos more than neg, put pos to tailer
			//{-1, -1, -1, 1, 2, 3, 4, 5}
			while(right>=positive) {
				swap(A, left, right);
				left++;
				right--;
			}
		}
		//now swap pos and neg
		//{-1, -1, -1, 1, 2, 3, 4, 5}
		/*  p
		 *             n 
		 *  1  -1  -1 -1  2  3  4  5   
		 *          p
		 *                   n 
		 *  1  -1   3 -1  2 -1  4  5   
		 *                           p
		 *                         n
		 *        
		 */
		while(true) {
			while(posIndex<leng && A[posIndex]>0) {
				posIndex+=2;
			}
			while(negIndex<leng && A[negIndex]<0) {
				negIndex+=2;
			}
			if(posIndex>=leng || negIndex>=leng) {
				break;
			}
			swap(A, posIndex, negIndex);
		}
		return A;
	}
	
	private void swap(int[] A, int left, int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right]=temp;
	}
	
	public static void main(String[] args) {


	}
}
