package laicode_java;
//Cycle Node In Linked List
//Check if a given linked list has a cycle. Return the node where the cycle starts.
//Return null if there is no cycle.

public class Solution138 {
	public ListNode cycleNode(ListNode head) {
		ListNode fast=head;
		ListNode slow=head;
		while(fast != null && slow != null) {
			fast=fast.next;
			slow=slow.next;
			if(fast != null) {
				fast=fast.next;
			}
			else {
				return null;
			}
			if(fast == slow) {
				fast=head;
				while(fast!=null && slow!=null && fast!=slow) {
					fast=fast.next;
					slow=slow.next;
				}
				return fast;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		l7.next=l1;
		Solution138 s138=new Solution138();
		ListNode result=s138.cycleNode(l1);
		System.out.println(result.value);
		
	}
}