package laicode_java;

//Is binary search tree or not
public class Solution31 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode root, int min, int max) {
		if(root==null) {
			return true;
		}
		if(root.value<min || root.value>max) {
			return false;
		}
		return isBST(root.left, min, root.value-1) &&
				isBST(root.right, root.value+1, max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution31 s31 = new Solution31();
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
		boolean result=s31.isBST(t1);
		System.out.println(result);
		return;
	}
}
