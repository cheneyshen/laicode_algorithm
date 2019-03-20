package laicode_java;

import java.util.*;

//Get Count Array
//Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
//Assumptions:
//The given array A is not null.
//Examples:
//A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
//Requirement:
//time complexity = O(nlogn).
/*	
 * 该题对应leetcode 315
 */
public class Solution276 {
	//方法1: TreeMap 实现方法O(nlog(n))
	public int[] countArray(int[] array) {
		if(array==null || array.length==0) {
			return array;
		}
		if(array.length == 1) {
			return new int[] {0};
		}
		int[] result = new int[array.length];
		NavigableMap<Integer, Integer> map = new TreeMap<>();
		//从后往前计算，对每个数字统计频率
		for(int i=array.length-1; i>=0; i--) {
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
			//NavigableMap的headMap统计有多少个比array[i]小的key
			Map<Integer, Integer> headMap = map.headMap(array[i], false);
			int value = 0;
			for(Map.Entry<Integer, Integer> e : headMap.entrySet()) {
				value += e.getValue();
			}
			result[i] = value;
		}
		return result;
	}
	//方法2: Binary Indexed Tree 实现O(Nlog(N))
	static int lowbit(int x) {
		return x & (-x);
	}
	
	static class FenwickTree {
		private int[] sums;
		public FenwickTree(int n) {
			sums = new int[n+1];
		}
		public void update(int i, int delta) {
			while(i<sums.length) {
				sums[i] += delta;
				i += lowbit(i);
			}
		}
		public int query(int i) {
			int sum = 0;
			while(i>0) {
				sum += sums[i];
				i -= lowbit(i);
			}
			return sum;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		//先对原数组进行排序，得到对应的rank值
		//rank值表示reversed的数组中的值在排序后的sorted的位置
		//  nums = 7 1 3 2 9 2 1
		// sorted = 1 2 3 7 9
		// ranks = 1 2 5 2 3 1 4
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);
		Map<Integer, Integer> ranks = new HashMap<>();
		int rank = 0;
		for(int i=0; i<sorted.length; i++) {
			//rank值是去重的，只有不同时才更新rank
			if(i==0 || sorted[i] != sorted[i-1]) {
				ranks.put(sorted[i], ++rank);
			}
		}
		FenwickTree tree = new FenwickTree(ranks.size());
		List<Integer> res = new ArrayList<>();
		//从后往前查找
		for(int i=nums.length-1; i>=0; i--) {
			//FenwickTree帮助我们从ranks表中找所有的prefix sum值
			//时间复杂度是Log(N)
			int sum = tree.query(ranks.get(nums[i])-1);
			res.add(sum);
			//找到后，更新当前值到prefix sum 树中
			tree.update(ranks.get(nums[i]), 1);
		}
		//反转
		Collections.reverse(res);
		return res;
	}
	
	//方法3:Segment Tree线段树 实现O(Nlog(N))
	static class SegTreeNode {
		int min, max;	// 记录范围 range [min, max]
		int count;	//相同个数
		SegTreeNode left, right;
		public int mid() {
			return min + (max-min+1)/2;
		}
		public SegTreeNode(int min, int max) {
			this.min = min;
			this.max = max;
			this.count = 0;
		}
	}
	
