package laicode_java;

import java.util.*;

/*Ternary Expression Tree
	Implement a solution to parse a ternary expression into a tree.
	Assumptions:
The input ternary expression is a string, and it is guaranteed to be valid.
	Examples :
	a ? b : c-->
	a
	/ \
	b     c
	a ? b ? c : d : e-->
	a
	/ \
	b       e
	/ \
	c    d*/
public class Solution291 {
	static class TreeNode {
		char data;
		TreeNode left, right;
		TreeNode(char item) {
			data = item;
			left = null;
			right = null;
		}
	}
	
	TreeNode convertExpression(String expression, int i) {
		if(i>expression.length()) {
			return null;
		}
		TreeNode root = new TreeNode(expression.charAt(i));
		i++;
		if(i<expression.length() && expression.charAt(i)=='?') {
			root.left = convertExpression(expression, i+1);
		} else if(i<expression.length()) {
			root.right = convertExpression(expression, i+1);
		}
		return root;
	}
	
	public static void main(String[] args) {


	}
}
