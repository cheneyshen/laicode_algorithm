package laicode_java;

import java.util.*;

//    Max Water Trapped I
//    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.
//
//    Assumptions
//
//    The given array is not null
//    Examples
//
//    { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
/*    2 1 3 2 4
 *    0 1 0 1 |
 *            4
 */
public class Solution199 {
	public int maxTrapped(int[] array) {
		int result=0;
		int i=0, j=array.length-1;
		int leftmost=array[i];
		int rightmost=array[j];
		while(i<=j) {
			if(leftmost<=rightmost) {
				if(leftmost<array[i]) {
					leftmost=array[i];
				}
				result+=leftmost-array[i];
				i++;
			} else {
				if(rightmost<array[j]) {
					rightmost=array[j];
				}
				result+=rightmost-array[j];
				j--;
			}
		}
		return result;
	}

	public int maxTrapped(int[] array, int k) {
		int result=0;
		int i=0, j=array.length-1;
		int leftmost=0;
		int rightmost=0;
		while(i<=j) {
			if(leftmost<array[i]) {
				leftmost=array[i];
			}
			if(rightmost<array[j]) {
				rightmost=array[j];
			}
			if(leftmost<=rightmost) {
				result+=leftmost-array[i];
				i++;
			} else {
				result+=rightmost-array[j];
				j--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution199 ss = new Solution199();
		int[] array = new int[]{1,3,2,4,1,3,2,4,3,2};
		System.out.println(ss.maxTrapped(array));
		System.out.println(ss.maxTrapped(array, 2));
	}
	

    public void moveZeroes(int[] nums) {
        
        int low=0, high=nums.length;
        // move all the nonzero elements advance
        for (int i = 0; i < high; i++) {
            if (nums[i] != 0) {
                nums[low++] = nums[i];
            }
        }
        for (;low < high; low++) {
            nums[low] = 0;
        }
        return;
    }
    

    public String addStrings(String num1, String num2) {
        
        String result = "";
        for(int i=num1.length()-1, j=num2.length()-1, carry=0;i>=0 ||j >=0|| carry>0;) {
            if(i>=0) {
                carry+=num1.charAt(i)-'0';
                i--;
            }
            if(j>=0) {
                carry+=num2.charAt(j)-'0';
                j--;
            }
            result=String.valueOf(carry%10) + result;
            carry=carry/10;
        }
        return result;
    }
    

    public String longestPalindrome(String s) {
        
        if(s==null || s.length()<1)
            return "";
        int leng=s.length();
        if(leng==1)
            return s;
          int n = s.length();
        String res = null;
    
        boolean[][] dp = new boolean[leng][leng];
    
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
    
    public class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            helper(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = stack.peek();
            stack.pop();
            if(cur.right!=null) {
                helper(cur.right);
            }
            return cur.key;
        }
        
        public void helper(TreeNode root) {
            TreeNode p = root;
            while(p !=null) {
                stack.push(p);
                p = p.left;
            }
        }
    }
    

    public String reverseWords(String s) {
        if (s==null || s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int i = 0, j = (int)array.length - 1; i <= j; i++, j--) {
            swap(array, i, j);
        }
        for (int i = 0; i<(int)array.length; ) {
            while (i<array.length && array[i] == ' ') {
                i++;
            }
            int j = i;
            while (j<(int)array.length && array[j] != ' ') {
                j++;
            }
            for (int m = i, n = j - 1; m<n; m++, n--) {
                swap(array, m, n);
            }
            i = j;
        }
        return String.valueOf(array);
    }
    
    void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    

    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
         
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }

    public int numSquares(int n) {
       int[] dp = new int[n + 1];
       Arrays.fill(dp, Integer.MAX_VALUE);
       dp[0] = 0;
       for(int i = 0; i <= n; i++){
           for(int j = 1; i + j * j <= n; j++){
               dp[i  + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
       }
       return dp[n];
    }
}
