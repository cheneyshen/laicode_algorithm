package laicode_java;

import java.util.*;

//    Restore IP Addresses
//    Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
//
//Input:  25525511135
//
//Output: 255.255.11.135, 255.255.111.35 
public class Solution147 {
	public List<String> restore(String ip) {
		List<String> combo = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		helper(ip, 0, combo, result);
		return result;
	}
	
	private void helper(String ip, int left, List<String> combo, List<String> result) {
		if(combo.size()==4) {
			if(left==ip.length()) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<4; i++) {
					sb.append(combo.get(i)+".");
				}
				sb.deleteCharAt(sb.length()-1);
				result.add(sb.toString());
			}
		}
		String current="";
		for(int i=left; i<ip.length() && i<left+3; i++) {
			current += ip.charAt(i);
			if(isValidNum(current)) {
				combo.add(current);
				helper(ip, i+1, combo, result);
				combo.remove(combo.size()-1);
			}
		}
	}
	
	private boolean isValidNum(String s) {
		if(s.isEmpty() || s.length()>3) {
			return false;
		}
		if(s.charAt(0) == '0' && s.length()!=1) {
			return false;
		}
		if(s.length()==3 && Integer.valueOf(s) > 255) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String ip = "25525511135";
		Solution147 ss = new Solution147();
		List<String> result = ss.restore(ip);
		for(int i=0; i< result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
