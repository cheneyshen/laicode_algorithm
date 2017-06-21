package laicode_java;
import java.util.*;

//Reverse String
public class Solution50 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String reverse1(String input) {
		if(input==null || input.length()<=1) {
			return input;
		}
		char[] array=input.toCharArray();
		for(int left=0, right=array.length-1;left<right;left++,right--) {
			swap(array, left, right);
		}
		return new String(array);
	}
	
	public String reverse2(String input) {
		if(input==null || input.length()<=1) {
			return input;
		}
		char[] array=input.toCharArray();
		reverseHelper(array, 0, array.length-1);
		return new String(array);
	}
	
	private void reverseHelper(char[] array, int left, int right) {
		if(left>=right) {
			return;
		}
		swap(array, left, right);
		reverseHelper(array, left+1, right-1);
	}
	
	private void swap(char[] array, int a, int b) {
		char tmp=array[a];
		array[a]=array[b];
		array[b]=tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution50 s50 = new Solution50();
		String result=s50.reverse1("hello world");
		System.out.println(result);
		result=s50.reverse2("hello world");
		System.out.println(result);
		return;
	}
}
