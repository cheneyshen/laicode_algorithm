package laicode_java;

//Check If Binary Tree is Balanced
public class Solution28 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public boolean isBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}
		return height(root)!=-1;
	}
	private int height(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftHeight=height(root.left);
		if(leftHeight==-1) {
			return -1;
		}
		int rightHeight=height(root.right);
		if(rightHeight==-1) {
			return -1;
		}
		if(Math.abs(leftHeight-rightHeight)>1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution28 s28 = new Solution28();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(8);
		TreeNode t9=new TreeNode(9);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t6.left=t8;
		t8.right=t9;
		boolean result=s28.isBalanced(t1);
		System.out.println(result);
		return;
	}
}
