package laicode_java;

//Merge Sort Linked List
public class Solution135 {
	public ListNode mergeSort(ListNode head) {
		ListNode left=head;
		ListNode right=getMiddle(head);
		return head;
	}
//	4 2 6 -3 5
//	le=0, ri=length-1=4
//	mid=2
//	4 2 6 -3 5
//	sort(lefthalf);
//	sort(righthalf);
//	merge(lefthalf, righthalf);
	public ListNode getMiddle(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode slow=head, fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next;
			if(fast.next!=null) {
				fast=fast.next;
			}
		}
		return slow;
	}
	
	private ListNode merge(ListNode left, ListNode right) {
		if(left==null) {
			return right;
		}
		else if(right==null) {
			return left;
		}
		else {
			ListNode result, index;
			if(left.value<=right.value) {
				result=left;
				left=left.next;
			}
			else {
				result=right;
				right=right.next;
			}
			index=result;
			while(left!=null && right!=null) {
				if(left.value<=right.value) {
					index.next=left;
					left=left.next;
				}
				else {
					index.next=right;
					right=right.next;
				}
			}
			while(left!=null) {
				index.next=left;
				left=left.next;
			}
			while(right!=null) {
				index.next=right;
				right=right.next;
			}
			return result;
		}
	}
	public static void main(String[] args) {
		Solution135 s135 = new Solution135();
		ListNode l1=new ListNode(6);
		ListNode l2=new ListNode(5);
		ListNode l3=new ListNode(2);
		ListNode l4=new ListNode(1);
		ListNode l5=new ListNode(4);
		ListNode l6=new ListNode(3);
		l1.next=l2;
//		l2.next=l3;
//		l3.next=l4;
//		l4.next=l5;
//		l5.next=l6;
		ListNode result=s135.getMiddle(l1);
		System.out.println(result.value);
	}
}