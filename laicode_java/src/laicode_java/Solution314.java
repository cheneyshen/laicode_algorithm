package laicode_java;

import java.util.*;

import laicode_java.Solution126.TreeNode;

//A + B + C = D
//Determine if there exist 4 elements in an given positive integer array, such that A + B + C = D.
//  Assumptions:
//  The given array is not null and has length of >= 4.
//  All the elements in the given array are positive integers.
//  Examples:
//  
//  array = {1, 4, 3, 2}, there does not exist such elements, return false.
//array = {5, 1, 4, 0, 2, 1}, since 1 + 4 + 0 = 5, return true.
public class Solution314 {
	class Pair {
		int first, second;
		Pair(int f, int s) {
			first = f;
			second = s;
		}
	}
	
	boolean findPairs(int arr[]) {
		HashMap<Integer, Pair> map = new HashMap<>();
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int sum = arr[i] + arr[j];
				int minus = arr[i] - arr[j];
				if(!map.containsKey(sum)) {
					map.put(sum, new Pair(i, j));
				} else if(map.containsKey(Math.abs(minus))){
					return true;
				}
			}
		}
		return false;
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		if(root==null) {
			return null;
		}
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		q.add(root);
		cols.add(0);
		int min = 0, max = 0;
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.key);
			if(node.left!=null) {
				q.add(node.left);
				cols.add(col-1);
				min = Math.min(col-1, min);
			}
			if(node.right!=null) {
				q.add(node.right);
				cols.add(col+1);
				max = Math.max(col+1, max);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for(int i=min; i<=max; i++) {
			result.add(map.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
