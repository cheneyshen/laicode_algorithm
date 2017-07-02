package laicode_java;
import java.util.*;
//Deep Copy Skip List
//A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.
//
//Make a deep copy of the original skip list.

class SkipListNode {
	public int value;
	public SkipListNode next;
	public SkipListNode forward;
	public SkipListNode(int value) {
		this.value = value;
	}
}

public class Solution159 {
	public SkipListNode copy(SkipListNode head) {
		if(head==null) {
			return null;
		}
		HashMap<SkipListNode, SkipListNode> mapper = new HashMap<SkipListNode, SkipListNode>();
		SkipListNode header=head;
		SkipListNode result=new SkipListNode(head.value);
		mapper.put(header, result);
//		SkipListNode newhead=result;
//		SkipListNode output=result;
//		while(header.next!=null) {
//			newhead.next=new SkipListNode(header.next.value);
//			mapper.put(header.next, newhead.next);
//			header=header.next;
//			newhead=newhead.next;
//		}
//		header=head;
//		newhead=result;
//		while(header!=null) {
//			if(header.forward!=null) {
//				newhead.forward=mapper.get(header.forward);
//			}
//			header=header.next;
//			newhead=newhead.next;
//		}
//		
//		return output;
		while(header!=null) {
			if(header.next!=null) {
				if(mapper.containsKey(header.next)) {
					result.next=mapper.get(header.next);
				}
				else {
					result.next=new SkipListNode(header.next.value);
					mapper.put(header.next, result.next);
				}
			}
			if(header.forward!=null) {
				if(mapper.containsKey(header.forward)) {
					result.forward=mapper.get(header.forward);
				}
				else {
					result.forward=new SkipListNode(header.forward.value);
					mapper.put(header.forward, result.forward);
				}
			}
			header=header.next;
			result=result.next;
		}
		return mapper.get(head);
	}
	
	public static void main(String[] args) {
		Solution159 s159 = new Solution159();
		SkipListNode s1=new SkipListNode(1);
		SkipListNode s2=new SkipListNode(2);
		SkipListNode s3=new SkipListNode(3);
		SkipListNode s4=new SkipListNode(4);
		SkipListNode s5=new SkipListNode(5);
		SkipListNode s6=new SkipListNode(6);
		s1.next=s2;
		s2.next=s3;
		s3.next=s4;
		s4.next=s5;
		s5.next=s6;
		s1.forward=s2;
		s2.forward=s3;
		s3.forward=s5;
		s5.forward=s6;
		SkipListNode result=s159.copy(s1);
		while(result!=null) {
			System.out.print(result.value+ " ");
			if(result.forward!=null) {
				System.out.println(result.forward.value);
			}
			else
				System.out.println();
			result=result.next;
		}
	}
}
