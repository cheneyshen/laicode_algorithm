package laicode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Get keys in binary search tree in given range
public class Solution32 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> list=new ArrayList<Integer>();
		getRange(root, min, max, list);
		return list;
	}
	private void getRange(TreeNode root, int min, int max, List<Integer> list) {
		if(root==null) {
			return;
		}
		if(root.key>min) {
			getRange(root.left, min, max, list);
		}
		if(root.key>=min && root.key<=max) {
			list.add(root.key);
		}
		if(root.key<max) {
			getRange(root.right, min, max, list);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution32 s32 = new Solution32();
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
		List<Integer> result=s32.getRange(t4, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(Arrays.toString(result.toArray()));
		return;
	}
}
