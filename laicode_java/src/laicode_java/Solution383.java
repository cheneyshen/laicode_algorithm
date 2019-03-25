package laicode_java;

import java.util.*;

//Reverse Words In A Sentence II
//Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
//
//Examples
//
//“ I  love  Google  ” → “Google love I”
//
//Corner Cases
//
//If the given string is null, we do not need to do anything.
public class Solution383 {
	public String reverseWords(String input) {
		if(input==null || input.length()<1) {
			return input;
		}
		char[] chars = input.toCharArray();
		int slow = 0, fast = 0;
		//跳过空格
		while(fast<chars.length && chars[fast] == ' ') {
			fast++;
		}
		//不是空格或者有一个空格记录进[0, fast],清理多余空格
		while(fast<chars.length) {
			if(chars[fast]!=' ' || chars[fast]==' '&& fast+1<chars.length && chars[fast+1]!=' ') {
				chars[slow++] = chars[fast];
			}
			fast++;
		}
		//slow没变，那就直接返回
		if(slow==0) {
			return "";
		}
		//交换
		swap(chars, 0, slow-1);
		fast = 0;
		int len = slow;
		while(fast<len) {
			int fast1 = fast;
			//记录所有字母位置
			while(fast1<len && chars[fast1]!=' ') {
				fast1++;
			}
			//调换这个word
			swap(chars, fast, fast1-1);
			//跳过所有空格
			while(fast1<len && chars[fast1]==' ') {
				fast1++;
			}
			fast=fast1;
		}
		return new String(chars, 0, len);
 	}
	
	private void swap(char[] array, int left, int right) {
		while(left<right) {
			char t=array[left];
			array[left] = array[right];
			array[right] = t;
			left++; right--;
		}
	}
	
	public static void main(String[] args) {


	}
}
