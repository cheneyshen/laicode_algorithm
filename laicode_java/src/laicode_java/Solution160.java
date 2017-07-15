package laicode_java;

//Binary Tree Diameter
//Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.
//
//If there does not exist any such paths, return 0.
//
//Examples
//
//    5
//
//  /    \
//
//2      11
//
//     /    \
//
//    6     14
//
//The diameter of this tree is 4 (2 ¡ú 5 ¡ú 11 ¡ú 14)
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

public class Solution160 {
	private int result=0;
	public int diameter(TreeNode root) {
		distHelper(root);
		return result;
	}
	
	private int distHelper(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftdist=distHelper(root.left);
		int rightdist=distHelper(root.right);
		result=Math.max(result, leftdist+rightdist);
		
		return Math.max(leftdist, rightdist)+1;
	}
	
	public static void main(String[] args) {
		Solution160 s160 = new Solution160();
		TreeNode t5=new TreeNode(5);
		TreeNode t2=new TreeNode(2);
		TreeNode t11=new TreeNode(11);
		TreeNode t6=new TreeNode(6);
		TreeNode t14=new TreeNode(14);
		t5.left=t2;
		t5.right=t11;
		t11.left=t6;
		t11.right=t14;
		int result=s160.diameter(t5);
		System.out.println(result);
	}
}
