package laicode_java;

import java.util.*;

public class Solution507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class CommonElement implements Iterable<Integer> {
	
		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			List<Integer> l1 = new ArrayList<>();
			List<Integer> l2 = new ArrayList<>();
			for(int i=0; i<=20; i+=2) {
				l1.add(i);
			}
			for(int i=0; i<=20; i+=4) {
				l2.add(i);
			}
			return new CommonElementIterator(l1.iterator(), l2.iterator());
		}
		
	}
	
	public class CommonElementIterator implements Iterator<Integer> {
		private Iterator<Integer> iter1, iter2;
		private Integer next;
		
		public CommonElementIterator(Iterator<Integer> iter1, Iterator<Integer> iter2) {
			this.iter1 = iter1;
			this.iter2 = iter2;
			next = findNext();
			
		}
		private Integer findNext() {
			// TODO Auto-generated method stub
			Integer tmp1 = null, tmp2 = null;
			while((iter1.hasNext() || tmp1 !=null) && (iter2.hasNext() || tmp2 !=null)) {
				if(tmp1==null ) {
					tmp1 = iter1.next();
				}
				if(tmp2==null) {
					tmp2 = iter2.next();
				}
				if(tmp1==tmp2) {
					return tmp1;
				} else if(tmp1>tmp2) {
					tmp2 = null;
				} else {
					tmp1 = null;
				}
			}
			return null;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next!=null;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Integer ret = next;
			next = findNext();
			return ret;
		}
		
	}
	
	public int compress(char[] chars) {
		int result = 0, index = 0;
		while(index < chars.length) {
			char curr = chars[index];
			int count=0;
			while(index<chars.length && chars[index] == curr) {
				count++;
				index++;
			}
			chars[result++] = curr;
			if(count!=1) {
				for(char c:Integer.toString(count).toCharArray()) {
					chars[result++] = c;
				}
			}
		}
		return result;
	}
	
	
	public int reverse(int x) {
		int result = 0, newone;
		while(x!=0) {
			int now = x%10;
			newone = result *10 + now;
			if((newone-now)/10 != result) {
				return 0;
			}
			result = newone;
			x = x/10;
		}
		return result;
	}
	
	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if(k<=count) {
			return kthSmallest(root.left, k);
		} else if(k>count+1) {
			return kthSmallest(root.right, k-1-count);
		}
		return root.key;
	}
	
	public int countNodes(TreeNode n) {
		if(n==null) {
			return 0;
		}
		return 1+countNodes(n.left) + countNodes(n.right);
	}
	
	
	Map<Integer, Integer> map;
	int max = 0;
	public int[] findMode(TreeNode root) {
		if(root==null) 
			return new int[0];
		this.map = new HashMap<>();
		inorder(root);
		List<Integer> list = new LinkedList<>();
		for(int key:map.keySet()) {
			if(map.get(key) == max) list.add(key);
		}
		int[] res = new int[list.size()];
		for(int i=0; i<res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	private void inorder(TreeNode node) {
		if(node.left!=null) {
			inorder(node.left);
		}
		map.put(node.key, map.getOrDefault(node.key, 0) + 1);
		max = Math.max(max, map.get(node.key));
		if(node.right!=null) {
			inorder(node.right);
		}
	}
	

    public int numIslands(char[][] grid) {
        
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int result=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    result++;
                    DFS(grid, i, j);
                }
            }
        }
        return result;
    }
    
    void DFS(char[][] grid, int x, int y) {
        grid[x][y]='0';
        if(x>0 && grid[x-1][y]=='1')
            DFS(grid, x-1, y);
        if(x<grid.length-1 && grid[x+1][y]=='1')
            DFS(grid, x+1, y);
        if(y>0 && grid[x][y-1]=='1')
            DFS(grid, x, y-1);
        if(y<grid[0].length-1 && grid[x][y+1]=='1')
            DFS(grid, x, y+1);
    }
    
    class MaxStack {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        /** initialize your data structure here. */
        public MaxStack() {
            
        }
        
        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty() || x>=getMax()) {
                stack2.push(x);
            }
        }
        
        public void pop() {
            if(stack1.peek() == getMax()) {
                stack2.pop();
            }
            stack1.pop();
        }
        
        public int top() {
            return stack1.peek();
        }
        
        public int getMax() {
            return stack2.peek();
        }
    }
    
    public boolean exist(char[][] board, String word) {
        if(board==null) {
            return false;
        }
        int m = board.length, n = board[0].length;
        char[] array = word.toCharArray();
        boolean[] result = new boolean[1];
        result[0] = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(board[i][j] == array[0]) {
                    helper(board, array, i, j, 0, visited, result);
                }
                if(result[0]) {
                    return result[0];
                }
            }
        }
        return result[0];
    }
    
    static void helper(char[][] board, char[] array, int m, int n, int i, boolean[][] visited, boolean[] result) {
        if(result[0] == true) {
            return;
        }
        if(i == array.length-1 && board[m][n]==array[i]) {
            result[0] = true;
            return;
        }
        if(board[m][n] == array[i]) {
            visited[m][n] = true;
            if(m+1<board.length && board[m+1][n]==array[i+1] && visited[m+1][n]==false) {
                helper(board, array, m+1, n, i+1, visited, result);
            }
            if(result[0]) {
                return;
            }
            if(n+1<board[0].length && board[m][n+1]==array[i+1] && visited[m][n+1]==false) {
                helper(board, array, m, n+1, i+1, visited, result);
            }
            if(result[0]) {
                return;
            }
            if(m-1>=0 && board[m-1][n]==array[i+1] && visited[m-1][n]==false) {
                helper(board, array, m-1, n, i+1, visited, result);
            }
            if(result[0]) {
                return;
            }
            if(n-1>=0 && board[m][n-1]==array[i+1] && visited[m][n-1]==false) {
                helper(board, array, m, n-1, i+1, visited, result);
            }
            if(result[0]) {
                return;
            }
            visited[m][n] = false;
        }
    }
    
    public int longestConsecutive(int[] nums) {
    	int res = 0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int n: nums) {
    		if(!map.containsKey(n)) {
    			int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
    			int right = (map.containsKey(n + 1)) ? map.get(n+1) : 0;
    			int sum = left+right+1;
    			map.put(n, sum);
    			res = Math.max(res, sum);
    			map.put(n-left, sum);
    			map.put(n+right, sum);
    		} else {
    			continue;
    		}
    	}
    	return res;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        helper(matrix, result, 0, m, n);
        return result;
    }
    void helper(int[][] matrix, List<Integer> result, int offset, int m, int n) {
        if(m==0 || n==0) {
            return;
        }
        else if(m==1 && n==1) {
            result.add(matrix[offset+m-1][offset+n-1]);
            return;
        } else if(m==1) {
            for(int i=0; i<n; i++) {
                result.add(matrix[offset+m-1][offset+i]);
            }
            return;
        } else if(n==1) {
            for(int i=0;i<m; i++) {
                result.add(matrix[offset+i][offset+n-1]);
            }
            return;
        }
        for(int i=0; i<n-1; i++) {
            result.add(matrix[0+offset][i+offset]);
        }
        for(int i=0; i<m-1; i++) {
            result.add(matrix[i+offset][n-1+offset]);
        }
        for(int j=n-1; j>0; j--) {
            result.add(matrix[m-1+offset][j+offset]);
        }
        for(int j=m-1; j>0; j--) {
            result.add(matrix[j+offset][0+offset]);
        }
        helper(matrix, result, offset+1, m-2, n-2);
    }
    

    public int majorityElement(int[] nums) {
        if(nums==null || nums.length<1) {
            return 0;
        }
        
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0) {
                count++;  //unique++
                major=nums[i];
            } else if(major==nums[i]){
                count++;  //unique++
            } else {
                count--;  //unique的抵消
            }
        }
        return major;
    }
    
    public int findKthLargest(int[] nums, int k) {
    	if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }    

    public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
    	if (start > end) return Integer.MAX_VALUE;
    	
    	int pivot = nums[end];// Take A[end] as the pivot, 
    	int left = start;
    	for (int i = start; i < end; i++) {
    		if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
    			swap(nums, left++, i);			
    	}
    	swap(nums, left, end);// Finally, swap A[end] with A[left]
    	
    	if (left == k)// Found kth smallest number
    		return nums[left];
    	else if (left < k)// Check right part
    		return findKthLargest(nums, left + 1, end, k);
    	else // Check left part
    		return findKthLargest(nums, start, left - 1, k);
    } 

    void swap(int[] A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;				
    }
    
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();
        
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        
        
        return lines;
    }
    

    public int maxProfit(int[] prices) {
        if (prices.length  < 2 ) return 0;
        int maxprofit = 0;
        int minprice = prices[0];
        for (int i = 1;i < prices.length;i++) {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
    
    
}