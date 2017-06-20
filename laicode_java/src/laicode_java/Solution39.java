package laicode_java;

import java.util.ArrayList;
import java.util.List;

//All valid permutations of parentheses I
public class Solution39 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<String> validParentheses(int k) {
		List<String> result=new ArrayList<String>();
		char[] cur=new char[k*2];
		helper(cur, k, k, 0, result);
		return result;
	}
	
	private void helper(char[] cur, int left, int right, int index, List<String> result) {
		if(left==0 && right==0) {
			result.add(new String(cur));
			return;
		}
		if(left>0) {
			cur[index]='(';
			helper(cur, left-1, right, index+1, result);
		}
		if(right>left) {
			cur[index]=')';
			helper(cur, left, right-1, index+1, result);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution39 s39 = new Solution39();
		List<String> result=s39.validParentheses(3);
		System.out.println(result);
		return;
	}
}
