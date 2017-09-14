package laicode_java;

import java.util.*;

//Merge Two Sorted Linked Lists
//Merge two sorted lists into one large sorted list.
//
//Examples
//
//L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
//L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
//L1 = null, L2 = null, merge L1 and L2 to null
public class Solution040 {
	ListNode merge(ListNode one, ListNode two) {
		if(one==null && two==null) {
			return one;
		}
		else if(one==null) {
			return two;
		}
		else if(two==null) {
			return one;
		}
		ListNode faker=new ListNode(-1);
		ListNode curr=faker;
		while(one!=null && two!=null) {
			if(one.value<=two.value) {
				curr.next=one;
				one=one.next;
			}
			else {
				curr.next=two;
				two=two.next;
			}
			curr=curr.next;
		}
		while(one!=null) {
			curr.next=one;
			one=one.next;
			curr=curr.next;
		}
		while(two!=null) {
			curr.next=two;
			two=two.next;
			curr=curr.next;
		}
		return faker.next;
	}
	public static void main(String[] args) {


	}
}
