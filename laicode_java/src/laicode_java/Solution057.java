package laicode;

import java.util.*;
//Get Keys In Binary Tree Layer By Layer
//Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.
//
//Examples
//
//5
//
///    \
//
//3        8
//
///   \        \
//
//1     4        11
//
//the result is [ [5], [3, 8], [1, 4, 11] ]
//
//Corner Cases
//
//What if the binary tree is null? Return an empty list of list in this case.
public class Solution057 {
	List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null) {
			return list;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int leng=queue.size();
			List<Integer> level=new ArrayList<Integer>();
			for(int i=0; i<leng; i++) {
				TreeNode head=queue.poll();
				level.add(head.key);
				if(head.left!=null) {
					queue.offer(head.left);
				}
				if(head.right!=null) {
					queue.offer(head.right);
				}
			}
			list.add(level);
		}
		return list;
	}
	public static void main(String[] args) {


	}
}
