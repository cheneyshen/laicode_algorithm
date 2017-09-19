package laicode_java;

import java.util.*;

//Merge Two Sorted Array
//	Merge two sorted arrays.

//	Input: [1, 2, 3], [2, 4, 6]

//	Output : [1, 2, 2, 3, 4, 6]
public class Solution149 {
	public int[] merge(int[] a, int[] b) {
		int lefts=a.length;
		int rights=b.length;
		int[] result=new int[lefts+rights];
		int i=0, j=0, current=0;
		while(i<lefts && j<rights) {
			if(a[i]<=b[j]) {
				result[current++] = a[i++];
			}
			else {
				result[current++] = b[j++];
			}
		}
		while(i<lefts) {
			result[current++] = a[i++];
		}
		while(j<rights) {
			result[current++] = b[j++];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution149 ss = new Solution149();
		int[] a = {1,2,3};
		int[] b = {2,4,6};
		int[] result = ss.merge(a, b);
		System.out.println(Arrays.toString(result));
	}
}
