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
	    	//我们先用s2去得到s1当中最大的元素，s1当然最后会被弹空
	    	//交换地，我们再用s1去得到s2当中最大的元素，当然s2最后也被弹空
	        if (i % 2 == 0)
	        {
	            while (!s1.isEmpty())
	            {
	                int t = s1.pop();
	                // s2为空或者比栈顶大的话，直接入栈
	                if (s2.isEmpty() || s2.peek()<=t)  {
	                    s2.push(t);
	                } else {
                        // 为了保持最大的在栈顶，交换栈顶元素
                        int temp = s2.pop();
                        s2.push(t);
                        s2.push(temp);
	                }
	            }
	            // 此时最大的就在栈顶，弹出扔到数组尾部
	            array[n-1-i] = s2.pop();
	        } else {
	            while(!s2.isEmpty())
	            {
	                int t = s2.pop();
	                // s1为空或者比栈顶大的话，直接入栈
	                if (s1.isEmpty() || s1.peek()<=t) {
	                    s1.push(t);
	                } else {
                        // 为了保持最大的在栈顶，交换栈顶元素
                        int temp = s1.pop();  
                        s1.push(t);
                        s1.push(temp);
	                }
	            }
	            // 此时最大的就在栈顶，弹出扔到数组尾部
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
