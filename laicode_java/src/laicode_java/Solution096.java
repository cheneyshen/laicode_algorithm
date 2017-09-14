package laicode_java;

import java.util.*;
//Merge Stones
//	We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers.In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles.We merge the piles of stones until we have only one pile left.Determine the minimum total cost.

//	Assumptions

//	stones is not null and is length of at least 1
//	Examples

//{ 4, 3, 3, 4 }, the minimum cost is 28

//	merge first 4 and first 3, cost 7

//	merge second 3 and second 4, cost 7

//	merge two 7s, cost 14

//	total cost = 7 + 7 + 14 = 28
public class Solution096 {
	public int minCost(int[] stones) {
		int len=stones.length;
		int[][] cost=new int[len][len];
		int[][] subSum=new int[len][len];
		for(int i=0; i<len; i++) {
			for(int j=i; j>=0; j--) {
				if(i==j) {
					cost[i][j]=0;
					subSum[j][i]=stones[i];
				}
				else {
					subSum[j][i]=subSum[j][i-1]+stones[i];
					cost[j][i]=Integer.MAX_VALUE;
					for(int k=j; k<i; k++) {
						cost[j][i]=Math.min(cost[j][i], cost[j][k]+cost[k-1][i]+subSum[j][i]);
					}
				}
			}
		}
		return cost[0][len-1];
	}
	
	public int minCost(int[] stones, int leng) {
		int sum=0;
		for(int i:stones) {
			sum+=i;
		}
		if(leng==1) {
			return 0;
		}
		else if(leng==2) {
			return sum;
		}
		else if(leng==3) {
			return Math.min(stones[0]+stones[1], stones[1]+stones[2])+sum;
		}
		else {
			int result= Integer.MAX_VALUE;
			for(int i=0; i<leng-1; i++) {
				int curr=stones[i]+stones[i+1];
				int[] nextStones=new int[leng-1];
				for(int j=0; j<i; j++) {
					nextStones[j]=stones[j];
				}
				nextStones[i]=curr;
				for(int j=i+2; j<leng; j++) {
					nextStones[j-1]=stones[j];
				}
				result=Math.min(result, minCost(nextStones, leng-1));
			}
			return result;
		}
	}
	
	public static void main(String[] args) {


	}
}
