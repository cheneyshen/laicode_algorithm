package laicode_java;

import java.util.*;

//Implement LRU Cache
//Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java), false (C++).
public class Solution205 {
	/* 1 -> 2 -> 3
	 * 
	 */
	private int size;
	private HashMap<Integer, ListNode> cache;
	private ListNode head;
	private ListNode tail;
	
	public Solution205(int size) {
		this.size = size;
		this.cache = new HashMap<Integer, ListNode>(size);
		this.head = null;
		this.tail = null;
	}
	
	static class ListNode {
		public int key;
		public int value;
		public ListNode left;
		public ListNode right;
		public ListNode(int key, int value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public void set(int key, int value) {
		if(cache.containsKey(key)) {
			ListNode curr = cache.get(key);
			remove(curr);
			curr = new ListNode(key, value);
			append(curr);
		}
		else {
			ListNode curr = new ListNode(key, value);
			append(curr);
		}
		while(cache.size()>size) {
			ListNode tailer=tail;
			remove(tailer);
		}
	}
	
	public int get(int key) {
		ListNode node = cache.get(key);
		if(node==null) {
			return -1;
		}
		else {
			remove(node);
			append(node);
			return node.value;
		}
	}
	
	private void remove(ListNode node) {
		cache.remove(node.key);
		if(node.left!=null) {
			node.left.right = node.right;
		}
		if(node.right!=null) {
			node.right.left = node.left;
		}
		if(node==head) {
			head = node.right;
		}
		if(node==tail) {
			tail = node.left;
		}
	}
	
	private void append(ListNode node) {
		cache.put(node.key, node);
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			node.right = head;
			node = head.left;
			head=node;
		}
	}
	
	public static void main(String[] args) {


	}
}
