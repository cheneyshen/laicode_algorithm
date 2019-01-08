package laicode_java;

import java.util.*;

//Insertion Sort Linked List
//Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The insertion sort algorithm should be used to solve this problem.
//
//Examples
//
//null, is sorted to null
//1 -> null, is sorted to 1 -> null
//1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6

//Given a nested list of integers, implement an iterator to flatten it.
//
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//Example 1:
//
//Input: [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]
//Explanation: By calling next repeatedly until hasNext returns false, 
//             the order of elements returned by next should be: [1,1,2,1,1].
//Example 2:
//
//Input: [1,[4,[6]]]
//Output: [1,4,6]
//Explanation: By calling next repeatedly until hasNext returns false, 
//             the order of elements returned by next should be: [1,4,6].

public class Solution341 implements Iterator<Integer> {
	private Stack<NestedInteger> stk;
	public Solution341(List<NestedInteger> nestedList) {
		stk = new Stack<>();
		for(int i=nestedList.size()-1; i>=0; i--) {
			stk.push(nestedList.get(i));
		}
	}
	
	@Override
	public Integer next() {
		if(stk.isEmpty()) {
			return null;
		}
		NestedInteger ni = stk.pop();
		return ni.getInteger();
	}
	
	@Override
	public boolean hasNext() {
		while(!stk.empty()) {
			NestedInteger ni = stk.peek();
			if(ni.isInteger()) {
				return true;
			}
			stk.pop();
			for(int i=ni.getList().size()-1; i>=0; i--) {
				stk.push(ni.getList().get(i));
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<NestedInteger> ln = new ArrayList<>();
		NestedIntegerImpl nii1 = new NestedIntegerImpl();
		nii1.setInteger(1);
		NestedIntegerImpl nii2 = new NestedIntegerImpl();
		nii2.setInteger(2);
		
		List<NestedInteger> ln0 = new ArrayList<>();
		ln0.add(nii1);
		ln0.add(nii1);
		NestedIntegerImpl nii = new NestedIntegerImpl();
		nii.setList(ln0);
		ln.add(nii);
		ln.add(nii2);
		ln.add(nii);
		Solution341 i = new Solution341(ln);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	
//		NestedIntegerImpl nii146  = new NestedIntegerImpl();
//		nii146.setInteger(6);
//		List<NestedInteger> ln = new ArrayList<>();
//		ln.add(nii146);
//		NestedIntegerImpl nii2 = new NestedIntegerImpl();
//		nii2.setList(ln);
//		NestedIntegerImpl nii14 = new NestedIntegerImpl();
//		nii14.setInteger(4);
//		List<NestedInteger> ln1 = new ArrayList<>();
//		ln1.add(nii14);
//		ln1.add(nii2);
//		NestedIntegerImpl nii1 = new NestedIntegerImpl();
//		nii1.setList(ln1);
//		NestedIntegerImpl nii0 = new NestedIntegerImpl();
//		nii0.setInteger(1);
//		List<NestedInteger> ln0 = new ArrayList<>();
//		ln0.add(nii0);
//		ln0.add(nii1);
//		Solution341 i = new Solution341(ln0);
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//		
	}
}
