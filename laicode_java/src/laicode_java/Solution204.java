package laicode_java;

import java.util.*;

//Maximum Values Of Size K Sliding Windows
//Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.
//Assumptions
//The given array is not null and is not empty
//
//K >= 1, K <= A.length
//Examples
//    A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
//1 2 3 2 4 2 1
//-----> front
//0
//	1
//    2
//    3 2
//        4
//        5 4
//        6 5 4
//and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
public class Solution204 {
	public List<Integer> maxWindows(int[] array, int k) {
		//我们需要用Deque保存降序数组，因为升序只需要最大的那个
		Deque<Integer> stk = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		//遍历整个数组
		for(int i=0; i<array.length; i++) {
			//如果栈不为空且栈顶元素小于当前元素，则弹栈
			while(!stk.isEmpty() && array[stk.peekFirst()]<=array[i]) {
				stk.pollFirst();
			}
			//如果栈不为空且栈底位置为i-k，则继续弹栈
			while(!stk.isEmpty() && stk.peekLast()<=i-k) {
				stk.pollLast();
			}
			//当该弹的弹完了，则添加这个元素
			stk.addLast(i);
			//如果i==k-1时，往结果集添加栈顶元素
			if(i>=k-1) {
				result.add(array[stk.peekFirst()]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution204 ss = new Solution204();
		int[] array = new int[]{1,2,3,2,4,2,1};
		List<Integer> result = ss.maxWindows(array, 3);
		System.out.println(result);
	}
}
