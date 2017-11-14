package laicode_java;

import java.util.*;

//Different Ways to Add Parentheses
//Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators in Ascending order. The valid operators are +, - and *.
//
//
//Example 1
//
//Input: "2-1-1".
//
//((2-1)-1) = 0
//(2-(1-1)) = 2
//Output: [0, 2]
//
//
//Example 2
//
//Input: "2*3-4*5"
//
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
//Output: [-34, -14, -10, -10, 10]
//

public class Solution475 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c=='-' || c=='+' || c=='*') {
				String a = input.substring(0, i);
				String b = input.substring(i+1);
				List<Integer> al = diffWaysToCompute(a);
				List<Integer> bl = diffWaysToCompute(b);
				for(int x:al) {
					for(int y:bl) {
						if(c=='-') {
							result.add(x-y);
						} else if (c=='+') {
							result.add(x+y);
						} else if (c=='*') {
							result.add(x*y);
						}
					}
				}
			}
		}
		if (result.size()==0) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
