package laicode_java;
import java.util.*;

//Right shift by N characters
public class Solution52 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String rightShift(String input, int n) {
		if(input.length()<=1) {
			return input;
		}
		char[] array=input.toCharArray();
		n%=array.length;
		reverse(array, array.length-n, array.length-1);
		reverse(array, 0, array.length-n-1);
		reverse(array, 0, array.length-1);
		return new String(array);
	}
	
	private void reverse(char[] array, int left, int right) {
		while(left<right) {
			char temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution52 s52 = new Solution52();
		String result=s52.rightShift("hello world", 90);
		System.out.println(result);
		return;
	}
}
