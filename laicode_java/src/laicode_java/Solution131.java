package laicode_java;

import java.util.*;

//    Deep Copy Linked List With Random Pointer
//    Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
//
public class Solution131 {
	class RandomListNode {
		public int key;
		public RandomListNode next;
		public RandomListNode random;
		public RandomListNode(int key) {
			this.key = key;
		}
	}
	
	public RandomListNode copy(RandomListNode head) {
		if(head==null) {
			return null;
		}
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode curr=dummy;
		Map<RandomListNode, RandomListNode> dict = new HashMap<>();
		while(head!=null) {
			if(!dict.containsKey(head)) {
				dict.put(head, new RandomListNode(head.key));
			}
			curr.next=dict.get(head);
			if(head.random!=null) {
				if(!dict.containsKey(head.random)) {
					dict.put(head.random, new RandomListNode(head.random.key));
				}
				curr.random=dict.get(head.random);
			}
			head=head.next;
			curr=curr.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {


	}
}
