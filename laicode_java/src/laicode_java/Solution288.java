package laicode_java;

import java.util.*;

/*First Non - Repeating Character In Stream
		Given a stream of characters, find the first non - repeating character from stream.You need to tell the first non - repeating character in O(1) time at any moment.
		Implement two methods of the class :
		read() - read one character from the stream
		firstNonRepeating() - return the first non - repeating character from the stream at any time when calling the method, return null if there does not exist such characters
		Examples :
read:
	a   b   c   a   c   c    b
		firstNonRepeating :
	a   a   a   b   b   b   null*/
public class Solution288 {
	//根据LRU实现做的双向链表
	class ListNode {
		char key;
		ListNode left, right;
		public ListNode(char key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	//每个字符记录出现的Node位置
	Map<Character, ListNode> map;
	ListNode head, tail;
	public Solution288() {
		this.map = new HashMap<>();
		this.head = null;
		this.tail = null;
	}
	//跟LRU一致的remove方法
	private void remove(ListNode cur) {
		if(cur.right != null) {
			cur.right.left = cur.left;
		}
		if(cur.left != null) {
			cur.left.right = cur.right;
		}
		if(cur==head) {
			head = head.right;
		}
		if(cur==tail) {
			tail = tail.left;
		}
		cur.left = null;
		cur.right = null;
	}
	//跟LRU一致的insert方法
	private void insert(ListNode cur) {
		if(head==null) {
			head=cur;
			tail=cur;
		} else {
			//插入右边
			tail.right = cur;
			cur.left = tail;
			tail = cur;
		}
	}
	/*
	 * read方法，不存在则插入最右侧
	 * 否则从map删除
	 */
	public void read(char ch) {
		if(!map.containsKey(ch)) {
			ListNode cur = new ListNode(ch);
			insert(cur);
			map.put(ch, cur);
		} else {
			ListNode cur = map.get(ch);
			remove(cur);
		}
	}
	//firstNonRepeating方法返回head
	public Character firstNonRepeating() {
		if(head!=null) {
			return head.key;
		}
		return null;
	}
	
	public static void main(String[] args) {

	}
}
