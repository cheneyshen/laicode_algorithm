package laicode_java;

import java.util.*;

//Reverse Integer
//Reverse digits of an integer.
//
//Assumptions
//If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//Examples
//Input:      23
//Output:   32
//
//Input:     -14
//Output:  -41
public class Solution224 {
	public int reverseInt(int i) {
		long result=0;
		while(i!=0) {
			result=result*10+i%10;
			i=i/10;
		}
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return 0;
		}
		return (int) (result);
	}
	public static void main(String[] args) {
		Solution224 ss = new Solution224();
		System.out.println(ss.reverseInt(-32));
		System.out.println(ss.reverseInt(1000000003));
	}
}
