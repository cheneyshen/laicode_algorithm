package laicode_java;

import java.util.*;

//Get Post-order Sequence By Pre-order and In-order
//Given Inorder and Preorder traversals of a binary tree, get the Postorder traversal without reconstructing a binary tree.
//Assumptions:
//The given Inorder and Preorder traversals are guaranteed to be valid.
//Examples:
//Input:
//
//Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
//Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
//
//Output:
//Postorder traversal is {4, 5, 2, 6, 3, 1}
public class Solution301 {
	int search(int arr[], int from, int x, int n) {
		for(int i=from; i<n; i++) {
			if(arr[i]==x) {
				return i;
			}
		}
		return -1;
	}
	
	void getPostOrder(int in[], int ii, int pre[], int pi, int n, List<Integer> result) {
		int root = search(in, ii, pre[pi], n);
		if(root!=0) {
			getPostOrder(in, ii, pre, pi+1, root, result);
		}
		if(root!=n-1) {
			getPostOrder(in, ii+root+1, pre, pi+root+1, n-root-1, result);
		}
		result.add(new Integer(pre[pi]));
	}
	
	List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> visited = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.add(s);
		visited.put(s, visited.getOrDefault(s, 0)+1);
		boolean found = false;
		while(!q.isEmpty()) {
			s = q.poll();
			if(isValid(s)) {
				result.add(s);
				found = true;
			}
			if(found) {
				continue;
			}
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) != '(' && s.charAt(i) != ')') {
					continue;
				}
				String t = s.substring(0, i) + s.substring(i+1);
				if(visited.get(t)==0) {
					q.add(t);
					visited.put(t, visited.getOrDefault(t, 0)+1);
				}
			}
		}
		return result;
	}
	
	boolean isValid(String t) {
		int cnt = 0;
		for(int i=0; i<t.length(); i++) {
			if(t.charAt(i)=='(')	cnt++;
			if(t.charAt(i)==')' && cnt--==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution301 ss = new Solution301();
		int[] in = {4, 2, 5, 1, 3, 6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		List<Integer> result = new ArrayList<>();
		ss.getPostOrder(in, 0, pre, 0, 6, result);
		System.out.println(result.get(0));
	}
}
