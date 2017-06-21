package laicode_java;
import java.util.*;

//Reverse words in sentence
public class Solution51 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String reverseWords(String input) {
		char[] array=input.toCharArray();
		reverse(array, 0, array.length-1);
		int start=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]!=' ' && (i==0 || array[i-1]==' ')) {
				start=i;
			}
			if(array[i]!=' ' && (i==array.length-1 || array[i+1]==' ')) {
				reverse(array, start, i);
			}
		}
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

		Solution51 s51 = new Solution51();
		String result="I love Google";
		result=s51.reverseWords(result);
		System.out.println(result);
		return;
	}
}
