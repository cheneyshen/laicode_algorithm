package laicode_java;

import java.util.*;

//Rectangle Area
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//Rectangle Area
//Assume that the total area is never beyond the maximum possible value of int.
public class Solution445 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int minWidth, minHeight;
		if(Math.min(C,G) > Math.min(A, E) ) {
			minWidth = Math.min(C, G) - Math.max(A, E);
		} else {
			minWidth = 0;
		}
		if(Math.min(D, H) > Math.max(B, F)) {
			minHeight = Math.min(D, H) - Math.max(B, F);
		} else {
			minHeight = 0;
		}
		return (C-A)*(D-B) - minWidth*minHeight + (G-E)*(H-F);
	}
	public static void main(String[] args) {


	}
}
