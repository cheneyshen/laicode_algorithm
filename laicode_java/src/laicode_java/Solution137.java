package laicode_java;

//Number Of Nodes
//Return the number of nodes in the linked list.
//
//Examples
//
//L = null, return 0
//L = 1 -> null, return 1
//L = 1 -> 2 -> null, return 2

public class Solution137 {
	public int numberOfNodes(ListNode head) {
		int result=0;
		while(head!=null) {
			head=head.next;
			result+=1;
		}
	    return result;
	}
	
	public static void main(String[] args) {
		Solution137 s137=new Solution137();
		ListNode l1=new ListNode(6);
		ListNode l2=new ListNode(5);
		ListNode l3=new ListNode(2);
		ListNode l4=new ListNode(1);
		ListNode l5=new ListNode(4);
		ListNode l6=new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		int result=s137.numberOfNodes(l1);
		System.out.println(result);
		l1=null;
		result=s137.numberOfNodes(l1);
		System.out.println(result);
	}
}