package laicode_java;
import java.util.*;

//String replace
public class Solution53 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String replace1(String input, String s, String t) {
		char[] array=input.toCharArray();
		if(s.length()>=t.length()) {
			return replaceShorted(array, s, t);
		}
		return replaceLonger(array, s, t);
	}
	
	private String replaceShorted(char[] input, String s, String t) {
		int slow=0, fast=0;
		while(fast<input.length) {
			if(fast<=input.length-s.length() && equalSubstring(input, fast, s)) {
				copySubstring(input, slow, t);
				slow+=t.length();
				fast+=s.length();
			}
			else {
				input[slow++]=input[fast++];
			}
		}
		return new String(input, 0, slow);
	}
	
	private String replaceLonger(char[] input, String s, String t) {
		ArrayList<Integer> matches = getAllMatches(input, s);
		char[] result=new char[input.length+matches.size()*(t.length()-s.length())];
		int lastIndex=matches.size()-1;
		int slow=input.length-1;
		int fast=result.length-1;
		while(slow>=0) {
			if(lastIndex>=0 && slow==matches.get(lastIndex)) {
				copySubstring(result, fast-t.length()+1, t);
				fast-=t.length();
				slow-=s.length();
				lastIndex--;
			}
			else {
				result[fast--]=input[slow--];
			}
		}
		return new String(result);
	}
	
	private boolean equalSubstring(char[] input, int fromIndex, String s) {
		for(int i=0;i<s.length();i++) {
			if(input[fromIndex+i]!=s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	private void copySubstring(char[] result, int fromIndex, String t) {
		for(int i=0;i<t.length();i++) {
			result[fromIndex+i]=t.charAt(i);
		}
	}
	
	private ArrayList<Integer> getAllMatches(char[] input, String s) {
		ArrayList<Integer> matches=new ArrayList<Integer>();
		int i=0;
		while(i<=input.length-s.length()) {
			if(equalSubstring(input, i, s)) {
				matches.add(i+s.length()-1);
				i+=s.length();
			}
			else {
				i++;
			}
		}
		return matches;
	}
	
	public String replace2(String input, String s, String t) {
		StringBuilder sb=new StringBuilder();
		int fromIndex=0;
		int matchIndex=input.indexOf(s, fromIndex);
		while(matchIndex!=-1) {
			sb.append(input, fromIndex, matchIndex).append(t);
			fromIndex=matchIndex+s.length();
			matchIndex=input.indexOf(s, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution53 s53 = new Solution53();
		String result=s53.replace1("docomomomocomo","omo","o");
		System.out.println(result);
		result=s53.replace2("docomomomocomo","omo","o");
		System.out.println(result);
		return;
	}
}
