package laicode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * VMWare OA
 * 
 * 一道平衡树的遍历，给定post order和pre order，求in order. 
一道考try catch finally的用法，
implement queue using circular linked list,（最后一个node的next是第一个，应该是这个意思） 两个pointer,一个指向front node,一个指向rear node. 问想要以O(1)完成offer和deque需要多少额外的pointer.. 
4.无向图 N个顶点E条边，问DFS的复杂度，两种情况 （adjacency matrix和adjacency list）
1. shift string 2. building the sequence-geoogle 1point3acres 3. Team formation2, 给个upper bound 和lower bound，至少选k个人组队，问至少有多少种组队方式
usernames system Perfect Team, Climb the Hill. 
Even subarray:
[1, 2, 1, 2]    m = 1 这两个[1, 2]就算做一个？.本文原创自1poi
 最后一题even subarrays我感觉做的很崩，一开始吗没看到是distinct subarrays, 就用两个指针start, end.去遍历list,看有多少subarray可以以end为结尾。当遇到odd的时候就将start右移这样。结果直接给出的test case就错了，我一看要distinct,就加了个set,把每个合规的以end为结尾的sublist放入set中，差不多是i=start;i<=end;i++这样，每次新建一个list,把i到end的数都放进去，然后把list放进set,最后返回set的size,然后有几个test case超时了。关键时刻拿出杀手锏sublist(i, end+1)，终于通过所有case。求教有什么好方法做这个题，我考虑过以含有多少odd number（从0到k）这样去找但感觉也并不会快就没深想，不知道正途是什么==nt3acres论坛
这道题我是用2pointer想的，一个l, 一个r, 然后维护[l,r]这个window里面的奇数《=k, 那么这个window里面的任何一个subarray都满足条件，对于任意一组l,r, for i in range (l, r)取这一段的sublist，最后放进set里面就可以了。  补充内容 (2018-8-21 21:51): 补充一下，假如sublist的复杂度是1的话，这复杂度是O(nk)， n是两个pointer扫一遍数组的消耗，然后每次都需要遍历sublist(i, r), i = [l,...r]。就算sublist是O（n)， 那复杂度就会变成nkk。。
input是List<Integer>, 我的set是放了HaseSet<List<Integer>>的类型
 2. FIFO system，4个page，一开始都没有load，先access100个不同的page，按某个顺序，然后再反着来。总共会有多少次page fault 3. 一个无向图，n个点，e个边，选择当图用（1）邻接矩阵（2）邻接列表时DFS的时间复杂度。 4. 忘了 5. break a palindrome。给定一个palindrome。要改变一个char，使得新的string不是palindrome。而且要是lexicocographically最小的，不然就返回"IMPOSSIBLE"。找左半边不是"a"的。 6. Intelligent Substring。给一个字符串，只有小写英文字母。然后会对应1或者0。求最长的子字符串的长度，要求0的个数不超过k个。sliding window。 7. The perfect team。就给你一个字符串，每个char代表一个人擅长的科目，然后要组队，要求队伍里五个人各擅长一门科目，求可以最多可以组几个队伍。数数取最小。

第二题number of teams, 一个team至少需要k个人，现在给一个list的人，里面qualification大于l 小于 r的是满足要求的，问组一个队有多少种组队方式  第三题user name system，如果有重名，要在名字后面加数字，比如request是dave, dave, dave，那返回应该是dave, dave1, dave2


有一个整数数组，要把它变成单调递增或者单调递减（相等也行），可以对数组内任意一个数字加或者减任意值，把这个加减的绝对值称为cost，问要实现最后单调递增或者递减的效果，最少的cost总和是多少？ 比如[1,2,3,4,5,6,5,7] -> [1,2,3,4,5,6,6,7] -> result = 1 
[9, 8. 7, 2, 3, 3] -> [9, 8. 7, 3, 3, 3] -> result = 1例子只是对一个数字进行修改。求问思路？
不会证明，遍历但找出每个元素的left minimum，和rightax，然后计算cost不知道行不行。类似candy game
https://oi.men.ci/haoi2006-sequence/ 可以看看这个的后半段，转移方程里f=f[j]+1,变成h>=h[j]就行

