package laicode_java;

import java.util.*;

//Strobogrammatic Number III
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
//
//For example,
//Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
//
//Note:
//Because the range might be a large number, the low and high numbers are represented as string.
//

public class Solution480 {
	private int result = 0;
	
	public int strobogrammaticInRange(String low, String high) {
		for(int i=low.length(); i<=high.length(); i++) {
			find(low, high, "", i);
			find(low, high, "0", i);
			find(low, high, "1", i);
			find(low, high, "8", i);
		}
		return result;
	}
	
	private void find(String low, String high, String path, int leng) {
		if(path.length() >= leng) {
			if(path.length()!=leng || (leng!=1 && path.charAt(0)=='0')) {
				return;
			}
			if((leng==low.length() && path.compareTo(low)<0) || (leng==high.length() && path.compareTo(high)>0)) {
				return;
			}
			result++;
		}
		find(low, high, "0"+path+"0", leng);
		find(low, high, "1"+path+"1", leng);
		find(low, high, "6"+path+"9", leng);
		find(low, high, "8"+path+"8", leng);
		find(low, high, "9"+path+"6", leng);
	}
	
	static class MedianQueue {
	    private Queue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	    private Queue<Long> minHeap = new PriorityQueue<>();

	    public void add(long n) {
	        if (maxHeap.size()>minHeap.size()) {
	            if (n >= maxHeap.peek()) {
	                minHeap.add(n);
	            } else {
	                minHeap.add(maxHeap.poll());
	                maxHeap.add(n);
	            }
	        } else if (maxHeap.size() == minHeap.size()) {
	            if (maxHeap.size() == 0 || n <= minHeap.peek()) {
	                maxHeap.add(n);
	            } else {
	                maxHeap.add(minHeap.poll());
	                minHeap.add(n);
	            }
	        }
	    }

	    public double median() {
	    	if(maxHeap.size()==0 && minHeap.size()==0) {
	    		return 0.0;
	    	}
	        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0 : maxHeap.peek();
	    }

	    public boolean remove(long n) {
	        return maxHeap.remove(n) || minHeap.remove(n);
	    }
	}


	public static void main(String[] args) {
		MedianQueue mq = new MedianQueue();
		mq.add(2);
		mq.add(3);
//		mq.add(4);
//		mq.add(5);
//		mq.add(6);
//		mq.add(7);
//		mq.add(8);
		System.out.println(mq.median());
	}
}
