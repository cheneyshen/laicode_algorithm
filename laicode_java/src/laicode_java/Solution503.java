package laicode_java;

import java.util.*;
/*
 * Linkedin OA
 */
public class Solution503 {
	// Minimum Unique Array Sum
	public int minSum(int[] array) {
		if(array==null || array.length<1) {
			return 0;
		}
		Arrays.sort(array);
		int sum = array[0], prev = array[0];
		for (int i=1; i<array.length;i++) {
			if(array[i]<=prev) {
				array[i] = prev+1;
				sum += array[i];
				prev = array[i];
			} else {
				sum += array[i];
				prev = array[i];
			}
		}
		return sum;
	}
	
	// Usernames System
	public String[] uniqueUserNames(String[] array) {
		if(array==null || array.length<2) {
			return array;
		}
		HashMap<String, Integer> dict = new HashMap<>();
		String[] result = new String[array.length];
		for(int i=0;i<array.length;i++) {
			if(dict.get(array[i])==null) {
				result[i] = array[i];
				dict.put(array[i], 1);
			} else {
				result[i] = array[i] + Integer.valueOf(dict.get(array[i]));
				dict.put(array[i], dict.get(array[i])+1);
			}
		}
		return result;
	}
	
	// Monsoon Umbrellas
	public int coinChange(int[] coins, int amount) {
		if(coins==null || coins.length<1) {
			return -1;
		}
		if (amount<1) {
			return 0;
		}
		Arrays.sort(coins);
		int sum = 0;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i=1; i<=amount; i++) {
			int min = Integer.MAX_VALUE;
			for(int coin:coins) {
				if(coin>i) break;
				if(dp[i-coin]<0) continue;
				min = Math.min(min, dp[i-coin]+1);
			}
			if (min == Integer.MAX_VALUE)
				dp[i] = -1;
			else 
				dp[i] = min;
		}
		if(dp[amount]==-1 && amount==Integer.MAX_VALUE && coins[0]==1) {
			return Integer.MAX_VALUE;
		} 
		return dp[amount];
		
		
	}
	
	// Subarray Sum
	public long subArraySum(int arr[]) {
		if(arr==null || arr.length<1) {
			return 0;
		}
		int leng = arr.length;
		long result = 0;
		for (int i=0; i<leng; i++) {
			result += (arr[i] * (i+1) * (leng-i));
		}
		return result;
		
	}
	
	// Valid Parentheses
	public boolean isValidParentheses(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] cs = s.toCharArray();
		HashSet<Character> hashSet = new HashSet<Character>();
		hashSet.addAll(Arrays.asList('(', '{', '['));
		for(char c:cs) {
			if(hashSet.contains(c)) {
				stack.push(c);
			} else {
				if(stack.empty())
					return false;
				char tmp = (char)stack.pop();
				if (tmp == '(' && c!=')')return false;
				if (tmp == '{' && c!='}')return false;
				if (tmp == '[' && c!=']')return false;
			}
		}
		if(stack.empty()) 
			return true;
		else 
			return false;
	}
	
	// Maximum Difference in an array
	public int maxDiff(int arr[]) {
		if(arr==null || arr.length<2) {
			return 0;
		}
		int maxDiff = arr[1] - arr[0];
		int minElement = arr[0];
		int i;
		for (i=1; i<arr.length; i++) {
			if (arr[i] - minElement > maxDiff) {
				maxDiff = arr[i] - minElement;
			}
			if (arr[i] < minElement) {
				minElement = arr[i];
			}
		}
		return maxDiff < 0 ? -1 : maxDiff;
	}
	
	// Can You Sort?
	public void sortByFrequency(int[] array) {
		if(array==null || array.length<2) {
			return;
		}
		HashMap<Integer, Integer> map = new HashMap();
		int leng = array.length;
		Integer[] nums = new Integer[leng];
		for (int i=0; i<leng; i++) {
			nums[i] = new Integer(array[i]);
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
		}
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer c1 = map.get(o1);
				Integer c2 = map.get(o2);
				if (c1!=c2) {
					return Integer.compare(c1, c2);
				} else {
					return Integer.compare(o1, o2);
				}
			}
		});
		for(Integer num:nums) {
			System.out.println(num);
		}
	}
	
	// Movie ratings - house robber
	public int rob(int[] nums) {
		if(nums==null || nums.length<1) {
			return 0;
		}
		int n = nums.length;
		if (n==2)
			return Math.max(nums[0], nums[1]);
		int[] result = new int[n];
		result[0] = nums[0];
		result[1] = nums[1];
		for(int i=2; i<n;i++) {
			result[i] = Math.max(result[i-2]+nums[i], result[i-1]);
		}
		return result[n-1];
	}
	
	// Cut Sticks
	public List<Integer> cutSticks(int[] array) {
		Arrays.sort(array);
		List<Integer> result = new ArrayList<>();
		result.add(array.length);
		for(int i=1; i<array.length; i++) {
			if(array[i] != array[i-1]) {
				result.add(array.length-i);
			}
		}
		return result;
	}
	
	// Zombies Cluster
	public int find(int parent[], int i) {
		if(parent[i]==-1) {
			return i;
		}
		return find(parent, parent[i]);
	}
	
	public void union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		if(xset != yset) {
			parent[xset] = yset;
		}
	}
	public int findCircelNum(int[][] M) {
		int[] parent = new int[M.length];
		Arrays.fill(parent, -1);
		for(int i=0; i<M.length; i++) {
			for(int j=0; i<M.length; j++) {
				if(M[i][j]==1 && j!=i) {
					union(parent, i, j);
				}
			}
		}
		int count = 0;
		for (int i=0; i<parent.length; i++) {
			if (parent[i] == -1) {
				count++;
			}
		}
		return count;
	}
	
	// Shift String
	public String getShiftedString(String input) {
		return input;
	}
	
	// Simple queries, binary search
	public int[] search(int[] i1, int[] i2) {
		Arrays.sort(i1);
		int[] res = new int[i2.length];
		for (int i=0; i<i2.length; i++) {
			int temp = bs(i2[i], i1);
			res[i] = temp;
		}
		return res;
	}
	
	public int bs(int i, int[] array) {
		int left = 0, right = array.length;
		while(left!=right) {
			int mid = left + (right-left)/2;
			if (array[mid]>i) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	// Different parity permutation
	public void dfsParity(int n, List<List<Integer>> lists, List<Integer> cur) {
		if(cur.size() == n) {
			List<Integer> list = new ArrayList<>(cur);
			lists.add(list);
		}
		for(int i=1; i<=n; i++) {
			if(cur.contains(i)) {
				continue;
			}
			if (cur.size() > 0) {
				if((cur.get(cur.size()-1)%2) + (i%2)!=1) {
					continue;
				}
			}
			cur.add(i);
			dfsParity(n, lists, cur);
			cur.remove(cur.size()-1);
		}
	}
	
	// Distinct Pairs
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(target-nums[i], i);
			} else {
				return new int[]{map.get(nums[i]), i};
			}
		}
		return new int[2];
	}
	
	// Sort by bitCount, ascending binary sorting
	class SortByBitCounts implements Comparator<Integer> 
	{
		public int compare(Integer a, Integer b) 
		{ 
			int c1 = Integer.bitCount(a);
			int c2 = Integer.bitCount(b);
			if (c1!=c2) {
				return Integer.compare(c1, c2);
			} else {
				return Integer.compare(a, b);
			}
		}
	};
	public void sortByBitCount(Integer[] array) {
		Arrays.sort(array, new SortByBitCounts());
	}
	
	// Last substring, lexicographical substring
	public String lastSubstring(String a) {
		List<String> res = new ArrayList<>();
		char maxChar = 'a';
		char[] sc = a.toCharArray();
		for (int i=0; i<sc.length; i++) {
			if(sc[i] > maxChar) {
				maxChar = sc[i];
				res.clear();
				res.add(a.substring(i));
			} else if(sc[i] == maxChar) {
				res.add(a.substring(i));
			}
		}
		Collections.sort(res);
		return res.get(res.size()-1);
	}
	
	// The Social Network
	public List<List<Integer>> socialNetwork(int[] i1) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0; i<i1.length; i++) {
			if(!map.containsKey(i1[i])) {
				map.put(i1[i], new ArrayList<>());
			}
			map.get(i1[i]).add(i);
		}
		List<List<Integer>> res = new ArrayList<>();
		for(Integer key : map.keySet()) {
			List<Integer> all = map.get(key);
			int group = all.size()/key;
			for(int i=0; i<group; i++) {
				List<Integer> temp = new ArrayList<>();
				for(int j=0; j<key; j++) {
					temp.add(all.get(i*key+j));
				}
				res.add(temp);
			}
		}
		Collections.sort(res, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0) - o2.get(0);
			}
		});
		return res;
	}
	
	public static List<List<Integer>> permutation(List<List<Integer>> array) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		helper(array, 0, res, result);
		return result;
	}
	
	public static void helper(List<List<Integer>> array, int x, List<Integer> res, List<List<Integer>> result) {
		if(x==array.size()) {
			List<Integer> mirr = new ArrayList<>(res);
			result.add(mirr);
			return;
		}
		for(int i=0; i<array.get(x).size(); i++) {
			res.add(array.get(x).get(i));
			helper(array, x+1, res, result);
			res.remove(res.size()-1);
		}
	}
	public static List<List<Integer>> permutation1(List<List<Integer>> array) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<List<Integer>> que = new LinkedList<>();
		if(array==null || array.size()<1) 	return res;
		int i=0;
		for(int j=0; j<array.get(i).size(); j++) {
			List<Integer> cur = new ArrayList<>();
			cur.add(array.get(i).get(j));
			que.add(cur);
		}
		while(!que.isEmpty()) {
			i++;
			int size=que.size();
			for(int m=0; m<size; m++) {
				List<Integer> cur = que.poll();
				if(i==array.size()) {
					res.add(cur);
				} else {
					for(int n=0; n<array.get(i).size(); n++) {
						List<Integer> tmp = new ArrayList<>(cur);
						tmp.add(array.get(i).get(n));
						que.add(tmp);
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 5, 2, 6 };
		Solution503 solution = new Solution503();
		System.out.println(solution.minSum(arr));
		String[] array = new String[]{"alex", "bob", "alex"};
		array = solution.uniqueUserNames(array);
		System.out.println(Arrays.toString(array));
		List<Integer> cur1 = new ArrayList<>();cur1.add(2);cur1.add(3);cur1.add(4);
		List<Integer> cur2 = new ArrayList<>();cur2.add(7);cur2.add(8);cur2.add(9);
		List<Integer> cur3 = new ArrayList<>();cur3.add(5);cur3.add(6);
		List<List<Integer>> arry = new ArrayList<>();;
		arry.add(cur1);arry.add(cur2);arry.add(cur3);
		permutation(arry);
		permutation1(arry);
	}

}
