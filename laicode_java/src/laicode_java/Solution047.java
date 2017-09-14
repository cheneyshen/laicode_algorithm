package laicode;

import java.util.*;
//    Check If Binary Tree Is Completed
//    Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
//
//        Examples
//
//              5
//
//            /    \
//
//           3        8
//
//         /   \
//
//        1      4
//
//        is completed.
//
//               5
//
//             /    \
//
//            3        8
//
//          /   \        \
//
//        1      4        11
//
//        is not completed.
//
//        Corner Cases
//
//        What if the binary tree is null? Return true in this case.
public class Solution047 {
	boolean isCompleted(TreeNode root) {
		if(root==null) {
			return true;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		boolean flag=false;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curr=queue.poll();
			if(curr.left==null) {
				flag=true;
			}
			else if(flag) {
				return false;
			}
			else {
				queue.offer(curr.left);
			}
			if(curr.right==null) {
				flag=true;
			}
			else if(flag) {
				return false;
			}
			else {
				queue.offer(curr.right);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
