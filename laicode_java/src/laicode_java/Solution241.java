package laicode_java;

import java.util.*;

//Reverse Nodes in k-Group
//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.
//
//Example
//
//Given this linked list: 1->2->3->4->5
/*		1	2	3	4	5
 *  p   c   n
 */
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
public class Solution241 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val=x;
			this.next=null;
		}
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k<=1) {
			return head;
		}
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode index=head;
		ListNode prev=null;
		int leng=k;
		while(leng>0 && index!=null) {
			index=index.next;
			leng--;
		}
		if(leng==0) {
			prev=reverseKGroup(index, k);
		}
		ListNode curr=head;
		leng=k;
		while(curr!=null && leng>0) {
			ListNode nexter = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nexter;
			leng--;
		}
		return prev;
		
	}
	
public ListNode reverse2KGroupwithK(ListNode head, int k, int i) {
	if(k<=1) {
		return head;
	}
	if(head==null) {
		return head;
	}
	ListNode index=head;
	int leng=k;
	while(leng>0 && index!=null) {
		index=index.next;
		leng--;
	}
	if(leng>0) {
		//no enough list nodes, directly return head
		return head;
	}
	//find if there are enough nodes
	//index would be the (k+1)th node
	//new header next should be the new converted list
	ListNode prev=reverse2KGroupwithK(index, k, i+1);
	ListNode curr=head;
	leng=k;
    if(i%2==0) {
    	//normal reversed operation
		while(curr!=null && leng>0) {
			ListNode nexter = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nexter;
			leng--;
		}
		return prev;	
    } else {
    	//find the last node in every K nodes
		while(curr!=null && leng>1) {
			curr = curr.next;
			leng--;
		}
		//connect the last node to the updated list head
		curr.next = prev;
		return head;	
    }
}
	
	public static void main(String[] args) {
		Solution241 ss = new Solution241();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		l7.next=l8;
		l8.next=l9;
		l1 = ss.reverse2KGroupwithK(l1, 2, 0);
		while(l1!=null) {
			System.out.println(l1.val);
			l1=l1.next;
		}
	}
}
