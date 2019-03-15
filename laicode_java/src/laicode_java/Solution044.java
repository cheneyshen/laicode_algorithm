package laicode_java;

import java.util.*;

public class Solution044 {
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Deque<TreeNode> que=new LinkedList<TreeNode>();
		que.offerFirst(root);
		while(que.isEmpty()==false) {
			TreeNode curr=que.pollFirst();
			res.add(curr.key);
			if(curr.right!=null) {
				que.offerFirst(curr.right);
			}
			if(curr.left!=null) {
				que.offerFirst(curr.left);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {


	}
}
