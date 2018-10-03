package laicode_java;

import java.util.*;

public class Solution044 {
	List<Integer> preOrder(TreeNode root) {
		List<Integer> preorder=new ArrayList<Integer>();
		if(root==null) {
			return preorder;
		}
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while(stack.isEmpty()==false) {
			TreeNode curr=stack.pollFirst();
			preorder.add(curr.key);
			if(curr.right!=null) {
				stack.offerFirst(curr.right);
			}
			if(curr.left!=null) {
				stack.offerFirst(curr.left);
			}
		}
		return preorder;
	}
	
	public static void main(String[] args) {


	}
}
