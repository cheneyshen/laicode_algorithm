package laicode;

import java.util.*;

//Number Of Nodes
//Return the number of nodes in the linked list.
//
//Examples
//
//L = null, return 0
//L = 1 -> null, return 1
//L = 1 -> 2 -> null, return 2
public class Solution033 {
	public int numberOfNodes(ListNode head) {
		int result=0;
		while(head!=null) {
			head=head.next;
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
