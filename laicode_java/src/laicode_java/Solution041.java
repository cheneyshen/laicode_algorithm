package laicode;

import java.util.*;
//ReOrder Linked List
//Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
//
//Examples
//
//L = null, is reordered to null
//L = 1 -> null, is reordered to 1 -> null
//L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
//L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

public class Solution041 {
	ListNode reorderHelper(ListNode left, ListNode right) {
		if(left==null && right==null) {
			return null;
		}
		else if(left==null) {
			return right;
		}
		else if(right==null) {
			return left;
		}
		ListNode faker=new ListNode(-1);
		ListNode curr=faker;
		int index=0;
		while(left!=null && right!=null) {
			if(index%2==0) {
				curr.next=left;
				left=left.next;
				index++;
				curr=curr.next;
			}
			else {
				curr.next=right;
				right=right.next;
				index++;
				curr=curr.next;
			}
		}
		while(left!=null) {
			curr.next=left;
			left=left.next;
			curr=curr.next;
		}
		while(right!=null) {
			curr.next=right;
			right=right.next;
			curr=curr.next;
		}
		return faker.next;
	}
	
	ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode prev=null;
		ListNode next=null;
		ListNode curr=head;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	ListNode reorder(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) {
			return head;
		}
		ListNode fast=head;
		ListNode slow=head;
		ListNode prev=null;
		while(fast.next!=null && fast.next.next!=null) {
			fast=fast.next;
			prev=slow;
			slow=slow.next;
			if(fast!=null) {
				fast=fast.next;
			}
		}
		ListNode second=slow.next;
		slow.next=null;
		second=reverse(second);
		ListNode result=reorderHelper(head, second);
		return result;
	}
	
	public static void main(String[] args) {


	}
}
