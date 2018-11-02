package laicode_java;

import java.util.*;

import laicode_java.Solution028.ListNode;

//N-Queen II
//Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
public class Solution234 {
	public int nqueens(int n) {
		int[] result=new int[1];
		if(n<=0) {
			return 0;
		}
		List<Integer> matrix=new ArrayList<>();
		for(int i=0; i<n; i++) {
			matrix.add(0);
		}
		nqueensHelper(matrix, 0, n, result);
		return result[0];
	}
	
	private void nqueensHelper(List<Integer> matrix, int i, int n, int[] result) {
		if(i==n) {
			result[0]++;
			return;
		}
		for(int j=0; j<n; j++) {
			if(checker(matrix, i, j)==true) {
				matrix.set(i, j);
				nqueensHelper(matrix, i+1, n, result);
			}
		}
	}
	
	private boolean checker(List<Integer> matrix, int idx, int val) {
		for(int i=0; i<idx; i++) {
			if(matrix.get(i)==val) {
				return false;
			}
			if(Math.abs(matrix.get(i)-val) == Math.abs(i-idx)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(ListNode head) {
		int i=0, len=0;
		ListNode prev=null, curr=head, next=null, shead=null;
		boolean res = true;
		while(curr!=null) {
			len++;
			curr=curr.next;
		}
		if(len<=1)	return true;
		else if(len==2)	return (head.value == head.next.value);
		
		curr = head;
		prev = null;
		for(i=0; i<len/2; i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		shead = len%2 == 1? next.next : next;
		while(shead!=null && (shead.value == head.value)) {
			shead = shead.next;
			head = head.next;
		}
		res = (null == shead);
		return res;
	}
	
	public static void main(String[] args) {
		Solution234 ss = new Solution234();
		System.out.println(ss.nqueens(8));
	}
}
