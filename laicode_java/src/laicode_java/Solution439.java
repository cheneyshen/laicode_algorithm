package laicode_java;

import java.util.*;

//Unique paths
//A robot is located at the top-left corner of a m x n grid(where m > 0 and n > 0).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
//
//How many possible unique paths are there?

public class Solution439 {
	public int uniquePaths(int m, int n) {
		Integer[][] map = new Integer[m][n];
		for(int i=0; i<m; i++) {
			map[i][0]=1;
		}
		for(int j=0; j<n; j++) {
			map[0][j]=1;
		}
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		return map[m-1][n-1];
	}
	
	public static String parseTernary(String expression) {
	    if (expression == null || expression.length() == 0) return "";
	    Deque<Character> stack = new LinkedList<>();

	    for (int i = expression.length() - 1; i >= 0; i--) {
	        char c = expression.charAt(i);
	        if (!stack.isEmpty() && stack.peek() == '?') {

	            stack.pop(); //pop '?'
	            char first = stack.pop();
	            stack.pop(); //pop ':'
	            char second = stack.pop();

	            if (c == 'T') stack.push(first);
	            else stack.push(second);
	        } else {
	            stack.push(c);
	        }
	    }

	    return String.valueOf(stack.peek());
	}
	
	public static void main(String[] args) {
		String out = parseTernary("F?F?6:7:T?4:5");
		System.out.println(out);
	}
}
