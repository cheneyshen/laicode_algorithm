package laicode_java;

import java.util.*;

//Identical Binary Tree
//Check if two given binary trees are identical. Identical means the equal valued keys are at the same position in the two binary trees.
//  
//  Examples
//
//      5
//  
//    /    \
//  
//  3        8
//  
//  and
//
//      5
//  
//    /    \
//  
//  3        8
//  
//  are identical trees.
//  
public class Solution049 {
	boolean isIdentical(TreeNode r1, TreeNode r2) {
        if (r1==null && r2==null) {
            return true;
        }
        else if (r1==null || r2==null) {
            return false;
        }
        else if (r1.key!=r2.key) {
            return false;
        }
        else {
            return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
        }
    }
	public static void main(String[] args) {


	}
}
