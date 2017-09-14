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
public class Solution012 {

	public long fibonacci(int k) {
		if(k<=0) {
			return 0;
		}
		else if(k==1) {
			return 1;
		}
		long prepre=0;
		long pre=1;
		long result=1;
		for(int i=2; i<=k; i++) {
			result=prepre+pre;
			prepre=pre;
			pre=result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution012 ss = new Solution012();
		System.out.println(ss.fibonacci(10));
	}
}
