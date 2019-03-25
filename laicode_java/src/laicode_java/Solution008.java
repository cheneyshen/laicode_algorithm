package laicode_java;

import java.util.*;

public class Solution008 {

//  Evaluate Reverse Polish Notation
//  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//  
//  Assumption
//  
//  Valid operators are +, -, *, /.
//  Each operand may be an integer or another expression.
//  Examples
//  
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	public int evalRPN(String[] tokens) {
		if(tokens==null || tokens.length<=0) {
			return 0;
		}
		Deque<Integer> stk=new LinkedList<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].charAt(0)>='1' && tokens[i].charAt(0)<='9') {
				stk.push(tokens[i].charAt(0)-'0');
			} else {
				Integer b=stk.pop();
				Integer a=stk.pop();
				char cur = tokens[i].charAt(0);
				switch(cur) {
				case '+':
					stk.push(a+b);
					break;
				case '-':
					stk.push(a-b);
					break;
				case '*':
					stk.push(a*b);
					break;
				case '/':
					stk.push(a/b);
					break;
				default:
					stk.push(0);
					break;
				}
			}
		}
		return stk.peek();
	}
	public static void main(String[] args) {
		Solution008 ss = new Solution008();
		String[] array= {"4", "13", "5", "/", "+"};
		System.out.println(ss.evalRPN(array));
	}
}
