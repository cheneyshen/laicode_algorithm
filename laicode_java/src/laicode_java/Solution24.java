package laicode_java;

import laicode_java.Solution028.ListNode;

//Partition Linked List
public class Solution24 {
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
	
	public ListNode partition(ListNode head, int target) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode small=new ListNode(0);
		ListNode large=new ListNode(0);
		ListNode curSmall=small;
		ListNode curLarge=large;
		while(head!=null) {
			if(head.value<target) {
				curSmall.next=head;
				curSmall=curSmall.next;
			}
			else {
				curLarge.next=head;
				curLarge=curLarge.next;
			}
			head=head.next;
		}
		curSmall.next=large.next;
		curLarge.next=null;
		return small.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution24 s24 = new Solution24();
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
		ListNode result=s24.partition(l11, 13);
		System.out.println(result.next.next.value);
		return;
	}
}
