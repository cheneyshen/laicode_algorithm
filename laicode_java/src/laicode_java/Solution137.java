package laicode_java;

import java.util.*;
//    Cutting Wood I
//    There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A.
//    The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.
//    
//    Examples
//    
//    L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
/*
 *   1 2 3 4 5 6 7 8 9 10
 *  |   |   |     |      |
 *  0   1   2     3      4
 *  M[0][4] 
 *  M[0][1]=0 
 *  M[1][2]=0
 *  M[2][3]=0
 *  M[3][4]=0
 *  M[0][2]=M[0][1]+M[1][2]+A2-A0=4
 *  M[1][3]=M[1][2]+M[2][3]+A3-A1=5
 *  M[2][4]=M[2][3]+M[3][4]+A4-A2=6
 *  M[0][3]=Min(M[0][2]+M[2][3]+A3-A0 = 4 + 7,  M[0][1]+M[1][3]+A3-A0 = 5 + 7) = 11
 *  M[1][4]=Min(M[1][3]+M[3][4]+A4-A0 = 5 + 8,  M[1][2]+M[2][4]+A4-A0 = 6 + 8) = 13
 *  M[0][4]=Min(M[0][3]+M[3][4]+A4-A0 = 11+10,  M[0][2]+M[2][4]+A4-A0 = 4+6+10, M[0][1]+M[1][4]+A4-A0 = 13+10) = 20
 */
public class Solution137 {
	public int minCost(int[] cuts, int length) {
		int leng = cuts.length;
		int[] fullcuts = new int[leng+2];
		Arrays.fill(fullcuts, 0);
		// 0 2 4 7 10
		for(int i=1; i<leng; i++) {
			fullcuts[i+1] = cuts[i];
		}
		fullcuts[leng+1]=length;
		int[][] matrix = new int[leng+2][leng+2];
		for(int dist=1; dist<leng+2; dist++) {
			for(int i=0; i<leng+2-dist; i++) {
				int j=dist+i;
				if(dist==1) {
					matrix[i][j]=0;
				}
				else {
					matrix[i][j]=Integer.MAX_VALUE;
					for(int k=i+1; k<j; k++) {
						matrix[i][j]=Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
					matrix[i][j]+=fullcuts[j]-fullcuts[i];
				}
			}
		}
		return matrix[0][leng+1];
	}
	
	public static void main(String[] args) {
		Solution137 ss = new Solution137();
		int[] cuts = {2,4,7};
		int length = 10;
		System.out.println(ss.minCost(cuts, length));
	}
}
