package laicode_java;

import java.util.*;

//Place To Put The Chair I
//Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.
//  
//  Assumptions
//  There is at least one equipment in the gym
//  The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//  It is guaranteed that each 'C' cell is reachable from all 'E' cells.
//  If there does not exist such place to put the chair, just return null (Java) empty vector (C++)
//  Examples
//  
//{ { 'E', 'O', 'C' },
//  {  'C', 'E',  'C' },
//  {  'C',  'C',  'C' } }
//  we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
public class Solution195 {

	public static void main(String[] args) {


	}
}
