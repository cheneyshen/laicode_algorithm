package laicode;

import java.util.*;

public class Solution045 {
//  Post-order Traversal Of Binary Tree
//  Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.
//  
//  Examples
//  
//         5
//  
//       /    \
//  
//      3        8
//  
//    /   \        \
//  
//  1      4        11
//  
//  Post-order traversal is [1, 4, 3, 11, 8, 5]
//  
//  Corner Cases
//  
//  What if the given binary tree is null? Return an empty list in this case.
	List<Integer> postOrderI(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		if(root==null) {
			return result;
		}
		Deque<TreeNode> postOrder=new LinkedList<TreeNode>();
		postOrder.offerFirst(root);
		while(!postOrder.isEmpty()) {
			TreeNode curr=postOrder.pollFirst();
			result.add(curr.key);
			if(curr.left!=null) {
				postOrder.offerFirst(curr.left);
			}
			if(curr.right!=null) {
				postOrder.offerFirst(curr.right);
			}
		}
		Collections.reverse(result);
		return result;
	}
	
	List<Integer> postOrderII(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		if(root==null) {
			return result;
		}
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		stack.offerFirst(root);
		TreeNode prev=null;
		while(!stack.isEmpty()) {
			TreeNode curr=stack.peekFirst();
			if(prev==null || curr==prev.left || curr==prev.right) {
				if(curr.left!=null) {
					stack.offerFirst(curr.left);
				}
				else if(curr.right!=null) {
					stack.offerFirst(curr.right);
				}
				else {
					stack.pollFirst();
					result.add(curr.key);
				}
			}
			prev=curr;
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
