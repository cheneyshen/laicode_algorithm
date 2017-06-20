package laicode_java;

//Find Middle Node of linkedlist
public class Solution19 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public ListNode findMiddle(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution19 s19 = new Solution19();
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
		l1=s19.findMiddle(l1);
		System.out.println(l1.value);
		return;
	}
}

//class ListNode {
//	public int value;
//	public ListNode next;
//	public ListNode(int value) {
//		this.value=value;
//		this.next=null;
//	}
//}