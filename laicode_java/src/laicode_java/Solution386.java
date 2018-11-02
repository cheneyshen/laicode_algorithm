package laicode_java;

import java.util.*;

//Inorder Successor
//Determine which node is the current node's successor in the inorder traversal sequence.
//
//The parent pointer is given for the nodes.
//

public class Solution386 {
	public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        helper(result, 1, n);
        return result;
    }
    
    void helper(List<Integer> result, int low, int high) {
        if(low>high) {
            return;
        }
        if(low>0) {
            result.add(low);
        }
        if(low*10<=high) {
            helper(result, low*10, high);
        }
        if(low+1<=(low/10)*10+9 && low<high) {
            helper(result, low+1, high);
        }
    }
    
	public TreeNode next(TreeNode current) {
		// Write your solution here.
		return current;
	}
	
	public static void main(String[] args) {
		Solution386 s = new Solution386();
		s.lexicalOrder(13);
	}
}
