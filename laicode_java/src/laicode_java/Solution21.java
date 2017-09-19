package laicode_java;

//Insert In Sorted Linked List
public class Solution21 {
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
	public ListNode insert(ListNode head, int value) {
		ListNode newer = new ListNode(value);
		if(head==null || head.value>=value) {
			newer.next=head;
			return newer;
		}
		ListNode prev=head;
		while(prev.next!=null && prev.next.value<value) {
			prev=prev.next;
		}
		newer.next=prev.next;
		prev.next=newer;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution21 s21 = new Solution21();
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
		l1=s21.insert(l1, 0);
		System.out.println(l1.value);
		return;
	}
}
