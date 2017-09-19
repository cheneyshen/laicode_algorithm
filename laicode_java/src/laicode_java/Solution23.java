package laicode_java;

import laicode_java.Solution028.ListNode;

//Reorder Linked list
public class Solution23 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	
	public ListNode reorder(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode mid=middleNode(head);
		ListNode one=head;
		ListNode two=mid.next;
		mid.next=null;
		return merge(one, reverse(two));
	}
	
	private ListNode middleNode(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	private ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode prev=null;
		while(head!=null) {
			ListNode next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
	}
	
	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(one!=null && two!=null) {
			cur.next=one;
			one=one.next;
			cur.next.next=two;
			two=two.next;
			cur=cur.next.next;
		}
		if(one!=null) {
			cur.next=one;
		}
		else {
			cur.next=two;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution23 s23 = new Solution23();
		ListNode l11=new ListNode(11);
		ListNode l12=new ListNode(12);
		ListNode l13=new ListNode(13);
		ListNode l14=new ListNode(14);
		ListNode l15=new ListNode(15);
		ListNode l16=new ListNode(16);
		ListNode l17=new ListNode(17);
		l11.next=l12;
		l12.next=l13;
		l13.next=l14;
		l14.next=l15;
		l15.next=l16;
		l16.next=l17;
		ListNode result=s23.reorder(l11);
		System.out.println(result.next.value);
		return;
	}
}
