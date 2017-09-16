package laicode_java;

import java.util.*;

//Celebrity Problem
//Given an binary matrix of N * N (the only elements in the matrix are 0s and 1s), each of the indices represents one person.
//matrix[i][j] = 1 if and only if person i knows person j (this is single direction, only if matrix[j][i] = 1 such that person j knows person i).
//  Determine if there is one celebrity among all N persons, a celebrity is defined as
//      He does not know any other person.
//      All the other persons know him.
//      Return the celebrity's index if there exist one (there could be at most one celebrity, why?), return -1 otherwise.
//Assumptions:
//The given matrix is not null and N >= 2.
//Examples:
//matrix = { { 0, 1, 1 },
//          { 0, 0, 0 },
//          { 1, 1, 0 } }
//The celebrity is person 1, since person 0 and person 2 all know him, but person 1 does not know person 0 or person 2.
public class Solution344 {

	public static void main(String[] args) {


	}
}
