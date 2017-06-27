package laicode_java;
//Identical Binary Tree
//Check if two given binary trees are identical. Identical means the equal valued keys are at the same position in the two binary trees.
//
//Examples
//
// 
//
//        5
//
//      /    \
//
//    3        8
//
//and
//
//        5
//
//      /    \
//
//    3        8
//
//are identical trees.
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

public class Solution139 {
	public boolean isIdentical(TreeNode one, TreeNode two) {
		if(one==null && two==null) {
			return true;
		}
		else if(one==null || two==null) {
			return false;
		}
		else if(one.value != two.value) {
			return false;
		}
		else {
			return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
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
		TreeNode t11=new TreeNode(1);
		TreeNode t21=new TreeNode(2);
		TreeNode t31=new TreeNode(3);
		TreeNode t41=new TreeNode(4);
		TreeNode t51=new TreeNode(5);
		TreeNode t61=new TreeNode(6);
		TreeNode t71=new TreeNode(7);
		t11.left=t21;
		t11.right=t31;
		t21.left=t41;
		t21.right=t51;
		t31.left=t61;
		t31.right=t71;
		Solution139 s139 = new Solution139();
		boolean result=s139.isIdentical(t1, t11);
		System.out.println(result);
		result=s139.isIdentical(t1, null);
		System.out.println(result);
		result=s139.isIdentical(null, null);
		System.out.println(result);
	}
	
}