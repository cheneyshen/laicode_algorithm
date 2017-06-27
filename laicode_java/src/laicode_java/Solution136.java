package laicode_java;

//Quick Sort Linked List
public class Solution136 {
	public ListNode quickSort(ListNode head) {
//		每次选header为pivot
//		把所有小于等于pivot的节点都挪到前面，再将pivot移到指针位置
//		这样，小于等于pivot的都在该节点左边，大于等于的都在右边
//		再重新quickSort左半边，右半边
		if(head==null || head.next==null) {
			return head;
		}
		ListNode header=head;
		ListNode result=quickSortHelper(header, null);
		return result;
	}

	private ListNode quickSortHelper(ListNode header, ListNode tailer) {
		if(header==null || header==tailer) {
			return header;
		}
		ListNode pivot=partition(header,tailer);
		quickSortHelper(header, pivot);
		quickSortHelper(pivot.next, tailer);
		return header;
	}
	
	private ListNode partition(ListNode header, ListNode tailer) {
		int pivot=header.value;
		ListNode i=header, j=header.next;
		while(j!=tailer) {
			if(j.value<=pivot) {
				i=i.next;
				int swap=j.value;
				j.value=i.value;
				i.value=swap;
			}
			j=j.next;
		}
		header.value=i.value;
		i.value=pivot;
		return i;
	}
	
	public static void main(String[] args) {
		Solution136 s136 = new Solution136();
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
		ListNode result=s136.quickSort(l1);
		printLinkedList(result);
	}
	
	public static void printLinkedList(ListNode head) {
		for(ListNode node=head;node!=null;node=node.next) {
			System.out.print(String.valueOf(node.value)+" ");
		}
		System.out.println("");
	}
	
}