package laicode_java;

import java.util.*;

//    Random1000 Using Random5
//    Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
// std::srand(time(NULL)); is called for you.
public class Solution112 {
	private int rand5() {
		return (int)(Math.random()%5);
	}
	
	public int random1000() {
		while(true) {
			int num=0;
			for(int i=0; i<5; i++) {
				num =num*5 + rand5(); 
			}
			if(num<3000) {
				return num%1000;
			}
		}
	}
	public static void main(String[] args) {


	}
}
