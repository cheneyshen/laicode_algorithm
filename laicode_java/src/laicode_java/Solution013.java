package laicode_java;

import java.util.*;
	//Fibonacci Number
	//	Get the Kth number in the Fibonacci Sequence. (K is 0 - indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
	//	Examples
	//	0th fibonacci number is 0
	//	1st fibonacci number is 1
	//	2nd fibonacci number is 1
	//	3rd fibonacci number is 2
	//	6th fibonacci number is 8
	//	Corner Cases
	//	What if K < 0 ? in this case, we should always return 0.
public class Solution013 {
	public long power(int a, int b) {
		if(b==0) {
			return 1;
		}
		if (b<0) {
			return 0;
		}
		else if(b%2==0) {
			long result=power(a, b/2);
			return result* result;
		}
		else {
			long result=power(a, b/2);
			return result* result*a;
		}
	}
	public static void main(String[] args) {
		Solution013 ss = new Solution013();
		System.out.println(ss.power(10, 3));
	}
}
