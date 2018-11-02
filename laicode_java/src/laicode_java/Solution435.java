package laicode_java;

import java.util.*;
//
//Shortest Palindrome
//Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
//For example:
//
//Given "aacecaaa", return "aaacecaaa".
//
//Given "abcd", return "dcbabcd".
//

public class Solution435 {
	public String shortestPalindrome(String s) {
		int j=0;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)==s.charAt(j)) {
				j+=1;
			}
		}
		if(j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + 
				shortestPalindrome(s.substring(0, j)) + suffix;
		
	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	 }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals==null || intervals.length<1) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if(a.start==b.start) {
                    return b.end - a.end;
                }
                return b.start - a.start;
            }
        });
        List<Interval> combo = new ArrayList<>();
        helper(intervals, 0, intervals.length, combo, result);
        return result[0];
    }
    
    void helper(Interval[] intervals, int start, int end, List<Interval> combo, int[] result) {
        if(start==end) {
            int sum=0;
            for(int i=0; i<combo.size()-1; i++) {
                if(combo.get(i).end > combo.get(i+1).start) {
                    sum++;
                }
            }
            //System.out.println(sum);
            sum += intervals.length - combo.size();
            if(result[0]>sum) {
                result[0] = Math.min(result[0], sum);
            }
            return;
        }
        combo.add(intervals[start]);
        helper(intervals, start+1, end, combo, result);
        combo.remove(combo.size()-1);
        helper(intervals, start+1, end, combo, result);
    }
    class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){ 
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
                
            }
        }
        return false;
    }
    
    public static boolean arithmeticBoggle(
        int magicNumber,
        ArrayList<Integer> numbers) {
        // Fill in the code here
    	boolean[] result = new boolean[1];
    	if(numbers==null || numbers.size()<1) {
    		return false;
    	}
    	if(numbers.size()==1) {
    		if(numbers.get(0) == magicNumber) {
    			return true;
    		}
    		return false;
    	}
    	helper(magicNumber, numbers, 0,  0, result);
    	return result[0];
    }
    
    static void helper(int target, ArrayList<Integer> array, int sum, int index, boolean[] result) {
    	if(result[0] == true) {
    		return;
    	}
    	if(index==array.size()) {
    		if(target == sum) {
    			result[0] = true;
    		}
    		return;
    	}
    	helper(target, array, sum+array.get(index), index+1, result);
    	helper(target, array, sum-array.get(index), index+1, result);
    }
    
	public static void main(String[] args) {
		Solution435 s = new Solution435();
	}
}
