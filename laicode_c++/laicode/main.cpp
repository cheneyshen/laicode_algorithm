// laicode.cpp : 定义控制台应用程序的入口点。
//
//#pragma once
//#include"stdafx.h"

#include <algorithm>	// std::sort
#include <assert.h>
#include <functional>	// std::greater
#include <iostream>		// std::cout
#include <queue>
#include <map>
#include <math.h>
#include <set>
#include <stack>
#include <string>
#include <time.h>
#include <unordered_map>
#include <vector>
#include <math.h>       /* pow */
#include <sstream>
#include <unordered_set>
#include <random>
#include <float.h>      /* DBL_MAX */
#include <list>
#include <thread>
#include <condition_variable>
#include <mutex>
#include <unistd.h>
#include <iomanip>

// C++ program to  largest rectangle with all 1s in a binary matrix
using namespace std; 
//
//  main.cpp
//  leetcode
//
//  Created by spring on 8/25/16.
//  Copyright © 2016 spring . All rights reserved.
//

class ListNode {
public:
	int value;
	ListNode* next;
	ListNode(int v) : value(v), next(NULL) {}
};

class TreeNode {
public:
	int value;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int v) : value(v), left(NULL), right(NULL) {}
};

class TreeNodeP {
public:
	int value;
	TreeNodeP* left;
	TreeNodeP* right;
	TreeNodeP* parent;
	TreeNodeP(int v, TreeNodeP* p) :
		value(v), left(NULL), right(NULL), parent(p) {}
};

struct StackMinNode {
	int value;
	int min;
	StackMinNode* next;
	StackMinNode(int v) {
		value = v;
		next = NULL;
	}
};

class GraphNode {
public:
	int value;
	vector<GraphNode*> neighbors;
	GraphNode(int v) : value(v) {}
};

class Point {
public:
    static const int right=0, down=1, left=2, up=3;
    int d, x, y;
    Point(int d, int x, int y): d(d), x(x), y(y){
        
    }
    bool equal(Point p) {
        if(d==p.d && x==p.x && y==p.y) {
            return true;
        }
        else {
            return false;
        }
    }
};
static void printintArray(vector<int> A)
{
	int i;
	for (i = 0; i < (int)A.size(); i++)
		cout << A[i] << " ";
	cout << endl;
}

class Solution1 {
//    Longest Ascending Subsequence
//    Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//    
//    Assumptions
//    
//    A is not null
//    Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//    Because [2, 3, 4, 5] is the longest ascending subsequence.
//
private:
    int find(vector<int> table, int left, int right, int target) {
        while (left<=right) {
            int mid=left+(right-left)/2;
            if(table[mid]==target) {
                right=mid-1;
            }
            else if(table[mid]>target) {
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return right;
    }
public:
    int longest(vector<int> array) {
        if(array.empty()) {
            return 0;
        }
        vector<int> table(array.size()+1, 0);
        int result=1;
        table[1]=array[0];
        for (int i=1; i<array.size(); i++) {
            int index=find(table, 1, result, array[i]);
            if(index==result) {
                table[++result]=array[i];
            }
            else {
                table[index+1]=array[i];
            }
        }
        return result;
    }
};

class Solution4 {
//    Selection Sort
//    Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.
//    
//    Examples
//    
//    {1} is sorted to {1}
//    {1, 2, 3} is sorted to {1, 2, 3}
//    {3, 2, 1} is sorted to {1, 2, 3}
//    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
public:
	vector<int> solve(vector<int> a) {
		// vector<int> result;
		if (a.size() == 1 || a.size() == 0)
			return a;
		for (int i = 0; i<(int)a.size(); i++) {
			int index = i;
			for (int j = i + 1; j<(int)a.size(); j++) {
				if (a[j]<a[index]) {
					index = j;
				}
			}
			swap(a[i], a[index]);
		}
		return a;
	}
};

class Solution8 {
//    Evaluate Reverse Polish Notation
//    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//    
//    Assumption
//    
//    Valid operators are +, -, *, /.
//    Each operand may be an integer or another expression.
//    Examples
//    
//    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public:
    int evalRPN(vector<string> tokens) {
        int leng = tokens.size();
        stack<int> stk;
        for (int i = 0; i < leng; i++)
        {
            if (tokens[i][0]>='1' && tokens[i][0] <= '9')
            {
                int token = stoi(tokens[i]);
                stk.push(token);
            }
            else if (tokens[i]=="+") {
                int b = stk.top(); stk.pop();
                int a = stk.top(); stk.pop();
                int c = a + b;
                stk.push(c);
            }
            else if (tokens[i] == "-") {
                int b = stk.top(); stk.pop();
                int a = stk.top(); stk.pop();
                int c = a - b;
                stk.push(c);
            }
            else if (tokens[i] == "*") {
                int b = stk.top(); stk.pop();
                int a = stk.top(); stk.pop();
                int c = a*b;
                stk.push(c);
            }
            else if(tokens[i]=="/")
            {
                int b = stk.top(); stk.pop();
                int a = stk.top(); stk.pop();
                int c = a / b;
                stk.push(c);
            }
        }
        return stk.top();
    }
};

class Solution9 {
//    
//    Merge Sort
//    Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.
//    
//    Examples
//    
//    {1} is sorted to {1}
//    {1, 2, 3} is sorted to {1, 2, 3}
//    {3, 2, 1} is sorted to {1, 2, 3}
//    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
public:

	vector<int> mergeCombine(vector<int>& left, vector<int>& right) {
		vector<int> output;
		int i = 0, j = 0;
		while (i<(int)left.size() && j<(int)right.size()) {
			if (left[i] <= right[j]) {
				output.push_back(left[i]);
				i++;
			}
			else {
				output.push_back(right[j]);
				j++;
			}
		}
		while (i<left.size()) {
			output.push_back(left[i]);
			i++;
		}
		while (j<right.size()) {
			output.push_back(right[j]);
			j++;
		}
		return output;
	}
	vector<int> mergeSort(vector<int> array) {
		int leng = (int)array.size();
		if (leng <= 1) {
			return array;
		}
		int mid = leng / 2;
		vector<int> result;
		vector<int> leftarray, rightarray;
		for (int i = 0; i<mid; i++) {
			leftarray.push_back(array[i]);
		}
		for (int i = mid; i<leng; i++) {
			rightarray.push_back(array[i]);
		}
		leftarray = mergeSort(leftarray);
		rightarray = mergeSort(rightarray);
		result = mergeCombine(leftarray, rightarray);
		return result;
	}
};

class Solution10 {
//    
//    Quick Sort
//    Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.
//    
//    Examples
//    
//    {1} is sorted to {1}
//    {1, 2, 3} is sorted to {1, 2, 3}
//    {3, 2, 1} is sorted to {1, 2, 3}
//    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
public:
	void quickSortHelper(vector<int>& result, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = left + (right - left) / 2;
		swap(result[pivot], result[right]);
		int index = left;
		for (int i = left; i<right; i++) {
			if (result[i]<result[right]) {
				swap(result[i], result[index]);
				index++;
			}
		}
		swap(result[index], result[right]);
		quickSortHelper(result, left, index);
		quickSortHelper(result, index + 1, right);
	}

	vector<int> quickSort(vector<int> array) {
		int leng = (int)array.size();
		if (leng <= 1) {
			return array;
		}
		vector<int> result = array;
		quickSortHelper(result, 0, leng - 1);
		return result;
	}
};

class Solution11 {
	//Rainbow Sort
	//	Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by - 1, Green is denoted by 0, and Blue is denoted by 1).

	//	Examples

	//{ 0 } is sorted to{ 0 }
	//{1, 0} is sorted to{ 0, 1 }
	//{1, 0, 1, -1, 0} is sorted to{ -1, 0, 0, 1, 1 }
	//	Assumptions

	//	The input array is not null.
public:
	vector<int> rainbowSort(vector<int> a) {
		int leng = (int)a.size();
		vector<int> result = a;
		if (leng <= 1) {
			return a;
		}
		int first = 0, second = 0, third = leng - 1;
		while (second <= third) {
			if (result[second] == -1) {
				swap(result[first], result[second]);
				first++;
				second++;
			}
			else if (result[second] == 1) {
				swap(result[second], result[third]);
				third--;
			}
			else {
				second++;
			}
		}
		return result;
	}
};

class Solution12 {

	//Fibonacci Number
	//	Get the Kth number in the Fibonacci Sequence. (K is 0 - indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

	//	Examples

	//	0th fibonacci number is 0
	//	1st fibonacci number is 1
	//	2nd fibonacci number is 1
	//	3rd fibonacci number is 2
	//	6th fibonacci number is 8
	//	Corner Cases

	//	What if K < 0 ? in this case, we should always return 0.
public:
	long fibonacci(int K) {
		if (K <= 0) {
			return 0;
		}
		else if (K == 1) {
			return 1;
		}
		long prepre = 0;
		long pre = 1;
		long result = 0;
		for (int i = 2; i <= K; i++) {
			result = prepre + pre;
			prepre = pre;
			pre = result;
		}
		return result;
	}
};

class Solution13 {

	//a to the power of b
	//	Evaluate a to the power of b, assuming both a and b are integers and b is non - negative.

	//	Examples

	//	power(2, 0) = 1
	//	power(2, 3) = 8
	//	power(0, 10) = 0
	//	power(-2, 5) = -32
public:
	long power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (b < 0) {
			return 0;
		}
		else if (b % 2 == 0) {
			long long result = power(a, b / 2);
			return result*result;
		}
		else {
			long long result = power(a, b / 2);
			return result*result*a;
		}
	}
};

class Solution14 {

	//Classical Binary Search
	//	Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

	//	Assumptions

	//	There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
	//	Examples

	//	A = { 1, 2, 3, 4, 5 }, T = 3, return 2
	//	A = { 1, 2, 3, 4, 5 }, T = 6, return -1
	//	A = { 1, 2, 2, 2, 3, 4 }, T = 2, return 1 or 2 or 3
public:
	int solve(vector<int> input, int target) {
		int leng = (int)input.size();
		if (leng == 0) {
			return -1;
		}
		int left = 0, right = leng - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (input[mid] == target) {
				return mid;
			}
			else if (input[mid]>target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}
};

class Solution15 {

	//First Occurrence
	//	Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

	//	Assumptions

	//	There can be duplicate elements in the array.
	//	Examples

	//	A = { 1, 2, 3 }, T = 2, return 1
	//	A = { 1, 2, 3 }, T = 4, return -1
	//	A = { 1, 2, 2, 2, 3 }, T = 2, return 1
public:
	int firstOccur(vector<int> input, int target) {
		int leng = (int)input.size();
		if (leng == 0) {
			return -1;
		}
		else if (leng == 1) {
			if (target == input[0]) {
				return 0;
			}
			else {
				return -1;
			}
		}
		int left = 0, right = leng - 1;
		int mid = 0;
		while (left<right - 1) {
			mid = left + (right - left) / 2;
			if (input[mid] == target) {
				right = mid;
			}
			else if (input[mid]>target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		if (input[left] == target) {
			return left;
		}
		if (input[right] == target) {
			return right;
		}
		return -1;
	}
};

class Solution16 {
	//Last Occurrence
	//	Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.

	//	Assumptions

	//	There can be duplicate elements in the array.

	//	Examples

	//	A = { 1, 2, 3 }, T = 2, return 1
	//	A = { 1, 2, 3 }, T = 4, return -1
	//	A = { 1, 2, 2, 2, 3 }, T = 2, return 3
public:
	int lastOccur(vector<int> input, int target) {
		int leng = (int)input.size();
		if (leng == 0) {
			return -1;
		}
		else if (leng == 1) {
			if (target == input[0]) {
				return 0;
			}
			else {
				return -1;
			}
		}
		int left = 0, right = leng - 1;
		int mid = 0;
		while (left<right - 1) {
			mid = left + (right - left) / 2;
			if (input[mid] == target) {
				left = mid;
			}
			else if (input[mid]>target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		if (input[right] == target) {
			return right;
		}
		if (input[left] == target) {
			return left;
		}
		return -1;
	}
};

class Solution17 {

	//Closest In Sorted Array
	//	Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

	//	Assumptions

	//	There can be duplicate elements in the array, and we can return any of the indices with same value.
	//	Examples

	//	A = { 1, 2, 3 }, T = 2, return 1
	//	A = { 1, 4, 6 }, T = 3, return 1
	//	A = { 1, 4, 6 }, T = 5, return 1 or 2
	//	A = { 1, 3, 3, 4 }, T = 2, return 0 or 1 or 2
public:
	int solve(vector<int> input, int target) {
		int leng = (int)input.size();
		if (leng == 0) {
			return -1;
		}
		int left = 0, right = leng - 1;
		int mid = 0;
		while (left<right - 1) {
			mid = left + (right - left) / 2;
			if (input[mid] == target) {
				return mid;
			}
			else if (input[mid]>target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		if (abs(input[left] - target) > abs(input[right] - target)) {
			return right;
		}
		else {
			return left;
		}
	}
};

class Solution19 {

	//K Closest In Sorted Array
	//	Given a target integer T, a non - negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

	//	Assumptions

	//	A is not null
	//	K is guranteed to be >= 0 and K is guranteed to be <= A.length
	//	Return

	//	A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
public:
	vector<int> kClosest(vector<int> array, int target, int k) {
		int leng = (int)array.size();
		if (leng == 0) {
			return array;
		}
		vector<int> result;
		if (k == 0) {
			return result;
		}
		int left = 0, right = leng - 1;
		int mid = 0;
		while (left<right - 1) {
			mid = left + (right - left) / 2;
			if (array[mid] == target) {
				right = mid;
			}
			else if (array[mid]>target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		while (left >= 0 && right<leng && k) {
			if (abs(array[left] - target) <= abs(array[right] - target)) {
				result.push_back(array[left]);
				left--;
				k--;
			}
			else {
				result.push_back(array[right]);
				right++;
				k--;
			}
		}
		while (left >= 0 && k) {
			result.push_back(array[left]);
			left--;
			k--;
		}
		while (right<leng && k) {
			result.push_back(array[right]);
			right++;
			k--;
		}
		return result;
	}
};

class Solution20 {
	//Search In Unknown Sized Sorted Array
	//	Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary.Return the index of T in A, return -1 if T is not in A.

	//	Assumptions

	//	dictionary A is not null
	//	dictionary.get(i) will return null(Java) / INT_MIN(C++) if index i is out of bounds
private:
	class UnknownSizeVector {
	public:
		int get(int index) {
			//Return INT_MIN if out of bound;
			//Otherwise return the element value;
			return INT_MIN;
		}
	};
	int binarySearch(UnknownSizeVector& input, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (input.get(mid) == INT_MIN || input.get(mid)>target) {
				right = mid - 1;
			}
			else if (input.get(mid)<target) {
				left = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
public:
	int solve(UnknownSizeVector input, int target) {
		int left = 0, right = 1;
		while (input.get(right) != INT_MIN && input.get(right)<target) {
			left = right;
			right = 2 * right;
		}
		return binarySearch(input, target, left, right);
	}
};

class Solutino21 {
//    Search In Shifted Sorted Array I
//    Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//    
//    For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//        
//        Assumptions
//        
//        There are no duplicate elements in the array.
//        Examples
//        
//        A = {3, 4, 5, 1, 2}, T = 4, return 1
//        A = {1, 2, 3, 4, 5}, T = 4, return 3
//        A = {3, 5, 6, 1, 2}, T = 4, return -1
//        Corner Cases
//    
//        What if A is null or A is of zero length? We should return -1 in this case.
public:
    int search(vector<int> input, int target) {
        int left=0, right=input.size()-1;
        while (left<right) {
            int mid=left+(right-left)/2;
            if (input[mid]>input[right]) {
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        int shift=left;
        left=0, right=input.size()-1;
        while (left<=right) {
            int mid=left+(right-left)/2;
            int realmid=(mid+shift)%input.size();
            if(input[realmid]==target) {
                return realmid;
            }
            else if(input[realmid]>target) {
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return -1;
    }
};

class Solution22 {
//    Search In Shifted Sorted Array II
//    Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//    
//    For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//        
//        Assumptions
//        
//        There could be duplicate elements in the array.
//        Examples
//        
//    A = {3, 4, 5, 1, 2}, T = 4, return 1
//    A = {3, 3, 3, 1, 3}, T = 1, return 3
//    A = {3, 1, 3, 3, 3}, T = 1, return 1
//    ​Corner Cases
//    
//    What if A is null or A is of zero length? We should return -1 in this case.
public:
    int solve(vector<int> input, int target) {
        if(input.size()==0) {
            return -1;
        }
        int left=0, right=input.size()-1;
        while (left<=right) {
            int mid=left+(right-left)/2;
            if (input[mid]==target) {
                return mid;
            }
            else if(input[mid]==input[left]) {
                left++;
            }
            else if(input[mid]>input[left]) {
                if (input[mid]>=target && target>=input[left]) {
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            else {
                if (input[mid]<=target && input[right]>=target) {
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
};

class Solution23 {
//    Shift Position
//    Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.
//    
//    Assumptions
//    
//    There are no duplicate elements in the array
//    Examples
//    
//    A = {3, 4, 5, 1, 2}, return 3
//    A = {1, 2, 3, 4, 5}, return 0
//    Corner Cases
//    
//    What if A is null or A is of zero length? We should return -1 in this case.
public:
    int shiftPosition(vector<int> input) {
        if(input.size()<=0) {
            return -1;
        }
        int left=0, right=input.size()-1;
        while (left<right) {
            int mid=left+(right-left)/2;
            if (input[mid]>=input[right]) {
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }
};

class Solution24 {
//    Total Occurrence
//    Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.
//    
//    Examples
//    
//    A = {1, 2, 3, 4, 5}, T = 3, return 1
//    A = {1, 2, 2, 2, 3}, T = 2, return 3
//    A = {1, 2, 2, 2, 3}, T = 4, return 0
//    Corner Cases
//    
//    What if A is null? We should return 0 in this case.
public:
    int totalOccurrence(vector<int> input, int target) {
        if (input.size()<=0) {
            return 0;
        }
        int left=0, right=input.size()-1;
        int first=-1, last=-1;
        while (left<right-1) {
            int mid=left+(right-left)/2;
            if (input[mid]==target) {
                right=mid;
            }
            else if (input[mid]>target) {
                right=mid;
            }
            else {
                left=mid;
            }
        }
        if (input[left]==target) {
            first=left;
        }
        else if (input[right]==target) {
            first=right;
        }
        if (first==-1) {
            return 0;
        }
        left=0, right=input.size()-1;
        while (left<right-1) {
            int mid=left+(right-left)/2;
            if(input[mid]==target) {
                left=mid;
            }
            else if(input[mid]<target) {
                left=mid;
            }
            else {
                right=mid;
            }
        }
        if (input[right]==target) {
            last=right;
        }
        else if (input[left]==target) {
            last=left;
        }
        return last-first+1;
    }
};

class Solution25 {
    //    K Smallest In Unsorted Array
    //    Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
    //
    //    Assumptions
    //
    //    A is not null
    //    K is >= 0 and smaller than or equal to size of A
    //    Return
    //
    //    an array with size K containing the K smallest numbers in ascending order
    //    Examples
    //
    //    A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
public:
    vector<int> KSmallest(vector<int> input, int k) {
        priority_queue<int> mypq;
        int leng = (int)input.size();
        vector<int> result(k, 0);
        for (int i = 0; i<leng; i++) {
            mypq.push(input[i]);
        }
        for (int i = leng; i >= k; i--) {
            while (mypq.size()>k) {
                mypq.pop();
            }
        }
        while (!mypq.empty()) {
            result.insert(result.begin(), mypq.top());
            mypq.pop();
        }
        return result;
    }
};

class Solution26 {
    //    Kth Smallest Number In Sorted Matrix
    //    Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
    //
    //        Assumptions
    //
    //        the matrix is not null, N > 0 and M > 0
    //        K > 0 and K <= N * M
    //        Examples
    //
    //      { {1,  3,   5,  7},
    //        {2,  4,   8,   9},
    //        {3,  5, 11, 15},
    //        {6,  8, 13, 18} }
    //
    //        the 5th smallest number is 4
    //        the 8th smallest number is 6
    
public:
    class comphelper {
    public:
        bool operator()(pair<int, pair<int, int>> p1, pair<int, pair<int, int>> p2) {
            return p1.first>p2.first;
        }
    };
    int kthSmallest(vector<vector<int>> matrix, int k) {
        int m = (int)matrix.size(), n = (int)matrix[0].size();
        if (k>m*n || k<1) {
            return -1;
        }
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, comphelper> mypq;
        set<pair<int, int>> myset;
        int row = 0, col = 0;
        mypq.push(make_pair(matrix[row][col], make_pair(row, col)));
        myset.insert(make_pair(row, col));
        while (1) {
            pair<int, pair<int, int>> p = mypq.top();
            mypq.pop();
            //            cout<<mypq.size()<<endl;
            if (k == 1) {
                return p.first;
            }
            k--;
            row = p.second.first;
            col = p.second.second;
            if (row<m - 1 && myset.find(make_pair(row + 1, col)) == myset.end()) {
                myset.insert(make_pair(row + 1, col));
                mypq.push(make_pair(matrix[row + 1][col], make_pair(row + 1, col)));
            }
            if (col<n - 1 && myset.find(make_pair(row, col + 1)) == myset.end()) {
                myset.insert(make_pair(row, col + 1));
                mypq.push(make_pair(matrix[row][col + 1], make_pair(row, col + 1)));
            }
        }
        return 0;
    }
};

class Solution27 {
    //    Kth Smallest Sum In Two Sorted Arrays
    //    Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.
    //
    //    Assumptions
    //
    //    A is not null and A is not of zero length, so as B
    //    K > 0 and K <= m * n
    //    Examples
    //
    //    A = {1, 3, 5}, B = {4, 8}
    //
    //    1st smallest s is 1 + 4 = 5
    //    2nd smallest s is 3 + 4 = 7
    //    3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
    //    5th smallest s is 3 + 8 = 11
public:
    class Pair {
    public:
        int first;
        int second;
        Pair(int first, int second) {
            this->first=first;
            this->second=second;
        }
    };
    
    class Combo {
    public:
        int a,b;
        Combo(int a, int b) : a(a), b(b){
        }
        string toString() {
            return to_string(a)+" "+to_string(b);
        }
    };
    
    class Node {
    public:
        Pair* pa;
        Pair* pb;
        Node(Pair* pa, Pair* pb) : pa(pa), pb(pb){
        }
    };
    
    class comphelper {
    public:
        bool operator() (Node* a, Node* b) {
            int a1=a->pa->first+a->pb->first;
            int b1=b->pa->first+b->pb->first;
            return a1>b1;
        }
    };
    
    int kthSum(vector<int> a, vector<int> b, int k) {
        priority_queue<Node*, vector<Node*>, comphelper> myque;
        unordered_set<string> myset;
        int aleng=a.size();
        int bleng=b.size();
        int loop=k;
        if (aleng==0 || bleng==0) {
            return 0;
        }
        if (k<=0 || k>aleng*bleng) {
            return 0;
        }
        Pair* aone=new Pair(a[0], 0);
        Pair* bone=new Pair(b[0], 0);
        Node* one=new Node(aone, bone);
        Combo* newbo=new Combo(0, 0);
        myque.push(one);
        myset.insert(newbo->toString());
        while (!myque.empty()) {
            Node* now=myque.top(); myque.pop();
            loop--;
            if (loop==0) {
                return now->pa->first+now->pb->first;
            }
            int aindex=now->pa->second;
            int bindex=now->pb->second;
            newbo=new Combo(aindex+1, bindex);
            if (aindex+1<aleng && myset.count(newbo->toString())==0) {
                aone=new Pair(a[aindex+1], aindex+1);
                Node* newone=new Node(aone, now->pb);
                myque.push(newone);
                myset.insert(newbo->toString());
            }
            newbo=new Combo(aindex, bindex+1);
            if (bindex+1<bleng && myset.count(newbo->toString())==0) {
                bone=new Pair(b[bindex+1], bindex+1);
                Node* newtwo=new Node(now->pa, bone);
                myque.push(newtwo);
                myset.insert(newbo->toString());
            }
        }
        return 0;
    }
};

class Solution28 {
    //    Selection Sort Linked List
    //    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The selectoin sort algorithm should be used to solve this problem.
    //
    //    Examples
    //
    //    null, is sorted to null
    //    1 -> null, is sorted to 1 -> null
    //    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
    //    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to 2 -> 3 -> 4 -> 5 -> 6
public:
    ListNode* selectionSort(ListNode* a) {
        for (ListNode* node1=a; node1!=NULL; node1=node1->next) {
            ListNode* min=node1;
            for (ListNode* node2=node1; node2!=NULL; node2=node2->next) {
                if (min->value>node2->value) {
                    min=node2;
                }
            }
            swap(node1->value, min->value);
        }
        return a;
    }
};

class Solution29 {
    //    Merge Sort Linked List
    //    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.
    //
    //    Examples
    //
    //    null, is sorted to null
    //    1 -> null, is sorted to 1 -> null
    //    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
    //    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
public:
    ListNode* mergeSort(ListNode* a) {
        // write your solution here
        if (a==NULL || a->next==NULL) {
            return a;
        }
        ListNode* left=a;
        ListNode* right=getMiddle(a);
        ListNode* prev=right;
        right=right->next;
        if (prev!=NULL) {
            prev->next=NULL;
        }
        left=mergeSort(left);
        right=mergeSort(right);
        a=merge(left, right);
        return a;
    }
private:
    //	4 2 6 -3 5
    //	le=0, ri=length-1=4
    //	mid=2
    //	4 2 6 -3 5
    //	sort(lefthalf);
    //	sort(righthalf);
    //	merge(lefthalf, righthalf);
    ListNode* getMiddle(ListNode* head) {
        if (head==NULL || head->next==NULL) {
            return head;
        }
        ListNode *slow=head, *fast=head;
        while (fast->next!=NULL && fast->next->next!=NULL) {
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    
    ListNode* merge(ListNode* left, ListNode* right) {
        if (left==NULL) {
            return right;
        }
        else if (right==NULL) {
            return left;
        }
        else {
            ListNode *result, *index;
            if (left->value<=right->value) {
                result=left;
                left=left->next;
            }
            else {
                result=right;
                right=right->next;
            }
            index=result;
            while (left && right) {
                if (left->value<=right->value) {
                    index->next=left;
                    left=left->next;
                    index=index->next;
                }
                else {
                    index->next=right;
                    right=right->next;
                    index=index->next;
                }
            }
            if (left!=NULL) {
                index->next=left;
            }
            if (right!=NULL) {
                index->next=right;
            }
            return result;
        }
    }
};

class Solution30 {
    //    Quick Sort Linked List
    //    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The quick sort algorithm should be used to solve this problem.
    //
    //    Examples
    //
    //    null, is sorted to null
    //    1 -> null, is sorted to 1 -> null
    //    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
    //    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
public:
    ListNode* quickSort(ListNode* a) {
        //		每次选header为pivot
        //		把所有小于等于pivot的节点都挪到前面，再将pivot移到指针位置
        //		这样，小于等于pivot的都在该节点左边，大于等于的都在右边
        //		再重新quickSort左半边，右半边
        if (a==NULL || a->next==NULL) {
            return a;
        }
        ListNode* head=a;
        ListNode* result=quickSortHelper(head, NULL);
        return result;
    }
private:
    ListNode* quickSortHelper(ListNode* head, ListNode* tail) {
        if (head==NULL || head==tail) {
            return head;
        }
        ListNode* pivot=partition(head, tail);
        quickSortHelper(head, pivot);
        quickSortHelper(pivot->next, tail);
        return head;
    }
    
    ListNode* partition(ListNode* head, ListNode* tail) {
        int pivot=head->value;
        ListNode *i=head, *j=head->next;
        while (j!=tail) {
            if (j->value<=pivot) {
                i=i->next;
                swap(i->value, j->value);
            }
            j=j->next;
        }
        head->value=i->value;
        i->value=pivot;
        return i;
    }
};


class Solution31 {
//    Queue By Two Stacks
//Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.
//    
//    C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.
//    
//    Assumptions
//    
//    The elements in the queue are all Integers.
//    size() should return the number of elements buffered in the queue.
//    isEmpty() should return true if there is no element buffered in the queue, false otherwise.
private:
	stack<int> stack1;
	stack<int> stack2;
public:
	//    Solution31() {
	//    }
	//    ~Solution31() {
	//        while (!stack1.empty()) {
	//            stack1.pop();
	//        }
	//        while (!stack2.empty()) {
	//            stack2.pop();
	//        }
	//    }
	void pop() {
		if (!stack2.empty()) {
			return stack2.pop();
		}
		else if (!stack1.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.top());
				stack1.pop();
			}
			return stack2.pop();
		}
		else {
			return;
		}
	}
	void push(int element) {
		stack1.push(element);
	}
	int front() {
		if (!stack2.empty()) {
			return stack2.top();
		}
		else if (!stack1.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.top());
				stack1.pop();
			}
			return stack2.top();
		}
		else {
			return -1;
		}
	}
	int size() {
		return (int)stack1.size() + (int)stack2.size();
	}
	bool isEmpty() {
		return stack1.empty() && stack2.empty();
	}
};

class Solution32 {
//    Stack With min()
//    Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
//    
//    pop() - remove and return the top element, if the stack is empty, return -1
//    push(int element) - push the element to top
//    top() - return the top element without remove it, if the stack is empty, return -1
//    min() - return the current min value in the stack.
private:
	StackMinNode* head;
public:
	Solution32() {
		head = NULL;
	}
	~Solution32() {
		while (head != NULL) {
			StackMinNode* temp = head;
			head = head->next;
			delete temp;
		}
	}

	void push(int x) {
		StackMinNode* temp = new StackMinNode(x);
		temp->next = head;
		if (head == NULL) {
			temp->min = x;
		}
		else {
			temp->min = std::min(x, head->min);
		}
		head = temp;
	}

	int top() {
		if (head == NULL) {
			return -1;
		}
		return head->value;
	}

	int min() {
		if (head == NULL) {
			return -1;
		}
		return head->min;
	}
};

class Solution33 {
//    Number Of Nodes
//    Return the number of nodes in the linked list.
//    
//    Examples
//    
//    L = null, return 0
//    L = 1 -> null, return 1
//    L = 1 -> 2 -> null, return 2
public:
    int numberOfNodes(ListNode* head) {
        int result=0;
        while (head!=NULL) {
            head=head->next;
            result+=1;
        }
        return result;
    }
};

class Solution34 {
//    Reverse Linked List
//    Reverse a singly-linked list.
//    
//    Examples
//    
//    L = null, return null
//    L = 1 -> null, return 1 -> null
//    L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
public:
	ListNode* reverse(ListNode* head) {
		if (head == NULL || head->next == NULL) {
			return head;
		}
		ListNode* prev = NULL;
		ListNode* next = NULL;
		ListNode* current = head;
		while (current) {
			next = current->next;
			current->next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	ListNode* reverse1(ListNode* head) {
		if (head == NULL || head->next == NULL) {
			return head;
		}
		ListNode* new_node = head->next;
		ListNode* new_head = reverse1(new_node);
		new_node->next = head;
		head->next = NULL;
		return new_head;
	}
};

class Solution35 {
    //    Reverse Linked List In Pairs
    //    Reverse pairs of elements in a singly-linked list.
    //
    //    Examples
    //
    //    L = null, after reverse is null
    //    L = 1 -> null, after reverse is 1 -> null
    //    L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
    //    L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
public:
    ListNode* reverseInPairs(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* nexter = head->next;
        head->next = reverseInPairs(nexter->next);
        nexter->next = head;
        return nexter;//!
    }
};

class Solution36 {
//    Middle Node Of Linked List
//    Find the middle node of a given linked list.
//    
//    Examples
//    
//    L = null, return null
//    L = 1 -> null, return 1
//    L = 1 -> 2 -> null, return 1
//    L = 1 -> 2 -> 3 -> null, return 2
//    L = 1 -> 2 -> 3 -> 4 -> null, return 2
public:
	ListNode* middleNode(ListNode* head) {
		if (head == NULL || head->next == NULL) {
			return head;
		}
		ListNode* fast = head;
		ListNode* slow = head;
		while (fast->next && fast->next->next) {
			fast = fast->next;
			slow = slow->next;
			if (fast) {
				fast = fast->next;
			}
		}
		return slow;
	}
};

class Solution37 {
//    Check If Linked List Has A Cycle
//    Check if a given linked list has a cycle. Return true if it does, otherwise return false.
public:
	bool hasCycle(ListNode* head) {
		ListNode* fast = head;
		ListNode* slow = head;
		while (fast && slow) {
			fast = fast->next;
			slow = slow->next;
			if (fast) {
				fast = fast->next;
			}
			else {
				return false;
			}
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
};

class Solution38 {
//    Cycle Node In Linked List
//    Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.
public:
    ListNode* cycleNode(ListNode* head) {
        ListNode* fast=head;
        ListNode* slow=head;
        while (fast && slow) {
            fast=fast->next;
            slow=slow->next;
            if (fast) {
                fast=fast->next;
            }
            else {
                return NULL;
            }
            if (fast==slow) {
                fast=head;
                while (fast && slow && fast!=slow) {
                    fast=fast->next;
                    slow=slow->next;
                }
                return fast;
            }
        }
        return NULL;
    }
};

class Solution39 {
//    Insert In Sorted Linked List
//    Insert a value in a sorted linked list.
//    
//    Examples
//    
//    L = null, insert 1, return 1 -> null
//    L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
//    L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
//    L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
public:
	ListNode* insert(ListNode* head, int value) {
		ListNode* node = new ListNode(value);
		if (head == NULL || head->value >= value) {
			node->next = head;
			head = node;
			return head;
		}
		ListNode* prev = head;
		while (prev->next != NULL && prev->next->value<value) {
			prev = prev->next;
		}
		node->next = prev->next;
		prev->next = node;
		return head;
	}
};

class Solution40 {
//    Merge Two Sorted Linked Lists
//    Merge two sorted lists into one large sorted list.
//    
//    Examples
//    
//    L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
//    L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
//    L1 = null, L2 = null, merge L1 and L2 to null
public:
	ListNode* merge(ListNode* one, ListNode* two) {
		if (one == NULL && two == NULL) {
			return one;
		}
		else if (one == NULL) {
			return two;
		}
		else if (two == NULL) {
			return one;
		}
		else {
			ListNode* fakeHead = new ListNode(-1);
			ListNode* current = fakeHead;
			while (one != NULL && two != NULL) {
				if (one->value <= two->value) {
					current->next = one;
					one = one->next;
				}
				else {
					current->next = two;
					two = two->next;
				}
				current = current->next;
			}
			while (one != NULL) {
				current->next = one;
				one = one->next;
				current = current->next;
			}
			while (two != NULL) {
				current->next = two;
				two = two->next;
				current = current->next;
			}
			return fakeHead->next;
		}
	}
};

class Solution41 {
//    ReOrder Linked List
//    Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
//    
//    Examples
//    
//    L = null, is reordered to null
//    L = 1 -> null, is reordered to 1 -> null
//    L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
//    L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
private:
	ListNode* reorderHelper(ListNode* left, ListNode* right) {
		if (left == NULL && right == NULL) {
			return NULL;
		}
		else if (left == NULL) {
			return right;
		}
		else if (right == NULL) {
			return left;
		}
		else {
			ListNode* fakehead = new ListNode(-1);
			ListNode* current = fakehead;
			int index = 0;
			while (left != NULL && right != NULL) {
				if (index % 2 == 0) {
					current->next = left;
					left = left->next;
					index++;
					current = current->next;
				}
				else {
					current->next = right;
					right = right->next;
					index++;
					current = current->next;
				}
			}
			while (left != NULL) {
				current->next = left;
				left = left->next;
				current = current->next;
			}
			while (right != NULL) {
				current->next = right;
				right = right->next;
				current = current->next;
			}
			return fakehead->next;
		}
	}

	ListNode* reverse(ListNode* head) {
		if (head == NULL || head->next == NULL) {
			return head;
		}
		ListNode* prev = NULL;
		ListNode* next = NULL;
		ListNode* current = head;
		while (current) {
			next = current->next;
			current->next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
public:
	ListNode* reorder(ListNode* head) {
		if (head == NULL || head->next == NULL || head->next->next == NULL) {
			return head;
		}
		ListNode* fast = head;
		ListNode* slow = head;
		ListNode* prev = NULL;
		while (fast->next != NULL && fast->next->next != NULL) {
			fast = fast->next;
			prev = slow;
			slow = slow->next;
			if (fast != NULL) {
				fast = fast->next;
			}
		}
		ListNode* second = slow->next;
		slow->next = NULL;
		second = reverse(second);
		ListNode* result = reorderHelper(head, second);
		return result;
	}
};

class Solution42 {
//    Partition Linked List
//    Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.
//    
//    Examples
//    
//    L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
public:
	ListNode* partition(ListNode* head, int target) {
		if (head == NULL) {
			return NULL;
		}
		ListNode* fakeSmall = new ListNode(-1);
		ListNode* fakeLarge = new ListNode(-1);
		ListNode* currSmall = fakeSmall;
		ListNode* currLarge = fakeLarge;
		while (head != NULL) {
			if (head->value<target) {
				currSmall->next = head;
				currSmall = currSmall->next;
				head = head->next;
			}
			else {
				currLarge->next = head;
				currLarge = currLarge->next;
				head = head->next;
			}
		}
		currSmall->next = fakeLarge->next;
		currLarge->next = NULL;   // must set to NULL, big bug I had
		return fakeSmall->next;
	}
};

class Solution43 {
//    In-order Traversal Of Binary Tree
//    Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.
//    
//    Examples
//    
//            5
//    
//          /    \
//    
//        3        8
//    
//      /   \        \
//    
//    1      4        11
//    
//    In-order traversal is [1, 3, 4, 5, 8, 11]
//    
//    Corner Cases
//    
//    What if the given binary tree is null? Return an empty list in this case.

private:
	void inOrderHelper(TreeNode* root, vector<int>& result) {
		if (root == NULL) {
			return;
		}
		if (root->left != NULL) {
			inOrderHelper(root->left, result);
		}
		if (root != NULL) {
			result.push_back(root->value);
		}
		if (root->right != NULL) {
			inOrderHelper(root->right, result);
		}
	}
public:
	vector<int> inOrder(TreeNode* root) {
		vector<int> result;
		inOrderHelper(root, result);
		return result;
	}
};

class Solution44 {
//    Pre-order Traversal Of Binary Tree
//    Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.
//    
//    Examples
//    
//          5
//    
//        /    \
//    
//       3        8
//    
//     /   \        \
//    
//    1      4        11
//    
//    Pre-order traversal is [5, 3, 1, 4, 8, 11]
//    
//    Corner Cases
//    
//    What if the given binary tree is null? Return an empty list in this case.
private:
	void preOrderHelper(TreeNode* root, vector<int>& result) {
		if (root == NULL) {
			return;
		}
		else {
			result.push_back(root->value);
		}
		if (root->left != NULL) {
			preOrderHelper(root->left, result);
		}
		if (root->right != NULL) {
			preOrderHelper(root->right, result);
		}
	}
public:
	vector<int> preOrder(TreeNode* root) {
		vector<int> result;
		preOrderHelper(root, result);
		return result;
	}
};

class Solution45 {
//    Post-order Traversal Of Binary Tree
//    Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.
//    
//    Examples
//    
//           5
//    
//         /    \
//    
//        3        8
//    
//      /   \        \
//    
//    1      4        11
//    
//    Post-order traversal is [1, 4, 3, 11, 8, 5]
//    
//    Corner Cases
//    
//    What if the given binary tree is null? Return an empty list in this case.
private:
	void postOrderHelper(TreeNode* root, vector<int>& result) {
		if (root == NULL) {
			return;
		}
		if (root->left != NULL) {
			postOrderHelper(root->left, result);
		}
		if (root->right != NULL) {
			postOrderHelper(root->right, result);
		}
		result.push_back(root->value);
	}
public:
	vector<int> postOrder(TreeNode* root) {
		vector<int> result;
		postOrderHelper(root, result);
		return result;
	}
};

class Solution46 {
//    Check If Binary Tree Is Balanced
//    Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
//        
//        Examples
//        
//                5
//        
//              /    \
//        
//            3        8
//        
//          /   \        \
//        
//        1      4        11
//        
//        is balanced binary tree,
//        
//             5
//        
//            /
//        
//          3
//        
//        /   \
//        
//        1      4
//        
//        is not balanced binary tree.
//        
//        Corner Cases
//        
//        What if the binary tree is null? Return true in this case.
private:
	int getHeight(TreeNode* root) {
		if (root == NULL) {
			return 0;
		}
		if (root->left == NULL && root->right == NULL) {
			return 1;
		}
		return 1 + max(getHeight(root->left), getHeight(root->right));
	}
public:
	bool isBalanced(TreeNode* root) {
		if (root == NULL) {
			return true;
		}
		if (abs(getHeight(root->left) - getHeight(root->right))>1) {
			return false;
		}
		else {
			return isBalanced(root->left) && isBalanced(root->right);
		}
	}
};

class Solution47 {
    //    Check If Binary Tree Is Completed
    //    Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
    //
    //        Examples
    //
    //              5
    //
    //            /    \
    //
    //           3        8
    //
    //         /   \
    //
    //        1      4
    //
    //        is completed.
    //
    //               5
    //
    //             /    \
    //
    //            3        8
    //
    //          /   \        \
    //
    //        1      4        11
    //
    //        is not completed.
    //
    //        Corner Cases
    //
    //        What if the binary tree is null? Return true in this case.
private:
    int nodeCounts(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        else if (root->left == NULL && root->right == NULL) {
            return 1;
        }
        else {
            return 1 + nodeCounts(root->left) + nodeCounts(root->right);
        }
    }
    bool isCompletedHelper(TreeNode* root, int index, int counts) {
        if (root == NULL) {
            return true;
        }
        if (index >= counts) {
            return false;
        }
        return isCompletedHelper(root->left, 2 * index + 1, counts) && \
        isCompletedHelper(root->right, 2 * index + 2, counts);
    }
public:
    bool isCompleted(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        int node_count = nodeCounts(root);
        return isCompletedHelper(root, 0, node_count);
    }
    bool isCompleted1(TreeNode* root) {
        if (root==NULL) {
            return true;
        }
        queue<TreeNode*> myque;
        bool flag=false;
        myque.push(root);
        while (!myque.empty()) {
            TreeNode* curr=myque.front();
            myque.pop();
            if(!curr->left) {
                //no left child, set flag
                flag=true;
            }
            else if(flag) {
                return false;
            }
            else {
                myque.push(curr->left);
            }
            if (!curr->right) {
                //no right child, set flag
                flag=true;
            }
            else if (flag){
                return false;
            }
            else {
                myque.push(curr->right);
            }
        }
        return true;
    }
};

class Solution48 {
//    Symmetric Binary Tree
//    Check if a given binary tree is symmetric.
//        
//        Examples
//        
//                5
//        
//              /    \
//        
//            3        3
//        
//          /   \    /   \
//        
//        1      4  4      1
//        
//        is symmetric.
//        
//               5
//        
//             /    \
//        
//           3        3
//        
//         /   \    /   \
//        
//        1      4  1      4
//        
//        is not symmetric.
//        
private:
	bool isSymmHelper(TreeNode* left, TreeNode* right) {
		if (left == NULL && right == NULL) {
			return true;
		}
		else if (left == NULL || right == NULL) {
			return false;
		}
		else if (left->value != right->value) {
			return false;
		}
		else {
			return isSymmHelper(left->left, right->right) && isSymmHelper(left->right, right->left);
		}
	}
public:
	bool isSymmetric(TreeNode* root) {
		if (root == NULL) {
			return true;
		}
		return isSymmHelper(root->left, root->right);
	}
};

class Solution49 {
//    Identical Binary Tree
//    Check if two given binary trees are identical. Identical means the equal valued keys are at the same position in the two binary trees.
//        
//        Examples
//
//            5
//        
//          /    \
//        
//        3        8
//        
//        and
//
//            5
//        
//          /    \
//        
//        3        8
//        
//        are identical trees.
//        

public:
    bool isIdentical(TreeNode *r1, TreeNode *r2) {
        if (r1==NULL && r2==NULL) {
            return true;
        }
        else if (r1==NULL || r2==NULL) {
            return false;
        }
        else if (r1->value!=r2->value) {
            return false;
        }
        else {
            return isIdentical(r1->left, r2->left) && isIdentical(r1->right, r2->right);
        }
    }
};

class Solution50 {
    
//    Tweaked Identical Binary Trees
//    Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.
//    
//    Examples
//    
//           5
//    
//         /    \
//    
//       3        8
//    
//     /   \
//    
//    1      4
//    
//    and
//    
//          5
//    
//        /    \
//    
//       8        3
//    
//     /   \
//    
//    1     4
//    
//    the two binary trees are tweaked identical.

public:
	bool isTweakedIdentical(TreeNode* r1, TreeNode* r2) {
		if (r1 == NULL && r2 == NULL) {
			return true;
		}
		else if (r1 == NULL || r2 == NULL) {
			return false;
		}
		else if (r1->value != r2->value) {
			return false;
		}
		else {
			return (isTweakedIdentical(r1->left, r2->left) && \
				isTweakedIdentical(r1->right, r2->right)) || \
				(isTweakedIdentical(r1->left, r2->right) && \
					isTweakedIdentical(r1->right, r2->left));
		}
		return false;
	}
};

class Solution51 {
	//    Insert In Binary Search Tree
	//    Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
	//        
	//        Assumptions
	//        
	//        There are no duplicate keys in the binary search tree
	//        
	//        If the key is already existed in the binary search tree, you do not need to do anything
	//            
	//            Examples
	//            
	//                  5
	//            
	//                /    \
	//            
//               3        8
//            
//             /   \
//            
//            1     4
//            
//            insert 11, the tree becomes
//            
//                  5
//            
//                /    \
//            
//               3        8
//            
//             /   \        \
//            
//            1     4       11
//            
//            insert 6, the tree becomes
//            
//                   5
//            
//                 /    \
//            
//               3        8
//            
//             /   \     /  \
//            
//            1     4   6    11
public:
	TreeNode* insert(TreeNode* root, int value) {
		// Write your solution here.
		if (root == NULL) {
			root = new TreeNode(value);
			return root;
		}
		TreeNode* parent = NULL;
		TreeNode* current = root;
		while (current != NULL) {
			if (current->value == value) {
				return root;
			}
			else if (current->value>value) {
				parent = current;
				current = current->left;
			}
			else {
				parent = current;
				current = current->right;
			}
		}
		if (parent->value<value) {
			parent->right = new TreeNode(value);
		}
		else {
			parent->left = new TreeNode(value);
		}
		return root;
	}
};

class Solution52 {
	//    Search In Binary Search Tree
	//    Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
	//        
	//    Assumptions
	//        
	//    There are no duplicate keys in the binary search tree
	//
public:
	TreeNode* solve(TreeNode* root, int value) {
		if (root == NULL) {
			return NULL;
		}
		TreeNode* temp = root;
		while (temp != NULL) {
			if (temp->value == value) {
				return temp;
			}
			else if (temp->value>value) {
				temp = temp->left;
			}
			else {
				temp = temp->right;
			}
		}
		return NULL;
	}
};

class Solution53 {
	//    Delete In Binary Search Tree
	//    Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.
	//        
	//    Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.
	//        
	//    Assumptions
	//        
	//    There are no duplicate keys in the binary search tree
public:
	TreeNode* solve(TreeNode* root, int value) {
		if (root == NULL) {
			return root;
		}
		if (root->value>value) {
			//删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
			root->left = solve(root->left, value);
		}
		else if (root->value<value) {
			//删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
			root->right = solve(root->right, value);
		}
		else {
			if (root->left == NULL && root->right == NULL) {
				//不需要改
				return NULL;
			}
			else if (root->left == NULL || root->right == NULL) {
				//只返回另一个子树
				return root->left == NULL ? root->right : root->left;
			}
			else {
				//find the node with smallest value in the right subtree
				//copy its value to root
				//recurse delete the smallest node from right of this root
				TreeNode* closet = root->right;
				while (closet->left != NULL) {
					closet = closet->left;
				}
				root->value = closet->value;
				root->right = solve(root->right, closet->value);
			}
		}
		return root;
	}
};

class Solution54 {
//    Is Binary Search Tree Or Not
//    Determine if a given binary tree is binary search tree.
//        
//    Assumptions
//        
//    There are no duplicate keys in binary search tree.
//    You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
//    Corner Cases
//        
//    What if the binary tree is null? Return true in this case.
private:
	bool isBSTHelper(TreeNode* root, int left, int right) {
		if (root == NULL) {
			return true;
		}
		if (root->value<right && root->value>left) {
			return isBSTHelper(root->left, left, root->value) && \
				isBSTHelper(root->right, root->value, right);
		}
		else {
			return false;
		}
	}
    
    void isBSTHelper1(TreeNode* root, TreeNode* &prev, bool& isbst) {
        if (root==NULL || isbst==false) {
            return;
        }
        isBSTHelper1(root->left, prev, isbst);
        if(prev!=NULL) {
            isbst &= root->value > prev->value;
        }
        if(root!=NULL) {
            prev=root;
        }
        isBSTHelper1(root->right, prev, isbst);
    }
    
public:
	bool isBST(TreeNode* root) {
		if (root == NULL) {
			return true;
		}
		return isBSTHelper(root, INT_MIN, INT_MAX);
	}
    
    bool isBST1(TreeNode* root) {
        if (root==NULL) {
            return true;
        }
        TreeNode* min = NULL;
        bool isbst = true;
        isBSTHelper1(root, min, isbst);
        return isbst;
    }
};

class Solution55 {
//    Get Keys In Binary Search Tree In Given Range
//    Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
//    
//    Examples
//    
//    5
//    
//    /    \
//    
//    3        8
//    
//    /   \        \
//    
//    1     4        11
//    
//    get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
//    
//    Corner Cases
//    
//    What if there are no keys in the given range? Return an empty list in this case.
private:
	void getRangeHelper(TreeNode* root, int min, int max, vector<int>& result) {
		if (root == NULL) {
			return;
		}
		if (root->value>min) {
			getRangeHelper(root->left, min, max, result);
		}
		if (root->value >= min && root->value <= max) {
			result.push_back(root->value);
		}
		if (root->value<max) {
			getRangeHelper(root->right, min, max, result);
		}
	}
public:
	vector<int> getRange(TreeNode* root, int min, int max) {
		vector<int> result;
		getRangeHelper(root, min, max, result);
		return result;
	}
};

class Solution56 {
//    Bipartite
//    Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
//        
//        Examples
//        
//        1  --   2
//        
//        /
//        
//        3  --   4
//        
//        is bipartite (1, 3 in group 1 and 2, 4 in group 2).
//        
//        1  --   2
//        
//        /   |
//        
//        3  --   4
//        
//        is not bipartite.
private:
	bool bfsMark(GraphNode* node, map<GraphNode*, int>& nodemark) {
		// if this node has been traversed, no need to do again
		if (nodemark.find(node) != nodemark.end()) {
			return true;
		}
		queue<GraphNode*> myq;
		myq.push(node);
		while (!myq.empty()) {
			GraphNode* curr = myq.front();
			myq.pop();
			int currmark = nodemark[curr];
			int neibmark = currmark == 0 ? 1 : 0; //opposite groups
			for (int i = 0; i<curr->neighbors.size(); i++) {
				GraphNode* neib = curr->neighbors[i];
				if (nodemark.find(neib) == nodemark.end()) {
					myq.push(neib);
					nodemark[neib] = neibmark;
				}
				else if (nodemark[neib] != neibmark) {
					return false;
				}
			}
		}
		return true;
	}
public:
	bool solve(vector<GraphNode*> graph) {
		if (graph.empty()) {
			return false;
		}
		map<GraphNode*, int> nodemark;
		for (int i = 0; i<graph.size(); i++) {
			if (!bfsMark(graph[i], nodemark)) {
				return false;
			}
		}
		return true;
	}
};

class Solution57 {
//    Get Keys In Binary Tree Layer By Layer
//    Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.
//    
//    Examples
//    
//    5
//    
//    /    \
//    
//    3        8
//    
//    /   \        \
//    
//    1     4        11
//    
//    the result is [ [5], [3, 8], [1, 4, 11] ]
//    
//    Corner Cases
//    
//    What if the binary tree is null? Return an empty list of list in this case.

public:
	vector<vector<int>> solve(TreeNode* root) {
		vector<vector<int>> resultset;
		if (root == NULL) {
			return resultset;
		}
		queue<TreeNode*> myq;
		myq.push(root);
		while (!myq.empty()) {
			int leng = (int)myq.size();
			vector<int> level;
			for (int i = 0; i<leng; i++) {
				TreeNode* head = myq.front();
				myq.pop();
				level.push_back(head->value);
				if (head->left != NULL) {
					myq.push(head->left);
				}
				if (head->right != NULL) {
					myq.push(head->right);
				}
			}
			resultset.push_back(level);
		}
		return resultset;
	}
};

class Solution58 {
    //    Get Keys In Binary Tree Layer By Layer Zig-Zag Order
    //    Get the list of keys in a given binary tree layer by layer in zig-zag order.
    //
    //    Examples
    //
    //    5
    //
    //    /    \
    //
    //    3        8
    //
    //    /   \        \
    //
    //    1     4        11
    //
    //    the result is [5, 3, 8, 11, 4, 1]
public:
    vector<int> zigZag(TreeNode* root) {
        vector<int> result;
        if (root == NULL) {
            return result;
        }
        /*
         5
         3       8
         1     4        11
         2   6  7   9   10    12
         */
        deque<TreeNode*> mydeque;
        bool isodd = true;
        mydeque.push_back(root);
        while (!mydeque.empty()) {
            if (!isodd) {
                int leng = (int)mydeque.size();
                while (leng != 0) {
                    TreeNode* current = mydeque.front();
                    mydeque.pop_front();
                    result.push_back(current->value);
                    if (current->left) {
                        mydeque.push_back(current->left);
                    }
                    if (current->right) {
                        mydeque.push_back(current->right);
                    }
                    leng--;
                }
                isodd = !isodd;
            }
            else {
                int leng = (int)mydeque.size();
                while (leng>0) {
                    TreeNode* current = mydeque.back();
                    mydeque.pop_back();
                    result.push_back(current->value);
                    if (current->right) {
                        mydeque.push_front(current->right);
                    }
                    if (current->left) {
                        mydeque.push_front(current->left);
                    }
                    leng--;
                }
                isodd = !isodd;
            }
        }
        return result;
    }
};

class Solution60 {
    //    Height of Binary Tree
    //    Find the height of binary tree.
    //
    //Examples:
    //
    //    5
    //
    //    /    \
    //
    //    3        8
    //
    //    /   \        \
    //
    //    1      4        11
    //
    //    The height of above binary tree is 3.
public:
    int findHeight(TreeNode* root) {
        if(root==NULL) {
            return 0;
        }
        else {
            return max(findHeight(root->left), findHeight(root->right)) + 1;
        }
    }
};

class Solution62 {
//    All Subsets I
//    Given a set of characters represented by a String, return a list containing all subsets of the characters.
//    
//    Assumptions
//    
//    There are no duplicate characters in the original set.
//    ​Examples
//    
//    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
//    Set = "", all the subsets are [""]
//    Set = null, all the subsets are []
private:
	void allsubsets(string input, string& current, vector<string>& result) {
		if (input.size() == 0) {
			result.push_back(current);
			return;
		}
		current.push_back(input[0]);
		allsubsets(input.substr(1), current, result);
		current.pop_back();
		allsubsets(input.substr(1), current, result);
	}
public:
	vector<string> solve(string input) {
		vector<string> result;
		if (input.size() == 0) {
			result.push_back("");
			return result;
		}
		string temp = "";
		allsubsets(input, temp, result);
		return result;
	}
};

class Solution63 {
    //    All Subsets II
    //    Given a set of characters represented by a String, return a list containing all subsets of the characters.
    //
    //    Assumptions
    //
    //    There could be duplicate characters in the original set.
	//​Examples
	//	Set = "abc", all the subsets are["", "a", "ab", "abc", "ac", "b", "bc", "c"]
	//	Set = "abb", all the subsets are["", "a", "ab", "abb", "b", "bb"]
	//	Set = "", all the subsets are[""]
	//	Set = null, all the subsets are[]
private:
    void solveHelper(string input, int index, string& combo, vector<string>& result) {
        if (index >= input.size()) {
            return;
        }
        combo += input[index];
        result.push_back(combo);
        solveHelper(input, index + 1, combo, result);
        combo.pop_back();
        while (index<input.size() - 1 && input[index + 1] == input[index]) {
            index++;
        }
        solveHelper(input, index + 1, combo, result);
    }
    void solveHelper2(string input, int index, string& combo, vector<string>& result) {
        if (index == input.size()) {
            result.push_back(combo);
            return;
        }
        combo += input[index];
        solveHelper2(input, index + 1, combo, result);
        combo.pop_back();
        while (index<input.size() - 1 && input[index + 1] == input[index]) {
            index++;
        }
        solveHelper2(input, index + 1, combo, result);
    }
    
public:
    vector<string> solve(string input) {
        int leng = (int)input.size();
        if (leng == 0) {
            return { "" };
        }
        else if (leng == 1) {
            return { "", input };
        }
        vector<string> result = { "" };
        string combo = "";
        solveHelper(input, 0, combo, result);
        return result;
    }
    vector<string> solve2(string input) {
        int leng = (int)input.size();
        if (leng == 0) {
            return { "" };
        }
        else if (leng == 1) {
            return { "", input };
        }
        vector<string> result;
        string combo = "";
        solveHelper2(input, 0, combo, result);
        return result;
    }
};

class Solution64 {
//    All Permutations I
//    Given a string with no duplicate characters, return a list with all permutations of the characters.
//    
//    Examples
//    
//    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//    Set = "", all permutations are [""]
//    Set = null, all permutations are []
private:
	void allpermutations(string input, int index, vector<string>& result) {
		if (index == input.size()) {
			result.push_back(input);
			return;
		}
		for (int i = index; i<input.size(); i++) {
			swap(input[index], input[i]);
			allpermutations(input, index + 1, result);
			swap(input[index], input[i]);
		}
	}
public:
	vector<string> solve(string input) {
		vector<string> result;
		if (input == "") {
			result.push_back("");
			return result;
		}
		allpermutations(input, 0, result);
		return result;
	}
};

class Solution65 {
    //    All Permutations II
    //    Given a string with possible duplicate characters, return a list with all permutations of the characters.
    //
    //    Examples
    //
    //    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
    //    Set = "aba", all permutations are ["aab", "aba", "baa"]
    //    Set = "", all permutations are [""]
    //    Set = null, all permutations are []
private:
    void permutation2(vector<string>& result, string input, int index) {
        if (index == input.size()) {
            result.push_back(input);
            return;
        }
        set<char> worddict;
        for (int i = index; i<input.size(); i++) {
            if (worddict.count(input[i]) == 0) {
                worddict.insert(input[i]);
                swap(input[i], input[index]);
                permutation2(result, input, index + 1);
                swap(input[i], input[index]);
            }
        }
    }
public:
    vector<string> solve(string input) {
        if (input == "") {
            return { "" };
        }
        vector<string> output;
        permutation2(output, input, 0);
        return output;
    }
};

class Solution66 {
//    All Valid Permutations Of Parentheses I
//    Given N pairs of parentheses “()”, return a list with all the valid permutations.
//    
//    Assumptions
//    
//    N >= 0
//    Examples
//    
//    N = 1, all valid permutations are ["()"]
//    N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
//    N = 0, all valid permutations are [""]
private:
	void allvalidpermutationsofparentheses(string permu, int left, int right, int num, vector<string>& result) {
		if (permu.size() == 2 * num) {
			result.push_back(permu);
			return;
		}
		if (left<num) {
			permu += "(";
			allvalidpermutationsofparentheses(permu, left + 1, right, num, result);
			permu.pop_back();   //backtracking, must
		}
		if (right<left) {
			permu += ")";
			allvalidpermutationsofparentheses(permu, left, right + 1, num, result);
			permu.pop_back();   //backtracking, must
		}
	}
public:
	vector<string> solve(int num) {
		vector<string> result;
		string permu = "";
		int left = 0, right = 0;
		if (num == 0) {
			result.push_back("");
			return result;
		}
		else if (num == 1) {
			result.push_back("()");
			return result;
		}
		else {
			allvalidpermutationsofparentheses(permu, left, right, num, result);
			return result;
		}
	}
};

class Solution67 {
    //    Top K Frequent Words
    //    Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.
    //
    //    Assumptions
    //
    //    the composition is not null and is not guaranteed to be sorted
    //    K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
    //    Return
    //
    //    a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
    //    Examples
    //
    //    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
    //    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
    //    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
public:
    class comhelper {
    public:
        bool operator() (pair<string, int> left, pair<string, int> right) {
            return left.second>right.second;
        }
    };
    vector<string> topKFrequent(vector<string> combo, int k) {
        vector<string> result;
        if (k <= 0 || combo.size() == 0) {
            return result;
        }
        unordered_map<string, int> mymap;
        for (int i = 0; i<combo.size(); i++) {
            mymap[combo[i]]++;
        }
        priority_queue<pair<string, int>, vector<pair<string, int>>, comhelper> mypq;
        for (auto it = mymap.begin(); it != mymap.end(); it++) {
            mypq.push(*it);
            if (mypq.size()>k) {
                mypq.pop();
            }
        }
        while (!mypq.empty()) {
            result.insert(result.begin(), mypq.top().first);
            mypq.pop();
        }
        return result;
    }
};

class Solution68 {
    //    Missing Number I
    //    Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
    //
    //    Assumptions
    //
    //    The given array is not null, and N >= 1
    //    Examples
    //
    //    A = {2, 1, 4}, the missing number is 3
    //    A = {1, 2, 3}, the missing number is 4
    //    A = {}, the missing number is 1
public:
    int missing(vector<int> array) {
        long result = 0;
        int i;
        for (i = 0; i<array.size(); i++) {
            result += array[i];
        }
        return int(long((i + 2)*(i + 1) / 2 - result));
        //        if (array.size()==0) {
        //            return 1;
        //        }
        //        int x1=array[0];
        //        int x2=1;
        //        for (int i=1; i<array.size(); i++) {
        //            x1^=array[i];
        //        }
        //        for (int i=2; i<=array.size(); i++) {
        //            x2^=i;
        //        }
        //        return x1^x2;
    }
};

class Solution69 {
    //    Missing Number II
    //    Given an integer array of size N - 1 sorted by ascending order, containing all the numbers from 1 to N except one, find the missing number.
    //
    //    Assumptions
    //
    //    The given array is not null, and N >= 1
    //    Examples
    //
    //    A = {1, 2, 4}, the missing number is 3
    //    A = {1, 2, 3}, the missing number is 4
    //    A = {}, the missing number is 1
public:
    int missing(vector<int> array) {
        int leng=array.size();
        if (leng==0) {
            return 1;
        }
        for (int i=0; i<leng; i++) {
            if (array[i]!=i+1) {
                return i+1;
            }
        }
        return leng+1;
    }
};

class Solution70 {
    //    Common Numbers Of Two Arrays I
    //    Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
    //
    //    Assumptions
    //
    //    Both arrays are not null.
    //    There are no duplicate numbers in each of the two arrays respectively.
    //    Exmaples
    //
    //    A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
    //    A = {}, B = {3, 1, 4}, return []
public:
    vector<int> common(vector<int> a, vector<int> b) {
        if (a.size()==0 || b.size()==0) {
            return {};
        }
        else {
            unordered_map<int, int> dict;
            vector<int> result;
            for (int i=0; i<a.size(); i++) {
                dict[a[i]]++;
            }
            for (int i=0; i<b.size(); i++) {
                if (dict[b[i]]==0) {
                    result.push_back(b[i]);
                }
            }
            sort(result.begin(), result.end());
            return result;
        }
    }
};

class Solution71 {
    //    Common Numbers Of Two Arrays II
    //    Find all numbers that appear in both of two unsorted arrays.
    //
    //    Assumptions
    //
    //    Both of the two arrays are not null.
    //    In any of the two arrays, there could be duplicate numbers.
    //    Examples
    //
    //    A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
    vector<int> common(vector<int> a, vector<int> b) {
        if (a.size()==0 || b.size()==0) {
            return {};
        }
        unordered_map<int, int> dict;
        vector<int> result;
        for (int i=0; i<a.size(); i++) {
            dict[a[i]]++;
        }
        for (int i=0; i<b.size(); i++) {
            if (dict[b[i]]>0) {
                result.push_back(b[i]);
                dict[b[i]]--;
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};
class Solution72 {
    //    Common Numbers Of Two Sorted Arrays
    //    Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
    //
    //    Assumptions
    //    
    //    In each of the two sorted arrays, there could be duplicate numbers.
    //    Both two arrays are not null.
    //    Examples
    //    
    //    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
public:
    vector<int> common(vector<int> a, vector<int> b) {
        vector<int> result;
        if (a.size() == 0 || b.size() == 0) {
            return {};
        }
        unordered_map<int, int> mymap;
        for (int i : a) {
            mymap[i]++;
        }
        for (int j : b) {
            if (mymap[j]>0) {
                result.push_back(j);
                mymap[j]--;
            }
        }
        return result;
    }
};

class Solution73 {
//    Combinations Of Coins
//    Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.
//    
//    Arguments
//    
//    coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
//    target - a non-negative integer representing the target number of cents, eg. 99
//    Assumptions
//    
//    coins is not null and is not empty, all the numbers in coins are positive
//    target >= 0
//    You have infinite number of coins for each of the denominations, you can pick any number of the coins.
//        Return
//        
//        a list of ways of combinations of coins to sum up to be target.
//        each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
//            Examples
//            
//            coins = {2, 1}, target = 4, the return should be
//    
//    [
//     
//     [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
//     
//     [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
//     
//     [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
//     
//     ]
private:
	void combinationOfCoins(int target, const vector<int> coins, int index, vector<int>& combo, vector<vector<int>>& result) {
		if (index == coins.size() - 1 && (target%coins[coins.size() - 1] == 0)) {
			combo[index] = target / coins[coins.size() - 1];
			result.push_back(combo);
			return;
		}
		else if (index<coins.size() - 1) {
			for (int i = 0; i <= target / coins[index]; i++) {
				combo[index] = i;
				combinationOfCoins(target - coins[index] * i, coins, index + 1, combo, result);
			}
		}
	}
public:
	vector<vector<int>> solve(int target, vector<int> coins) {
		vector<vector<int>> result;
		const int leng = (int)coins.size();
		vector<int> combo(leng, 0);
		sort(coins.begin(), coins.end(), [](const int a, const int b) {return a>b; });
		combinationOfCoins(target, coins, 0, combo, result);
		return result;
	}
};

class Solution74 {
    //    Power Of Two
    //    Determine if a given integer is power of 2.
    //
    //        Examples
    //
    //        16 is power of 2 (2 ^ 4)
    //        3 is not
    //        0 is not
    //        -1 is not
public:
    bool isPowerOfTwo(int number) {
        if (number == 0) {
            return false;
        }
        long lower = (long)number - 1;
        bool result = (long)number&lower;
        if (result == false) {
            return true;
        }
        else {
            return false;
        }
    }
};

class Solution75 {
    //    Number Of Different Bits
    //    Determine the number of bits that are different for two given integers.
    //
    //    Examples
    //
    //    5(“0101”) and 8(“1000”) has 3 different bits
public:
    int diffBits(int a, int b) {
        //        int count=0;
        //        int a1=0, b1=0;
        //        while (a!=0 || b!=0) {
        //            a1=a&1;
        //            b1=b&1;
        //            count+=a1^b1;
        //            a>>=1;
        //            b>>=1;
        //        }
        //        return count;
        int count = 0;
        int result = a^b;
        while (result) {
            count++;
            result = result&(result - 1);
        }
        return count;
    }
};

class Solution76 {
    //    All Unique Characters I
    //    Determine if the characters of a given string are all unique.
    //
    //        Assumptions
    //
    //        The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
    //        The given string is not null.
    //        Examples
    //
    //        the characters used in "abcd" are unique
    //        the characters used in "aba" are not unique
public:
    bool allUnique(string word) {
        int dict[8]={0};
        for (int i=0; i<word.size(); i++) {
            int aa=word[i]%32;
            int bb=word[i]/32;
            if (dict[bb] && (1<<aa)) {
                return false;
            }
            dict[bb]|=1<<aa;
        }
        return true;
    }
};
class Solution77 {
    //    All Unique Characters II
    //    Determine if the characters of a given string are all unique.
    //
    //        Assumptions
    //
    //        We are using ASCII charset, the value of valid characters are from 0 to 255
    //        The given string is not null
    //        Examples
    //
    //        all the characters in "abA+\8" are unique
    //        "abA+\a88" contains duplicate characters
public:
    bool allUnique(string s) {
        int mapper[8] = { 0 };
        for (int i = 0; i<s.size(); i++) {
            int aa = s[i] / 32;
            int bb = s[i] % 32;
            if (((mapper[aa] >> bb) & 1) == true) {
                return false;
            }
            else {
                mapper[aa] |= (1 << bb);
            }
        }
        return true;
    }
};

class Solution78 {
    //    Hexadecimal Representation
    //    Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
    //
    //        There should not be extra zeros on the left side.
    //
    //        Examples
    //
    //        0's hex representation is "0x0"
    //        255's hex representation is "0xFF"
public:
    string hex(int n) {
        string result;
        int offset;
        char cur;
        if (n == 0) {
            result += '0';
        }
        else {
            while (n>0) {
                offset = n % 16;
                if (offset<10) {
                    cur = offset + '0';
                }
                else {
                    cur = offset + 'A' - 10;
                }
                result += cur;
                n /= 16;
            }
        }
        result += "x0";
        reverse(result.begin(), result.end());
        return result;
    }
};

class Solution79 {
//    Remove Adjacent Repeated Characters I
//    Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//        
//        Assumptions
//        
//        Try to do it in place.
//            Examples
//            
//            “aaaabbbc” is transferred to “abc”
//            Corner Cases
//            
//            If the given string is null, we do not need to do anything.
public:
	string deDup(string s) {
		int leng = (int)s.size();
		if (leng <= 1) {
			return s;
		}
		int fast = 0, slow = 0;
		for (; fast<leng; ) {
			if (s[fast] == s[slow]) {
				fast++;
			}
			else {
				slow++;
				s[slow] = s[fast];
				fast++;
			}
		}
		s.resize(slow + 1);
		return s;
	}
};

class Solution80 {
//    Remove Adjacent Repeated Characters II
//    Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.
//        
//        Assumptions
//        
//        Try to do it in place.
//            Examples
//            
//            “aaaabbbc” is transferred to “aabbc”
//            Corner Cases
//            
//            If the given string is null, we do not need to do anything.
    string deDup(string input) {
        int leng=input.size();
        if (leng<=2) {
            return input;
        }
        string result="";
        result+=input[0];
        result+=input[1];
        for (int i=2; i<leng; i++) {
            if (input[i]==input[i-2]) {
                continue;
            }
            else {
                result+=input[i];
            }
        }
        return result;
    }
};

class Solution81 {
//    Remove Adjacent Repeated Characters III
//    Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.
//        
//        Assumptions
//        
//        Try to do it in place.
//            Examples
//            
//            “aaaabbbc” is transferred to “c”
//            Corner Cases
//            
//            If the given string is null, we do not need to do anything.
public:
    string duDup(string input) {
        int leng=input.size();
        if (leng<=1) {
            return input;
        }
        string result="";
        result+=input[0];
        for (int i=1; i<leng; ) {
            if (result.size()>0 && input[i]==result.back()) {
                while (i<leng && input[i]==result.back()) {
                    i++;
                }
                result.pop_back();
            }
            else {
                result+=input[i];
                i++;
            }
        }
        return result;
    }
};

class Solution82 {
//    Remove Adjacent Repeated Characters IV
//    Repeatedly remove all adjacent, repeated characters in a given string from left to right.
//    
//    No adjacent characters should be identified in the final string.
//    
//    Examples
//    
//    "abbbaaccz" → "aaaccz" → "ccz" → "z"
//    "aabccdc" → "bccdc" → "bdc"
public:
    string deDup(string s) {
        // abbbaaccz
        // z
        // s
        //         f
		if (s.size() <= 1) {
			return s;
		}
		vector<char> mys;
		int slow = 0, fast = 0;
		for (; fast<s.size(); ) {
			slow = fast;
			if (!mys.empty() && s[fast] == mys.back()) {
				while (s[fast] == mys.back()) {
					fast++;
				}
				mys.pop_back();
			}
			else {
				mys.push_back(s[fast]);
				fast++;
			}
		}
		s.clear();
		for (auto i : mys) {
			s += i;
		}
		return s;
	}
};

class Solution83 {
//    Encode Space
//    In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that performs this encoding for a given string.
//        
//        Examples
//        
//        "google/q?flo wer market" → "google/q?flo20%wer20%market"
//        Corner Cases
//        
//        If the given string is null, we do not need to do anything.
public:
    string encode(string input) {
        if (input.size()==0) {
            return input;
        }
        string result="";
        for (int i=0; i<input.size(); i++) {
            if (input[i]==' ') {
                result+="20%";
            }
            else {
                result+=input[i];
            }
        }
        return result;
    }
};

class Solution84 {
    //    Reverse Words In A Sentence I
    //    Reverse the words in a sentence.
    //
    //    Assumptions
    //
    //    Words are separated by single space
    //
    //    There are no heading or tailing white spaces
    //
    //    Examples
    //
    //    “I love Google” → “Google love I”
    //
    //    Corner Cases
    //
    //    If the given string is null, we do not need to do anything.
public:
    string reverseWords(string s) {
        if (s.size() <= 1) {
            return s;
        }
        for (int i = 0, j = (int)s.size() - 1; i <= j; i++, j--) {
            swap(s[i], s[j]);
        }
        for (int i = 0; i<(int)s.size(); ) {
            while (s[i] == ' ') {
                i++;
            }
            int j = i;
            while (s[j] != ' ' && j<(int)s.size()) {
                j++;
            }
            for (int m = i, n = j - 1; m<n; m++, n--) {
                swap(s[m], s[n]);
            }
            i = j;
        }
        return s;
    }
};

class Solution85 {
//    Determine If One String Is Another's Substring
//    Determine if a small string is a substring of another large string.
//        
//        Return the index of the first occurrence of the small string in the large string.
//        
//        Return -1 if the small string is not a substring of the large string.
//            
//            Assumptions
//            
//            Both large and small are not null
//            If small is empty string, return 0
//            Examples
//            
//            “ab” is a substring of “bcabc”, return 2
//            “bcd” is not a substring of “bcabc”, return -1
//            "" is substring of "abc", return 0
public:
	int strstr(string large, string small) {
		if (small.size() == 0) {
			return 0;
		}
		if (large.size() == 0) {
			return -1;
		}
		int i = 0, j = 0;
		while (i <= large.size() - small.size()) {
			while (j<small.size() && small[j] == large[i + j]) {
				j++;
			}
			if (j == small.size()) {
				return i;
			}
			else {
				i += 1;
				j = 0;
			}
		}
		return -1;
	}
};

class Solution86 {
    //    Longest Ascending SubArray
    //    Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
    //
    //    Assumptions
    //
    //    The given array is not null
    //    Examples
    //
    //    {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
    //
    //    {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
public:
    int longest(vector<int> input) {
        if (input.size() == 0) {
            return 0;
        }
        else if (input.size() == 1) {
            return 1;
        }
        vector<int> result(input.size(), 1);
        int output = 1;
        for (int i = 1; i<input.size(); i++) {
            if (input[i]>input[i - 1]) {
                result[i] = result[i - 1] + 1;
                output = max(output, result[i]);
            }
        }
        return output;
    }
};

class Solution87 {
    /*Max Product Of Cutting Rope
     Given a rope with positive integer - length n, how to cut the rope into m integer - length parts with length p[0], p[1], ..., p[m - 1], in order to get the maximal product of p[0] * p[1] * ... *p[m - 1] ? m is determined by you and must be greater than 0 (at least one cut must be made).Return the max product you can have.
     
     Assumptions
     
     n >= 2
     Examples
     
     n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).*/
public:
    int maxProduct(int length) {
        //        vector<int> product(length+1, 0);
        //        product[0]=0;
        //        product[1]=0;   //at least one cut must be made
        //        for (int i=1; i<=length; i++) {
        //            int temp=0;
        //            for (int j=1; j<=i/2; j++) {
        //                temp=max(temp, max(j, product[j])*max(i-j, product[i-j]));
        //            }
        //            product[i]=temp;
        //        }
        //        return product[length];
        if (length<2) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i<length; i++) {
            int best = max(length - i, maxProduct(length - i));
            result = max(best*i, result);
        }
        return result;
    }
};

class Solution88 {
    /*Array Hopper I
     Given an array A of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from that position(you can only jump towards the end of the array).Determine if you are able to reach the last index.
     
     Assumptions
     
     The given array is not null and has length of at least 1.
     Examples
     
     { 1, 3, 2, 0, 3 }, we are able to reach the end of array(jump to index 1 then reach the end of the array)
     
     {2, 1, 1, 0, 2 }, we are not able to reach the end of array*/
public:
    bool canJump(vector<int> input) {
        if (input.size()<1) {
            return false;
        }
        else if (input.size() == 1) {
            return true;
        }
        vector<bool> memo(input.size(), false);
        memo[0] = true;
        for (int i = 1; i<input.size(); i++) {
            for (int j = 0; j<i; j++) {
                if (j + input[j] >= i && memo[j] == true) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[input.size() - 1];
    }
};

class Solution89 {
    //Array Hopper II
    //	Given an array A of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from index i(you can only jump towards the end of the array).Determine the minimum number of jumps you need to reach the end of array.If you can not reach the end of the array, return -1.
    
    //	Assumptions
    
    //	The given array is not null and has length of at least 1.
    //	Examples
    
    //{ 3, 3, 1, 0, 4 }, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
    
    //{ 2, 1, 1, 0, 2 }, you are not able to reach the end of array, return -1 in this case.
public:
    int minJump(vector<int> input) {
        if (input.size() == 1) {
            return 0;
        }
        vector<int> mi(input.size(), INT_MAX);
        mi[input.size() - 1] = 0;
        for (int i = (int)input.size() - 2; i >= 0; i--) {
            for (int j = input[i]; j>0; j--) {
                if (mi[i + j] != INT_MAX) {
                    mi[i] = min(mi[i], mi[i + j] + 1);
                }
            }
        }
        return mi[0] == INT_MAX ? -1 : mi[0];
    }
};

class Solution90 {
    //Array Hopper III
    //	Given an array of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from that position(you can only jump towards the end of the array).Determine the minimum number of jumps you need to jump out of the array.
    
    //	By jump out, it means you can not stay at the end of the array.Return - 1 if you can not do so.
    
    //	Assumptions
    
    //	The given array is not null and has length of at least 1.
    //	Examples
    
    //{ 1, 3, 2, 0, 2 }, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)
    
    //{ 3, 2, 1, 1, 0 }, you are not able to jump out of array, return -1 in this case.
public:
    int minJump(vector<int> array) {
        if (array.size() == 0)
        {
            return -1;
        }
        vector<int> jumps(array.size(), 0);
        fill(jumps.begin(), jumps.end(), INT_MAX);
        jumps[0] = 0;
        for (int i = 0; i < array.size(); i++)
        {
            for (int j = array[i]; j >= 0; j--)
            {
                if (jumps[i] != INT_MAX)
                {
                    if (i + j < array.size())
                    {
                        jumps[i + j] = min(jumps[i + j], jumps[i] + 1);
                    }
                    else {
                        return jumps[i] + 1;
                    }
                }
            }
        }
        if (array[array.size() - 1] > 0) {
            if (jumps[array.size() - 1] != INT_MAX) {
                return jumps[array.size() - 1] + 1;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }
};

class Solution91 {
    //Array Hopper IV
    //	Given an array A of non - negative integers, you are initially positioned at an arbitrary index of the array.A[i] means the maximum jump distance from that position(you can either jump left or jump right).Determine the minimum jumps you need to reach the right end of the array.Return - 1 if you can not reach the right end of the array.
    
    //	Assumptions
    
    //	The given array is not null and has length of at least 1.
    //	Examples
    
    //{ 1, 3, 1, 2, 2 }, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)
    
    //{ 3, 3, 1, 0, 0 }, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)
    
    // { 4, 0, 1, 0, 0 }, if the initial position is 2, you are not able to reach the right end of array, return -1 in this case.
public:
    int minJump(vector<int> array, int index) {
        int leng = array.size();
        vector<int> cancome(leng, INT_MAX);
        if (leng <= index || index < 0) {
            return -1;
        }
        cancome[index] = 0;
        minJumpHelper(array, leng, index, cancome);
        if (cancome[leng-1]==INT_MAX)
        {
            return -1;
        }
        else {
            return cancome[leng - 1];
        }
        return 0;
    }
private:
    void minJumpHelper(vector<int>& array, int leng, int index, vector<int>& cancome) {
        if (index<0 || index>=leng || array[index] == 0)
        {
            return;
        }
        for (int i = 1; i <= array[index]; i++)
        {
            if (i+index<leng && cancome[index + i]> cancome[index] + 1)
            {
                cancome[index+i] = cancome[index] + 1;
                minJumpHelper(array, leng, index + i, cancome);
            }
            if (index - i >= 0 && cancome[index - i] > cancome[index] + 1) {
                cancome[index - i] = cancome[index] + 1;
                minJumpHelper(array, leng, index - i, cancome);
            }
        }
    }
};

class Solution92 {
    
    //Buy Stock I
    //	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock and you can make at most 1 transaction.Determine the maximum profit you can make.
    
    //	Assumptions
    
    //	The given array is not null and is length of at least 2.
    //	Examples
    
    //{ 2, 3, 2, 1, 4, 5 }, the maximum profit you can make is 5 - 1 = 4
public:
    int maxProfit(vector<int> array) {
        int leng = array.size();
        if (leng<=1)
        {
            return 0;
        }
        int minprice = array[0];
        int maxprofit = 0;
        for (int i = 0; i < leng; i++)
        {
            minprice = min(minprice, array[i]);
            maxprofit = max(maxprofit, array[i] - minprice);
        }
        return maxprofit;
    }
};

class Solution93 {
    //Buy Stock II
    //	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock.Determine the maximum profit you can make.
    
    //	Assumptions
    
    //	The give array is not null and is length of at least 2
    //	Examples
    
    //{ 2, 3, 2, 1, 4, 5 }, the maximum profit you can make is(3 - 2) + (5 - 1) = 5
    //		if array[2]>array[1]
    //				profit[2][1]=array[2]-array[1]
    //				else
    //					profit[2][1]=0;
    //
    //		if array[j]-array[i]>0
    //			profit[j][i] = array[j]-array[i]
    //			else
    //				profit[j][i]=0
    //
    //				profit[j][i]=profit[j][k]+profit[k][i];
    //		return profit[5][0];
    //		0 0 0 0 0 0
    //		1 0 0 0 0 0
    //		0 1 0 0 0 0
    //		0 0 1 0 0 0
    //		0 0 0 4 0 0
    //		0 0 0 0 5 0
public:
    int maxProfit(vector<int> array) {
        int leng = array.size();
        if (leng <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < leng; i++)
        {
            if (array[i]>array[i-1])
            {
                result += array[i] - array[i - 1];
            }
        }
        return result;
    }
};

class Solution94 {
    
    //Buy Stock III
    //	Given an array of positive integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total.Determine the maximum profit you can make.
    
    //	Assumptions
    
    //	The give array is not null and is length of at least 2
    //	Examples
    
    //{ 2, 3, 2, 1, 4, 5, 2, 11 }, the maximum profit you can make is(5 - 1) + (11 - 2) = 13
public:
    int maxProfit(vector<int> array) {
        //切一刀,两边各做一次
        int leng = array.size();
        if (leng <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < leng; i++) {
            int leftmax = maxHelper(array, 0, i);
            int rightmax = maxHelper(array, i + 1, leng - 1);
            result = max(result, leftmax + rightmax);
        }
        return result;
    }
    int maxProfit1(vector<int> array) {
        //切一刀,两边各做一次
        int leng = array.size();
        if (leng<=1)
        {
            return 0;
        }
        return maxHelper1(array, 2);
    }
private:
    int maxHelper(vector<int>& array, int left, int right) {
        if (right-left<=0)
        {
            return 0;
        }
        int minprice = array[left];
        int result = 0;
        for (int i = left; i <= right; i++)
        {
            minprice = min(minprice, array[i]);
            result = max(result, array[i] - minprice);
        }
        return result;
    }
    int maxHelper1(vector<int>& array, int k) {
        // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (array.size() <= 1) {
            return 0;
        }
        int result = 0;
        vector<vector<int>> matrix(k + 1, vector<int>(array.size(), 0));
        for (int kk = 1; kk <= k; kk++)
        {
            int temp = matrix[kk - 1][0] - array[0];
            for (int ii = 1; ii < array.size(); ii++)
            {
                matrix[kk][ii] = max(matrix[kk][ii - 1], array[ii] + temp);
                temp = max(temp, matrix[kk - 1][ii] - array[ii]);
                result = max(result, matrix[kk][ii]);
            }
        }
        return result;
        // zero time	0 0 0 0 0 0 0 0  
        //	1st time	0 1 1 1 3 4 4 10    tmp:-2, -2, -2, -1, -1, -1, -1
        //	2nd time	0 1 1 1 6 7 7 13	tmp:-2, -1,  2,  2,  2,  2, 2
    }
};


class Solution95 {
    /*Buy Stock IV
     Given an array of integers representing a stock’s price on each day.On each day you can only make one operation : either buy or sell one unit of stock, and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total.Determine the maximum profit you can make.
     
     Assumptions
     
     The give array is not null and is length of at least 2
     Examples
     
     { 2, 3, 2, 1, 4, 5, 2, 11 }, K = 3, the maximum profit you can make is(3 - 2) + (5 - 1) + (11 - 2) = 14*/
public:
    int maxProfit(vector<int> array, int k) {
        int leng = array.size();
        if (leng <= 1) {
            return 0;
        }
        if (k<1)
        {
            return 0;
        }
        vector<vector<int>> matrix(k + 1, vector<int>(leng, 0));
        int result = 0;
        for (int kk = 1; kk <= k; kk++)
        {
            int temp = matrix[kk - 1][0] - array[0];
            for (int ii = 1; ii < leng; ii++)
            {
                matrix[kk][ii] = max(matrix[kk][ii - 1], array[ii] + temp);
                temp = max(temp, matrix[kk - 1][ii] - array[ii]);
                result = max(result, matrix[kk][ii]);
            }
        }
        return result;
    }
};

class Solution96 {
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
public:
    int minCostInterative(vector<int> stones) {
        int leng = (int)stones.size();
        if (leng == 0) {
            return 0;
        }
        vector<vector<int>> mincost(leng, vector<int>(leng, 0));
        vector<vector<int>> subsumm(leng, vector<int>(leng, 0));
        //        for(int i=0;i<leng;i++) {
        //            for(int j=i;j<leng;j++) {
        //                if(j==i) {
        //                    mincost[i][j]=0;
        //                    subsumm[i][j]=stones[i];
        //                }
        //                else {
        //                    mincost[i][j]=INT_MAX;
        //                    subsumm[i][j]=subsumm[i][j-1]+stones[j];
        //                    for(int k=i;k<j;k++) {
        //                        mincost[i][j]=min(mincost[i][j], mincost[i][k]+mincost[k+1][j]+subsumm[i][j]);
        //                    }
        //                }
        //            }
        //        }
        
        for (int i = 0; i<leng; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    mincost[j][i] = 0;
                    subsumm[j][i] = stones[i];
                }
                else {
                    mincost[j][i] = INT_MAX;
                    subsumm[j][i] = subsumm[j][i - 1] + stones[i];
                    for (int k = j; k<i; k++) {
                        mincost[j][i] = min(mincost[j][i], mincost[j][k] + mincost[k + 1][i] + subsumm[j][i]);
                    }
                }
                //cout << j << " " << i << " " << mincost[j][i] << endl;
            }
        }
        return mincost[0][leng - 1];
    }
    int minCost(vector<int> stones) {
        //        ​if leng==1
        //        ​return a[0]
        //        if leng==2
        //        ​return a[0]+a[1]
        //        if leng==3
        //        ​return min(a[0]+a[1], a[1]+a[2])+sum
        //        if leng==4
        //        ​return min(a[0]+a[1], a[1]+a[2], a[2]+a[3]) + leng==3时的最优解
        //        if leng==5
        //        ​return min(a[0]+a[1], a[1]+a[2], a[2]+a[3], a[3]+a[4]) + leng==4时的最优解
        int leng = (int)stones.size();
        int summary = 0;
        for (auto i : stones) {
            summary += i;
        }
        if (leng == 1) {
            return 0;
        }
        else if (leng == 2) {
            return summary;
        }
        else if (leng == 3) {
            return min(stones[0] + stones[1], stones[1] + stones[2]) + summary;
        }
        else {
            int result = INT_MAX;
            for (int i = 0; i<leng - 1; i++) {
                int current = stones[i] + stones[i + 1];
                vector<int> next_stones(leng - 1, 0);
                for (int j = 0; j<i; j++) {
                    next_stones[j] = stones[j];
                }
                next_stones[i] = current;
                for (int j = i + 2; j<leng; j++) {
                    next_stones[j - 1] = stones[j];
                }
                result = min(result, current + minCost(next_stones));
            }
            return result;
        }
    }
};

class Solution97 {
    //Largest SubArray Sum
    //	Given an unsorted integer array, find the subarray that has the greatest sum.Return the sum.
    
    //	Assumptions
    
    //	The given array is not null and has length of at least 1.
    //	Examples
    
    //{ 2, -1, 4, -2, 1 }, the largest subarray sum is 2 + (-1) + 4 = 5
    
    //{-2, -1, -3}, the largest subarray sum is - 1
public:
    int largestSum(vector<int> input) {
        int leng = (int)input.size();
        if (leng <= 0) {
            return 0;
        }
        else if (leng == 1) {
            return input[0];
        }
        vector<int> msum(leng, INT_MIN);
        msum[0] = input[0];
        int result = msum[0];
        for (int i = 1; i<leng; i++) {
            if (msum[i - 1] <= 0) {
                msum[i] = input[i];
            }
            else {
                msum[i] = msum[i - 1] + input[i];
            }
            result = max(result, msum[i]);
        }
        return result;
    }
};

class Solution98 {
    /*
     Largest SubArray Product
     Given an unsorted array of doubles, find the subarray that has the greatest product.Return the product.
     
     Assumptions
     
     The given array is not null and has length of at least 1.
     Examples
     
     { 2.0, -0.1, 4, -2, -1.5 }, the largest subarray product is 4 * (-2) * (-1.5) = 12
     */
public:
    double largestProduct(vector<double> array) {
        if (array.size()==0)
        {
            return 0;
        }
        double maxproduct = array[0];
        double maxtemp = array[0];
        double mintemp = array[0];
        for (int i = 1; i < array.size(); i++)
        {
            double a = maxtemp*array[i];
            double b = mintemp*array[i];
            maxtemp = max(array[i], max(a, b));
            mintemp = min(array[i], min(a, b));
            maxproduct = max(maxproduct, maxtemp);
        }
        return maxproduct;
    }

	double largestProduct1(vector<double> array) {
		int leng = array.size();
		if (leng==0)
		{
			return 0;
		}
		else if (leng == 1) {
			return array[0];
		}
		else if (leng == 2) {
			return max(array[0] * array[1], max(array[1], array[0]));
		}
		else {
			// 	//    	  0 2.0
			// 	//    	  1 -0.1
			// 	//    	  2 4
			// 	//    	  3 1.6
			// 	//    	  4 12
			double resultmax = DBL_MAX;
			for (int i = 0; i < leng; i++)
			{
				double loopmax = array[i];
				double current = array[i];
				resultmax = max(resultmax, current);
				for (int j = i; j >=0; j--)
				{
					if (j == i) {
						continue;
					}
					else {
						current = current*array[j];
						loopmax = max(loopmax, current);
						resultmax = max(resultmax, loopmax);
					}
				}
			}
			return resultmax;
		}
	}
};

class Solution99 {
    //Dictionary Word I
    //	Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
    
    //	Assumptions
    
    //	The given word is not null and is not empty
    //	The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
    //	Examples
    
    //	Dictionary : {“bob”, “cat”, “rob”}
    
    //Word: “robob” return false
    
    //Word : “robcatbob” return true since it can be composed by "rob", "cat", "bob"
public:
    bool canBreak(string input, vector<string> dict) {
        if (input.size() == 0) {
            return false;
        }
        vector<bool> vb(input.size() + 1, false);
        for (int i = 1; i <= input.size(); i++) {
            if (find(dict.begin(), dict.end(), input.substr(0, i)) != dict.end()) {
                vb[i] = true;
                continue;
            }
            for (int j = 1; j<i; j++) {
                if (vb[j] == true && (find(dict.begin(), dict.end(), input.substr(j, i - j)) != dict.end())) {
                    vb[i] = true;
                    break;
                }
            }
        }
        return vb[input.size()];
    }
};

class Solution100 {
    /*	Edit Distance
     Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
     
     Assumptions
     
     Both strings are not null
     Examples
     
     string one : “sigh”, string two : “asith”
     
     the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).*/
public:
    int editDistance(string s1, string s2) {
        int m = (int)s1.size(), n = (int)s2.size();
        vector<vector<int>> matrix(m + 1, vector<int>(n + 1, 0));
        matrix[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            matrix[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            matrix[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                else {
                    matrix[i][j] = min(matrix[i - 1][j - 1], min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
            }
        }
        return matrix[m][n];
    }
};

class Solution101 {
    //Largest Square Of 1s
    //	Determine the largest square of 1s in a binary matrix(a binary matrix only contains 0 and 1), return the length of the largest square.
    
    //	Assumptions
    
    //	The given matrix is not null and guaranteed to be of size N * N, N >= 0
    //	Examples
    
    //{ { 0, 0, 0, 0 },
    
    //{ 1, 1, 1, 1 },
    
    //{ 0, 1, 1, 1 },
    
    //{ 1, 0, 1, 1 } }
    
    //	the largest square of 1s has length of 2
public:
    int largest(vector<vector<int>> matrix) {
        int row = (int)matrix.size(), col = (int)matrix[0].size();
        int result = 0;
        vector<vector<int>> func(row, vector<int>(col, 0));
        for (int i = 0; i<row; i++) {
            if (matrix[i][0] == 0) {
                func[i][0] = 0;
            }
            result = max(result, func[i][0]);
        }
        for (int j = 0; j<col; j++) {
            if (matrix[0][j] == 0) {
                func[0][j] = 0;
            }
            result = max(result, func[0][j]);
        }
        for (int i = 1; i<row; i++) {
            for (int j = 1; j<col; j++) {
                if (matrix[i][j] == 0) {
                    func[i][j] = 0;
                }
                else {
                    func[i][j] = min(min(func[i - 1][j - 1], func[i - 1][j]), func[i][j - 1]) + 1;
                    result = max(result, func[i][j]);
                }
            }
        }
        return result;
    }
};

class Solution102 {
    
    //Largest Rectangle Of 1s
    //	Determine the largest rectangle of 1s in a binary matrix(a binary matrix only contains 0 and 1), return the area.
    
    //	Assumptions
    
    //	The given matrix is not null and has size of M * N, M >= 0 and N >= 0
    //	Examples
    
    //{ { 0, 0, 0, 0 },
    
    //{ 1, 1, 1, 1 },
    
    //{ 0, 1, 1, 1 },
    
    //{ 1, 0, 1, 1 } }
    
    //	the largest rectangle of 1s has area of 2 * 3 = 6
public:
    int largest(vector<vector<int>> matrix) {
        if (matrix.size()==0)
        {
            return 0;
        }
        int result = 0, m = matrix.size(), n = matrix[0].size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        vector<int> height(n, 0);
        for (int i = 0; i < m; i++) {
            int curleft = 0, curright = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[j]++;
                }
                else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[j]=max(curleft, left[j]);
                }
                else {
                    left[j] = 0;
                    curleft = j + 1;
                }
            }
            for (int j = n-1; j >= 0; j--)
            {
                if (matrix[i][j]==1)
                {
                    right[j] = min(right[j], curright);
                }
                else {
                    right[j] = n; curright = j;
                }
            }
            for (int j = 0; j < n; j++) {
                result = max(result, (right[j] - left[j])*height[j]);
            }
        }
        return result;
    }
};

class Solution103 {
    /*  Longest Consecutive 1s
     Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.
     
     Assumptions
     
     The given array is not null
     Examples
     
     { 0, 1, 0, 1, 1, 1, 0 }, the longest consecutive 1s is 3.*/
public:
    int longest(vector<int> input) {
        int leng = (int)input.size();
        if (leng <= 0) {
            return 0;
        }
        else if (leng == 1) {
            return input[0];
        }
        int result = 0;
        vector<int> vlargest(leng, 0);
        vlargest[0] = (input[0] == 0 ? 0 : 1);
        for (int i = 1; i<leng; i++) {
            if (input[i] == 1) {
                vlargest[i] = vlargest[i - 1] + 1;
            }
            else {
                vlargest[i] = 0;
            }
            result = max(result, vlargest[i]);
        }
        return result;
    }
};

class Solution104 {
    //    Longest Cross Of 1s
    //    Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
    //
    //    Return the arm length of the largest cross.
    //
    //    Assumptions
    //
    //    The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
    //    Examples
    //
    //    { {0, 0, 0, 0},
    //
    //        {1, 1, 1, 1},
    //
    //        {0, 1, 1, 1},
    //
    //        {1, 0, 1, 1} }
    //
    //    the largest cross of 1s has arm length 2.
public:
    int largest(vector<vector<int>> matrix) {
        //    {0, 0, 0, 0},
        //    {1, 1, 1, 1},
        //    {0, 1, 1, 1},
        //    {1, 0, 1, 1}
        //    left2right
        //    0 0 0 0
        //    1 2 3 4
        //    0 1 2 3
        //    1 0 1 2
        //    right2left
        //    0 0 0 0
        //    4 3 2 1
        //    0 3 2 1
        //    1 0 2 1
        //    up2down
        //    0 0 0 0
        //    1 1 1 1
        //    0 2 2 2
        //    1 0 3 3
        //    down2up
        //    0 0 0 0
        //    1 2 3 3
        //    0 1 2 2
        //    1 0 1 1
        int rows = (int)matrix.size(), cols;
        if (rows <= 0) {
            return 0;
        }
        cols = (int)matrix[0].size();
        if (rows == 1) {
            for (auto i : matrix[0]) {
                if (i == 1) {
                    return 1;
                }
            }
            return 0;
        }
        vector<vector<int>> ups(rows, vector<int>(cols, 0));
        vector<vector<int>> downs(rows, vector<int>(cols, 0));
        vector<vector<int>> lefts(rows, vector<int>(cols, 0));
        vector<vector<int>> rights(rows, vector<int>(cols, 0));
        int result = 0;
        // preprocess
        for (int i = 0; i<cols; i++) {
            for (int j = 0; j<rows; j++) {
                if (i == 0) {
                    lefts[j][i] = matrix[j][i];
                }
                else {
                    if (matrix[j][i] == 1) {
                        lefts[j][i] = lefts[j][i - 1] + 1;
                    }
                    else {
                        lefts[j][i] = 0;
                    }
                }
            }
        }
        for (int i = cols - 1; i >= 0; i--) {
            for (int j = 0; j<rows; j++) {
                if (i == cols - 1) {
                    rights[j][i] = matrix[j][i];
                }
                else {
                    if (matrix[j][i] == 1) {
                        rights[j][i] = rights[j][i + 1] + 1;
                    }
                    else {
                        rights[j][i] = 0;
                    }
                }
            }
        }
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (i == 0) {
                    ups[i][j] = matrix[i][j];
                }
                else {
                    if (matrix[i][j] == 1) {
                        ups[i][j] = ups[i - 1][j] + 1;
                    }
                    else {
                        ups[i][j] = 0;
                    }
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j<cols; j++) {
                if (i == rows - 1) {
                    downs[i][j] = matrix[i][j];
                }
                else {
                    if (matrix[i][j] == 1) {
                        downs[i][j] = downs[i + 1][j] + 1;
                    }
                    else {
                        downs[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                result = max(result, min(min(ups[i][j], downs[i][j]), min(lefts[i][j], rights[i][j])));
            }
        }
        return result;
    }
};

class Solution105 {
    //    Largest X Of 1s
    //    Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.
    //
    //    Return the arm length of the largest X shape.
    //
    //    Assumptions
    //
    //    The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
    //    Examples
    //
    //    { {0, 0, 0, 0},
    //
    //        {1, 1, 1, 1},
    //
    //        {0, 1, 1, 1},
    //
    //        {1, 0, 1, 1} }
    //
    //    the largest X of 1s has arm length 2.
public:
    int largest(vector<vector<int> > input) {
        //    {0, 0, 0, 0},
        //    {1, 1, 1, 1},
        //    {0, 1, 1, 1},
        //    {1, 0, 1, 1}
        //    leftdown2rightup
        //    0 0 0 0
        //    1 1 3 2
        //    0 2 1 2
        //    1 0 1 1
        //    rightup2leftdown
        //    0 0 0 0
        //    1 1 1 1
        //    0 2 2 1
        //    3 0 2 1
        //    leftup2rightdown
        //    0 0 0 0
        //    1 1 1 1
        //    0 2 2 2
        //    1 0 3 3
        //    rightdown2leftup
        //    0 0 0 0
        //    3 3 2 1
        //    0 2 2 1
        //    1 0 1 1
        int rows = (int)input.size(), cols;
        if (rows <= 0) {
            return 0;
        }
        cols = (int)input[0].size();
        if (rows == 1) {
            for (auto i : input[0]) {
                if (i == 1) {
                    return 1;
                }
            }
            return 0;
        }
        vector<vector<int>> leftups(rows, vector<int>(cols, 0));
        vector<vector<int>> rightups(rows, vector<int>(cols, 0));
        vector<vector<int>> leftdowns(rows, vector<int>(cols, 0));
        vector<vector<int>> rightdowns(rows, vector<int>(cols, 0));
        int result = 0;
        // preprocess
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (i == 0 || j == 0) {
                    leftups[i][j] = input[i][j];
                }
                else {
                    if (input[i][j] == 1) {
                        leftups[i][j] = leftups[i - 1][j - 1] + 1;
                    }
                    else {
                        leftups[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i<rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == 0 || j == cols - 1) {
                    rightups[i][j] = input[i][j];
                }
                else {
                    if (input[i][j] == 1) {
                        rightups[i][j] = rightups[i - 1][j + 1] + 1;
                    }
                    else {
                        rightups[i][j] = 0;
                    }
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j<cols; j++) {
                if (i == rows - 1 || j == 0) {
                    leftdowns[i][j] = input[i][j];
                }
                else {
                    if (input[i][j] == 1) {
                        leftdowns[i][j] = leftdowns[i + 1][j - 1] + 1;
                    }
                    else {
                        leftdowns[i][j] = 0;
                    }
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 || j == cols - 1) {
                    rightdowns[i][j] = input[i][j];
                }
                else {
                    if (input[i][j] == 1) {
                        rightdowns[i][j] = rightdowns[i + 1][j + 1] + 1;
                    }
                    else {
                        rightdowns[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                result = max(result, min(min(leftups[i][j], leftdowns[i][j]), min(rightdowns[i][j], rightups[i][j])));
            }
        }
        return result;
    }
};

class Solution106 {
    //    Largest SubMatrix Sum
    //    Given a matrix that contains integers, find the submatrix with the largest sum.
    //
    //    Return the sum of the submatrix.
    //    Assumptions
    //
    //    The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
    //    Examples
    //
    //    { {1, -2, -1, 4},
    //
    //        {1, -1,  1, 1},
    //
    //        {0, -1, -1, 1},
    //
    //        {0,  0,  1, 1} }
    //
    //    the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
private:
    int matrixSumHelper(vector<int>& array) {
        int leng = (int)array.size();
        if (leng <= 0) {
            return 0;
        }
        else if (leng == 1) {
            return array[0];
        }
        vector<int> msum(leng, INT_MIN);
        msum[0] = array[0];
        int result = msum[0];
        for (int i = 1; i<leng; i++) {
            if (msum[i - 1]>0) {
                msum[i] = msum[i - 1] + array[i];
            }
            else {
                msum[i] = array[i];
            }
            result = max(msum[i], result);
        }
        return result;
    }
public:
    int largest(vector<vector<int>> matrix) {
        // write your solution here.
        int rows = (int)matrix.size();
        if (rows <= 0) {
            return 0;
        }
        else if (rows == 1) {
            return matrixSumHelper(matrix[0]);
            
        }
        int cols = (int)matrix[0].size();
        //  preprocess
        //      { {1, -2, -1, 4},
        //        {1, -1,  1, 1},
        //        {0, -1, -1, 1},
        //        {0,  0,  1, 1} }
        vector<vector<int>> matrixSum(rows, vector<int>(cols, INT_MIN));
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (j == 0) {
                    matrixSum[i][j] = matrix[i][j];
                }
                else {
                    matrixSum[i][j] = matrixSum[i][j - 1] + matrix[i][j];
                }
            }
        }
        int result = INT_MIN;
        for (int i = 0; i<cols; i++) {
            for (int j = i; j<cols; j++) {
                vector<int> testing;
                for (int m = 0; m<rows; m++) {
                    testing.push_back(matrixSum[m][j] - matrixSum[m][i] + matrix[m][i]);
                }
                result = max(result, matrixSumHelper(testing));
            }
        }
        return result;
    }
};

class Solution107 {
    //    Largest SubMatrix Product
    //    Given a matrix that contains doubles, find the submatrix with the largest product.
    //
    //    Return the product of the submatrix.
    //
    //    Assumptions
    //
    //    The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1
    //    Examples
    //
    //    { {1, -0.2, -1},
    //
    //        {1, -1.5,  1},
    //
    //        {0,     0,  1} }
    //
    //    the largest submatrix product is 1 * 1 = 1.
public:
    double largest(vector<vector<double>> matrix) {
        if (matrix.size()==0) {
            return 0.0;
        }
        int rows=matrix.size(), cols=matrix[0].size();
        //		{2.0, -1.0,  0.5,  1.0, -3.0},
        //		{0.0, -2.0, -1.0,  2.0,  0.1},
        //		{3.0,  0.2,  1.0, -3.0, -2.0}
        //		2.0 -2.0 -1.0 -1.0  3.0
        //		0.0  0.0  0.0  0.0  0.0
        //		3.0  0.6  0.6 -1.8  3.6
        double result=matrix[0][0];
        vector<vector<double>> matrixProduct(rows, vector<double>(cols, 0));
        //preprocess for all columns
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (j==0) {
                    matrixProduct[i][j]=matrix[i][j];
                }
                else {
                    matrixProduct[i][j]=matrix[i][j]*matrixProduct[i][j-1];
                    //Perhaps this value == -0.0
                    if(abs(matrixProduct[i][j])==0) {
                        matrixProduct[i][j]=0;
                    }
                }
            }
        }
        //zip all the rows for [i,j] columns (0<=i<=j<N)
        for (int i=0; i<cols; i++) {
            for (int j=i; j<cols; j++) {
                vector<double> testing(rows, 0);
                for (int m=0; m<rows; m++) {
                    if (matrixProduct[m][j]==0 && matrix[m][j]!=0) {
                        testing[m]=1;
                        for (int k=i; k<=j; k++) {
                            testing[m]=testing[m]*matrix[m][k];
                        }
                    }
                    else if (matrix[m][j]==0) {
                        testing[m]=0;
                    }
                    else {
                        testing[m]=matrixProduct[m][j]/matrixProduct[m][i]*matrix[m][i];
                    }
                }
                result=max(result, matrixProductHelper(testing));
            }
        }
        return result;
    }
private:
    double matrixProductHelper(vector<double>& array) {
        if (array.size()==0) {
            return 0;
        }
        double maxProduct=array[0];
        double minCurrent=array[0];
        double maxCurrent=array[0];
        for (int i=1; i<array.size(); i++) {
            double a=minCurrent*array[i];
            double b=maxCurrent*array[i];
            minCurrent=min(array[i], min(a, b));
            maxCurrent=max(array[i], max(a, b));
            maxProduct=max(maxProduct, maxCurrent);
        }
        return maxProduct;
    }
};
class Solution108 {
    //    Perfect Shuffle
    //    Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.
    //
    //    Assumptions
    //
    //    The given array is not null
public:
    // std::srand(time(NULL)); is already called for you.
    void solve(vector<int>& input) {
        int leng = (int)input.size();
        for (int i = 0; i<leng; i++) {
            int idx = rand() % (leng - i);
            swap(input[i], input[i + idx]);
        }
        return;
    }
};

class Solution109 {
    //    Reservoir Sampling
    //    Consider an unlimited flow of data elements. How do you sample one element from this flow, such that at any point during the processing of the flow, you can return a random element from the n elements read so far.
    //
    //        You will implement two methods for a sampling class:
    //
    //            read(int value) - read one number from the flow
    //            sample() - return at any time the sample, if n values have been read, the probability of returning any one of the n values is 1/n, return null(Java)/INT_MIN(C++) if there is no value read so far
    //                You may need to add more fields for the class.
private:
    int count = 0;
    int result;
public:
    int sample() {
        return result;
    }
    
    void read(int i) {
        count++;
        int prob = rand() % count;
        //prob has the probability 1/count to be the 0th current sample
        if (prob == 0) {
            result = i;
        }
    }
};

class Solution110 {
    //    Generalized Reservoir Sampling
    //    Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far.
    //
    //        Assumptions
    //
    //        k >= 1
    //        You will implement two methods for a sampling class:
    //
    //            read(int value) - read one number from the flow
    //            sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
    //            You may need to add more fields for the class.
private:
    int k;
    vector<int> result;
public:
    Solution110(int size) {
        k=size;
    }
    vector<int> sample() {
        return result;
    }
    void read(int i) {
        if (result.size()<=k) {
            result.push_back(i);
        }
        else {
            int index=rand()*k;
            if (index<k) {
                result[index]=i;
            }
        }
    }
};

class Solution111 {
    //    Random7 Using Random5
    //    Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().
private:
    int rand5() {
        return rand() % 5;
    }
public:
    Solution111() {
        srand((unsigned int)time(NULL));
    }
    int solve() {
        // use rand5() here.
        while (1) {
            int num = 0;
            for (int i = 0; i<2; i++) {
                num = num * 5 + rand5();
            }
            if (num<21) {
                return num % 7;
            }
        }
    }
};

class Solution112 {
    //    Random1000 Using Random5
    //    Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
    // std::srand(time(NULL)); is called for you.
private:
    int rand5() {
        return rand() % 5;
    }
public:
    Solution112() {
        srand((unsigned int)time(NULL));
    }
    int solve() {
        // use rand5() here.
        //5^3=125, 5^5=125*25>1000, so we call rand5 5 times to get result
        
        while (1) {
            int num = 0;
            for (int i = 0; i<5; i++) {
                num = num * 5 + rand5();
            }
            if (num<1000) {
                return num;
            }
            else {
                return num % 1000;
            }
        }
    }
};

class Solution113 {
    //    Median Tracker
    //    Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
    //
    //    You will have to implement the following two methods for the class
    //
    //        read(int value) - read one value from the flow
    //        median() - return the median at any time, return null if there is no value read so far
    //            Examples
    //
    //            read(1), median is 1
    //            read(2), median is 1.5
    //            read(3), median is 2
    //            read(10), median is 2.5
    //            ......
    
public:
    priority_queue<int, vector<int>, less<int>> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    Solution113() {
    }
    double median() {
        int size = (int)max_heap.size() + (int)min_heap.size();
        if (size != 0) {
            if (size % 2 == 0) {
                return (double)(max_heap.top() + min_heap.top()) / 2.0;
            }
            else {
                return max_heap.top();
            }
        }
        else {
            return 0;
        }
    }
    
    void read(int i) {
        //guarantee all the time max_heap.size()>=min_heap.size()
        if (max_heap.size()>min_heap.size()) {
            if (i >= max_heap.top()) {
                min_heap.push(i);
            }
            else {
                int other = max_heap.top();
                max_heap.pop();
                min_heap.push(other);
                max_heap.push(i);
            }
        }
        else if (max_heap.size() == min_heap.size()) {
            if (max_heap.size() == 0 || i <= min_heap.top()) {
                max_heap.push(i);
            }
            else {
                int other = min_heap.top();
                min_heap.pop();
                max_heap.push(other);
                min_heap.push(i);
            }
        }
    }
};

class Solution114 {
    //    95 Percentile
    //    Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).
    //
    //    Assumptions
    //
    //    The maximum length of valid url is 4096
    //
    //    The list is not null and is not empty and does not contain null
    //
    //    Examples
    //
    //    [1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
    
public:
    int solve(vector<int> values) {
        //    95 Percentile
        vector<int> counts(4097, 0);
        for (auto i : values) {
            counts[i]++;
        }
        int sum = 0;
        int leng = 4097;
        while (sum <= 0.05*values.size()) {
            sum += counts[--leng];
        }
        return leng;
    }
};

class Solution115 {
    //    Array Deduplication I
    //    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
    //
    //    Assumptions
    //
    //    The array is not null
    //    Examples
    //
    //    {1, 2, 2, 3, 3, 3} → {1, 2, 3}
public:
    vector<int> dedup(vector<int> input) {
        int leng = (int)input.size();
        if (leng <= 1) {
            return input;
        }
        //1, 2, 3, 4, 3, 3, 4, 4
        //            s
        //                  f
        int slow = 1, fast = 1;
        while (fast<leng) {
            if (input[fast] != input[slow - 1]) {
                input[slow] = input[fast];
                fast++;
                slow++;
            }
            else {
                fast++;
            }
        }
        input.resize(slow);
        return input;
    }
};

class Solution116 {
    //    Array Deduplication II
    //    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
    //    
    //    Assumptions
    //    
    //    The given array is not null
    //    Examples
    //    
    //    {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
public:
    vector<int> dedup(vector<int> array) {
        int leng = (int)array.size();
        if (leng <= 2) {
            return array;
        }
        //1, 2, 2, 3, 3, 4, 4, 4
        //                  s
        //                     f
        int slow = 2, fast = 2;
        while (fast<leng) {
            if (array[fast] != array[slow - 2]) {
                array[slow] = array[fast];
                fast++;
                slow++;
            }
            else {
                fast++;
            }
        }
        array.resize(slow);
        return array;
    }
};

class Solution117 {
    //    Array Deduplication III
    //    Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.
    //        
    //        Assumptions
    //        
    //        The given array is not null
    //        Examples
    //        
    //    {1, 2, 2, 3, 3, 3} → {1}
public:
    vector<int> dedup(vector<int> array) {
        int leng = (int)array.size();
        if (leng >= 1) {
            return array;
        }
        //{1, 2, 2, 3, 3, 3, 4} → {1}
        //    s
        //                   f1
        //                   f2
        int slow = 0, fast1 = 0, fast2 = 0;
        while (fast2<leng) {
            if (array[fast2] == array[fast1]) {
                while (fast2<leng && array[fast2] == array[fast1]) {
                    fast2++;
                }
            }
            if (fast2>fast1 + 1) {
                fast1 = fast2;
            }
            else {
                array[slow] = array[fast1];
                slow++;
                fast1++;
            }
        }
        array.resize(slow);
        return array;
    }
};

class Solution118 {
    
    //    Array Deduplication IV
    //    Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.
    //        
    //        Do this in-place, using the left side of the original array. Return the array after deduplication.
    //        
    //        Assumptions
    //        
    //        The given array is not null
    //        Examples
    //        
    //    {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
public:
    vector<int> dedup(vector<int> input) {
        int leng = (int)input.size();
        if (leng <= 1) {
            return input;
        }
        vector<int> result;
        //{1, 2, 3, 3, 3, 2}
        //       slow
        //                fast
        for (int fast = 0; fast<leng; ) {
            if (result.size()>0 && result.back() == input[fast]) {
                while (fast<leng && result.back() == input[fast]) {
                    fast++;
                }
                result.pop_back();
            }
            else {
                result.push_back(input[fast]);
                fast++;
            }
        }
        return result;
    }
};

class Solution119 {
    //    Largest And Smallest
    //    Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.
    //    
    //    Assumptions
    //    
    //    The given array is not null and has length of at least 1
    //    Examples
    //    
    //    {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
    //
public:
    vector<int> largestAndSmallest(vector<int> input) {
        int leng = (int)input.size();
        if (leng<1) {
            return { 0,0 };
        }
        else if (leng == 1) {
            return { input[0], input[0] };
        }
        else if (leng == 2) {
            return { max(input[0], input[1]), min(input[0], input[1]) };
        }
        vector<int> large;
        vector<int> small;
        int largest = INT_MIN, smallest = INT_MAX;
        for (int i = 0; i<leng; i += 2) {
            if (i + 1<leng) {
                large.push_back(max(input[i], input[i + 1]));
                small.push_back(min(input[i], input[i + 1]));
            }
            else {
                large.push_back(input[i]);
                small.push_back(input[i]);
            }
            largest = max(largest, large.back());
            smallest = min(smallest, small.back());
        }
        return { largest, smallest };
    }
};

class Solution120 {
    //    Largest And Second Largest
    //    Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.
    //    
    //    Assumptions
    //    
    //    The given array is not null and has length of at least 2
    //    Examples
    //    
    //    {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
    //    -1 5 4 5 4 2 1 5 4 3
public:
    vector<int> largestAndSecond(vector<int> array) {
        int leng=(int)array.size();
        if (leng<1) {
            return {0, 0};
        }
        else if (leng==1) {
            return {array[0], array[0]};
        }
        else if (leng==2) {
            return {max(array[0], array[1]), min(array[0], array[1])};
        }
        int leng2=2*leng;
        int secondLarge=-1;
        int index;
        vector<int> heaper(leng2, -1);
        for (index=leng; index<leng2; index++) {
            heaper[index]=array[index-leng];
        }
        for (index=leng2-2; index>=2; index=index-2) {
            heaper[index/2]=max(heaper[index], heaper[index+1]);
        }
        int largest=heaper[1];
        for (index=1; index<leng; ) {
            if (heaper[2*index]==heaper[index]) {
                if (secondLarge<heaper[2*index+1]) {
                    secondLarge=heaper[2*index+1];
                }
                index=2*index;
            }
            else {
                if (secondLarge<heaper[2*index]) {
                    secondLarge=heaper[2*index];
                }
                index=2*index+1;
            }
        }
        return {largest, secondLarge};
    }
};

class Solution121 {
    //    Spiral Order Traverse I
    //    Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
    //
    //    Assumptions
    //
    //    The 2D array is not null and has size of N * N where N >= 0
    //    Examples
    //
    //    { {1,  2,  3},
    //
    //        {4,  5,  6},
    //
    //        {7,  8,  9} }
    //
    //    the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
private:
    void spiralHelper(vector<vector<int>>& input, vector<int>& result, int offset, int size) {
        if (size == 1) {
            result.push_back(input[0 + offset][0 + offset]);
            return;
        }
        else if (size == 0) {
            return;
        }
        for (int i = 0; i<size - 1; i++) {
            result.push_back(input[0 + offset][i + offset]);
        }
        for (int i = 0; i<size - 1; i++) {
            result.push_back(input[i + offset][size - 1 + offset]);
        }
        for (int j = size - 1; j>0; j--) {
            result.push_back(input[size - 1 + offset][j + offset]);
        }
        for (int j = size - 1; j>0; j--) {
            result.push_back(input[j + offset][0 + offset]);
        }
        spiralHelper(input, result, offset + 1, size - 2);
    }
public:
    vector<int> spiral(vector<vector<int>> input) {
        if (input.size() == 0) {
            return {};
        }
        vector<int> result;
        spiralHelper(input, result, 0, (int)input.size());
        return result;
    }
};

class Solution122 {
    //    Spiral Order Traverse II
    //    Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
    //
    //    Assumptions
    //
    //    The 2D array is not null and has size of M * N where M, N >= 0
    //    Examples
    //
    //    { {1,  2,  3,  4},
    //
    //        {5,  6,  7,  8},
    //
    //        {9, 10, 11, 12} }
    //
    //    the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
private:
    void spiralHelper2(vector<vector<int>>& matrix, vector<int>& result, int offset, int m, int n) {
        //1行或者1列
        if (m == 0 || n == 0) {
            return;
        }
        else if (m == 1 || n == 1) {
            result.push_back(matrix[offset + m - 1][offset + n - 1]);
            return;
        }
        else if (m == 1) {
            for (int i = 0; i<n; i++) {
                result.push_back(matrix[offset + m - 1][offset + i]);
            }
            return;
        }
        else if (n == 1) {
            for (int i = 0; i<m; i++) {
                result.push_back(matrix[offset + i][offset + n - 1]);
            }
            return;
        }
        for (int i = 0; i<n - 1; i++) {
            result.push_back(matrix[0 + offset][i + offset]);
        }
        for (int i = 0; i<m - 1; i++) {
            result.push_back(matrix[i + offset][n - 1 + offset]);
        }
        for (int j = n - 1; j>0; j--) {
            result.push_back(matrix[m - 1 + offset][j + offset]);
        }
        for (int j = m - 1; j>0; j--) {
            result.push_back(matrix[j + offset][0 + offset]);
        }
        spiralHelper2(matrix, result, offset + 1, m - 2, n - 2);
    }
public:
    vector<int> spiral(vector<vector<int>> matrix) {
        int m = (int)matrix.size(), n = (int)matrix[0].size();
        vector<int> result;
        if (m == 0 || n == 0) {
            return result;
        }
        spiralHelper2(matrix, result, 0, m, n);
        return result;
    }
};

class Solution123 {
    //    Spiral Order Generate I
    //    Generate an N * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, N * N in increasing order.
    //
    //    Assumptions
    //
    //    N >= 0
    //    Examples
    //
    //    N = 3, the generated matrix is
    //
    //    { {1,  2,  3}
    //
    //        {8,  9,  4},
    //
    //        {7,  6,  5} }
private:
    void helper(int offset, int size, int& current, vector<vector<int>>& result) {
        if (size==0) {
            return;
        }
        else if(size==1) {
            result[offset][offset]=current++;
            return;
        }
        for (int i=0; i<size-1; i++) {
            result[0+offset][i+offset]=current++;
        }
        for (int i=0; i<size-1; i++) {
            result[i+offset][size-1+offset]=current++;
        }
        for (int i=size-1; i>0; i--) {
            result[size-1+offset][i+offset]=current++;
        }
        for (int i=size-1; i>0; i--) {
            result[i+offset][0+offset]=current++;
        }
        helper(offset+1, size-2, current, result);
    }
public:
    vector<vector<int>> solve(int n) {
        if (n==1) {
            return {{1}};
        }
        vector<vector<int>> result(n, vector<int>(n, 0));
        int now=1;
        helper(0, n, now, result);
        return result;
    }
};

class Solution124 {
    //    Spiral Order Generate II
    //    Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.
    //
    //    Assumptions
    //
    //    M >= 0, N >= 0
    //    Examples
    //
    //    M = 3, N = 4, the generated matrix is
    //
    //    { {1,  2,  3,  4}
    //
    //        {10, 11, 12, 5},
    //
    //        {9,  8,  7,  6} }
    
private:
    void solveHelper(vector<vector<int>>& matrix, int count, int offset, int m, int n) {
        int counter = count;
        if (m == 0 || n == 0) {
            return;
        }
        else if (m == 1) {
            for (int i = 0; i<n; i++) {
                matrix[m - 1 + offset][i + offset] = counter++;
            }
            return;
        }
        else if (n == 1) {
            for (int i = 0; i<m; i++) {
                matrix[i + offset][n - 1 + offset] = counter++;
            }
            return;
        }
        for (int i = 0; i<n - 1; i++) {
            matrix[0 + offset][i + offset] = counter++;
        }
        for (int i = 0; i<m - 1; i++) {
            matrix[i + offset][n - 1 + offset] = counter++;
        }
        for (int j = n - 1; j>0; j--) {
            matrix[m - 1 + offset][j + offset] = counter++;
        }
        for (int j = m - 1; j>0; j--) {
            matrix[j + offset][0 + offset] = counter++;
        }
        solveHelper(matrix, counter, offset + 1, m - 2, n - 2);
    }
public:
    vector<vector<int>> solve(int m, int n) {
        vector<vector<int>> result;
        if (m == 0 || n == 0) {
            return result;
        }
        else if (m == 1) {
            vector<int> row;
            for (int i = 0; i<n; i++) {
                row.push_back(i + 1);
            }
            result.push_back(row);
            return result;
        }
        else if (n == 1) {
            for (int i = 0; i<m; i++) {
                vector<int> col;
                col.push_back(i + 1);
                result.push_back(col);
            }
            return result;
        }
        else if (m>1 && n>1) {
            for (int i = 0; i<m; i++) {
                vector<int> col;
                for (int j = 0; j<n; j++) {
                    col.push_back(0);
                }
                result.push_back(col);
            }
            solveHelper(result, 1, 0, m, n);
        }
        return result;
    }
};

class Solution125 {
    //    Rotate Matrix
    //    Rotate an N * N matrix clockwise 90 degrees.
    //
    //    Assumptions
    //
    //    The matrix is not null and N >= 0
    //    Examples
    //
    //    { {1,  2,  3}
    //
    //        {8,  9,  4},
    //
    //        {7,  6,  5} }
    //
    //    after rotation is
    //
    //    { {7,  8,  1}
    //
    //        {6,  9,  2},
    //
    //        {5,  4,  3} }
private:
    void solveHelper(vector<vector<int>>& matrix, int offset, int size) {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i<size - 1; i++) {
            //0 0       -> 0 n-1       -> n-1 n-1       -> n-1 0
            //0 1       -> 1 n-1       -> n-1 n-2       -> n-2 1
            //0 2       -> 2 n-1       -> n-1 n-3       -> n-3 2
            //....
            //0 n-2     -> n-2 n-1     -> n-1 1         -> 1 0
            // 1  2  3  4
            // 5  6  7  8
            // 9  10 11 12
            // 13 14 15 16
            // 13  9 5 1
            // 14 10 6 2
            // 15 11 7 3
            // 16 12 8 4
            int temp = matrix[0 + offset][i + offset];
            matrix[0 + offset][i + offset] = matrix[size - 1 + offset - i][0 + offset];
            matrix[size - 1 + offset - i][0 + offset] = matrix[size - 1 + offset][size - 1 + offset - i];
            matrix[size - 1 + offset][size - 1 + offset - i] = matrix[i + offset][size - 1 + offset];
            matrix[i + offset][size - 1 + offset] = temp;
        }
        solveHelper(matrix, offset + 1, size - 2);
    }
public:
    void solve(vector<vector<int>>& matrix) {
        int leng = (int)matrix.size();
        solveHelper(matrix, 0, leng);
        return;
    }
};

class Solution126 {
    //    Lowest Common Ancestor I
    //    Given two nodes in a binary tree, find their lowest common ancestor.
    //
    //    Assumptions
    //
    //    There is no parent pointer for the nodes in the binary tree
    //
    //        The given two nodes are guaranteed to be in the binary tree
    //
    //        Examples
    //
    //        5
    //
    //        /   \
    //
    //        9     12
    //
    //        /  \      \
    //
    //        2    3      14
    //
    //        The lowest common ancestor of 2 and 14 is 5
    //
    //        The lowest common ancestor of 2 and 9 is 9
public:
    TreeNode* solve(TreeNode* root, TreeNode* one, TreeNode* two) {
        if (root == NULL) {
            return root;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode* leftsub = solve(root->left, one, two);
        TreeNode* rightsub = solve(root->right, one, two);
        if (leftsub != NULL && rightsub != NULL) {
            return root;
        }
        return leftsub == NULL ? rightsub : leftsub;
    }
};

class Solution127 {
    //    Lowest Common Ancestor II
    //    Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
    //
    //    Assumptions
    //
    //    There is parent pointer for the nodes in the binary tree
    //
    //        The given two nodes are not guaranteed to be in the binary tree
    //
    //        Examples
    //
    //        5
    //
    //        /   \
    //
    //        9     12
    //
    //        /  \      \
    //
    //        2    3      14
    //
    //        The lowest common ancestor of 2 and 14 is 5
    //
    //        The lowest common ancestor of 2 and 9 is 9
    //
    //        The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
private:
    int solve127Helper(TreeNodeP* one) {
        int result = 0;
        TreeNodeP* someone = one;
        while (someone != NULL) {
            result++;
            someone = someone->parent;
        }
        delete someone;
        return result;
    }
public:
    TreeNodeP* solve(TreeNodeP* one, TreeNodeP* two) {
        int height_one = solve127Helper(one);
        int height_two = solve127Helper(two);
        if (height_one>height_two) {
            int diff = abs(height_one - height_two);
            while (diff>0) {
                one = one->parent;
                diff--;
            } // same level
        }
        else if (height_two>height_one) {
            int diff = abs(height_one - height_two);
            while (diff>0) {
                two = two->parent;
                diff--;
            } // same level
        }
        while (one != NULL && two != NULL && one != two) {
            one = one->parent;
            two = two->parent;
        }
        return one;
    }
};

class Solution128 {
    //    Lowest Common Ancestor III
    //    Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
    //
    //    Return null If any of the nodes is not in the tree.
    //
    //    Assumptions
    //
    //    There is no parent pointer for the nodes in the binary tree
    //
    //        The given two nodes are not guaranteed to be in the binary tree
    //
    //        Examples
    //
    //        5
    //
    //        /   \
    //
    //        9     12
    //
    //        /  \      \
    //
    //        2    3      14
    //
    //        The lowest common ancestor of 2 and 14 is 5
    //
    //        The lowest common ancestor of 2 and 9 is 9
    //
    //        The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* one, TreeNode* two) {
        if (findNode(root, one)==false || findNode(root, two)==false) {
            return NULL;
        }
        return LCAHelper(root, one, two);
    }
private:
    TreeNode* LCAHelper(TreeNode* root, TreeNode* one, TreeNode* two) {
        if (root==NULL || one==root || two==root) {
            return root;
        }
        TreeNode* left=LCAHelper(root->left, one, two);
        TreeNode* right=LCAHelper(root->right, one, two);
        if (left!=NULL && right!=NULL) {
            return root;
        }
        return left==NULL?right:left;
    }
    
    bool findNode(TreeNode* one, TreeNode* two) {
        if (one==NULL || two==NULL) {
            return false;
        }
        else if (one==two){
            return true;
        }
        
        return findNode(one->left, two) || findNode(one->right, two);
    }
};

class Solution129 {
    //    Lowest Common Ancestor IV
    //    Given K nodes in a binary tree, find their lowest common ancestor.
    //
    //    Assumptions
    //
    //    K >= 2
    //
    //    There is no parent pointer for the nodes in the binary tree
    //
    //        The given K nodes are guaranteed to be in the binary tree
    //
    //        Examples
    //
    //        5
    //
    //        /   \
    //
    //        9     12
    //
    //        /  \      \
    //
    //        2    3      14
    //
    //        The lowest common ancestor of 2, 3, 14 is 5
    //
    //        The lowest common ancestor of 2, 3, 9 is 9
public:
    TreeNode* solve(TreeNode* root, vector<TreeNode*> nodes) {
        if (root == NULL) {
            return root;
        }
        for (auto node_i : nodes) {
            if (root == node_i) {
                return root;
            }
        }
        TreeNode* left_node = solve(root->left, nodes);
        TreeNode* right_node = solve(root->right, nodes);
        if (left_node != NULL && right_node != NULL) {
            return root;
        }
        return left_node != NULL ? left_node : right_node;
    }
};

class Solution130 {
    //    Deep Copy Skip List
    //    A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.
    //
    //    Make a deep copy of the original skip list.
public:
    class SkipListNode {
    public:
        int value;
        SkipListNode* next;
        SkipListNode* forward;
        SkipListNode(int v) {
            value = v;
            next = forward = NULL;
        }
    };
    
    SkipListNode* solve(SkipListNode* n) {
        if (n==NULL) {
            return n;
        }
        unordered_map<SkipListNode*, SkipListNode*> mapper;
        SkipListNode* head=n;
        SkipListNode* result=new SkipListNode(n->value);
        mapper[head]=result;
        SkipListNode* newhead=result;
        SkipListNode* output=result;
        while (head->next!=NULL) {
            newhead->next=new SkipListNode(head->next->value);
            mapper[head->next]=newhead->next;
            head=head->next;
            newhead=newhead->next;
        }
        head=n;
        newhead=result;
        while (head!=NULL) {
            if (head->forward!=NULL) {
                newhead->forward=mapper[head->forward];
            }
            head=head->next;
            newhead=newhead->next;
        }
        return output;
    }
};

class Solution131 {
    //    Deep Copy Linked List With Random Pointer
    //    Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
    //
public:
    class RandomListNode {
    public:
        int value;
        RandomListNode* next;
        RandomListNode* random;
        RandomListNode(int v) {
            value = v;
            next = random = NULL;
        }
    };
    RandomListNode* solve(RandomListNode* n) {
        if (n == NULL) {
            return NULL;
        }
        RandomListNode* result = new RandomListNode(n->value);
        unordered_map<RandomListNode*, RandomListNode*> lookup;
        RandomListNode* current = result;
        while (n != NULL) {
            lookup[n] = current;
            if (n->next != NULL) {
                if (lookup.count(n->next) == 0) {
                    lookup[n->next] = new RandomListNode(n->next->value);
                }
                current->next = lookup[n->next];
            }
            if (n->random != NULL) {
                if (lookup.count(n->random) == 0) {
                    lookup[n->random] = new RandomListNode(n->random->value);
                }
                current->random = lookup[n->random];
            }
            current = current->next;
            n = n->next;
        }
        return result;
    }
};

class Solution132 {
    
    //    Deep Copy Undirected Graph
    //    Make a deep copy of an undirected graph, there could be cycles in the original graph.
    //
    //    Assumptions
    //
    //    The given graph is not null
    
public:
    GraphNode* solve(GraphNode* startNode) {
        if (startNode == NULL) {
            return NULL;
        }
        GraphNode* result = new GraphNode(startNode->value);
        unordered_map<GraphNode*, bool> lookup;
        lookup[startNode] = true;
        solveHelper(startNode, result, lookup);
        return result;
    }
    void solveHelper(GraphNode* east, GraphNode* west, unordered_map<GraphNode*, bool>& dict) {
        if (east == NULL) {
            //base case
            return;
        }
        for (GraphNode* neighbor : east->neighbors) {
            GraphNode* newone = new GraphNode(neighbor->value);
            if (dict.count(neighbor) == 0) {
                west->neighbors.push_back(newone);
                dict[neighbor] = true;
                solveHelper(neighbor, newone, dict);
            }
        }
        return;
    }
};

class Solution133 {
    //    Merge K Sorted Array
    //    Merge K sorted array into one big sorted array in ascending order.
    //
    //    Assumptions
    //
    //    The input arrayOfArrays is not null, none of the arrays is null either.
    
public:
    struct element {
        int index_of_row;
        int index_in_row;
        int value;
        bool operator>(const element& a) const {
            return value>a.value;
        }
        bool operator<(const element& a) const {
            return value<a.value;
        }
    };
    vector<int> merge(vector<vector<int> > arrayOfArrays) {
        int rows = (int)arrayOfArrays.size();
        vector<int> result;
        if (rows == 0) {
            return result;
        }
        else if (rows == 1) {
            return arrayOfArrays[0];
        }
        else {
            priority_queue<element, vector<element>, greater<element>> min_heap;
            element current;
            int leng = 0;
            for (int i = 0; i<rows; i++) {
                vector<int> rowi = arrayOfArrays[i];
                leng += rowi.size();
                if (rowi.size() != 0) {
                    current.index_of_row = i;
                    current.index_in_row = 0;
                    current.value = rowi[0];
                    min_heap.push(current);
                }
            }
            while (!min_heap.empty()) {
                element temp = min_heap.top();
                result.push_back(temp.value);
                //				cout << min_heap.size() << endl;
                min_heap.pop();
                if (temp.index_in_row + 1<arrayOfArrays[temp.index_of_row].size()) {
                    temp.index_in_row += 1;
                    temp.value = arrayOfArrays[temp.index_of_row][temp.index_in_row];
                    min_heap.push(temp);
                }
            }
            return result;
            //            for(int i=0;i<rows;i++) {
            //                for(int j=0;j<arrayOfArrays[i].size();j++) {
            //                    current.index_of_row=i;
            //                    current.index_in_row=j;
            //                    current.value=arrayOfArrays[i][j];
            //                    min_heap.push(current);
            //                }
            //            }
            //            while(!min_heap.empty()) {
            //                current=min_heap.top();
            //                result.push_back(current.value);
            //                min_heap.pop();
            //            }
            //            return result;
        }
    }
};

class Solution134 {
    //    Merge K Sorted Lists
    //    Merge K sorted lists into one big sorted list in ascending order.
    //
    //    Assumptions
    //
    //    ListOfLists is not null, and none of the lists is null.
public:
    class listNodeComparer {
    public:
        bool operator()(const ListNode* a, const ListNode* b) {
            return (a->value > b->value);
        }
    };
    ListNode* solve(vector<ListNode*> input) {
        int rows = (int)input.size();
        if (rows == 0) {
            return NULL;
        }
        else if (rows == 1) {
            return input[0];
        }
        else {
            priority_queue<ListNode*, vector<ListNode*>, listNodeComparer> min_heap;
            ListNode* result = new ListNode(0);
            ListNode* current = result;
            for (int i = 0; i<rows; i++) {
                if (input[i] != NULL) {
                    min_heap.push(input[i]);
                }
            }
            while (!min_heap.empty()) {
                ListNode* temp = min_heap.top();
                current->next = temp;
                current = current->next;
                min_heap.pop();
                if (temp->next != NULL) {
                    temp = temp->next;
                    min_heap.push(temp);
                }
            }
            return result->next;
        }
    }
};

class Solution135 {
    //    Closest Number In Binary Search Tree
    //    In a binary search tree, find the node containing the closest number to the given target number.
    //
    //Assumptions:
    //
    //    The given root is not null.
    //    There are no duplicate keys in the binary search tree.
    //Examples:
    //
    //    5
    //
    //    /    \
    //
    //    2      11
    //
    //    /    \
    //
    //    6     14
    //
    //    closest number to 4 is 5
    //
    //    closest number to 10 is 11
    //
    //    closest number to 6 is 6
public:
    void closestHelper(TreeNode* root, int target, int& solution) {
        if (root == NULL) {
            return;
        }
        if (root->value < target) {
            if (abs(root->value - target) < abs(solution - target)) {
                solution = root->value;
            }
            closestHelper(root->right, target, solution);
        }
        else if (root->value > target) {
            if (abs(root->value - target) < abs(solution - target)) {
                solution = root->value;
            }
            closestHelper(root->left, target, solution);
        }
        else {
            solution = target;
            //return root->value; // target
        }
        return;
    }
    int closest(TreeNode* root, int target) {
        if (root == NULL) {
            return 0;
        }
        else {
            int solution = root->value;
            closestHelper(root, target, solution);
            return solution;
        }
    }
};

class Solution136 {
    //    Largest Number Smaller In Binary Search Tree
    //    In a binary search tree, find the node containing the largest number smaller than the given target number.
    //
    //    If there is no such number, return INT_MIN.
    //
    //Assumptions:
    //
    //    The given root is not null.
    //    There are no duplicate keys in the binary search tree.
    //    Examples
    //
    //    5
    //
    //    /    \
    //
    //    2      11
    //
    //    /    \
    //
    //    6     14
    //
    //    largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
    //
    //    largest number smaller than 10 is 6
    //
    //    largest number smaller than 6 is 5
public:
    void largestSmallerHelper(TreeNode* root, int target, int& solution) {
        if (root == NULL) {
            return;
        }
        else if (root->value >= target) {
            largestSmallerHelper(root->left, target, solution);
        }
        else {
            solution = root->value;
            largestSmallerHelper(root->right, target, solution);
        }
        return;
    }
    int largestSmaller(TreeNode* root, int target) {
        if (root == NULL) {
            return 0;
        }
        else {
            int solution = INT_MIN;
            largestSmallerHelper(root, target, solution);
            return solution;
        }
    }
};

class Solution137 {
    //    Cutting Wood I
    //    There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A. The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.
    //    
    //    Examples
    //    
    //    L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
public:
    int minCost(vector<int> cuts, int length) {
        int leng = (int)cuts.size();
        vector<int> fullcuts(leng + 2, 0);    //full size of cost, has 0, length
        for (int i = 0; i<leng; i++) {
            fullcuts[i + 1] = cuts[i];
        }
        fullcuts[leng + 1] = length;
        leng = leng + 2;
        vector<vector<int>> matrix(leng, vector<int>(leng, INT_MAX));
        for (int dist = 1; dist<leng; dist++) {
            for (int i = 0; i<leng - dist; i++) {
                int j = i + dist;
                if (dist == 1) {
                    matrix[i][j] = 0;
                }
                else {
                    for (int k = i + 1; k<j; k++) {
                        //						cout << matrix[i][j] << "\t" << matrix[i][k] << "\t" << matrix[k][j] << "\t" << fullcuts[j] << "\t" << fullcuts[i] << endl;
                        matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j] + fullcuts[j] - fullcuts[i]);
                    }
                }
            }
        }
        return matrix[0][leng - 1];
    }
};

class Solution138 {
    //    Maximum Path Sum Binary Tree I
    //    Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
    //
    //    Examples
    //
    //    -15
    //
    //    /    \
    //
    //    2      11
    //
    //    /    \
    //
    //    6     14
    //
    //    The maximum path sum is 6 + 11 + 14 = 31.
private:
    int getMaxPathSumHelper(TreeNode* root, int& result) {
        if (root == NULL) {
            return 0;
        }
        
        int leftsum = 0, rightsum = 0;
        if (root->left) {
            leftsum = getMaxPathSumHelper(root->left, result);
        }
        if (root->right) {
            rightsum = getMaxPathSumHelper(root->right, result);
        }
        if (root->left && root->right) {
            result = max(result, root->value + leftsum + rightsum);
            return max(leftsum, rightsum) + root->value;
        }
        else if (root->left) {
            return leftsum + root->value;
        }
        else {
            return rightsum + root->value;
        }
    }
    
public:
    int maxPathSum(TreeNode* root) {
        if (root == NULL) {
            return INT_MIN;
        }
        int result = INT_MIN;
        getMaxPathSumHelper(root, result);
        return result;
    }
};


class Solution139 {
    //    Maximum Path Sum Binary Tree II
    //    Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).
    //
    //    Assumptions
    //
    //    ​The root of the given binary tree is not null
    //    Examples
    //
    //    -1
    //
    //    /    \
    //
    //    2      11
    //
    //    /    \
    //
    //    6    -14
    //
    //    one example of paths could be -14 -> 11 -> -1 -> 2
    //
    //    another example could be the node 11 itself
    //
    //    The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
private:
    int maxPathSumHelper(TreeNode* root, int& global_max) {
        if (root == NULL) {
            return 0;
        }
        int left_in = maxPathSumHelper(root->left, global_max);
        int right_in = maxPathSumHelper(root->right, global_max);
        left_in = max(left_in, 0);
        right_in = max(right_in, 0);
        global_max = max(global_max, left_in + right_in + root->value);
        //from any node to any node
        return max(left_in, right_in) + root->value;
    }
public:
    int maxPathSum(TreeNode* root) {
        int result = INT_MIN;
        maxPathSumHelper(root, result);
        return result;
    }
};

class Solution140 {
    //    Maximum Path Sum Binary Tree III
    //    Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).
    //
    //    Assumptions
    //
    //    The root of given binary tree is not null
    //    Examples
    //
    //    -5
    //
    //    /    \
    //
    //    2      11
    //
    //    /    \
    //
    //    6     14
    //
    //    /
    //
    //    -3
    //
    //    The maximum path sum is 11 + 14 = 25
private:
    // Time = O(n^2)
    void maxPathSumHelper(TreeNode* root, vector<TreeNode*>& path_prefix, int& global_max) {
        if (root == NULL) {
            return;
        }
        else {
            path_prefix.push_back(root);
            vector<int> local_max(path_prefix.size(), INT_MIN);
            local_max[0] = path_prefix[0]->value;
            for (int i = 1; i<path_prefix.size(); i++) {
                if (local_max[i - 1] <= 0) {
                    local_max[i] = path_prefix[i]->value;
                }
                else {
                    local_max[i] = path_prefix[i]->value + local_max[i - 1];
                }
                global_max = max(global_max, local_max[i]);
            }
            maxPathSumHelper(root->left, path_prefix, global_max);
            maxPathSumHelper(root->right, path_prefix, global_max);
            path_prefix.pop_back();
        }
    }
    // Time = O(n)
    void maxPathSumWorker(TreeNode* root, int presum, int& global_max) {
        if (root == NULL) {
            return;
        }
        if (presum <= 0) {
            presum = root->value;
        }
        else {
            presum += root->value;
        }
        global_max = max(global_max, presum);
        maxPathSumWorker(root->left, presum, global_max);
        maxPathSumWorker(root->right, presum, global_max);
        
    }
    // Bottom to Up
    int maxPathSumUpper(TreeNode* root, int presum, int& global_max) {
        if (root == NULL) {
            return 0;
        }
        int left_sum = maxPathSumUpper(root->left, presum, global_max);
        int right_sum = maxPathSumUpper(root->right, presum, global_max);
        int temp = max(0, max(left_sum, right_sum));
        global_max = max(global_max, temp);
        return temp + root->value;
    }
public:
    int maxPathSum(TreeNode* root) {
        int result = INT_MIN;
        vector<TreeNode*> routes;
        maxPathSumHelper(root, routes, result);
        maxPathSumWorker(root, 0, result);
        maxPathSumUpper(root, 0, result);
        return result;
    }
};

class Solution141 {
    //    Binary Tree Path Sum To Target III
    //    Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
    //
    //        Examples
    //
    //        5
    //
    //        /    \
    //
    //        2      11
    //
    //        /    \
    //
    //        6     14
    //
    //        /
    //
    //        3
    //
    //        If target = 17, There exists a path 11 + 6, the sum of the path is target.
    //
    //        If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
    //
    //        If target = 10, There does not exist any paths sum of which is target.
    //
    //        If target = 11, There exists a path only containing the node 11.
private:
    void matchedSumHelper(TreeNode* root, int presum, int target, unordered_map<int, int>& mymap, int& found) {
        if (root == NULL) {
            return;
        }
        presum += root->value;
        if (mymap[presum - target] != 0) {
            found = 1;
            return;
        }
        mymap[presum]++;
        matchedSumHelper(root->left, presum, target, mymap, found);
        matchedSumHelper(root->right, presum, target, mymap, found);
        mymap[presum]--;
        presum -= root->value;
        return;
    }
public:
    bool exist(TreeNode* root, int target) {
        int found = 0;
        unordered_map<int, int> mymap;
        mymap[0]++;
        matchedSumHelper(root, 0, target, mymap, found);
        return found == 1;
    }
};

class Solution142 {
    //    Binary Tree Diameter
    //    Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.
    //
    //    If there does not exist any such paths, return 0.
    //
    //    Examples
    //
    //    5
    //
    //    /    \
    //
    //    2      11
    //
    //          /    \
    //
    //          6     14
    //
    //    The diameter of this tree is 4 (2 → 5 → 11 → 14)
    //                      1
    //                   2     6
    //                3     4
    //              7  8   5
    //                9   10      7(9 8 3 2 4 5 10)
    //    1
    //       2
    //     3   4   (3 2 4)
public:
    int diameter(TreeNode* root) {
        int height=0;
        int counts=leaves(root);
        if (counts<=1) {
            return 0;
        }
        return diameter(root, height);
    }
private:
    int leaves(TreeNode* root) {
        if (root==NULL) {
            return 0;
        }
        if (root->left==NULL && root->right==NULL) {
            return 1;
        }
        else {
            return leaves(root->left)+leaves(root->right);
        }
    }
    int diameter(TreeNode* root, int& height) {
        if (root==NULL) {
            height=0;
            return 0;
        }
        
        int lh=0, rh=0;
        int ldiamter=0, rdiameter=0;
        ldiamter=diameter(root->left, lh);
        rdiameter=diameter(root->right, rh);
        height=max(lh, rh)+1;
        if (lh==0 || rh==0) {
            return max(ldiamter, rdiameter);
        }
        else {
            return max(max(ldiamter, rdiameter),lh+rh+1);
        }
    }
};

class Solution143 {
    //    Minimum Cuts For Palindromes
    //    Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.
    //
    //        Assumptions
    //
    //        The given string is not null
    //        Examples
    //
    //        “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
    //
    //        The minimum number of cuts needed is 3.
private:
    int getMinHelper(string input) {
        int leng = (int)input.size();
        if (leng <= 1) {
            return 0;
        }
        vector<vector<bool>> huiwen(leng+1, vector<bool>(leng+1, false));
        vector<int> mincuts(leng + 1, 0);
        for (size_t end = 1; end <= leng; end++)
        {
            mincuts[end] = (int)end;
            for (size_t start = end; start >= 1; start--)
            {
                if (input[start-1]==input[end-1])
                {
                    huiwen[start][end] = end - start < 2 || huiwen[start + 1][end - 1];
                }
                if (huiwen[start][end]) {
                    mincuts[end] = min(mincuts[end], mincuts[start - 1] + 1);
                }
            }
        }
        return mincuts[leng]-1;
    }
public:
    int minCuts(string input) {
        return getMinHelper(input);
    }
    void test() {
        cout<<minCuts("ababbbabbababa")<<endl;
    }
};

class Solution144 {
    //    Recover Binary Search Tree
    //    Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.
    //
    //Input:
    //
    //    4
    //
    //    / \
    //
    //    2   6
    //
    //    / \   / \
    //
    //    1  5 3  7
    //
    //Output:       4
    //
    //    / \
    //
    //    2   6
    //
    //    /  \   / \
    //
    //    1  3   5  7
public:
    TreeNode* recover(TreeNode* root) {
        if (root==NULL || (root->left ==NULL && root->right==NULL)) {
            return root;
        }
        recoverHelper(root, INT_MIN, INT_MAX);
        if (node1!=NULL && node2!=NULL) {
            swap(node1->value, node2->value);
        }
        return root;
    }
private:
    TreeNode* node1=NULL;
    TreeNode* node2=NULL;
    TreeNode* prev=NULL;
    
    void recoverHelper(TreeNode* root, int left, int right) {
        if (root==NULL) {
            return;
        }
        recoverHelper(root, left, root->value);
        if (prev!=NULL && prev->value>root->value) {
            if (node1==NULL) {
                node1=prev;
            }
            node2=root;
        }
        prev=root;
        recoverHelper(root->right, root->value, right);
    }
};

class Solution145 {
    
    //    Find all binary search trees
    //Description: Given a number n, generate all possible BST from 1…n.
    //
    //Input:   3
    //
    //Output:
    //
    //    1                 3       2              3      1
    //
    //    \              /         /   \          /           \
    //
    //    3        2       1        3    1               2
    //
    //    /         /                              \                \
    //
    //    2        1                                  2               3
public:
    vector<TreeNode*> generateBSTs(int n) {
        if (n<1) {
            return {};
        }
        else if (n==1) {
            TreeNode* t1=new TreeNode(1);
            return {t1};
        }
        vector<TreeNode*> result;
        result=buildBST(1, n);
        return result;
    }
private:
    vector<TreeNode*> buildBST(int left, int right) {
        vector<TreeNode*> result;
        if (left>right) {
            result.push_back(NULL);
            return result;
        }
        else if (left==right) {
            result.push_back(new TreeNode(left));
            return result;
        }
        for (int i=left; i<=right; i++) {
            vector<TreeNode*> lefts=buildBST(left, i-1);
            vector<TreeNode*> rights=buildBST(i+1, right);
            for (auto ileft:lefts) {
                for (auto iright:rights) {
                    TreeNode* ti=new TreeNode(i);  //must regeneate root each time
                    ti->left=ileft;
                    ti->right=iright;
                    result.push_back(ti);
                }
            }
        }
        return result;
    }
};

class Solution146 {
    //    Find Number of BSTs Generated
    //    Find the number of different Binary Search Trees generated from 1-n.
    //
    //Example:
    //
    //Input: 3, Return: 5
public:
    int numOfTrees(int n) {
        if (n<=0) {
            return 0;
        }
        else if (n==1) {
            return 1;
        }
        vector<TreeNode*> result=constructBST(1, n);
        return result.size();
    }
    
private:
    vector<TreeNode*> constructBST(int left, int right) {
        vector<TreeNode*> result;
        if (left>right) {
            result.push_back(NULL);
            return result;
        }
        else if(left==right) {
            result.push_back(new TreeNode(left));
            return result;
        }
        for (int i=left; i<=right; i++) {
            vector<TreeNode*> lefts=constructBST(left, i-1);
            vector<TreeNode*> rights=constructBST(i+1, right);
            for (auto ileft:lefts) {
                for (auto iright:rights) {
                    TreeNode* ti=new TreeNode(i);
                    ti->left=ileft;
                    ti->right=iright;
                    result.push_back(ti);
                }
            }
        }
        return result;
    }
};

class Solution147 {
    
    //    Restore IP Addresses
    //    Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
    //
    //Input:  ”25525511135”
    //
    //Output: [“255.255.11.135”, “255.255.111.35”]
public:
    vector<string> restore(string ip) {
        vector<string> combo;
        vector<string> result;
        restoreHelper(ip, 0, combo, result);
        return result;
    }
private:
    void restoreHelper(string& ip, int left, vector<string>& combo, vector<string>& result) {
        if (combo.size()==4) {
            if (left == ip.size()) {
                string addr = combo[0];
                for (int i = 1; i < 4; i++) {
                    addr += ("." + combo[i]);
                }
                result.push_back(addr);
            }
            return;
        }
        string current;
        for (int i = left; i < ip.size() && i < left+3; i++)
        {
            current += ip[i];
            if (isValidNum(current));
            {
                combo.push_back(current);
                restoreHelper(ip, i+1, combo, result);
                combo.pop_back();
            }
        }
    }
    
    bool isValidNum(string s) {
        if (s.empty() || s.size() > 3) return false;
        if (s[0] == '0' && s.size() != 1) return false;
        if (s.size() == 3 && stoi(s) > 255) return false;
        return true;
    }
};

class Solution148 {
    /*Decode Ways
     A message containing letters from A - Z is being encoded to numbers using the following ways :
     ‘A’ = 1
     ‘B’ = 2
     …
     ‘Z’ = 26
     Given an encoded message containing digits, determine the total number of ways to decode it.
     Input:    “212”
     It can be either decoded as 2, 1, 2("BAB") or 2, 12("BL") or 21, 2("UB"), return 3.*/
public:
    int numDecodeWay(string s) {
        if (s.size() == 0 || s[0] == '0')
        {
            return 0;
        }
        return numDecodeWay(s, 0);
    }
    
    int numDecodeWay1(string s) {
        int n = s.size();
        vector<int> mem(n + 1, -1);
        mem[n] = 1;
        return s.empty() ? 0 : num(0, s, mem);
    }
    
    int num(int i, string& s, vector<int>& mem) {
        if (mem[i] >= 0)	return mem[i];
        if (s[i] == '0')	return mem[i] = 0;
        int result = num(i + 1, s, mem);
        if (i < s.size() - 1 && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
            result += num(i + 2, s, mem);
        }
        return mem[i] = result;
    }
    
    int numDecoding(string s) {
        int n = s.size();
        vector<int> dp(n + 1);
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--)
        {
            if (s[i]=='0')
            {
                dp[i] = '0';
            }
            else {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return s.empty() ? 0 : dp[0];
    }
    
    int numDecoding1(string s) {
        int p = 1, pp, n = s.size();
        for (int i = n - 1; i >= 0; i--) {
            int curr = s[i] == '0' ? 0 : p;
            if (i < n - 1 && (s[i] == '1' || (s[i] == '2'&&s[i + 1] < '7'))) {
                curr += pp;
            }
            pp = p;
            p = curr;
        }
        return s.empty()?0:p;
    }
    
private:
    int numDecodeWay(string& s, int i) {
        if (i==s.size())
        {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        int result = numDecodeWay(s, i + 1);
        if (i < s.size() - 1 && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
            result += numDecodeWay(s, i + 2);
        }
        return result;
    }
    
};

class Solution149 {
    //Merge Two Sorted Array
    //	Merge two sorted arrays.
    
    //	Input: [1, 2, 3], [2, 4, 6]
    
    //	Output : [1, 2, 2, 3, 4, 6]
public:
    vector<int> merge(vector<int> A, int m, vector<int> B, int n) {
        int index = m + n - 1, idx1 = m - 1, idx2 = n - 1;
        while (idx1>=0 && idx2>=0)
        {
            if (A[idx1] < B[idx2]) {
                A[index--] = B[idx2--];
            }
            else {
                A[index--] = A[idx1--];
            }
        }
        if (idx2>=0 || idx1<0)
        {
            while (index >= 0) {
                A[index--] = B[idx2--];
            }
        }
        return A;
    }
};

class Solution150 {
    //Scramble String
    //	Given a string s1, we may represent it as a binary tree by partitioning it to two non - empty substrings recursively.
    
    //	Below is one possible representation of s1 = "great":
    
    //great
    
    //	/ \
    
    //	gr    eat
    
    //	/ \ / \
    
    //	g   r  e   at
    
    //	/ \
    
    //	a   t
    
    //	To scramble the string, we may choose any non - leaf node and swap its two children.For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    
    //	rgeat
    
    //	/ \
    
    //	rg    eat
    
    //	/ \ / \
    
    //	r   g   e   at
    
    //	/ \
    
    //	a   t
    
    //	We say that "rgeat" is a scrambled string of "great".Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
    
    //	rgtae
    
    //	/ \
    
    //	rg    tae
    
    //	/ \ / \
    
    //	r   g  ta  e
    
    //	/ \
    
    //	t   a
    
    //	We say that "rgtae" is a scrambled string of "great".Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
    
public:
    bool isScramble(string s1, string s2) {
        if (s1.size() != s2.size()) {
            return false;
        }
        int leng = s1.size();
        vector<vector<vector<int>>> memo(leng, vector<vector<int>>(leng, vector<int>(leng, -1)));
        return isScrambleMemo(s1, 0, s2, 0, leng, memo);
    }
private:
    bool isScrambleMemo(string& s1, int i1, string& s2, int i2, int leng, vector<vector<vector<int>>>& memo) {
        if (leng==1)
        {
            return s1[i1] == s2[i2];
        }
        int result = memo[i1][i2][leng - 1];
        if (result!=-1)
        {
            return result == 1 ? true : false;
        }
        result = 0;
        for (int i = 1; i < leng; i++)
        {
            if (isScrambleMemo(s1, i1, s2, i2, i, memo) && isScrambleMemo(s1, i1+i, s2, i2+i, leng-i, memo))
            {
                result = 1;
                break;
            }
            if (isScrambleMemo(s1, i1, s2, i2+leng-i, i, memo) && isScrambleMemo(s1, i1+i, s2, i2, leng-i, memo))
            {
                result = 1;
                break;
            }
        }
        memo[i1][i2][leng - 1] = result;
        return result == 1 ? true : false;
    }
};

class Solution152 {
    
    //Remove Extra Duplicates from Sorted List
    //	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    
    //	Input:  1->2->3->3->4->4->5
    //	Output : 1->2->5
    //	Input : 1->1->1
    
    //	Output : NULL
public:
    ListNode* removeDup(ListNode* head) {
        if (head == NULL || head->next == NULL)
        {
            return head;
        }
        ListNode* fake = new ListNode(-1);
        fake->next = head;
        ListNode* prev = fake;
        ListNode* slow = head, *fast1 = head, *fast2 = head;
        int dist = 0;
        while (fast2 != NULL) {
            while (fast2 != NULL && fast2->value == fast1->value) {
                fast2 = fast2->next;
                dist++;
            }
            // 1   2   3   3   4   4   5
            //             s
            //                         f1
            //                             f2
            if (dist == 1)
            {
                slow->value = fast1->value;
                prev = slow;
                slow = slow->next;
                fast1 = fast2;
                dist = 0;
            }
            else {
                fast1 = fast2;
                dist = 0;
            }
        }
        ListNode* cur = slow;
        prev->next = NULL;
        while (cur != NULL) {
            slow = cur;
            cur = cur->next;
            delete slow;
        }
        return fake->next;
    }
};

class Solution153 {
	//Remove Duplicates from Sorted List
	//	Given a sorted linked list, delete all duplicates such that each element appear only once.

	//	Input: 1->1->2

	//	Output : 1->2
    ListNode* removeDup(ListNode* head) {
        if (head == NULL || head->next == NULL)
        {
            return head;
        }
        ListNode* prev = new ListNode(-1);
        prev->next = head;
        ListNode* slow = head, *fast1 = head, *fast2 = head;
        while (fast2 != NULL) {
            while (fast2 != NULL && fast2->value == fast1->value) {
                fast2 = fast2->next;
            }
            slow->value = fast1->value;
            prev = slow;
            slow = slow->next;
            fast1 = fast2;
        }
        prev->next = NULL;
        while (slow != NULL) {
            ListNode* curr = slow;
            slow = slow->next;
            delete curr;
        }
        return head;
    }
};

class Solution154 {
    //Word Search
    //	Given a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.The same letter cell may not be used more than once.
    //	Input: board = [
    //			   [“ABCE”],
    //			   [“SFCS”],
    //			   [“ADEE”]
    //		   ]
    //	Output: Word = “ABCCED”   return true
    //			   Word = “SEE”      return true
    //			   Word = “ABCB”      return false
public:
    bool isWord(vector<vector<char>> board, string word) {
        if (board.empty())
        {
            return false;
        }
        int rows = board.size(), cols = board[0].size();
        bool result = false;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++) {
                vector<vector<bool>> visited(rows, vector<bool>(cols, false));
                if (board[i][j]==word[0])
                {
                    wordSearch(board, word, i, j, 0, visited, result);
                }
                if(result) {
                    return result;
                }
            }
        }
        return result;
    }
private:
    void wordSearch(vector<vector<char>>& board, string& word, int row, int col, int i, vector<vector<bool>>& visited, bool& result) {
        if (result == true) {
            return;
        }
        if (i==word.size()-1 && board[row][col]==word[i])
        {
            result = true;
            return;
        }
        if (board[row][col] == word[i]) {
            visited[row][col] = true;
            if (row+1<board.size() && board[row+1][col]==word[i+1] && visited[row+1][col]==false)
            {
                wordSearch(board, word, row + 1, col, i + 1, visited, result);
			}
			if (result == false && col + 1 < board[0].size() && board[row][col + 1] == word[i + 1] && visited[row][col + 1] == false) {
				wordSearch(board, word, row, col + 1, i + 1, visited, result);
			}
			if (result == false && row - 1 >= 0 && board[row - 1][col] == word[i + 1] && visited[row - 1][col] == false)
			{
				wordSearch(board, word, row - 1, col, i + 1, visited, result);
			}
			if (result == false && col - 1 >= 0 && board[row][col - 1] == word[i + 1] && visited[row][col - 1] == false) {
				wordSearch(board, word, row, col - 1, i + 1, visited, result);
			}
			visited[row][col] = false;
		}
		return;
	}
};

class Solution155 {
	//Combinations
	//	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.    //	E.g.Input: n = 4, k = 2
	//	Output : [
	//				 [2, 4],
	//					 [3, 4],
	//					 [2, 3],
	//					 [1, 2],
	//					 [1, 3],
	//					 [1, 4]
	//			 ]
public:
	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> result;
		if (n < k) {
			return result;
		}
		vector<int> temp;
		combine(result, temp, 0, 0, n, k);
		return result;
	}

	vector<vector<int>> combine1(int n, int k) {
		vector<vector<int>> result;
		if (n == 0 || k == 0) {
			return result;
		}
		vector<int> temp(k, 0);
		core(result, temp, 1, n, k);
		return result;
	}
private:
	void core(vector<vector<int>>& result, vector<int>& temp, int start, int end, int k) {
		int i = start;
		while (i <= end - k + 1) {
			temp[temp.size() - k] = i;
			i++;
			if (k > 1) {
				core(result, temp, i, end, k - 1);
			}
			else {
				result.push_back(temp);
			}
		}
	}
	void combine(vector<vector<int>>& result, vector<int>& temp, int start, int size, int n, int k) {
		if (size == k) {
			result.push_back(temp);
			return;
		}
		for (int i = start; i < n; i++) {
			temp.push_back(i + 1);
			combine(result, temp, i + 1, size + 1, n, k);
			temp.pop_back();
		}
	}
};

class Solution156 {
//Minimum Window Substring
//	Given a string S and a string T, find the minimum window in S which will contain all the characters in T
//	Input : S = “ADOBECODEBANC”
//	T = “ABC”
//	Output : “BANC”
public:
	string minWindow(string s, string t) {
		if (t.size() > s.size()) {
			return "";
		}
		string result;
		int slow = 0, count = 0, min_len = s.size() + 1;
		unordered_map<char, int> dict;
		for (int i = 0; i < t.size(); i++) {
			dict[t[i]]++;
		}
		for (int fast = 0; fast < s.size(); fast++) {
			if (dict.find(s[fast]) != dict.end()) {
				dict[s[fast]]--;
				if (dict[s[fast]] >= 0) {
					count++;
				}
				while (count == t.size()) {
					if (fast - slow + 1 < min_len) {
						min_len = fast - slow + 1;
						result = s.substr(slow, min_len);
					}
					if (dict.find(s[slow]) != dict.end()) {
						dict[s[slow]]++;
						if (dict[s[slow]] > 0) {
							count--;
						}
					}
					slow++;
				}
			}
		}
		return result;
	}
};

class Solution158 {
	//Set Matrix Zeroes
	//	Given a m x n matrix, if an element is 0, set its entire row and column to 0.
	//	E.g.Input: Matrix = [
	//			[1, 1, 1, 1, 0],
	//			[0, 1, 1, 0, 1],
	//			[1, 1, 1, 0, 1],
	//			[1, 1, 1, 1, 1]
	//	]
	//	Output: Matrix = [
	//					[0, 0, 0, 0, 0],
	//					[0, 0, 0, 0, 0],
	//					[0, 0, 0, 0, 0],
	//					[0, 1, 1, 0, 0],
	//			]
public:
	vector<vector<int>> setZero(vector<vector<int>> matrix) {
		//[1, 1, 1, 1, 0],
		//[0, 1, 1, 0, 1],
		//[1, 1, 1, 0, 1],
		//[1, 1, 1, 1, 1]
		//rows(0, 0, 0, 1)
		//cols(0, 1, 1, 0, 0)
		//0 0 0 0 0
		//0 0 0 0 0
		//0 0 0 0 0
		//0 1 1 0 0
		//1.遍历第一行第一列得到first_row=0 first_col=0
		//2.遍历其他元素，若==0，则其第一行第一列为0
		//3.遍历其他元素，若第一行第一列为0，则=0
		//4.根据first_row,first_col置第一列第一行
		int rows = matrix.size(), cols = matrix[0].size();
		vector<int> m(rows, 1);
		vector<int> n(cols, 1);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					m[i] = 0; n[j] = 0;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (m[i] == 0 || n[j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
private:
    
};

class Solution159 {
	/*Simplify Path
		Given an absolute path for a file(Unix - style), simplify it.

		Input: path = “ / home / ”

		Output : “ / home”

		Input : path = “ / a / . / b / .. / .. / c / ”

		Output : “ / c”*/
public:
    string simplify(string path) {
        vector<string> arr;
        istringstream ss(path);
        string token;
        string result;
        while(getline(ss, token, '/')) {
            arr.push_back(token);
        }
        vector<string> real;
        for (int i=0; i<arr.size(); i++) {
            if (arr[i]=="" || arr[i]==".") {
                continue;
            }
            else if(arr[i]==".." && !real.empty()) {
                real.pop_back();
            }
            else if(arr[i]!="..") {
                real.push_back(arr[i]);
            }
        }
        for (int i=0; i<real.size(); i++) {
            result+="/"+real[i];
        }
        if(result.empty()) {
            return "/";
        }
        return result;
    }
private:
    
};

class Solution160 {
//    Climbing Stairs
//    There are in total n steps to climb until you can reach the top. You can climb 1 or 2 steps a time. Determine the number of ways you can do that.
//        
//        Example:
//        
//        Input: n = 4, Return 5.
public:
    int stairs(int n) {
        //		0 1
        //		1
        //
        //		0 1 2
        //		1 1 0
        //		2 0 0
        //
        //		0 1 2 3
        //		1 1 1 0
        //		2 0 1 0
        //		1 2 0 0
        //
        //		0 1 2 3 4
        //		1 1 1 1 0
        //		1 2 0 1 0
        //		1 1 2 0 0
        //		2 0 2 0 0
        //		2 0 1 1 0
        if(n<=0) {
            return 0;
        }
        else if(n==1) {
            return 1;
        }
        else if(n==2) {
            return 2;
        }
        else {
            vector<int> table(n, 0);
            table[0]=1;
            table[1]=2;
            for(int i=2;i<n;i++) {
                table[i]=table[i-1]+table[i-2];
            }
            return table[n-1];
        }
    }
private:
    
};

class Solution161 {
//    Square Root I
//    Given an integer number n, find its integer square root.
//    
//Assumption:
//    
//    n is guaranteed to be >= 0.
//Example:
//    
//Input: 18, Return: 4
//    
//Input: 4, Return: 2
public:
    int sqrt(int x) {
        if(x<=0) {
            return 0;
        }
        else if(x==1) {
            return 1;
        }
        else {
            int i=x/2;
            for(;i>=2;--i) {
                if(pow(i, 2)<=x) {
                    break;
                }
            }
            return i;
        }
    }
private:
    
};

class Solution162 {
//    Plus One
//    Given a non-negative number represented as an array of digits, plus one to the number.
//    
//Input: [2, 5, 9]
//    
//Output: [2, 6, 0]
public:
    vector<int> plus(vector<int> digits) {
        if (digits.empty()) {
            return digits;
        }
        int carry=1;
        for (int i=digits.size()-1; i>=0; i--) {
            int digit=(digits[i]+carry)%10;
            carry=(digits[i]+carry)/10;
            digits[i]=digit;
            if(carry==0) {
                return digits;
            }
        }
        vector<int> result(digits.size()+1);
        result[0]=1;
        return result;
    }
private:
    
};


class Solution163 {
//    Add Binary
//    Given two binary strings, return their sum (also a binary string).
//    
//Input: a = “11”
//    
//    b = “1”
//    
//Output: “100”
public:
    string addBinary(string a, string b) {
        if (a.empty()) {
            return b;
        }
        if (b.empty()) {
            return a;
        }
        int carry=0;
        int i=a.size()-1, j=b.size()-1;
        string result;
        while(i>=0 || j>=0 || carry!=0) {
            if (i>=0) {
                carry+=a[i]-'0';
                i--;
            }
            if(j>=0) {
                carry+=b[j]-'0';
                j--;
            }
            result.insert(result.begin(), carry%2+'0');
            carry=carry/2;
        }
        return result;
    }
private:
};

class Solution164 {
//    Minimum Path Sum
//    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//    
//Input: [
//        
//        [5, 1, 2, 4],
//        
//        [4, 1, 0, 1],
//        
//        [0, 3, 7, 6]
//        
//        ]    
//    
//Output: 14
public:
    int miniPathSum(vector<vector<int>> grid) {
        if (grid.empty()) {
            return 0;
        }
        int m=grid.size();
        int n=grid[0].size();
        int Min[m][n];
        Min[0][0]=grid[0][0];
        for(int i=1;i<m;i++) {
            Min[i][0]=grid[i][0]+Min[i-1][0];
        }
        for(int j=1;j<n;j++) {
            Min[0][j]=grid[0][j]+Min[0][j-1];
        }
        for(int ki=1;ki<m;ki++) {
            for(int kj=1;kj<n;kj++) {
                Min[ki][kj]=min(Min[ki-1][kj], Min[ki][kj-1])+grid[ki][kj];
            }
        }
        return Min[m-1][n-1];
    }
private:
    
};

class Solution165 {
//    Possible Paths with Obstacles
//    There is a robot on top left corner of the matrix, it can only move down or right. The matrix is represented by either 0(path) or 1(obstacle). For obstacle, robot can not move through. Find the number of possible ways for robot to move to right down corner.
//        
//        Input:    [
//                   
//                   [0,0,0],
//                   
//                   [0,1,0],
//                   
//                   [0,0,0]
//                   
//                   ]
//        
//        Output: 2
public:
    int possiblepath(vector<vector<int>>& obstacleGrid) {
        //if(m<n) return uniquePaths(n, m);
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<vector<int>> path(m, vector<int>(n, 0));
        path[0][0] = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==0) {
                    if (i==0 && j==0) {
                        path[0][0]=1;
                    }
                    else if(i==0) {
                        path[0][j] = path[0][j-1];
                    }
                    else if(j==0) {
                        path[i][0] = path[i-1][0];
                    }
                    else {
                        path[i][j] = path[i-1][j] + path[i][j-1];
                    }
                }
            }
        return path[m-1][n-1];
    }
private:
    
};

class Solution166 {
//    Rotate List by K places
//    Given a list, rotate the list to the right by k places, where k is non-negative.
//    
//Input: 1->2->3->4->5->NULL, k = 2
//    
//Output: 4->5->1->2->3->NULL
public:
    ListNode* rotateKplace(ListNode* head, int k) {
        if(head==NULL || k==0) {
            return head;
        }
        int leng=1;
        ListNode *p=head, *pre;
        while(p->next!=NULL) {
            p=p->next;
            leng++;
        }
        k=leng-k%leng;
        p->next=head;
        while(k--) {
            p=p->next;
        }
        head=p->next;
        p->next=NULL;
        return head;
    }
private:
    
};

class Solution167 {
//    Permutation Sequence
//    The set [1,2,3,…,n] contains a total of n! unique permutations, return kth largest permutation.
//    
//    E.g.    Input: n = 3, k = 2    =>    "123"
//    
//    "132"
//    
//    "213"
//    
//    "231"
//    
//    "312"
//    
//    "321"
//    
//Output: “132”
public:
    string getPermutation(int n, int k) {
        string perm;
        for(int i=1;i<=n;i++) {
            perm+=i+'0';
        }
        string result;
        int index=k;
        helper(perm, result, index, 0);
        return result;
    }
private:
    void helper(string input, string& result, int& index, int start) {
        if(start==input.size()) {
            index--;
            if(index==0) {
                result=input;
            }
            return;
        }
        for(int i=start;i<input.size();i++) {
            swap(input[i], input[start]);
            helper(input, result, index, start+1);
            swap(input[i], input[start]);
            
        }
    }
};

class Solution168 {
//    Length of Last Word
//    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//    
//Input: s = “Hello World   “
//    
//Output: 5
public:
    int lenOflast(string s) {
        int leng=0, i=s.size()-1;
        while (s[i]==' ') {
            i--;
        }
        for (; i>=0 && s[i]!=' '; i--) {
            leng++;
        }
        return leng;
    }
private:
    
};

class Solution169 {
//    Gray Code
//    The gray code is a binary numeral system where two successive values differ in only one bit.
//    
//    For example: given n = 2, return [0,1,3,2], the gray code sequence is:
//    
//    00 - 0
//    
//    01 - 1
//    
//    11 - 3
//    
//    10 - 2
//    
//    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//    
//    E.g.    Input: n = 2
//    
//Output: [0, 2, 3, 1]
public:
    vector<int> graycode(int n) {
        vector<string> array=grayHelper(n);
        vector<int> result;
        for (int i=0; i<array.size(); i++) {
            result.push_back(convert2b(array[i]));
        }
        return result;
    }
private:
    int convert2b(string a) {
        int result=0;
        for (int i=0; i<a.size(); i++) {
            if (a[i]=='1') {
                result=result*2+1;
            }
            else {
                result=result*2;
            }
        }
        return result;
    }
    vector<string> grayHelper(int n) {
        if(n<0) {
            return {};
        }
        else if(n==0) {
            return {"0"};
        }
        else if(n==1) {
            return {"0", "1"};
        }
        else {
            vector<string> result;
            vector<string> lower=grayHelper(n-1);
            for (int i=0; i<lower.size(); i++) {
                result.push_back("0"+lower[i]);
            }
            for (int i=lower.size()-1; i>=0; i--) {
                result.push_back("1"+lower[i]);
            }
            return result;
        }
    }
};

class Solution171 {
//    Common Elements In Three Sorted Array
//    Find all common elements in 3 sorted arrays.
//    
//    Assumptions
//    
//    The 3 given sorted arrays are not null
//    There could be duplicate elements in each of the arrays
//    Examples
//    
//    A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
public:
    vector<int> common(vector<int> a, vector<int> b, vector<int> c) {
        if (a.size() == 0 || b.size() == 0 || c.size() == 0) {
            return {};
        }
        vector<int> result;
        for (int i = 0, j = 0, k = 0; i<a.size() && j<b.size() && k<c.size(); ) {
            if (a[i] == b[j] && b[j] == c[k]) {
                result.push_back(a[i]);
                i++; j++; k++;
            }
            else if (a[i]<b[j] && a[i]<c[k]) {
                i++;
            }
            else if (a[i] == b[j] && a[i]<c[k]) {
                i++; j++;
            }
            else if (b[j]<a[i] && b[j]<c[k]) {
                j++;
            }
            else if (a[i]<b[j] && a[i] == c[k]) {
                i++; k++;
            }
            else if (b[j]<a[j] && b[j] == c[k]) {
                j++; k++;
            }
            else if (c[k]<a[i] && c[k]<b[j]) {
                k++;
            }
        }
        return result;
    }
};

class Solution172 {
//    String Replace
//    Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
//    
//    Assumptions
//    
//    input, S and T are not null, S is not empty string
//    Examples
//    
//    input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
//    input = "dodododo", S = "dod", T = "a", input becomes "aoao"

private:
    void finderHelper(string& input, int index, string s, vector<pair<int, int>>& positions) {
        for (int i = index, j = 0; i<input.size(); ) {
            while (input[i + j] == s[j] && j<s.size()) {
                j++;
            }
            //docomomomocomo    omo
            //0123456789
            //   i
            //docom
            if (j == s.size()) {
                positions.push_back(make_pair(i, j));
                i += j;
                j = 0;
            }
            else {
                i++;
                j = 0;
            }
        }
        return;
    }
    void replaceHelper(string& input, string t, vector<pair<int, int>>& positions) {
        for (int i = 0; i<positions.size(); i++) {
            int j = positions[i].first + i*((int)t.size() - positions[i].second);
            input.replace(j, positions[i].second, t);
        }
        return;
    }
public:
    string replace(string input, string s, string t) {
        if (input == "") {
            return input;
        }
        vector<pair<int, int>> positions;
        finderHelper(input, 0, s, positions);
        replaceHelper(input, t, positions);
        return input;
    }
};

class Solution173 {
//    Compress String
//    Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.
//    
//    Assumptions
//    
//    The string is not null
//    
//    The characters used in the original string are guaranteed to be ‘a’ - ‘z’
//    
//    There are no adjacent repeated characters with length > 9
//    
//    Examples
//    
//    “abbcccdeee” → “ab2c3de3”
public:
    string compress(string input) {
        int leng=input.length();
        if(leng<=1) {
            return input;
        }
        string output = "";
        output+=input[0];
        int count=1;
        for(int i=1;i<leng;) {
            while(i<leng && input[i]==input[i-1]) {
                count++;
                i++;
            }
            if(count>1) {
                output+=count+'0';
            }
            if(i<leng) {
                output+=input[i];
            }
            count=1;
            i++;
        }
        return output;
    }
private:
};

class Solution174 {
//    Decompress String I
//    Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. If the character does not have any adjacent repeated occurrences, it is not compressed.
//    
//    Assumptions
//    
//    The string is not null
//    
//    The characters used in the original string are guaranteed to be ‘a’ - ‘z’
//    
//    There are no adjacent repeated characters with length > 9
//    
//    Examples
//    
//    “acb2c4” → “acbbcccc”
public:
    string decompress(string input) {
    int leng=input.length();
    if(leng<=1) {
        return input;
    }
    string output="";
    char current=input[0];
    for(int i=0;i<leng;++i) {
        if(input[i]>'9') {
            current=input[i];
            output+=current;
        }
        else {
            for(char j='2';j<=input[i];j++) {
                output+=current;
            }
        }
    }
    return output;
}
private:
    
};

class Solution175 {
//    Decompress String II
//    Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.
//    
//    Assumptions
//    
//    The string is not null
//    
//    The characters used in the original string are guaranteed to be ‘a’ - ‘z’
//    
//    There are no adjacent repeated characters with length > 9
//    
//    Examples
//    
//    “a1c0b2c4” → “abbcccc”
public:
    string decompress(string input) {
        if (input.size() <= 1) {
            return input;
        }
        string result;
        for (int i = 0; i<input.size(); i++) {
            if (input[i] >= 'a' && input[i] <= 'z') {
                result.push_back(input[i]);
            }
            else {
                if (input[i] == '0') {
                    result.pop_back();
                }
                else {
                    for (int addt = input[i] - '0'; addt>0; addt--) {
                        result.push_back(result[result.size() - 1]);
                    }
                }
            }
        }
        return result;
    }
};

class Solution176 {
//    Longest Common Substring
//    Find the longest common substring of two given strings.
//    
//    Assumptions
//    
//    The two given strings are not null
//    Examples
//    
//    S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
private:
    //    void longestCommonHelper(string& s, int bs, string& t, int bt, string& result) {
    //        if (s.size()-bs<=result.size() || t.size()-bt<=result.size() || bs==s.size() || bt==t.size()) {
    //            return;
    //        }
    //        int fs=bs, ft=bt;
    //        while (s[fs]==t[ft] && fs<s.size() && ft<t.size()) {
    //            fs++;
    //            ft++;
    //        }
    //        if (result.size()<fs-bs) {
    //            result=s.substr(bs, fs-bs);
    //        }
    //        longestCommonHelper(s, bs+1, t, bt, result);
    //        longestCommonHelper(s, bs, t, bt+1, result);
    //        longestCommonHelper(s, bs+1, t, bt+1, result);
    //    }
    void longestCommonHelper(string& s, int m, string& t, int n, string& result) {
        vector<vector<int>> lcmatrix(m + 1, vector<int>(n + 1, 0));
        int maxsize=0;
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i==0 || j==0) {
                    lcmatrix[i][j]=0;
                }
                else if (s[i-1]==t[j-1]) {
                    lcmatrix[i][j]=lcmatrix[i-1][j-1]+1;
                    if (lcmatrix[i][j]>maxsize) {
                        maxsize=lcmatrix[i][j];
                        result=s.substr(i-maxsize, maxsize);
                    }
                }
                else {
                    lcmatrix[i][j]=0;
                }
            }
        }
        return;
    }
public:
    string longestCommon(string s, string t) {
        if (s.size()==0 || t.size()==0) {
            return "";
        }
        else {
            //          abcde
            //          cdf
            string result="";
            longestCommonHelper(s, (int)s.size(), t, (int)t.size(), result);
            return result;
        }
    }
};

class Solution177 {
//    Longest Common Subsequence
//    Find the length of longest common subsequence of two given strings.
//    
//    Assumptions
//    
//    The two given strings are not null
//    Examples
//    
//    S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
private:
    int lcsHelper(string& s, int m, string& t, int n) {
        if (m==0 || n==0) {
            return 0;
        }
        if (s[m-1]==t[n-1]) {
            return 1 + lcsHelper(s, m-1, t, n-1);
        }
        else {
            return max(lcsHelper(s, m-1, t, n), lcsHelper(s, m, t, n-1));
        }
    }
public:
    //    int longest(string s, string t) {
    //        int sleng=s.size(), tleng=t.size();
    //        if (sleng==0 || tleng==0) {
    //            return 0;
    //        }
    //        vector<vector<int>> lcmatrix(sleng+1, vector<int>(tleng+1, 0));
    //        for (int i=0; i<=sleng; i++) {
    //            for (int j=0; j<=tleng; j++) {
    //                if (i==0 || j==0) {
    //                    lcmatrix[i][j]=0;
    //                }
    //                else if (s[i-1]==t[j-1]) {
    //                    lcmatrix[i][j]=lcmatrix[i-1][j-1]+1;
    //                }
    //                else {
    //                    lcmatrix[i][j]=max(lcmatrix[i-1][j], lcmatrix[i][j-1]);
    //                }
    //            }
    //        }
    //        return lcmatrix[sleng][tleng];
    //    }
    int longest(string s, string t) {
        return lcsHelper(s, (int)s.size(), t, (int)t.size());
    }
};



class Solution178 {
//    Reverse Binary Tree Upside Down
//    Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.
//    
//    Examples
//    
//    1
//    /    \
//    2        5
//    /   \
//    3      4
//    
//    is reversed to
//    
//    3
//    /    \
//    2        4
//    /   \
//    1      5
public:
    TreeNode* reverse(TreeNode* root) {
        if (root == NULL || root->left == NULL) {
            return root;
        }
        TreeNode* subroot = reverse(root->left);
        root->left->left = root;  //必须用root->left, 而不是subroot
        root->left->right = root->right;
        root->left = NULL;
        root->right = NULL;
        return subroot;
    }
};

class Solution179 {
//    All Valid Permutations Of Parentheses II
//    Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
//    
//    Assumptions
//    
//    l, m, n >= 0
//    Examples
//    
//    l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]
public:
    void solveHelper(int length, vector<int>& remains, string& path_prefix, stack<char>& mystk, vector<string>& result) {
        for (auto i : remains) {
            if (i<0) {
                return;
            }
        }
        if (path_prefix.size() == length) {
            result.push_back(path_prefix);
        }
        if (remains[0]>0) {
            path_prefix.push_back('(');
            mystk.push('(');
            remains[0]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            remains[0]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[2]>0) {
            path_prefix.push_back('[');
            mystk.push('[');
            remains[2]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            remains[2]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[4]>0) {
            path_prefix.push_back('{');
            mystk.push('{');
            remains[4]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            remains[4]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[1]>remains[0] && mystk.top() == '(') {
            path_prefix.push_back(')');
            mystk.pop();
            remains[1]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('(');
            remains[1]++;
        }
        if (remains[3]>remains[2] && mystk.top() == '[') {
            path_prefix.push_back(']');
            mystk.pop();
            remains[3]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('[');
            remains[3]++;
        }
        if (remains[5]>remains[4] && mystk.top() == '{') {
            path_prefix.push_back('}');
            mystk.pop();
            remains[5]--;
            solveHelper(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('{');
            remains[5]++;
        }
    }
    vector<string> solve(int l, int m, int n) {
        int leng = 2 * (l + m + n);
        vector<int> counts;
        counts.push_back(l);
        counts.push_back(l);
        counts.push_back(m);
        counts.push_back(m);
        counts.push_back(n);
        counts.push_back(n);
        string combo = "";
        stack<char> mystk;
        vector<string> result;
        solveHelper(leng, counts, combo, mystk, result);
        return result;
    }
    void solveHelper2(int length, vector<int>& remains, string& path_prefix, stack<char>& mystk, vector<string>& result) {
        for (auto i : remains) {
            if (i<0) {
                return;
            }
        }
        if (path_prefix.size() == length) {
            result.push_back(path_prefix);
        }
        if (remains[0]>0) {
            path_prefix.push_back('(');
            mystk.push('(');
            remains[0]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            remains[0]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[2]>0 && remains[0] == 0) {
            path_prefix.push_back('[');
            mystk.push('[');
            remains[2]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            remains[2]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[4]>0 && remains[2] == 0 && remains[0] == 0) {
            path_prefix.push_back('{');
            mystk.push('{');
            remains[4]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            remains[4]++;
            mystk.pop();
            path_prefix.pop_back();
        }
        if (remains[1]>remains[0] && mystk.top() == '(') {
            path_prefix.push_back(')');
            mystk.pop();
            remains[1]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('(');
            remains[1]++;
        }
        if (remains[3]>remains[2] && mystk.top() == '[' && remains[1] == 0) {
            path_prefix.push_back(']');
            mystk.pop();
            remains[3]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('[');
            remains[3]++;
        }
        if (remains[5]>remains[4] && mystk.top() == '{' && remains[1] == 0 && remains[3] == 0) {
            path_prefix.push_back('}');
            mystk.pop();
            remains[5]--;
            solveHelper2(length, remains, path_prefix, mystk, result);
            path_prefix.pop_back();
            mystk.push('{');
            remains[5]++;
        }
    }
    vector<string> solve2(int l, int m, int n) {
        int leng = 2 * (l + m + n);
        vector<int> counts;
        counts.push_back(l);
        counts.push_back(l);
        counts.push_back(m);
        counts.push_back(m);
        counts.push_back(n);
        counts.push_back(n);
        string combo = "";
        stack<char> mystk;
        vector<string> result;
        solveHelper2(leng, counts, combo, mystk, result);
        return result;
    }
};

class Solution180 {
//    2 Sum
//    Determine if there exist two elements in a given array, the sum of which is the given target number.
//        
//        Assumptions
//        
//        The given array is not null and has length of at least 2
//        ​Examples
//        
//        A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
//    
//    A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
//    
//    A = {2, 4, 1}, target = 4, return false
public:
    bool existSum(vector<int> array, int target) {
        unordered_map<int, int> lookup;
        for (int i = 0; i<array.size(); i++) {
            if (lookup[target - array[i]]>0) {
                return true;
            }
            lookup[array[i]]++;
        }
        return false;
    }
};

class Solution181 {
//    2 Sum All Pair I
//    Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.
//    
//    Assumptions
//    
//    The given array is not null and has length of at least 2.
//    
//    Examples
//    
//    A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
//    
//    A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
private:
    void solveHelper(vector<int> array, int target, vector<vector<int>>& result) {
        unordered_map<int, set<int>> lookup;
        for (int i = 0; i<array.size(); i++) {
            if (lookup[target - array[i]].size()>0) {
                for (auto key : lookup[target - array[i]]) {
                    result.push_back({ key, i });
                }
            }
            //unordered_map[i]==0表示不存在，所以顺移
            lookup[array[i]].insert(i);
        }
    }
    void solveHelper2(vector<int> array, int target, vector<vector<int>>& result) {
        for (int i = 0; i<array.size() - 1; i++) {
            for (int j = i + 1; j<array.size(); j++) {
                if (array[i] + array[j] == target) {
                    result.push_back({ i, j });
                }
            }
        }
    }
public:
    vector<vector<int>> solve(vector<int> array, int target) {
        vector<vector<int>> result;
        //        solveHelper(array, target, result);
        solveHelper2(array, target, result);
        return result;
    }
};

class Solution182 {
//    2 Sum All Pair II
//    Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.
//    
//    Assumptions
//    
//    The given array is not null and has length of at least 2
//    The order of the values in the pair does not matter
//    Examples
//    
//    A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
private:
    void solveHelper(vector<int> array, int target, vector<vector<int>>& result) {
        unordered_map<int, int> lookup;
        unordered_map<int, bool> checker;
        for (int i = 0; i<array.size(); i++) {
            if (lookup[target - array[i]]>0 && checker[array[i]] == false) {
                result.push_back({ target - array[i], array[i] });
                checker[array[i]] = true;
                checker[target - array[i]] = true;
            }
            //unordered_map[i]==0表示不存在，所以顺移
            lookup[array[i]] = i + 1;
        }
    }
public:
    vector<vector<int>> solve(vector<int> array, int target) {
        vector<vector<int>> result;
        solveHelper(array, target, result);
        return result;
    }
};

class Solution183 {
//    2 Sum Closest
//    Find the pair of elements in a given array that sum to a value that is closest to the given target number. Return the values of the two numbers.
//    
//    Assumptions
//    
//    The given array is not null and has length of at least 2
//    Examples
//    
//    A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
public:
    vector<int> solve(vector<int> array, int target) {
        if(array.size()<=1) {
            return vector<int> ();
        }
        sort(array.begin(), array.end());
        if(array.size()==2) {
            return array;
        }
        int start=0, end=(int)array.size()-1;
        int minDist=INT_MAX;
        vector<int> result;
        while(start<end) {
            int sum=array[start]+array[end];
            int dist=abs(sum-target);
            if(dist<minDist) {
                result={array[start], array[end]};
                minDist=dist;
            }
            if(dist==0) {
                return result;
            }
            else if(sum>target) {
                end--;
            }
            else {
                start++;
            }
        }
        return result;
    }
};

class Solution184 {
//    2 Sum Smaller
//    Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.
//    
//    Assumptions
//    The given array is not null and has length of at least 2
//    Examples
//    A = {1, 2, 2, 4, 7}, target = 7, number of pairs is 6({1,2}, {1, 2}, {1, 4}, {2, 2}, {2, 4}, {2, 4})
public:
    int smallerPairs(vector<int> array, int target) {
        if(array.size()<=1) {
            return 0;
        }
        sort(array.begin(), array.end());
        if(array.size()==2) {
            if(array[0]+array[1]<=target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int result=0;
        for(int i=0;i<array.size()-1 && array[i]<=target;++i) {
            int other=target-array[i];
            int low=i, high=(int)array.size()-1;
            int mid = i;
            while(low<=high) {
                mid=low+(high-low)/2;
                if(array[mid]<other) {
                    if(mid+1<=high && array[mid+1]>=other) {
                        break;
                    }
                    else {
                        low=mid+1;
                    }
                }
                else {
                    if(mid-1>=low && array[mid-1]<other) {
                        mid=mid-1;
                        break;
                    }
                    else {
                        high=mid-1;
                    }
                }
            }
            result+=mid-i;
        }
        return result;
    }
    
};

class Solution185 {
//    2 Sum 2 Arrays
//    Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.
//    
//    Assumptions
//    The two given arrays are not null and have length of at least 1
//    Examples
//    A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)
//    A = {1, 3, 5}, B = {2, 8}, target = 6, return false
public:
    bool existSum(vector<int> a, vector<int> b, int target) {
        vector<int> vb=b;
        sort(vb.begin(), vb.end());
        for(int i=0;i<a.size();++i) {
            int other=target-a[i];
            int start=0, end=(int)vb.size()-1;
            while(start<=end) {
                int mid=start+(end-start)/2;
                if(vb[mid]==other) {
                    return true;
                }
                else if(vb[mid]>other){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return false;
    }
};

class Solution186 {
//    3 Sum
//    Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.
//        
//        Assumptions
//        
//        The given array is not null and has length of at least 3
//        No duplicate triples should be returned, order of the values in the tuple does not matter
//        Examples
//        A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
private:
    void solveHelper(vector<int> array, int target, vector<vector<int>>& result) {
        sort(array.begin(), array.end());
        for (int i = 0; i<array.size() - 2; i++) {
            if (i>0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1, right = (int)array.size() - 1;
            while (left<right) {
                int temp = target - array[i] - array[left] - array[right];
                if (temp == 0) {
                    result.push_back({ array[i], array[left], array[right] });
                    left++;
                    while (left<right && array[left] == array[left - 1]) {
                        left++;
                    }
                }
                else if (temp>0) {
                    left++;
                    while (left<right && array[left] == array[left - 1]) {
                        left++;
                    }
                }
                else {
                    right--;
                    while (left<right && array[right] == array[right + 1]) {
                        right--;
                    }
                }
            }
        }
    }
public:
    vector<vector<int>> solve(vector<int> array, int target) {
        vector<vector<int>> result;
        solveHelper(array, target, result);
        return result;
    }
};

class Solution187 {
//    3 Sum 3 Arrays
//    Given three arrays, determine if a set can be made by picking one element from each array that sums to the given target number.
//        
//        Assumptions
//        The three given arrays are not null and have length of at least 1
//        Examples
//        A = {1, 3, 5}, B = {8, 2}, C = {3}, target = 14, return true(pick 3 from A, pick 8 from B and pick 3 from C)
public:
    bool exist(vector<int> a, vector<int> b, vector<int> c, int target) {
        unordered_map<int, int> lookup;
        for(int i=0;i<c.size();i++) {
            lookup[c[i]]++;
        }
        for(int i=0;i<a.size();i++) {
            for(int j=0;j<b.size();j++) {
                if(lookup[target-a[i]-b[j]]>0) {
                    return true;
                }
            }
        }
        return false;
    }
};

class Solution188 {
//    4 Sum
//    Determine if there exists a set of four elements in a given array that sum to the given target number.
//        
//        Assumptions
//        The given array is not null and has length of at least 4
//        Examples
//        A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
//    A = {1, 2, 2, 3, 4}, target = 12, return false
public:
    bool exist(vector<int> array, int target) {
        unordered_map<int, pair<int, int>> lookup;
        for (int j = 1; j<array.size(); j++) {
            for (int i = 0; i<j; i++) {
                if (lookup[target - array[i] - array[j]].second>0 && lookup[target - array[i] - array[j]].second<i) {
                    return true;
                }
                else if (lookup[array[i] + array[j]].second == 0) {
                    lookup[array[i] + array[j]] = make_pair(i, j);
                }
            }
        }
        return false;
    }
};

class Solution189 {
//    Text Justification
//    Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//    
//Input: words: ["This", "is", "an", "example", "of", "text", "justification."]    L: 16.
//Output:[
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//Input: words: [“This”, “is”, “my”]       L = 5
//Output: [
//         “This ”,
//         “is my”
//         ]
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> result;
        int i=0, n=words.size();
        while (i<n) {
            int leng=words[i].size();
            int j=i+1;
            while (j<n && leng+1+words[j].size()<=maxWidth) {
                leng+=1+words[j].size();
                j++;
            }
            string line=words[i];
            if (j==n) {
                for (int k=i+1; k<n; k++) {
                    line+=" "+words[k];
                }
                while (line.size()<maxWidth) {
                    line+=" ";
                }
            }
            else {
                int whites=maxWidth-leng;
                int spaces=j-i-1;
                if (spaces==0) {
                    while (line.size()<maxWidth) {
                        line+=" ";
                    }
                }
                else {
                    for (int k=i+1; k<j; k++) {
                        line+=" ";
                        for (int p=0; p<whites/spaces; p++) {
                            line+=" ";
                        }
                        if (k-i<=whites%spaces) {
                            line+=" ";
                        }
                        line+=words[k];
                    }
                }
            }
            result.push_back(line);
            i=j;
        }
        return result;
    }
private:
    
};

class Solution190 {
//    Valid Number
//    Validate if a given string is numeric.
//        Input:  “0”    Output: true
//        Input:  “ 0.1 ” Output: true
//        Input:  “abc”   Output: false
//        Input:  “1 a”   Output: false
//        Input:  “2e10”    Output: true
public:
    bool isNumber(string s) {
        int i=0;
        for (; s[i]==' '; i++) {}
        if (s[i]=='+' || s[i]=='-') {
            i++;
        }
        int nums, pots;
        for (nums=0, pots=0; (s[i]<='9' && s[i]>='0') || (s[i]=='.'); i++) {
            if (s[i]=='.') {
                pots++;
            }
            else {
                nums++;
            }
        }
        if (nums<1 || pots>1) {
            return false;
        }
        if (s[i]=='e') {
            i++;
            if (s[i]=='+'||s[i]=='-') {
                i++;
            }
            int tails=0;
            for (; s[i]>='0' && s[i]<='9'; i++, tails++) {}
            if (tails<1) {
                return false;
            }
        }
        for (; s[i]==' '; i++) {}
        return s[i]==0;
    }
private:
    
};


class Solution191 {
//    Largest Product Of Length
//    Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.
//        
//        Assumptions
//        The words only contains characters of 'a' to 'z'
//        The dictionary is not null and does not contains null string, and has at least two strings
//        If there is no such pair of words, just return 0
//        Examples
//        dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
private:
    class comphelper {
    public:
        bool operator()(pair<pair<string, int>, pair<string, int>> p1, pair<pair<string, int>, pair<string, int>> p2) {
            return p1.first.first.size()+p1.second.first.size() > p2.first.first.size()+p2.second.first.size();
        }
    };
    struct sorthelper1 {
        bool operator()(string a, string b) {
            return (a.size()>b.size());
        }
    } mysorter; //sort支持这个struct
    
    void largestProductHelperIterative(vector<string>& dict, int m, int n, priority_queue<pair<pair<string, int>, pair<string, int>>, vector<pair<pair<string, int>, pair<string, int>>>>& mypq, int* result) {
        int leng=(int)dict.size();
        mypq.push(make_pair(make_pair(dict[m], m), make_pair(dict[n], n)));
        while (!mypq.empty()) {
            pair<pair<string, int>, pair<string, int>> current=mypq.top();
            mypq.pop();
            int mson=current.first.second;
            int nson=current.second.second;
            if(allUnique(current.first.first, current.second.first)) {
                *result = current.first.first.size()*current.second.first.size();
                return;
            }
            if (mson+1<nson && nson<leng) {
                mypq.push(make_pair(make_pair(dict[mson+1], mson+1), make_pair(dict[nson], nson)));
                
            }
            if (mson<nson && nson+1<leng) {
                mypq.push(make_pair(make_pair(dict[mson], mson), make_pair(dict[nson+1], nson+1)));
            }
        }
        return;
    }
    
    void largestProductHelperRecursive(vector<string>& dict, int m, int n, priority_queue<pair<pair<string, int>, pair<string, int>>, vector<pair<pair<string, int>, pair<string, int>>>>& mypq, int* result) {
        int leng=(int)dict.size();
        mypq.push(make_pair(make_pair(dict[m], m), make_pair(dict[n], n)));
        while (!mypq.empty()) {
            pair<pair<string, int>, pair<string, int>> current=mypq.top();
            mypq.pop();
            if(allUnique(current.first.first, current.second.first)) {
                *result = current.first.first.size()*current.second.first.size();
                return;
            }
            if (m+1<n && n<leng) {
                largestProductHelperRecursive(dict, m+1, n, mypq, result);
            }
            if (m<n && n+1<leng) {
                largestProductHelperRecursive(dict, m, n+1, mypq, result);
            }
        }
        return;
    }
    
    bool allUnique(string& a, string& b) {
        int checker[8]={0};
        bool unique=true;
        for (int i=0; i<a.size(); i++) {
            int aa=a[i]/32;
            int bb=a[i]%32;
            checker[aa]|=(1<<bb);
        }
        for (int j=0; j<b.size(); j++) {
            int aa=b[j]/32;
            int bb=b[j]%32;
            if ((checker[aa]>>bb) & 1){
                unique=false;
                break;
            }
        }
        return unique;
    }
    
public:
    int largestProduct(vector<string> dict) {
        sort(dict.begin(), dict.end(), mysorter);
        priority_queue<pair<pair<string, int>, pair<string, int>>, vector<pair<pair<string, int>, pair<string, int>>>> mypq;
        int result=0;
        largestProductHelperIterative(dict, 0, 1, mypq, &result);
        cout<<"Iterative Result:"<<result<<endl;
        result=0;
        largestProductHelperRecursive(dict, 0, 1, mypq, &result);
        cout<<"Recursive Result:"<<result<<endl;
        return result;
    }
};

class Solution192 {
//    Kth Smallest With Only 2, 3 As Factors
//    Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.
//    Assumptions
//    K >= 1
//    Examples
//    the smallest is 1
//    the 2nd smallest is 2
//    the 3rd smallest is 3
//    the 5th smallest is 2 * 3 = 6
//    the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
    //    2^0*3^0  2^0*3^0
    //    2^1*3^0  2^0*3^0
    //    2^1*3^0  2^0*3^1
    //    2^2*3^0  2^0*3^1
    //    2^2*3^0  2^1*3^1
    //    2^2*3^0  2^1*3^1
    //    2^3*3^0  2^1*3^1
public:
    int kth(int k) {
        if(k<=0) {
            return 0;
        }
        if(k==1){
            return 1;
        }
        vector<int> result(k, 0);
        int i2=0, i3=0;
        int next=1;
        result[0]=1;
        for(int i=1;i<k;++i) {
            next=min(result[i2]*2, result[i3]*3);
            result[i]=next;
            if(result[i]==result[i2]*2) {
                i2++;
            }
            if(result[i]==result[i3]*3) {
                i3++;
            }
        }
        return result[k-1];
    }
};


class Solution193 {
//    Kth Smallest With Only 3, 5, 7 As Factors
//    Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
//    
//    Assumptions
//    K >= 1
//    Examples
//    the smallest is 3 * 5 * 7 = 105
//    the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
//    the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
//    the 5th smallest is 3 ^ 3 * 5 * 7 = 945
public:
    long kth(int k) {
        priority_queue<long, vector<long>, greater<long>> mypq;
        mypq.push(3*5*7);
        unordered_map<long, int> visited;
        visited[3*5*7]=1;
        int index=k;
        while (index>1) {
            long curr=mypq.top();
            mypq.pop();
            if (visited[curr*3]==0) {
                mypq.push(curr*3);
                visited[curr*3]++;
            }
            if (visited[curr*5]==0) {
                mypq.push(curr*5);
                visited[curr*5]++;
            }
            if (visited[curr*7]==0) {
                mypq.push(curr*7);
                visited[curr*7]++;
            }
            index--;
        }
        return mypq.top();
    }
};

class Solution194 {
//    Kth Closest Point To <0,0,0>
//    Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.
//    
//    We are using euclidean distance here.
//    
//    Assumptions
//    The three given arrays are not null or empty
//    K >= 1 and K <= a.length * b.length * c.length
//    Return
//    a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
//    Examples
//    
//    A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
//    
//    The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
//    
//    The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
private:
    class comphelper {
    public:
        bool operator()(vector<int> a, vector<int> b) {
            return a[0]*a[0]+ a[1]*a[1] + a[1]*a[1]>b[0]*b[0] + b[1]*b[1] + b[1]*b[1];
        }
    };
public:
    vector<int> closest(vector<int> a, vector<int> b, vector<int> c, int k) {
        int aleng=(int)a.size(), bleng=(int)b.size(), cleng=(int)c.size();
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        sort(c.begin(), c.end());
        priority_queue<vector<int>, vector<vector<int>>, comphelper> mypq;
        
        for (int x=0; x<aleng && x<k; x++) {
            for (int y=0; y<bleng && y<k; y++) {
                for (int z=0; z<cleng && z<k; z++) {
                    mypq.push({ a[x],b[y], c[z] });
                }
            }
        }
        vector<int> current;
        //        while (!mypq.empty()) {
        //            current=mypq.top();
        //            mypq.pop();
        //            cout<<current.first*current.first+current.second.first*current.second.first+current.second.second*current.second.second<<endl;
        //        }
        while (!mypq.empty() && k>0) {
            current=mypq.top();
            mypq.pop(); k--;
        }
        return current;
    }
};

class Solution195 {
//    Place To Put The Chair I
//    Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.
//        
//        Assumptions
//        There is at least one equipment in the gym
//        The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//        It is guaranteed that each 'C' cell is reachable from all 'E' cells.
//        If there does not exist such place to put the chair, just return null (Java) empty vector (C++)
//        Examples
//        
//      { { 'E', 'O', 'C' },
//        {  'C', 'E',  'C' },
//        {  'C',  'C',  'C' } }
//        we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
private:
    vector<pair<int, int>> getNeis(pair<int, int> curr, vector<vector<char>>& gym) {
        vector<pair<int, int>> result;
        int x = curr.first, y = curr.second;
        int rows = (int)gym.size(), cols = (int)gym[0].size();
        if (x + 1<rows && gym[x + 1][y] != 'O') {
            result.push_back(make_pair(x + 1, y));
        }
        if (y + 1<cols && gym[x][y + 1] != 'O') {
            result.push_back(make_pair(x, y + 1));
        }
        if (x - 1 >= 0 && gym[x - 1][y] != 'O') {
            result.push_back(make_pair(x - 1, y));
        }
        if (y - 1 >= 0 && gym[x][y - 1] != 'O') {
            result.push_back(make_pair(x, y - 1));
        }
        return result;
    }
    bool addCost(vector<vector<int>>& cost, vector<vector<char>>& gym, int i, int j) {
        vector<vector<bool>> visited(gym.size(), vector<bool>(gym[0].size(), false));
        queue<pair<int, int>> myq;
        myq.push(make_pair(i, j));
        visited[i][j] = true;
        int fee = 1;
        while (!myq.empty()) {
            int size = (int)myq.size();
            for (int m = 0; m<size; m++) {
                pair<int, int> curr = myq.front();
                myq.pop();
                vector<pair<int, int>> neis = getNeis(curr, gym);
                for (int next = 0; next<neis.size(); next++) {
                    if (!visited[neis[next].first][neis[next].second]) {
                        visited[neis[next].first][neis[next].second] = true;
                        cost[neis[next].first][neis[next].second] += fee;
                        myq.push(neis[next]);
                    }
                }
            }
            fee++;
        }
        for (int m = 0; m<gym.size(); m++) {
            for (int n = 0; n<gym[0].size(); n++) {
                if (toupper(gym[m][n]) == 'E' && !visited[m][n]) {
                    return false;
                }
            }
        }
        return true;
    }
public:
    vector<int> solve(vector<vector<char>> gym) {
        vector<int> result;
        int m = (int)gym.size(), n = (int)gym[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (toupper(gym[i][j]) == 'E') {
                    if (!addCost(cost, gym, i, j)) {
                        return result;
                    }
                }
            }
        }
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if ('E' != toupper(gym[i][j]) && 'O' != toupper(gym[i][j])) {
                    if (result.size() == 0) {
                        result.push_back(i);
                        result.push_back(j);
                    }
                    else if (cost[i][j]<cost[result[0]][result[1]]) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }
};


class Solution196 {
//    Place To Put The Chair II
//    Given a gym with k pieces of equipment without any obstacles.  Let’s say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ' ' denotes a cell without equipment. The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.
//    
//    Assumptions
//    
//    There is at least one equipment in the gym
//    The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//    ​Examples
//      { { 'E', ' ', ' ' },
//        {  ' ', 'E',  ' ' },
//        {  ' ',  ' ', 'E' } }
//    we should put the chair at (1, 1), so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, which is minimal.
private:
    vector<pair<int, int>> getNeis(int x, int y, int rows, int cols) {
        vector<pair<int, int>> result;
        if(x-1>=0) {
            result.push_back(make_pair(x-1, y));
        }
        if(x+1<rows) {
            result.push_back(make_pair(x+1, y));
        }
        if(y-1>=0) {
            result.push_back(make_pair(x, y-1));
        }
        if(y+1<cols) {
            result.push_back(make_pair(x, y+1));
        }
        return result;
    }
    
    void getDist(int x, int y, vector<vector<int>>& dist, int rows, int cols) {
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        queue<pair<int, int>> myque;
        myque.push(make_pair(x, y));
        visited[x][y]=true;
        while(!myque.empty()) {
            int size=(int)myque.size();
            for(int i=0;i<size;++i) {
                pair<int, int> cur=myque.front();
                myque.pop();
                vector<pair<int, int>> neibs=getNeis(cur.first, cur.second, rows, cols);
                for(int m=0;m<neibs.size();++m) {
                    if(visited[neibs[m].first][neibs[m].second]==false) {
                        visited[neibs[m].first][neibs[m].second]=true;
                        dist[neibs[m].first][neibs[m].second]=dist[cur.first][cur.second]+1;
                        myque.push(neibs[m]);
                    }
                }
            }
        }
    }
public:
    vector<int> solve(vector<vector<char>> gym) {
        int rows=(int)gym.size();
        if(rows<=0) {
            return vector<int>();
        }
        int cols=(int)gym[0].size();
        if(cols<=0) {
            return vector<int>();
        }
        vector<pair<int, int>> equips;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(gym[i][j]=='E') {
                    equips.push_back(make_pair(i, j));
                }
            }
        }
        if(equips.size()<=0) {
            return vector<int>();
        }
        if(equips.size()==1) {
            return {equips[0].first, equips[1].second};
        }
        vector<int> result(2, 0);
        vector<vector<vector<int>>> dist(equips.size(), vector<vector<int>>(rows, vector<int>(cols, 0)));
        for(int i=0;i<equips.size();i++) {
            getDist(equips[i].first, equips[i].second, dist[i], rows, cols);
        }
        for(int m=1;m<equips.size();++m) {
            for(int i=0;i<rows;++i) {
                for(int j=0;j<cols;++j) {
                    dist[0][i][j]+=dist[m][i][j];
                }
            }
        }
        int minValue=dist[0][0][0];
        for(int i=0;i<rows;++i) {
            for(int j=0;j<cols;++j) {
                if(minValue>dist[0][i][j]) {
                    minValue=dist[0][i][j];
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
};

class Solution197 {
//    ReOrder Array
//    Given an array of elements, reorder it as follow:
//    { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
//    { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
//    
//    Try to do it in place.
//        
//        Assumptions
//        
//        The given array is not null
//        Examples
//        
//    { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
//    
//    { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
//    
//    { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
    

private:
    void reorderHelper(vector<int>& array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int leng = right - left + 1;
        int mid = left + leng / 2;
        int offset = leng / 4;
        int leftmid = left + offset;
        int rightmid = mid + offset;
        reverse(array.begin() + leftmid, array.begin() + mid);
        reverse(array.begin() + mid, array.begin() + rightmid);
        reverse(array.begin() + leftmid, array.begin() + rightmid);
        //reorderHelper(array, left, left+2*(leftmid-left)-1);
        //reorderHelper(array, left+2*(leftmid-left), right);
        reorderHelper(array, left, mid - 1);
        reorderHelper(array, mid, right);
        return;
    }
public:
    vector<int> reorder(vector<int> array) {
        //12345678   8/4=2
        //12 34 56 78
        //12 43 65 78
        //12 56 34 78
        //1526 3748
        reorderHelper(array, 0, (int)array.size() - 1);
        return array;
    }
};

class Solution198 {
    //    Largest Rectangle In Histogram
    //    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
    //
    //    Assumptions
    //
    //    The given array is not null or empty
    //    Examples
    
    /*
     { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
     2  3  4
     2*1  2*(1-0+1)  3*1 3*(3-2+1) 4*()
     */
public:
    int largest(vector<int> array) {
        int area=0;
        stack<int> stk;
        for (int i = 0; i < array.size(); i++)
        {
            if (stk.empty() || array[stk.top()] < array[i]) {
                stk.push(i);
            }
            else {
                int start = stk.top();
                stk.pop();
                int width = stk.empty() ? i : i - stk.top() - 1;
                area = max(area, array[start] * width);
                i--; //++, --所以就不变，但是栈顶在变
            }
        }
        while (!stk.empty())
        {
            int start = stk.top();
            stk.pop();
            int width = stk.empty() ? (int)array.size() : (int)array.size() - stk.top() - 1;
            area = max(area, array[start] * width);
        }
        return area;
    }
};

class Solution199 {
    //    Max Water Trapped I
    //    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.
    //
    //    Assumptions
    //
    //    The given array is not null
    //    Examples
    //
    //    { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
public:
    int maxTrapped(vector<int> array) {
        int i=0, j=(int)array.size()-1;
        int result=0;
        int left_max=0, right_max=0;
        if(j<=1) {
            return result;
        }
        //{1,3,2,4,1,3,2,4,3,2}
        while (i<=j) {
            left_max=max(left_max, array[i]);
            right_max=max(right_max, array[j]);
            if (left_max<=right_max) {
                result+=left_max-array[i];
                i++;
            }
            else {
                result+=right_max-array[j];
                j--;
            }
        }
        return result;
    }
};

class Solution200 {
    //    Max Water Trapped II
    //    Given a non-negative integer 2D array representing the heights of bars in a matrix. Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.
    //
    //        Assumptions
    //        The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values are non-negative integers in the matrix.
    //        Examples
    //    	{ { 2, 3, 4, 2 },
    //        { 3, 1, 2, 3 },
    //        { 4, 3, 5, 4 } }
    //    the amount of water can be trapped is 3,
    //
    //    at position (1, 1) there is 2 units of water trapped,
    //    at position (1, 2) there is 1 unit of water trapped.
private:
    class Element {
    public:
        int i, j;
        int height;
        Element(int i, int j, int height) {
            this->i=i;
            this->j=j;
            this->height=height;
        }
    };
    class comphelper {
    public:
        bool operator()(Element* a, Element* b) {
            return a->height>b->height;
        }
    };
    vector<Element*> getNeis(Element* ele, vector<vector<int>>& matrix, vector<vector<bool>>& visited) {
        int i=ele->i, j=ele->j;
        int m=(int)matrix.size(), n=(int)matrix[0].size();
        vector<Element*> result;
        if (i+1<m) {
            Element* nei=new Element(i+1, j, matrix[i+1][j]);
            result.push_back(nei);
        }
        if (j+1<n) {
            Element* nei=new Element(i, j+1, matrix[i][j+1]);
            result.push_back(nei);
        }
        if (i-1>=0) {
            Element* nei=new Element(i-1, j, matrix[i-1][j]);
            result.push_back(nei);
        }
        if (j-1>=0) {
            Element* nei=new Element(i, j-1, matrix[i][j-1]);
            result.push_back(nei);
        }
        return result;
    }
public:
    int maxTrapped(vector<vector<int>> matrix) {
        int m=(int)matrix.size(), n=(int)matrix[0].size();
        if (m<3 || n<3) {
            return 0;
        }
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        priority_queue<Element*, vector<Element*>, comphelper> min_heap;
        int result=0;
        Element* ele=NULL;
        for (int i=0; i<m; i++) {
            ele=new Element(i, 0, matrix[i][0]);
            min_heap.push(ele);
            visited[i][0]=true;
            ele=new Element(i, n-1, matrix[i][n-1]);
            min_heap.push(ele);
            visited[i][n-1]=true;
        }
        for (int j=0; j<n; j++) {
            ele=new Element(0, j, matrix[0][j]);
            min_heap.push(ele);
            visited[0][j]=true;
            ele=new Element(m-1, j, matrix[m-1][j]);
            min_heap.push(ele);
            visited[m-1][j]=true;
        }
        while (!min_heap.empty()) {
            ele=min_heap.top();
            min_heap.pop();
            vector<Element*> neis = getNeis(ele, matrix, visited);
            for (Element* nei:neis) {
                if (visited[nei->i][nei->j]) {
                    continue;
                }
                visited[nei->i][nei->j]=true;
                result+=max(ele->height-nei->height, 0);
                //LEVEL(Q)=MAX(HEIGHT(Q), MIN(LEVEL(Q), LEVEL(P)));
                nei->height=max(ele->height, nei->height);
                min_heap.push(nei);
            }
        }
        return result;
    }
};

class Solution201 {
//    Largest Container
//    Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line, the distance between any two adjacent boards is 1. Consider selecting two boards such that together with the horizontal line they form a container. Find the volume of the largest such container.
//    
//    Assumptions
//    The given array is not null and has size of at least 2
//    Examples
//    { 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.
public:
    int largest(vector<int> array) {
        int result=0;
        int leng=(int)array.size();
        if(leng<=0) {
            return result;
        }
        int left=0, right=leng-1;
        while(left<right) {
            int minheight=min(array[left], array[right]);
            result=max(result, minheight*(right-left));
            if (left<right && array[left]<=array[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return result;
    }
};


class Solution202 {
//    Kth Smallest In Two Sorted Arrays
//    Given two sorted arrays of integers, find the Kth smallest number.
//    
//    Assumptions
//    The two given arrays are not null and at least one of them is not empty
//    K >= 1, K <= total lengths of the two sorted arrays
//    Examples
//    A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
//    A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
public:
    int kth(vector<int> a, vector<int> b, int k) {
        return helper(a, 0, b, 0, k);
    }
private:
    int helper(vector<int>& a, int ai, vector<int>& b, int bi, int k) {
        if (ai>=a.size()) {
            return b[bi+k-1];
        }
        if (bi>=b.size()) {
            return a[ai+k-1];
        }
        if (k==1) {
            return min(a[ai], b[bi]);
        }
        int amid=ai+k/2-1;
        int bmid=bi+k/2-1;
        int aval=amid>=a.size()?INT_MAX:a[amid];
        int bval=bmid>=b.size()?INT_MAX:b[bmid];
        if (aval<=bval) {
            return helper(a, amid+1, b, bi, k-k/2);
        }
        else {
            return helper(a, ai, b, bmid+1, k-k/2);
        }
    }
};

class Solution203 {
//    Median Of Two Arrays
//    Given two arrays of integers, find the median value.
//    Assumptions
//    The two given array are not null and at least one of them is not empty
//    The two given array are not guaranteed to be sorted
//    Examples
//    A = {4, 1, 6}, B = {2, 3}, median is 3
//    A = {1, 4}, B = {3, 2}, median is 2.5
public:
    double median(vector<int> a, vector<int> b) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        int total=a.size()+b.size();
        if (total%2!=0) {
            return (double)findKth(a, 0, b, 0, total/2+1);
        }
        else {
            return (double)(findKth(a, 0, b, 0, total/2) + \
                            findKth(a, 0, b, 0, total/2+1))/2.0;
        }
    }
private:
    int findKth(vector<int> a, int ai, vector<int> b, int bi, int k) {
        if (ai>=a.size()) {
            return b[bi+k-1];
        }
        if (bi>=b.size()) {
            return a[ai+k-1];
        }
        if (k==1) {
            return min(a[ai], b[bi]);
        }
        int amid=ai+k/2-1;
        int bmid=ai+k/2-1;
        int aval=amid>=a.size()?INT_MAX:a[amid];
        int bval=amid>=b.size()?INT_MAX:b[bmid];
        if(aval<=bval) {
            return findKth(a, amid+1, b, bi, k-k/2);
        }
        else {
            return findKth(a, ai, b, bmid+1, k-k/2);
        }
    }
};

class Solution204 {
//    Maximum Values Of Size K Sliding Windows
//    Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.
//    Assumptions
//    The given array is not null and is not empty
//    
//    K >= 1, K <= A.length
//    Examples
    //    A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
//    1 2 3 2 4 2 1
//    1
//		2
//        3
//        2 3
//            4
//            2 4
//            1 2 4
//    and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
public:
    vector<int> maxWindows(vector<int> array, int k) {
        vector<int> max;
        deque<int> mydeq;
        for (int i=0; i<array.size(); i++) {
            while (!mydeq.empty() && array[mydeq.back()]<=array[i]) {
                mydeq.pop_back();
            }
            while (!mydeq.empty() && mydeq.front()<=i-k) {
                mydeq.pop_front();
            }
            mydeq.push_back(i);
            if (i>=k-1) {
                max.push_back(array[mydeq.front()]);
            }
        }
        return max;
    }
private:
    
};

class Solution205 {
//    Implement LRU Cache
//    Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java), false (C++).
public:
    class Node {
    public:
        Node* next;
        Node* prev;
        int key;
        int value;
        Node(int key, int value) {
            this->key=key;
            this->value=value;
        }
        void update(int key, int value) {
            this->key=key;
            this->value=value;
        }
    };
    
    Solution205(int leng) {
        this->leng=leng;
    }
    
    void set(int key, int value) {
        Node* node=NULL;
        if (dict.find(key)!=dict.end()) {
            node=dict[key];
            node->value=value;
            remove(node);
        }
        else if (dict.size()<leng) {
            node=new Node(key, value);
        }
        else {
            node=tail;
            remove(tail);
            node->update(key, value);
        }
        append(node);
    }
    
    int get(int key) {
        Node* node=dict[key];
        if(node==NULL) {
            return -1;
        }
        remove(node);
        append(node);
        return node->value;
    }
    
private:
    int leng;
    Node* head;
    Node* tail;
    unordered_map<int, Node*> dict;
    
    Node* remove(Node* node) {
        dict.erase(node->key);
        if (node->prev!=NULL) {
            node->prev->next=node->next;
        }
        if (node->next!=NULL) {
            node->next->prev=node->prev;
        }
        if (node==head) {
            head=head->next;
        }
        if (node==tail) {
            tail=tail->prev;
        }
        return node;
    }
    
    Node* append(Node* node) {
        dict[node->key]=node;
        if (head==NULL) {
            head=node;
            tail=node;
        }
        else {
            node->next=head;
            head->prev=node;
            head=node;
        }
        return node;
    }
};

class Solution206 {
//    Majority Number I
//    Given an integer array of length L, find the number that occurs more than 0.5 * L times.
//    
//    Assumptions
//    
//    The given array is not null or empty
//    It is guaranteed there exists such a majority number
//    Examples
//    
//    A = {1, 2, 1, 2, 1}, return 1
public:
    int majority(vector<int> array) {
        int result=array[0];
        int count=1;
        for(int i=1;i<array.size();i++) {
            if(count==0) {
                result=array[i];
                count++;
            }
            else if(array[i]==result) {
                count++;
            }
            else {
                count--;
            }
        }
        return result;
    }
private:
    
};

class Solution207 {
//    Majority Number II
//    Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
//        
//        Assumptions
//        
//        The given array is not null
//        Examples
//        
//        A = {1, 2, 1, 2, 1}, return [1, 2]
//    A = {1, 2, 1, 2, 3, 3, 1}, return [1]
//    A = {1, 2, 2, 3, 1, 3}, return []
public:
    vector<int> majority(vector<int> array) {
        int counta=0, countb=0;
        int leng=array.size();
        int a = 0, b = 0;
        for(auto ai:array) {
            if (counta==0) {
                a=ai; counta++;
            }
            else if (countb==0) {
                b=ai; countb++;
            }
            else if(ai==a) {
                counta++;
            }
            else if(ai==b) {
                countb++;
            }
            else {
                counta--;
                countb--;
            }
        }
        counta=0, countb=0;
        for(int i=0;i<leng;++i) {
            if(array[i]==a) {
                counta++;
            }
            else if(array[i]==b) {
                countb++;
            }
        }
        if(counta>leng/3 && countb>leng/3) {
            if(a>b) {
                return {b, a};
            }
            else {
                return {a, b};
            }
        }
        else if(counta>leng/3) {
            return {a};
        }
        else if(countb>leng/3) {
            return {b};
        }
        else {
            return {};
        }
    }
};

class Solution208 {
//    Majority Number III
//    Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.
//        
//        Assumptions
//        
//        The given array is not null or empty
//        K >= 2
//        Examples
//        
//    A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
//    A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
//    A = {2, 1}, K = 2, return []
public:
    vector<int> majority(vector<int> array, int k) {
        if (k<2) {
            return {};
        }
        vector<pair<int, int>> ks(k, make_pair(0,0));
        int leng=array.size();
        for (auto ai:array) {
            int comptime=0;
            for (int ki=0; ki<ks.size(); ++ki) {
                if (ks[ki].second == 0) {
                    ks[ki].first=ai;
                    ks[ki].second++;
                    break;
                }
                else if(ks[ki].first==ai) {
                    ks[ki].second++;
                    break;
                }
                else {
                    comptime++;
                }
            }
            //所有都比较了才可以抵消
            if(comptime==ks.size()) {
                for (auto k:ks) {
                    if(k.second>0) {
                        k.second--;
                    }
                }
            }
        }
        //准备重新走一遍
        for (int i=0; i<ks.size(); i++) {
            ks[i].second=0;
        }
        for (auto ai:array) {
            for (int i=0; i<ks.size(); i++) {
                if (ks[i].first==ai) {
                    ks[i].second++;
                }
            }
        }
        vector<int> result={};
        //发现大于size/k就捡起来
        for (int i=0; i<ks.size(); i++) {
            if (ks[i].second>leng/k) {
                result.push_back(ks[i].first);
            }
        }
        return result;
    }
};

class Solution210 {
//    Reconstruct Binary Search Tree With Preorder Traversal
//    Given the preorder traversal sequence of a binary search tree, reconstruct the original tree
private:
    TreeNode* reconstructHelper(vector<int>& pre, int left, int right) {
        if (left>right) {
            return NULL;
        }
        else if (left==right) {
            return new TreeNode(pre[left]);
        }
        TreeNode* root = new TreeNode(pre[left]);
        int i=left;
        for (i=left+1; i<=right; ++i) {
            if (pre[i]>pre[left]) {
                break;
            }
        }
        root->left = reconstructHelper(pre, left+1, i-1);
        root->right = reconstructHelper(pre, i, right);
        return root;
    }
public:
    TreeNode* reconstruct(vector<int> pre) {
        return reconstructHelper(pre, 0, pre.size()-1);
    }
    
};

class Solution211 {
//    Reconstruct Binary Search Tree With Postorder Traversal
//    Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
//    Assumptions
//    The given sequence is not null
//    There are no duplicate keys in the binary search tree
private:
    TreeNode* reconstructHelper(vector<int> post, int left, int right) {
        if (left>right) {
            return NULL;
        }
        TreeNode* root = new TreeNode(post[right]);
        int cursor = left;
        while (cursor<right && post[cursor]<post[right]) {
            cursor++;
        }
        cursor--;
        root->left = reconstructHelper(post, left, cursor);
        root->right = reconstructHelper(post, cursor + 1, right - 1);
        return root;
    }
public:
    TreeNode* reconstruct(vector<int> post) {
        int leng = (int)post.size();
        if (leng == 0) {
            return NULL;
        }
        else if (leng == 1) {
            TreeNode* root = new TreeNode(post[0]);
            return root;
        }
        else {
            TreeNode* root = reconstructHelper(post, 0, leng - 1);
            return root;
        }
    }
};

class Solution212 {
//    Reconstruct Binary Search Tree With Level Order Traversal
//    Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.
//    
//    Assumptions
//    
//    The given sequence is not null
//    There are no duplicate keys in the binary search tree
private:
    TreeNode* reconstructHelper(vector<int>& level, vector<int>& inorder, int left, int right, unordered_map<int, int>& dict) {
        if (left>right) {
            return NULL;
        }
        else if (left==right) {
            return new TreeNode(level[0]);
        }
        TreeNode* root = new TreeNode(level[0]);
        vector<int> leftlevel;
        vector<int> rightlevel;
        int pivot = dict[level[0]];
        for (int i=1; i<level.size(); ++i) {
            if (dict[level[i]]<pivot) {
                leftlevel.push_back(level[i]);
            }
            else if(dict[level[i]]>pivot) {
                rightlevel.push_back(level[i]);
            }
        }
        root->left = reconstructHelper(leftlevel, inorder, left, pivot-1, dict);
        root->right = reconstructHelper(rightlevel, inorder, pivot+1, right, dict);
        return root;
    }
public:
    TreeNode* reconstruct(vector<int> level) {
        vector<int> inorder = level;
        sort(inorder.begin(), inorder.end());
        unordered_map<int, int> dict;
        for (int i=0; i<inorder.size(); ++i) {
            dict[inorder[i]]=i;
        }
        return reconstructHelper(level, inorder, 0, inorder.size()-1, dict);
    }
};

class Solution213 {
//    Reconstruct Binary Tree With Preorder And Inorder
//    Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//    
//    Assumptions
//    
//    The given sequences are not null and they have the same length
//    There are no duplicate keys in the binary tree
private:
    TreeNode* reconstructHelper(vector<int>& in, int inleft, int inright, \
                                vector<int>& pre, int preleft, int preright) {
        if (inleft>inright || preleft>preright) {
            return NULL;
        }
        TreeNode* root = new TreeNode(pre[preleft]);
        int cursor = 0;
        while (inleft + cursor<inright && in[inleft + cursor] != root->value) {
            cursor++;
        }
        cursor--; //cursor==2
        root->left = reconstructHelper(in, inleft, inleft + cursor, pre, preleft + 1, preleft + cursor + 1);
        root->right = reconstructHelper(in, inleft + cursor + 2, inright, pre, preleft + cursor + 2, preright);
        return root;
    }
public:
    TreeNode* reconstruct(vector<int> in, vector<int> pre) {
        int lengin = (int)in.size();
        int lengpre = (int)pre.size();
        if (lengin != lengpre) {
            return NULL;
        }
        if (lengin == 0) {
            return NULL;
        }
        else if (lengin == 1) {
            TreeNode* root = new TreeNode(in[0]);
            return root;
        }
        else {
            TreeNode* root = reconstructHelper(in, 0, (int)in.size() - 1, pre, 0, (int)pre.size() - 1);
            return root;
        }
        return nullptr;
    }
};

class Solution214 {
//    Reconstruct Binary Tree With Postorder And Inorder
//    Given the postorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//    
//    Assumptions
//    
//    The given sequences are not null and they have the same length
//    There are no duplicate keys in the binary tree
private:
    TreeNode* helper(vector<int>& in, int inleft, int inright,
                     vector<int>& post, int postleft, int postright,
                     unordered_map<int, int>& dict) {
        if (inleft>inright) {
            return NULL;
        }
        else if (inleft==inright) {
            return new TreeNode(post[postright]);
        }
        TreeNode* root=new TreeNode(post[postright]);
        int leftSize=dict[post[postright]]-inleft;
        root->left=helper(in, inleft, leftSize+inleft-1, post, postleft, postleft+leftSize-1, dict);
        root->right=helper(in, leftSize+inleft+1, inright, post, postleft+leftSize, postright-1, dict);
        return root;
    }
    
public:
    TreeNode* reconstruct(vector<int> in, vector<int> post) {
        unordered_map<int, int> dict;
        int leng=in.size();
        for (int i=0; i<in.size();++i) {
            dict[in[i]]=i;
        }
        return helper(in, 0, leng-1, post, 0, leng-1, dict);
    }
};

class Solution215 {
//    Reconstruct Binary Tree With Levelorder And Inorder
//    Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//    
//    Assumptions
//    
//    The given sequences are not null and they have the same length
//    There are no duplicate keys in the binary tree

private:
    TreeNode* reconstructHelper(vector<int>& in, int inleft, int inright, vector<int>& level, unordered_map<int, int>& indict) {
        if (inleft>inright) {
            return NULL;
        }
        vector<int> levelleft;
        vector<int> levelright;
        TreeNode* root = new TreeNode(level[0]);
        for (int i = 0; i<level.size(); i++) {
            if (indict[level[i]]<indict[root->value]) {
                levelleft.push_back(level[i]);
            }
            else if (indict[level[i]]>indict[root->value]) {
                levelright.push_back(level[i]);
            }
        }
        root->left = reconstructHelper(in, inleft, indict[root->value] - 1, levelleft, indict);
        root->right = reconstructHelper(in, indict[root->value] + 1, inright, levelright, indict);
        return root;
    }
public:
    TreeNode* reconstruct(vector<int> in, vector<int> level) {
        int lengin = (int)in.size();
        int lenglevel = (int)level.size();
        if (lengin != lenglevel) {
            return NULL;
        }
        if (lengin == 0) {
            return NULL;
        }
        else if (lengin == 1) {
            TreeNode* root = new TreeNode(in[0]);
            return root;
        }
        else {
            unordered_map<int, int> mymap;
            for (int i = 0; i<in.size(); i++) {
                mymap[in[i]] = i;
            }
            TreeNode* root = reconstructHelper(in, 0, (int)in.size() - 1, level, mymap);
            return root;
        }
        return nullptr;
    }
};

class Solution216 {
//    Most Points On A Line
//    Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can be crossed by a single line in 2D space.
//    
//    Assumptions
//    
//    The given array is not null and it has at least 2 points
//    Examples
//    
//    <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
public:
    int most(vector<Point> points) {
        int result=0;
        for (int i=0; i<points.size(); i++) {
            Point seed = points[i];
            int same=1, sameX=0, most=0;
            unordered_map<double, int> dict;
            for (int j=0; j<points.size(); j++) {
                if (i==j) {
                    continue;
                }
                Point temp=points[j];
                if (temp.x==seed.x && temp.y==seed.y) {
                    same++;
                }
                else if (temp.x==seed.x) {
                    sameX++;
                }
                else {
                    double slope = (double)(temp.y-seed.y)/(temp.x-seed.x);
                    dict[slope]++;
                    most = max(sameX, dict[slope]);
                }
            }
            most = max(most, sameX)+same;
            result = max(most, result);
        }
        return result;
    }
private:
    
};

class Solution217 {
//    Largest Set Of Points With Positive Slope
//    Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.
//    
//    Assumptions
//    The given array is not null
//Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
//    Examples
//    <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
public:
    struct myoperator {
        bool operator()(Point p1, Point p2) {
            if(p1.y>p2.y || p1.x>p2.x) {
                return true;
            }
            else {
                return false;
            }
        }
    } myoperator;
    
    int largest(vector<Point> points) {
        sort(points.begin(), points.end(), myoperator);
        int result=0;
        vector<int> longest(points.size(), 0);
        for (int i=0; i<longest.size(); i++) {
            for (int j=0; j<i; j++) {
                if (points[j].x<points[i].x && points[j].y<points[i].y) {
                    longest[i]=max(longest[j], longest[i]);
                }
            }
            longest[i]++;
            result=max(result, longest[i]);
        }
        return result==1?0:result;
    }
private:
    
};

class Solution218 {
//    Generate Random Maze
//    Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.
//    
//    Assumptions
//    
//    N = 2K + 1 and K >= 0
//    the top left corner must be corridor
//    there should be as many corridor cells as possible
//    for each pair of cells on the corridor, there must exist one and only one path between them
//        Examples
//        
//        N = 5, one possible maze generated is
//        0  0  0  1  0
//        1  1  0  1  0
//        0  1  0  0  0
//        0  1  1  1  0
//        0  0  0  0  0
public:
    class Dir {
    public:
        int dx, dy;
        Dir(int dx, int dy) {
            this->dx=dx;
            this->dx=dy;
        }
        int moveX(int x, int times) {
            return x+times*dx;
        }
        int moveY(int y, int times) {
            return y+times*dy;
        }
    };
    
    Solution218() {
        Dir* north = new Dir(0, 1);
        Dir* south = new Dir(0, -1);
        Dir* east = new Dir(1, 0);
        Dir* west = new Dir(-1, 0);
        this->dirs.push_back(north);
        this->dirs.push_back(south);
        this->dirs.push_back(east);
        this->dirs.push_back(west);
    }
    
    vector<vector<int>> maze(int n) {
        vector<vector<int>> result;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) {
                    result[i][j]=0;
                }
                else {
                    result[i][j]=1;
                }
            }
        }
        generate(result, 0, 0);
        return result;
    }
private:
    vector<Dir*> dirs;
    void generate(vector<vector<int>>& result, int x, int y) {
        random_shuffle(dirs.begin(), dirs.end());
        for (Dir* dir:dirs) {
            int nextX=dir->moveX(x, 2);
            int nextY=dir->moveY(y, 2);
            if (isValidWall(result, nextX, nextY)) {
                result[dir->moveX(x, 1)][dir->moveY(y, 1)]=0;
                result[nextX][nextY]=0;
                generate(result, nextX, nextY);
            }
        }
    }
    
    bool isValidWall(vector<vector<int>>& result, int x, int y) {
        return x>=0 && x<result.size() && y>=0 && y<result[0].size() && result[x][y]==1;
    }
};

class Solution219 {
//    Disjoint White Objects
//    In a 2D black image there are some disjoint white objects with arbitrary shapes, find the number of disjoint white objects in an efficient way.
//    
//    By disjoint, it means there is no white pixels that can connect the two objects, there are four directions to move to a neighbor pixel (left, right, up, down).
//    
//    Black is represented by 1’s and white is represented by 0’s.
//    
//    Assumptions
//    
//    The given image is represented by a integer matrix and all the values in the matrix are 0 or 1
//    The given matrix is not null
//    Examples
//    
//    the given image is
//    
//    0  0  0  1
//    1  0  1  1
//    1  1  0  0
//    0  1  0  0
//    
//    there are 3 disjoint white objects.
private:
    void dfsHelper(vector<vector<int>>& matrix, int rows, int cols, int i, int j, vector<vector<bool>>& visited) {
        visited[i][j]=true;
        if (i+1<rows && matrix[i+1][j]==0 && visited[i+1][j]==false) {
            dfsHelper(matrix, rows, cols, i+1, j, visited);
        }
        if (j+1<cols && matrix[i][j+1]==0 && visited[i][j+1]==false) {
            dfsHelper(matrix, rows, cols, i, j+1, visited);
        }
        if (i-1>=0 && matrix[i-1][j]==0 && visited[i-1][j]==false) {
            dfsHelper(matrix, rows, cols, i-1, j, visited);
        }
        if (j-1>=0 && matrix[i][j-1]==0 && visited[i][j-1]==false) {
            dfsHelper(matrix, rows, cols, i, j-1, visited);
        }
    }
public:
    int whiteObjects(vector<vector<int>> matrix) {
        int rows=matrix.size();
        int cols=matrix[0].size();
        vector<vector<bool>> visited(rows, vector<bool>(cols, 0));
        int result=0;
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                if (matrix[i][j]==0 && visited[i][j]==false) {
                    dfsHelper(matrix, rows, cols, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }
};

class Solution220 {
//    Largest Sum Of Valid Numbers
//    Given a 2D array A[8][8] with all integer numbers if we take a number a[i][j], then we cannot take its 8 neighboring cells. How should we take the numbers to make their sum as large as possible.
//    Assumptions
//        
//  The given matrix is 8 * 8
//    4 3 2 1 9 6 5 2
//    5 8 7 6 7 4 3 1
//    8 7 6 5 4 3 2 1
//    5 6 7 8 9 4 3 8
//    8 7 6 5 3 4 8 9
//    2 3 4 5 6 5 2 8
//    6 5 8 9 5 4 2 3
//    5 8 7 1 4 3 5 8
public:
    int largestSum(vector<vector<int>> matrix) {
        return 0;
    }
private:
    
};

class Solution223 {
//    Add Two Numbers
//    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//    
//    Example
//    
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    
//Output: 7 -> 0 -> 8
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy=new ListNode(-1);
        ListNode* p=dummy;
        int sum=0;
        while(l1!=NULL || l2!=NULL) {
            if (l1!=NULL) {
                sum+=l1->value;
            }
            if (l2!=NULL) {
                sum+=l2->value;
            }
            if (l1!=NULL) {
                l1->value=(sum%10);
                p->next=l1;
                l1=l1->next;
                if(l2!=NULL) {
                    l2=l2->next;
                }
            }
            else {
                l2->value=(sum%10);
                p->next=l2;
                l2=l2->next;
            }
            sum=sum/10;
            p=p->next;
        }
        if(sum) {
            p->next=new ListNode(sum);
        }
        
        return dummy->next;
    }
private:
    
};

class Solution224 {
//    Reverse Integer
//    Reverse digits of an integer.
//    
//    Assumptions
//    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//    Examples
//Input:      23
//Output:   32
//    
//Input:     -14
//Output:  -41
public:
    int reverse(int x) {
        int result=0, newone;
        while(x!=0) {
            int now=x%10;
            int newone=result*10+now;
            if((newone-now)/10!=result)
                return 0;
            result=newone;
            x=x/10;
        }
        return result;
    }
private:
    
};

class Solution225 {
//    Implement atoi to convert a string to an integer.
//    
//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//    
//    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
public:
    int myAtoi(string str) {
        int result=0, sign=1, i=str.find_first_not_of(' '), base=INT_MAX/10;
        if (str[i]=='+') {
            sign=1;
            i++;
        }
        else if (str[i]=='-') {
            sign=-1;
            i++;
        }
        while (isdigit(str[i])) {
            if (result>base || (result==base || str[i]>'7')) {
                if (sign==1) {
                    return INT_MAX;
                }
                else
                    return INT_MIN;
            }
            result=result*10+str[i]-'0';
            i++;
        }
        return result;
    }
private:
    
};

class Solution226 {
//    Multiply Strings
//    Given two numbers represented as strings, return multiplication of the numbers as a string. The numbers can be arbitrarily large and are non-negative.
//    
//    Example
//    
//Input: "19", "20"
//    
//Output: "380"
public:
    string multiply(string num1, string num2) {
        string sum(num1.size()+num2.size(), 0);
        for (int i=num1.size(); i>=0; i--) {
            int carry=0;
            for (int j=num2.size(); j>=0; j--) {
                int temp = sum[i+j+1]+num1[i]-'0';
                carry = temp/10;
                sum[i+j+1]=temp-carry*10;
            }
            sum[i]=carry;
        }
        size_t startpos=sum.find_first_not_of('\0');
        if (string::npos!=startpos) {
            for (int i=startpos; i<sum.size(); i++) {
                sum[i]+='0';
            }
            return sum.substr(startpos);
        }
        return "0";
    }
private:
    
};

class Solution227 {
//    First Missing Positive II
//    Given an unsorted integer array, find the first missing positive integer.
//    
//    Example
//    Given [0, 2, 3, 1], return 4,
//    and [3, 4, -2, 1, -4] return 2.
public:
    int firstMissingPositive(vector<int> input) {
        int m=input.size();
        for (int i=0; i<m; ) {
            while (input[i]<=m && input[i]>=1 && input[i]!=i+1) {
                swap(input[i], input[input[i]-1]);
            }
            i++;
        }
        for (int i=0; i<m; i++) {
            if (input[i]!=i+1) {
                return i+1;
            }
        }
        return m+1;
    }
private:
    
};

class Solution231 {
//    Combination Sum II
//    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. Each number in C may only be used once in the combination.
//    
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order.
//    The solution set must not contain duplicate combinations.
//    
//    Example
//    given candidate set 10,1,2,7,6,1,5 and target 8,
//    A solution set is:
//    
//    [1, 7]
//    [1, 2, 5]
//    [2, 6]
//    [1, 1, 6]
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> result;
        vector<int> combo;
        helper(candidates, result, combo, 0, target);
        return result;
    }
private:
    void helper(vector<int>& candidates, vector<vector<int>>& result, vector<int> combo, int start, int remain) {
        if (remain==0) {
            result.push_back(combo);
            return;
        }
        for(int i=start; i!=candidates.size(); i++) {
            if (i==start || candidates[i]!=candidates[i+1]) {
                combo.push_back(candidates[i]);
                helper(candidates, result, combo, i+1, remain-candidates[i]);
                combo.pop_back();
            }
        }
    }
};

class Solution232 {
//    Combination Sum
//    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.
//    
//    All numbers (including target) will be positive integers.
//    
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order.
//    
//    The solution set must not contain duplicate combinations.
//    
//    Example
//    
//    given candidate set 2,3,6,7 and target 7,
//    
//    A solution set is:
//    
//    [7]
//    [2, 2, 3]
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> result;
        vector<int> combo;
        helper(candidates, result, combo, 0, target);
        return result;
    }
private:
    void helper(vector<int>& candidates, vector<vector<int>>& result, vector<int>& combo, int start, int remain) {
        if (remain==0) {
            result.push_back(combo);
            return;
        }
        for (int i=start; i!=candidates.size() && remain>=candidates[i]; i++) {
            combo.push_back(candidates[i]);
            helper(candidates, result, combo, i, remain-candidates[i]);
            combo.pop_back();
        }
    }
};

class Solution233 {
private:
    bool checkCombo(vector<int>& combo, int index, int col) {
        for (int i = 0; i<index; i++) {
            if (combo[i] == col) {
                return false;
            }
            if (abs(i - index) == abs(combo[i] - col)) {
                return false;
            }
        }
        return true;
    }
    void nQueensHelper(vector<vector<int>>& result, vector<int>& combo, int i, int total) {
        if (i == total) {
            result.push_back(combo);
        }
        for (int x = 0; x<total; x++) {
            if (checkCombo(combo, i, x)) {
                combo[i] = x;
                nQueensHelper(result, combo, i + 1, total);
            }
        }
    }
public:
    vector<vector<int>> solve(int n) {
        if (n <= 0) {
            return vector<vector<int>>();
        }
        vector<vector<int>> result;
        vector<int> combo(n, 0);
        nQueensHelper(result, combo, 0, n);
        return result;
    }
};

class Solution234 {
//    N-Queen II
//    Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
public:
    int totalNQueens(int n) {
        int count=0;
        vector<int> columns(n);
        helper(n, count, columns, 0);
        return count;
    }
private:
    void helper(int n, int& count, vector<int>& columns, int rows) {
        if (rows==n) {
            count++;
        }
        else {
            for (int col=0; col<n; col++) {
                if (valid(columns, rows, col)) {
                    columns[rows]=col;
                    helper(n, count, columns, rows+1);
                }
            }
        }
    }
    
    bool valid(vector<int>& columns, int rows, int col) {
        for (int p=0; p<rows; p++) {
            int queen=columns[p];
            if (col==queen || abs(rows-p)==abs(col-queen)) {
                return false;
            }
        }
        return true;
    }
};


class Solution235 {
//    Count and Say
//    Given a sequence of number: 1, 11, 21, 1211, 111221, …
//    
//    The rule of generating the number in the sequence is as follow:
//    
//    1 is "one 1" so 11.
//    11 is "two 1s" so 21.
//    21 is "one 2 followed by one 1" so 1211.
//    
//    Find the nth number in this sequence.
//Assumptions:
//    
//    n starts from 1, the first number is "1", the second number is "11"
public:
    string countAndSay(int n) {
        if (n<=0) {
            return "";
        }
        else if (n==1) {
            return "1";
        }
        else if (n==2) {
            return "11";
        }
        string prev=countAndSay(n-1);
        string curr="";
        for (int i=0; i<prev.size(); ) {
            char now = prev[i];
            int repeat=0;
            for (repeat=0; repeat+i<prev.size(); ++repeat) {
                if (prev[repeat+i]!=now) {
                    break;
                }
            }
            curr+=to_string(repeat)+to_string(now-'0');
            i+=repeat;
        }
        return curr;
    }
};

class Solution236 {
//    Search Insert Position
//    Given a sorted array and a target value, return the index where it would be if it were inserted in order.
//        Assumptions
//        If there are multiple elements with value same as target, we should insert the target before the first existing element.
//        
//        Examples
//        [1,3,5,6], 5 → 2
//        [1,3,5,6], 2 → 1
//        [1,3,5,6], 7 → 4
//        [1,3,3,3,5,6], 3 → 1
//        [1,3,5,6], 0 → 0
public:
    int searchInsert(vector<int>& nums, int target) {
        int low=0, high=nums.size()-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (nums[mid]<target) {
                low=mid+1;
            }
            else if(nums[mid]>target) {
                high=mid-1;
            }
            else {
                return mid;
            }
        }
        return low;
    }
private:
    
};

class Solution237 {
//    Longest Valid Parentheses
//    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//    
//    Example
//    
//    ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public:
    int longestValidParentheses(string s) {
        return 0;
    }
private:
    
};

class Solution238 {
//    Next Permutation
//    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//    The replacement must be in-place, do not allocate extra memory.
//        
//        Example
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public:
    vector<int> nextPermutation(vector<int> num) {
        return num;
    }
private:
    
};

class Solution240 {
//    Remove Element
//    Given an array and a value, remove all instances of that value in place and return the new length. The order of elements can not be changed.
//    
//    Examples
//Input:     [1,2,3,1]
//value:      1
//Output:   [2,3]
public:
    vector<int> removeElement(vector<int> input, int value) {
        return input;
    }
private:
    
};

class Solution241 {
//    Reverse Nodes in k-Group
//    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.
//    
//    Example
//    
//    Given this linked list: 1->2->3->4->5
//    
//    For k = 2, you should return: 2->1->4->3->5
//    
//    For k = 3, you should return: 3->2->1->4->5
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        return head;
    }
private:
    
};


class Solution242 {
//    Valid Parentheses
//    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order.
//        
//        Examples
//        
//        "()" and "()[]{}", "[{()}()]" are all valid but "(]" and "([)]" are not.
public:
    bool isValid(string s) {
        return false;
    }
private:
    
};

class Solution243 {
//    Remove Nth Node From End of List
//    Given a linked list, remove the nth node from the end of list and return its head.
//    
//    Assumptions
//    If n is not valid, you do not need to do anything to the original list.
//        Try to do this in one pass.
//            
//            Examples
//            
//            Given linked list: 1->2->3->4->5, and n = 2.
//            
//            After removing the second node from the end, the linked list becomes 1->2->3->5.
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        return head;
    }
private:
    
};

class Solution244 {
//    3Sum Closest
//    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//    
//    Example
//    
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//    
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public:
    int threeSumClosest(vector<int> num, int target) {
        return 0;
    }
private:
    
};

class Solution245 {
//    Longest Common Prefix
//    Write a function to find the longest common prefix string amongst an array of strings.
public:
    string longestCommonPrefix(vector<string> strs) {
        return "";
    }
private:
    
};

class Solution246 {
//    Roman to Integer
//    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
public:
    int romanToInt(string s) {
        return 0;
    }
private:
    
};

class Solution247 {
//    Integer to Roman
//    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
public:
    string intToRoman(int num) {
        return "";
    }
private:
    
};

class Solution248 {
//    Container With Most Water
//    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water. Note: You may not slant the container.
public:
    int maxArea(vector<int> height) {
        return 0;
    }
private:
    
};

class Solution249 {
//  Regular Expression Matching
//    Implement regular expression matching with support for '.' and '*'. '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).
//
//  Example
//  isMatch("aa","a") → false
//  isMatch("aa","aa") → true
//  isMatch("aaa","aa") → false
//  isMatch("aa", "a*") → true
//  isMatch("aa", ".*") → true
//  isMatch("ab", ".*") → true
//  isMatch("aab", "c*a*b") → true
public:
    bool isMatch(string input, string pattern) {
        if (input.empty() && pattern.empty()) {
            return true;
        }
        if (input.empty() || pattern.empty()) {
            return false;
        }
        int sleng=input.size(), pleng=pattern.size();
        vector<vector<bool>> dp(sleng+1, vector<bool>(pleng+1, false));
        for (int i=0; i<=sleng; i++) {
            for (int j=0; j<=pleng; j++) {
                if (i==0 && j==0) {
                    dp[i][j]=true;
                }
                else if (j==0) {
                    dp[i][j]=false;
                }
                else if (i==0) {
                    if (j>1 && pattern[j-1]=='*' && dp[0][j-2]) {
                        dp[i][j]=true;
                    }
                    else {
                        dp[i][j]=false;
                    }
                }
                else if (pattern[j-1]==input[i-1] || pattern[j-1]=='.') {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if (pattern[j-1]=='*') {
                    dp[i][j]=dp[i][j-2];
                    if (pattern[j-2]==input[i-1] || pattern[j-2]=='.') {
                        dp[i][j]=true;
                    }
                    dp[i][j]=dp[i][j]&&dp[i-1][j];
                }
            }
        }
        return dp[sleng][pleng];
    }
    
    void test() {
        cout<<isMatch("aa","a")<<endl;
        cout<<isMatch("aa","aa")<<endl;
        cout<<isMatch("aaa","aa")<<endl;
        cout<<isMatch("aa", "a*")<<endl;
        cout<<isMatch("aa", ".*")<<endl;
        cout<<isMatch("ab", ".*")<<endl;
        cout<<isMatch("aab", "c*a*b")<<endl;
    }
private:
};

class Solution250 {
//    Palindrome Number
//    Determine whether an integer is a palindrome.
//    
//    Assumptions
//    
//    Could negative integers be palindromes? (ie, -1) No.
//    
//    If you are thinking of converting the integer to string, note the restriction of using extra space.You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case? There is a more generic way of solving this problem.
public:
    bool isPalindrome(int x) {
        return false;
    }
private:
    
};

class Solution251 {
//    ZigZag Conversion
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility).
//    
//    And then read line by line: "PAHNAPLSIIGYIR". Write the code that will take a string and make this conversion given a number of rows. convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
public:
    string convert(string s, int nRows) {
        return "";
    }
private:
    
};

class Solution252 {
//    Longest Palindromic Substring
//    Given a string S, find the longest palindromic substring in S.
//    
//    Assumptions
//    There exists one unique longest palindromic substring.
//    The input S is not null.
//    Examples
//Input:     "abbc"
//Output:  "bb"
//    
//Input:     "abcbcbd"
//Output:  "bcbcb"
public:
    string longestPalindrome(string s) {
    int leng=s.size();
    int dist=0;
    string result="";
    if(leng==0) {
        return s;
    }
    vector<vector<bool>> isP(leng+1, vector<bool>(leng+1, 0));
    vector<int> minCuts(leng+1, 0);
    for(int end=1;end<=leng;end++) {
        minCuts[end]=end;
        for(int start=end;start>=1;start--) {
            if(s[start-1]==s[end-1]) {
                isP[start][end]=end-start<2||isP[start+1][end-1];
            }
            if(isP[start][end] && end-start>=dist) {
                result=s.substr(start-1, end-start);
                dist=end-start;
            }
        }
    }
    return result;
}
private:
    
};

class Solution253 {
//    Longest Substring Without Repeating Characters
//    Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
//    
//    For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
public:
    int longest(string input) {
        //efhrgsayekasdanfev
        int leng = (int)input.size();
        if (leng <= 1) {
            return leng;
        }
        int result = 0;
        unordered_map<char, int> hashset;
        for (int slow = 0, fast = 0; fast<leng; fast++) {
            hashset[input[fast]]++;
            if (hashset[input[fast]]>1) {
                while (hashset[input[fast]]>1) {
                    hashset[input[slow]]--;
                    slow++;
                }
            }
            else {
                result = max(result, fast - slow + 1);
            }
        }
        return result;
    }
};

class Solution254 {
//    Binary Tree Level Order Traversal II
//    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//    
//Example:
//    Given the below binary tree
//            5
//        /        \
//        3          8
//    /    \           \
//    
//    1       4         11
//    return its bottom-up level order traversal as:
//    
//    [
//     [1, 4, 11],
//     [3, 8],
//     [5]
//     ]
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        return {};
    }
private:
    
};

class Solution255 {
//    Sorted Array To Binary Search Tree
//    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//    
//Example:
//    Given ascending order array: [1, 3, 4, 5, 8, 11]
//    
//    return Binary Search Tree is
//    
//    4
//    
//    /        \
//    
//    1          8
//    
//    \      /     \
//    
//    3     5    11
public:
    TreeNode* sortedArrayToBST(vector<int> num) {
        return nullptr;
    }
private:
    
};

class Solution256 {
//    Sorted List to Binary Search Tree
//    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//    
//Example:
//    Given ascending order list: 1→3→4→5→8→11
//    
//    return Binary Search Tree is
//    
//    4
//    
//    /        \
//    
//    1          8
//    
//    \      /     \
//    
//    3    5     11
public:
    TreeNode* sortedListToBST(ListNode* head) {
        return nullptr;
    }
private:
    
};

class Solution257 {
//    Minimum Depth of Binary Tree
//    Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//    
//Example:
//    Given the below binary tree
//    5
//    /       \
//    3         8
//    \
//    4
//    minimum depth is 2,path is 5→8.
public:
    int minDepth(TreeNode* root) {
        return 0;
    }
private:
    
};

class Solution258 {
//    Move 0s To The End I
//    Given an array of integers, move all the 0s to the right end of the array.
//    
//    The relative order of the elements in the original array does not need to be maintained.
//    
//Assumptions:
//    
//    The given array is not null.
//Examples:
//    
//    {1} --> {1}
//    {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
public:
    vector<int> moveZero(vector<int> array) {
        int leng = (int)array.size();
        if (leng <= 0) {
            return array;
        }
        int front = 0, end = leng - 1;
        while (front <= end) {
            if (array[front] != 0) {
                front++;
            }
            else if (array[end] == 0) {
                end--;
            }
            else {
                swap(array[front], array[end]);
            }
        }
        return array;
    }
};

class Solution259 {
//    Move 0s To The End II
//    Given an array of integers, move all the 0s to the right end of the array.
//    
//    The relative order of the elements in the original array need to be maintained.
//    
//Assumptions:
//    
//    The given array is not null.
//Examples:
//    
//    {1} --> {1}
//    {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
public:
    vector<int> moveZero(vector<int> array) {
        // 0 3 1 0 1
        //   s
        //     f
        int leng = (int)array.size();
        if (leng <= 1) {
            return array;
        }
        int slow = 0, fast = 0;
        for (fast = 0; fast<leng; fast++) {
            if (array[fast] != 0) {
                array[slow] = array[fast];
                slow++;
            }
        }
        for (fast = slow; fast<leng; fast++) {
            array[fast] = 0;
        }
        return array;
    }
};


class Solution260 {
//    Interleave Positive And Negative Elements
//    Given an array with both positive and negative numbers in random order. Shuffle the array so that positive and negative numbers are put in position with even and odd indices, respectively.
//    
//    If there are more positive/negative numbers, put them at the end of the array. The ordering of positive/negative numbers does not matter.
//    
//Assumptions:
//    
//    The given array is not null.
//    There is no 0 in the array.
//Examples:
//    
//    {1, 2, 3, 4, 5, -1, -1, -1} --> {1, -1, 2, -1, 3, -1, 4, 5}  (The ordering of positive/negative numbers do not matter)
public:
    vector<int> interleave(vector<int> array) {
//        1 -1 2 -2 3 -3 5 -4 4 -5 6
//   posi                             |
//   negi                        |
		if(array.empty() || array.size()<=2) {
			return array;
		}
		int leng=array.size();
		int positive=0;
		int slow=0;
		//sort, left pos, right neg
		//{1, 2, 3, 4, 5, -1, -1, -1}
		for(int fast=0; fast<leng; fast++) {
			if(array[fast]>0) {
				positive++;
				swap(array[slow++], array[fast]);
			}
		}
		int negIndex=0;
		int posIndex=1;
		if(positive>leng/2) {
			posIndex=0;
			negIndex=1;
			int left=0;
			int right=leng-1;
			//if pos more than neg, put pos to tailer
			//{-1, -1, -1, 1, 2, 3, 4, 5}
			while(right>=positive) {
				swap(array[left++], array[right--]);
			}
		}
		//now swap pos and neg
		//{-1, -1, -1, 1, 2, 3, 4, 5}
		/*  p
		 *             n 
		 *  1  -1  -1 -1  2  3  4  5   
		 *          p
		 *                   n 
		 *  1  -1   3 -1  2 -1  4  5   
		 *                           p
		 *                         n
		 *        
		 */
		while(true) {
			while(posIndex<leng && array[posIndex]>0) {
				posIndex+=2;
			}
			while(negIndex<leng && array[negIndex]<0) {
				negIndex+=2;
			}
			if(posIndex>=leng || negIndex>=leng) {
				break;
			}
			swap(array[posIndex], array[negIndex]);
		}
		return array;
    }
private:
    
};

class Solution261 {
//    Sort In Specified Order
//    Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as those are in A2.
//    
//    For the elements that are not in A2, append them in the right end of the A1 in an ascending order.
//    
//Assumptions:
//    
//    A1 and A2 are both not null.
//    There are no duplicate elements in A2.
//Examples:
//    
//    A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
private:
    struct data {
        int value;
        int index;
    };
    
    static bool compare_by_a2(const data& a, const data& b) {
        if (a.index >= 0 && b.index >= 0) {
            return a.index<b.index;
        }
        else if (a.index >= 0 && b.index<0) {
            return true;
        }
        else if (a.index<0 && b.index >= 0) {
            return false;
        }
        else {
            //            a.index==-1 && b.index==-1
            return a.value<b.value;
        }
    }
public:
    vector<int> sortSpecial(vector<int> A1, vector<int> A2) {
        vector<data> result;
        unordered_map<int, int> indexer;
        for (int i = 0; i<A1.size(); i++) {
            indexer[A1[i]] = -1;
        }
        for (int i = 0; i<A2.size(); i++) {
            indexer[A2[i]] = i;
        }
        data temp;
        for (auto i : A1) {
            int idx = indexer[i];
            temp.index = idx;
            temp.value = i;
            result.push_back(temp);
        }
        std::sort(result.begin(), result.end(), compare_by_a2);
        vector<int> output;
        for (auto i : result) {
            output.push_back(i.value);
        }
        return output;
    }
};

class Solution262 {
//    Sort In Pair
//    Given an array A with integers, sort the array such that  A[0] < A[1]  > A[2] < A[3] >  A[4] < A[5] > … A[N-1].
//    
//Assumptions:
//    
//    A is guaranteed to be not null.
//    There are no duplicate elements in A.
//Examples:
//    
//    {1, 4, 2, 3, 5, 6} --> {1, 4, 2, 5, 3, 6}
//    {1, 2, 3, 4, 5} --> {1, 3, 2, 5, 4}
//           m
public:
    void sortInPair(vector<int> & array) {
        // Traverse all even elements
        if(array.empty() || array.size()==1) {
            return;
        }
        int n=array.size();
        for (int i = 0; i < n; i+=2)
        {
            // If current even element is smaller than previous
            if (i>0 && array[i-1] < array[i] )
                swap(array[i], array[i-1]);
            
            // If current even element is smaller than next
            if (i<n-1 && array[i] > array[i+1] )
                swap(array[i], array[i + 1]);
        }
    }
    
    void test() {
        vector<int> array = {12, 3, 5, 7, 4, 19, 26};
        sortInPair(array);
        cout<<kthSmallest(array, 0, array.size()-1, array.size()/2)<<endl;
        array = {1, 5, 3, 2, 4};
        cout<<kthSmallest(array, 0, array.size()-1, array.size()/2)<<endl;
        array = {5,4,3,2,1};
        cout<<kthSmallest(array, 0, array.size()-1, array.size()/2)<<endl;
    }
private:
    int findMedian(vector<int>& array, int left, int leng) {
        sort(array.begin()+left,  array.begin()+left+leng-1);
        return array[left+leng/2];
    }
    // Returns k'th smallest element in arr[l..r] in worst case linear time.
    int kthSmallest(vector<int>& array, int l, int r, int k) {
        if (k>0 && k<=r-l+1) {
            int n=r-l+1;
            // Divide array in groups of size 5, calculate median
            // of every group and store it in median array.
            int i;
            vector<int> median((n+4)/5, -1);
            for (i=0; i<n/5; i++) {
                median[i]=findMedian(array, l+i*5, 5);
            }
            if (i*5<n) {
                //For last group with less than 5 elements
                median[i]=findMedian(array, l+i*5, n%5);
                i++;
            }
            // Find median of all medians using recursive call.
            // If median has only one element, then no need
            // of recursive call
            int medOfMed=(i==1)?median[i-1]:kthSmallest(median, 0, i-1, i/2);
            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int pos = partition(array, l, r, medOfMed);
            
            if (pos-l == k-1) {
                // If position is same as k
                return array[pos];
            }
            else if (pos-l > k-1) {
                // If position is more, recur for left
                return kthSmallest(array, l, pos-1, k);
            }
            else {
                // Else recur for right subarray
                return kthSmallest(array, pos+1, r, k-pos+l-1);
            }
        }
        
        return INT_MAX;
    }
    
    int partition(vector<int>& array, int l, int r, int x) {
        int i;
        for (i=1; i<r; i++) {
            if (array[i]==x) {
                break;
            }
        }
        swap(array[i], array[r]);
        i=l;
        for (int j=l; j<=r-1; j++) {
            if (array[j]<=x) {
                swap(array[i], array[j]);
                i++;
            }
        }
        swap(array[i], array[r]);
        return i;
    }
};

class Solution263 {
//    Two Subsets With Min Difference
//    Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
//    
//    Return the minimum difference(absolute value).
//    
//Assumptions:
//    
//    The given integer array is not null and it has length of >= 2.
//Examples:
//    
//    {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
public:
    int minDifference(vector<int> array) {
        int sum=0;
        int n=array.size();
        for (int i=0; i<n; i++) {
            sum+=array[i];
        }
        // Compute result using recursive function
        return findMinRec(array, n, 0, sum);
    }
    
    void test() {
        cout<<minDifference({3, 1, 4, 2, 2, 1})<<endl;
    }
private:
    int findMinRec(vector<int>& array, int i, int curr, int sum) {
        // If we have reached last element.  Sum of one
        // subset is curr, sum of other subset is
        // sum-curr.  Return absolute difference
        // of two sums.
        if (i==0) {
            return abs(sum-curr - curr);
        }
        // For every item array[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return min(findMinRec(array, i-1, curr+array[i-1], sum),
                   findMinRec(array, i-1, curr, sum));
    }
};

class Solution264 {
//    Keep Distance For Identical Elements
//    Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:
//    
//    Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).
//    
//    If there does not exist such sequence, return null.
//    
//Assumptions:
//    
//    k is guaranteed to be > 0
//Examples:
//    
//    k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
public:
    vector<int> keepDistance(int k) {
        
        return {};
    }
private:
    
};

class Solution265 {
//    Subarray Sum To Target
//    Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums to a target number.
//    
//Assumptions:
//    
//    The given array is not null and its length is > 0.
//Examples:
//    
//    array = {1, 5, 2, 3}, target = 10, return true since the sum of subarray {5, 2, 3} is 10.
//    array = {1, 5, 2,e 3}, target = 4, return false.
public:
    bool sumToTarget(vector<int> array, int target) {
        return false;
    }
private:
    
};

class Solution266 {
//    Merge Intervals
//    Given a set of time intervals in any order, return the total length of the area covered by those intervals.
//    
//Assumptions:
//    
//    The given array of intervals is not null.
//    None of the intervals in the array is null.
//Examples:
//    
//    {<1,3>, <2,4>, <5,7>, <6,8> }. The total length returned is 6(<1,4> is covered and <5,8> is covered).
public:
    struct Interval {
        int start;
        int end;
        Interval() : start(0), end(0) {}
        Interval(int s, int e) : start(s), end(e) {}
    };
    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.empty()) {
            return vector<Interval>{};
        }
        vector<Interval> result;
        int leng=intervals.size();
        if (leng==1) {
            return intervals;
        }
        vector<int> starts={};
        vector<int> ends={};
        for (int i=0; i<leng; i++) {
            starts.push_back(intervals[i].start);
            ends.push_back(intervals[i].end);
        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        int starti=0, endi=0;
        while (endi<leng) {
            while (endi+1<leng && starts[endi+1]<=ends[endi]) {
                endi+=1;
            }
            while (ends[endi]==ends[endi+1]) {
                endi+=1;
            }
            result.push_back(Interval(starts[starti], ends[endi]));
            endi+=1;
            starti=endi;
        }
        return result;
    }
private:
    
};


class Solution267 {
//    Search In Sorted Matrix I
//    Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.
//    
//    Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
//    
//Assumptions:
//    
//    The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
//Examples:
//    
//    matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
//    target = 7, return {1, 2}
//    target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
public:
    vector<int> search(vector<vector<int>> matrix, int target) {
        int row = (int)matrix.size(), col = (int)matrix[0].size();
        if (row == 0 || col == 0) {
            return { -1, -1 };
        }
        int left = 0, right = row - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return { mid, 0 };
            }
            else if (matrix[mid][0]>target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (right<0) {
            return { -1, -1 };
        }
        int begin = 0, end = col - 1;
        mid = 0;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (matrix[right][mid] == target) {
                return { right, mid };
            }
            else if (matrix[right][mid]>target) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }
        return { -1, -1 };
    }
};

class Solution268 {
//    Search In Sorted Matrix II
//    Given a 2D matrix that contains integers only, which each row is sorted in ascending order and each column is also sorted in ascending order.
//    
//    Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
//    
//Assumptions:
//    
//    The given matrix is not null.
//Examples:
//    
//    matrix = { {1, 2, 3}, {2, 4, 5}, {6, 8, 10} }
//    target = 5, return {1, 2}
//    target = 7, return {-1, -1}
public:
    vector<int> search(vector<vector<int>> matrix, int target) {
        
        return {-1, -1};
    }
private:
    
};

class Solution269 {
//    Total Area Of Skyline
//    Given n houses on the ground with each house represented by a rectangle. The i-th rectangle is represented as [start_i, end_i, height_i], where  0 <= i < n. The rectangles may overlap with each other.  How can we calculate the total area that these rectangles cover.
//Assumptions:
//    The given array of buildings is not null, the buildings are not null.
//Examples:
//    buildings = {<1,3,1>, <2,4,2>},  output = 5.
public:
    class Building {
    public:
        int start;
        int end;
        int height;
        Building(int start, int end, int height) {
            this->start = start;
            this->end = end;
            this->height = height;
        }
    };
    int totalArea(vector<Building> buildings) {
        return 0;
    }
private:
    
};

class Solution270 {
//    Max Sum Of Two Indices
//    Given an array with integers, find two indices i and j  (j>=i),  such that the value of A[i]+A[j]+ (j - i) is maximized.
//    Return (i, j).
//Assumptions:
//    The given array is not null and it has length of > 0.
//Examples
//    array = {1, 5, 3}, the max sum is array[1] + array[1] + (1 - 1) = 10, return {1, 1}
public:
    vector<int> maxSum(vector<int> array) {
        return {0, 0};
    }
private:
    
};
class Solution271 {
//    Smallest Non-Existed Subsequence Sum
//    Given a sorted array of positive numbers in ascending order, find the smallest positive integer value that cannot be represented as sum of elements of any sub-sequence of the input array.
//Assumptions:
//    The given array is not null.
//Examples:
//    array = {1, 3, 6, 10, 11, 15}, result is 2
//    array = {1, 1, 1, 1}, result is 5
public:
    int firstMissing(vector<int> array) {
        return 0;
    }
private:
    
};

class Solution272 {
//    Combinations For Telephone Pad I
//    Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.
//    {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
//Assumptions:
//    The given number >= 0
//Examples:
//    if input number is 231, possible words which can be formed are:
//        [ad, ae, af, bd, be, bf, cd, ce, cf]
public:
    vector<string> combinations(int number) {
        if (number<=0) {
            return vector<string>();
        }
        string digits=to_string(number);
        vector<string> dict={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> result;
        queue<string> que;
        que.push("");
        for (int i=0; i<digits.size(); i++) {
            int x=digits[i]-'0';
            int leng=que.size();
            while (!que.empty() && leng>0 && que.front().size()==i ) {
                string t=que.front(); que.pop();
                if (dict[x].size()==0) {
                    que.push(t);
                }
                else {
                    for (char s:dict[x]) {
                        que.push(t+s);
                    }
                }
                leng--;
            }
        }
        while (!que.empty()) {
            result.push_back(que.front());
            que.pop();
        }
        return result;
    }
    
    vector<string> combinations1(int number) {
        if (number<=0) {
            return vector<string>();
        }
        string digits=to_string(number);
        vector<string> dict={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> result;
        dfsHelper("", digits, 0, dict, result);
        return result;
    }
    
    void dfsHelper(string prefix, string digits, int start, vector<string>& dict, vector<string>& result) {
        if (start>=digits.size()) {
            result.push_back(prefix);
            return;
        }
        int curr=digits[start]-'0';
        if (dict[curr].size()==0) {
            dfsHelper(prefix+"", digits, start+1, dict, result);
        }
        else {
            for (int i=0; i<dict[curr].size(); i++) {
                dfsHelper(prefix+dict[curr][i], digits, start+1, dict, result);
            }
        }
    }
    
    void test() {
        vector<string> result;
        result=combinations(231);
        for (auto i : result) {
            cout<<i<<" ";
        }
        result=combinations1(231);
        for (auto i : result) {
            cout<<i<<" ";
        }
    }
private:
};

class Solution273 {
//    Number Of Valid Triangles
//    Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as three sides of triangles.
//    
//Assumptions:
//    The given array is not null and has length of at least 3.
//Exmaples:
//    array = {4, 6, 3, 7}, the output should be 3. There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is impossible.
//    Preferred time complexity O(n ^ 2).
public:
    int numOfTriangles(vector<int> array) {
        // Write your solution here.
        return 0;
    }
private:
    
};

class Solution274 {
//    All Factors Of A Number
//    Get all possible combinations of factors that can multiply to a target number.
//    
//Assumptions:
//    The given number is guaranteed to be >= 2.
//Examples:
//    12 -->  [ [2, 2, 3], [2, 6], [3, 4], [12] ]
//    5 --> [ [5] ]
public:
    vector<vector<int>> factors(int n) {
        return {};
    }
private:
    
};

class Solution275 {
//    Longest Subarray With Equal Number Of 1s And 0s
//    Given an unsorted array with all 0 or 1s. Return the length of the longest contiguous sub-array that contains equal numbers of 0s and 1s.
//Assumptions:
//    The given array is not null.
//Examples:
//    array = {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0}, the answer is 6 (the subarray is highlighted).
public:
    int longest(vector<int> array) {
        return 0;
    }
private:
    
};

class Solution276 {
//    Get Count Array
//    Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
//Assumptions:
//    The given array A is not null.
//Examples:
//    A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
//Requirement:
//    time complexity = O(nlogn).
public:
    vector<int> countArray(vector<int> array) {
        return array;
    }
private:
    
};

class Solution277 {
//    Restore From Count Array
//    Given an original unsorted array A of size n that contains all integers from  [1….n] (no duplicated numbers) but we do not know A. Instead, we only know a count-array B, in which B[i] represents the number of elements A[j]  (i < j) that are smaller than A[i]. How can we re-store A based on B?
//        Assumptions:
//        The given array is not null.
//        Examples:
//        Given B = { 3, 0, 1, 0 }, then we can restore the original array A = { 4, 1, 3, 2 },
//Requirement:
//    time complexity = O(nlogn).
public:
    //    原始数组
    //    5 4 1 3 7 6 2 8 9
    //    后面多少比他小的变形数组
    //    4 3 0 1 2 1 0 0 0
    //    N^2的算法，根据变形数组中每个坐标在升序数组中取出对应的元素，升序的坐标从0开始
    //    演示如下：
    //    变形数组坐标  需要拿走的值  升序数组{1 2 3 4 5 6 7 8 9}
    //         4         5             1 2 3 4 6 7 8 9
    //         3         4             1 2 3 6 7 8 9
    //         0         1             2 3 6 7 8 9
    //         1         3             2 6 7 8 9
    //         2         7             2 6 8 9
    //         1         6             2 8 9
    //         0         2             8 9
    //         0         8             9
    //         0         9             null
    //    当然跟原始数组是一样的
    //    下面想个办法把更新的数组用LOG(N)时间维护
    class BSTNode {
    public:
    //      线段树数据结构
    //      区间是[1, n]，这里1=l, n=r
    //      如果是叶子节点，value为1，其他节点value表示为多少个1的叶子节点
        int value;
        int l, r;
        BSTNode *left, *right;
        BSTNode(int l, int r) {
            this->l = l;
            this->r = r;
            this->left = NULL;
            this->right = NULL;
        }
    };
    //  为区间[l, r]构造线段树BST
    BSTNode* buildTree(int l, int r) {
        BSTNode* root = new BSTNode(l, r);
        if(l==r) {
            root->value = 1;
            return root;
        }
        int mid = l + (r-l)/2;
        root->left = buildTree(l, mid);
        root->right = buildTree(mid+1, r);
        root->value = root->left->value + root->right->value;
        return root;
    }
    // 【查找K大】
    // 看左子树有多少个为1的节点，如果大于等于K，那么就在左子树找
    // 如果小于K，就在右子树找K-左子树的叶子节点个数
    // 当你找到相应的叶子节点，那么她表示的区间[l,r](这里l==r)，就是我们要找的第K个数
    // 当然K属于[1，N]
    int query(BSTNode* root, int k) {
        if(root==NULL) {
            return -1;
        }
        if(root->l == root->r) {
            return root->l;
        }
        if(root->left->value >= k) {
            return query(root->left, k);
        } else {
            return query(root->right, k-root->left->value);
        }
    }
    //  【删除]
    //  就是把这个叶子节点标记为0,其他包含这个叶子节点的区间统统num--
    void update(BSTNode* root, int num) {
        if (root->l<=num && root->r>=num) {
            root->value--;  //所有经过的节点的value都--
        }
        if (root->l < root->r) {
            update(root->left, num);
            update(root->right, num);
        }
    }
    
    void test() {
        BSTNode* root = buildTree(1, 4);
        vector<int> countArray = {3,0,1,0};
        for (int i=0; i<4; i++) {
            int result = query(root, countArray[i]+1);
            cout<<result<<" ";
            update(root, result);
        }
    }
private:
    
};

class Solution278 {
//    2 Difference In Sorted Array
//    Given a sorted array A, find a pair (i, j) such that A[j] - A[i] is identical to a target number(i != j).
//    If there does not exist such pair, return a zero length array.
//Assumptions:
//    The given array is not null and has length of at least 2.
//Examples:
//    A = {1, 2, 3, 6, 9}, target = 2, return {0, 2} since A[2] - A[0] == 2.
//    A = {1, 2, 3, 6, 9}, target = -2, return {2, 0} since A[0] - A[2] == 2.
public:
    vector<int> twoDiff(vector<int> array, int target) {
        return {};
    }
private:
    
};

class Solution279 {
//    Sort With 3 Stacks
//    Given one stack with integers, sort it with two additional stacks (total 3 stacks).
//    
//    After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
//Assumptions:
//    The given stack is not null.
//Requirements:
//    No additional memory, time complexity = O(nlog(n)).
public:
    void sort(stack<int>& s1) {
        stack<int> s2;
        stack<int> s3;
    }
private:
    
};

class Solution280 {
//    Sort With 2 Stacks
//    Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
//    After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
//    
//Assumptions:
//    The given stack is not null.
//Requirements:
//    No additional memory, time complexity = O(n ^ 2).
public:
    void sort(vector<int> s1) {
        return;
    }
private:
    
};

class Solution281 {
//    Remove Spaces
//    Given a string, remove all leading/trailing/duplicated empty spaces.
//Assumptions:
//    The given string is not null.
//Examples:
//    “  a” --> “a”
//    “   I     love MTV ” --> “I love MTV
public:
    string removeSpaces(string input) {
        if (input.size() == 0) {
            return input;
        }
        int slow = 0, fast = 0;
        for (; fast<input.size(); ) {
            while (input[fast] == ' ') {
                fast++;
            }
            while (fast<input.size() && input[fast] != ' ') {
                input[slow++] = input[fast++];
            }
            while (fast<input.size() && input[fast] == ' ') {
                fast++;
            }
            input[slow] = ' ';
            slow++;
        }
        input.resize(slow - 1);
        return input;
    }
};

class Solution282 {
//    Number Of Words
//    Given a string, count number of words in it. The delimiters can be the following characters: space (‘ ‘) or new line (‘\n’) or tab (‘\t’) or a combination/duplication of these.
//    
//Assumptions:
//    The given string is not null.
//Examples:
//    "I love \t\n google", there are 3 words in it.
public:
    int numOfWords(string input) {
        return 0;
    }
private:
    
};

class Solution283 {
/*String Distance
	Given an array of strings, and two different string s and t.We need to return the smallest indices difference between the two given strings.

	Return - 1 if we can not find s or t in the array.

	Assumptions:

The given array is not null, none of the strings in the array is null.
	s and t are different and they are not null.
	Examples :

	array = { "this", "is", "a", "is", "fox", "happy" }, the distance of "fox" and "is" is 1.*/
public:
	int distance(vector<string> array, string s, string t) {
		return -1;
	}
private:
    
};

class Solution284 {
	//Nested Value
	//	Given a string, calcualte the nested integer weighted sum.
	//	Weight is + 1 for each deeper level of "{}".
	//	Assumptions:
	//The given string is not null
	//	The only characters in the string is either '0' - '9' or '{', '}'
	//	Each digit character is calculated separately.
	//	Examples :
	//	input = “{ 2{4{6}} }”.output = 2×1 + 4×2 + 6×3 = 28.
	//	input = "{34{5}6}".output = 3 + 4 + 5x2 + 6 = 23.
public:
	int value(string input) {
		return 0;
	}
private:
    
};

class Solution285 {
/*Longest Substring With K Typed Characters
	Given a string, return the longest contiguous substring that contains exactly k type of characters.
	Return null if there does not exist such substring.
	Assumptions:
The given string is not null.
	k >= 0.
	Examples :
	input = "aabcc", k = 3, output = "aabcc".
	input = "aabcccc", k = 2, output = "bcccc".*/
public:
	string longest(string input, int k) {
		return input;
	}
private:
};

class Solution286 {
/*Form A Ring With Words
	Given an array of strings, find if the strings can be concatenated to form a ring.The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical to the first char of s2.The first char of the first string in the array must be identical to the last char of the last string.The ring must contain every string in the input once and only once.
	Assumptions:
The given array is not null or empty.
	None of the strings in the array is null or empty.
	Examples :
	input = { "aaa", "bbb", "baa", "aab" }, return true since it can be re - arranged to{ "aaa", "aab", "bbb"  and "baa" }
	input = { "aaa", "bbb" }, return false*/
public:
	bool formRing(vector<string> input) {
		return false;
	}
private:
    
};

class Solution287 {
/*Form Largest Number
	Given an array of numbers in string type, sort them in a way that the concatenation of them yields the largest value.Return the largest number in string type.
	Assumptions:
The given array is not null.
	Each of the strings in the array is not null and they are all numbers.
	Examples :
{“54”, “546”, “648”, “88”}, the arrangement “8864854654” gives the largest value.*/
public:
	string largestNumber(vector<string> input) {
		return "";
	}
private:
    
};

class Solution288 {
/*First Non - Repeating Character In Stream
		Given a stream of characters, find the first non - repeating character from stream.You need to tell the first non - repeating character in O(1) time at any moment.
		Implement two methods of the class :
		read() - read one character from the stream
		firstNonRepeating() - return the first non - repoeating character from the stream at any time when calling the method, return null if there does not exist such characters
		Examples :
read:
	a   b   c   a   c   c    b
		firstNonRepeating :
	a   a   a   b   b   b   null*/
public:
	Solution288() {
		// Initialize the class.
	}

	void read(char ch) {
		// Implement this method here.
	}

	char firstNonRepeating() {
		// Implement this method here.
		return ' ';
	}
private:
    
};

class Solution289 {
/*String Frequency In Windows
	Given a string containing only 'A', 'B', 'C', 'D', return the number of occurrences of substring which has length 4 and includes all of the characters from 'A', 'B', 'C', 'D' with in descending sorted order.
	Assumptions:
The given string is not null and has length of >= 4.
	In the output, if two substrings have the same frequency, then they should be sorted by the their natural order.
	Examples :
	“ABCDABCDD”, --> {"ABCD" : 2, "BCDA" : 1, "CDAB" : 1, "DABC" : 1}*/
public:
	class Frequency {
		string str;
		int freq;
		Frequency(string str, int freq) {
			this->str = str;
			this->freq = freq;
		}
	};
	vector<Frequency> frequency(string input) {
		return {};
	}
private:
    
};

class Solution290 {
/*Wildcard Matching
	Given two strings where first string is a normal string and second string may contain wild card characters.Write a function that returns true if the two strings match.The following are allowed wildcard characters in first string.
	* --> Matches with 0 or more instances of any character or set of characters.
	? --> Matches with any one character.
	Assumptions:
The two strings are both not null.
	Assume there is no more than one '*' adjacent to each other.
	Examples :
	input = "abc", pattern = "?*", return true.*/
public:
	bool match(string input, string pattern) {
		return false;
	}
private:
    
};

class Solution291 {
/*Ternary Expression Tree
	Implement a solution to parse a ternary expression into a tree.
	Assumptions:
The input ternary expression is a string, and it is guaranteed to be valid.
	Examples :
	a ? b : c-->
	a
	/ \
	b     c
	a ? b ? c : d : e-->
	a
	/ \
	b       e
	/ \
	c    d*/
public:
	class ExpNode {
	public:
		char symbol;
		ExpNode* left;
		ExpNode* right;
		ExpNode(char symbol) {
			this->symbol = symbol;
		}
    };
	ExpNode* tree(string exp) {
		return NULL;
	}
private:
};

class Solution292 {
/*String Abbreviation Matching
	Word “book” can be abbreviated to 4, b3, b2k, etc.Given a string and an abbreviation, return if the string matches the abbreviation.
	Assumptions:
The original string only contains alphabetic characters.
	Both input and pattern are not null.
	Examples :
	pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.*/
private:
    bool matchHelper(string& input, int id, string& pattern, int ip) {
        if (id == input.size() && ip == pattern.size()) {
            return true;
        }
        else if (input.size() == id || pattern.size() == ip) {
            return false;
        }
        else if (isdigit(pattern[ip])) {
            int i = ip;
            int num = 0;
            while (i<pattern.size() && isdigit(pattern[i])) {
                num = num * 10 + pattern[i] - '0';
                i++;
            }
            if (id + num>input.size()) {
                return false;
            }
            else {
                return matchHelper(input, id + num, pattern, i);
            }
        }
        else {
            if (input[id] != pattern[ip]) {
                return false;
            }
            else {
                return matchHelper(input, id, pattern, ip + 1);
            }
        }
    }
public:
    bool match(string input, string pattern) {
        return matchHelper(input, 0, pattern, 0);
    }
};

class Solution293 {
/*Smallest Substring Containing All Characters Of Another String
	Given two strings s1 and s2, find the shortest substring in s1 containing all characters in s2.
	If there does not exist such substring in s1, return an empty string.
	Assumptions:
s1 and s2 are not null or empty.
	Examples :
	s1 = “The given test strings”
	s2 : “itsst”
	Output string : “st stri”*/
public:
	string smallest(string s1, string s2) {
		return "";
	}
private:
};

class Solution294 {
//Levelorder Reconstruct Complete Binary Tree
//	How to re construct a complete binary tree from its level - order traversal sequence only.
//	Assumptions:
//The given level - order is not null.
//	Examples :
//{1, 2, 3} -->
//	1
//	/ \
//	2     3
public:
	TreeNode* construct(vector<int> level) {
		return nullptr;
	}
private:
};

class Solution295 {
//Cousins In Binary Tree
//	Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not.Two nodes are cousins of each other if they are at the same level and have different parents.
//	Assumptions:
//It is not guranteed the two keys are all in the binary tree.
//	There are no duplicate keys in the binary tree.
//	Examples :
//	6
//	/ \
//	3     5
//	/ \ / \
//	7   8 1   3
//	7 and 1, result is true.
//	3 and 5, result is false.
//	7 and 5, result is false.
public:
	bool isCousin(TreeNode* root, int a, int b) {
		return false;
	}
private:
};

class Solution296 {
/*Right View Of Binary Tree
	Given a Binary Tree, return the right view of it.Right view of a Binary Tree is list of nodes visible when tree is visited from Right side, the order of the nodes in the list should be from top to bottom level of the original tree.
	Examples:
		1
	   / \
	 2     3
	/ \    / \
	4   5   6  7
	/       \
	9        8
	/ \
	10  11
	the right view = [1, 3, 7, 8, 11]*/
public:
	vector<int> rightView(TreeNode* root) {
		return {};
	}
private:
};

class Solution297 {
/*Top View Of Binary Tree
	Given a binary tree, get the top view of it.The nodes in the output list should be from left to right.A node x belongs to the output if x is the topmost node at its column.
	Examples:
	1
	/ \
	2     3
	/ \ / \
	4  (5, 6)  7
	the top view is[4, 2, 1, 3, 7]*/
public:
	vector<int> topView(TreeNode* root) {
		return {};
	}
private:
};

class Solution298 {
	//Vertical List Of Binary Tree
	//	Given a binary tree, get the vertically representation of it as a list of lists.
	//	The columns should be from left to right, and for each column the nodes should be placed from top to bottom, from left to right.
	//	The following example illustrates vertical order traversal.Input:
	//		1
	//	   / \
	//	  2     3
	//	 / \    / \
	//	4   5, 6   7
	//	     \     \
	//	      8     9
	//	Output:
	//[[4],         // left most column
	//	[2],         // 2nd left-most column
	//	[1, 5, 6], // 3rd left-most column, top->bottom, left->right
	//	[3, 8],
	//	[7],
	//	[9]]
public:
	vector<vector<int>> verticalPrint(TreeNode* root) {
		return {};
	}
private:
};

class Solution299 {
//Distance Of Two Nodes In Binary Tree
//	Find distance between two given keys of a Binary Tree, no parent pointers are given.Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
//	Assumptions:
//There are no duplicate keys in the binary tree.
//	The given two keys are guaranteed to be in the binary tree.
//	Examples :
//	1
//	/ \
//	2    3
//	/ \ / \
//	4   5 6   7
//	\
//	8
//	distance(4, 5) = 2
//	distance(4, 6) = 4
public:
	int distance(TreeNode* root, int k1, int k2) {
		return 0;
	}
private:
};

class Solution300 {
/*Convert Binary Tree To Doubly Linked List I
 Given a binary tree, convert it to a doubly linked list in place(use the left pointer as previous, use the right pointer as next).
 The values in the nodes of the doubly linked list should follow the in - order traversal sequence of the binary tree.
 Examples:
		10
		/ \
	   5    15
	  /
	 2
	Output:  2 <-> 5 <-> 10 <-> 15
*/
public:
	TreeNode* toDoubleLinkedList(TreeNode* root) {
		return root;
	}
private:
};

class Solution301 {
//    Get Post-order Sequence By Pre-order and In-order
//    Given Inorder and Preorder traversals of a binary tree, get the Postorder traversal without reconstructing a binary tree.
//Assumptions:
//    The given Inorder and Preorder traversals are guaranteed to be valid.
//Examples:
//Input:
//    
//    Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
//    Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
//    
//Output:
//    Postorder traversal is {4, 5, 2, 6, 3, 1}
public:
    vector<int> postOrder(vector<int> pre, vector<int> in) {
        return {};
    }
private:
};

class Solution302 {
//    Transform Binary Search Tree To Greater Sum Tree
//    Given a BST, change each node’s value, such that its value is equal to the sum of all nodes greater than itself.
//    
//Examples:
//        11
//       /  \
//     2     29
//    /  \  /  \
//    1   7 15  40
//         /
//        35
//    is transformed to
//         119
//         /  \
//      137    75
//     /  \    /  \
//    139 130 104  0
//    /
//   40
public:
    TreeNode* greaterSum(TreeNode* root) {
        return root;
    }
private:
};

class Solution303 {
//    Connect Right Pointer To Successor
//    Connect the node whose right child is NULL to the successor node in in-order sequence.
//Examples:
//        11
//       /  \
//     2     29
//    /  \  /  \
//    1   7 15  40
//   /
//  35
//   the added edges are:
//    1.right = 2
//    7.right = 11
//    15.right = 29
//    35.right = 40
public:
    void connect(TreeNode* root) {
        // Write your solution here.
    
    }
private:
};

class Solution304 {
//    Valid Post-order Traversal Of Binary Search Tree
//    Given an array with integers, determine whether the array contains a valid postorder traversal sequence a BST.
//    
//Assumptions:
//    The given postorder traversal array is not null.
//Examples:
//    { 3, 5, 4 }  is valid
//    { 3,  6,  2,  5,  4} is not valid
public:
    bool validPostOrder(vector<int> post) {
        // Write your solution here.
        return false;
    }
private:
};

class Solution305 {
//    Reverse Alternate Nodes
//    Given a linked list, reverse alternate nodes and append at the end.
//    
//Examples:
//    Input List:    1 -> 2 -> 3 -> 4 -> 5 -> 6
//    Output List: 1 -> 3 -> 5 -> 6 -> 4 -> 2
//    Input List:    1 -> 2 -> 3 -> 4 -> 5
//    Output List: 1 -> 3 -> 5 -> 4 -> 2
public:
    ListNode* reverseAlternate(ListNode* head) {
        // Write your solution here.
        return head;
    }
private:
};

class Solution306 {
//    Check If Linked List Is Palindrome
//    Given a linked list, check whether it is a palindrome.
//    
//Examples:
//    
//Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
//    
//output: true.
//    
//Input:   1 -> 2 -> 3 -> null
//    
//output: false.
//    
//Requirements:
//    
//    Space complexity must be O(1)
public:
    bool isPalindrome(ListNode* head) {
        // Write your solution here.
        return false;
    }
private:
};

class Solution307 {
//    Max Weights Sum Of Intervals
//    Given a list of intervals, each interval has (start, end, weight). find a subset of the intervals, such that there is no overlap, and the sum of weight is maximized.
//    
//    Return the max weights sum.
//Assumptions:
//    The given array of intervals is not null and has length of > 0
public:
    struct IntervalW {
    int start;
    int end;
    int weight;
    IntervalW(int start, int end, int weight) {
        this->start = start;
        this->end = end;
        this->weight = weight;
    }
};
    int maxWeightSum(vector<IntervalW> intervals) {
        // Write your solution here.
        return 0;
    }
private:
};

class Solution308 {
//    Least Insertions To Form A Palindrome
//    Insert the least number of characters to a string in order to make the new string a palindrome. Return the least number of characters should be inserted.
//Assumptions:
//    The given string is not null.
public:
    int leastInsertion(string input) {
        if (input.empty() || input.size()==0) {
            return 0;
        }
        int leng=input.size();
        if (leng==1) {
            return 0;
        }
        else if (leng==2) {
            if (input[0]!=input[1]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if (input[0]==input[leng-1]) {
                return leastInsertion(input.substr(1, leng-2));
            }
            int result=INT_MAX;
            string aa=input.substr(0, leng-1);
            string bb=input.substr(1);
            result = min(leastInsertion(aa), result);
            result = min(leastInsertion(bb), result);
            return result+1;
        }
    }
    int leastInsertion1(string input, int leng) {
        vector<vector<int>> table(leng, vector<int>(leng, 0));
        int l, h, gap;
        for (gap=1; gap<leng; gap++) {
            for (l=0, h=gap+l; h<leng; l++, h++) {
                table[l][h]=(input[l]==input[h]) ? table[l+1][h-1] : \
                min(table[l][h-1]+1, table[l+1][h]+1);
            }
        }
        return table[0][leng-1];
    }
    
    void test() {
        cout<<leastInsertion("ab")<<endl;
        cout<<leastInsertion("aa")<<endl;
        cout<<leastInsertion("abcd")<<endl;
        cout<<leastInsertion("abcda")<<endl;
        cout<<leastInsertion("abcde")<<endl;
        cout<<leastInsertion1("abcde", 5)<<endl;
        cout<<leastInsertion("a")<<endl;
    }
private:
    int findMinInsertions(string& input, int left, int right) {
        if (left>right) {
            return INT_MAX;
        }
        if (left==right) {
            return 0;
        }
        if (left==right-1) {
            return input[left]==input[right]?0:1;
        }
        if (input[left]==input[right]) {
            return findMinInsertions(input, left+1, right-1);
        }
        else {
            return min(findMinInsertions(input, left, right-1),
                       findMinInsertions(input, left+1, right))+1;
        }
    }
};

class Solution309 {
//    Longest Bitonic Sequence
//    Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order, then sorted in a descending order. How can you find the length of the longest bitonic subsequence.
//        
//        Assumptions:
//        The given array is not null.
//        Corner Cases:
//        A subsequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
//        Examples:
//    {1, 3, 2, 1, 4, 6, 1}, the longest bitonic sub sequence is {1, 3, 4, 6, 1}, length is 5.
public:
    int longestBitonic1(vector<int> array) {
        int result=0;
        vector<int> aa=longestAs(array);
        vector<int> bb=longestDs(array);
        for (int i=0; i<array.size(); i++) {
            result=max(result, aa[i]+bb[i]-1);
        }
        return result;
    }
    
    int longestBitonic(vector<int> array) {
        if (array.empty() || array.size()==0) {
            return 0;
        }
        int n=array.size();
        int i, j;
        
        /* Allocate memory for LIS[] and initialize LIS values as 1 for
         all indexes */
        vector<int> lis(n, 1);
        
        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (array[i] > array[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
        
        /* Allocate memory for lds and initialize LDS values for
         all indexes */
        vector<int> lds(n, 1);
        
        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (array[i] > array[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
        
        
        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;
        return max;
    }
    
    void test() {
        cout<<longestBitonic1({1, 3, 2, 1, 4, 6, 1})<<endl;
        cout<<longestBitonic({1, 3, 2, 1, 4, 6, 1})<<endl;
        
        cout<<longestBitonic1({1, 11, 2, 10, 4, 5, 2, 1})<<endl;
        cout<<longestBitonic({1, 11, 2, 10, 4, 5, 2, 1})<<endl;
    }
    
    int findBigger(vector<int>& table, int left, int right, int target) {
        while (left<=right) {
            int mid=left+(right-left)/2;
            if(table[mid]==target) {
                right=mid-1;
            }
            else if(table[mid]>target) {
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return right;
    }
    
    vector<int> longestAs(vector<int>& array) {
        if(array.empty()) {
            return {};
        }
        vector<int> table(array.size()+1, 0);
        vector<int> output(array.size(), 0);
        int result=1;
        table[1]=array[0];
        output[0]=1;
        for (int i=1; i<array.size(); i++) {
            int index=findBigger(table, 1, result, array[i]);
            if(index==result) {
                table[++result]=array[i];
            }
            else {
                table[index+1]=array[i];
            }
            output[i]=index+1;
        }
        return output;
    }
    
    int findSmaller(vector<int>& table, int left, int right, int target) {
        while (left<=right) {
            int mid =left+(right-left)/2;
            if (table[mid]==target) {
                left=mid+1;
            }
            else if(table[mid]>target) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return left;
    }
    
    vector<int> longestDs(vector<int>& array) {
        if (array.empty()) {
            return {};
        }
        int leng=array.size();
        vector<int> table(leng+1, 0);
        vector<int> output(array.size(), 0);
        int result=leng;
        table[leng]=array[leng-1];
        output[leng-1]=1;
        for (int i=leng-2; i>=0; i--) {
            int index=findSmaller(table, result, leng, array[i]);
            if (index==result) {
                table[--result]=array[i];
            }
            else {
                table[index-1]=array[i];
            }
            output[i]=leng+1-index+1;
        }
        return output;
    }
private:
};

class Solution310 {
//    Max Subarray Sum Difference
//    Given an array of integers. Find two disjoint contiguous subarrays in it such that the absolute value of the difference between the sums of two subarray is maximum.  Return the maximum difference.
//    
//Assumptions:
//    The given array is not null and has length of at least 2.
//Examples:
//Input: { 1, -3, 1, -4, 3, 4 }
//    Two subarrays: {-3, 1, -4 }, { 3, 4 }
//    Maximum difference = 13
public:
    int maxDiff(vector<int> array) {
        if (array.empty() || array.size()==0) {
            return 0;
        }
        int leng=array.size();
        int minSum, maxSum;
        vector<int> minLeft(leng, 0);
        vector<int> maxLeft(leng, 0);
        minSum = maxSum = minLeft[0] = maxLeft[0] = array[0];
        for (int i=1; i<leng; i++) {
            minSum = min(array[i], minSum+array[i]);
            minLeft[i] = min(minLeft[i-1], minSum);
            maxSum = max(array[i], maxSum+array[i]);
            maxLeft[i] = max(maxLeft[i-1], maxSum);
        }
        vector<int> minRight(leng, 0);
        vector<int> maxRight(leng, 0);
        minSum = maxSum = minRight[leng-1] = maxRight[leng-1] = array[leng-1];
        for (int i=leng-2; i>=0; i--) {
            minSum = min(array[i], minSum+array[i]);
            minRight[i] = min(minSum, minRight[i+1]);
            maxSum = max(array[i], array[i]+maxSum);
            maxRight[i] = max(maxSum, maxRight[i+1]);
        }
        
        int result=INT_MIN;
        for (int i=0; i<leng-1; i++) {
            result=max(result, max(abs(minLeft[i]-maxRight[i+1]), abs(maxLeft[i]-minRight[i+1])));
        }
        return result;
    }
    
    int maxDiff1(vector<int> array) {
        int result=INT_MIN;
        for (int i=1; i<array.size(); i++) {
            vector<int> a(array.begin(), array.begin()+i);
            vector<int> b(array.begin()+i, array.end());
            maxDiffHelper(a, b, result);
        }
        return result;
    }
    
    
    void test() {
        cout<<maxDiff1({ 1, -3, 1, -4, 3, 4 })<<endl;
        cout<<maxDiff({ 1, -3, 1, -4, 3, 4 })<<endl;
    }
private:
    void maxDiffHelper(vector<int>& a, vector<int>& b, int& result) {
        long suma=0;
        long sumb=0;
        for (int i=0; i<a.size(); i++) {
            suma+=a[i];
        }
        for (int i=0; i<b.size(); i++) {
            sumb+=b[i];
        }
        if (result<abs(suma-sumb)) {
            result=abs(suma-sumb);
        }
        for (int i=1; i<a.size(); i++) {
            vector<int> aa(a.begin(), a.begin()+i);
            vector<int> ab(a.begin()+i, a.end());
            for (int j=1; j<b.size(); j++) {
                vector<int> ba(b.begin(), b.begin()+j);
                vector<int> bb(b.begin(), b.end());
                maxDiffHelper(aa, ba, result);
                maxDiffHelper(aa, bb, result);
                maxDiffHelper(ab, ba, result);
                maxDiffHelper(ab, bb, result);
            }
        }
    }
};

class Solution311 {
//    Prime Factors
//    Each positive integer larger than 1 is the production of several prime numbers. Return the list of prime factors in ascending order.
//    
//Assumptions:
//    The given number is >= 2.
//Examples:
//    12 = 2 * 2 * 3, return [2, 2, 3]
//    5 = 5, return [5]
public:
    vector<int> factors(int target) {
        if (target<2) {
            return {};
        }
        vector<int> result;
        int temp=target;
        while (temp%2==0) {
            result.push_back(2);
            temp=temp/2;
        }
        for (int i=3; i<=sqrt(temp); i+=2) {
            while (temp%i==0) {
                result.push_back(i);
                temp=temp/i;
            }
        }
        if (temp>2) {
            result.push_back(temp);
        }
        return result;
    }
    
    void test() {
        factors(12);
        factors(5);
        factors(1024);
    }
private:
};

class Solution312 {
//    Primes
//    Return the primes less than or equals to target in ascending order.
//    
//Assumptions:
//    
//    The given target is >= 2.
//Examples:
//    
//    target = 3,  return [2, 3]
//    target = 10, return [2, 3, 5, 7]
public:
    vector<int> primes(int target) {
        if (target<=1) {
            return {};
        }
        vector<bool> nonPrime(target+1, false);
        for (int i=2; i<=sqrt(target); i++) {
            if (nonPrime[i]==false) {
                for (int j=i*2; j<=target; j+=i) {
                    nonPrime[j]=true;
                }
            }
        }
        vector<int> result;
        for (int i=2; i<=target; i++) {
            if (nonPrime[i]==false) {
                result.push_back(i);
            }
        }
        return result;
    }
    
    void test() {
        primes(10);
    }
private:
};

class Solution313 {
//    Greatest Common Factor
//    Find the greatest common factor of two positive integers.
//    
//Examples:
//    a = 12, b = 18, the greatest common factor is 6, since 12 = 6 * 2, 18 = 6 * 3.
//    a = 5, b = 16, the greatest common factor is 1.
public:
    int gcf(int a, int b) {
        if (a<0 || b<0) {
            return INT_MIN;
        }
        if (a==b) {
            return a;
        }
        else if (a<b) {
            return gcf(a, b-a);
        }
        else {
            return gcf(b, a-b);
        }
    }
    
    void test() {
        cout<<gcf(12, 18)<<" "<<gcf(5, 16)<<" "<<gcf(90, 99)<<endl;
    }
private:
};

class Solution314 {
//    A + B + C = D
//    Determine if there exist 4 elements in an given positive integer array, such that A + B + C = D.
//        Assumptions:
//        The given array is not null and has length of >= 4.
//        All the elements in the given array are positive integers.
//        Examples:
//        
//        array = {1, 4, 3, 2}, there does not exist such elements, return false.
//    array = {5, 1, 4, 0, 2, 1}, since 1 + 4 + 0 = 5, return true.

public:
    class Element {
    public:
        int i, j;
        Element(int i, int j) {
            this->i=i;
            this->j=j;
        }
    };
    bool exist(vector<int> array) {
        unordered_map<int, Element*> dict;
        for (int i=0; i<array.size()-1; i++) {
            for (int j=i+1; j<array.size(); j++) {
                Element* e = new Element(i, j);
                dict[array[i]+array[j]]=e;
            }
        }
        for (int i=0; i<array.size()-1; i++) {
            for (int j=i+1; j<array.size(); j++) {
                if (dict.find(array[i]-array[j])!=dict.end()) {
                    if (dict[array[i]-array[j]]->i==i || dict[array[i]-array[j]]->j==j) {
                        continue;
                    }
                    else {
                        return true;
                    }
                }
                if (dict.find(array[j]-array[i])!=dict.end()) {
                    if (dict[array[j]-array[i]]->i==i || dict[array[j]-array[i]]->j==j) {
                        continue;
                    }
                    else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    void test() {
        cout<<exist({1, 4, 3, 2})<<endl;
        cout<<exist({5, 1, 4, 0, 2, 1})<<endl;
    }
private:
};


class Solution315 {
//    Array Deduplication V
//    Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the final array.
//    
//    Assumptions
//    
//    The given array is not null
//    Examples
//    {1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}
//    {2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3}
public:
    vector<int> dedup(vector<int> array) {
        int leng=array.size();
        if(leng<=2) {
            return array;
        }
        //        1 2 2 3 3 3
        //            s
        //            f
        //        2 1 2 2 2 3
        //            s
        //                  f
        int slow=0;
        vector<int> result;
        for (int fast=slow; fast<leng; ) {
            while (fast<leng && array[slow]==array[fast]) {
                fast++;
            }
            int offset=fast-slow;
            if(offset==1) {
                result.push_back(array[slow]);
            }
            else {
                result.push_back(array[slow]);
                result.push_back(array[slow]);
            }
            slow=fast;
        }
        return result;
    }
};

class Solution316 {
//    Border View Of Binary Tree
//    Given a binary tree, return its border view. The border view is defined as follow: first get all the border nodes at left side(from root and always go to the left subtree, from top to bottom), then get all the leaf nodes(from left to right), at last get all the border nodes at right side(from bottom to top), the list of border view should not contain duplicate nodes.
//    
//Examples:
//         1
//       /    \
//      2      3
//     / \    /  \
//    4   5   6  7
//    /            \
//    9             8
//     \
//      11
//    the border view =  [1, 2, 4, 9, 11, 5, 6, 8, 7, 3]
//    
//    1, 2, 4, 9 are the left border, 11, 5, 6, 8 are the leaf nodes, 8, 7, 3, 1 are the right border.

public:
    vector<int> borderView(TreeNode* root) {
        if (root==NULL) {
            return {};
        }
        vector<int> result;
        result.push_back(root->value);
        borderLeft(root->left, result);
        borderLeaves(root->left, result);
        borderLeaves(root->right, result);
        borderRight(root->right, result);
        return result;
    }
    
    void test() {
        TreeNode *root            = new TreeNode(20);
        root->left                = new TreeNode(8);
        root->left->left          = new TreeNode(4);
        root->left->right         = new TreeNode(12);
        root->left->right->left   = new TreeNode(10);
        root->left->right->right  = new TreeNode(14);
        root->right               = new TreeNode(22);
        root->right->right        = new TreeNode(25);
        vector<int> result=borderView(root);
    }
private:
    void borderLeft(TreeNode* root, vector<int>& result) {
        if (root) {
            if (root->left) {
                result.push_back(root->value);
                borderLeft(root->left, result);
            }
            else if (root->right) {
                result.push_back(root->value);
                borderLeft(root->right, result);
            }
        }
    }
    void borderLeaves(TreeNode* root, vector<int>& result) {
        if (root) {
            borderLeaves(root->left, result);
            if (root->left==NULL && root->right==NULL) {
                result.push_back(root->value);
            }
            borderLeaves(root->right, result);
        }
    }
    void borderRight(TreeNode* root, vector<int>& result) {
        if (root) {
            if (root->right) {
                borderRight(root->right, result);
                result.push_back(root->value);
            }
            else if (root->left) {
                borderRight(root->left, result);
                result.push_back(root->value);
            }
        }
    }
};

class Solution318 {
//    Compact Divide
//    Given two integers a and b, return the result of a / b in String with compact format. The repeated decimal part should be identified and enclosed by "()".
//    Examples
//    
//    0 / 2 = "0"
//    4 / 2 = "2"
//    1 / 2 = "0.5"
//    -14 / 12 = "-1.1(6)"
//    1 / 11 = "0.(09)"
//    1 / 0 = "NaN"
//    -1 / 0 = "NaN"
public:
    string divide(int a, int b) {
        if (a==0) {
            return "0";
        }
        if (b==0) {
            return "NaN";
        }
        string result;
        if (a<0 ^ b<0) {
            result+="-";
        }
        long long int m=abs(a), n=abs(b);
        result+=to_string(m/n);
        long long int r=m%n;
        if (r==0) {
            return result;
        }
        else {
            result+=".";
        }
        unordered_map<int, int> map;
        while (r) {
            if (map[r]>0) {
                result.insert(map[r], 1, '(');
                result+=')';
                break;
            }
            map[r]=result.size();
            r=r*10;
            result+=to_string(r/n);
            r=r%n;
        }
        return result;
    }
    
    void test() {
        cout<<divide(-14, 12)<<endl;
    }
private:
};

class Solution319 {
//    Delete Node At Index
//    Delete the node at the given index for the given linked list.
//        Examples
//        [1, 2, 3], delete at 1 --> [1, 3]
//        [1, 2, 3], delete at 4 --> [1, 2, 3]
//        [1, 2, 3], delete at 0 --> [2, 3]
public:
    ListNode* deleteNode(ListNode* head, int index) {
        if (head==NULL || index<0) {
            return head;
        }
        ListNode* dummy=new ListNode(-1);
        dummy->next=head;
        deleteHelper(dummy, index+1);
        return dummy->next;
    }
    
    void push(ListNode** head_ref, int new_data)
    {
        ListNode* new_node = new ListNode(new_data);
        new_node->next = (*head_ref);
        (*head_ref) = new_node;
    }
    
    void test() {
        ListNode* head=NULL;
        push(&head, 4);
        push(&head, 3);
        push(&head, 2);
        push(&head, 1);
        head = deleteNode(head, 5);
        head = deleteNode(head, 4);
        head = deleteNode(head, 0);
        head = deleteNode(head, 1);
    }
private:
    void deleteHelper(ListNode* dummy, int index) {
        ListNode* prev=NULL;
        ListNode* curr=dummy;
        ListNode* next=NULL;
        while (index>0 && curr!=NULL) {
            prev=curr;
            curr=curr->next;
            index--;
        }
        if (curr!=NULL) {
            next=curr->next;
            prev->next=next;
            delete(curr);
        }
    }
};

class Solution320 {
//    Delete Nodes At Indices
//    Given a linked list and an sorted array of integers as the indices in the list. Delete all the nodes at the indices in the original list.
//    Examples
//    1 -> 2 -> 3 -> 4 -> NULL, indices = {0, 3, 5}, after deletion the list is 2 -> 3 -> NULL.
//    Assumptions
//    the given indices array is not null and it is guaranteed to contain non-negative integers sorted in ascending order.

public:
    ListNode* deleteNodes(ListNode* head, vector<int> indices) {
        if (head==NULL) {
            return NULL;
        }
        int j=0;
        vector<pair<ListNode*, ListNode*>> positions;
        ListNode* dummy=new ListNode(-1);
        dummy->next=head;
        ListNode *prev=dummy, *curr=head;
        for (int i=0; i<indices.size(); i++) {
            findHelper(prev, curr, j, indices[i], positions);
        }
        deleteHelper(positions);
        return dummy->next;
    }
    
    void push(ListNode** head_ref, int new_data)
    {
        ListNode* new_node = new ListNode(new_data);
        new_node->next = (*head_ref);
        (*head_ref) = new_node;
    }

    void test() {
        ListNode* head=NULL;
        push(&head, 4);
        push(&head, 3);
        push(&head, 2);
        push(&head, 1);
        head = deleteNodes(head, {0, 1, 3, 4, 5});
    }
private:
    void findHelper(ListNode*& prev, ListNode*& curr, int& j, int index, vector<pair<ListNode*, ListNode*>>& positions) {
        if (curr==NULL) {
            return;
        }
        while (curr!=NULL && j!=index) {
            prev=curr;
            curr=curr->next;
            j++;
        }
        if (j>index) {
            positions.push_back(make_pair(curr, curr));
        }
        else {
            positions.push_back(make_pair(prev, curr));
        }
    }
    void deleteHelper(vector<pair<ListNode*, ListNode*>>& positions) {
        if (positions.empty()) {
            return;
        }
        int leng=positions.size();
        for (int i=leng-1; i>=0; i--) {
            if (positions[i].second==NULL) {
                continue;
            }
            else {
                ListNode* temp = positions[i].second;
                positions[i].first->next = temp->next;
                delete temp;
            }
        }
    }
};

class Solution321 {
//    Divide Two Integers With Restrictions
//    Given two integers a and b, calculate a / b without using divide/mod operations.
//Examples:
//    0 / 1 = 0
//    1 / 0 = Integer.MAX_VALUE
//    -1 / 0 = Integer.MAX_VALUE
//    11 / 2 = 5
//    -11 / 2 = -5
//    11 / -2 = -5
//    -11 / -2 = -5
public:
    int divide(int a, int b) {
        if (b==0 || (a==INT_MIN && b==-1)) {
            return INT_MAX;
        }
        long long aa=abs(a), bb=abs(b);
        int result=0;
        while (a>=b) {
            long long temp=bb, shift=1;
            while (a>=(temp<<1)) {
                temp<<=1;
                shift<=1;
            }
            aa=aa-temp;
            result=result+shift;
        }
        int sign=(a<0)^(b<0)?-1:1;
        return sign==1?result:-result;
    }
private:
};

class Solution322 {
//    Delete Zero Nodes From Leaf
//    Given a binary tree, delete the nodes only if it is 0 and all the nodes on the paths from the node to any leaf nodes are all 0.
//        In another word, delete the leaf nodes with 0 recursively until there are no such nodes in the tree.
//        You only need to return the final tree after deletion.
//        Examples:
//            0
//          /    \
//         0      3
//         / \    / \
//        0   0   0  7
//        /            \
//        0             0
//         \
//          0
//        After first round, deleting all the leaf nodes with 0, the tree becomes:
//        0
//        /   \
//        0     3
//        /     / \
//        0     0   7
//        /
//        0
//        After second round, deleting all the leaf nodes with 0, the tree becomes:
//          0
//        /   \
//        0     3
//        /       \
//        0         7
//        After third round, deleting all the leaf nodes with 0, the tree becomds:
//          0
//        /   \
//        0     3
//               \
//                7
//        After another round, deleting all the leaf nodes with 0, the tree becomds:
//        0
//         \
//          3
//           \
//            7
//        The deletion end at this step since there are no more nodes to delete.
//        
//        You only need to return the final binary tree after deletion.
public:
    TreeNode* deleteNode(TreeNode* root) {
        if (root==NULL) {
            return root;
        }
        root->left=deleteNode(root->left);
        root->right=deleteNode(root->right);
        if (root->left==NULL && root->right==NULL && root->value==0) {
            return NULL;
        }
        return root;
    }
    
    void test() {
        TreeNode* t1=new TreeNode(0);
        TreeNode* t2=new TreeNode(0);
        TreeNode* t3=new TreeNode(0);
        TreeNode* t4=new TreeNode(0);
        TreeNode* t5=new TreeNode(3);
        TreeNode* t6=new TreeNode(7);
        t1->left=t2;    t1->right=t5;
        t2->left=t3;    t3->right=t4;
        t5->left=t6;
        TreeNode* result=deleteNode(t1);
    }
private:
};

class Solution323 {
//    Depth Of Forest
//    Given an integer array A representing a forest, such that, A[i] means the parent index of index i, if A[i] == -1, it means index i is a root.
//        Determine what is the depth of the forest, the depth of the forest is the maximum depth of the trees in the forest.
//        Examples:
//        A = {2, 2, -1, 5, 5, -1, 3}, represnts the forest:
//    
//     2
//    / \
//    0   1
//    
//    and
//     5
//    /  \
//    3    4
//    /
//    6
//    
//    The depth of the forest is 3(the depth of the second tree).
//    
//Assumptions:
//    The given array is not null or empty, all the elements in the array are in the range of [-1, N - 1] where N is the length of the array.
//    Corner Cases:
//    
//    You should be able to identify that there could be a cycle in the forest, what if that is the case? Return -1
public:
    int depth(vector<int> forest) {
        if (forest.empty()) {
            return 0;
        }
        int leng=forest.size();
        if (leng==1) {
            if (forest[0]==-1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int result=0;
        vector<bool> visited(leng, false);
        for (int i=0; i<leng; i++) {
            if (forest[i]==-1) {
                int height=1;
                int current=height;
                helper(forest, i, height, current, visited);
                if (current<0) {
                    return current;
                }
                else {
                    result=max(result, current);
                }
            }
        }
        return result;
    }
    
    void test() {
        cout<<depth({2, 2, -1, 5, 5, -1, 3})<<endl;
    }
private:
    void helper(vector<int>& forest, int root, int height, int& result, vector<bool>& visited) {
        if (visited[root]==true) {
            result=-1;
            return;
        }
        visited[root]=true;
        result=max(result, height);
        for (int i=0; i<forest.size(); i++) {
            if (forest[i]==root) {
                helper(forest, i, height+1, result, visited);
            }
        }
    }
};

class Solution324 {
//    Different Elements In Two Sorted Arrays
//    Given two sorted arrays a and b containing only integers, return two list of elements: the elements only in a but not in b, and the elements only in b but not in a.
//    Do it in one pass.
//Assumptions:
//    The two given arrays are not null.
//Examples:
//    a = {1, 2, 2, 3, 4, 5}
//    b = {2, 2, 2, 4, 4, 6}
//    The returned two lists are:
//    [
//     [1, 3, 5],
//     [2, 4, 6]  // there are two 2s in a, so there is one 2 in b not in a
//     ]
public:
    vector<vector<int>> diff(vector<int> a, vector<int> b) {
        unordered_map<int, int> commons;
        intersection(a, b, commons);
        vector<vector<int>> result(2, {});
        for (int i=0; i<a.size(); i++) {
            unordered_map<int, int> copy=commons;
            if (copy.find(a[i])==copy.end()) {
                result[0].push_back(a[i]);
            }
            else if(copy[a[i]]>0) {
                copy[a[i]]--;
            }
            else if(copy[a[i]]==0) {
                result[0].push_back(a[i]);
            }
        }
        for (int i=0; i<b.size(); i++) {
            if (commons.find(b[i])==commons.end()) {
                result[1].push_back(b[i]);
            }
            else if(commons[b[i]]>0) {
                commons[b[i]]--;
            }
            else if(commons[b[i]]==0) {
                result[1].push_back(b[i]);
            }
        }
        return result;
    }
    
    void test() {
        vector<vector<int>> result=diff({1, 2, 2, 3, 4, 5}, {2, 2, 2, 4, 4, 6});
        for (auto i:result) {
            for (auto j:i) {
                cout<<j<<" ";
            }
            cout<<endl;
        }
    }
    void intersection(vector<int>& a, vector<int>& b, unordered_map<int, int>& commons) {
        int i=0, j=0;
        vector<int> result;
        while (i<a.size() && j<b.size()) {
            if (a[i]<b[j]) {
                i++;
            }
            else if (a[i]>b[j]) {
                j++;
            }
            else {
                commons[a[i]]++;
                i++; j++;
            }
        }
        return;
    }
private:
};

class Solution325 {
//    K Sorted Array
//    Given an unsorted integer array, each element is at most k step from its position after the array is sorted.
//    Can you sort this array with time complexity better than O(nlogn)?
//Assumptions:
//    The given array is not null and length is n, k < n and k >= 0
public:
    vector<int> ksort(vector<int> array, int k) {
        priority_queue<int, vector<int>, greater<int>> min_heap;
        int leng=array.size();
        for (int i=0; i<=k && i<leng; i++) {
            min_heap.push(array[i]);
        }
        for (int i=k+1, ti=0; ti<leng; i++, ti++) {
            if (i<leng) {
                int temp=min_heap.top();
                min_heap.pop();
                min_heap.push(array[i]);
                array[ti]=temp;
            }
            else {
                array[ti]=min_heap.top();
                min_heap.pop();
            }
        }
        return array;
    }
    
    void test() {
        vector<int> result=ksort({3, 2, 8, 6, 56, 32}, 1);
    }
private:
};

class Solution326 {
//    Heapify
//    Heapify an unsorted array to min heap
public:
    vector<int> heapify(vector<int> array) {
        int leng=array.size();
        for (int i=leng/2-1; i>=0; i--) {
            heapHelper(array, leng, i);
        }
        return array;
    }
private:
    void heapHelper(vector<int>& array, int leng, int i) {
        int smallest=i;
        int left=2*smallest+1;
        int right=2*smallest+2;
        if (left<leng && array[left]<array[smallest]) {
            smallest=left;
        }
        if (right<leng && array[right]<array[smallest]) {
            smallest=right;
        }
        if (smallest!=i) {
            swap(array[i], array[smallest]);
            heapHelper(array, leng, smallest);
        }
    }
};

class Solution327 {
//    Find Local Minimum
//    Given an unsorted integer array, return any of the local minimum's index.
//    An element at index i is defined as local minimum when it is smaller than all its possible two neighbors a[i - 1] and a[i + 1]
//    
//    (you can think a[-1] = -infinite, and a[a.length] = +infinite)
//    
//Assumptions:
//    
//    The given array is not null or empty.
//    There are no duplicate elements in the array.

public:
    int localMinimum(vector<int> array) {
        int left=0, leng=array.size(), right=leng-1;
        return localMinHelper(array, left, right, leng);
    }
private:
    int localMinHelper(vector<int>& array, int left, int right, int leng) {
        int mid=left+(right-left)/2;
        if ((mid==0 || array[mid-1]>array[mid]) &&
            (mid==leng-1 || array[mid+1]>array[mid])) {
            return mid;
        }
        else if (mid>0 && array[mid-1] < array[mid]) {
            return localMinHelper(array, left, mid-1, leng);
        }
        else {
            return localMinHelper(array, mid+1, right, leng);
        }
    }
};

class Solution328 {
//    Heap Sort
//    Heap Sort is a comparison based sorting algorithm with O(nlogn) time and O(1) space.
//Requirements:
//    You have to do it in place, extra space used is no more than O(1).
//        Time complexity is O(nlogn).
public:
    vector<int> heapsort(vector<int> array) {
        vector<int> result=array;
        int leng=array.size();
        for (int i=leng/2-1; i>=0; i--) {
            heapify(array, leng, i);
        }
        for (int i=leng-1; i>=0; i--) {
            swap(array[i], array[0]);
            heapify(array, i, 0);
        }
        return array;
    }
    
    void test() {
        heapsort({12, 11, 13, 5, 6, 7});
    }
private:
    void heapify(vector<int>& array, int leng, int i) {
        int largest=i;
        int l=largest*2+1, r=largest*2+2;
        if (l<leng && array[l]>array[largest]) {
            largest=l;
        }
        if (r<leng && array[l]>array[largest]) {
            largest=r;
        }
        if (largest!=i) {
            swap(array[i], array[largest]);
            heapify(array, leng, largest);
        }
    }
};

class Solution329 {
//    Number Of Negative Numbers In Sorted Matrix
//    Given an matrix of integers, each row is sorted in ascending order from left to right, each column is also sorted in ascending order from top to bottom.
//    
//    Determine how many negative numbers in the matrix.
//Assumptions:
//    The given matrix is not null.
//Examples:
//      { {-5, -3, 0, 0, 1},
//        {-3, -2, 1, 1, 3}
//        {-2, 0,  3, 5, 6} }
//    The number of negative elements in the matrix is 5.
public:
    int negNumber(vector<vector<int>> matrix) {
        int count=0;
        int i=0, j=matrix[0].size()-1;
        while (j>=0 && i<matrix.size()-1) {
            if (matrix[i][j]<0) {
                count+=j+1;
                i+=1;
            }
            else {
                j-=1;
            }
        }
        return count;
    }
private:
};

class Solution330 {
//    One Edit Distance
//    Determine if two given Strings are one edit distance.
//        One edit distance means you can only insert one character/delete one character/replace one character to another character in one of the two given Strings and they will become identical.
//        Assumptions:
//        The two given Strings are not null
//        Examples:
//        s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical
//        s = "abc", t = "bcd" are not one edit distance
public:
    bool oneEditDistance(string s, string t) {
        int m=s.size(), n=t.size();
//        a) If current characters don't match, then
//        (i)   Increment count of edits
//        (ii)  If count becomes more than 1, return false
//        (iii) If length of one string is more, then only
//        possible  edit is to remove a character.
//        Therefore, move ahead in larger string.
//        (iv)  If length is same, then only possible edit
//        is to  change a character. Therefore, move
//        ahead in both strings.
//        b) Else, move ahead in both strings.
        if (abs(n-m)>1) {
            return false;
        }
        int count=0;
        int i=0, j=0;
        while (i<m && j<n) {
            if (s[i]!=t[j]) {
                if (count==1) {
                    return false;
                }
                if (m>n) {
                    i++; count++;
                }
                else if (m<n) {
                    j++; count++;
                }
                else {
                    i++; j++; count++;
                }
            }
            else {
                i++; j++;
            }
        }
        if (i<m || j<n) {
            count++;
        }
        return count==1;
    }
private:
};

class Solution331 {
//    Determine The Intersection Of Two Linked Lists
//    Given two singly linked list, determine the intersection node. If there does not exist one, return null.
public:
    ListNode* intersect(ListNode* h1, ListNode* h2) {
        int c1=getCount(h1);
        int c2=getCount(h2);
        int d;
        if (c1>c2) {
            d=c1-c2;
            return intersectHelper(d, h1, h2);
        }
        else {
            d=c2-c1;
            return intersectHelper(d, h2, h1);
        }
    }
private:
    ListNode* intersectHelper(int d, ListNode* h1, ListNode* h2) {
        int i;
        ListNode* curr1=h1, * curr2=h2;
        for (i=0; i<d; i++) {
            if (curr1==NULL) {
                return NULL;
            }
            curr1=curr1->next;
        }
        while (curr1!=NULL && curr2!=NULL) {
            if (curr1==curr2) {
                return curr1;
            }
            curr1=curr1->next;
            curr2=curr2->next;
        }
        return NULL;
    }
    
    int getCount(ListNode* head) {
        ListNode* curr=head;
        int count=0;
        while (curr) {
            count++;
            curr=curr->next;
        }
        return count;
    }
};

class Solution332 {
//    Ways Of Expressions To Target
//    Given an expression as a String array, the only possible elements are "0", "1", "|", "&", "^".
//    You can add parentheses to let the execution sequence be changed.
//    
//    Given a target number(either 0 or 1), how many different ways of execution sequence are there to let the result be the target number?
//    
//Assumptions:
//    The given String array is not null or empty, and it is guaranteed to be valid.
//Examples:
//    {"0", "&", "1", "|", "1"}, if target is 1, there is only one way (0 & 1) | 1 == 1
//        
    
public:
    class ETreeNode {
    public:
        string value;
        ETreeNode* left;
        ETreeNode* right;
        ETreeNode(string value) {
            this->value=value;
            this->left=NULL;
            this->right=NULL;
        }
    };
    
    int ways(vector<string> exp, int target) {
        vector<ETreeNode*> trees;
        trees=buildBST(exp, 0, exp.size()-1);
        int result=0;
        for (int i=0; i<trees.size(); i++) {
            int curr = computeHelper(trees[i]);
            if (curr==target) {
                result++;
            }
        }
        return result;
    }
    
    void test() {
        int result= ways({"0", "&", "1", "|", "1"}, 1);
        cout<<result<<endl;
    }
    
private:
    vector<ETreeNode*> buildBST(vector<string>& exp, int start, int end) {
        vector<ETreeNode*> result;
        if (start>end) {
            result.push_back(NULL);
            return result;
        }
        else if(start==end) {
            string curr=exp[start];
            result.push_back(new ETreeNode(curr));
            return result;
        }
        for (int i=start; i<=end; i++) {
            if (exp[i]=="|" || exp[i]=="&" | exp[i]=="^") {
                vector<ETreeNode*> lefts=buildBST(exp, start, i-1);
                vector<ETreeNode*> rights=buildBST(exp, i+1, end);
                for (auto ileft:lefts) {
                    for (auto iright:rights) {
                        ETreeNode* ti=new ETreeNode(exp[i]);
                        ti->left=ileft;
                        ti->right=iright;
                        result.push_back(ti);
                    }
                }
            }
        }
        return result;
    }
    
    int computeHelper(ETreeNode* root) {
        int result=INT_MIN;
        if (root==NULL) {
            return result;
        }
        if (root->left==NULL && root->right==NULL) {
            return root->value[0]-'0';
        }
        int left=computeHelper(root->left);
        int right=computeHelper(root->right);
        switch (root->value[0]) {
            case '&':
                result=left&right;
                break;
            case '|':
                result=left|right;
                break;
            case '^':
                result=left^right;
                break;
            default:
                break;
        }
        return result;
    }
};

class Solution333 {
//    Check If Undirected Graph Has Cycle
//    Given an undirected graph, determine if it has cycle.
public:
    bool isCyclic(vector<GraphNode*> graph) {
        if(graph.empty()) {
            return false;
        }
        int n=graph.size();
        unordered_map<GraphNode*, bool> visited;
        for (int i=0; i<n; i++) {
            visited[graph[i]]=false;
        }
        for (int u=0; u<n; u++) {
            if (!visited[graph[u]]) {
                if (hasCycle(graph[u], visited, NULL)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    void test() {
        GraphNode* n0=new GraphNode(0);
        GraphNode* n1=new GraphNode(1);
        GraphNode* n2=new GraphNode(2);
        GraphNode* n3=new GraphNode(3);
        GraphNode* n4=new GraphNode(4);
        n0->neighbors.push_back(n1);
        n0->neighbors.push_back(n2);
        n0->neighbors.push_back(n3);
        n1->neighbors.push_back(n0);
        n1->neighbors.push_back(n2);
        n2->neighbors.push_back(n0);
        n2->neighbors.push_back(n1);
        n3->neighbors.push_back(n0);
        n3->neighbors.push_back(n4);
        n4->neighbors.push_back(n3);
        cout<<isCyclic({n0, n1, n2, n3, n4})<<endl;
        GraphNode* n5=new GraphNode(5);
        GraphNode* n6=new GraphNode(6);
        GraphNode* n7=new GraphNode(7);
        n5->neighbors.push_back(n6);
        n6->neighbors.push_back(n5);
        n6->neighbors.push_back(n7);
        cout<<isCyclic({n5, n6, n7})<<endl;
    }
private:
    bool hasCycle(GraphNode*& i, unordered_map<GraphNode*, bool>& visited, GraphNode* parent) {
        visited[i]=true;
        for (int j=0; j<i->neighbors.size(); j++) {
            GraphNode* nei=i->neighbors[j];
            if (!visited[nei]) {
                if (hasCycle(nei, visited, i)) {
                    return true;
                }
            }
            else if (nei!=parent) {
                return true;
            }
        }
        return false;
    }
};

class Solution334 {
//    Check If Directed Graph Has Cycle
//    Determine if a directed graph has cycle.
public:
    bool isCyclic(vector<GraphNode*> graph) {
        if(graph.empty()) {
            return false;
        }
        int n=graph.size();
        
        unordered_map<GraphNode*, bool> visited;
        unordered_map<GraphNode*, bool> recStack;
        for (int i=0; i<n; i++) {
            visited[graph[i]]=false;
            recStack[graph[i]]=false;
        }
        for (int i=0; i<n; i++) {
            if(isCyclicHelper(graph[i], visited, recStack)) {
                return true;
            }
        }
        return false;
    }
    
    void test() {
        GraphNode* g1=new GraphNode(1);
        GraphNode* g2=new GraphNode(2);
        GraphNode* g3=new GraphNode(3);
        GraphNode* g4=new GraphNode(4);
        
        g1->neighbors.push_back(g2);
        g1->neighbors.push_back(g3);
        g2->neighbors.push_back(g3);
        g3->neighbors.push_back(g1);
        g3->neighbors.push_back(g4);
        g4->neighbors.push_back(g4);
        bool result=isCyclic({g1, g2, g3, g4});
    }
private:
    bool isCyclicHelper(GraphNode*& i, unordered_map<GraphNode*, bool>& visited, unordered_map<GraphNode*, bool>& recStack) {
        if(visited[i]==false) {
            visited[i]=true;
            recStack[i]=true;
            for (int j=0; j<i->neighbors.size(); j++) {
                GraphNode* nei=i->neighbors[j];
                if(visited[nei]==false && isCyclicHelper(nei, visited, recStack)) {
                    return true;
                }
                else if (recStack[nei]) {
                    return true;
                }
            }
        }
        recStack[i]=false;
        return false;
    }
};

class Solution335 {
//    Largest SubArray Sum II
//    Given an unsorted integer circular array with length n (the next element of index n - 1 is index 0), find the subarray that has the greatest sum and return the sum, the subarray at least should contains 1 element.
//    
//    Assumptions
//    The given array is not null and has length of at least 1.
//    Examples
//    {2, -1, 4, -2, 1}, the largest subarray sum is 1 + 2 + (-1) + 4 = 6
//    {-2, -1, -3}, the largest subarray sum is -1
public:
    int subarraySum(vector<int> nums){
        int leng = (int)nums.size();
        if (leng <= 0) {
            return 0;
        }
        else if (leng == 1) {
            return nums[0];
        }
        int output=INT_MIN;
        for (int i=0; i<leng; i++) {
            vector<int> msum(leng, INT_MIN);
            
            msum[0] = nums[i];
            int result = msum[0];
            for (int j = 1; j<leng; j++) {
                if (msum[j - 1] <= 0) {
                    msum[j] = nums[(j+i)%leng];
                }
                else {
                    msum[j] = msum[j-1] + nums[(j+i)%leng];
                }
                result = max(result, msum[j]);
            }
            output=max(result, output);
        }
        return output;
    }
    
    void test() {
        cout<<subarraySum({2, -1, 4, -2, 1})<<endl;
        cout<<subarraySum({-2, -1, -3})<<endl;
    }
private:
};

class Solution336 {
//    Anagrams With Only Lower Case Letters
//    Find all the anagrams with only lower case letters 'a' - 'z' for a given String, the other characters are not changed.
//        
//        Examples:
//        
//        "AbcbD" --> ["AbbcD", "AbcbD", "AcbbD"]
//        
//        Assumptions:
//        
//        The given String is not null.
public:
    vector<string> anagrams(string input) {
        if (input.empty()) {
            return {};
        }
        vector<string> result;
        vector<int> positions;
        for (int i=0; i<input.size(); i++) {
            if (input[i]>='a' && input[i]<='z') {
                positions.push_back(i);
            }
        }
        if (positions.size()<=1) {
            return {input};
        }
        dfsHelper(input, positions, 0, result);
        return result;
    }
    
    void test() {
        anagrams("AbcDe");
    }
private:
    void dfsHelper(string& input, vector<int>& positions, int i, vector<string>& result) {
        if (i==positions.size()) {
            result.push_back(input);
            return;
        }
        for (int j=i; j<positions.size(); j++) {
            swap(input[positions[j]], input[positions[i]]);
            dfsHelper(input, positions, i+1, result);
            swap(input[positions[j]], input[positions[i]]);
        }
    }
};

class Solution337 {
//    Prefix To Postfix Expression
//    Transfer the given prefix expression to postfix expression. The given prefix expression is in String format and each of the tokens are separated by a space character (There could be 5 types of tokens: an integer number, +, -, *, /).
//    
//Assumptions:
//    The given expression in String is not null or empty and it is guaranteed to be valid.
//Examples:
//    "* + 1 2 3" --> "1 2 + 3 *"
public:
    string transfer(string prefix) {
        string postfix;
        stack<string> st;
        int leng=prefix.length();
        for (int i=leng-1; i>=0; i--) {
            string t1="", t2="";
            if (isOperator(prefix[i])) {
                if(!st.empty()) {
                    t1=st.top(); st.pop();
                }
                if(!st.empty()) {
                    t2=st.top(); st.pop();
                }
                t2.push_back(' ');
                t2.push_back(prefix[i]);
                st.push(t1+' '+t2);
            }
            else if(prefix[i]!= ' ') {
                t1=prefix[i];
                st.push(t1);
            }
        }
        postfix=st.top();
        st.pop();
        return postfix;
    }
    void test() {
        string result=transfer("* + 1 2 3");
        cout<<result<<endl;
    }
private:
    bool isOperator(char c) {
        if (c=='+' || c=='-' || c=='*' || c=='/') {
            return true;
        }
        return false;
    }
};

class Solution338 {
//    Reverse Odd Groups Of K Nodes
//    Given a singly linked list, group the nodes for each k nodes, reverse only the odd groups (the group number starts from 0).
//        Assumptions:
//        k >= 1
//        Examples:
//        1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, k = 2. After reverse the list is:
//        1 -> 2 -> 4 -> 3 -> 5 -> 6 -> null
public:
    ListNode* reverseKOddGroup(ListNode* head, int k) {
        if (head==NULL || head->next==NULL) {
            return head;
        }
        int count=0;
        ListNode* curr=head;
        ListNode* here=NULL;
        ListNode* prev=NULL;
        while (curr!=NULL && count!=2*k) {
            if(count<k) {
                prev=curr;
            }
            if(count==k) {
                here=curr;
            }
            curr=curr->next;
            count++;
        }
        if (count==2*k) {
            curr=reverseKOddGroup(curr, k);
            while(count>k) {
                ListNode* temp=here->next;
                here->next=curr;
                curr=here;
                here=temp;
                count--;
            }
            prev->next=curr;
        }
        return head;
    }
    
    void test() {
        ListNode* a1= new ListNode(1);
        ListNode* a2= new ListNode(2);
        ListNode* a3= new ListNode(3);
        ListNode* a4= new ListNode(4);
        ListNode* a5= new ListNode(5);
        ListNode* a6= new ListNode(6);
        ListNode* a7= new ListNode(7);
        ListNode* a8= new ListNode(8);
        ListNode* a9= new ListNode(9);
        ListNode* a10= new ListNode(10);
        a1->next=a2;
        a2->next=a3;
        a3->next=a4;
        a4->next=a5;
        a5->next=a6;
        a6->next=a7;
        a7->next=a8;
        a8->next=a9;
        a9->next=a10;
        ListNode* result=reverseKOddGroup(a1, 2);
    }
private:
};

class Solution339 {
//    Largest Different Zero/One Numbers
//    Given an integer array containing only 0 and 1. Find the subarray such that the absolute value of difference between number of 0s and number of 1s is the largest.
//    
//    Return the absolute difference.
//Assumptions:
//    The given array is not null. It is guaranteed the elements are all 0 or 1.
//Examples:
//    {1, 1, 1, 0, 1, 0}, the largest difference is 3 (in subarray of {1, 1, 1, 0, 1}, there are 4 elements of 1 and 1 element of 0)
public:
    int diff(vector<int> array) {
        if (array.empty() || array.size()==1) {
            return 0;
        }
        //1, 0, 0, 1, 0, 1, 1
        int result=0;
        for (int i=0; i<array.size(); i++) {
            int zeros=0, ones=0;
            for (int j=i; j>=0; j--) {
                if (array[j]==0) {
                    zeros++;
                }
                else {
                    ones++;
                }
            }
            if (zeros && ones) {
                result=max(result, abs(zeros-ones));
            }
        }
        return result;
    }
private:
};

class Solution340 {
//    Insertion Sort
//    Given an array of integers, sort the elements in the array in ascending order. The insertion sort algorithm should be used to solve this problem.
//    
//    Examples
//    
//    {1, 2, 3} is sorted to {1, 2, 3}
//    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
//    Corner Cases
//    
//    What if the given array is null? In this case, we do not need to do anything.
//        What if the given array is of length zero? In this case, we do not need to do anything.

public:
    vector<int> sort(vector<int> array) {
        int i, j;
        int temp;
        for (i=1; i<array.size(); i++) {
            temp=array[i];
            j=i-1;
            for (;j>=0 && array[j]>temp;j--) {
                array[j+1]=array[j];
            }
            array[j+1]=temp;
        }
        return array;
    }
private:
};

class Solution341 {
//    Insertion Sort Linked List
//    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The insertion sort algorithm should be used to solve this problem.
//    
//    Examples
//    
//    null, is sorted to null
//    1 -> null, is sorted to 1 -> null
//    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
public:
    ListNode* sort(ListNode* head) {
        ListNode* result=head;
        if (head==NULL || head->next==NULL) {
            return result;
        }
        ListNode *t1=head->next;
        result->next=NULL;
        while (t1!=NULL) {
            ListNode *t2=result;
            if(t1->value>t2->value) {
                ListNode *prev=NULL;
                while (t2!=NULL && t1->value>t2->value) {
                    prev=t2;
                    t2=t2->next;
                }
                if(t2==NULL) {
                    prev->next=t1;
                    t1=t1->next;
                    prev=prev->next;
                    prev->next=NULL;
                }
                else {
                    ListNode* temp=t1;
                    t1=t1->next;
                    prev->next=temp;
                    temp->next=t2;
                }
            }
            else {
                ListNode* temp=t1;
                t1=t1->next;
                temp->next=t2;
                result=temp;
            }

        }
        return result;
    }
    
    void test() {
        ListNode* a1= new ListNode(4);
        ListNode* a2= new ListNode(2);
        ListNode* a3= new ListNode(6);
        ListNode* a4= new ListNode(-3);
        ListNode* a5= new ListNode(5);
        a1->next=a2;
        a2->next=a3;
        a3->next=a4;
        a4->next=a5;
        a5->next=NULL;
        ListNode* result=sort(a1);
    }
private:
};

class Solution342 {
//    Isomorphic String I
//    Two Strings are called isomorphic if the letters in one String can be remapped to get the second String. Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. The mapping is two way and no two letters may map to the same letter, but a letter may map to itself. Determine if two given String are isomorphic.
//        Assumptions:
//        The two given Strings are not null.
//        Examples:
//        "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
//        "abba" and "cccc" are not isomorphic.
public:
    bool isomorphic(string s, string t) {
        int sleng=s.size(), tleng=t.size();
        if (sleng!=tleng) {
            return false;
        }
        char tmp='0';
        string ss="";
        string tt="";
        unordered_map<char, char> dict;
        for (int i=0; i<sleng; ++i) {
            if (dict.count(s[i])==0) {
                dict[s[i]]=tmp++;
            }
            ss+=dict[s[i]];
        }
        tmp='0';
        dict.clear();
        for (int i=0; i<tleng; ++i) {
            if (dict.count(t[i])==0) {
                dict[t[i]]=tmp++;
            }
            tt+=dict[t[i]];
        }
        return ss==tt;
    }
};

class Solution343 {
//    Number Of Pairs Diff To Target
//    Given an integer array, determine how many pairs of elements, the absolute value of the difference between the two elements is the given target value.
//Assumptions:
//    There could be elements with duplicate value in the array, and each of the elements is considered different.
//    The given array is not null and has length >= 2.
//Examples:
//    array = {3, 1, 2, 1}, target = 2, there are 2 pairs { (3, 1), (3, 1) }
public:
    int pairs(vector<int> array, int target) {
        if (array.empty() || array.size()<2) {
            return 0;
        }
        int count=0;
        unordered_map<int, bool> hashmap;
        for (int i=0; i<array.size(); i++) {
            hashmap[array[i]]=true;
        }
        for (int i=0; i<array.size(); i++) {
            int x=array[i];
            if (hashmap[x-target]) {
                count++;
            }
            if (hashmap[target+x]) {
                count++;
            }
            hashmap[x]=false;
        }
        return count;
    }
private:
};

class Solution344 {
//    Celebrity Problem
//    Given an binary matrix of N * N (the only elements in the matrix are 0s and 1s), each of the indices represents one person.
//    matrix[i][j] = 1 if and only if person i knows person j (this is single direction, only if matrix[j][i] = 1 such that person j knows person i).
//        Determine if there is one celebrity among all N persons, a celebrity is defined as
//            He does not know any other person.
//            All the other persons know him.
//            Return the celebrity's index if there exist one (there could be at most one celebrity, why?), return -1 otherwise.
//     Assumptions:
//     The given matrix is not null and N >= 2.
//     Examples:
//     matrix = { { 0, 1, 1 },
//                { 0, 0, 0 },
//                { 1, 1, 0 } }
//    The celebrity is person 1, since person 0 and person 2 all know him, but person 1 does not know person 0 or person 2.
public:
    int celebrity(vector<vector<int>> matrix) {
        if (matrix.empty() || matrix.size()<2) {
            return -1;
        }
        int a=0, b=matrix[0].size()-1;
//        The idea is to use two pointers, one from start and one from the end. Assume the start person is A, and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity. We will find a celebrity candidate at the end of the loop. Go through each person again and check whether this is the celebrity.
        while (a<b) {
            if (matrix[a][b]==1) {
                a++;
            }
            else {
                b--;
            }
        }
        for (int i=0; i<matrix[0].size(); i++) {
            if (i!=a && (matrix[a][i]==1 || matrix[i][a]==0)) {
                return -1;
            }
        }
        return a;
    }
private:
};

class Solution345 {
//    Boggle Game I
//    Given a char matrix of M * N, and a target String, determine if there exist one path in the matrix such that the string constructed by concatenating the characters on the path, equals to the target.
//        
//        From any cell of the matrix, you can go to the neighbor cells of 4 directions(up, down, left, right), the same cell should not be visited more than once on the same path.
//        
//        Return the list of cells if such path exists, or null otherwise.
//            
//            Assumptions:
//            The given matrix is not null, M, N >= 1
//            The target String is not null or empty
//            Examples:
//            matrix = { { 'a', 'b', 'c' },
//                { 'p', 'p', 'q' },
//                { 'i' , 'l', 'e' } }
//    
//    if the target is "apple", then there exists a path [[0, 0], [1, 0], [1, 1], [2, 1], [2, 2]] to form "apple".
public:
    vector<vector<int>> boggle(vector<vector<char>> matrix, string target) {
        if (matrix.empty()) {
            return {};
        }
        int rows=matrix.size(), cols=matrix[0].size();
        if (target.size()>rows*cols) {
            return {};
        }
        vector<vector<int>> result;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j]==target[0]) {
                    dfshelper(matrix, rows, cols, i, j, target, 0, result);
                }
            }
        }
        return result;
    }
    void dfshelper(vector<vector<char>>& matrix, int rows, int cols, int x, int y, string target, int i, vector<vector<int>>& result) {
        if (x<0 || x>=rows || y<0 || y>=cols || matrix[x][y]==' ') {
            return;
        }
        if (target[i]==matrix[x][y]) {
            result.push_back({x, y});
            if (i==target.size()-1) {
                return;
            }
            char curr=matrix[x][y];
            matrix[x][y]=' ';
            dfshelper(matrix, rows, cols, x+1, y, target, i+1, result);
            dfshelper(matrix, rows, cols, x-1, y, target, i+1, result);
            dfshelper(matrix, rows, cols, x, y+1, target, i+1, result);
            dfshelper(matrix, rows, cols, x, y-1, target, i+1, result);
            matrix[x][y]=curr;
        }
    }
    
    void test() {
        vector<vector<char>> matrix={ { 'a', 'b', 'c' },
                            { 'p', 'p', 'q' },
                            { 'i' , 'l', 'e' } };
        string target="apple";
        vector<vector<int>> result=boggle(matrix, target);
        for (auto i:result) {
            cout<<i[0]<<" "<<i[1]<<endl;
        }
    }
private:
};

class Solution346 {
//    Closest Taller Person On The Right Side
//    Given an integer array representing the heights of N persons, now determine for each of the N persons, which person is the closet taller person on the right side.
//        
//        Return another integer array of size N, each element is the closest taller person's index in the original array.
//        If there is no taller person at right side, then use -1 to mark such case.
//        Assumptions:
//        The given array is not null.
//        Examples:
//        array = {3, 2, 7, 5, 6}, result is {2, 2, -1, 4, -1}
public:
    vector<int> closetTaller(vector<int> array) {
        if(array.empty()) {
            return {};
        }
        int maxv=array.size()-1;
        vector<int> result(array.size(), 0);
        for (int i=array.size()-1; i>=0; i--) {
            if (array[i]<array[maxv]) {
                result[i]=maxv;
            }
            else if(array[i]>=array[maxv]) {
                result[i]=-1;
                maxv=i;
            }
        }
        return result;
    }

    void test() {
        vector<int> array={3, 2, 7, 5, 6};
        array = closetTaller(array);
        for (auto i:array) {
            cout<<i<<" ";
        }
    }
private:
};

class Solution347 {
//    Second Largest In Binary Search Tree
//    Find the second largest key in the given binary search tree.
//    
//    If there does not exist the second largest key, return Integer.MIN_VALUE.
//    
//Assumptions:
//    
//    The given binary search tree is not null.
//Examples:
//    
//    2
//    
//    /   \
//    
//    1     4
//    
//    /
//    
//    3
//    
//    the second largest key is 3.
public:
    int secondLargest(TreeNode* root) {
        int result=0, index=0;
        helper(root, index, result);
        return result;
    }
    
    void helper(TreeNode* root, int& index, int& result) {
        if (root==NULL || index>=2) {
            return;
        }
        helper(root->right, index, result);
        index++;
        if (index==2) {
            result=root->value;
            return;
        }
        helper(root->left, index, result);
    }
private:
};

class Solution348 {
//    Reverse Only Vowels
//    Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.
//    
//Assumptions:
//    
//    The given string is not null, and only contains lower case letters.
//Examples:
//    
//    "abbegi" --> "ibbega"
public:
    string reverse(string s) {
        int leng=s.size();
        if(leng<=1) {
            return s;
        }
        int i=0, j=leng-1;
        while (i<j) {
            i=s.find_first_of("aeiouAEIOU", i);
            j=s.find_last_of("aeiouAEIOU", j);
            if (i<j) {
                swap(s[i++], s[j--]);
            }
        }
        return s;
    }
};

class Solution349 {
//    Smallest Range
//    Given k sorted integer arrays, pick k elements (one element from each of sorted arrays), what is the smallest range.
//Assumptions:
//    k >= 2
//    None of the k arrays is null or empty
//Examples:
//      { { 1, 4, 6 },
//        { 2, 5 },
//        { 8, 10, 15} }
//    
//    pick one element from each of 3 arrays, the smallest range is {5, 8} (pick 6 from the first array, pick 5 from the second array and pick 8 from the third array).
public:
    struct minHeapNode {
        int value;
        int i,j;
    };
    class minHeap {
        vector<minHeapNode*> harr;
        int heap_size;
    public:
        minHeap(vector<minHeapNode*> a, int size) {
            heap_size=size;
            harr=a;
            int i=(heap_size-1)/2;
            while (i>=0) {
                minHeapify(i);
                i--;
            }
        }
        
        void minHeapify(int i) {
            int l=left(i);
            int r=right(i);
            int smallest=i;
            if (l<heap_size && harr[l]->value<harr[i]->value) {
                smallest=l;
            }
            if (r<heap_size && harr[r]->value<harr[i]->value) {
                smallest=r;
            }
            if (smallest!=i) {
                swap(harr[i]->value, harr[smallest]->value);
                minHeapify(smallest);
            }
        }
        
        int left(int i) {
            return (2*i+1);
        }
        
        int right(int i) {
            return (2*i+2);
        }
        
        minHeapNode* getMin() {
            return harr[0];
        }
        
        void replaceMin(minHeapNode* x) {
            harr[0]=x;
            minHeapify(0);
        }
    };
    
    vector<int> smallestRange(vector<vector<int>> arrays) {
        int range=INT_MAX;
        int minv=INT_MAX, maxv=INT_MIN;
        int start=0, end=0;
        if(arrays.empty()) {
            return {};
        }
        int rows=arrays.size(), cols=arrays[0].size();
        vector<minHeapNode*> harr(rows, 0);
        for (int i=0; i<rows; i++) {
            harr[i]->value=arrays[i][0];
            harr[i]->i=i;
            harr[i]->j=1;
            
            if(harr[i]->value>maxv) {
                maxv=harr[i]->value;
            }
        }
        minHeap hp(harr, rows);
        while (true) {
            minHeapNode* root=hp.getMin();
            minv=root->value;
            if (range>maxv-minv+1) {
                range=maxv-minv+1;
                start=minv;
                end=maxv;
            }
            if (root->j<arrays[root->i].size()) {
                root->value=arrays[root->i][root->j];
                root->j+=1;
                if (root->value>maxv) {
                    maxv=root->value;
                }
            }
            else {
                break;
            }
            hp.replaceMin(root);
        }
        return {start, end};
    }
private:
};


class Solution350 {
//    Replacements Of A And B
//    Given a string with only character 'a' and 'b', replace some of the characters such that the string becomes in the forms of all the 'b's are on the right side of all the 'a's.
//    
//    Determine what is the minimum number of replacements needed.
//    
//Assumptions:
//    
//    The given string is not null.
//Examples:
//    
//    "abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 'a' so that the string becomes "aaaab").
public:
    int minReplacements(string input) {
        int leng = input.size();
        if(leng<=1) {
            return 0;
        }
        if(leng==2) {
            if (input[0]=='b' && input[1]=='a') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            vector<int> dp1(leng, 0);
            vector<int> dp2(leng, 0);
            dp1[0]=0, dp2[leng-1]=0;
            for (int i=0; i<leng; i++) {
                if (i==0) {
                    if (input[i]=='b') {
                        dp1[0]=1;
                    }
                    else {
                        dp1[0]=0;
                    }
                }
                else {
                    if (input[i]=='b') {
                        dp1[i]=dp1[i-1]+1;
                    }
                    else {
                        dp1[i]=dp1[i-1];
                    }
                    
                }
            }
            for (int j=leng-1; j>=0; j--) {
                if(j==leng-1) {
                    if (input[j]=='a') {
                        dp2[j]=1;
                    }
                    else {
                        dp2[j]=0;
                    }
                }
                else {
                    if (input[j]=='a') {
                        dp2[j]=dp2[j+1]+1;
                    }
                    else {
                        dp2[j]=dp2[j+1];
                    }
                }
            }
            int result=INT_MAX;
            for (int m=0; m<leng-1; m++) {
                result=min(result, min(min(dp1[leng-1], dp2[0]), dp1[m]+dp2[m+1]));
            }
            return result;
        }
        //aaabbabbaaaabba
    }
};

class Solution351 {
public:
private:
};

class Solution352 {
public:
private:
};

class Solution353 {
public:
private:
};

class Solution354 {
public:
private:
};

class Solution355 {
public:
private:
};

class Solution356 {
public:
private:
};

class Solution357 {
public:
private:
};

class Solution358 {
public:
private:
};

class Solution359 {
public:
private:
};

class Solution360 {
public:
private:
};

class Solution361 {
public:
private:
};

class Solution362 {
public:
private:
};

class Solution363 {
public:
private:
};

class Solution364 {
public:
private:
};

class Solution365 {
public:
private:
};

class Solution366 {
public:
private:
};

class Solution367 {
public:
private:
};

class Solution368 {
public:
private:
};

class Solution369 {
public:
private:
};

class Solution370 {
public:
private:
};

class Solution371 {
public:
private:
};

class Solution372 {
public:
private:
};

class Solution373 {
public:
private:
};

class Solution374 {
public:
private:
};

class Solution375 {
public:
private:
};

class Solution376 {
public:
private:
};

class Solution377 {
public:
private:
};

class Solution378 {
public:
private:
};

class Solution380 {
public:
private:
};

class Solution381 {
public:
private:
};

class Solution382 {
public:
private:
};

class Solution383 {
public:
    string reverseWords(string s) {
        int leng=s.size();
        if (leng<=1) {
            return s;
        }
        string result=s;
        reverse(result.begin(), result.end());
        string output="";
        int length=0;
        for (int i=0; i<leng; ) {
            while (i<leng && result[i]==' ') {
                i++;
            }
            int j=i;
            while (j<leng && result[j]!=' ') {
                j++;
            }
            //j==' '
            for (int m=j-1; m>=i; --m) {
                output+=result[m];
            }
            output+=" ";
            i=j;
        }
        while (output.back()==' ') {
            output.pop_back();
        }
        return output;
    }
};

class Solution384 {
public:
private:
};

class Solution385 {
public:
private:
};

class Solution386 {
public:
private:
};

class Solution387 {
public:
private:
};

class Solution388 {
public:
private:
};

class Solution389 {
public:
private:
};

class Solution390 {
public:
private:
};

class Solution391 {
public:
private:
};

class Solution392 {
public:
private:
};

class Solution393 {
public:
private:
};

class Solution394 {
public:
private:
};

class Solution395 {
public:
    string remove(string input, string t) {
        if (input.size() == 0) {
            return input;
        }
        unordered_map<char, int> mymap;
        for (auto i : t) {
            mymap[i]++;
        }
        int slow = 0;
        for (int fast = 0; fast<input.size(); fast++) {
            if (mymap[input[fast]]>0) {
                continue;
            }
            input[slow] = input[fast];
            slow++;
        }
        return input.substr(0, slow);
    }
};

class Solution396 {
public:
    string reverse(string input) {
        std::reverse(input.begin(), input.end());
        return input;
    }
};

class Solution397 {
public:
    string rightShift(string input, int n) {
        if (input.size() <= 1 || n == 0) {
            return input;
        }
        else if (n >= input.size()) {
            n = n%input.size();
        }
        //abc defg 3
        //gfe dcba
        //efg abcd
        reverse(input.begin(), input.end());
        reverse(input.begin(), input.begin() + n);
        reverse(input.begin() + n, input.end());
        return input;
    }
};

class Solution398 {
public:
    vector<int> allAnagrams(string s, string l) {
        int leng = (int)l.size();
        if (leng == 0) {
            return {};
        }
        unordered_map<char, int> hashset;
        unordered_map<char, int> worker;
        for (int i = 0; i<s.size(); i++) {
            hashset[s[i]]++;
        }
        worker = hashset;
        //aabc
        //zzzz cde bcaa b cyywww
        //          s
        //           f
        vector<int> result;
        for (int slow = 0, fast = 0; fast<leng - s.size() + 1; fast++) {//必须要加1
            if (worker[l[fast]]>0) {
                slow = fast;
                while (slow<leng && worker[l[slow]]>0) {
                    worker[l[slow]]--;
                    slow++;
                }
                bool found = true;
                for (auto it = worker.begin(); it != worker.end(); it++) {
                    if (it->second != 0) {
                        found = false;
                        break;
                    }
                }
                worker = hashset;
                if (found) {
                    result.push_back(fast);
                }
            }
        }
        return result;
    }
};

class Solution399 {
public:
    vector<int> rainbowSortII(vector<int> array) {
        int red=0,green=0,blue=0, black=0;
        for (int i=0; i<array.size(); ++i) {
            switch (array[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    green++;
                    break;
                case 2:
                    blue++;
                    break;
                case 3:
                    black++;
                    break;
                default:
                    break;
            }
        }
        int j=0;
        for (int i=0; i<red; i++) {
            array[j++]=0;
        }
        for (int i=0; i<green; i++) {
            array[j++]=1;
        }
        for (int i=0; i<blue; i++) {
            array[j++]=2;
        }
        for (int i=0; i<black; i++) {
            array[j++]=3;
        }
        return array;
    }
};

class Solution400 {
public:
    vector<int> rainbowSortIII(vector<int> array, int k) {
        vector<int> color(k, 0);
        for (int i=0; i<array.size(); ++i) {
            color[array[i]-1]++;
        }
        int j=0;
        for(int m=0;m<k;++m) {
            for(int i=0; i<color[m];++i) {
                array[j++]=m+1;
            }
        }
        return array;
    }
};

class Solution401 {
public:
private:
};

class Solution402 {
public:
private:
};

class Solution403 {
public:
private:
};

class Solution404 {
public:
private:
};

class Solution405 {
public:
private:
};

class Solution406 {
public:
private:
};

class Solution407 {
public:
private:
};

class Solution408 {
public:
private:
};

class Solution409 {
public:
private:
};

class Solution410 {
public:
private:
};

class Solution411 {
public:
private:
};

class Solution412 {
public:
private:
};

class Solution413 {
public:
private:
};

class Solution414 {
public:
private:
};

class Solution415 {
public:
private:
};

class Solution416 {
public:
private:
};

class Solution417 {
public:
private:
};

class Solution418 {
public:
private:
};

class Solution419 {
public:
private:
};

class Solution420 {
public:
private:
};

class Solution421 {
public:
private:
};

class Solution422 {
public:
private:
};

class Solution423 {
public:
private:
};

class Solution424 {
public:
private:
};

class Solution425 {
public:
private:
};

class Solution426 {
public:
private:
};

class Solution427 {
public:
private:
};

class Solution428 {
public:
private:
};

class Solution429 {
public:
private:
};

class Solution430 {
public:
private:
};

class Solution431 {
public:
private:
};

class Solution432 {
public:
private:
};

class Solution433 {
public:
private:
};

class Solution434 {
public:
private:
};

class Solution435 {
public:
private:
};

class Solution436 {
public:
private:
};

class Solution437 {
public:
private:
};

class Solution438 {
public:
private:
};

class Solution439 {
public:
private:
};

class Solution440 {
public:
private:
};

class Solution441 {
public:
private:
};

class Solution442 {
public:
private:
};

class Solution443 {
public:
private:
};

class Solution444 {
public:
private:
};

class Solution445 {
public:
private:
};

class Solution446 {
public:
private:
};

class Solution447 {
public:
private:
};

class Solution448 {
public:
private:
};

class Solution449 {
public:
private:
};

class Solution450 {
public:
private:
};

class Solution451 {
public:
private:
};

class Solution452 {
public:
private:
};

class Solution453 {
public:
private:
};

class Solution454 {
public:
private:
};

class Solution455 {
public:
private:
};

class Solution456 {
public:
private:
};

class Solution457 {
public:
private:
};

class Solution458 {
public:
private:
};

class Solution459 {
public:
private:
};

class Solution460 {
public:
private:
};

class Solution461 {
public:
private:
};

class Solution462 {
public:
private:
};

class Solution463 {
public:
private:
};

class Solution464 {
public:
private:
};

class Solution465 {
public:
private:
};

class Solution466 {
public:
private:
};

class Solution467 {
public:
private:
};

class Solution468 {
public:
private:
};

class Solution469 {
public:
private:
};

class Solution470 {
public:
private:
};

class Solution471 {
public:
private:
};

class Solution472 {
public:
private:
};

class Solution473 {
public:
private:
};

class Solution474 {
public:
private:
};

class Solution475 {
public:
private:
};

class Solution476 {
public:
private:
};

class Solution477 {
public:
private:
};

class Solution478 {
public:
private:
};

class Solution479 {
public:
private:
};

class Solution480 {
public:
};

class Solution481 {
public:
};

class Solution482 {
public:
private:
};

class Solution500 {
private:
    const char flag='1';
    void dfsHelper(vector<string>& zombies, vector<bool>& visited, int index, const char& target) {
        for(int cursor=0;cursor<zombies.size();cursor++) {
            const char& refchar = zombies[index].at(cursor);
            if(refchar==target && visited[cursor]==false) {
                visited[cursor]=true;
                dfsHelper(zombies, visited, cursor, target);
            }
        }
        return;
    }
    
public:
    int zombieCluster(vector<string> zombies) {
        int n=(int)zombies.size();
        if(n<=1) {
            return n;
        }
        vector<bool> visited(n, false);
        int result=0;
        for(int zombie=0;zombie<n;zombie++) {
            if(visited[zombie]==false) {
                result++;
                dfsHelper(zombies, visited, zombie, flag);
            }
        }
        return result;
    }
    
};

class Solution501 {
private:
    void dfsHelper(string& input, int i, int leng, string& combo, vector<string>& result) {
        if(i==leng-1) {
            combo+=input[i];
            result.push_back(combo);
            combo.pop_back();
            return;
        }
        combo+=input[i];
        combo+=" ";
        dfsHelper(input, i+1, leng, combo, result);
        combo.pop_back();
        dfsHelper(input, i+1, leng, combo, result);
        combo.pop_back();
    }
    
public:
    vector<string> listspace(string input) {
        int leng=(int)input.size();
        vector<string> result;
        if(leng<=0) {
            return result;
        }
        string combo="";
        dfsHelper(input, 0, leng, combo, result);
        return result;
    }
};


class Solution502 {
public:
    bool isCousions(TreeNode* root, TreeNode* one, TreeNode* two) {
        if(root==nullptr) {
            return false;
        }
        if(one==two) {
            return false;
        }
        vector<TreeNode*> path;
        TreeNode* lparent=NULL;
        TreeNode* rparent=NULL;
        int lHeight=getHeight(root, one, path, &lparent);
        path.clear();
        int rHeight=getHeight(root, two, path, &rparent);
        if(lHeight!=rHeight) {
            return false;
        }
        if(lparent==rparent) {
            return false;
        }
        return true;
    }
private:
    int getHeight(TreeNode* root, TreeNode* target, vector<TreeNode*>& path, TreeNode** parent) {
        if(root==NULL) {
            return 0;
        }
        if(root==target) {
            *parent=path[path.size()-1];
            return 1;
        }
        path.push_back(root);
        int left=getHeight(root->left, target, path, parent);
        int right=getHeight(root->right, target, path, parent);
        path.pop_back();
        return max(left, right)+1;
    }
};

class Solution503 {
public:
    int minCut(int n) {
        int result=minCutHelper(n);
        return result;
    }
private:
    int minCutHelper(int n) {
        if(n<=0) {
            return 0;
        }
        for(int i=n/2+1;i>=1;i--) {
            if(i*i==n) {
                return 1;
            }
            else if(i*i<n) {
                return 1+minCutHelper(n-i*i);
            }
        }
        return n;
    }
};

class Solution504 {
public:
    bool cycle(vector<string> array) {
        int leng=(int)array.size();
        if(leng<=0) {
            return false;
        }
        vector<string> result;
        result.push_back(array[0]);
        vector<bool> visited(leng, false);
        return dfsHelper(array, leng, result, visited, array[0][0]);
    }
private:
    bool dfsHelper(vector<string>& array, int leng, vector<string>& result, vector<bool>& visited, char sign) {
        if(result.size()==leng) {
            if(result[leng-1][result[leng-1].length()-1]==sign) {
                return true;
            }
            else {
                return false;
            }
        }
        string str=result[result.size()-1];
        char lastsign=str[str.length()-1];
        for(int i=1;i<leng;i++) {
            if(visited[i]==true) {
                continue;
            }
            if(lastsign==array[i][0]) {
                visited[i]=true;
                result.push_back(array[i]);
                bool curr=dfsHelper(array, leng, result, visited, lastsign);
                if(curr) {
                    return true;
                }
                else {
                    visited[i]=false;
                    result.pop_back();
                }
            }
        }
        return false;
    }
};


class Solution505 {
private:
    int getLeftHeight(TreeNode* root) {
        if(root==NULL) {
            return 0;
        }
        return getLeftHeight(root->left)+1;
    }
    int getRightHeight(TreeNode* root) {
        if(root==NULL) {
            return 0;
        }
        return getRightHeight(root->right)+1;
    }
    
public:
    int count(TreeNode* root) {
        //base case
        if(root==NULL) {
            return 0;
        }
        if(root->left==NULL && root->right==NULL) {
            return 1;
        }
        int left=getLeftHeight(root->left);
        int right=getRightHeight(root->right);
        if(left==right) {
            return pow(2, left+1)-1;
        }
        else {
            int leftCounts=count(root->left);
            int rightCounts=count(root->right);
            return leftCounts+rightCounts+1;
        }
    }
};

class Solution506 {
private:
    bool isExist(set<Point*>& list, Point* p) {
        bool result=false;
        set<Point*>::iterator it;
        for(it=list.begin(); it!=list.end(); ++it) {
            if((*it)->d==p->d && (*it)->x==p->x && (*it)->y==p->y) {
                result=true;
            }
        }
        cout<<result<<endl;
        return result;
    }
    
    Point* go(Point* start, char command) {
        if(command=='G') {
            if(start->d==start->right) {
                return new Point(start->d, start->x+1, start->y);
            }
            else if(start->d==start->down) {
                return new Point(start->d, start->x, start->y-1);
            }
            else if(start->d==start->left) {
                return new Point(start->d, start->x-1, start->y);
            }
            else if(start->d==start->up) {
                return new Point(start->d, start->x, start->y+1);
            }
        }
        else if(command=='L') {
            return new Point((start->d+4-1)%4, start->x, start->y);
        }
        else if(command=='R') {
            return new Point((start->d+1)%4, start->x, start->y);
        }
        return start;
    }
public:
    vector<string> doesCircleExist(vector < string > commands) {
        int leng=(int)commands.size();
        vector<string> result;
        if(leng<=0) {
            return {""};
        }
        for(int i=0;i<leng;++i) {
            int leng2=(int)commands[i].size();
            if(leng2<=0) {
                result.push_back("");
            }
            if(leng2==1) {
                if(commands[i][0]=='G') {
                    result.push_back("NO");
                }
                else {
                    result.push_back("YES");
                }
            }
            else {
                Point* current=new Point(0, 0, 0);
                set<Point*> lookup;
                lookup.insert(current);
                for(int i=0;i<4;++i) {
                    for(int j=0;j<leng2;j++) {
                        current=go(current, commands[i].at(j));
                    }
                    if(isExist(lookup, current)) {
                        result.push_back("YES");
                    }
                    else {
                        result.push_back("NO");
                    }
                }
                
            }
        }
        return result;
    }
};

class Solution507 {
private:
    void dfs(unordered_map<int, unordered_set<int>>& mp, unordered_set<int>& visited, set<int>& result, int i, int start) {
        visited.insert(i);
        for(auto next:mp[i]) {
            if(result.count(next)!=0) {
                result.erase(next);
                result.insert(start);
                continue;
            }
            if(visited.count(next)) {
                continue;
            }
            dfs(mp, visited, result, next, start);
        }
    }
public:
    vector<int> putad(unordered_map<int, unordered_set<int>>& mp) {
        set<int> result;
        vector<int> output;
        unordered_set<int> visited;
        for(auto i:mp) {
            cout<<i.first<<endl;
            if(!visited.count(i.first)) {
                result.insert(i.first);
                dfs(mp, visited, result, i.first, i.first);
            }
        }
        copy(result.begin(), result.end(), back_inserter(output));
        return output;
    }
};

class Solution508 {
public:
    struct host {
        int id;
        int score;
    };
    
    vector<vector<int>> counting(vector<vector<int>>& input, unordered_map<int, int>& lookup) {
        vector<vector<int>> result;
        for(auto i:input) {
            if(lookup[i[0]]==0) {
                result.push_back(i);
            }
            lookup[i[0]]++;
        }
        return result;
    }
    
    struct mycompare {
    public:
        bool operator()(vector<int>& a, vector<int>& b) {
            return (a[1]>=b[1]);
        }
    } mycompare;
    
    vector<vector<int>> sorting(vector<vector<int>>& input) {
        vector<vector<int>> result=input;
        sort(result.begin(), result.end(), mycompare);
        return result;
    }
    
};

class Solution509 {
public:
    long dotProduct(vector<pair<int, int>> a1, vector<pair<int, int>> a2) {
        if (a1.empty() || a1.size()==0 || a2.empty() || a2.size()==0) {
            return 0;
        }
        //  0 1 2 3 4 5
        //  0 4 0 0 2 3
        //  0 7 6 0 0 1
        unordered_map<int, int> vector1;
        for(int i=0; i<a1.size(); i++) {
            vector1[a1[i].first]=a1[i].second;
        }
        long result=0;
        for (int i=0; i<a2.size(); i++) {
            if (vector1[a2[i].first]!=0) {
                result+=vector1[a2[i].first]*a2[i].second;
            }
        }
        return result;
    }
    void test() {
        vector<pair<int, int>> a1;
        a1.push_back({1, 4});
        a1.push_back({4, 2});
        a1.push_back({5, 3});
        vector<pair<int, int>> a2;
        a2.push_back({1, 7});
        a2.push_back({2, 6});
        a2.push_back({5, 1});
        cout<<dotProduct(a1, a2);
    }
};

class Solution510 {
public:
//    碰到这种相邻是重复的问题应该用stack
    int getCompleteTime(string list, int k) {
        string curr;
        stack<char> stk;
        for (int i=0; i<list.size(); i++) {
            if (!stk.empty()) {
                if (stk.top()==list[i]) {
                    for (int j=0; j<k; j++) {
                        curr+=stk.top();
                    }
                }
            }
            curr+=list[i];
            stk.push(list[i]);
        }
        return curr.size();
    }
    
    void test() {
        cout<<getCompleteTime("AAAA", 3)<<endl;
        cout<<getCompleteTime("ABCD", 3)<<endl;
        cout<<getCompleteTime("ABAD", 3)<<endl;
    }
};

class Solution511 {
public:
//Maximum Size Subarray Sum Equals k
    int maxSubArrayLen(vector<int> nums, int k) {
        int sum=0;
        int result=0;
        unordered_map<int, int> dict;
        for(int i=0;i<nums.size();i++) {
            sum+=nums[i];
            if (sum==k) {
                result=max(result, i+1);
            }
            int diff=sum-k;
            if (dict.find(diff)!=dict.end()) {
                result=max(result, i-dict[diff]);
            }
            if (dict.find(sum)==dict.end()) {
                dict[sum]=i;
            }
        }
        return result;
    }
    
    void test() {
        cout<<maxSubArrayLen({1, -1, 5, -2, 3}, 3)<<endl;
        cout<<maxSubArrayLen({-2, -1, 2, 1}, 1)<<endl;
    }
};

class Solution512 {
//  Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//Note: The input string may contain letters other than the parentheses ( and ).
//Examples:
//  "()())()" -> ["()()()", "(())()"]
//  "(a)())()" -> ["(a)()()", "(a())()"]
//  ")(" -> [""]
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> result;
        dfsHelper(result, s, 0, ')');
        return result;
    }
    vector<string> removeInvalidParentheses1(string s) {
        vector<string> result;
        set<string> visit;
        if (s.empty()) {
            return result;
        }
        queue<string> que;
        string temp;
        que.push(s);
        visit.insert(s);
        bool level=false;
        while (!que.empty()) {
            s=que.front(); que.pop();
            if (isValidString(s)) {
                result.push_back(s);
                level=true;
            }
            if (level) {
                continue;
            }
            for (int i=0; i<s.size(); i++) {
                if (s[i]!='(' && s[i]!=')') {
                    continue;
                }
                temp=s.substr(0, i) + s.substr(i+1);
                if (visit.find(temp)==visit.end()) {
                    que.push(temp);
                    visit.insert(temp);
                }
            }
            
        }
        return result;
    }
    
    bool isValidString(string s) {
        int cnt=0;
        for (int i=0; i<s.size(); i++) {
            if (s[i]=='(') {
                cnt++;
            }
            else if (s[i]==')') {
                cnt--;
            }
            if (cnt<0) {
                return false;
            }
        }
        return cnt==0;
    }
    
    void dfsHelper(vector<string>& result, string s, int start, char right) {
        for (int i=0, cnt=0; i<s.size(); i++) {
            if (s[i]=='(' || s[i]==')') {
                s[i]==right?cnt++:cnt--;
            }
            if (cnt<=0) {
                continue;
            }
            for (int j=start; j<=i; j++) {
                if (s[j]==right && (j==start || s[j-1]!=right)) {
                    dfsHelper(result, s.substr(0, j)+s.substr(j+1), j, right);
                }
            }
            return;
        }
        reverse(s.begin(), s.end());
        if (right==')') {
            return dfsHelper(result, s, 0, '(');
        }
        result.push_back(s);
    }
    
    void test() {
        vector<string> result;
        result=removeInvalidParentheses("()())()");
        for (auto i : result) {
            cout<<i<<endl;
        }
        result=removeInvalidParentheses("(a)())()");
        for (auto i : result) {
            cout<<i<<endl;
        }
        result=removeInvalidParentheses(")(");
        for (auto i : result) {
            cout<<i<<endl;
        }
        result=removeInvalidParentheses1("(a)())()");
        for (auto i : result) {
            cout<<i<<endl;
        }
    }
};

class Solution513 {
public:
//     Sparse Matrix Multiplication
    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
        int m=A.size(), n=A[0].size(), nb=B[0].size();
        vector<vector<int>> C(m, vector<int>(nb, 0));
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (A[i][j]!=0) {
                    for (int k=0; k<nb; k++) {
                        if (B[j][k]!=0) {
                            C[i][k]+=A[i][j]*B[j][k];
                        }
                    }
                }
            }
        }
        return C;
    }
};

class Solution514 {
public:
    void printVertical(TreeNode* root, int dist, multimap<int, int>& map) {
        if (root==nullptr)
        {
            return;
        }
        map.insert({dist, root->value});
        printVertical(root->left, dist-1, map);
        printVertical(root->right, dist+1, map);
    }
    
    void printVertical(TreeNode* root) {
        multimap<int, int> map;
        printVertical(root, 0, map);
        int temp=0;
        for (auto it = map.begin(); it != map.end(); ++it)
        {
            if (temp!=it->first)
            {
                cout<<endl;
                temp=it->first;
            }
            cout<<it->second<<" ";
        }
    }
    
    void test() {
        TreeNode* t1= new TreeNode(1);
        TreeNode* t2= new TreeNode(2);
        TreeNode* t3= new TreeNode(3);
        TreeNode* t8= new TreeNode(8);
        TreeNode* t5= new TreeNode(5);
        TreeNode* t6= new TreeNode(6);
        TreeNode* t7= new TreeNode(7);
        t1->left=t2;
        t1->right=t3;
        t3->left=t5;
        t3->right=t6;
        t5->left=t7;
        t5->right=t8;
        printVertical(t1);
    }
};

class Solution515 {
public:
//    Integer to English Words
    string num2str(int num) {
        string result="";
        vector<string> LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        vector<string> THOUSANDS = {"", "Thousands", "Millions", "Billions"};
        int offset=0;
        while (num) {
            result = helper(num%1000, LESS_THAN_20, TENS, THOUSANDS)+result;
            num/=1000;
            if (num>0) {
                offset++;
                result = " "+THOUSANDS[offset]+" "+result;
            }
        }
        return result;
    }
    
    string helper(int num, vector<string>& less_than_20,
                  vector<string>& tens, vector<string>& thousands) {
        if (num==0) {
            return "";
        }
        else if (num<20) {
            return less_than_20[num]+"";
        }
        else if (num<100) {
            return tens[num/10]+" "+helper(num%10, less_than_20, tens, thousands);
        }
        else {
            return less_than_20[num/100]+" Hundred " + helper(num%100, less_than_20, tens, thousands);
        }
    }
    
    void test() {
        cout<<num2str(2133939203)<<endl;
        cout<<num2str(100103)<<endl;
        cout<<num2str(19)<<endl;
    }
};

class Solution516 {
public:
//  First Bad Version
    int firstBadVersion(int n) {
        return bsHelper(1, n);
    }
    
    bool isBadVersion(int n) {
        return true;
    }
    
    int bsHelper(int left, int right) {
        int middle=left+(right-left)/2;
        if (!isBadVersion(middle)) {
            if (isBadVersion(middle-1)) {
                return middle;
            }
            return bsHelper(left, middle-1);
        }
        else {
            return bsHelper(middle+1, right);
        }
    }
};

class Solution517 {
public:
    class Interval {
    public:
        int start, end;
        Interval(int start, int end) {
            this->start=start;
            this->end=end;
        }
    };
    //Meeting Rooms II;
    int minMeetingRooms(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](Interval& a, Interval& b){return a.start<b.start;});
        priority_queue<int, vector<int>, greater<int>> mpq;
        for (int i=0; i<intervals.size(); i++) {
            if (!mpq.empty() && mpq.top()<=intervals[i].start) {
                mpq.pop();
            }
            mpq.push(intervals[i].end);
        }
        return mpq.size();
    }
    
    void test() {
        vector<Interval> data;
        data.push_back({0, 30});
        data.push_back({10, 15});
        data.push_back({15, 20});
        cout<<minMeetingRooms(data)<<endl;
    }
};

class Solution518 {
public:
    long getPowerNumber(long index) {
        long x=2;
        long n=2;
        priority_queue<long, vector<long>, greater<long>> mpq;
        unordered_map<long, int> dict;
        for (x=2; x <= index + 3; x++) {
            for (n=2; pow(x, n)<LONG_MAX; n++) {
                long curr=pow(x, n);
                if (dict[curr]==0) {
                    dict[curr]++;
                    mpq.push(curr);
                }
            }
        }
        long idx=0;
        while (idx<index && !mpq.empty()) {
            mpq.pop();
            idx++;
        }
        if (mpq.empty()) {
            return -1;
        }
        return mpq.top();
    }

    void test() {
        cout<<getPowerNumber(0)<<endl;
        cout<<getPowerNumber(1)<<endl;
        cout<<getPowerNumber(2)<<endl;
        cout<<getPowerNumber(3)<<endl;
        cout<<getPowerNumber(4)<<endl;
        cout<<getPowerNumber(5)<<endl;
        cout<<getPowerNumber(6)<<endl;
        cout<<getPowerNumber(7)<<endl;
        cout<<getPowerNumber(8)<<endl;
        cout<<getPowerNumber(9)<<endl;
        cout<<getPowerNumber(10)<<endl;
        cout<<getPowerNumber(11)<<endl;
    }
};

class Solution519 {
//    匹配
//    s =  “abc”, p = “abc”
//    s = “aaaab”, p = “a*b”
//    s = “”, p = “a*b*c*”
//    s = “abcdefg”, p = “.*”
//    不匹配
//    s = “abc”, p = “a*”
//    s = “”, p = “ab*”
private:
    bool dfs(string s, string p) {
        //空的regexp 只能匹配空字符串
        if (p.empty()) {
            return s.empty();
        }
        char c=p[0];
        //第二个字符为*
        if (p.size()>1 && p[1]=='*') {
            int k=0;
            //枚举所有匹配前两个字符的前缀，剩下部分是子问题
            //这里用do-while而不是while 为了处理好match empty prefix
            do {
                if (dfs(s.substr(k), p.substr(2))) {
                    return true;
                }
            } while(k<s.size() && match(s[k++], c));
            return false;
        }
        //第二个字符不为*
        return !s.empty() && match(s[0], c) && dfs(s.substr(1), p.substr(1));
    }
    
    bool match(char c, char p) {
        return p=='.'?true:p==c;
    }
    
    bool dfs1(string s, string p) {
        if (p.empty()) {
            return s.empty();
        }
        char c=p[0];
        if (p.size()>1 && p[1]=='*') {
            return dfs1(s, p.substr(2)) ||
                       (!s.empty() && match(s[0], c) && dfs1(s.substr(1), p));
        }
        return !s.empty() && match(s[0], c) && dfs1(s.substr(1), p.substr(1));
    }
    
    bool dfs2(string s, int i, string p, int j) {
        if (j==p.size()) {
            return i==s.size();
        }
        char c=p[j];
        if (j+1 < p.size() && p[j+1]=='*') {
            return dfs2(s, i, p, j+2) ||
            (i<s.size() && match(s[i], c) && dfs2(s, i+1, p, j));
        }
        return i<s.size() && match(s[i], c) && dfs2(s, i+1, p, j+1);
    }
    
    bool dfs3(string s, int i, string p, int j, vector<vector<bool>>& memo) {
        if (j==p.size()) {
            return i==s.size();
        }
        if (memo[i][j]!=false) {
            return memo[i][j];
        }
        char c=p[j];
        if (j+1<p.size() && p[j+1]=='*') {
            memo[i][j]=dfs3(s, i, p, j+2, memo) ||
            (i<s.size() && match(s[i], c) && dfs3(s, i+1, p, j, memo));
            return memo[i][j];
        }
        memo[i][j]=i<s.size() && match(s[i], c) && dfs3(s, i+1, p, j+1, memo);
        return memo[i][j];
    }
    
    bool isMatch(string s, string p) {
        vector<vector<bool>> dp(s.size()+1, vector<bool>(p.size()+1, false));
        for (int i=s.size(); i>=0; i--) {
            for (int j=p.size(); j>=0; j--) {
                if (j==p.size()) {
                    dp[i][j]=i==s.size();
                }
                else {
                    char c=p[j];
                    if (j+1<p.size() && p[j+1]=='*') {
                        dp[i][j]=dp[i][j+2] ||
                        (i!=s.size() && match(s[i], c) && dp[i+1][j]);
                    }
                    else {
                        dp[i][j]=i!=s.size() && match(s[i], c) && dp[i+1][j+1];
                    }
                }
            }
        }
        return dp[0][0];
    }
    
    bool isMatch2(string s, string p) {
        vector<vector<bool>> dp(2, vector<bool>(p.size()+1));
        for (int i=s.size(); i>=0; i--) {
            for (int j=p.size(); j>=0; j--) {
                if (j==p.size()) {
                    dp[i%2][j]=i==s.size();
                }
                else {
                    char c=p[j];
                    if (j+1<p.size() && p[j+1]=='*') {
                        dp[i%2][j]==dp[i%2][j+2] ||
                        (i!=s.size() && match(s[i], c) && dp[(i+1)%2][j]);
                    }
                    else {
                        dp[i%2][j]=i!=s.size() && match(s[i], c) && dp[(i+1)%2][j+1];
                    }
                }
            }
        }
        return dp[0][0];
    }
public:
    void test() {
        string s="";
        string p="ab";
        cout<<isMatch(s, p)<<endl;
        cout<<isMatch2(s, p)<<endl;
    }
};

class Solution520 {
//  Given a 2D array of either '\' or '/', find out how many pieces this rectangle is divided into graphically.
//  For a 2X2 matrix with
//    /\
//    \/
//  The matrix split into 5 pieces - the diamond in middle and the four corners. Return 5 as the answer.
private:
    int segmentCount(vector<vector<char>> m) {
        int rows=m.size(), cols=m[0].size();
        vector<vector<bool>> upperHalf(rows, vector<bool>(cols));
        vector<vector<bool>> lowerHalf(rows, vector<bool>(cols));
        int count=0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (!upperHalf[i][j]) {
                    count++;
                    dfs(m, upperHalf, lowerHalf, i, j, 0);
                }
                if (!lowerHalf[i][j]) {
                    count++;
                    dfs(m, upperHalf, lowerHalf, i, j, 1);
                }
            }
        }
        return count;
    }
    // position:upper:0, lower:1, left:2, right:3
    // In this graph every node has at most 2 edges. Every position (x, y) has 2 nodes.
    // If it's a '/' in (x, y) and current node is upper half of (x,y), the next two nodes to search is right half of (x - 1, y) and lower half of (x, y - 1).
    void dfs(vector<vector<char>>& m,
             vector<vector<bool>>& upperHalf, vector<vector<bool>>& lowerHalf,
             int i, int j, int position) {
        if (i<0 || i>=m.size() || j<0 || j>=m[0].size()) {
            return;
        }
        if ((position==2 && m[i][j]=='\\') || (position==3 && m[i][j]=='/')) {
            position=1;
        }
        if ((position==2 && m[i][j]=='/') || (position==3 && m[i][j]=='\\')) {
            position=0;
        }
        if ((position==0 && upperHalf[i][j]) || (position==1 && lowerHalf[i][j])) {
            return;
        }
        if (position==0) {
            upperHalf[i][j]=true;
        }
        else {
            lowerHalf[i][j]=true;
        }
        if (position==0 && m[i][j]=='\\') {
            dfs(m, upperHalf, lowerHalf, i, j+1, 2);    //go right
            dfs(m, upperHalf, lowerHalf, i-1, j, 1);    //go up
        }
        if (position==0 && m[i][j]=='/') {
            dfs(m, upperHalf, lowerHalf, i, j-1, 3);    //go left
            dfs(m, upperHalf, lowerHalf, i-1, j, 1);    //go up;
        }
        if (position==1 && m[i][j]=='\\') {
            dfs(m, upperHalf, lowerHalf, i, j-1, 3);    //go left
            dfs(m, upperHalf, lowerHalf, i+1, j, 0);    //go down
        }
        if (position==1 && m[i][j]=='/') {
            dfs(m, upperHalf, lowerHalf, i, j+1, 2);    //go right
            dfs(m, upperHalf, lowerHalf, i+1, j, 0);    //go down
        }
    }
public:
    void test() {
        vector<vector<char>> input={{'/', '\\'}, {'\\', '/'}};
        cout<<segmentCount(input)<<endl;
    }
};

class Solution521 {
// finding the longest (number of characters) absolute path to a file within our file system.
// For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
private:
public:
    int lengthLongestPath(string input) {
        int leng=input.size();
        vector<int> levels(200, 0);
        int lv=0;
        bool isFile=false;
        int count=0;
        int result=0;
        // dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
        // =\n end
        // =\t level++
        // =.
        //     result=0;
        for (int i=0; i<leng; i++) {
            //find which level
            while (input[i]=='\t') {
                lv++;
                i++;
            }
            while (input[i]!='\n' && i<leng) {
                if (input[i]=='.') {
                    isFile=true;
                }
                count++;
                i++;
            }
            if (isFile) {
                result=max(result, levels[lv-1]+count);
            }
            else {
                levels[lv]=levels[lv-1]+count+1;
            }
            lv=0; isFile=false; count=0;
        }
        return result;
    }
};

class Solution522 {
//  word break
private:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }
        vector<bool> dp(s.size()+1, false);
        dp[0] = true;
        for (int i = 1; i <= s.size(); ++i) {
            for (int j = i-1; j >= 0; --j) {
                if (dp[j]) {
                    string word=s.substr(j, i-j);
                    if (wordDict.count(word)>0) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < dp.size(); ++i) {
            cout<<dp[i]<<" ";
        }
        return dp.back();
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        if (wordDict.size() == 0) {
            return {};
        }
        unordered_set<string> lookup;
        for (auto i:wordDict) {
            lookup.insert(i);
        }
        vector<string> result;
        string combo="";
        wordBreakHelper(s, 0, combo, lookup, result);
        return result;
    }

    void wordBreakHelper(string s, int index, string& combo, unordered_set<string>& lookup, vector<string>& result) {
        if (index == s.size()) {
            combo.pop_back();   //delete last space
            result.push_back(combo);
            combo.clear();  //restart new backtracking
            return;
        }
        for (int i = index+1; i <= s.size(); ++i) {
            string word=s.substr(index, i-index);
            if (lookup.count(word)>0) {
                combo += word;
                combo += " ";
                wordBreakHelper(s, i, combo, lookup, result);
            }
        }
    }
public:
    void test() {
        string s="catsanddog";
        vector<string> dict={"cat", "cats", "and", "sand", "dog"};
        vector<string> result=wordBreak(s, dict);
        for (auto ss : result) {
            cout<<ss<<endl;
        }
    }
};

class Solution523 {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if (board.size()==0) {
            return;
        }
        solve(board);
    }
    
    void test() {
        vector<string> data;
        data = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        vector<vector<char>> array;
        for (int i=0; i<data.size(); i++) {
            vector<char> v(data[i].c_str(), data[i].c_str()+data[i].length()+1);
            array.push_back(v);
        }
        solveSudoku(array);
        for (int i=0; i<array.size(); i++) {
            for (int j=0; j<array[0].size(); j++) {
                cout<<array[i][j]<<" ";
            }
            cout<<endl;
        }
        
    }
private:
    bool solve(vector<vector<char>>& board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j]=='.') {
                    for (char d='1'; d<='9'; d++) {
                        if (valid(board, i, j, d)) {
                            board[i][j]=d;
                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    bool valid(vector<vector<char>>& board, int m, int n, char c) {
        for (int row=0; row<9; row++) {
            if (board[row][n]==c) {
                return false;
            }
        }
        for (int col=0; col<9; col++) {
            if (board[m][col]==c) {
                return false;
            }
        }
        for (int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                if (board[row+m/3*3][col+n/3*3]==c) {
                    return false;
                }
            }
        }
        return true;
    }
};

class Solution524 {
//    str = "aabbcc", k = 3
//    Result: "abcabc"
//    str = "aaadbbcc", k = 2
//    Answer: "abacabcd"
//    Another possible answer is: "abcabcda"
private:
    string rearrangeString(string str, int k) {
        if (k==0) {
            return str;
        }
        string result;
        int leng=str.size();
        unordered_map<char, int> dict;
        priority_queue<pair<int, char>> pq;
        for (auto a : str) {
            dict[a]++;
        }
        for (auto it=dict.begin(); it!=dict.end(); it++) {
            pq.push({it->second, it->first});
        }
        while (!pq.empty()) {
            int cnt=min(k, leng);
            vector<pair<int, char>> remains;
            for (int i=0; i<cnt; i++) {
                if (pq.empty()) {
                    return "";
                }
                auto t=pq.top();
                pq.pop();
                result.push_back(t.second);
                if(--t.first>0) {
                    remains.push_back(t);
                };
                leng--;
            }
            for (auto j : remains) {
                pq.push(j);
            }
        }
        return result;
    }
public:
    void test() {
        string str="aaaadbbcc";
        int k=2;
        cout<<rearrangeString(str, 2)<<endl;
    }
};

class Solution525 {
//    gift wrapping algorithm
//    Jarvis’s Algorithm or Wrapping
public:
    struct Point {
        int x, y;
    };
    // To find orientation of ordered triplet (p, q, r).
    // The function returns following values
    // 0 --> p, q and r are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    int orientation(Point p, Point q, Point r) {
        int val = (q.y-p.y)*(r.x-q.x) - (q.x-p.x)*(r.y-q.y);
        if (val==0) {
            return 0;
        }
        return val > 0 ? 1 : 2;
    }
    
    void convexHull(vector<Point> points, int n) {
        if (n<3) {
            return;
        }
        vector<Point> hull;
        int l=0;
        for (int i=1; i<n; i++) {
            if (points[i].x<points[l].x) {
                l=i;
            }
        }
        int p=l, q;
        do {
            hull.push_back(points[p]);
            q=(p+1)%n;
            for (int i=0; i<n; i++) {
                // If i is more counterclockwise than current q, then update q
                if (orientation(points[p], points[i], points[q])==2) {
                    q=i;
                }
            }
            p=q;
        } while(p!=l);
        
        for (int i=0; i<hull.size(); i++) {
            cout<<"(" << hull[i].x << ", "<< hull[i].y << ")\n";
        }
    }
    
    void test() {
        vector<Point> points={{0, 3}, {2, 2}, {1, 1}, {2, 1},
            {3, 0}, {0, 0}, {3, 3}};
        int n = points.size();
        convexHull(points, n);
    }
};

class Solution999 {
public:
    class topoSort {
    public:
        vector<int> findOrder(int numCourses, vector<vector<int>> prerequisites) {
            vector<int> result(numCourses, 0);
            if (numCourses==0) {
                return result;
            }
            vector<int> indegrees(numCourses, 0);
            vector<vector<int>> graph;
            buildGraph(numCourses, prerequisites, graph, indegrees);
            queue<int> myque;
            for (int i=0; i<numCourses; i++) {
                if (indegrees[i]==0) {
                    myque.push(i);
                }
            }
            int index=0;
            while (!myque.empty()) {
                int temp=myque.front();   myque.pop();
                result[index++]=temp;
                vector<int> children=graph[temp];
                for (auto child:children) {
                    indegrees[child]--;
                    if (indegrees[child]==0) {
                        myque.push(child);
                    }
                }
            }
            if (index==numCourses) {
                return result;
            }
            else {
                return {};
            }
        }
    private:
        void buildGraph(int Courses, vector<vector<int>>& prerequisites, vector<vector<int>>& graph, vector<int>& indegrees) {
            for (int i=0; i<Courses; i++) {
                graph.push_back({});
            }
            for (auto pre : prerequisites) {
                graph[pre[1]].push_back(pre[0]);
                indegrees[pre[0]]++;
            }
        }
    };
    class vector2D {
    public:
        vector2D(vector<vector<int>>& vec2d) {
            if (vec2d.size()==0) {
                return;
            }
            it1=vec2d.begin();
            ite=vec2d.end();
            it2=(*it1).begin();
            
        }
        int next() {
            return *it2++;
        }
        
        bool hasNext() {
            while (it1!=ite && it2==(*it1).end()) {
                it1++;
                it2=(*it1).begin();
                
            }
            return it1!=ite;
        }
        
    private:
        vector<vector<int>>::iterator it1, ite;
        vector<int>::iterator it2;
    };
    //    Given a sorted integer array without duplicates, return the summary of its ranges
    //    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
    
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ans;
        for(int i=0;i<nums.size();)
        {
            int start = i;
            while(i+1<nums.size() && nums[i+1]-nums[i]==1) {
                i++;
            }
            if(nums[i]>nums[start]) {
                //cout<<to_string(nums[start])+"->"+to_string(nums[i]);
                ans.push_back(to_string(nums[start])+"->"+to_string(nums[i]));
            }
            else if(nums[i]==nums[start]) {
                //cout<<to_string(nums[i]);
                ans.push_back(to_string(nums[i]));
            }
            i++;
        }
        return ans;
    }
    //    intersection A: [ {name: "road1", cost: 3, destination: "intersection B"}, {name: "road2", cost: 2, destination: "intersection B"}, {name: "road3", cost: 1, destination: "intersection B"} ]
    //    intersection B: [ {name: "road4", cost: 4, destination: "intersection C"} ]
    //    intersection C: []. more info on 1point3acres.com
    //
    //    最短路径从A到C：road3 -> road4
    vector<string> getPath(unordered_map<string, unordered_map<string, pair<string, int> > >& mp, const string& start, const string& end) {
        unordered_map<string, int> dist;
        unordered_set<string> q;
        for (const auto& p: mp) {
            dist[p.first] = INT_MAX;
            q.insert(p.first);
        }
        dist[start] = 0;
        unordered_map<string, string> previous;
        if (mp.count(start) == 0 || start == end) {
            return {};
        }
        while (not q.empty()) {
            string cur;
            int curDist = INT_MAX;
            for (const string& s: q) {
                if (dist[s] < curDist) {
                    curDist = dist[s];
                    cur = s;
                }
            }
            for (auto p: mp[cur]) {
                if (dist[p.first]> dist[cur] + p.second.second) {
                    dist[p.first] = dist[cur] + p.second.second;
                    previous[p.first] = cur;
                }
            }
            q.erase(cur);
        }
        vector<string> res;
        string tmp = end;
        while (tmp != start) {
            res.push_back(mp[previous[tmp]][tmp].first);
            tmp = previous[tmp];
        }
        reverse(res.begin(), res.end());
        return res;
    }
    
    //Insert Into Cycle Linked List
    ListNode* insertNode(ListNode* head, int val) {
        // 如果原本head为空，添加新的节点，next指向自己
        if (head == NULL) {
            ListNode *node = new ListNode(val);
            node->next = node;
            return node;
        }
        
        ListNode *cur = head;
        
        do {
            //如果val的值正好介于两个节点之间，结束循环，等号是有必要的
            if (val >= cur->value && val <= cur->next->value)
                break;
            // 如果正好是排序链断开处
            if (cur->value > cur->next->value && (val < cur->next->value || val > cur->value))
                break;
            // 否则继续往下找
            cur = cur->next;
        } while (cur != head);
        // 循环直到又到head
        
        //插入新节点
        ListNode *newNode = new ListNode(val);
        newNode->next = cur->next;
        cur->next = newNode;
        return newNode;
    }
    //  meeting overlap
    //  The number of minutes in a day is constant. Create an array of size 60*24 minutes in a day. Mark true on meeting schedules.
    bool meetingOverlap(vector<vector<int>> meetings) {
        vector<bool> schedule(24*60, false);
        for (auto time: meetings) {
            for (int i=time[0]; i<time[1]; i++) {
                if (schedule[i]==true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    void subset_sum(vector<int>& s, vector<int>& t, int sizes, int sizet, int sum, int ite, int target, int& nodes) {
        nodes++;
        if (target==sum) {
            //handle t
            if (ite+1<sizes && sum-s[ite]+s[ite+1]<=target) {
                subset_sum(s, t, sizes, sizet-1, sum-s[ite], ite+1, target, nodes);
            }
            return;
        }
        else {
            if (ite<sizes && sum+s[ite]<=target) {
                for (int i=ite; i<sizes; i++) {
                    t[sizet]=s[i];
                    if (sum+s[i]<=target) {
                        subset_sum(s, t, sizes, sizet+1, sum+s[i], i+1, target, nodes);
                    }
                }
            }
        }
    }
    
    //  Subset sum. Follow-up: Optimize the solution.
    void generateSubsets(vector<int>& s, int size, int target) {
        vector<int> tuplet(size, 0);
        int total=0;
        sort(s.begin(), s.end(), [](int a, int b){return a>b;});
        for (int i=0; i<size; i++) {
            total+=s[i];
        }
        int nodes=0;
        if (s[0] <= target && total >= target) {
            subset_sum(s, tuplet, size, 0, 0, 0, target, nodes);
        }
    }    //    void sortColors(vector<int>& A, int n) {
    //        int red = 0, blue = n-1;
    //        int i = 0;
    //        while (i <= blue) {
    //            if(A[i] == 0) {//red
    //                swap(A[red], A[i]);
    //                red++;
    //                i++;
    //
    //            }
    //            else if(A[i]==2) {//blue
    //                swap(A[blue], A[i]);
    //                blue--;
    //            }
    //            else {
    //                i++;
    //            }
    //        }
    //    }
    //
    //    void sortColors(vector<vector<int>>& A, int m, int n) {
    //        int red=0, blue=m*n-1, i=0;
    //        while (i<=blue) {
    //            int row=i/m, col=i%n;
    //            if(A[row][col] == 0) {
    //                //red
    //                swap(A[red/m][red%n], A[row][col]);
    //                i++;
    //                red++;
    //            }
    //            else if(A[row][col] == 2) {
    //                //blue
    //                swap(A[blue/m][blue%n], A[row][col]);
    //                blue--;
    //            }
    //            else {
    //                i++;
    //            }
    //        }
    //    }
    //
    //
    //    int findOptimal(int n) {
    //        if (n<=6) {
    //            return n;
    //        }
    //        int result=0;
    //        int b=0;
    //        for (b = n-3-1; b >= 1; --b) {
    //            int curr=(n-b-1)*findOptimal(b);
    //            if (curr > result) {
    //                result = curr;
    //            }
    //        }
    //        return result;
    //    }
    //    // Only +, - ,(, ), empty
    //    int Calculate1(string s) {
    //        int sign=-1, result=0;
    //        stack<int> stk;
    //        for (int i = 0; i < s.size(); ++i) {
    //            if (isdigit(s[i])) {
    //                int sum=s[i]-'0';
    //                while (i+1 < s.size() && isdigit(s[i+1])) {
    //                    sum = sum * 10 + s[i+1] - '0';
    //                    i++;
    //                }
    //                result = result + sum * sign;
    //            }
    //            else if (s[i] == '+') {
    //                sign = 1;
    //            }
    //            else if (s[i] == '-') {
    //                sign = -1;
    //            }
    //            else if (s[i] == '(') {
    //                stk.push(result);
    //                stk.push(sign);
    //                result = 0;
    //                sign = 1;
    //            }
    //            else if (s[i] == ')') {
    //                result = result*stk.top();
    //                stk.pop();
    //                result += stk.top();
    //                stk.pop();
    //            }
    //        }
    //        return result;
    //    }
    //
    //    // Only +, - , *, /, empty
    //    int Calculate2(string s) {
    //        if (s.size()<=0) {
    //            return 0;
    //        }
    //        stack<int> stk;
    //        int num=0;
    //        char sign='+';
    //        for (int i=0; i<s.size(); ++i) {
    //            if (isdigit(s[i])) {
    //                num = num*10 + s[i] - '0';
    //                if (num > INT_MAX) {
    //                    num = INT_MAX;
    //                }
    //            }
    //            if ((!isdigit(s[i]) && s[i] != ' ' ) || i == s.size()-1) {
    //                if (sign == '+') {
    //                    stk.push(num);
    //                }
    //                else if (sign == '-') {
    //                    stk.push(-num);
    //                }
    //                else if (sign == '*') {
    //                    int top=stk.top();
    //                    stk.pop();
    //                    stk.push(top * num);
    //                }
    //                else if (sign == '/') {
    //                    int top=stk.top();
    //                    stk.pop();
    //                    stk.push(top / num);
    //                }
    //                //reset
    //                sign = s[i];
    //                num = 0;
    //            }
    //        }
    //        //sum up
    //        int res=0;
    //        while (!stk.empty()) {
    //            res += stk.top();
    //            stk.pop();
    //        }
    //        return res;
    //    }
    //
    //    //    int Calculate3(string s) {
    //    //        if (s.size() <= 0) {
    //    //            return 0;
    //    //        }
    //    //        stack<int> stk;
    //    //        int num = 0;
    //    //        char sign = '+';
    //    //        int res = 0;
    //    //        for (int i = 0; i < s.size(); ++i) {
    //    //            char cur = s[i];
    //    //            if (isdigit(cur)) {
    //    //                num = num * 10 + cur - '0';
    //    //                if (num > INT_MAX) {
    //    //                    num = INT_MAX;
    //    //                }
    //    //            }
    //    //            if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == s.size()-1) {
    //    //                if (sign == '+' || sign == '-') {
    //    //                    int tmp = sign == '+' ? num : -num;
    //    //                    stk.push(tmp);
    //    //                    res += tmp;
    //    //                }
    //    //                else {
    //    //                    res = res - stk.top();
    //    //                    stk.pop();
    //    //                    int tmp = sign == '*' ? res * stk.top() : stk.top() / num;
    //    //                    stk.pop();
    //    //                    stk.push(tmp);
    //    //                    res = res + tmp;
    //    //                }
    //    //                sign = cur;
    //    //                num = 0;
    //    //            }
    //    //        }
    //    //        return res;
    //    //    }
    //
    //    //+, -, *, /, allowed negative after sign
    //    int Calculate4(string s) {
    //        if (s.size()<=0) {
    //            return 0;
    //        }
    //        int num = 0;
    //        char sign = '+';
    //        int negative = 1;
    //        stack<int> stk;
    //        for (int i = 0; i < s.size(); ++i) {
    //            if (isdigit(s[i])) {
    //                num = num * 10 + s[i] - '0';
    //                if (num > INT_MAX) {
    //                    num =INT_MAX;
    //                }
    //            }
    //            if (s[i] != ' ' && (i == s.size() -1  || !isdigit(s[i]))) {
    //                //Handle 3+-10 => 3+(-10) case
    //                if (s[i] == '-' && (i==0 || !isdigit(s[i-1]))) {
    //                    negative = -1;
    //                    continue;
    //                }
    //                if (sign == '+') {
    //                    stk.push(negative * num);
    //                }
    //                else if (sign == '-') {
    //                    stk.push(negative * -1 * num);
    //                }
    //                else if (sign == '*') {
    //                    int tmp = stk.top();
    //                    stk.pop();
    //                    stk.push(tmp * num * negative);
    //                }
    //                else if (sign == '/') {
    //                    int tmp = stk.top();
    //                    stk.pop();
    //                    stk.push(tmp / (negative * num));
    //                }
    //                //reset
    //                num = 0;
    //                negative = 1;
    //                sign = s[i];
    //            }
    //        }
    //        //sum up
    //        int res = 0;
    //        while (!stk.empty()) {
    //            res += stk.top();
    //            stk.pop();
    //        }
    //        return res;
    //    }
    //
    //    //Case 4 +，-， *， /， (, ) Case
    //    int Calculate5(string s) {
    //        if (s.size() <= 0) {
    //            return 0;
    //        }
    //        stack<int> stk;
    //        int num = 0;
    //        char sign = '+';
    //        int negative = 1;
    //        for (int i = 0; i < s.size(); ++i) {
    //            if (isdigit(s[i])) {
    //                num = num * 10 + s[i] - '0';
    //                if (num > INT_MAX) {
    //                    num = INT_MAX;
    //                }
    //            }
    //            if (s[i] != ' ' && (i == s.size() - 1 || !isdigit(s[i]))) {
    //                //Handle 3+-10 => 3+(-10) case
    //                if (s[i] == '-' && (i == 0 || !isdigit(s[i-1]))) {
    //                    negative = -1;
    //                    continue;
    //                }
    //                if (s[i] == '(') {
    //                    int count = 1;
    //                    int start = i;
    //                    int leng = 0;
    //                    i++;
    //                    while (i < s.size() && count > 0) {
    //                        if (s[i] == '(') {
    //                            count++;
    //                        }
    //                        else if (s[i] == ')') {
    //                            count--;
    //                        }
    //                        i++;
    //                        leng++;
    //                    }
    //                    //excute last ')'
    //                    i = i - 1;
    //                    leng--;
    //                    string curr= s.substr(start+1, leng);
    //                    num = Calculate5(curr);
    //                    if (i == s.size() - 1) {
    //                        i = i - 1;
    //                    }
    //                    continue;
    //                }
    //                if (sign == '+') {
    //                    stk.push(negative * num);
    //                }
    //                else if (sign == '-') {
    //                    stk.push(negative * -1 * num);
    //                }
    //                else if (sign == '*') {
    //                    int tmp = stk.top();
    //                    stk.pop();
    //                    stk.push(tmp * negative * num);
    //                }
    //                else if (sign == '/') {
    //                    int tmp = stk.top();
    //                    stk.pop();
    //                    stk.push(tmp / (negative * num));
    //                }
    //
    //                //reset
    //                num = 0;
    //                negative = 1;
    //                sign = s[i];
    //            }
    //        }
    //        int res = 0;
    //        while (!stk.empty()) {
    //            res += stk.top();
    //            stk.pop();
    //        }
    //        return res;
    //    }
    //
    //    void helper(stack<int>& nums, stack<char>& oprs) {
    //        int a = nums.top(); nums.pop();
    //        int b = nums.top(); nums.pop();
    //        char p = oprs.top(); oprs.pop();
    //        if (p == '+') {
    //            nums.push(b + a);
    //        }
    //        else if (p == '-') {
    //            nums.push(b - a);
    //        }
    //        else if (p == '*') {
    //            nums.push(b * a);
    //        }
    //        else if (p == '/') {
    //            nums.push(b / a);
    //        }
    //        else if (p == '^') {
    //            nums.push(pow(b, a));
    //        }
    //        return;
    //    }
    //
    //    //Case 5  Only +, -, *, / and ^
    //    int Calculate6(string s) {
    //        if (s.size()<=0) {
    //            return 0;
    //        }
    //        int num = 0;
    //        stack<int> nums;
    //        stack<char> oprs;
    //        unordered_map<char, int> dict;
    //        dict['+']=1;
    //        dict['-']=1;
    //        dict['*']=2;
    //        dict['/']=2;
    //        dict['^']=3;
    //        for (int i = 0; i < s.size(); ++i) {
    //            if (isdigit(s[i])) {
    //                num = num * 10 + s[i] - '0';
    //            }
    //            else if(s[i] != ' ') {
    //                nums.push(num);
    //                num = 0;
    //                //Empty case or Curr operator's level > top of opStack
    //                if (oprs.size() == 0 || dict[s[i]] > dict[oprs.top()]) {
    //                    oprs.push(s[i]);
    //                }
    //                else {
    //                    while (!oprs.empty() && dict[s[i]] <= dict[oprs.top()]) {
    //                        helper(nums, oprs);
    //                    }
    //                    oprs.push(s[i]);
    //                }
    //            }
    //        }
    //        nums.push(num);
    //        while (!oprs.empty()) {
    //            helper(nums, oprs);
    //        }
    //        return nums.top();
    //    }
    //    //Medean of 2 sorted array
    //    double findMedian(vector<int>& a, vector<int>& b) {
    //        int m = a.size(), n = b.size();
    //        int total = m + n;
    //        if (total % 2 != 0) {
    //            return findKth(a, 0, b, 0, total/2 + 1);
    //        }
    //        else {
    //            return (findKth(a, 0, b, 0, total/2) +
    //                    findKth(a, 0, b, 0, total/2 + 1)) / 2.0;
    //        }
    //    }
    //
    //    double findKth(vector<int>& a, int m, vector<int>& b, int n, int k) {
    //        if (m >= a.size()) {
    //            return b[n+k-1];
    //        }
    //        if (n >= b.size()) {
    //            return a[m+k-1];
    //        }
    //        if (k == 1) {
    //            return min(a[m], b[n]);
    //        }
    //        int ap=m + k/2 - 1 >= a.size() ? INT_MAX : a[m+k/2-1];
    //        int bp=n + k/2 - 1 >= b.size() ? INT_MAX : b[n+k/2-1];
    //        if (ap<bp) {
    //            return findKth(a, m+k/2, b, n, k-k/2);
    //        }
    //        else {
    //            return findKth(a, m, b, n+k/2, k-k/2);
    //        }
    //    }
    //    //second largest in BST
    //    void inOrder(struct TreeNode* root, int& pre, int& prepre) {
    //        if (root == NULL) {
    //            return;
    //        }
    //        else {
    //            inOrder(root->left, pre, prepre);
    //            prepre = pre;
    //            cout<<root->val<<" ";
    //            pre = root->val;
    //            inOrder(root->right, pre, prepre);
    //        }
    //    }
    //
    //    //Kth largest in BST with space
    //    void inOrder(struct TreeNode* root, vector<int>& pres, int& i) {
    //        if (root == NULL) {
    //            return;
    //        }
    //        else {
    //            inOrder(root->left, pres, i);
    //            cout<<root->val<<" ";
    //            pres[(i++)%3]=root->val;
    //            inOrder(root->right, pres, i);
    //        }
    //    }
    //
    //    void secondLargestHelper(struct TreeNode* root, int& c) {
    //        if (root == NULL || c >= 2) {
    //            return;
    //        }
    //        secondLargestHelper(root->right, c);
    //        c++;
    //        if (c == 2) {
    //            cout<<"2nd largest element is "<<root->val<<endl;
    //            return;
    //        }
    //        secondLargestHelper(root->left, c);
    //    }
    //
    //    void secondLargest(struct TreeNode* root) {
    //        int c = 0;
    //        secondLargestHelper(root, c);
    //    }
    //
    //    //Say the node for whose inorder suc­ces­sor needs to be find is p.
    //
    //    //Case 1 : If the p has a right child then its inorder suc­ces­sor will the left most ele­ment in the right sub tree of p.
    //
    //    //Case 2: If the p doesnt have a right child then its inorder suc­ces­sor will the one of its ances­tors, using par­ent link keep trav­el­ing up till you get the node which is the left child of its par­ent. Then this par­ent node will be the inorder successor.
    //
    //    //Case 3: if p is the right most node in the tree then its inorder suc­ces­sor will be NULL.
    //
    //    TreeNode* leftMost(TreeNode* p) {
    //        while (p->left) {
    //            p = p->left;
    //        }
    //        return p;
    //    }
    //
    //    TreeNode* inOrderSuccessor(TreeNode* p) {
    //        if (p->right) {
    //            return leftMost(p->right);
    //        }
    //        TreeNode* parent = p->parent;
    //        while (parent && p == parent->right) {
    //            p = parent;
    //            parent = parent->parent;
    //        }
    //
    //        return parent;
    //    }
    //
    //    //Find Successor, no parent point, no value to compare, but give the root of tree
    //    void inOrderTraverse(TreeNode* root, vector<TreeNode*>& inorders) {
    //        if (root == NULL) {
    //            return;
    //        }
    //        inOrderTraverse(root->left, inorders);
    //        inorders.push_back(root);
    //        inOrderTraverse(root->right, inorders);
    //    }
    //
    //    TreeNode* inOrderSuccessor(TreeNode* root, TreeNode* p) {
    //        if (p->right) {
    //            return leftMost(p);
    //        }
    //        vector<TreeNode*> inorders;
    //        inOrderTraverse(root, inorders);
    //        for (int i = 0; i < inorders.size(); ++i) {
    //            if (inorders[i] == p && i+1 < inorders.size()) {
    //                return inorders[i+1];
    //            }
    //        }
    //        return NULL;
    //    }
    //
    //    void dfs(TreeNode* root, TreeNode* p, vector<TreeNode*>& array, vector<TreeNode*>& res) {
    //        if (root == NULL) {
    //            return;
    //        }
    //        array.push_back(root);
    //        if (root == p) {
    //            res.insert(res.end(), array.begin(), array.end());
    //            return;
    //        }
    //        dfs(root->left, p, array, res);
    //        dfs(root->right, p, array, res);
    //        array.pop_back();
    //    }
    //
    //    vector<TreeNode*> getAncestors(TreeNode* root, TreeNode* p) {
    //        vector<TreeNode*> res;
    //        vector<TreeNode*> array;
    //        dfs(root, p, array, res);
    //        return res;
    //    }
    //
    //    //第二个使用了DFS Backtracking, 来寻找p到root的路径， 而且修改了找不到返回本身，
    //    //如果需要返回Null的话， 删掉temp,。总体来说跟前面差不多，少许少了些无用功
    //    TreeNode* inOrderSuccessorWithRoot(TreeNode* root, TreeNode* p) {
    //        TreeNode* temp = p;
    //        if (p != NULL && p->right != NULL) {
    //            return leftMost(p->right);
    //        }
    //        vector<TreeNode*> ancestors = getAncestors(root, p);
    //        int i = 1;
    //        while (ancestors.size() - i > 0) {
    //            TreeNode* parent = ancestors[ancestors.size()-1-i];
    //            if (parent->left == p) {
    //                return parent;
    //            }
    //            p = parent;
    //            i++;
    //        }
    //        return temp;
    //    }
    //
    //    TreeNode* rightMost(TreeNode* root) {
    //        if (root == NULL) {
    //            return NULL;
    //        }
    //        while (root->right != NULL) {
    //            root = root->right;
    //        }
    //        return root;
    //    }
    //    //Find predecessor with parent, no root
    //    TreeNode* inOrderPredecessor(TreeNode* p) {
    //        if (p==NULL) {
    //            return NULL;
    //        }
    //        if (p->left!=NULL) {
    //            return rightMost(p->left);
    //        }
    //        TreeNode* parent = p->parent;
    //        TreeNode* curr = p;
    //        while (parent != NULL && curr == parent->left) {
    //            curr = parent;
    //            parent = parent->parent;
    //        }
    //        return parent;
    //    }
    //
    //    //Inorder Successor(Predecessor) in BST
    //    //With Value and Root
    //    TreeNode* inOrderSuccessorWithRootAndValue(TreeNode* root, TreeNode* p) {
    //        TreeNode* successor = NULL;
    //        while (root!=NULL) {
    //            if (p->val < root->val) {
    //                successor = root;
    //                root = root->left;
    //            }
    //            else {
    //                root = root->right;
    //            }
    //        }
    //        return successor;
    //    }
    //
    //    TreeNode* predeccessor(TreeNode* root, TreeNode* p) {
    //        if (root == NULL) {
    //            return NULL;
    //        }
    //        if (root->val >= p->val) {
    //            return predeccessor(root->left, p);
    //        }
    //        else {
    //            TreeNode* right = predeccessor(root->right, p);
    //            return right == NULL ? root : right;
    //        }
    //    }
       //Array Update and Query
    
       //Naive
       class numArrayNaive {
       private:
           vector<int> nums;
       public:
           numArrayNaive(vector<int>& nums) {
               this->nums = nums;
           }
           void update(int i, int val) {
               this->nums[i] = val;
           }
           int sumRange(int i, int j) {
               int sum = 0;
               for (int low = i; low <= j; ++low) {
                   sum += nums[low];
               }
               return sum;
           }
       };
    
    
       void testNaive(int i) {
           vector<int> array;
           for (int j=0; j<i; ++j) {
               array.push_back(j);
           }
           numArrayNaive* nan = new numArrayNaive(array);
           cout<<nan->sumRange(3, 7);
       }
    
       //Naive with Buffer
       class numArrayBuffer {
       private:
           vector<int> nums;
           vector<long> sums;
           vector<pair<int, int>> buffer;
       public:
           numArrayBuffer(vector<int>& nums) {
               this->nums = nums;
               this->sums = vector<long>(nums.size() + 1);
               for (int i=0; i<nums.size()-1; ++i) {
                   sums[i+1]=nums[i]+sums[i];
               }
           }
    
           void update(int i, int val) {
               buffer.push_back(make_pair(i, val-nums[i]));
               nums[i] = val;
               if (buffer.size() > 300) {
                   for (int j = 0; j<nums.size()-1; ++j) {
                       sums[j+1] = nums[j] + sums[j];
                   }
               }
           }
    
           int sumRange(int i, int j) {
               long res = sums[j+1] - sums[i];
               for (int m = 0; m < buffer.size(); ++m) {
                   if (buffer[m].first <= j && buffer[m].first >= i) {
                       res += buffer[m].second;
                   }
               }
               if (res >= INT_MAX || res <= INT_MIN) {
                   throw out_of_range("error");
               }
               else {
                   return (int)res;
               }
           }
       };
    
       void testBuffer(int n) {
           vector<int> array;
           for (int j=0; j<n; ++j) {
               array.push_back(j);
           }
           numArrayBuffer* nan = new numArrayBuffer(array);
           cout<<nan->sumRange(3, 7);
       }
    
    
       //Segment Tree
       struct segmentTree {
           int start, end;
           segmentTree *left, *right;
           int sum;
           segmentTree(int s, int e): start(s), end(e) {
               left=NULL;
               right=NULL;
               sum=0;
           }
       };
    
    
       class numArrayTree {
       private:
           segmentTree* root;
    
           int sumRange(segmentTree* root, int i, int j) {
               if(root==NULL) {
                   return 0;
               }
               if (root->start == i && root->end == j) {
                   return root->sum;
               }
               else {
                   int mid = root->start + (root->end-root->start)/2;
                   if (j <= mid) {
                       return sumRange(root->left, i, j);
                   }
                   else if (i >= mid + 1) {
                       return sumRange(root->right, i, j);
                   }
                   else {
                       return sumRange(root->right, mid+1, j) +
                       sumRange(root->left, i, mid);
                   }
               }
           }
           void updateTree(segmentTree* root, int i, int val) {
               if (root->start == root->end) {
                   root->sum = val;
               }
               else {
                   int mid = root->start + (root->end - root->start)/2;
                   if (i <= mid) {
                       updateTree(root->left, i, val);
                   }
                   else {
                       updateTree(root->right, i, val);
                   }
                   root->sum = root->left->sum + root->right->sum;
               }
           }
    
           segmentTree* buildTree(vector<int>& nums, int start, int end) {
               if (start>end) {
                   return NULL;
               }
               else {
                   segmentTree* p = new segmentTree(start, end);
                   if (start == end) {
                       p->sum = nums[start];
                   }
                   else {
                       int mid = start + (end - start)/2;
                       p->left = buildTree(nums, start, mid);
                       p->right = buildTree(nums, mid+1, end);
                       if (p->left!=NULL && p->right!=NULL) {
                           p->sum = p->left->sum + p->right->sum;
                       }
                       else if (p->left!=NULL) {
                           p->sum = p->left->sum;
                       }
                       else if (p->right!=NULL) {
                           p->sum = p->right->sum;
                       }
                       else {
                           p->sum = 0;
                       }
                   }
                   return p;
               }
           }
       public:
           numArrayTree(vector<int>& array) {
               this->root = buildTree(array, 0, array.size()-1);
           }
           int sumRange(int start, int end) {
               return sumRange(root, start, end);
           }
    
           void updateTree(int i, int val) {
               updateTree(root, i, val);
           }
       };
    
       void testSegmentTree(int i) {
           vector<int> array;
           for (int j=0; j<i; ++j) {
               array.push_back(j);
           }
           numArrayTree* nat = new numArrayTree(array);
           nat->updateTree(3, 10);
           cout<<nat->sumRange(3, 7)<<endl;
       }
    
       class numArrayBIT {
       private:
           vector<int> nums;
           vector<int> bits;
           int n;
    
           void init(int i, int val) {
               i++;
               while (i<=n)  {
                   bits[i] += val;
                   i += (i & -i);
               }
           }
    
           int getSum(int i) {
               int sum=0;
               i++;
               while (i>0) {
                   sum += bits[i];
                   i = i - (i&-i);
               }
               return sum;
           }
       public:
           numArrayBIT(vector<int> nums) {
               this->nums = nums;
               n = nums.size();
               bits = vector<int>(n+1, 0);
               for (int i=0; i<n; ++i) {
                   init(i, nums[i]);
               }
           }
    
           void update(int i, int val) {
               int diff = val - nums[i];
               nums[i] = val;
               init(i, diff);
           }
    
           int sumRange(int i, int j) {
               return getSum(j) - getSum(i-1);
           }
       };
    
       void testBits(int i) {
           vector<int> array;
           for (int j=0; j<i; ++j) {
               array.push_back(j);
           }
           numArrayBIT* nab = new numArrayBIT(array);
           nab->update(3, 10);
           cout<<nab->sumRange(3, 7)<<endl;;
       }
    //Calculator series II
    //Most General Case: Can handle +, -, *, /, ^, (, ) and Negative sign
    int Calculate(string s) {
        if (s.size()<=0) {
            return 0;
        }
        int num = 0;
        int negative = 1;
        stack<int> nums;
        stack<char> oprs;
        unordered_map<char, int> dict;
        dict['+'] = 1; dict['-'] = 1;
        dict['*'] = 2; dict['/'] = 2;
        dict['^'] = 3;
        
        for (int i=0; i<s.size(); ++i) {
            char cur = s[i];
            if (isdigit(cur)) {
                num = num * 10 + cur - '0';
            }
            else if (cur != ' ') {
                if (cur == '(') {
                    int count = 1;
                    int j = i + 1;
                    int leng = 0;
                    while (j<s.size()) {
                        char now = s[j];
                        if (now == '(') {
                            count++;
                        }
                        else if (now == ')') {
                            count--;
                        }
                        if (count==0) {
                            break;
                        }
                        j++;
                        leng++;
                    }
                    int temp = Calculate(s.substr(i+1, leng)); //recursive process
                    num = temp;
                    i = j;
                    continue;
                }
                
                if (cur == '-') {
                    if (i == 0 || !isdigit(s[i-1]) && s[i-1] != ')') {
                        negative = -1;
                        continue;
                    }
                }
                nums.push(negative*num);
                num = 0;
                negative = 1;
                
                if (oprs.size() == 0 || dict[cur] > dict[oprs.top()]) {
                    oprs.push(cur);
                }
                else {
                    while (!oprs.empty() && dict[cur] <= dict[oprs.top()]) {
                        helper(nums, oprs);
                    }
                    oprs.push(cur);
                }
            }
        }
        nums.push(num);
        while (!oprs.empty()) {
            helper(nums, oprs);
        }
        cout<<nums.top()<<endl;
        return nums.top();
    }
    
    void helper(stack<int>& nums, stack<char>& oprs) {
        int b = nums.top(); nums.pop();
        int a = nums.top(); nums.pop();
        char p = oprs.top(); oprs.pop();
        
        if (p == '+') {
            nums.push(a+b);
        }
        else if (p == '-') {
            nums.push(a-b);
        }
        else if (p == '*') {
            nums.push(a*b);
        }
        else if (p == '/') {
            nums.push(a/b);
        }
        else if (p == '^') {
            nums.push(pow(a, b));
        }
        return;
    }
    
    //    GraphNode* dfsClone(GraphNode* node) {
    //        if (node == NULL) {
    //            return NULL;
    //        }
    //        GraphNode* root = new GraphNode(node->val);
    //        unordered_map<GraphNode*, GraphNode*> dict;
    //        dict[node] = root;
    //        dfsHelper(node, root, dict);
    //        return root;
    //    }
    //
    //    GraphNode* bfsClone(GraphNode* node) {
    //        if (node == NULL) {
    //            return NULL;
    //        }
    //        GraphNode* root = new GraphNode(node->val);
    //        unordered_map<GraphNode*, GraphNode*> dict;
    //        dict[node] = root;
    //        deque<GraphNode*> dq;
    //        dq.push_back(node);
    //        while (!dq.empty()) {
    //            GraphNode* curr = dq.front();
    //            dq.pop_front();
    //            for (int i=0; i<curr->neighbors.size(); ++i) {
    //                if (dict.count(curr->neighbors[i])==0) {
    //                    GraphNode* now = new GraphNode(curr->neighbors[i]->val);
    //                    dict[curr->neighbors[i]]=now;
    //                    dq.push_back(curr->neighbors[i]);
    //                }
    //                else {
    //                    dict[curr]->neighbors.push_back(dict[curr->neighbors[i]]);
    //                }
    //            }
    //        }
    //        return root;
    //    }
    //    void dfsHelper(GraphNode* node, GraphNode* root, unordered_map<GraphNode*, GraphNode*>& dict) {
    //        for (int i=0; i<(node->neighbors).size(); ++i) {
    //            if (dict[node->neighbors[i]]==NULL) {
    //                GraphNode* child = new GraphNode((node->neighbors)[i]->val);
    //                (root->neighbors).push_back(child);
    //                dict[node->neighbors[i]]=child;
    //                dfsHelper(node->neighbors[i], child, dict);
    //            }
    //            else {
    //                root->neighbors.push_back(dict[node->neighbors[i]]);
    //            }
    //        }
    //    }
    
    //    //Dijkstra: Shortest path from a source
    //    //If Given is a distance, source and total vertices's
    //    //First Missing Positive
    //    void dijkstra(vector<vector<int>>& graph, int source, int vertices) {
    //        vector<int> distance(vertices, INT_MAX);
    //        vector<bool> shortpath(vertices, false);
    //        distance[source] = 0;
    //        //Find shortest path for all vertices
    //        for (int count=0; count<vertices-1; ++count) {
    //            int u = minDistance(distance, shortpath, vertices);
    //            shortpath[u] = true;
    //            for (int v=0; v<vertices; ++v) {
    //                if (!shortpath[v] && graph[u][v]>0 && \
    //                    distance[u] != INT_MAX && distance[u]+graph[u][v] < distance[v]) {
    //                    distance[v] = distance[u] + graph[u][v];
    //                }
    //            }
    //        }
    //        output(distance, vertices);
    //    }
    //
    //    int minDistance(vector<int>& distance, vector<bool>& shortpath, int vertices) {
    //        int min = INT_MAX;
    //        int idx= 0;
    //        for (int v=0; v<vertices; ++v) {
    //            if (shortpath[v] == false && distance[v]<=min) {
    //                min = distance[v];
    //                idx = v;
    //            }
    //        }
    //        return idx;
    //    }
    //
    //    void output(vector<int>& distance, int vertices) {
    //        cout<<"Vertex        Distance from source"<<endl;
    //        for (int i=0; i<vertices; ++i) {
    //            cout<<i<<"\t   "<<distance[i]<<endl;
    //        }
    //    }
    //
    //    int firstMissingPositive(vector<int>& nums) {
    //        for (int i=0; i<nums.size();) {
    //            //1. nums[i] = i + 1 Normal case
    //            //2. nums[i] < 1; Negative number
    //            //3. nums[i] > nums.size()  Greatest value
    //            //4. nums[i == nums[nums[i] - 1] => n = nums[n+1]
    //            while (nums[i] != i+1 && nums[i]>=1 && nums[i]<=nums.size() && nums[i] != nums[nums[i]-1]) {
    //                swap(nums[nums[i]-1], nums[i]);
    //            }
    //            i++;
    //
    //        }
    //        for (int i=0; i<nums.size(); ++i) {
    //            if (nums[i]!=i+1) {
    //                return i+1;
    //            }
    //        }
    //        return nums.size()+1;
    //    }
    //
    //
    //    int firstMissingPositive(vector<int>& nums, int n) {
    //        int result=n;
    //        for (int i=n-1; i>=0; --i) {
    //            while (nums[i] != i+1 && nums[i]>=1 && nums[i]<=n && nums[i] != nums[nums[i]-1]) {
    //                swap(nums[nums[i]-1], nums[i]);
    //            }
    //            if (nums[i]!=i+1) {
    //                result=i;
    //            }
    //        }
    //        return result+1;
    //    }
    
    //    void heapify(vector<int>& array, int n, int i) {
    //        int max=i;
    //        int left=2*i+1;
    //        int right=2*i+2;
    //        if (left<n && array[left]>array[max]) {
    //            max=left;
    //        }
    //        if (right<n && array[right]>array[max]) {
    //            max=right;
    //        }
    //        if (max!=i) {
    //            swap(array[max], array[i]);
    //            heapify(array, n, max);
    //        }
    //    }
    //
    //    void heapsort(vector<int>& array, int n) {
    //        for (int i=n/2-1; i>=0; i--) {
    //            heapify(array, n, i);
    //        }
    //        for (int i=n-1; i>=0; i--) {
    //            swap(array[i], array[0]);
    //            heapify(array, n, 0);
    //        }
    //    }
    //    //Kth Largest Element
    //    //naive
    //    int findKthLargest(vector<int>& nums, int k) {
    //        int leng = nums.size();
    //        sort(nums.begin(), nums.end());
    //        return nums[leng-k];
    //    }
    //
    //    //use maxHeap
    //    int findKthLargestInHeap(vector<int>& nums, int k) {
    //        priority_queue<int, vector<int>, greater<int>> min_heap;
    //        for (int i=0; i<nums.size(); ++i) {
    //            if (min_heap.size()<k) {
    //                min_heap.push(nums[i]);
    //            }
    //            else {
    //                if (nums[i]>=min_heap.top()) {
    //                    min_heap.pop();
    //                    min_heap.push(nums[i]);
    //                }
    //            }
    //        }
    //        return min_heap.top();
    //    }
    //    //quick select
    //    int findKthLargestQuick(vector<int>& nums, int k) {
    //        if (nums.size()==1) {
    //            return nums[0];
    //        }
    //        int left=0, right=nums.size()-1;
    //        while (left<=right) {
    //            int mid = partition(nums, left, right);
    //            if (mid - left + 1 < k) {
    //                k = k - (mid - left +1);
    //                left = mid+1;
    //            }
    //            else if (mid - left + 1 > k) {
    //                right = mid - 1;
    //            }
    //            else {
    //                return nums[mid];
    //            }
    //        }
    //        return 0;
    //    }
    //    int partition(vector<int>& nums, int left, int right) {
    //        int mid = left + (right - left) / 2;
    //        int now = nums[mid];
    //        swap(nums[mid], nums[right]);
    //        int leftb = left;
    //        int rightb = right - 1;
    //        while (leftb <= rightb) {
    //            if (nums[leftb]>now) {
    //                leftb++;
    //            }
    //            else if (nums[rightb]<now) {
    //                rightb--;
    //            }
    //            else {
    //                swap(nums[leftb], nums[rightb]);
    //                leftb++;
    //                rightb--;
    //            }
    //        }
    //        swap(nums[leftb], nums[right]);
    //        return leftb;
    //    }
    
    //    //Longest Increasing Subsequence
    //    int lengthOfLIS(vector<int>& nums) {
    //        return findLength(nums, INT_MIN, 0);
    //    }
    //
    //    int dplengthOfLIS(vector<int>& nums) {
    //        int leng = nums.size();
    //        if (leng<=1) {
    //            return leng;
    //        }
    //        vector<int> dp(leng, 0);
    //        int curr=0;
    //        for (int i=0; i<leng; ++i) {
    //            dp[i]=1;
    //            for (int j=0; j<i; ++j) {
    //                if (nums[i]>nums[j]) {
    //                    dp[i]=dp[j]+1;
    //                }
    //            }
    //            curr=max(curr, dp[i]);
    //        }
    //        return curr;
    //    }
    //
    //    int dplogLengthOfLIS(vector<int>& nums) {
    //        int leng = nums.size();
    //        if (leng<=0) {
    //            return 0;
    //        }
    //        vector<int> table(leng+1, 0);
    //        int result=1;
    //        for (int i=1; i<leng; ++i) {
    //            int index=findLargestSmaller(table, 1, result, nums[i]);
    //            if (index==result) {
    //                table[++result]=nums[i];
    //            }
    //            else {
    //                table[index+1]=nums[i];
    //            }
    //        }
    //        return result;
    //    }
    //    int findLength(vector<int>& nums, int prev, int curr) {
    //        if (curr == nums.size()) {
    //            return 0;
    //        }
    //        int taken=0;
    //        if (nums[curr] > prev) {
    //            taken = 1 + findLength(nums, nums[curr], curr+1);
    //        }
    //        int notTaken = findLength(nums, prev, curr+1);
    //        return max(taken, notTaken);
    //    }
    //
    //    int findLargestSmaller(vector<int>& table, int left, int right, int target) {
    //        while (left<=right) {
    //            int mid=left+(right-left)/2;
    //            if (table[mid]>=target) {
    //                right=mid-1;
    //            }
    //            else {
    //                left=mid+1;
    //            }
    //        }
    //        return right;
    //    }
    //    struct Tuple {
    //    public:
    //        string name;
    //        int value;
    //        int maximum_stack_size;
    //        Tuple(string name, int value, int maximum_stack_size) {
    //            this->name = name;
    //            this->value = value;
    //            this->maximum_stack_size = maximum_stack_size;
    //        }
    //    };
    //    int maxValue(int n, vector<string>& stuff, vector<Tuple*>& items) {
    //        unordered_map<string, int> cnt_dict;
    //        for (auto s:stuff) {
    //            cnt_dict[s]++;
    //        }
    //        priority_queue<int, vector<int>, less<int>> max_heap;
    //        unordered_map<string, Tuple*> item_map;
    //        for (auto item:items) {
    //            item_map[item->name]=item;
    //        }
    //        for (auto it=cnt_dict.begin(); it!=cnt_dict.end(); ++it) {
    //            string key = it->first;
    //            int amt = it->second;
    //            int maxstack = item_map[key]->maximum_stack_size;
    //            int value = item_map[key]->value;
    //            if (amt>maxstack) {
    //                max_heap.push(value*maxstack);
    //                max_heap.push(value*(amt-maxstack));
    //            }
    //            else {
    //                max_heap.push(value*amt);
    //            }
    //        }
    //        int t=0, result=0;
    //        while (t<n) {
    //            result+=max_heap.top();
    //            max_heap.pop();
    //            t++;
    //        }
    //        return result;
    //    }
    //    int maxPathSum(TreeNode* root) {
    //        if (root==NULL) {
    //            return INT_MIN;
    //        }
    //        int maxsum=INT_MIN;
    //        helper(root, maxsum);
    //        return maxsum;
    //    }
    //
    //    TreeNode* buildTree(string a) {
    //        if(a.size()==0) {
    //            return NULL;
    //        }
    //        int leng = a.size();
    //        stack<TreeNode*> stk;
    //
    //        TreeNode* root=new TreeNode(a[0]);
    //        TreeNode* output=root;
    //        //   Ex 1: "a?b?c:d:e"
    //        //                |
    //        //   a
    //        // b   c
    //        bool flag=true;
    //        for(int i=1;i<leng;++i) {
    //            if(a[i]>='a' && a[i]<='z') {
    //                if(flag) {
    //                    stk.top()->left = new TreeNode(a[i]);
    //                    root=stk.top()->left;
    //                }
    //                else {
    //                    if(stk.empty()) {
    //                        stk.push(root);
    //                    }
    //                    stk.top()->right=new TreeNode(a[i]);
    //                    root=stk.top()->right;
    //                }
    //            }
    //            else if(a[i]=='?') {
    //                stk.push(root);
    //                flag=true;
    //            }
    //            else if(a[i]==':') {
    //                flag=false;
    //            }
    //        }
    //        return output;
    //    }
    //    int helper(TreeNode* root, int& maxsum) {
    //        if (root==NULL) {
    //            return 0;
    //        }
    //        int leftsum=0, rightsum=0;
    //        if (root->left!=NULL) {
    //            leftsum = helper(root->left, maxsum);
    //        }
    //        if (root->right!=NULL) {
    //            rightsum = helper(root->right, maxsum);
    //        }
    //        if (root->left && root->right) {
    //            maxsum = max(maxsum, root->val + leftsum + rightsum);
    //            return max(leftsum, rightsum) + root->val;
    //        }
    //        else if(root->left){
    //            return leftsum+root->val;
    //        }
    //        else {
    //            return rightsum+root->val;
    //        }
    //    }
    
    //    class Server {
    //    private:
    //        unordered_set<Client*> _clients;
    //
    //    public:
    //        void registerClient(Client* client) {
    //            _clients.insert(client);
    //        }
    //
    //        void unregisterClient(Client* client) {
    //            if (_clients.count(client)) _clients.erase(client);
    //        }
    //
    //        void update(string ticker) {
    //            for (auto c:_clients) c->update(ticker);
    //        }
    //    };
    //
    //    struct Comp {
    //        bool operator()(const pair<string,int>& a, const pair<string,int>& b) {
    //            return a.second > b.second;
    //        }
    //    };
    //
    //    class Client {
    //    private:
    //        string _id;
    //        unordered_map<string, int> _freq;
    //        set<pair<string,int>, Comp> _top10freq;
    //        Server* _server;
    //
    //    public:
    //        Client(string id, Server* server)
    //        :_id(id), _server(server) {
    //            if (_server) _server->registerClient(this);
    //        }
    //
    //        void registerTicker(string ticker) {
    //            if (!_freq.count(ticker)) _freq[ticker] = 0;
    //        }
    //
    //        void update(string ticker) {
    //            if (!_freq.count(ticker)) return;
    //            _freq[ticker]++;
    //            for (auto& x:_top10freq) {
    //                if (x.first == ticker) {
    //                    _top10freq.erase(x); break;
    //                }
    //            }
    //            if (_top10freq.size() < 10) _top10freq.emplace(ticker, _freq[ticker]);
    //            else if (_top10freq.rbegin()->second < _freq[ticker]) {
    //                _top10freq.erase(*_top10freq.rbegin());
    //                _top10freq.emplace(ticker, _freq[ticker]);
    //            }
    //        }
    //
    //        vector<string> getTop10freq() {
    //            vector<string> top10;
    //            for (auto& x:_top10freq) top10.push_back(x.first);
    //            return top10;
    //        }
    //    };
    //    int lengthOfLongestSubstringKDistinct(String s, int k) {
    //        if(k==0 || s==null || s.length()==0)
    //            return 0;
    //        
    //        if(s.length()<k)
    //            return s.length();
    //        
    //        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //        
    //        int maxLen=k;
    //        int left=0;
    //        for(int i=0; i<s.length(); i++){
    //            char c = s.charAt(i);
    //            if(map.containsKey(c)){
    //                map.put(c, map.get(c)+1);
    //            }else{
    //                map.put(c, 1);
    //            }
    //            
    //            if(map.size()>k){
    //                maxLen=Math.max(maxLen, i-left);
    //                
    //                while(map.size()>k){
    //                    
    //                    char fc = s.charAt(left);
    //                    if(map.get(fc)==1){
    //                        map.remove(fc);
    //                    }else{
    //                        map.put(fc, map.get(fc)-1);
    //                    }
    //                    
    //                    left++;
    //                }
    //            }
    //            
    //        }
    //        
    //        maxLen = Math.max(maxLen, s.length()-left);
    //        
    //        return maxLen;
    //    }
    //    class Singleton
    //    {
    //    private:
    //        /* Here will be the instance stored. */
    //        static Singleton* instance;
    //        
    //        /* Private constructor to prevent instancing. */
    //        Singleton();
    //        
    //    public:
    //        /* Static access method. */
    //        static Singleton* getInstance() {
    //            
    //            if (instance == 0)
    //            {
    //                instance = new Singleton();
    //            }
    //            
    //            return instance;
    //        }
    //        
    //    };
    //
    //    class prodcons {
    //        
    //        vector<int> buffer;
    //
    //        uint64_t produced_count = 0;
    //        uint64_t consumed_count = 0;
    //        mutex counts_mutex;
    //        condition_variable counts_cv;
    //
    //        void producer()
    //        {
    //            while (true) {
    //                unique_lock<mutex> counts_lock(counts_mutex);
    //                while (produced_count - consumed_count == buffer.size()) {
    //                    counts_cv.wait(counts_lock);
    //                }
    //
    //                int product = rand();
    //                buffer[produced_count++ % buffer.size()] = product;
    //                cout << "produced: " << product << "\n";
    //
    //                counts_cv.notify_all();
    //            }
    //        }
    //
    //        void consumer()
    //        {
    //            while (true) {
    //                unique_lock<mutex> counts_lock(counts_mutex);
    //                while (produced_count - consumed_count == 0) {
    //                    counts_cv.wait(counts_lock);
    //                }
    //
    //                int product = buffer[consumed_count++ % buffer.size()];
    //                cout << "consumed: " <<  product << "\n";
    //
    //                counts_cv.notify_all();
    //            }
    //        }
    //
    //        int test()
    //        {
    //            buffer.resize(16, 0);
    //             to handle the uint64_t counts overflow, the following must be true:
    //             (0xffffffffffffffff + 1) % buffer.size() == 0
    //    
    //            vector<thread> threads;
    //            for (int i = 0; i < 3; ++i) {
    //                threads.push_back(producer());
    //            }
    //            sleep(3);
    //            for (int i = 0; i < 3; ++i) {
    //                threads.push_back(consumer());
    //            }
    //            for (int i = 0; i < threads.size(); ++i) {
    //                threads[i].join();
    //            }
    //            return 0;
    //        }
    //    };
    //    int solution() {
    //        vector<int> first_3_digit(27, 0);
    //        vector<int> last_3_digit(27, 0);
    //        unordered_map<int, int> single_zero_set;
    //        for (int i=100; i<1000; i++) {
    //            int first_sum, zero_count, non_zero_num;
    //            sum_count_zero(i, first_sum, zero_count, non_zero_num);
    //            int last_3_combo=1;
    //            if (zero_count==1) {
    //                if (single_zero_set[non_zero_num]>0) {
    //                    last_3_combo=0;
    //                }
    //                else {
    //                    single_zero_set[non_zero_num]=1;
    //                }
    //                last_3_combo=3;
    //            }
    //            else if (zero_count==2) {
    //                last_3_combo=3;
    //            }
    //            first_3_digit+=1;
    //            last_3_digit+=last_3_combo;
    //        }
    //        int result=0;
    //        for (int i=0; i<27; i++) {
    //            result+=first_3_digit[i]*last_3_digit[i];
    //        }
    //        return result;
    //    }
    //    
    //    class Employee {
    //    public:
    //        int id_;
    //        vector<Employee*> reporters_;
    //    };
    //    void GetReporters(Employee *e, int id, vector<Employee*> &reporters, bool found = false, bool processed = false)
    //    {
    //        if (!processed &&
    //            e)
    //        {
    //            if (found) {
    //                reporters.push_back(e);
    //            }
    //            if (e->id_ == id) {
    //                found = true;
    //            }
    //            for (auto reporter : e->reporters_) {
    //                GetReporters(reporter, id, reporters, found, processed);
    //            }
    //            if (e->id_ == id) {
    //                processed = true;
    //            }        
    //        }
    //    }
};

class Solution526 {
public:
    class TreeNode {
    public:
        char val;
        vector<TreeNode*> children;
        TreeNode(char val) {
            this->val=val;
            this->children={};
        }
    };
    
    TreeNode* buildTree(TreeNode* root) {
        if (root==NULL) {
            return NULL;
        }
        else if (root->val=='*') {
            vector<TreeNode*> lefts;
            vector<TreeNode*> rights;
            if (root->children[0]->val=='+') {
                lefts=getChildren(root->children[0]);
            }
            if (root->children[1]->val=='+') {
                rights=getChildren(root->children[1]);
            }
            if (lefts.size()>0 && rights.size()>0) {
                TreeNode* result=new TreeNode('+');
                for (int i=0; i<lefts.size(); i++) {
                    for (int j=0; j<rights.size(); j++) {
                        TreeNode* child = new TreeNode('*');
                        TreeNode* child1 = new TreeNode(lefts[i]->val);
                        TreeNode* child2 = new TreeNode(rights[j]->val);
                        child->children.push_back(child1);
                        child->children.push_back(child2);
                        result->children.push_back(child);
                    }
                }
                return result;
            }
            else if (lefts.size()>0) {
                TreeNode* result=new TreeNode('+');
                for (int i=0; i<lefts.size(); i++) {
                    TreeNode* child = new TreeNode('*');
                    TreeNode* child1 = new TreeNode(lefts[i]->val);
                    TreeNode* child2 = new TreeNode(root->children[1]->val);
                    child->children.push_back(child1);
                    child->children.push_back(child2);
                    result->children.push_back(child);
                }
                return result;
            }
            else if (rights.size()>0) {
                TreeNode* result=new TreeNode('+');
                for (int i=0; i<rights.size(); i++) {
                    TreeNode* child = new TreeNode('*');
                    TreeNode* child1 = new TreeNode(root->children[1]->val);
                    TreeNode* child2 = new TreeNode(rights[i]->val);
                    child->children.push_back(child1);
                    child->children.push_back(child2);
                    result->children.push_back(child);
                }
                return result;
            }
            else {
                return root;
            }
        }
        else {
            return root;
        }
    }
    
    vector<TreeNode*> getChildren(TreeNode* root) {
        vector<TreeNode*> result;
        if (root->val=='+' || root->val=='*') {
            for (int i=0; i<root->children.size(); i++) {
                result.push_back(root->children[i]);
            }
        }
        return result;
    }
    void test() {
//                    +
//                *       d
//              *    e
//           +      c
//         a   b
        string str="((a+b)*(c+d))*e+d";
        TreeNode* t1=new TreeNode('*');
        TreeNode* t2=new TreeNode('+');
        TreeNode* t3=new TreeNode('+');
        TreeNode* t4=new TreeNode('a');
        TreeNode* t5=new TreeNode('b');
        TreeNode* t6=new TreeNode('c');
        TreeNode* t7=new TreeNode('d');
        t1->children.push_back(t2);
        t1->children.push_back(t3);
        t2->children.push_back(t4);
        t2->children.push_back(t5);
        t3->children.push_back(t6);
        t3->children.push_back(t7);
        TreeNode* root=buildTree(t1);
        cout<<root->val<<endl;
    }
};

class Solution555 {
public:
    
    int countBits(int a)
    {
        int result = 0;
        while (a!=0)
        {
            if (a & 1)
                result += 1;
            a = a>>1;
        }
        return result;
    }
    
    vector<int> cardinalitySort(vector<int> nums)
    {
        if(nums.size()<1) {
            return nums;
        }
        int leng=nums.size();
        //int has 32 bits, bucket sorting
        
        vector<vector<int>> count(32);
        int setbitcount = 0;
        for (int i=0; i<nums.size(); i++)
        {
            setbitcount = countBits(nums[i]);
            count[setbitcount].push_back(nums[i]);
        }
        vector<int> result;
        int j = 0;
        
        // Traverse through all bit counts
        for (int i=0; i<32; i++)
        {
            if(count[i].size()!=0) {
                
                for (int k=0; k<count[i].size(); k++)
                    result.push_back(count[i][k]);
            }
        }
        return result;
    }
    
    void test() {
        vector<int> nums = {1,2,3,4,5};
        vector<int> result = cardinalitySort(nums);
        for (int i=0; i<result.size(); i++) {
            cout<<result[i]<<" ";
        }
    }

};

class Solution556 {
public:
	//Audible
    int subarraySum(vector<int> arr) {
        if(arr.empty() || arr.size()<1) {
            return 0;
        }
        long result = 0;
        // must use long, otherwise some cases are failures, wired
        long leng = arr.size();
        for(long i=0; i<leng; i++) {
            // 1, 2, 3, 1 2, 2 3, 1 2 3
            // 1 1 1, i=0, 3*1*a[0]
            // 2 2 2 2, i=1, 2*2*a[1]
            // 3 3 3, i=2, 1*3*a[2]
            //(i+1) * (leng - i)*a[i]
            result+=(leng-i)*(i+1)*arr[i];
        }
        return result;
    }
    
    /*
     * helper function to convert prefix to postfix
     * input: prefix, eg: "*34"
     * output: postfix, eg: "34*"
     */
    string pre2post(string str) {
        if(str.empty() || str.size()<2) {
            return str;
        }
        //stack is used to store digits
        stack<string> stk;
        //from tail to head, push into stack
        for(int i=str.size()-1; i>=0; i--) {
            char curr = str[i];
            if(isdigit(curr)) {
                stk.push(to_string(curr-'0'));
            } else {
                string a = stk.top(); stk.pop();
                string b = stk.top(); stk.pop();
                //build target string
                stk.push(a+b+curr);
            }
        }
        return stk.top();
    }
    /*
     *  for each prefix, call helper function to convert
     *  input: array of prefixes
     *  output: array of postfixes
     */
    vector <string> prefixToPostfix(vector <string> prefixes) {
        vector<string> result;
        for (int i = 0; i < prefixes.size(); ++i)
        {
            result.push_back(pre2post(prefixes[i]));
        }
        return result;
    }
    
    /*
     * main function
     * input: total budget, shops' quantities, corresponding costs
     * output: the maximum quantities we can buy with budget
     */
    int budgetShopping(int n, vector <int> bundleQuantities, vector <int> bundleCosts) {
        
        if(bundleQuantities.empty() || bundleQuantities.size()<1) {
            return 0;
        }
        //array to save how much we buy with budget [1, n]
        vector<int> dp(n+1, 0);
        //need to sort by cost asc, the less cost we choose firstly
        vector<pair<int, int>> shops;
        for(int i=0; i<min(bundleQuantities.size(), bundleCosts.size()); i++) {
            shops.push_back(make_pair(bundleCosts[i], bundleQuantities[i]));
        }
        sort(shops.begin(), shops.end());
        //    for (int i=0; i<shops.size(); i++) {
        //        cout<<shops[i].first<<" "<<shops[i].second<<endl;
        //    }
        for(int i=shops[0].first; i<n+1; i++) {
            for(int j=0; j<shops.size(); j++) {
                //if current bugest is less than cost, skip
                if(i<shops[j].first) {
                    break;
                }
                //if we can buy more, then update the ith number
                if(dp[i-shops[j].first] + shops[j].second > dp[i]) {
                    dp[i] = dp[i-shops[j].first] + shops[j].second;
                }
            }
        }
        // return the nth, the maximum books we buy with n
        return dp[n];
    }
    
    void test1() {
        vector<int> arr;
        arr = {};
        cout<<subarraySum(arr)<<endl;
        arr = {1};
        cout<<subarraySum(arr)<<endl;
        arr = {1,1,1};
        cout<<subarraySum(arr)<<endl;
        arr = {1,2,3};
        cout<<subarraySum(arr)<<endl;
    }
    
    void test2() {
        vector<string> array;
        array.push_back("*34");
        array.push_back("+1*23");
        array.push_back("+12");
        array.push_back("+1**23/14");
        array = prefixToPostfix(array);
        for (auto i:array) {
            cout<<i<<endl;
        }
    }
    
    void test3() {
        vector<int> quantities = {20, 19};
        vector<int> costs = {24, 20};
        cout<<budgetShopping(50, quantities, costs)<<endl;
        quantities = {10};
        costs = {2, 20};
        cout<<budgetShopping(4, quantities, costs)<<endl;
    }
    
};

// To execute C++, please define "int main()"
int main() {
    Solution556* s556 = new Solution556();
    s556->test1();
    s556->test2();
    s556->test3();
//    Solution555* s555 = new Solution555();
//    s555->test();
//    Solution526* s526 = new Solution526();
//    s526->test();
//    Solution525* s525 = new Solution525();
//    s525->test();
//    Solution524* s524 = new Solution524();
//    s524->test();
//    Solution523* s523 = new Solution523();
//    s523->test();
//    Solution522* s522 = new Solution522();
//    s522->test();
//    Solution520* s520 = new Solution520();
//    s520->test();
//    Solution519* s519 = new Solution519();
//    s519->test();
//    Solution518* s518 = new Solution518();
//    s518->test();
//    Solution517* s517 = new Solution517();
//    s517->test();
//    Solution515* s515 = new Solution515();
//    s515->test();
//    Solution514* s514 = new Solution514();
//    s514->test();
//    Solution512* s512 = new Solution512();
//    s512->test();
//    Solution511* s511 = new Solution511();
//    s511->test();
//    Solution510* s510 = new Solution510();
//    s510->test();
//    Solution509* s509 = new Solution509();
//    s509->test();
//    Solution482* s482 = new Solution482();
//    s482->test();
//    Solution481* s481 = new Solution481();
//    s481->test();
//    Solution480* s480 = new Solution480();
//    s480->test();
	//    Solution400* s400 = new Solution400();
	//    s400->rainbowSortIII({1}, 1);
	//    s400->rainbowSortIII({1, 3, 2, 1, 2} , 3);
	//    s400->rainbowSortIII({3, 1, 5, 5, 1, 4, 2}, 5);
	//    
	//    Solution399* s399 = new Solution399();
	//    s399->rainbowSortII({0} );
	//    s399->rainbowSortII({1,0} );
	//    s399->rainbowSortII({1, 3, 1, 2, 0} );
	//    Solution383* s383 = new Solution383();
	//    s383->reverseWords(" I  love  Google  ");
	//    Solution350* s350 = new Solution350();
	//    int r350 = s350->minReplacements("bbbbbaaaab");
	//    r350 = s350->minReplacements("aaabbabbaaaabba");
	//    r350 = s350->minReplacements("aaaaaaaa");
	//    Solution348* s348 = new Solution348();
	//    s348->reverse("abbegi");
//    Solution346* s346 = new Solution346();
//    s346->test();
//    Solution345* s345 = new Solution345();
//    s345->test();
	//    Solution342* s342 = new Solution342();
	//    cout<<s342->isomorphic("aba", "aaa")<<endl;
	//    cout<<s342->isomorphic("hhkkhhkkk", "ccddcceee")<<endl;
	//    cout<<s342->isomorphic( "fgh","ghf" )<<endl;
//    Solution341* s341 = new Solution341();
//    s341->test();
//    Solution338* s338 = new Solution338();
//    s338->test();
//    Solution337* s337 = new Solution337();
//    s337->test();
//    Solution336* s336 = new Solution336();
//    s336->test();
//    Solution335* s335 = new Solution335();
//    s335->test();
//    Solution334* s334 = new Solution334();
//    s334->test();
//    Solution333* s333 = new Solution333();
//    s333->test();
//    Solution332* s332 = new Solution332();
//    s332->test();
//    Solution328* s328 = new Solution328();
//    s328->test();
//    Solution325* s325 = new Solution325();
//    s325->test();
//    Solution324* s324 = new Solution324();
//    s324->test();
//    Solution323* s323 = new Solution323();
//    s323->test();
//    Solution322* s322 = new Solution322();
//    s322->test();
//    Solution320* s320 = new Solution320();
//    s320->test();
//    Solution319* s319 = new Solution319();
//    s319->test();
//    Solution318* s318 = new Solution318();
//    s318->test();
//    Solution316* s316 = new Solution316();
//    s316->test();
//    Solution315* s315 = new Solution315();
//    vector<int> r315 = s315->dedup({1, 2, 2, 3, 3, 3});
//    r315 = s315->dedup({2, 1, 2, 2, 2, 3});
//    r315 = s315->dedup({4,4,4,1,2,3,3,3});
//    Solution314* s314 = new Solution314();
//    s314->test();
//    Solution313* s313 = new Solution313();
//    s313->test();
//    Solution312* s312 = new Solution312();
//    s312->test();
//    Solution311* s311 = new Solution311();
//    s311->test();
//    Solution310* s310 = new Solution310();
//    s310->test();
//    Solution309* s309 = new Solution309();
//    s309->test();
//    Solution308* s308 = new Solution308();
//        s308->test();
//    Solution277* s277 = new Solution277();
//    s277->test();
//    Solution272* s272 = new Solution272();
//    s272->test();
//    Solution249* s249 = new Solution249();
//    s249->test();
	//    Solution235* s235 = new Solution235();
	//    cout<<s235->countAndSay(3)<<endl;
	//    cout<<s235->countAndSay(4)<<endl;
	//    cout<<s235->countAndSay(5)<<endl;
	//    cout<<s235->countAndSay(6)<<endl;
	//    Solution219* s219 = new Solution219();
	//    int r219 = s219->whiteObjects({ {0,0,0,1}, {1,0,1,1}, {1,1,0,0}, {0,1,0,0} });
	//    cout<<r219<<endl;
	//    Solution214* s214 = new Solution214();
	//    TreeNode* r214 = s214->reconstruct( {1, 3, 4, 5, 8, 11}, {1, 4, 3, 11, 8, 5});
	//    cout<<r214->left->right->value<<endl;
	//    Solution212* s212 = new Solution212();
	//    TreeNode* r212 = s212->reconstruct( {3,2,8,1,5,12,4,7,10,13} );
	//    cout<<r212->right->right->value<<endl;
	//    r212 = s212->reconstruct( {41, 38} );
	//    cout<<r212->left->value<<endl;
	//    Solution210* s210 = new Solution210();
	//    TreeNode* r210 = s210->reconstruct( {5, 3, 1, 4, 8, 11} );
	//    cout<<r210->left->right->value<<endl;
	//    Solution208* s208 = new Solution208();
	//    vector<int> result={};
	//    result=s208->majority( {1, 2, 1, 2, 1}, 3);
	//    assert(result[0]==1);
	//    assert(result[1]==2);
	//    result=s208->majority( {1, 2, 1, 2, 3, 3, 1}, 4);
	//    assert(result[0]==1);
	//    assert(result[1]==2);
	//    assert(result[2]==3);
	//    result=s208->majority( {2, 1}, 2);
	//    assert(result.size()==0);
	//    Solution207* s207 = new Solution207();
	//    vector<int> result=s207->majority({1, 2, 2, 3, 1, 3});
	//    assert(result.size()==0);
	//    vector<vector<int>> words = { {1,200}, {2,199}, {3, 198}, {4, 197}, {5, 196}, \
	//        {6, 195}, {4, 194}, {1, 193}, {7, 192}};
	//    unordered_map<int, int> lookup;
	//    vector<vector<int>> result=counting(words, lookup);
	//    vector<vector<vector<int>>> pages(10, vector<vector<int>>());
	//    vector<vector<vector<int>>> output;
	//    int k=6, cursor=0, j=0;
	//    for(auto i:words) {
	//        if(lookup[i[0]]>0) {
	//            if(pages[j].size()<k) {
	//                pages[j].push_back(i);
	//            }
	//            else {
	//                pages[++j].push_back(i);
	//            }
	//            lookup[i[0]]--;
	//        }
	//    }
	//    for(auto i:pages) {
	//        vector<vector<int>> current=sorting(i);
	//        output.push_back(current);
	//    }
	//    Solution507* s507 = new Solution507();
	//    unordered_map<int, unordered_set<int>> graph;
	//    graph[1].insert(2);
	//    graph[2].insert(3);
	//    graph[3].insert(1);
	//    graph[4].insert(2);
	//    vector<int> o507=s507->putad(graph);
	//    cout<<o507[0]<<endl;
	//    Solution506* new506 = new Solution506();
	//    cout<<new506->doesCircleExist({"GRGL"})[0]<<endl;
	//    Solution505* new505 = new Solution505();
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t7=new TreeNode(7);
	//    t1->left=t2;
	//    t1->right=t3;
	//    t2->left=t4;
	//    t2->right=t5;
	//    t3->left=t6;
	//    t3->right=t7;
	//    cout<<new505->count(t1)<<endl;
	//    t1=NULL;
	//    cout<<new505->count(t1)<<endl;
	//    t1=new TreeNode(10);
	//    cout<<new505->count(t1)<<endl;
//    Solution205* s205 = new Solution205(3);
//    s205->set(1, 2);
//    s205->set(3, 4);
//    s205->set(5, 6);
//    s205->get(1);
//    s205->get(5);
//    s205->get(3);
//    Solution204* s204 = new Solution204();
//    s204->maxWindows({1, 2, 3, 2, 4, 2, 1}, 3);
	//    Solution201* new201 = new Solution201();
	//    int result=new201->largest({ 2, 1, 3, 1, 2, 1 });
	//    cout<<result<<endl;
	//    Solution196* new196 = new Solution196();
	//    vector<int> result=new196->solve( { { 'E', ' ', ' ' },
	//                                        { ' ', 'E', ' ' },
	//                                        { 'E', ' ', ' ' } });
	//    cout<<result[0]<<" "<<result[1]<<endl;
	//    Solution192* new192 = new Solution192();
	//    cout<<new192->kth(1)<<endl;
	//    cout<<new192->kth(2)<<endl;
	//    cout<<new192->kth(3)<<endl;
	//    cout<<new192->kth(4)<<endl;
	//    cout<<new192->kth(5)<<endl;
	//    cout<<new192->kth(6)<<endl;
	//    cout<<new192->kth(7)<<endl;
	//    Solution187* new187 = new Solution187();
	//    cout<<new187->exist({1, 3, 5}, {8, 2}, {3}, 14)<<endl;
	//    Solution185* new185 = new Solution185();
	//    vector<int> a= {3, 1, 5};
	//    vector<int> b= {2, 8};
	//    int target=7;
	//    bool result=new185->existSum(a, b, target);
	//    cout<<result<<endl;
	//    a= {3, 4, -1, 0};
	//    b= {5, -1, 2};
	//    target=-2;
	//    result=new185->existSum(a, b, target);
	//    cout<<result<<endl;
	//    Solution184* new184 = new Solution184();
	//    vector<int> array = {-1, 0, 1};
	//    cout<<new184->smallerPairs(array, 1)<<endl;
	//    cout<<new184->smallerPairs(array, 0)<<endl;
	//    cout<<new184->smallerPairs(array, -1)<<endl;
	//    array={1, 2, 2, 4, 7};
	//    cout<<new184->smallerPairs(array, 7)<<endl;
	//    Solution183* new183 = new Solution183();
	//    vector<int> result183=new183->solve({1, 3, 7, 11, 13}, 7);
	//    cout<<result183[0]<<" "<<result183[1]<<endl;
	//    Solution504* new504 = new Solution504();
	//    cout<<new504->cycle({"aab", "bac", "aaa"})<<endl;
	//    Solution503* new503 = new Solution503();
	//    cout<<new503->minCut(10)<<endl;
	//    Solution502* new502 = new Solution502();
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t7=new TreeNode(7);
	//    TreeNode* t8=new TreeNode(8);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t2=new TreeNode(2);
	//    t6->left=t3;
	//    t3->left=t7;
	//    t3->right=t8;
	//    t6->right=t5;
	//    t5->left=t1;
	//    t5->right=t2;
	//    cout<<new502->isCousions(t6, t7, t1)<<endl;
	//    Solution501* new501 = new Solution501();
	//    vector<string> result=new501->listspace("abc");
	//    for(auto i:result) {
	//        cout<<i<<endl;
	//    }
	//    Solution500* new500 = new Solution500();
	//    vector<string> array;
	//    array.push_back("1100");
	//    array.push_back("1110");
	//    array.push_back("0110");
	//    array.push_back("0001");
	//    int result=new500->zombieCluster(array);
	//    array.clear();
	//    cout<<result<<endl;
	//    Solution200* new200 = new Solution200();
	//    int result200 = new200->maxTrapped({{ 2, 3, 4, 2 },
	//                                        { 3, 1, 2, 3 },
	//                                        { 4, 3, 5, 4 } });
	//    cout<<result200<<endl;
	//    Solution199* new199 = new Solution199();
	//    int result199 = new199->maxTrapped({2,1,3,2,4});
	//    cout<<result199<<endl;
	//    result199 = new199->maxTrapped({1,3,2,4,1,3,2,4,3,2});
	//    cout<<result199<<endl;
	//	Solution198* new198 = new Solution198();
	//	new198->largest({ 2,3,1 });
	//	Solution195* new195 = new Solution195();
	//	vector<int> result195 = new195->solve({	{ 'E', 'O', 'C' },
	//											{ 'C', 'E',  'C' },
	//											{ 'C', 'C',  'C' } });
	//	cout << result195[0] << " " << result195[1] << endl;
	//    Solution194* new194 = new Solution194();
	//    vector<int> result194 = new194->closest({1,3},{2,3},{2,4},3 );
	//	cout << result194[0] << " " << result194[1] << " " << result194[1] << " " << endl;
	//    Solution193* new193 = new Solution193();
	//    for (int i=1; i<10; i++) {
	//        cout<<new193->kth(i)<<endl;
	//    }
	//    Solution191* new191 = new Solution191();
	//    cout<<new191->largestProduct({"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})<<endl;
	//    cout<<new191->largestProduct({"a","b","c","deuf","fhiop","lmhdnu","xpyzewu","rsptu"})<<endl;
	//    Solution177* new177 = new Solution177();
	//    cout<<new177->longest( "abcde", "cbabdfe")<<endl;
	//    Solution176* new176 = new Solution176();
	//    cout<<new176->longestCommon( "abcdefg","bbcefgh")<<endl;
		//    Solution188* new188 = new Solution188();
		//    cout<<new188->exist({1, 2, 2, 3, 4}, 9)<<endl;
		//    Solution186* new186 = new Solution186();
		//    vector<vector<int>> result186 = new186->solve({-1,0,1}, 0);
		//    for (int i=0; i<result186.size(); i++) {
		//        for (int j=0; j<result186[i].size(); j++) {
		//            cout<<result186[i][j]<<' ';
		//        }
		//    }
		//    Solution182* new182 = new Solution182();
		//    vector<vector<int>> result182 = new182->solve({2, 1, 3, 2, 4, 3, 4, 2}, 6);
		//    cout<<result182[1][0]<<endl;
		//    Solution181* new181 = new Solution181();
		//    vector<vector<int>> result181 = new181->solve({1, 2, 2, 4}, 6);
		//    cout<<result181[1][0]<<endl;
		//    Solution180* new180 = new Solution180();
		//    cout<<new180->existSum({2, 4, 1}, 4)<<endl;
		//    Solution179* new179 = new Solution179();
		//    vector<string> result179 = new179->solve(2, 1, 1);
		//    for (int i=0; i<result179.size(); i++) {
		//        cout<<result179[i]<<" ";
		//    }
		//    cout<<'\n'<<result179.size()<<endl;
		//    Solution178* new178 = new Solution178();
		//    TreeNode* t1=new TreeNode(1);
		//    TreeNode* t2=new TreeNode(2);
		//    TreeNode* t3=new TreeNode(3);
		//    TreeNode* t4=new TreeNode(4);
		//    TreeNode* t5=new TreeNode(5);
		//    t1->left=t2;
		//    t1->right=t5;
		//    t2->left=t3;
		//    t2->right=t4;
		//    TreeNode* result178 = new178->reverse(t1);
		//    cout<<result178->left->right->value<<endl;
		//    Solution171* new171 = new Solution171();
		//    vector<int> result171 = new171->common({1,2,3,3}, {2,3,4,4,5}, {1,1,3,3});
		//    printintArray(result171);
//    Solution169* s169 = new Solution169();
//    s169->graycode(2);
//    Solution167* s167 = new Solution167();
//    s167->getPermutation(3, 2);
//    Solution159* s159 = new Solution159();
//    string o159 = s159->simplify("/a/./b/../../c/");
//    o159 = s159->simplify("/home/");
//  Solution158* s158 = new Solution158();
//	s158->setZero({ { 1, 1, 1, 1, 0 },{ 0, 1, 1, 0, 1 },{ 1, 1, 1, 0, 1 },{ 1, 1, 1, 1, 1 } });
//	Solution156* s156 = new Solution156();
//	string ss = "adobecodebanc";
//    string tt = "abc";
//	ss = s156->minWindow(ss, tt);
//	Solution155* s155 = new Solution155();
//	s155->combine1(4, 2);
		//    Solution63* new63 = new Solution63();
		//    vector<string> result63 = new63->solve("abb");
		//    vector<string> result632 = new63->solve2("abb");
		//    for (auto i:result63) {
		//        cout<<i<<endl;
		//    }
		//    for (auto i:result632) {
		//        cout<<i<<endl;
		//    }
		//    Solution96* new96 = new Solution96();
		//    cout<<new96->minCostInterative({4, 3, 3, 4, 4})<<endl;
		//    cout<<new96->minCost({4, 3, 3, 4, 4});
		//    Solution137* new137=new Solution137;
		//    cout<<new137->minCost({2, 4, 7}, 10);
		//    TreeNode* t5=new TreeNode(5);
		//    TreeNode* t2=new TreeNode(2);
		//    TreeNode* t11=new TreeNode(11);
		//    TreeNode* t6=new TreeNode(6);
		//    TreeNode* t14=new TreeNode(14);
		//    t5->left=t2;
		//    t5->right=t11;
		//    t11->left=t6;
		//    t11->right=t14;
		//    Solution136* new136=new Solution136();
		//    cout<<new136->largestSmaller(t5, 1);
		//    TreeNode* t5=new TreeNode(5);
		//    TreeNode* t2=new TreeNode(2);
		//    TreeNode* t11=new TreeNode(11);
		//    TreeNode* t6=new TreeNode(6);
		//    TreeNode* t14=new TreeNode(14);
		//    t5->left=t2;
		//    t5->right=t11;
		//    t11->left=t6;
		//    t11->right=t14;
		//    Solution135* new135=new Solution135();
		//    cout<<new135->closest(t5, 14);
		//    ListNode* n1=new ListNode(1);
		//    ListNode* n3=new ListNode(3);
		//    ListNode* n5=new ListNode(5);
		//    ListNode* n7=new ListNode(7);
		//    ListNode* n9=new ListNode(9);
		//    ListNode* n2=new ListNode(2);
		//    ListNode* n4=new ListNode(4);
		//    ListNode* n6=new ListNode(6);
		//    ListNode* n8=new ListNode(8);
		//    ListNode* n10=new ListNode(10);
		//    n1->next=n3;
		//    n3->next=n5;
		//    n5->next=n7;
		//    n7->next=n9;
		//    n2->next=n4;
		//    n4->next=n6;
		//    n6->next=n8;
		//    n8->next=n10;
		//    Solution134* new134 = new Solution134();
		//    new134->solve({n1, n2});
		//    Solution133* new133 = new Solution133();
		//    vector<int> result=new133->merge({ {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16} });
		//    vector<int> result=new133->merge({{0,1,2,3}});
		//    for(auto i:result) {
		//        cout<<i<<" ";
		//    }
		//    Solution132* new132=new Solution132();
		//    GraphNode* n1=new GraphNode(1);
		//    GraphNode* n2=new GraphNode(2);
		//    GraphNode* n3=new GraphNode(3);
		//    n1->neighbors.push_back(n2);
		//    n1->neighbors.push_back(n3);
		//    n2->neighbors.push_back(n1);
		//    n3->neighbors.push_back(n3);
		//    n3->neighbors.push_back(n1);
		//    n2->neighbors.push_back(n2);
		//    GraphNode* result = new132->solve(n1);
		//    Solution53* new53=new Solution53();
		//    TreeNode* root= new TreeNode(41);
		//    TreeNode* now=new53->solve(root, 41);
		//    cout<<now;
		//    Solution52* new52=new Solution52();
		//    TreeNode* root= new TreeNode(41);
		//    TreeNode* now=new52->solve(root, 41);
		//    cout<<now;
		//    Solution51* new51=new Solution51();
		//    TreeNode* root= new TreeNode(41);
		//    TreeNode* now=new51->insert(root, 38);
		//    cout<<now->value;
		//    solve125({ {1,  2,  3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} });
		//    largestAndSmallest({2, 1, 5, 4, 3});
		//    dedup4({1, 2, 2, 3, 3, 3, 2});
		//    dedup3({1, 2, 2, 3, 3, 3, 4});
		//    dedup2({1, 2, 2, 3, 3, 3, 4, 4});
		//    dedup1({1, 2, 2, 3, 3, 3, 4, 4});
		//    TreeNode* root= new TreeNode(5);
		//    root->left=new TreeNode(3);
		//    root->right=new TreeNode(8);
		//    root->left->left=new TreeNode(1);
		//    root->left->right=new TreeNode(4);
		//    root->left->left->left=new TreeNode(2);
		//    root->left->left->right=new TreeNode(6);
		//    root->left->right->left=new TreeNode(7);
		//    root->left->right->right=new TreeNode(9);
		//    root->right->left=NULL;
		//    root->right->right=new TreeNode(11);
		//    root->right->right->left=new TreeNode(10);
		//    root->right->right->right=new TreeNode(12);
		//    zigZag(root);
		//    vector<string> tcs = printpermutationif(2);
		//    cout<<largestSubMatrixSum({{1},{-2}});

		//    cout<<largestx({{0, 0, 0, 0},
		//                    {1, 1, 1, 1},
		//                    {0, 1, 1, 1},
		//                    {1, 0, 1, 1} });
		//    cout<<largestcross({{0, 0, 0, 0},
		//                        {1, 1, 1, 1},
		//                        {0, 1, 1, 1},
		//                        {1, 0, 1, 1} });
		//    cout<<longest1s({0, 1, 0, 1, 1, 1, 0});
		//    cout<<largestSum({2, -1, 4, -2, 1});
		//    cout<<largestSum({-2, -1, -3});
		//    reorder({1,2,3,4,5,6,7,8});
		//    cout<<decompress("a1c0b2c4");
		//

		//    cout<<isPowerOfTwo(-2147483648)<<endl;
		//    cout<<diffBits(5, 8)<<endl;
		//    cout<<Change(29)<<endl;
		//    cout<<allUnique("abA+\a88")<<" "<<allUnique("abA+\8")<<endl;
		//    vector<vector<int>> input1={ {1,  2,  3},
		//        {4,  5,  6},
		//        {7,  8,  9} };
		//    vector<vector<int>> input2={{1, 2,  3, 4},
		//                                {5, 6,  7, 8},
		//                                {9, 10,11,12},
		//                                {13,14,15,16}};
		//    vector<vector<int>> input3={ {1,  2,  3,  4},
		//                                {5,  6,  7,  8},
		//                                {9, 10, 11, 12} };
		//
		//    vector<vector<int>> input4={ {1,  2,  3},
		//                                {4, 5,  6},
		//                                {7,  8, 9},
		//                                {10, 11, 12} };
		//    vector<int> result=spiral(input2);
		//    vector<int> result=spiral2({{1}} );
		//    for(auto i:result) {
		//        cout<<i<<" ";
		//    }
		//    solve(3, 5);
		//    generateMatrix(3,1);
		//    solve(0);
		//    solve(1);
		//    solve(2);
		//    solve(3);
		//    solve(4);
		//    solve(5);
		//    solve(6);
		//    solve(7);
		//    solve(8);
		//    solve(9);
		//    cout<<match("apple","a3e")<<endl;
		//    cout<<longest({7, 2, 3, 1, 5, 8, 9, 6})<<endl;
		//cout<<canJump({1,2,0})<<endl;
		//cout<<minJump({2, 1, 1, 0, 2});
		/*
		Trie trie;
		trie.insert("ab");
		cout<<trie.search("ab")<<endl;
		cout<<trie.search("a")<<endl;
		cout<<trie.startsWith("a")<<endl;

		int arr[] = {10, 13, 16, 7, 8, 9, 1, 5};
		*/

		//    printf("hello!");
		//printf("%d\n", HammingDistance(4, 14));

		//int n = sizeof(arr)/sizeof(arr[0]);
		//quickSort(arr, 0, n-1);
		//printf("Sorted array: \n");
		//printArray(arr, n);

		//    std::set<int> myints;
		//    std::cout << "0. size: " << myints.size() << '\n';
		//    for (int i=0; i<10; ++i) myints.insert(i);
		//    std::cout << "1. size: " << myints.size() << '\n';
		//
		//    myints.insert (100);
		//    std::cout << "2. size: " << myints.size() << '\n';
		//
		//    myints.erase(5);
		//    vector<string> sss;
		//    std::cout << "3. size: " << myints.size() << '\n'<<labs(2147483647+1)<<endl;
		//    sss.push_back(to_string(121));
		//    sss.push_back(to_string(12));
		//    sort(sss.begin(), sss.end(), comp());
		//    cout<<sss[0]+sss[1]<<endl;
		//    cout<<sss[1]+sss[0]<<endl;
		//    if(to_string(33)<to_string(34))
		//        cout<<to_string(33)<<endl;
		//    else
		//        cout<<to_string(34)<<endl;
		//    return 0;

		//    vector<int> A={1,3,3,6,9,9,12,15};
		//    vector<int> result;
		//    //result=mergeSort(A, 0, 4);
		//    //result=quickSort(A);
		//    result=kClosest(A, 0, 3);
		//    printArray(result);
		//BSTNode* root = CreateBST(A, 5);
		//cout<<root->key<<endl;
		//    vector<vector<int>> matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		//    matrix={{1,2,3,3,4},{4,5,6,7,10},{12,14,14,17,19},{22,22,22,24,25}};
		//    matrix={{1},{2},{3},{4}};
		//    int target=0;
		//    vector<int> result=search(matrix, target);
		//    for(auto i:result) {
		//        cout<<i<<endl;
		//    }
		//    string aaa="abc";
		//    vector<string> result=solve61(aaa);
		//    vector<string> result=solve62(aaa);
		//    cout<<aaa<<endl;
		//    int num=3;
		//    vector<int> combos;
		//    cout<<combos.size()<<endl;
		//    result=solve63(3);

		//    TreeNode* root= new TreeNode(10);
		//    root->left=new TreeNode(5);
		//    root->right=new TreeNode(15);
		//    root->left->left=new TreeNode(2);
		//    root->left->left->left=NULL;
		//    root->left->left->right=NULL;
		//    root->left->right=NULL;
		//
		//    root->right->left=NULL;
		//    root->right->right=NULL;
		//    vector<vector<int>> result65 = solve65(root);
		//    cout<<endl;


		//}

		//vector<int> lexicalOrder(int n) {
		//    int result[n];
		//    for(int i=1;i<=n;i++)
		//        result[i-1]=i;
		//    quickSort(result, 0, n-1);
		//    vector<int> x(result, result + sizeof( result)/ sizeof( result[0]));
		//    return x;
		//}
		// Driver code
		/*

		vector<char> row;
		vector<vector<char>> matrix;
		row.push_back('1');
		row.push_back('0');
		row.push_back('1');
		row.push_back('0');
		row.push_back('0');
		matrix.push_back(row);
		row.clear();
		row.push_back('1');
		row.push_back('0');
		row.push_back('1');
		row.push_back('1');
		row.push_back('1');
		matrix.push_back(row);
		row.clear();
		row.push_back('1');
		row.push_back('1');
		row.push_back('1');
		row.push_back('1');
		row.push_back('1');
		matrix.push_back(row);
		row.clear();
		row.push_back('1');
		row.push_back('0');
		row.push_back('0');
		row.push_back('1');
		row.push_back('0');
		matrix.push_back(row);
		row.clear();
		cout<<"rows:"<<matrix.size()<<endl;
		cout<<"cols:"<<matrix[0].size()<<endl;
		cout << "Area of maximum rectangle is "<< maxRectangle(matrix)<<endl;

		//cout<<getHint("1123", "0111")<<endl;
		vector<int>now=lexicalOrder(13);
		for (vector<int>::const_iterator i = now.begin(); i != now.end(); ++i)
		cout << *i << ' ';
		cout<<endl;
		cout<<pow(10, max((int)log10(13), (int)log10(113)))<<' '<<endl;
		return 0;
		*/
		//cout<<canBreak("robcatbob", {"bob", "cat", "rob"});
		//cout<<editDistance("sigh", "asith");
		//cout<<largest({ {0, 0, 0, 0},  {1, 1, 1, 1}, {0, 1, 1, 1},  {1, 0, 1, 1}});
		//solve("aba");
		//cout<<reverseWords("I love Google");
		//cout<<replace("docomoco","co","omo" );
		//    Solution215* new215 = new Solution215();
		//    TreeNode* result215 = new215->reconstruct({4,8,10,12,14,20,22}, {20,8,22,4,12,10,14});
		//    cout<<result215->left->right->value<<endl;
		//    Solution213* new213 = new Solution213();
		//    TreeNode* result213 = new213->reconstruct({1, 3, 4, 5, 8, 11}, {5, 3, 1, 4, 8, 11});
		//    cout<<result213->left->right->value<<endl;
		//    Solution211* new211 = new Solution211();
		//    TreeNode* result211 = new211->reconstruct( {1, 4, 3, 11, 8, 5});
		//    cout<<result211->left->right->value<<endl;
//	Solution154* s154 = new Solution154();
//	vector<vector<char>> board = { {'A','B','C','E'},
//	{'S', 'F', 'E', 'S' },
//	{'A', 'D', 'E', 'E'} };
//	string word = "ABCESEEEFS";
//	bool o154 = s154->isWord(board, word);
//	word = "ABCB";
//	o154 = s154->isWord(board, word);
//	board = { {'a'} };
//	word = "a";
//	o154 = s154->isWord(board, word);
	//ListNode* l1 = new ListNode(1);
	//ListNode* l2 = new ListNode(2);
	//ListNode* l3 = new ListNode(3);
	//ListNode* l31 = new ListNode(3);
	//ListNode* l4 = new ListNode(4);
	//ListNode* l41 = new ListNode(4);
	//ListNode* l5 = new ListNode(5);
	//l1->next = l2;
	//l2->next = l3;
	//l3->next = l31;
	//l31->next = l4;
	//l4->next = l41;
	//l41->next = l5;
	//Solution152* s152 = new Solution152();
	//ListNode* o152 = s152->removeDup(l1);
	//Solution150* s150 = new Solution150();
	//bool o150 = s150->isScramble("great", "rgtae");
	//cout << o150 << endl;
	//o150 = s150->isScramble("agreat", "rgaeds");
	//cout << o150 << endl;

	//Solution148* s148 = new Solution148();
	//cout << s148->numDecodeWay("212");
    //Solution147* s147 = new Solution147();
    //vector<string> o147 = s147->restore("25525511135");
    //Solution145* s145 = new Solution145();
    //vector<TreeNode*> o145 = s145->generateBSTs(3);
//    TreeNode* t1=new TreeNode(1);
//    TreeNode* t2=new TreeNode(2);
//    TreeNode* t3=new TreeNode(3);
//    TreeNode* t4=new TreeNode(4);
//    t1->right=t2;
//    t2->right=t4;
//    t2->left=t3;
//    Solution142* s142 = new Solution142();
//    s142->diameter(t1);
	//    Solution141* new141 = new Solution141();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t11=new TreeNode(11);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t14=new TreeNode(14);
	//    TreeNode* t3=new TreeNode(3);
	//    t5->left=t2;
	//    t5->right=t11;
	//    t11->left=t6;
	//    t11->right=t14;
	//    t6->left=t3;
	//    bool result141 = new141->exist(t5, 11);
	//    cout<<result141<<endl;
	//    Solution140* new140 = new Solution140();
	//    TreeNode* t51=new TreeNode(-5);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t11=new TreeNode(11);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t14=new TreeNode(14);
	//    TreeNode* t31=new TreeNode(-3);
	//    t51->left=t2;
	//    t51->right=t11;
	//    t11->left=t6;
	//    t11->right=t14;
	//    t14->left=t31;
	//    int result140 = new140->maxPathSum(t51);
	//    cout<<result140<<endl;
//	Solution143* new143 = new Solution143();
//	cout << new143->minCuts("abab") << endl;
//	//cout << new143->minCuts("ababbbabbababa") << endl;
//	Solution138* new138 = new Solution138();
//	TreeNode* t51 = new TreeNode(-5);
//	TreeNode* t2 = new TreeNode(2);
//	TreeNode* t12 = new TreeNode(12);
//	TreeNode* t6 = new TreeNode(6);
//	TreeNode* t14 = new TreeNode(14);
//	TreeNode* t31 = new TreeNode(-3);
//	t51->left = t2;
//	t51->right = t12;
//	t12->left = t6;
//	t12->right = t14;
//	t14->left = t31;
//	int result138 = new138->maxPathSum(t51);
//	cout << result138 << endl;
//    Solution263* s263 = new Solution263();
//    s263->test();
//    Solution262* s262 = new Solution262();
//    s262->test();
	//    Solution261* new261 = new Solution261();
	//    vector<int> result261 = new261->sortSpecial({4,2,1,3}, {});
	//    printintArray(result261);
//    Solution260* s260 = new Solution260();
//    s260->interleave({-1,1,1,1,1,1,1,-1});
	//    Solution259* new259 = new Solution259();
	//    vector<int> result259 = new259->moveZero({1,0,2,0,1});
	//    printintArray(result259);
	//           5
	//        3     8
	//      1   4     11
	//     2 6 7 9  10  12
//	TreeNode* root = new TreeNode(5);
//	root->left = new TreeNode(3);
//	root->right = new TreeNode(8);
//	root->left->left = new TreeNode(1);
//	root->left->right = new TreeNode(4);
//	root->left->left->left = new TreeNode(2);
//	root->left->left->right = new TreeNode(6);
//	root->left->right->left = new TreeNode(7);
//	root->left->right->right = new TreeNode(9);
//	root->right->left = NULL;
//	root->right->right = new TreeNode(11);
//	root->right->right->left = new TreeNode(10);
//	root->right->right->right = new TreeNode(12);
//	Solution129* new129 = new Solution129();
//	TreeNode* result129 = new129->solve(root, { root->left->right->left, root->left->right->right, root->right->right->left });
//	cout << result129->value << endl;
	//    TreeNodeP* root=new TreeNodeP(5, NULL);
	//    TreeNodeP* node9=new TreeNodeP(9, root);
	//    TreeNodeP* node12=new TreeNodeP(12, root);
	//    root->left=node9;
	//    root->right=node12;
	//    TreeNodeP* node2=new TreeNodeP(2, node9);
	//    TreeNodeP* node3=new TreeNodeP(3, node9);
	//    node9->left=node2;
	//    node9->right=node3;
	//    TreeNodeP* node14=new TreeNodeP(14, node12);
	//    node12->right=node14;
	//    TreeNodeP* node8=new TreeNodeP(8, nullptr);
	//    Solution127* new127 = new Solution127();
	//    TreeNodeP* result127 = new127->solve(node2, node8);
	//    cout<<(result127==NULL?"NULL":to_string(result127->value))<<endl;
	//    Solution125* new125 = new Solution125();
	//    vector<vector<int>> result125 = {   {1,2,3,4},
	//                                        {5,6,7,8},
	//                                        {9,10,11,12},
	//                                        {13,14,15,16}};
	//    new125->solve(result125);
    //Solution120* s120 = new Solution120();
    //s120->largestAndSecond({2,1,5,4,3});
	//    Solution119* new119 = new Solution119();
	//    vector<int> result119 = new119->largestAndSmallest({2, 1, 5, 4, 3});
	//    cout<<result119[0]<<" "<<result119[1]<<endl;
	//    Solution118* new118 = new Solution118();
	//    vector<int> result118 = new118->dedup({1,2,3,3,3,3,2,2});
	//    cout<<result118[0]<<endl;
	//    Solution117* new117 = new Solution117();
	//    vector<int> result117 = new117->dedup({1,2,2,3,3,3,3,2});
	//    cout<<result117[1]<<endl;
	//    Solution116* new116 = new Solution116();
	//    vector<int> result116 = new116->dedup({1,2,2,3,3,3,3});
	//    cout<<result116[1]<<endl;
	//    Solution115* new115 = new Solution115();
	//    vector<int> result115 = new115->dedup({1,2,2,3,3,3,3});
	//    cout<<result115[2]<<endl;
//	Solution58* new58 = new Solution58();
//	TreeNode* t5 = new TreeNode(5);
//	TreeNode* t3 = new TreeNode(3);
//	TreeNode* t8 = new TreeNode(8);
//	TreeNode* t1 = new TreeNode(1);
//	TreeNode* t4 = new TreeNode(4);
//	TreeNode* t11 = new TreeNode(11);
//	t5->left = t3;
//	t3->left = t1;
//	t3->right = t4;
//	t5->right = t8;
//	t8->right = t11;
//	vector<int> result58 = new58->zigZag(t5);
//	printintArray(result58);
	//    Solution114* new114 = new Solution114();
	//    cout<<new114->solve({1,2,3,4,5,6,7,8,9,10})<<endl;
	//    Solution113* new113 = new Solution113();
	//    new113->read(1);
	//    cout<<new113->median();
	//    new113->read(2);
	//    cout<<new113->median();
	//    new113->read(3);
	//    cout<<new113->median();
	//    new113->read(10);
	//    cout<<new113->median();
	//    Solution112* new112 = new Solution112();
	//    cout<<new112->solve()<<endl;
	//    Solution111* new111 = new Solution111();
	//    cout<<new111->solve()<<endl;
	//    Solution109* new109=new Solution109();
	//    new109->read(0);
	//    cout<<new109->sample();
	//    new109->read(1);
	//    cout<<new109->sample();
	//    new109->read(2);
	//    cout<<new109->sample();
	//    new109->read(3);
	//    cout<<new109->sample();
	//    new109->read(4);
	//    cout<<new109->sample();
	//    Solution108* new108 = new Solution108();
	//    vector<int> result108={1,2,3,4,5,6,7,8,9,10};
	//    new108->solve(result108);
	//    cout<<result108[0]<<endl;
	//    Solution106* new106 = new Solution106();
	//    cout<<new106->largest({ {1, -2, -1, 4},
	//                            {1, -1,  1, 1},
	//                            {0, -1, -1, 1},
	//                            {0,  0,  1, 1} })<<endl;
	//    Solution105* new105 = new Solution105();
	//    cout<<new105->largest({ {0, 0, 0, 0},
	//                            {1, 1, 1, 1},
	//                            {0, 1, 1, 1},
	//                            {1, 0, 1, 1} })<<endl;
	//    Solution104* new104 = new Solution104();
	//    cout<<new104->largest({ {0, 0, 0, 0},
	//                            {1, 1, 1, 1},
	//                            {0, 1, 1, 1},
	//                            {1, 0, 1, 1} })<<endl;
	//    Solution103* new103 = new Solution103();
	//    cout<<new103->longest({0, 1, 0, 1, 1, 1, 0})<<endl;
	//    Solution97* new97 = new Solution97();
	//    cout<<new97->largestSum({2, -1, 4, -2, 1})<<endl;
	//    cout<<new97->largestSum({-2, -1, -3})<<endl;
	//    Solution101* new101 = new Solution101();
	//    cout<<new101->largest({ {0, 0, 0, 0},
	//                            {1, 1, 1, 1},
	//                            {0, 1, 1, 1},
	//                            {1, 0, 1, 1}})<<endl;
	//    Solution100* new100 = new Solution100();
	//    cout<<new100->editDistance("sign", "asith")<<endl;
	//    Solution99* new99 = new Solution99();
	//    cout<<new99->canBreak("bcdbcdabc", {"abc","bcd","def"})<<endl;
	//    cout<<new99->canBreak("robob", {"bob", "cat", "rob"})<<endl;
    //  Solution91* s91 = new Solution91();
    //  s91->minJump({1, 3, 1, 2, 2}, 2);
	//    Solution89* new89 = new Solution89();
	//    cout<<new89->minJump({3, 3, 1, 0, 4})<<" "<<new89->minJump({2, 1, 1, 0, 2})<<endl;
	//    Solution88* new88 = new Solution88();
	//    cout<<new88->canJump({1, 3, 2, 0, 3})<<" "<<new88->canJump({2, 1, 1, 0, 2})<<endl;
	//    Solution87* new87 = new Solution87();
	//    cout<<new87->maxProduct(2)<<" "<<new87->maxProduct(12)<<endl;
	//    Solution86* new86 = new Solution86();
	//    cout<<new86->longest({7, 2, 3, 1, 5, 8, 9, 6})<<endl;
	//    Solution78* new78 = new Solution78();
	//    cout<<new78->hex(255)<<endl;
	//    Solution77* new77 = new Solution77();
	//    cout<<new77->allUnique("abA+\a88\t")<<endl;
	//    Solution75* new75 = new Solution75();
	//    cout<<new75->diffBits(5, 8)<<endl;
	//    Solution74* new74 = new Solution74();
	//    cout<<new74->isPowerOfTwo(15)<<endl;
	//    cout<<new74->isPowerOfTwo(0)<<endl;
	//    cout<<new74->isPowerOfTwo(-1)<<endl;
	//    cout<<new74->isPowerOfTwo(INT_MAX)<<endl;
	//    cout<<new74->isPowerOfTwo(INT_MIN)<<endl;
	//    Solution292* new292 = new Solution292();
	//    cout<<new292->match("", "0");
	//    Solution233* new233 = new Solution233();
	//    vector<vector<int>> result233 = new233->solve(0);
	//    result233 = new233->solve(1);
	//    result233 = new233->solve(2);
	//    result233 = new233->solve(3);
	//    result233 = new233->solve(4);
	//    result233 = new233->solve(15);
	//    cout<<result233.size()<<endl;
	//    Solution126* new126 = new Solution126();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t9=new TreeNode(9);
	//    TreeNode* t12=new TreeNode(12);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t14=new TreeNode(14);
	//    TreeNode* t3=new TreeNode(3);
	//    t5->left=t9;
	//    t5->right=t12;
	//    t9->left=t2;
	//    t9->right=t3;
	//    t12->left=t14;
	//    TreeNode* result126 = new126->solve(t5, t2, t9);
	//    cout<<result126->value<<endl;
	//    Solution124* new124 = new Solution124();
	//    vector<vector<int>> result124 = new124->solve(0, 0);
	//    if (result124.size()>0) {
	//        cout<<result124[0][0]<<endl;
	//    }
//    Solution123* s123 = new Solution123();
//    s123->solve(3);
	//    Solution122* new122 = new Solution122();
	//    vector<int> result122 = new122->spiral({{1}});
	//    cout<<result122[0]<<endl;
	//    Solution121* new121 = new Solution121();
	//    vector<int> result121 = new121->spiral({{1, 2,  3, 4},
	//                                            {5, 6,  7, 8},
	//                                            {9, 10,11,12},
	//                                            {13,14,15,16}});
	//    cout<<result121[3]<<endl;
	//    Solution35* new35 = new Solution35();
	//    ListNode* l1= new ListNode(1);
	//    ListNode* l2= new ListNode(2);
	//    ListNode* l3= new ListNode(3);
	//    l1->next=l2;
	//    l2->next=l3;
	//    ListNode* result35 = new35->reverseInPairs(l1);
	//    cout<<result35->next->value<<endl;
	//    Solution398* new398 = new Solution398();
	//    vector<int> result398 = new398->allAnagrams("a", "aaa");
	//    cout<<result398[2]<<endl;
	//    Solution397* new397 = new Solution397();
	//    cout<<new397->rightShift("abcdefg", 39)<<endl;
	//    Solution396* new396 = new Solution396();
	//    cout<<new396->reverse("docomomomocomo")<<endl;
	//    Solution253* new253 = new Solution253();
	//    cout<<new253->longest("abcabcbbcda")<<endl;
	//    Solution197* new197 = new Solution197();
	//    vector<int> result197 = new197->reorder({1,2,3,4,5,6,7});
	//    cout<<result197[3]<<endl;
	//    Solution175* new175 = new Solution175();
	//    cout<<new175->decompress("a1c0b2c4")<<endl;
	//    Solution172* new172 = new Solution172();
	//    cout<<new172->replace("docomomomocomo","omo","o")<<endl;
	//    Solution84* new84 = new Solution84();
	//    cout<<new84->reverseWords("I love Google")<<endl;
	//    Solution65* new65 = new Solution65();
	//    vector<string> result65 = new65->solve("aba");
	//    cout<<result65[2]<<endl;
	//    Solution139* new139 = new Solution139();
	//    TreeNode* t11=new TreeNode(-1);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t111=new TreeNode(11);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t141=new TreeNode(-14);
	//    t11->left=t2;
	//    t11->right=t111;
	//    t111->left=t6;
	//    t111->right=t141;
	//    int result139 = new139->maxPathSum(t11);
	//    cout<<result139<<endl;
	//    Solution395* new395 = new Solution395();
	//    cout<<new395->remove("abcded", "ab");
	//    Solution281* new281 = new Solution281();
	//    cout<<new281->removeSpaces("    I   love   MTV  ")<<endl;
	//    Solution85* new85 = new Solution85();
	//    cout<<new85->strstr("bcabc", "ab")<<endl;
	//    Solution82* new82 = new Solution82();
	//    cout<<new82->deDup("abbbaaacccz")<<endl;
	//    Solution79* new79 = new Solution79();
	//    cout<<new79->deDup("aaaabbbbcccc")<<endl;
	//    Solution72* new72 = new Solution72();
	//    cout<<new72->common({1,1,2,4,4,6,6,6}, {1,3,5,5,6,6})[2]<<endl;
	//    Solution68* new68 = new Solution68();
	//    cout<<new68->missing({1,3,4})<<endl;
	//    Solution67* new67 = new Solution67();
	//    vector<string> result67 = new67->topKFrequent({"a","a","b","b","b","b","c","c","c", "d"},5);
	//    cout<<result67[2]<<endl;
	//    Solution73* new73 = new Solution73();
	//    vector<vector<int> > result64=new73->solve(11, {5,2,1});
	//    for(int i=0;i<result64.size();i++) {
	//        for(int j=0;j<result64[i].size();j++) {
	//            cout<<result64[i][j]<<" ";
	//        }
	//        cout<<endl;
	//    }
	//    cout<<endl;
	//    Solution66* new66 = new Solution66();
	//    vector<string> result66 = new66->solve(3);
	//    cout<<result66[2]<<endl;
	//    Solution64* new64 = new Solution64();
	//    vector<string> result64 = new64->solve("abc");
	//    cout<<result64[2]<<endl;
	//    Solution62* new62 = new Solution62();
	//    vector<string> result62 = new62->solve("abc");
	//    cout<<result62[2]<<endl;
	//    Solution57* new57 = new Solution57();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t8=new TreeNode(8);
	//    TreeNode* t11=new TreeNode(11);
	//    t5->left=t3;
	//    t5->right=t8;
	//    t3->left=t1;
	//    t3->right=t4;
	//    t8->right=t11;
	//    vector<vector<int>> result57 = new57->solve(t5);
	//    cout<<result57[2][2]<<endl;
	//    Solution56* new56 = new Solution56();
	//    GraphNode* g1=new GraphNode(1);
	//    GraphNode* g2=new GraphNode(2);
	//    GraphNode* g3=new GraphNode(3);
	//    GraphNode* g4=new GraphNode(4);
	//    g1->neighbors={g2};
	//    g2->neighbors={g1, g3, g4};
	//    g3->neighbors={g2, g4};
	//    g4->neighbors={g3, g2};
	//    bool result56=new56->solve({g1, g2, g3, g4});
	//    cout<<result56<<endl;
	//    Solution47* new47 = new Solution47();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t8=new TreeNode(8);
	//    TreeNode* t11=new TreeNode(11);
	//    t5->left=t3;
	//    t5->right=t8;
	//    t3->left=t1;
	//    t3->right=t4;
	//    t8->right=t11;
	//    cout<<new47->isCompleted(t5)<<endl;
	//    Solution26* new26 = new Solution26();
	//    int result26 = new26->kthSmallest({{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}}, 5);
	//    cout<<result26<<endl;
	//    Solution25* new25 = new Solution25();
	//    vector<int> result25 = new25->KSmallest({3, 4, 1, 2, 5}, 3);
	//    cout<<result25[0]<<endl;
	//    Solution55* new55 = new Solution55();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t8=new TreeNode(8);
	//    TreeNode* t11=new TreeNode(11);
	//    t5->left=t3;
	//    t5->right=t8;
	//    t3->left=t1;
	//    t3->right=t4;
	//    t8->right=t11;
	//    vector<int> result55 = new55->getRange(t5, 2, 5);
	//    cout<<result55[0]<<endl;
	   /* Solution54* new54 = new Solution54();
	    TreeNode* t5=new TreeNode(5);
	    TreeNode* t3=new TreeNode(3);
	    TreeNode* t1=new TreeNode(1);
	    TreeNode* t4=new TreeNode(4);
	    TreeNode* t8=new TreeNode(8);
	    t5->left=t3;
	    t5->right=t8;
	    t3->left=t1;
	    t3->right=t4;
	    cout<<new54->isBST1(t5)<<endl;
		TreeNode* t2=new TreeNode(2);
		t1->left=t2;
		cout<<new54->isBST1(t1)<<endl;*/
	//    Solution50* new50 = new Solution50();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t51=new TreeNode(5);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t31=new TreeNode(3);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t11=new TreeNode(1);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t41=new TreeNode(4);
	//    TreeNode* t8=new TreeNode(8);
	//    TreeNode* t81=new TreeNode(8);
	//    t5->left=t3;
	//    t5->right=t8;
	//    t3->left=t1;
	//    t3->right=t4;
	//    t51->left=t81;
	//    t51->right=t31;
	//    t31->left=t11;
	//    t31->right=t41;
	//    cout<<new50->isTweakedIdentical(t5, t51)<<endl;
	//    Solution48* new48 = new Solution48();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t3=new TreeNode(3);
	//    TreeNode* t31=new TreeNode(3);
	//    TreeNode* t1=new TreeNode(1);
	//    TreeNode* t11=new TreeNode(1);
	//    TreeNode* t4=new TreeNode(4);
	//    TreeNode* t41=new TreeNode(4);
	//    t5->left=t3;
	//    t5->right=t31;
	//    t3->left=t1;
	//    t31->right=t11;
	//    t3->right=t4;
	//    t31->left=t41;
	//    cout<<new48->isSymmetric(t5)<<endl;
	//    Solution46* new46 = new Solution46();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t11=new TreeNode(11);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t14=new TreeNode(14);
	//    t5->left=t2;
	//    t5->right=t11;
	//    t11->left=t6;
	//    t11->right=t14;
	//    bool result46 = new46->isBalanced(t5);
	//    cout<<result46<<endl;
	//    Solution43* new43 = new Solution43();
	//    TreeNode* t5=new TreeNode(5);
	//    TreeNode* t2=new TreeNode(2);
	//    TreeNode* t11=new TreeNode(11);
	//    TreeNode* t6=new TreeNode(6);
	//    TreeNode* t14=new TreeNode(14);
	//    t5->left=t2;
	//    t5->right=t11;
	//    t11->left=t6;
	//    t11->right=t14;
	//    vector<int> result43 = new43->inOrder(t5);
	//    Solution41* new41 = new Solution41();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    ListNode* n2=new ListNode(2);
	//    ListNode* n4=new ListNode(4);
	//    ListNode* n6=new ListNode(6);
	//    ListNode* n8=new ListNode(8);
	//    ListNode* n10=new ListNode(10);
	//    n1->next=n2;
	//    n2->next=n3;
	//    n3->next=n4;
	//    n4->next=n5;
	//    ListNode* result41=new41->reorder(NULL);
	//    assert(result41==NULL);
	//    Solution40* new40 = new Solution40();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    n1->next=n3;
	//    n3->next=n5;
	//    n5->next=n7;
	//    n7->next=n9;
	//    ListNode* n2=new ListNode(2);
	//    ListNode* n4=new ListNode(4);
	//    ListNode* n6=new ListNode(6);
	//    ListNode* n8=new ListNode(8);
	//    ListNode* n10=new ListNode(10);
	//    n2->next=n4;
	//    n4->next=n6;
	//    n6->next=n8;
	//    n8->next=n10;
	//    ListNode* result40 = new40->merge(n1, n2);
	//    cout<<result40->value<<endl;
	//    Solution39* new39 = new Solution39();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    n1->next=n3;
	//    n3->next=n5;
	//    n5->next=n7;
	//    n7->next=n9;
	//    ListNode* result39 = new39->insert(n1, 8);
	//    cout<<result39->value<<endl;
	//    Solution37* new37 = new Solution37();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    n1->next=n3;
	//    n3->next=n5;
	//    n5->next=n7;
	//    n7->next=n9;
	//    n9->next=n1;
	//    bool result37 = new37->hasCycle(n1);
	//    cout<<result37<<endl;
	//    Solution36* new36 = new Solution36();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    n1->next=n3;
	//    n3->next=n5;
	//    n5->next=n7;
	//    n7->next=n9;
	//    ListNode* result36 = new36->middleNode(n1);
	//    cout<<result36->value<<endl;
	    //Solution34* new34 = new Solution34();
	    //ListNode* n1=new ListNode(1);
	    //ListNode* n3=new ListNode(3);
	    //ListNode* n5=new ListNode(5);
	    //ListNode* n7=new ListNode(7);
	    //ListNode* n9=new ListNode(9);
	    //n1->next=n3;
	    //n3->next=n5;
	    //n5->next=n7;
	    //n7->next=n9;
	    //ListNode* result34 = new34->reverse1(n1);
	    //cout<<result34->value<<endl;
	//    Solution32* new32 = new Solution32();
	//    cout<<new32->top()<<endl;
	//    cout<<new32->min()<<endl;
	//    new32->push(1);
	//    cout<<new32->top()<<endl;
	//    cout<<new32->min()<<endl;
	//    new32->push(2);
	//    cout<<new32->top()<<endl;
	//    cout<<new32->min()<<endl;
	//    new32->push(3);
	//    cout<<new32->top()<<endl;
	//    cout<<new32->min()<<endl;
	//    Solution31* new31 = new Solution31();
	//    cout<<new31->front()<<endl;
	//    new31->push(1);
	//    cout<<new31->front()<<endl;
	//    new31->push(2);
	//    cout<<new31->front()<<endl;
	//    new31->push(3);
	//    cout<<new31->front()<<endl;
	//    new31->pop();
	//    cout<<new31->front()<<endl;
	//    new31->pop();
	//    cout<<new31->front()<<endl;
	//    new31->pop();
	//    cout<<new31->front()<<endl;
	//    new31->pop();
	//    cout<<new31->front()<<endl;
	//    new31->pop();
	//    cout<<new31->front()<<endl;
	//    Solution267* new267 = new Solution267();
	//    vector<int> result267 = new267->search({{1,2,3}, {4,5,6}, {7,8,9}}, 8);
    /*Solution27* s27 = new Solution27();
    cout<<s27->kthSum({1, 3, 5}, {4, 8}, 1)<<endl;
    cout<<s27->kthSum({1, 3, 5}, {4, 8}, 2)<<endl;
    cout<<s27->kthSum({1, 3, 5}, {4, 8}, 3)<<endl;
    cout<<s27->kthSum({1, 3, 5}, {4, 8}, 4)<<endl;
    cout<<s27->kthSum({1, 3, 5}, {4, 8}, 5)<<endl;*/
	//    Solution17* new17 = new Solution17();
	//    int result17 = new17->solve({1, 3, 3, 4}, 2);
	//    cout<<result17<<endl;
	//    Solution16* new16 = new Solution16();
	//    int result16 = new16->lastOccur({1, 2, 2, 2, 3, 4}, 2);
	//    cout<<result16<<endl;
	//    Solution15* new15 = new Solution15();
	//    int result15 = new15->firstOccur({1, 2, 2, 2, 3, 4}, 2);
	//    cout<<result15<<endl;
	//    Solution14* new14 = new Solution14();
	//    int result14 = new14->solve({1, 2, 2, 2, 3, 4}, 2);
	//    cout<<result14<<endl;
	//    Solution13* new13 = new Solution13();
	//    long result13 = new13->power(-2, 5);
	//    cout<<result13<<endl;
	//    Solution12* new12 = new Solution12();
	//    long result12 = new12->fibonacci(6);
	//    cout<<result12<<endl;
	//    Solution258* new258 = new Solution258();
	//    vector<int> result258 = new258->moveZero({1, 0, 3, 0, 1});
	//    Solution11* new11 = new Solution11();
	//    vector<int> result11 = new11->rainbowSort({1, 0, 1, -1, 0});
	//    Solution10* new10 = new Solution10();
	//    vector<int> result10 = new10->quickSort({4, 2, -3, 6, 1});
	//    Solution9* new9 = new Solution9();
	//    vector<int> result9 = new9->mergeSort({4, 2, -3, 6, 1});
	//    Solution4* new4 = new Solution4();
	//    vector<int> result4 = new4->solve({4, 2, -3, 6, 1});
    //	cin.get();
	return 0;
}
