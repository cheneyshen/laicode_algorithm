package laicode_java;

import java.util.*;

//    Deep Copy Skip List
//    A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.
//
//    Make a deep copy of the original skip list.
public class Solution130 {
	class SkipListNode {
		public int key;
		public SkipListNode next;
		public SkipListNode forward;
		public SkipListNode(int key) {
			this.key = key;
		}
	}
	
	public SkipListNode copy(SkipListNode head) {
		if(head==null) {
			return null;
		}
		SkipListNode dummy = new SkipListNode(0);
		SkipListNode curr = dummy;
		
		HashMap<SkipListNode, SkipListNode> dict = new HashMap<SkipListNode, SkipListNode>();
		while(head!=null) {
			if(!dict.containsKey(head)) {
				dict.put(head, new SkipListNode(head.key));
			}
			curr.next=dict.get(head);
			if(head.forward!=null) {
				if(!dict.containsKey(head.forward)) {
					dict.put(head.forward, new SkipListNode(head.forward.key));
				}
				curr.forward=dict.get(head.forward);
			}
			head=head.next;
			curr=curr.next;
		}
		return curr.next;
	}
	
	public static void main(String[] args) {


	}
}
