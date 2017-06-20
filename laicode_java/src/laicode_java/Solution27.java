package laicode_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Binary Tree Post-order Iterative Traversal
public class Solution27 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> postOrder1(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		if(root==null) {
			return result;
		}
		Deque<TreeNode> preOrder=new LinkedList<TreeNode>();
		preOrder.offerFirst(root);
		while(!preOrder.isEmpty()) {
			TreeNode curr=preOrder.pollFirst();
			result.add(curr.value);
			if(curr.left!=null) {
				preOrder.offerFirst(curr.left);
			}
			if(curr.right!=null) {
				preOrder.offerFirst(curr.right);
			}
		}
		Collections.reverse(result);
		return result;
	}
	
	public List<Integer> postOrder2(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		if(root==null) {
			return result;
		}
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		stack.offer(root);
		TreeNode prev=null;
		while(!stack.isEmpty()) {
			TreeNode cur=stack.peekFirst();
			if(prev==null || cur==prev.left || cur==prev.right) {
				if(cur.left!=null) {
					stack.offerFirst(cur.left);
				}
				else if(cur.right!=null) {
					stack.offerFirst(cur.right);
				}
				else {
					stack.pollFirst();
					result.add(cur.value);
				}
			}
			else if(prev==cur.right || prev==cur.left && cur.right==null) {
				stack.pollFirst();
				result.add(cur.value);
			}
			else {
				stack.offerFirst(cur.right);
			}
			prev=cur;
 		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution27 s27 = new Solution27();
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
		List<Integer> result=s27.postOrder1(t1);
		System.out.println(result);
		result=s27.postOrder2(t1);
		System.out.println(result);
		return;
	}
}
