package laicode_java;

import java.util.*;

//Number Of Valid Triangles
//Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as three sides of triangles.
//
//Assumptions:
//The given array is not null and has length of at least 3.
//Exmaples:
//array = {4, 6, 3, 7}, the output should be 3. There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is impossible.
//Preferred time complexity O(n ^ 2).
public class Solution273 {
	//	3 4 6 7 8 9
	public int triangleNumber(int[] A) {
		if(A==null || A.length<3) {
			return 0;
		}
		Arrays.sort(A);
		int result=0, n=A.length;
		for(int i=n-1; i>=2; i--) {
			//A[i] is biggest, A[right] is middle, A[left] is smallest
			int left=0, right=i-1;
			while(left<right) {
				if(A[left]+A[right]>A[i]) {
					result+=right-left;
					right--;
				} else {
					left++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
