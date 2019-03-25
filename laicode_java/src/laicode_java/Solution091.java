package laicode_java;

import java.util.*;

//Array Hopper IV
//	Given an array A of non - negative integers, you are initially positioned at an arbitrary index of the array.A[i] means the maximum jump distance from that position(you can either jump left or jump right).Determine the minimum jumps you need to reach the right end of the array.Return - 1 if you can not reach the right end of the array.

//	Assumptions

//	The given array is not null and has length of at least 1.
//	Examples

//{ 1, 3, 1, 2, 2 }, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

//{ 3, 3, 1, 0, 0 }, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

// { 4, 0, 1, 0, 0 }, if the initial position is 2, you are not able to reach the right end of array, return -1 in this case.
public class Solution091 {
	public int minJump(int[] array, int index) {
		//用来保存往左跳 或者 往右跳 的节点
		Queue<Integer> que = new LinkedList<>();
		//用来去重
		Set<Integer> set = new HashSet<>();
		que.offer(index);
		set.add(index);
		int count = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			//BFS 操作把可以跳到的节点给存入队列
			for(int i=0; i<size; i++) {
				int cur = que.poll();
				if(cur == array.length-1) {
					return count;
				}
				for(int j=1; j<=array[cur]; j++) {
					//没有访问的继续操作
					if(cur+j < array.length && !set.contains(cur+j)) {
						que.offer(cur+j);
						set.add(cur+j);
					}
					if(cur-j>=0 && !set.contains(cur-j)) {
						que.offer(cur-j);
						set.add(cur-j);
					}
				}
			}
			count++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Solution091 s = new Solution091();
		int[]  array = new int[] {3,4,2,3,0,3,1,2,1};
		System.out.println(s.minJump(array, 2));
		System.out.println(s.minJump(array, 0));
		System.out.println(s.minJump(array, 1));
	}
}
