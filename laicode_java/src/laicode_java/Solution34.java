package laicode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Get keys in binary tree layer by layer
public class Solution34 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> curLayer=new ArrayList<Integer>();
			int size=queue.size();
			for(int i=0;i<size;i++) {
				TreeNode cur=queue.poll();
				curLayer.add(cur.value);
				if(cur.left!=null) {
					queue.offer(cur.left);
				}
				if(cur.right!=null) {
					queue.offer(cur.right);
				}
			}
			list.add(curLayer);
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution34 s34 = new Solution34();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		t4.left=t2;
		t4.right=t6;
		t2.left=t1;
		t2.right=t3;
		t6.left=t5;
		t6.right=t7;
		List<List<Integer>> result=s34.layerByLayer(t4);
		System.out.println(Arrays.toString(result.toArray()));
		return;
	}
}
