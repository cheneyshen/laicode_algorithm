package laicode_java;
import java.util.*;

//Implement LRU Cache
public class Solution118<K,V> {
	static class Node<K,V> {
		Node<K,V> next;
		Node<K,V> prev;
		K key;
		V value;
	
		Node(K key, V value) {
			this.key=key;
			this.value=value;
		}
		
		void update(K key, V value) {
			this.key=key;
			this.value=value;
		}
	}
	
	private final int limit;
	private Node<K, V> head;
	private Node<K, V> tail;
	private Map<K, Node<K, V>> mapper;
	
	public Solution118(int limit) {
		this.limit=limit;
		this.mapper=new HashMap<K, Node<K, V>>();
	}
	
	public void set(K key, V value) {
		Node<K, V> node=null;
		if(mapper.containsKey(key)) {
			node=mapper.get(key);
			node.value=value;
			remove(node);
		}
		else if(mapper.size()<limit) {
			node=new Node<K,V>(key, value);
		}
		else {
			node=tail;
			remove(node);
			node.update(key, value);
		}
		append(node);
	}
	
	public V get(K key) {
		Node<K, V> node=mapper.get(key);
		if(node==null) {
			return null;
		}
		remove(node);
		append(node);
		return node.value;
	}
	
	private Node<K, V> remove(Node<K,V> node) {
		mapper.remove(node.key);
		if(node.prev!=null) {
			node.prev.next=node.next;
		}
		if(node.next!=null) {
			node.next.prev=node.prev;
		}
		if(node==head) {
			head=head.next;
		}
		if(node==tail) {
			tail=tail.prev;
		}
		return node;
	}
	
	private Node<K,V> append(Node<K,V> node) {
		mapper.put(node.key, node);
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			node.next=head;
			head.prev=node;
			head=node;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Solution118<Integer, String> s118 = new Solution118<Integer, String>(3);
		s118.set(5, "555");
		s118.set(6, "666");
		s118.set(7, "777");
		s118.set(5, "555555");
		Object result=s118.get(5);
		System.out.println(result);
	}
}