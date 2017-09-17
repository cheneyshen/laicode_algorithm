package laicode_java;

import java.util.*;
//    Random7 Using Random5
//    Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().

public class Solution111 {

	private int rand5() {
		return (int)(Math.random()%5);
	}
	public int random7() {
		while(true) {
			int num=0;
			for(int i=0; i<2; i++) {
				num = num*5 + rand5();
			}
			if(num<21) {
				return num%7;
			}
		}
	}
	
	public static void main(String[] args) {


	}
}
