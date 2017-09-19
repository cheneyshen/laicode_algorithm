package laicode_java;

import laicode_java.Solution028.ListNode;

//Reverse Linked List
public class Solution18 {
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
	
	public ListNode reverseLinkedList(ListNode head) {
		ListNode prev=null;
		while(head!=null) {
			ListNode next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
	}
	
	public ListNode reverseLinkedList1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode newer=reverseLinkedList1(head.next);
		head.next.next=head;
		head.next=null;
		return newer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		Solution18 s18 = new Solution18();
		l1 = s18.reverseLinkedList(l1);
		System.out.println(l1.value);
		return;
	}
}