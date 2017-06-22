package laicode_java;
import java.util.*;

//Decompress String II
public class Solution56 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String decompress1(String input) {
		if(input.isEmpty()) {
			return input;
		}
		char[] array=input.toCharArray();
		return decodeLong(array, decodeShort(array));
	}
	
	private int decodeShort(char[] input) {
		int end=0;
		for(int i=0;i<input.length;i+=2) {
			int digit=getDigit(input[i+1]);
			if(digit>=0 && digit<=2) {
				for(int j=0;j<digit;j++) {
					input[end++]=input[i];
				}
			}
			else {
				input[end++]=input[i];
				input[end++]=input[i+1];
			}
		}
		return end;
	}
	
	private String decodeLong(char[] input, int length) {
		int newLength=length;
		for(int i=0;i<length;i++) {
			int digit=getDigit(input[i]);
			if(digit>2 && digit<=9) {
				newLength+=digit-2;
			}
		}
		char[] result=new char[newLength];
		int end=newLength-1;
		for(int i=length-1;i>=0;i--) {
			int digit=getDigit(input[i]);
			if(digit>2 && digit<=9) {
				i--;
				for(int j=0;j<digit;j++) {
					result[end--]=input[i];
				}
			}
			else {
				result[end--]=input[i];
			}
		}
		return new String(result);
	}
	
	private int getDigit(char digit) {
		return digit-'0';
	}
	
	public String decompress2(String input) {
		char[] array=input.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<array.length;i++) {
			char ch=array[i++];
			int count=array[i]-'0';
			for(int c=0;c<count;c++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution56 s56 = new Solution56();
		String result=s56.decompress1("a1c0b2c4");
		System.out.println(result);
		result=s56.decompress2("a1c0b2c4");
		System.out.println(result);
		return;
	}
}
