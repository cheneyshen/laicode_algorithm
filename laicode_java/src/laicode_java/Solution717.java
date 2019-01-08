package laicode_java;

import java.util.*;

public class Solution717 {
	class Node {
		private int val;
		private int idx;
		public Node(int v, int i) {
			this.val = v;
			this.idx = i;
		}
	}
	//MaxStack
	List<Integer> list = new LinkedList<>();
	Queue<Node> que = new PriorityQueue<>(11, new NodeComparator());
	
	public class NodeComparator implements Comparator<Node>
	{
	    @Override
	    public int compare(Node x, Node y)
	    {
	        if (x.val == y.val)
	        {
	            return y.idx-x.idx;
	        }
	        return y.val-x.val;
	    }
	}
	public Solution717() {
    
    }
	
	public void push(int x) {
		list.add(x);
        Node cur = new Node(x, list.size()-1);
        que.add(cur);
    }
    
    public int pop() {
        if(list.isEmpty()) {
        	throw null;
        }
        int cur = list.get(list.size()-1);
        Node tmp = new Node(cur, list.size()-1);
        System.out.println(que.contains(tmp));
        que.remove(tmp);
        return cur;
    }
    
    public int top() {
        if(list.isEmpty()) {
        	throw null;
        }
        return list.get(list.size()-1);
    }
    
    public int peekMax() {
        if(que.isEmpty()) {
        	throw null;
        }
        return que.peek().val;
    }
    
    public int popMax() {
        if(que.isEmpty()) {
        	throw null;
        }
        Node cur = que.poll();
        list.remove(cur.idx);
        return cur.val;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution717 ss = new Solution717();
		ss.push(5); 
		ss.push(1);
		ss.push(5);
		System.out.println(ss.top()); //-> 5
		System.out.println(ss.popMax()); //-> 5
		System.out.println(ss.top()); //-> 1
		System.out.println(ss.peekMax()); //-> 5
		System.out.println(ss.pop()); //-> 1
		System.out.println(ss.top()); //-> 5
	}

}
