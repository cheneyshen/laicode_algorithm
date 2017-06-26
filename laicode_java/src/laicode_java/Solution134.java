package laicode_java;

//Selection Sort Linked List
public class Solution134 {
	public ListNode selectionSort(ListNode head) {
		for(ListNode node1=head;node1!=null;node1=node1.next) {
			ListNode min=node1;
			for(ListNode node2=node1;node2!=null;node2=node2.next) {
				if(min.value>node2.value) {
					min=node2;
				}
			}
			int temp=node1.value;
			node1.value=min.value;
			min.value=temp;
		}
		return head;
	}
	
	public static void main(String[] args) {
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
		Solution134 s134 = new Solution134();
		ListNode result=s134.selectionSort(l1);
		printLinkedList(result);
	}
	
	public static void printLinkedList(ListNode head) {
		for(ListNode node=head;node!=null;node=node.next) {
			System.out.println(String.valueOf(node.value)+" ");
		}
		System.out.println("");
	}
}
