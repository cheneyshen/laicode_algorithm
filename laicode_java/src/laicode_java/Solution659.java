package laicode_java;

import java.util.*;

public class Solution659 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int res = 0, k = 1; // flip at most k zero
        Queue<Integer> zeroIndex = new LinkedList<>(); 
        for (int slow = 0, fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0)
                zeroIndex.offer(fast);
            if (zeroIndex.size() > k)                                   
                slow = zeroIndex.poll() + 1;
            res = Math.max(res, fast - slow + 1);
        }
        return res;
	}
	
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		Map<Integer, Integer> need = new HashMap<>();
		for(int i:nums) {
			if(!freq.containsKey(i)) {
				freq.put(i, 1);
			} else {
				freq.put(i, freq.get(i)+1);
			}
		}
		for(int i:nums) {
			if(freq.get(i)==0)	continue;
			else if(need.get(i)>0) {
				need.put(i, need.get(i)-1);
				if(!need.containsKey(i+1)) {
					need.put(i+1, 1);
				} else {
					need.put(i+1, need.get(i+1)+1);
				}
			} else if(freq.get(i+1)>0 && freq.get(i+2)>0) {
				if(!freq.containsKey(i+1)) {
					freq.put(i+1, -1);
				} else {
					freq.put(i+1, freq.get(i+1)-1);
				}
				if(!freq.containsKey(i+2)) {
					freq.put(i+2, -1);
				} else {
					freq.put(i+2, freq.get(i+2)-1);
				}
				if(!need.containsKey(i+2)) {
					need.put(i+2, 1);
				} else {
					need.put(i+2, need.get(i+2)+1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
