package laicode_java;

//Lowest Common Ancestor III
//Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
//
//Return null If any of the nodes is not in the tree.
//
//Assumptions
//
//There is no parent pointer for the nodes in the binary tree
//
//The given two nodes are not guaranteed to be in the binary tree
//
//Examples
//
//        5
//
//      /   \
//
//     9     12
//
//   /  \      \
//
//  2    3      14
//
//The lowest common ancestor of 2 and 14 is 5
//
//The lowest common ancestor of 2 and 9 is 9
//
//The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

public class Solution158 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if(findNode(root, one)==false || findNode(root, two)==false) {
			return null;
		}
		return LCAHelper(root, one, two);
	}
	
	private TreeNode LCAHelper(TreeNode root, TreeNode one, TreeNode two) {
		if(root==null || root==one || root==two) {
			return root;
		}
		TreeNode left=LCAHelper(root.left, one, two);
		TreeNode right=LCAHelper(root.right, one, two);
		if(left!=null && right!=null) {
			return root;
		}
		return left==null?right:left;
	}
	private boolean findNode(TreeNode one, TreeNode two) {
		if(one==null || two==null) {
			return false;
		}
		else if(one==two) {
			return true;
		}
		 
		return findNode(one.left, two) || findNode(one.right, two);
	}
	
	public static void main(String[] args) {
		Solution158 s158 = new Solution158();
		TreeNode r5=new TreeNode(5);
		TreeNode r9=new TreeNode(9);
		TreeNode r12=new TreeNode(12);
		TreeNode r2=new TreeNode(2);
		TreeNode r3=new TreeNode(3);
		TreeNode r14=new TreeNode(14);
		TreeNode r8=new TreeNode(8);
		r5.left=r9;
		r9.left=r2;
		r9.right=r3;
		r5.right=r12;
		r12.right=r14;
		TreeNode result=s158.lowestCommonAncestor(r5, r2, r14);
		System.out.println(result.value);
		result=s158.lowestCommonAncestor(r5, r2, r9);
		System.out.println(result.value);
		result=s158.lowestCommonAncestor(r5, r2, r8);
		if(result==null)
			System.out.println("null");
	}
}
