package laicode_java;
import java.util.*;

//Maximum values of size K sliding windows
public class Solution117 {
	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> max=new ArrayList<Integer>();
		Deque<Integer> deque=new LinkedList<Integer>();
		for(int i=0;i<array.length;i++) {
			while(!deque.isEmpty() && array[deque.peekFirst()]<=array[i]) {
				deque.pollFirst();
			}
			if(!deque.isEmpty() && deque.peekFirst()<=i-k) {
				deque.pollFirst();
			}
			deque.offer(i);
			if(i>=k-1) {
				max.add(array[deque.peekFirst()]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Solution117 s117 = new Solution117();
		int[] array={1, 2, 3, 2, 4, 2, 1};
		List<Integer> result=s117.maxWindows(array, 3);
		System.out.println(result);
	}
}