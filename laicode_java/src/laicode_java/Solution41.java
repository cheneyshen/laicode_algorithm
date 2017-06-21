package laicode_java;

import java.util.*;

//All permutations I
public class Solution41 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<String> permutations1(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] array=set.toCharArray();
		helper(array, 0, result);
		return result;
	}
	
	private void helper(char[] array, int index, List<String> result) {
		if(index==array.length) {
			result.add(new String(array));
			return;
		}
		
		for(int i=index;i<array.length;i++) {
			swap(array, index, i);
			helper(array, index+1, result);
			swap(array, index, i);
		}
	}
	
	public List<String> permutations2(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return null;
		}
		char[] arraySet=set.toCharArray();
		Arrays.sort(arraySet);
		boolean[] used=new boolean[arraySet.length];
		StringBuilder cur=new StringBuilder();
		helper2(arraySet, used, cur, result);
		return result;
	}
	
	private void helper2(char[] array, boolean[] used, StringBuilder cur, List<String> result) {
		if(cur.length()==array.length) {
			result.add(cur.toString());
			return;
		}
		for(int i=0;i<array.length;i++) {
			if(!used[i]) {
				used[i]=true;
				cur.append(array[i]);
				helper2(array, used, cur, result);
				used[i]=false;
				cur.deleteCharAt(cur.length()-1);
			}
		}
	}
	
	private void swap(char[] array, int left, int right) {
		char tmp=array[left];
		array[left]=array[right];
		array[right]=tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution41 s41 = new Solution41();
		List<String> result=s41.permutations1("hello");
//		System.out.println(Arrays.toString(result.toArray()));
		for(int i=0;i<result.size();i++){
		    System.out.println(result.get(i));
		}
		result=s41.permutations2("world");
//		System.out.println(Arrays.toString(result.toArray()));
		for(int i=0;i<result.size();i++){
		    System.out.println(result.get(i));
		}
		return;
	}
}
