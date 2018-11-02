package laicode_java;

public class Solution230 {

	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if(k<=count) {
			return kthSmallest(root.left, k);
		} else if(k>count+1) {
			return kthSmallest(root.right, k-1-count);
		}
		return root.key;
	}
	
	int countNodes(TreeNode n) {
		if(n==null)	return 0;
		return 1 + countNodes(n.left) + countNodes(n.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
