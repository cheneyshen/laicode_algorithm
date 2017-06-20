package laicode_java;

//Mere Two Sorted Linked List
public class Solution22 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(one!=null && two!=null) {
			if(one.value<=two.value) {
				cur.next=one;
				one=one.next;
			}
			else {
				cur.next=two;
				two=one.next;
			}
			cur=cur.next;
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

		Solution22 s22 = new Solution22();

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
		l1 = s22.merge(l1, l11);
		System.out.println(l1.next.value);
		return;
	}
}
