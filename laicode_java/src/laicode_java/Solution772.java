package laicode_java;

import java.io.*;
import java.util.*;
public class Solution772 {
    public int calculate(String s) {
        if(s==null || s.length()<1) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        for(char c:s.toCharArray()) {
        	if(c!=' ') {
            	q.offer(c);
        	}
        }
        q.offer('+');
        return helper(q);
    }

    private int helper(Queue<Character> q) {
    	char sign = '+';
    	int num = 0;
    	Stack<Integer> stk = new Stack<>();
    	while(!q.isEmpty()) {
    		char c = q.poll();
    		if(c>='0' && c<='9') {
    			num = num*10 + c-'0';
    		} else if(c=='(') {
    			num = helper(q);
    		} else {
    			if(sign == '+') {
    				stk.push(num);
    			} else if(sign == '-') {
    				stk.push(-num);
    			} else if(sign == '*') {
    				stk.push(stk.pop() * num);
    			} else if(sign == '/') {
    				stk.push(stk.pop() / num);
    			}
    			num = 0;
    			sign = c;
    			if(c==')') {
    				break;
    			}
    		}
    	}
    	int sum = 0;
    	while(!stk.isEmpty()) {
    		sum += stk.pop();
    	}
    	return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution772 s = new Solution772();
		System.out.println(s.calculate("1 + 1" ));
		System.out.println(s.calculate(" 6-4 / 2 "));
		System.out.println(s.calculate("2*(5+5*2)/3+(6/2+8)" ));
//		System.out.println(s.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
	}

}
