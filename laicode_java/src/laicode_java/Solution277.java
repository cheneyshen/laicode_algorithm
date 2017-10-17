package laicode_java;

import java.util.*;

//Restore From Count Array
//Given an original unsorted array A of size n that contains all integers from  [1….n] (no duplicated numbers) but we do not know A. Instead, we only know a count-array B, in which B[i] represents the number of elements A[j]  (i < j) that are smaller than A[i]. How can we re-store A based on B?
//  Assumptions:
//  The given array is not null.
//  Examples:
//  Given B = { 3, 0, 1, 0 }, then we can restore the original array A = { 4, 1, 3, 2 },
//Requirement:
//time complexity = O(nlogn).
public class Solution277 {
    //    原始数组
    //    5 4 1 3 7 6 2 8 9
    //    后面多少比他小的变形数组
    //    4 3 0 1 2 1 0 0 0
    //    N^2的算法，根据变形数组中每个坐标在升序数组中取出对应的元素，升序的坐标从0开始
    //    演示如下：
    //    变形数组坐标  需要拿走的值  升序数组{1 2 3 4 5 6 7 8 9}
    //         4         5             1 2 3 4 6 7 8 9
    //         3         4             1 2 3 6 7 8 9
    //         0         1             2 3 6 7 8 9
    //         1         3             2 6 7 8 9
    //         2         7             2 6 8 9
    //         1         6             2 8 9
    //         0         2             8 9
    //         0         8             9
    //         0         9             null
    //    当然跟原始数组是一样的
    //    下面想个办法把更新的数组用LOG(N)时间维护
	static class Node {
//      线段树数据结构
//      区间是[1, n]，这里1=l, n=r
//      如果是叶子节点，value为1，其他节点value表示为多少个1的叶子节点
		int value;
		int l, r;
		Node left, right;
		Node(int l, int r) {
			this.l = l;
			this.r = r;
			this.left = null;
			this.right = null;
		}
	}
	
	//	为区间[l,r]构造线段树BST
	Node buildTree(int l, int r) {
		Node root = new Node(l, r);
		if(l==r) {
			root.value = 1;
			return root;
		}
		int mid = l + (r-l)/2;
		root.left = buildTree(l, mid);
		root.right = buildTree(mid+1, r);
		root.value = root.left.value + root.right.value;
		return root;
	}

    // 【查找K大】
    // 看左子树有多少个为1的节点，如果大于等于K，那么就在左子树找
    // 如果小于K，就在右子树找K-左子树的叶子节点个数
    // 当你找到相应的叶子节点，那么她表示的区间[l,r](这里l==r)，就是我们要找的第K个数
    // 当然K属于[1，N]
	int query(Node root, int k) {
		if(root==null) {
			return -1;
		}
		if(root.l == root.r) {
			return root.l;
		}
		if(root.left.value >= k) {
			return query(root.left, k);
		} else {
			return query(root.right, k-root.left.value);
		}
	}
	
    //  【删除]
    //  就是把这个叶子节点标记为0,其他包含这个叶子节点的区间统统num--
	void update(Node root, int num) {
		if(root.l<=num && root.r>=num) {
			root.value--;	//所有经过的节点的value都--
		}
		if(root.l < root.r) {
			update(root.left, num);
			update(root.right, num);
		}
	}
	
	public int[] recover(int[] a) {
//		0 3
//		1 0
//		2 1
//		3 0
//		4 1 3 2
		int[] result = new int[a.length];
        Node root = buildTree(1, a.length);
        for (int i=0; i<a.length; i++) {
        	// a[i]表示后面有多少个比他小的，所以用a[i]+1表示查的第几大
            int curr = query(root, a[i]+1);
            result[i] = curr;
            update(root, curr);
        }
		return result;
	}
	
	public static void main(String[] args) {
		Solution277 ss = new Solution277();
		int[] a = new int[]{3,0,1,0};
		a = ss.recover(a);
		System.out.println(Arrays.toString(a));
		//5 1 2 4 7 8 9 6 3
		//4 0 0 1 2 2 2 1 0       
		int[] b = new int[]{4, 0, 0, 1, 2, 2, 2, 1, 0 };
		b = ss.recover(b);
		System.out.println(Arrays.toString(b));
	}
}
