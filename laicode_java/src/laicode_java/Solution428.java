package laicode_java;

import java.util.*;
//Remove Duplicate Letters
//Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//Example:
//
//Given "bcabc"
//Return "abc"
//
//Given "cbacdcbc"
//Return "acdb"
//

public class Solution428 {
	public String removeDuplicateLetters(String s) {
		int[] cnt = new int[26];
		int pos = 0;	// the position for the smallest s[i]
		for (int i=0; i<s.length(); i++) {
			cnt[s.charAt(i)-'a']++;
		}
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)<s.charAt(pos)) 
				pos = i;
			if(--cnt[s.charAt(i)-'a']==0) 
				break;
		}
		return s.length()==0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
	}
	
	
	class Node {
	    public int val;
	    public List<Node> children;
	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	    private static final String SEP = ",";
	    private static final String LEFT = "[";
	    private static final String RIGHT = "]";
	    // Encodes a tree to a single string.
	    public String serialize(Node root) {
	        if(root==null)  return "";
	        StringBuilder sb = new StringBuilder();
	        sb.append(String.valueOf(root.val));
	        sb.append(LEFT);
	        for(int i=0; i<root.children.size(); i++) {
	            sb.append(serialize(root.children.get(i)));
	            if(i!=root.children.size()-1)
	                sb.append(SEP);
	        }
	        
	        sb.append(RIGHT);
	        //System.out.println(sb.toString());
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public Node deserialize(String data) {
	        if(data==null || data.length() < 1 || data.charAt(0) == '[') {
	            return null;
	        }
	        System.out.println(data);
	        int left = data.indexOf("[");
	        Node root = new Node(Integer.parseInt(data.substring(0, left)), new ArrayList<>());
	        int right = data.lastIndexOf("]");
	        if(left<right) {
	            // 1[3[5[],6[]],2[],4[]]
	            //      l
	            left++;
	            int start = left;
	            int count = 0;
	            System.out.println(left + " " + right);
	            while(left<right) {
	                if(count==0 && data.charAt(left)==',') {
	                    start=left+1;
	                } else if(data.charAt(left) == '[') {
	                    count++;
	                } else if(data.charAt(left) == ']') {
	                    count--;
	                    if(count == 0) {
	                        String child = data.substring(start, left+1);
	                        System.out.println(child);
	                        root.children.add(deserialize(child));
	                    }
	                }
	                left++;
	            }
	        }
	        System.out.println(root.val);
	        return root;
	    }
	

	public static void main(String[] args) {


	}
}
