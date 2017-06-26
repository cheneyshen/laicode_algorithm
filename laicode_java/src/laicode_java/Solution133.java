package laicode_java;
import java.util.*;

//Kth Smallest Sum In Two Sorted Arrays
public class Solution133 {
	public int kthSum(int[] A, int[] B, int k) {
		PriorityQueue<Node> myqueue= new PriorityQueue<Node>();
		HashSet<String> mymap=new HashSet<String>();
		int aleng=A.length;
		int bleng=B.length;
		int loop=k;
		if(aleng==0 || bleng==0) {
			return 0;
		}
		if(k<=0 || k>aleng*bleng) {
			return 0;
		}
		Pair aone=new Pair(A[0], 0);
		Pair bone=new Pair(B[0], 0);
		Node one=new Node(aone, bone);
		Combo newbo=new Combo(0, 0);
		myqueue.add(one);
		mymap.add(newbo.toString());
		while(!myqueue.isEmpty()) {
			Node now=myqueue.poll();
			loop--;
//			System.out.println(Integer.toString(now.pa.first)+" "+Integer.toString(now.pb.first));
			if(loop==0) {
				return now.pa.first+now.pb.first;
			}
			int aindex=now.pa.second;
			int bindex=now.pb.second;
			newbo=new Combo(aindex+1, bindex);
			if(aindex+1<aleng && mymap.contains(newbo.toString())==false) {
				aone=new Pair(A[aindex+1], aindex+1);
				Node newone=new Node(aone, now.pb);
				myqueue.add(newone);
				mymap.add(newbo.toString());
			}
			newbo=new Combo(aindex, bindex+1);
			if(bindex+1<bleng && mymap.contains(newbo.toString())==false) {
				bone=new Pair(B[bindex+1], bindex+1);
				Node newtwo=new Node(now.pa, bone);
				myqueue.add(newtwo);
				mymap.add(newbo.toString());
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution133 s133 = new Solution133();
		int[] A={1,3,5};
		int[] B={4,8};
		int result=s133.kthSum(A, B, 1);
		System.out.println(result);
		result=s133.kthSum(A, B, 2);
		System.out.println(result);
		result=s133.kthSum(A, B, 3);
		System.out.println(result);
		result=s133.kthSum(A, B, 4);
		System.out.println(result);
		result=s133.kthSum(A, B, 5);
		System.out.println(result);
		result=s133.kthSum(A, B, 6);
		System.out.println(result);
	}
}

class Pair {
	public int first;
	public int second;
	public Pair(int first, int second) {
		this.first=first;
		this.second=second;
	}
}

class Combo{
    int a;
    int b;
    Combo(int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
	public String toString() {
    	return String.valueOf(a)+" "+String.valueOf(b);
    }
}

class Node implements Comparable<Node>{
	public Pair pa;
	public Pair pb;
	public Node(Pair pa, Pair pb) {
		this.pa=pa;
		this.pb=pb;
	}
	@Override
	public int compareTo(Node o) {
		int a1=this.pa.first+this.pb.first;
		int b1=o.pa.first+o.pb.first;
		if(a1 < b1) {
			return -1;
		}
		else if(a1 > b1) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
