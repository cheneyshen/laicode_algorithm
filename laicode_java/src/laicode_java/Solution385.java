package laicode_java;

import java.util.List;

import java.util.*;


public class Solution385 {

//Preorder Successor
//Determine which node is the current node's successor in the preorder traversal sequence.
//
//The parent pointer is given for the nodes.
//
	  public TreeNode next(TreeNode current) {
		    // Write your solution here.
		    return current;
		  }
	  
	  
	public static void main(String[] args) {


		
	}
	
	public class NestedInteger {
		  // Constructor initializes an empty nested list.
		      public NestedInteger() {
			}
		 
		      // Constructor initializes a single integer.
		      public NestedInteger(int value) {
			}
		 
		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger() {
				return false;
			}
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		  // Return null if this NestedInteger holds a nested list
		      public Integer getInteger() {
				return null;
			}
		 
		      // Set this NestedInteger to hold a single integer.
		      public void setInteger(int value) {
			}
		 
		      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
		      public void add(NestedInteger ni) {
			}
		 
		      // @return the nested list that this NestedInteger holds, if it holds a nested list
		  // Return null if this NestedInteger holds a single integer
		      public List<NestedInteger> getList() {
				return null;
			}
		}
	int i=1;
	public NestedInteger deserialize(String s) {
		if(s.charAt(0)!='[') {
			return new NestedInteger(Integer.parseInt(s));
		}
		return dfs(s.toCharArray());
	}
	
	NestedInteger dfs(char[] ca) {
		NestedInteger res = new NestedInteger();
		while(i<ca.length) {
			if(ca[i]==',') {
				i++;
			} else if(ca[i]=='[') {
				i++;
				res.add(dfs(ca));
			} else if(ca[i]==']') {
				i++;
				break;
			} else {
				int curr = 0;
				boolean pos = true;
				if(ca[i]=='-') {
					pos = false;
					i++;
				}
				while(i<ca.length && ca[i]>='0' && ca[i]<='9') {
					curr = 10*curr + ca[i++] - '0';
				}
				if(!pos) {
					curr = -curr;
				}
				res.add(new NestedInteger(curr));
			}
		}
		return res;
	}
}
