package laicode_java;

import java.util.*;
public class Solution239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		List<Integer> res = new ArrayList<>();
		if(n==0) {
			return null;
		}
		if(k==1) {
			return nums;
		}
		
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = nums[0];
		right[n-1] = nums[n-1];
		//max from left in the windows of k
		for(int i=0; i<n; i++) {
			if(i%k==0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(nums[i], left[i-1]);
			}
		}
		for(int i=n-2; i>=0; i--) {
			if(i%k==0) {
				right[i] = nums[i];
			} else {
				right[i] = Math.max(nums[i], right[i+1]);
			}
		}
		
		for(int i=0; i<=n-k; i++) {
			res.add(Math.max(right[i], left[i+k-1]));
		}
		int[] result = res.stream().mapToInt(i->i).toArray();
		return result;
	}
	
	public List<Integer> maxSlidingWindow1(int[] nums, int k) {
		List<Integer> max = new ArrayList<>();
        Deque<Integer> mydeq = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            while (!mydeq.isEmpty() && nums[mydeq.getLast()]<=nums[i]) {
                mydeq.removeLast();
            }
            while (!mydeq.isEmpty() && mydeq.getFirst() <=i-k) {
                mydeq.removeFirst();
            }
            mydeq.addLast(i);
            if (i>=k-1) {
                max.add(nums[mydeq.getFirst()]);
            }
        }
        return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
