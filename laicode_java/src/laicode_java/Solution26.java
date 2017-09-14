package laicode_java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Binary Tree In-order Iterative Traversal
public class Solution26 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> inorder=new ArrayList<Integer>();
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		TreeNode curr=root;
		while(curr!=null ||!stack.isEmpty()) {
			if(curr!=null) {
				stack.offerFirst(curr);
				curr=curr.left;
			}
			else {
				curr=stack.pollFirst();
				inorder.add(curr.key);
				curr=curr.right;
			}
		}
		return inorder;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution26 s26 = new Solution26();
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
		List<Integer> result=s26.inOrder(t1);
		System.out.println(result);
		return;
	}
}
