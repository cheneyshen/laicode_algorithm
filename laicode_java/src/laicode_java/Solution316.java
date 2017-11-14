package laicode_java;

import java.util.*;

//Border View Of Binary Tree
//Given a binary tree, return its border view. The border view is defined as follow: first get all the border nodes at left side(from root and always go to the left subtree, from top to bottom), then get all the leaf nodes(from left to right), at last get all the border nodes at right side(from bottom to top), the list of border view should not contain duplicate nodes.
//
//Examples:
//   1
// /    \
//2      3
/// \    /  \
//4   5   6  7
///            \
//9             8
//\
//11
//the border view =  [1, 2, 4, 9, 11, 5, 6, 8, 7, 3]
//
//1, 2, 4, 9 are the left border, 11, 5, 6, 8 are the leaf nodes, 8, 7, 3, 1 are the right border.
public class Solution316 {
	class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private Node root;
	private List<Node> nodes;
	
	public Solution316() {
		nodes = new ArrayList<Node>();
	}
	
	public void printLeaves(Node node) {
		if (node!=null) {
			printLeaves(node.left);
			if (node.left == null && node.right == null) {
				nodes.add(node);
			}
			printLeaves(node.right);
		}
	}
	
	public void printBoundaryLeft(Node node) {
		if (node != null) {
			if (node.left != null) {
				nodes.add(node);
				printBoundaryLeft(node.left);
			}
			else if (node.right != null) {
				nodes.add(node);
				printBoundaryLeft(node.right);
			}
		}
	}
	
	public void printBoundaryRight(Node node) {
		if (node != null) {
			if (node.right != null) {
				printBoundaryRight(node.right);
				nodes.add(node);
			}
			else if (node.left != null) {
				printBoundaryRight(node.left);
				nodes.add(node);
			}
		}
	}
	
	public void printBoundary(Node node) {
		if (node != null) {
			nodes.add(node);
			printBoundaryLeft(node.left);
			printLeaves(node.left);
			printLeaves(node.right);
			printBoundaryRight(node.right);
		}
	}
	
	public static void main(String[] args) {


	}
}
