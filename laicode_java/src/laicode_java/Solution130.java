package laicode_java;

import java.util.*;

//    Deep Copy Skip List
//    A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.
//
//    Make a deep copy of the original skip list.
public class Solution130 {
	static class SkipListNode {
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
		
		HashMap<SkipListNode, SkipListNode> dict = new HashMap<SkipListNode, SkipListNode>();
		SkipListNode curr = head;
		while(curr != null) {
			if(!dict.containsKey(curr)) {
				dict.put(curr, new SkipListNode(curr.key));
			}
			if(curr.next!=null) {
				if(!dict.containsKey(curr.next)) {
					dict.put(curr.next, new SkipListNode(curr.key));
				}
				dict.get(curr).next = dict.get(curr.next);
			}
			if(curr.forward!=null) {
				if(!dict.containsKey(curr.forward)) {
					dict.put(curr.forward, new SkipListNode(curr.forward.key));
				}
				dict.get(curr).forward=dict.get(curr.forward);
			}
			curr=curr.next;
		}
		return dict.get(head);
	}
	
	public static void main(String[] args) {


	}
}
