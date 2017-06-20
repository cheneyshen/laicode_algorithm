package laicode_java;

import java.util.*;
//coinCombinations of Coins
public class Solution40 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> cur=new ArrayList<Integer>();
		helper(target, coins, 0, cur, result);
		return result;
	}
	
	private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
		if(index==coins.length-1) {
			if(target%coins[coins.length-1]==0) {
				cur.add(target/coins[coins.length-1]);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size()-1);
			}
			return;
		}
		int max=target/coins[index];
		for(int i=0;i<=max;i++) {
			cur.add(i);
			helper(target-i*coins[index], coins, index+1, cur, result);
			cur.remove(cur.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution40 s40 = new Solution40();
		int[] set={5,2,1};
		List<List<Integer>> result=s40.combinations(13, set);
		System.out.println(Arrays.toString(result.toArray()));
		return;
	}
}
