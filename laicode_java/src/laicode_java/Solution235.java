package laicode_java;

import java.util.*;

//Count and Say
//Given a sequence of number: 1, 11, 21, 1211, 111221, …
//
//The rule of generating the number in the sequence is as follow:
//
//1 is "one 1" so 11.
//11 is "two 1s" so 21.
//21 is "one 2 followed by one 1" so 1211.
//
//Find the nth number in this sequence.
//Assumptions:
//
//n starts from 1, the first number is "1", the second number is "11"
public class Solution235 {
	public String countAndSay(int i) {
		if(i<=0) {
			return "";
		}
		String[] result=new String[1];
		helper("1", i-1, result);
		return result[0];
	}
	
	private void helper(String str, int index, String[] result) {
		if(index==0) {
			result[0]=str;
			return;
		}
		String array="";
		for(int i=0; i<str.length();) {
			int counts=1;
			int j=i;
			while(j+1<str.length() && str.charAt(j)==str.charAt(j+1)) {
				j++;
				counts++;
			}
			array+=(char)(counts+'0');
			array+=str.charAt(j);
			i=j+1;
		}
		helper(array, index-1, result);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.key - p.key) * (root.key - q.key) < 0) {
			if(p.key < root.key) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		Solution235 ss = new Solution235();
		System.out.println(ss.countAndSay(1));
		System.out.println(ss.countAndSay(2));
		System.out.println(ss.countAndSay(3));
		System.out.println(ss.countAndSay(4));
		System.out.println(ss.countAndSay(10));
	}
}
