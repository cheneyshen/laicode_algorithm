package laicode_java;

import java.util.*;

//Primes
//Return the primes less than or equals to target in ascending order.
//
//Assumptions:
//
//The given target is >= 2.
//Examples:
//
//target = 3,  return [2, 3]
//target = 10, return [2, 3, 5, 7]
public class Solution312 {
	List<Integer> primes(int n) {
		boolean[] nonPrime = new boolean[n+1];
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(!nonPrime[i]) {
				for(int j=i*2; j<=n; j+=i) {
					nonPrime[j]=true;
				}
			}
		}
		List<Integer> primes = new ArrayList<>();
		for(int i=2; i<=n; i++) {
			if(!nonPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	
	static int result = 0;
    public static int maxCoins(List<Integer> input) {
    	if(input==null || input.size()<1) {
    		return result;
    	}
    	Map<List<Integer>, Integer> map = new HashMap<>();
    	result = helper(input, map);
    	return result;
    }
    
    private static int helper(List<Integer> nums, Map<List<Integer>, Integer> map) {
    	if(nums.size()==3) {
    		int curr = nums.get(0)*nums.get(1)*nums.get(2);
    		if(!map.containsKey(nums)) {
    			map.put(nums, curr);
    		}
    		return curr;
    	}
    	int result = 0 ;
    	for(int i=1; i<nums.size()-1; i++) {
    		int cur = nums.get(i-1)*nums.get(i)*nums.get(i+1);
    		int valuei = nums.remove(i);
    		int nextloop = 0;
    		if(map.containsKey(nums)) {
    			nextloop = map.get(nums);
    		} else {
    			nextloop = helper(nums, map);
    		}
    		result = Math.max(result, cur+nextloop);
    		nums.add(i, valuei);
    	}
    	return result;
    }
    
    public static void validIfBlock(int n) {
    	if(n<=0) {
    		return;
    	}
    	List<String> blocks = new ArrayList<>();
    	helper(blocks, n, n);
    }
    
    private static void helper(List<String> blocks, int left, int right) {
    	if(left==0 && right==0) {
    		for(int i=0; i<blocks.size(); i++) {
    			System.out.println(blocks.get(i));
    		}
    		return;
    	}
    	String cur="";
    	if(left>0) {
    		for(int i=0; i<right-left; i++) {
    			cur+="  ";
    		}
    		blocks.add(cur+"if {");
    		helper(blocks, left-1, right);
    		blocks.remove(blocks.size()-1);
    	}
    	if(right>left) {
    		for(int i=0; i<right-left-1; i++) {
    			cur+="  ";
    		}
    		blocks.add(cur+"}");
    		helper(blocks, left, right-1);
    		blocks.remove(blocks.size()-1);
    	}
    }
    
    public int minCut(String input) {
    	if(input==null || input.length()==0) {
    		return 0;
    	}
    	int len = input.length();
    	int[] dp = new int[len];
    	for(int i=1; i<len; i++) {
    		if(isPalin(input, 0, i)) {
    			dp[i] = 0;
    			continue;
    		}
    		dp[i] = i;
    		for(int j=0; j<i; j++) {
    			if(isPalin(input, j, i)) {
    				dp[i] = Math.max(dp[i], dp[j]+1);
    			}
    		}
    	}
    	return dp[len-1];
    }
    
    private boolean isPalin(String input, int i, int j) {
    	while(i<j) {
    		if(input.charAt(i)!=input.charAt(j)) {
    			return false;
    		}
    		i++;j--;
    	}
    	return true;
    }
    public static List<String> permutationWithOrder(String set) {
    	List<String> res = new ArrayList<>();
    	if(set==null) {
    		return null;
    	}
    	char[] arraySet = set.toCharArray();
    	boolean[] used = new boolean[arraySet.length];
    	StringBuilder cur = new StringBuilder();
    	helperWithOrder(arraySet, used, cur, res);
    	return res;
    }
    
    private static void helperWithOrder(char[] array, boolean[] used, StringBuilder cur, List<String> result) {
        if(cur.length()==array.length) {
            result.add(cur.toString());
            return;
        }
        for(int i=0; i<array.length; i++) {
            if(!used[i]) {
                used[i]=true;
                cur.append(array[i]);
                helperWithOrder(array, used, cur, result);
                used[i]=false;
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
    
	public static void main(String[] args) {
		List<Integer> input = new LinkedList<>();
		input.add(1);
		input.add(3);
		input.add(5);
		input.add(8);
		input.add(1);
		maxCoins(input);
		System.out.println(result);
		validIfBlock(3);
		permutationWithOrder("acf");
	}
}
