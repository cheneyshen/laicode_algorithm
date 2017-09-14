package laicode_java;

import java.util.*;

/*Array Hopper I
 Given an array A of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from that position(you can only jump towards the end of the array).Determine if you are able to reach the last index.
 
 Assumptions
 
 The given array is not null and has length of at least 1.
 Examples
 
 { 1, 3, 2, 0, 3 }, we are able to reach the end of array(jump to index 1 then reach the end of the array)
 
 {2, 1, 1, 0, 2 }, we are not able to reach the end of array*/
public class Solution088 {
	public boolean canJump(int[] input) {
		if(input.length<1) {
			return false;
		} else if(input.length==1) {
			return true;
		}
		boolean[] memo=new boolean[input.length];
		Arrays.fill(memo, false);
		memo[0]=true;
		for(int i=1; i<input.length; i++) {
			for(int j=0; j<i; j++) {
				if(j+input[j]>=i && memo[j]==true) {
					memo[i]=true;
					break;
				}
			}
		}
		return memo[input.length-1];
	}
	
	public static void main(String[] args) {


	}
}
