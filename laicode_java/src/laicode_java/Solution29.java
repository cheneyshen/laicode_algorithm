package laicode_java;

//Check if binary tree is Symmetric
public class Solution29 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	private boolean isSymmetric(TreeNode one, TreeNode two) {
		if(one==null && two==null) {
			return true;
		}
		else if(one==null || two==null) {
			return false;
		}
		else if(one.value!=two.value) {
			return false;
		}
		return isSymmetric(one.left, two.right) && 
				isSymmetric(one.right, two.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution29 s29 = new Solution29();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t21=new TreeNode(2);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t41=new TreeNode(4);
		TreeNode t51=new TreeNode(5);
		t1.left=t2;
		t1.right=t21;
		t2.left=t4;
		t2.right=t5;
		t21.left=t51;
		t21.right=t41;
		boolean result=s29.isSymmetric(t1);
		System.out.println(result);
		return;
	}
}
