package laicode_java;
import java.util.*;
//Find Number of BSTs Generated
//Find the number of different Binary Search Trees generated from 1-n.
//
//Example:
//
//Input: 3, Return: 5

public class Solution162 {
	public int numOfTrees(int n) {
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		List<TreeNode> result=constuctBST(1, n);
		return result.size();
	}
	
	private List<TreeNode> constuctBST(int start, int end) {
		List<TreeNode> result=new ArrayList<TreeNode>();
		if(start>end) {
			result.add(null);
			return result;
		}
		for(int i=start;i<=end;i++) {
			List<TreeNode> left=constuctBST(start, i-1);
			List<TreeNode> right=constuctBST(i+1, end);
			for(int j=0;j<left.size();j++) {
				TreeNode leftroot=left.get(j);
				for(int k=0;k<right.size();k++) {
					TreeNode rightroot=right.get(k);
					TreeNode root=new TreeNode(i);
					root.left=leftroot;
					root.right=rightroot;
					result.add(root);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution162 s162 = new Solution162();
		int result=s162.numOfTrees(2);
		System.out.println(result);
	}
}