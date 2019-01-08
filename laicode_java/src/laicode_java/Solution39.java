package laicode_java;

import java.util.*;

//All valid permutations of parentheses I
public class Solution39 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
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
	public static List<String> permutationsWithOrder(String str) {
		List<String> res = new ArrayList<>();
		if(str==null)return res;
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		boolean[] used = new boolean[arr.length];
		StringBuilder sb = new StringBuilder();
		helperWithOrder(arr, sb, used, res);
		return res;
	}
	
	private static void helperWithOrder(char[] arr, StringBuilder sb, boolean[] used, List<String> res) {
		
		if(sb.length()==arr.length) {
			res.add(sb.toString());
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!used[i]) {
				used[i]=true;
				sb.append(arr[i]);
				helperWithOrder(arr, sb, used, res);
				sb.setLength(sb.length()-1);
				used[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution39 s39 = new Solution39();
		List<String> result=s39.validParentheses(3);
		System.out.println(result);
		permutationsWithOrder("cba");
		return;
	}
}
