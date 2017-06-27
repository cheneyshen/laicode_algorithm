package laicode_java;

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
    // write your solution here
    return null;
  }
}
