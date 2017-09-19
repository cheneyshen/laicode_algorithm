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
			next=null;
		}
	}
	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for(ListNode node : listOfLists) {
			if(node!=null) {
				minHeap.offer(node);
			}
		}
		while(!minHeap.isEmpty()) {
			cur.next = minHeap.poll();
			if(cur.next.next != null) {
				minHeap.offer(cur.next.next);
			}
			cur = cur.next;
		}
		return dummy.next;
	}
	
	static class MyComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			if(o1.value == o2.value) {
				return 0;
			}
			return o1.value < o2.value ? -1 : 1;
		}
	}
	public static void main(String[] args) {


	}
}
