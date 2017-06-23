package laicode_java;
import java.util.*;

//Median of two arrays
public class Solution116 {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public Solution116() {
		maxHeap=new PriorityQueue<Integer>();
		minHeap=new PriorityQueue<Integer>(11, Collections.reverseOrder());
	}
	
	public double median(int[] a, int[] b) {
		for(int i=0;i<a.length;i++) {
			if(maxHeap.size()>minHeap.size()) {
	            if(a[i]>=maxHeap.peek()) {
	            	minHeap.offer(a[i]);
	            }
	            else {
	            	minHeap.offer(maxHeap.poll());
	                maxHeap.offer(a[i]);
	            }
	        }
	        else if(maxHeap.size()==minHeap.size()){
	            if(maxHeap.size()==0 || a[i]<=minHeap.peek()) {
	            	maxHeap.offer(a[i]);
	            }
	            else {
	            	maxHeap.offer(minHeap.poll());
	            	minHeap.offer(a[i]);
	            }
	        }
		}
		for(int i=0;i<b.length;i++) {
			if(maxHeap.size()>minHeap.size()) {
	            if(b[i]>=maxHeap.peek()) {
	            	minHeap.offer(b[i]);
	            }
	            else {
	            	minHeap.offer(maxHeap.poll());
	                maxHeap.offer(b[i]);
	            }
	        }
	        else if(maxHeap.size()==minHeap.size()){
	            if(maxHeap.size()==0 || b[i]<=minHeap.peek()) {
	            	maxHeap.offer(b[i]);
	            }
	            else {
	            	maxHeap.offer(minHeap.poll());
	            	minHeap.offer(b[i]);
	            }
	        }
		}
		int size=maxHeap.size()+minHeap.size();
		if(size==0) {
			return 0.0; 
		}
		else if(size%2!=0) {
			return (double)(maxHeap.peek());
		}
		else {
			return (double)(maxHeap.peek()+minHeap.peek())/2.0;
		}
	}
	
	public static void main(String[] args) {
		Solution116 s116 = new Solution116();
		int[] a={4,1,6};
		int[] b={2,3};
		a=new int[]{1,4};
		b=new int[]{3,2};
		double result=s116.median(a, b);
		System.out.println(result);
	}
}