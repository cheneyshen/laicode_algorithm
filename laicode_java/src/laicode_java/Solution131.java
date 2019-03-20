package laicode_java;

import java.util.*;

//    Deep Copy Linked List With Random Pointer
//    Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
//
public class Solution131 {
	class RandomListNode {
		public int value;
		public RandomListNode next;
		public RandomListNode random;
		public RandomListNode(int key) {
			this.value = value;
		}
	}
	
	public RandomListNode copy(RandomListNode head) {
		if(head==null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cur = head;
		while(cur!=null) {
			if(!map.containsKey(cur)) {
				map.put(cur, new RandomListNode(cur.value));
			}
			if(cur.next!=null) {
				if(!map.containsKey(cur.next)) {
					map.put(cur.next, new RandomListNode(cur.next.value));
				}
				map.get(cur).next = map.get(cur.next);
			}
			if(cur.random!=null) {
				if(!map.containsKey(cur.random)) {
					map.put(cur.random, new RandomListNode(cur.random.value));
				}
				map.get(cur).random = map.get(cur.random);
			}
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public static void main(String[] args) {


	}
}
