package laicode_java;

import java.util.*;

//Sort With 2 Stacks
//Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
//After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
//
//Assumptions:
//The given stack is not null.
//Requirements:
//No additional memory, time complexity = O(n ^ 2).
public class Solution280 {
	public int[] sort(int[] array) {
		Stack<Integer> s1 = new Stack<>();
	    // Push all elements of array in 1st stack
	    for (int num : array) {
	        s1.push(num);       
	    }
	    Stack<Integer> s2 = new Stack<>();
	    int n=array.length;
	    for (int i = 0; i < n; i++) 
	    {
	        // alternatively
	        if (i % 2 == 0)
	        {
	            while (!s1.isEmpty())
	            {
	                int t = s1.pop();
	                if (s2.isEmpty())  {
	                    s2.push(t);     
	                } else {
	                    if (s2.peek() > t)
	                    {
	                        // swapping
	                        int temp = s2.pop();
	                        s2.push(t);
	                        s2.push(temp);
	                    } else {
	                        s2.push(t);
	                    }
	                }
	            }
	            // tricky step
	            array[n-1-i] = s2.pop();
	        } else {
	            while(!s2.isEmpty())
	            {
	                int t = s2.pop();
	                if (s1.isEmpty()) {
	                    s1.push(t);
	                } else {
	                    if (s1.peek() > t)
	                    {
	                        // swapping
	                        int temp = s1.pop();  
	                        s1.push(t);
	                        s1.push(temp);
	                    } else {
	                        s1.push(t);
	                    }
	                }
	            }
	            // tricky step
	            array[n-1-i] = s1.pop();
	        }
	    }
	    return array;
	}
	
	public static void main(String[] args) {
		Solution280 ss = new Solution280();
		int array[] = {15, 12, 44, 2, 5, 10};
		array = ss.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
