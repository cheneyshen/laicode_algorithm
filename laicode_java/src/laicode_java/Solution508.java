package laicode_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution508 {

	
	public int entryTime(String s, String keypad) {
		if(s==null || s.length()<1) {
			return 0;
		}
		if(keypad.length()!=9) {
			return 0;
		}
		int z = 0;
		int[][] array = new int[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				array[i][j] = keypad.charAt(z);
				z++;
			}
		}
		int time = 0;
		int curr = 0;
		for(int i=0; i<s.length(); i++) {
			if(i==0) {
				curr = s.charAt(i);
				continue;
			}
			if(s.charAt(i) != curr) {
				time += getTime(s.charAt(i), curr, array);
			}
			curr = s.charAt(i);
		}
		return time;
	}
	
	private static int getTime(int target, int curr, int[][] array) {
		int currX = 0, currY = 0, nextX = 0, nextY = 0;
		int time = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(target == array[i][j]) {
					currX = i;
					currY = j;
				} else if(curr == array[i][j]) {
					nextX = i;
					nextY = j;
				}
			}
		}
		int diffX = Math.abs(currX - nextX);
		int diffY = Math.abs(currY - nextY);
		if(diffX == 0 && diffY==0) {
			time = 0;
		} else if(diffX == 1 && diffY == 1) {
			time  = 1;
		} else if(diffX == 2 && diffY == 1) {
			time  = 2;
		} else if(diffX == 1 && diffY == 2) {
			time  = 2;
		} else if(diffX == 0 && diffY == 2) {
			time  = 2;
		} else if(diffY == 0 && diffX == 2) {
			time  = 2;
		} else if(diffX == 0 && diffY == 1) {
			time  = 1;
		} else if(diffX == 1 && diffY == 0) {
			time  = 1;
		} else if (diffX == 2 && diffY == 2) {
			time = 2;
		} else {
			time = 0;
		}
		return time;
	}
	
	public int countPalindromes(String s) {
		int result = 0;
		if(s==null || s.length()<1) {
			return result;
		}
		int leng = s.length();
		boolean[][] isPalindrome = new boolean[leng+1][leng+1]; 
		for(int end=1; end<=leng; end++) {
			for(int start=end; start>0; start--) {
				if(s.charAt(start-1)==s.charAt(end-1)) {
					isPalindrome[start][end] = end-start<2 || isPalindrome[start+1][end-1];
				}
				if(isPalindrome[start][end]) {
					result++;
				}
			}
		}
		return result;
	}
	
	public List<String> buildSubsequences(String s) {

		List<String> result = new ArrayList<>();
		if(s==null || s.length()<1) {
			return result;
		}
		StringBuilder combo = new StringBuilder();
		helper(s, 0, combo, result);
		Collections.sort(result);
		return result;
	}
	
	public void helper(String s, int index, StringBuilder combo, List<String> result) {
		if(index==s.length()) {
			if(combo.length()>0) {
				result.add(combo.toString());
			}
			return;
		}
		char cur = s.charAt(index);
		combo.append(cur);
		helper(s, index+1, combo, result);
		combo.deleteCharAt(combo.length()-1);
		helper(s, index+1, combo, result);
	}
	
	public int popularItem(int[] nums) {
		if(nums ==null || nums.length<4) {
			return 0;
		}
		int seg = nums.length/4;
		for(int i=seg; i<nums.length; i+=seg) {
			int first = findFirst(nums[i], 0, i-1, nums);
			if(first == -1)	first = i;
			int last = findLast(nums[i], i+1, nums.length-1, nums);
			if(last == -1) last = i;
			if(last - first + 1 >= seg) {
				return nums[i];
			}
		}
		return -1;
	}
	
	private int findFirst(int t, int s, int e, int[] nums) {
		while(s<=e) {
			int m = s + (e-s)/2;
			if(nums[m] == t && (m==0 || nums[m-1]!=t || nums[m+1]!=t)) {
				return m;
			} else if(nums[m]<t) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
	}
	
	private int findLast(int t, int s, int e, int[] nums) {
		while(s<=e) {
			int m = s + (e-s)/2;
			if(nums[m] == t && (nums[m-1]!=t || m+1==nums.length || nums[m+1]!=t)) {
				return m;
			} else if(nums[m] > t) {
				e = m - 1;
			} else {
				s = m + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution508 s = new Solution508();
		System.out.println(s.entryTime("123", "123456789"));
		System.out.println(s.entryTime("423692", "123456789"));
		System.out.println(s.countPalindromes("abccba"));
		System.out.println(s.countPalindromes("aaa"));
		System.out.println(s.countPalindromes("abc"));
		System.out.println(s.buildSubsequences("ab"));
		
		System.out.println(s.popularItem(new int[]{1, 1, 1, 1, 1, 3, 3, 4, 5, 5, 5, 5, 6, 6, 6, 6}));
	}
	
	

}
