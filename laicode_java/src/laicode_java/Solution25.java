package laicode_java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution25 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> preorder=new ArrayList<Integer>();
		if(root==null) {
			return preorder;
		}
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			TreeNode curr=stack.pollFirst();
			if(curr.right!=null) {
				stack.offerFirst(curr.right);
			}
			if(curr.left!=null) {
				stack.offerFirst(curr.left);
			}
			preorder.add(curr.value);
		}
		return preorder;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution25 s25 = new Solution25();
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
		List<Integer> result=s25.preOrder(t1);
		System.out.println(result);
		return;
	}
}

class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int value) {
		this.value=value;
		this.left=null;
		this.right=null;
	}
}