	public List<Integer> countSmaller1(int[] array) {
		List<Integer> list = new LinkedList<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i:array) {
			min = min > i ? i : min;
			max = max < i ? i : max;
		}
		SegTreeNode root = new SegTreeNode(min, max);
		for(int i = array.length-1; i>=0; i--) {
			//array[i]-1, 为了去重
			list.add(0, find(array[i]-1, root));
			add(root, array[i]);
		}
		return list;
	}
	
	private int find(int i, SegTreeNode root) {
		if(root == null) {
			return 0;
		}
		//我们只需要查找比当前数i小的所有数，count正好保存这个信息
		if(i >= root.max) {
			return root.count;
		} else {
			//开始log(n)查找
			int mid = root.mid();
			if(i < mid) {
				return find(i, root.left);
			} else {
				//如果当前数>=mid,则需要找左右两个子树
				return find(i, root.right) + find(i, root.left);
			}
		}
	}
	
	private void add(SegTreeNode root, int x) {
		//如果不在这个有效范围，直接退出, min & max 是提前设置好的
		if(root==null || x<root.min || x>root.max) {
			return;
		}
		//小于等于root.max的count++
		root.count++;
		//左右值相等，区间内只有一个值，到达叶子节点，直接退出
		if(root.max == root.min) {
			return;
		}
		int mid = root.mid();
		if(x < mid) {
			if(root.left == null) {
				root.left = new SegTreeNode(root.min, mid-1);
			}
			//转移到左子树进行更新
			add(root.left, x);
		} else {
			if(root.right == null) {
				root.right = new SegTreeNode(mid, root.max);
			}
			//转移到右子树进行更新
			add(root.right, x);
		}
	}
	
	//方法4:Merge Sort实现O(Nlog(N))
	public List<Integer> countSmaller2(int[] nums) {
		int len = (nums==null ? 0 : nums.length);
		int[][] idxValues = new int[len][2];
		int[] rightSmaller = new int[len];
		for(int i=0; i<len; i++) {
			idxValues[i][0] = i;
			idxValues[i][1] = nums[i];
		}
		mergeSort(idxValues, 0, len, rightSmaller);
		List<Integer> result = new ArrayList<>();
		for(int i : rightSmaller) {
			result.add(i);
		}
		return result;
	}
	private void mergeSort(int[][] idxValues, int left, int right, int[] rightSmaller) {
		if(left+1>=right) {
			return;
		}
		int mid = (right - left)/2 + left;
		mergeSort(idxValues, left, mid, rightSmaller);
		mergeSort(idxValues, mid, right, rightSmaller);
		merge(idxValues, left, right, rightSmaller);
	}
	
	private void merge(int[][] idxValues, int left, int right, int[] rightSmaller) {
		int mid = left + (right-left)/2;
		int[][] leftnums = new int[mid-left][2];
		int[][] rightnums = new int[right-mid][2];
	    // 合并前，将左半部分复制到left，右半部分复制到right, 复制区间为左闭右开
		for(int i=left, j=0, k=0; i<right; i++) {
			if(i<mid) {
				leftnums[j++] = idxValues[i];
			} else {
				rightnums[k++] = idxValues[i];
			}
		}
		// 记录左边已经合并的数量、右边已经合并的数量、总共已经合并的数量
		int left_merged = 0, right_merged = 0, total_merged = 0;
		//假设y在x的右边，且y<x，x在左半部分，y在右半部分。
		//那么在这次合并中，当选择x进行合并的时候，y必定已经合并了。
		//因此，当合并x的时候，右半部分已经合并的那些数字，都是在x右边、比x小的数字。
		while(left_merged < leftnums.length && right_merged < rightnums.length) {
			//较小的表头先合并, [1]表示具体的数值, [0]表示坐标
			if(leftnums[left_merged][1] <= rightnums[right_merged][1]) {
				//rightSmaller记录有多少个来自right, 且小于当前数的
				rightSmaller[leftnums[left_merged][0]] += right_merged;
				idxValues[left+total_merged] = leftnums[left_merged];
				left_merged++;
				total_merged++;
			} else {
				idxValues[left+total_merged] = rightnums[right_merged];
				right_merged++;
				total_merged++;
			}
		}
		//左边没走完,说明左边元素小, 继续加到rightSmaller结果集中
		while(left_merged < leftnums.length) {
			rightSmaller[leftnums[left_merged][0]] += right_merged;
			idxValues[left+total_merged] = leftnums[left_merged];
			left_merged++;
			total_merged++;
		}
		//右边没走完，说明右边元素小，多出一个逆序数, right_merged++
		while(right_merged < rightnums.length) {
			idxValues[left+total_merged] = rightnums[right_merged];
			right_merged++;
			total_merged++;
		}
	}
	
	public static void main(String[] args) {
		Solution276 ss = new Solution276();
		int[] nums = new int[]{5,2,3,3,3,6,1};
		System.out.println(ss.countArray(nums).toString());
	}
}
