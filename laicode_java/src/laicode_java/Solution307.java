package laicode_java;

import java.util.*;

//Max Weights Sum Of Intervals
//Given a list of intervals, each interval has (start, end, weight). find a subset of the intervals, such that there is no overlap, and the sum of weight is maximized.
//
//Return the max weights sum.
//Assumptions:
//The given array of intervals is not null and has length of > 0
public class Solution307 {

		int[] tree; // Fenwick tree
		int[] array;
		int n;
		public Solution307(int[] nums) {
			n = nums.length;
			if(n==0) {
				return;
			}
			tree = new int[n];
			array = new int[n];
			for(int i=0; i<n; i++) {
				update(i, nums[i]);
			}
		}
		
		void update(int i, int val) {
			int offset = val - array[i];
			array[i] = val;
			for(; i<n; i|=i+1) {
				tree[i] += offset;
			}
		}
		
		int sumRange(int i, int j) {
			return sum(j) - sum(i);
		}
		
		int sum(int i) {
			int ans=0;
			while(i>=0) {
				ans+=tree[i];
				i&=i+1;
				i--;
			}
			return ans;
		}
		
		class numArrayNaive {
			int[] nums;
			
			public numArrayNaive(int[] nums) {
				this.nums = nums;
			}
			
			void update(int i, int val) {
				this.nums[i] = val;
			}
			
			int sumRange(int i, int j) {
				int sum = 0;
				for(int low = i; low<=j; low++) {
					sum += nums[low];
				}
				return sum;
			}
		}
		//Naive with Buffer
		class numArrayBuffer {
			int[] nums;
			long[] sums;
			List<List<Integer>> buffer;
			
			numArrayBuffer(int[] nums) {
				this.nums = nums;
				this.sums = new long[] {nums.length+1};
				for(int i=0; i<nums.length-1; i++) {
					sums[i+1] = nums[i] + sums[i];
				}
			}
			
			void update(int i, int val) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(i); tmp.add(val-nums[i]);
				nums[i] = val;
				if(buffer.size() > 300) {
					for(int j=0; i<nums.length-1; j++) {
						sums[j+1] = nums[j] + sums[j];
					}
				}
			}
			
			int sumRange(int i, int j) {
				long res = sums[j+1] - sums[i];
				for(int m = 0; m<buffer.size(); m++) {
					if(buffer.get(m).get(0) <= j && buffer.get(m).get(0) >= i) {
						res += buffer.get(m).get(1);
					}
				}
				if(res>=Integer.MAX_VALUE || res<=Integer.MIN_VALUE) {
					return -1;
				} else {
					return (int)res;
				}
			}
		}
		
	    //    Segment Tree
        class segmentTree {
            int start, end;
            segmentTree left, right;
            int sum;
            segmentTree(int s, int e) {
                left=null;
                right=null;
                sum=0;
            }
        };
        
        class numArrayTree {
        	segmentTree root;
        	public int sumRange(segmentTree root, int i, int j) {
        		if(root==null) {
        			return 0;
        		}
        		if(root.start == i && root.end == j) {
        			return root.sum;
        		}
        		int mid = root.start + (root.end-root.start)/2;
        		if(j<=mid) {
        			return sumRange(root.left, i, j);
        		} else if(i>=mid+1) {
        			return sumRange(root.right, i, j);
        		} else {
        			return sumRange(root.right, mid+1, j) + sumRange(root.left, i, mid);
        		}
        	}
        	public segmentTree buildTree(int[] nums, int start, int end) {
        		if(start>end)	return null;
        		segmentTree p = new segmentTree(start, end);
        		if(start==end) {
        			p.sum = nums[start];
        		} else {
        			int mid = start + (end - start)/2;
        			p.left = buildTree(nums, start, mid);
        			p.right = buildTree(nums, mid+1, end);
        			if(p.left != null && p.right != null) {
        				p.sum = p.left.sum + p.right.sum;
        			} else if(p.left!=null) {
        				p.sum = p.left.sum;
        			} else if(p.right!=null) {
        				p.sum = p.right.sum;
        			} else {
        				p.sum = 0;
        			}
        		}
        		return p;
        	}
        	
        	public void updateTree(segmentTree root, int i, int val) {
        		if(root.start == root.end) {
        			root.sum = val;
        		} else {
        			int mid = root.start + (root.end - root.start) / 2;
        			if(i<=mid) {
        				updateTree(root.left, i, val);
        			} else {
        				updateTree(root.right, i, val);
        			}
        			root.sum = root.left.sum + root.right.sum;
        		}
        	}
        	
        	public numArrayTree(int[] array) {
        		this.root = buildTree(array, 0, array.length-1);
        	}
        	
        	public int sumRange(int start, int end) {
        		return sumRange(root, start, end);
        	}
        	
        	public void updateTree(int i, int val) {
        		this.updateTree(root, i, val);
        	}
        }
        
        class numArrayBIT {
        	int[] nums;
        	int[] bits;
        	int n;
        	public void init(int i, int val) {
        		i++;
        		while(i<=n) {
        			bits[i]+=val;
        			i+=(i&-i);
        		}
        	}
        	public int getSum(int i) {
        		int sum=0;
        		i++;
        		while(i>0) {
        			sum += bits[i];
        			i = i-(i&-i);
        		}
        		return sum;
        	}
        	public numArrayBIT(int[] nums) {
        		this.nums = nums;
        		n = nums.length;
        		bits = new int[n+1];
        		for(int i=0; i<n; i++) {
        			init(i, nums[i]);
        		}
        	}
        	
        	public void update(int i, int val) {
        		int diff = val - nums[i];
        		nums[i] = val;
        		init(i, diff);
        	}
        	
        	public int sumRange(int i, int j) {
        		return getSum(j) - getSum(i-1);
        	}
        }
	
    
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5};
		Solution307 s = new Solution307(nums);
		System.out.println(s.sumRange(0, 2));
		s.update(1, 2);
		System.out.println(s.sumRange(0, 2));
	}
}
