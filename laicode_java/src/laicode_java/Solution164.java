package laicode_java;

//Square Root I
//Given an integer number n, find its integer square root.
//
//Assumption:
//
//n is guaranteed to be >= 0.
//Example:
//
//Input: 18, Return: 4
//
//Input: 4, Return: 2

public class Solution164 {
	public int sqrt(int x) {
		if(x<=0) {
			return 0;
		}
		else if(x==1) {
			return 1;
		}
		else {
			int start=2, end=x/2, mid=x/2;
			while(start<=end) {
				mid=start+(end-start)/2;
				if(x/mid==mid) {
					return mid;
				}
				else if(x/mid>mid) {
					start=mid+1;
				}
				else {
					end=mid-1;
				}
			}
			return end; //mid ÊÇ¸öbug
		}
	}
	
	public static void main(String[] args) {
		Solution164 s164 = new Solution164();
		System.out.println(s164.sqrt(100000));
	}
}