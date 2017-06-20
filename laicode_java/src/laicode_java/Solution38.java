package laicode_java;

import java.util.ArrayList;
import java.util.List;

//All subsets I
public class Solution38 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<String> subSets1(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] arraySet=set.toCharArray();
		StringBuilder sb=new StringBuilder();
		helper1(arraySet, sb, 0, result);
		return result;
	}
	
	private void helper1(char[] set, StringBuilder sb, int index, List<String> result) {
		if(index==set.length) {
			result.add(sb.toString());
			return;
		}
		helper1(set, sb, index+1, result);
		helper1(set, sb.append(set[index]), index+1, result);
		sb.deleteCharAt(sb.length()-1);
	}
	
	public List<String> subSets2(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] arraySet=set.toCharArray();
		StringBuilder sb=new StringBuilder();
		helper2(arraySet, sb, 0, result);
		return result;
	}
	
	private void helper2(char[] set, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());
		for(int i=index;i<set.length;i++) {
			sb.append(set[i]);
			helper2(set, sb, i+1, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution38 s38 = new Solution38();
		List<String> result=s38.subSets1("hello");
		System.out.println(result);
		result=s38.subSets2("hello");
		System.out.println(result);
		return;
	}
}
