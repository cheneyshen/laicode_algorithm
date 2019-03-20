package laicode_java;

import java.util.*;
//    Merge K Sorted Lists
//    Merge K sorted lists into one big sorted list in ascending order.
//
//    Assumptions
//
//    ListOfLists is not null, and none of the lists is null.
public class Solution134 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			this.next=null;
		}
	}
	
	public ListNode merge(List<ListNode> listOfLists) {
		if(listOfLists==null || listOfLists.size()==0) {
			return null;
		}
		if(listOfLists.size()==1) {
			return listOfLists.get(0);
		}
		ListNode res = null;
		for(int i=0; i<listOfLists.size(); i++) {
			res = mergeHelper(res, listOfLists.get(i));
		}
		return res;
	}
	
	private ListNode mergeHelper(ListNode a, ListNode b) {
		if(a==null) {
			return b;
		}
		if(b==null) {
			return a;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(a!=null && b!=null) {
			if(a.value<=b.value) {
				cur.next = a;
				cur = cur.next;
				a = a.next;
			} else {
				cur.next = b;
				cur = cur.next;
				b = b.next;
			}
		}
		if(a!=null) {
			cur.next = a;
		}
		if(b!=null) {
			cur.next = b;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {


	}
}
