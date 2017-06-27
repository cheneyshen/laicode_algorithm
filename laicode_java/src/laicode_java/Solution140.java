package laicode_java;
//Height of Binary Tree
//Find the height of binary tree.
//
//Examples:
//
//        5
//
//      /    \
//
//    3        8
//
//  /   \        \
//
//1      4        11
//
//The height of above binary tree is 3.
//
//How is the binary tree represented?
//
//We use the level order traversal sequence with a special symbol "#" denoting the null node.
//
//For Example:
//
//The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//
//    1
//
//  /   \
//
// 2     3
//
//      /
//
//    4

public class Solution140 {
	public int findHeight(TreeNode root) {
		if(root==null) {
		     return 0;
		}
		else {
			return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		Solution140 s140 = new Solution140();
		int  result=s140.findHeight(t1);
		System.out.println(result);
	}
}