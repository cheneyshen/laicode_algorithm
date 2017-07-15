package laicode_java;

import java.util.*;

//Recover Binary Search Tree
//Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.
//
//Input: 
//
//               4
//
//              / \
//
//             2   6  
//
//            / \   / \
//
//           1  5 3  7
//
//Output:       4
//
//             / \
//
//            2   6
//
//          /  \   / \
//
//         1  3   5  7


public class Solution161 {
	private TreeNode node1=null;
	private TreeNode node2=null;
	private TreeNode prev=null;
	public TreeNode recover(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)) {
			return root;
		}
		recoverHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if(node1!=null) {
			int temp=node1.value;
			node1.value=node2.value;
			node2.value=temp;
		}
		return root;
	}
	
	private void recoverHelper(TreeNode root, int leftValue, int rightValue) {
		//base case
		if(root==null) {
			return;
		}
		//recursive left
		recoverHelper(root.left, leftValue, root.value);
	
		//find out the matched node
		if(prev!=null && prev.value>root.value) {
			if(node1==null) {
				node1=prev;
			}
			node2=root;
		}
		
		//recursive right
		prev=root;
		recoverHelper(root.right, root.value, rightValue);
		return;
	}
	
	public static void main(String[] args) {
		Solution161 s161=new Solution161();
//		TreeNode t4=new TreeNode(4);
//		TreeNode t2=new TreeNode(2);
//		TreeNode t6=new TreeNode(6);
//		TreeNode t1=new TreeNode(1);
//		TreeNode t5=new TreeNode(5);
//		TreeNode t3=new TreeNode(3);
//		TreeNode t7=new TreeNode(7);
//		t4.left=t2;
//		t4.right=t6;
//		t2.left=t1;
//		t2.right=t5;
//		t6.left=t3;
//		t6.right=t7;
//		TreeNode result=s161.recover(t4);
//		System.out.println(result.left.right.value);
//		3
//			2
//				1
//					4
//						5
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t3.right=t2;
		t2.right=t1;
		t1.right=t4;
		t4.right=t5;
		TreeNode result=s161.recover(t3);
		System.out.println(result.value);
	}
}