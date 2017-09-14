package laicode;

import java.util.*;
//Tweaked Identical Binary Trees
//Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.
//
//Examples
//
//     5
//
//   /    \
//
// 3        8
//
///   \
//
//1      4
//
//and
//
//    5
//
//  /    \
//
// 8        3
//
///   \
//
//1     4
//
//the two binary trees are tweaked identical.
public class Solution050 {
	boolean isTweakedIdentical(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		else if (r1 == null || r2 == null) {
			return false;
		}
		else if (r1.key != r2.key) {
			return false;
		}
		else {
			return (isTweakedIdentical(r1.left, r2.left) && 
				isTweakedIdentical(r1.right, r2.right)) || 
				(isTweakedIdentical(r1.left, r2.right) && 
					isTweakedIdentical(r1.right, r2.left));
		}
	}
	public static void main(String[] args) {


	}
}
