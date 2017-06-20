package laicode_java;

import java.util.Deque;
import java.util.LinkedList;

//Stack with min()
public class Solution16 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	private Deque<Integer> stack;
	private Deque<Integer> minStack;
	
	public Solution16() {
		stack=new LinkedList<Integer>();
		minStack=new LinkedList<Integer>();
	}
	
	public Integer min() {
		if(minStack.isEmpty()) {
			return null;
		}
		return minStack.peekFirst();
	}
	
	public void push(int value) {
		stack.offerFirst(value);
		if(minStack.isEmpty() || value<=minStack.peekFirst()) {
			minStack.offerFirst(value);
		}
	}
	
	public Integer pop() {
		if(stack.isEmpty()) {
			return null;
		}
		Integer result=stack.pollFirst();
		if(minStack.peekFirst().equals(result)) {
			minStack.pollFirst();
		}
		return result;
	}
	
	public Integer top() {
		if(stack.isEmpty()) {
			return null;
		}
		return stack.peekFirst();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution16 s16 = new Solution16();
		s16.push(9);
		s16.push(8);
		s16.push(7);
		s16.push(6);
		int result=s16.top();
		System.out.println(result);
		s16.pop();
		result=s16.top();
		System.out.println(result);
		s16.pop();
		result=s16.top();
		System.out.println(result);
		s16.pop();
		result=s16.top();
		System.out.println(result);
		result=s16.pop();
		System.out.println(result);

		System.out.println(s16.min());
		return;
	}
}