Codeforces 13C  http://codeforces.com/problemset/problem/13/C  补充内容 (2018-8-22 02:43): 可以Google一下。有不少解答。VMware可以看作用两次这个题的解。
。。。太强了，这怎么找到的呀  这是谷歌的一个dp解法 http://iamayushanand.github.io/c ... 13C-codeforces.html

应该是DP, 每个数字要改成的数字选项有限, .本文原创自1point3acres论坛 原数组int[] d 先排序 int[] sort  先考虑递增 另dp[j]  表示第0个到第i个的最优值, 而且第i个数字改成 sort[j]. 一亩-三分-地，独家发布  这样dp[i+1][x] 都可以依次找出来 根据dp[j] dp[i+1][x] = min( min(dp[0] -> dp[x])  + cost(当前位置修改为x)

https://blog.csdn.net/IcePrincess_1968/article/details/75092983
https://oi.men.ci/haoi2006-sequence/
http://iamayushanand.github.io/cp/dp/2016/05/20/Dynamic-Programming-13C-codeforces.html

1.删除linkedlist里面值为偶数的node
2.投票，根据票数找winner
3.给一个nums 数组, 再给一个 maxes 数组，找出nums数组中有多少个元素比maxes数组中的元素小，返回另一个数组
4.给一段程序问输出是什么，给前序后序求中序，还有一题是digits of sum
5.第一题是给一个字符串数组找出现频率最高的，第二题是删除一个linkedlist中所有元素是奇数的节点，第三题想不太起来了。
6. 用BST insert一串数字 在insert的同时print出来一个counter代表call了几次insert 函数。 这道题自己建一个node class 然后就是标准的insert。题目说明的地方还有为代码跟着那个写就可以了
7. 写个函数测试ip地址是不是v4 或者v6 或者都不是 跟利口四六八很像 但是要求稍有不同。. 牛人云集,一亩三分地
8. 给一个数返回一个array，array第一个数是count input 数二进制里面有几个1， 后面是按顺序输出1所在的index位置
9. https://www.geeksforgeeks.org/ma ... minimum-increments/
10.一道是intelligent substring 用sliding window做的
11.一道是build the subsequences 用dfs做的 想优化一下但是没成功
12.Shift Number, 
13.Perfect Team, 
14.Climb the Hill
15.even subarray
16.Team formatiom2  
17.Username system
 */
public class Solution504 {
	/*
	 * 10. Intelligent Substring
	 */
	public int getSepicalSubstring(String s, int k, String charValue) {
		if(s==null || s.length()<1) {
			return 0;
		}
		Set<String> dict = new HashSet<>();
		int count=0;
		int result=0;
		for(int i=0; i<s.length(); i++) {
			if((charValue.charAt(s.charAt(i)-'a')) == '0') {
				count++;
			}
		}
		if(count<=k) {
			dict.add(s);
		}
		getSubstring(s.substring(0, s.length()-1), k, charValue, dict);
		getSubstring(s.substring(1, s.length()), k, charValue, dict);
		for (String node : dict) {
			result = Math.max(result, node.length());
		}
		return result;
	}
	
	private static void getSubstring(String curr, int k, String charValue, Set<String> dict) {
		if(curr==null || curr.length()<1) {
			return;
		}
		int count=0;
		for(int i=0; i<curr.length(); i++) {
			if((charValue.charAt(curr.charAt(i)-'a')) == '0') {
				count++;
			}
		}
		if(count<=k) {
			dict.add(curr);
		}
		getSubstring(curr.substring(0, curr.length()-1), k, charValue, dict);
		getSubstring(curr.substring(1, curr.length()), k, charValue, dict);
	}
	/*
	 * 11. build the subsequences 
	 */
	public List<String> buildSubSequences(String input) {
		if(input==null || input.length()<1) {
			return null;
		}
		char[] array = input.toCharArray();
		String curr = "";
		List<String> result = new ArrayList<>();
		allSubsets(array, 0, curr, result);
		Collections.sort(result);
		return result;
	}
	private void allSubsets(char[] array, int index, String curr, List<String> result) {
		if(index==array.length) {
			if(curr.length()>0) {
				result.add(curr);
			}
			return;
		}
		curr+=array[index];
		allSubsets(array, index+1, curr, result);
		curr = curr.substring(0, curr.length() - 1);
		allSubsets(array, index+1, curr, result);
	}
	/*
	 * 13. The Perfect Team
	 */
	public int differentTeams(String skills) {
		HashMap<Character,Integer> skillsCount = new HashMap<>();
		skillsCount.put('p',0);
		skillsCount.put('c',0);
		skillsCount.put('m',0);
		skillsCount.put('b',0);
		skillsCount.put('z',0);
		for(Character c:skills.toCharArray()){
			if (skillsCount.containsKey(c)){
				skillsCount.put(c,skillsCount.get(c)+1);
			}
		}
		int differentTeams = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : skillsCount.entrySet())
		{
			if ( entry.getValue().compareTo(differentTeams) < 0)
			{
				differentTeams = entry.getValue();
			}
		}
		if (differentTeams != Integer.MAX_VALUE) {
			return differentTeams;
		} else {
			return 0;
		}
	}
	
	/*
	 * 14. Climb the hill
	 */
	public int climbHill(int[] array) {
		if(array == null || array.length<2) {
			return 0;
		}
		int leng = array.length;
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		int[][] dp = new int[leng][leng];
		for(int j=0; j<leng; j++) {
			dp[0][j] = Math.abs(array[0]-sorted[j]);
		}
		for(int i=1; i<leng; i++) {
			int cur = i & 0x1;
			int pre = (i-1) & 0x1;
			int pre_min_cost = dp[pre][0];
			for(int j=0; j<leng; j++) {
				pre_min_cost = Math.min(pre_min_cost, dp[pre][j]);
				dp[cur][j] = pre_min_cost + Math.abs(array[i] - sorted[j]);
			}
		}
		int cur = (leng - 1) & 0x1;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<leng; i++) {
			result = Math.min(result, dp[cur][i]);
		}
		return result;
	}
	
	public String[] userNameSystem(String[] names) {
		return names;
	}
	/*
	 * 15 Even Subarray
	 * a[] = 6 3 5 8  m = 1
	 * 0 odd elements [6] [8]
	 * 1 odd elements [6,3] [3] [5] [5,8]
	 */
	public static long beautifulSubarrays1(int[] a, int m) {
		List<Integer> list = Arrays.stream(a).mapToObj(Integer::new).collect(Collectors.toList());
		Set<List<Integer>> set = new HashSet<>();
		if(list.stream().filter(e->e%2!=0).count()<=m) {
			set.add(list);
		}
		getSubarrays(list.subList(1, list.size()), m, set, false);
		getSubarrays(list.subList(0, list.size()-1), m, set, true);
		return set.size();						
	}
	
	private static void getSubarrays(List<Integer> list, int m, Set<List<Integer>> set, boolean backward) {
		if(list.isEmpty())
			return;
		if(list.stream().filter(e->e%2!=0).count()<=m) {
			//System.out.println(list);
			set.add(list);
		}
		getSubarrays(list.subList(1, list.size()), m, set, false);
		getSubarrays(list.subList(0, list.size()-1), m, set, true);
		
	}
	
	public static long beautifulSubarrays(int[] a, int m) {
		if(a==null || a.length<1 || m<0) {
			return 0;
		}
		int result=0;
		HashSet<List<Integer>> dict = new HashSet<List<Integer>>();
		for(int i=0; i<a.length; i++) {
			for(int j=a.length-1; j>=i; j--) {
				List<Integer> interval = new ArrayList<Integer>();
				interval.add(i);
				interval.add(j);
				if(dict.contains(interval)) {
					continue;
				}
				int count = 0;
				for(int k=j;k>=i;k--) {
					if(a[k]%2==1) {
						count++;
					}
				}
				if(count<=m) {
					result++;
					dict.add(interval);
				}
			}
		}
		return result;
	}
	
	public int ediDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] matrix = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for (int j=0; j<=n; j++) {
				if(i==0) {
					matrix[i][j] = j;
				} else if(j==0){
					matrix[i][j] = i;
				} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1];
				} else {
					matrix[i][j] = Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1);
					matrix[i][j] = Math.min(matrix[i-1][j-1]+1, matrix[i][j]);
				}
			}
		}
		return matrix[m][n];
	}
	
	public boolean areAnagram(String s1, String s2) {
		if(s1==null && s2==null) {
			return true;
		}
		if (s1.length()!=s2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s1.length(); i++) {
			if(map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
			} else {
				map.put(s1.charAt(i), 1);
			}
		}
		for(int j=0; j<s2.length(); j++) {
			if(map.containsKey(s2.charAt(j))) {
				map.put(s2.charAt(j), map.get(s2.charAt(j))-1);
			} else {
				return false;
			}
		}
		for(Character k:map.keySet()) {
			if(map.get(k)!=0) {
				return false;
			}
		}
		return true;
	}
	
	public int editDistance(String s1, String s2) {
		int m=(int)s1.length(); 
		int n=(int)s2.length();
		int[][] matrix=new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0) {
					matrix[i][j]=j;
				} else if(j==0) {
					matrix[i][j]=i;
				} else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					matrix[i][j]=matrix[i-1][j-1];
				} else {
					matrix[i][j]=Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1);
					matrix[i][j]=Math.min(matrix[i-1][j-1]+1, matrix[i][j]);
				}
			}
		}
		return matrix[m][n];
	}
	
	public static String LongestWordLength(String str) {
		int n = str.length(); 
		int res = 0, curr_len = 0, starter = 0;
		for (int i = 0; i < n; i++) 
		{
			if (str.charAt(i) != ' ') {
				curr_len++; 
			} else if (curr_len % 2 == 0) { 
				res = Math.max(res, curr_len); 
				starter = i-curr_len;
				curr_len = 0; 
			}
		}
		if(res%2==0) {
			if(res >= curr_len) {
				return str.substring(starter, res);
			} else {
				return str.substring(starter, curr_len); 
			}
		}
		return "";
	}
	
	/*
	 * 16.Team formatiom2
	 */
	public int countTeams(int[] skills, int k, int l, int r) {
		if(skills==null || skills.length<k || l>r) {
			return -1;
		}
		int leng = skills.length;
		int count = 0;
		Set<List<Integer>> dict = new HashSet<>();
		for(int i=0; i<leng; i++) {
			if(skills[i]>=l && skills[i]<=r) {
				count++;
			}
		}
		if(count<k) {
			return -1;
		} else {
			List<Integer> curr = new ArrayList<>();
			for(int i=0; i<leng;i++) {
				curr.add(skills[i]);
			}
			dict.add(curr);
		}
		
		findTeam(skills, 0, leng-1, k, l, r, dict);
		findTeam(skills, 1, leng, k, l, r, dict);
		return dict.size();
	}
	
	private void findTeam(int[] skills, int left, int right, int k, int l, int r, Set<List<Integer>> dict) {
		if(left>=right) {
			return;
		}
		int count=0;
		for(int i=left; i<right; i++) {
			if(skills[i]>=l && skills[i]<=r) {
				count++;
			}
		}
		if(count<k) {
			return;
		} else {
			List<Integer> curr = new ArrayList<>();
			for(int i=left; i<right;i++) {
				curr.add(skills[i]);
			}
			dict.add(curr);
		}
		findTeam(skills, left, right-1, k, l, r, dict);
		findTeam(skills, left+1, right, k, l, r, dict);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {6,3,5,8};
		Solution504 solution = new Solution504();
		System.out.println(solution.areAnagram("abcd", "dabc"));
		System.out.println(solution.editDistance("abcd", "dabc"));
		System.out.println(solution.beautifulSubarrays(arr,1));;
		System.out.println(solution.beautifulSubarrays1(arr,1));
		System.out.println(solution.climbHill(new int[]{3,3,2,7,8,9}));

		System.out.println(solution.buildSubSequences("abc"));

		System.out.println(solution.getSepicalSubstring("abcde", 1, "10101111"));
		
		System.out.println(solution.countTeams(new int[]{12,4,5,13,5,10}, 3, 4, 10));
	}
}
