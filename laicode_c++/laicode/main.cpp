// laicode.cpp : 定义控制台应用程序的入口点。
//
#pragma once
#include"stdafx.h"

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

class UnknownSizeVector {
public:
	int get(int index) {
		//Return INT_MIN if out of bound;
		//Otherwise return the element value;
		return INT_MIN;
	}
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

class Solution4 {
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
public:
	long power(int a, int b) {
		if (a == 0) {
			return 0;
		}
		else if (b == 0) {
			return 1;
		}
		else if (b % 2 == 0) {
			long result = power(a, b / 2);
			return result*result;
		}
		else {
			long result = power(a, b / 2);
			return result*result*a;
		}
	}
};

class Solution14 {
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
private:
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

class Solution267 {
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
//        How is the binary tree represented?
//        
//        We use the level order traversal sequence with a special symbol "#" denoting the null node.
//        
//        For Example:
//        
//        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//        
//          1
//        
//        /   \
//        
//       2     3
//        
//            /
//        
//           4

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
//        How is the binary tree represented?
//        
//        We use the level order traversal sequence with a special symbol "#" denoting the null node.
//        
//        For Example:
//        
//        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//        
//           1
//        
//         /   \
//        
//        2     3
//        
//             /
//        
//            4
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
//        How is the binary tree represented?
//        
//        We use the level order traversal sequence with a special symbol "#" denoting the null node.
//        
//        For Example:
//        
//        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//        
//          1
//        
//        /   \
//        
//        2     3
//        
//            /
//
//           4
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
//        How is the binary tree represented?
//            
//            We use the level order traversal sequence with a special symbol "#" denoting the null node.
//            
//        For Example:
//            
//            The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//            
//              1
//            
//            /   \
//            
//            2     3
//            
//                 /
//            
//                4
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
//        Corner Cases
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
    
    void isBSTHelper1(TreeNode* root, TreeNode* &prev, bool* isbst) {
        if (root==NULL || *isbst==false) {
            return;
        }
        isBSTHelper1(root->left, prev, isbst);
        if(prev!=NULL) {
            *isbst &= root->value > prev->value;
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
        bool flag=true;
        bool *isbst=&flag;
        isBSTHelper1(root, min, isbst);
        return flag;
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
//            How is the binary tree represented?
//            
//            We use the level order traversal sequence with a special symbol "#" denoting the null node.
//            
//            For Example:
//            
//            The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//            
//               1
//            
//             /   \
//            
//            2     3
//            
//                 /
//            
//                4
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


class Solution281 {
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

class Solution172 {
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

class Solution175 {
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

class Solution197 {
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

class Solution253 {
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

class Solution121 {
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

class Solution124 {
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

class Solution126 {
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

class Solution292 {
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
		//int leng = array.size();
		//if (leng==0)
		//{
		//	return 0;
		//}
		//else if (leng == 1) {
		//	return array[0];
		//}
		//else if (leng == 2) {
		//	return max(array[0] * array[1], max(array[1], array[0]));
		//}
		//else {
		//	// 	//    	  0 2.0
		//	// 	//    	  1 -0.1
		//	// 	//    	  2 4
		//	// 	//    	  3 1.6
		//	// 	//    	  4 12
		//	double resultmax = DBL_MAX;
		//	for (int i = 0; i < leng; i++)
		//	{
		//		double loopmax = array[i];
		//		double current = array[i];
		//		resultmax = max(resultmax, current);
		//		for (int j = i; j >=0; j--)
		//		{
		//			if (j == i) {
		//				continue;
		//			}
		//			else {
		//				current = current*array[j];
		//				loopmax = max(loopmax, current);
		//				resultmax = max(resultmax, loopmax);
		//			}
		//		}
		//	}
		//	return resultmax;
		//}
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

class Solution108 {
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

class Solution111 {
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

class Solution115 {
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

class Solution125 {
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

class Solution127 {
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

class Solution129 {
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


class Solution258 {
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

class Solution261 {
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

class Solution138 {
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

class Solution143 {
public:
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

class Solution139 {
private:
	int maxPathSumHelper(TreeNode* root, int* global_max) {
		if (root == NULL) {
			return 0;
		}
		int left_in = maxPathSumHelper(root->left, global_max);
		int right_in = maxPathSumHelper(root->right, global_max);
		left_in = max(left_in, 0);
		right_in = max(right_in, 0);
		*global_max = max(*global_max, left_in + right_in + root->value);
		//from any node to any node
		return max(left_in, right_in) + root->value;
	}
public:
	int maxPathSum(TreeNode* root) {
		int result = INT_MIN;
		maxPathSumHelper(root, &result);
		return result;
	}
};

class Solution140 {
private:
	// Time = O(n^2)
	void maxPathSumHelper(TreeNode* root, vector<TreeNode*> path_prefix, int* global_max) {
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
				*global_max = max(*global_max, local_max[i]);
			}
			maxPathSumHelper(root->left, path_prefix, global_max);
			maxPathSumHelper(root->right, path_prefix, global_max);
			path_prefix.pop_back();
		}
	}
	// Time = O(n)
	void maxPathSumWorker(TreeNode* root, int presum, int* global_max) {
		if (root == NULL) {
			return;
		}
		if (presum <= 0) {
			presum = root->value;
		}
		else {
			presum += root->value;
		}
		*global_max = max(*global_max, presum);
		maxPathSumWorker(root->left, presum, global_max);
		maxPathSumWorker(root->right, presum, global_max);

	}
	// Bottom to Up
	int maxPathSumUpper(TreeNode* root, int presum, int* global_max) {
		if (root == NULL) {
			return 0;
		}
		int left_sum = maxPathSumUpper(root->left, presum, global_max);
		int right_sum = maxPathSumUpper(root->right, presum, global_max);
		int temp = max(0, max(left_sum, right_sum));
		*global_max = max(*global_max, temp);
		return temp + root->value;
	}
public:
	int maxPathSum(TreeNode* root) {
		int result = INT_MIN;
		//        vector<TreeNode*> routes;
		//        maxPathSumHelper(root, routes, &result);
		//        maxPathSumWorker(root, 0, &result);
		maxPathSumUpper(root, 0, &result);
		return result;
	}
};

class Solution141 {
private:
	void matchedSumHelper(TreeNode* root, int presum, int target, unordered_map<int, int>& mymap, int* found) {
		if (root == NULL) {
			return;
		}
		presum += root->value;
		if (mymap[presum - target] != 0) {
			*found = 1;
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
		matchedSumHelper(root, 0, target, mymap, &found);
		return found == 1;
	}
};

class Solution211 {
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

class Solution213 {
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

class Solution215 {
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

class Solution131 {
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
				cout << min_heap.size() << endl;
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
public:
	void closestHelper(TreeNode* root, int target, int* solution) {
		if (root == NULL) {
			return;
		}
		if (root->value < target) {
			if (abs(root->value - target) < abs(*solution - target)) {
				*solution = root->value;
			}
			closestHelper(root->right, target, solution);
		}
		else if (root->value > target) {
			if (abs(root->value - target) < abs(*solution - target)) {
				*solution = root->value;
			}
			closestHelper(root->left, target, solution);
		}
		else {
			*solution = target;
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
			closestHelper(root, target, &solution);
			return solution;
		}
	}
};

class Solution136 {
public:
	void largestSmallerHelper(TreeNode* root, int target, int* solution) {
		if (root == NULL) {
			return;
		}
		else if (root->value >= target) {
			largestSmallerHelper(root->left, target, solution);
		}
		else {
			*solution = root->value;
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
			largestSmallerHelper(root, target, &solution);
			return solution;
		}
	}
};

class Solution137 {
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
						cout << matrix[i][j] << "\t" << matrix[i][k] << "\t" << matrix[k][j] << "\t" << fullcuts[j] << "\t" << fullcuts[i] << endl;
						matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j] + fullcuts[j] - fullcuts[i]);
					}
				}
			}
		}
		return matrix[0][leng - 1];
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

class Solution63 {
//    All Subsets II
//    Given a set of characters represented by a String, return a list containing all subsets of the characters.
//    
//    Assumptions
//    
//    There could be duplicate characters in the original set.
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

class Solution171 {
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


class Solution178 {
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

class Solution186 {
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

class Solution188 {
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

class Solution176 {
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

class Solution191 {
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


class Solution193 {
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

class Solution198 {
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

class Solution183 {
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

class Solution187 {
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

class Solution192 {
//    0 0
//    1 0
//    0 1
//    2 0
//    1 1
//    3 0
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

class Solution196 {
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

class Solution201 {
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


int generateMatrix(vector<vector<int>>& matrix, int rows, int cols) {
    int count=1;
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            matrix[i][j]=count++;
        }
    }
    return 0;
}
int printSpiral(vector<vector<int>>& matrix, int offset, int rows, int cols) {
    if(rows<=0 || cols<=0) {
        return 0;
    }
    if(rows==1) {
        for(int x=0;x<cols;x++) {
            cout<<matrix[0+offset][x+offset]<<",";
        }
        return 0;
    }
    if(cols==1) {
        for(int x=0;x<rows;x++) {
            cout<<matrix[x+offset][0+offset]<<",";
        }
        return 0;
    }
    for(int i=0;i<cols-1;i++) {
        cout<<matrix[0+offset][i+offset]<<",";
    }
    for(int j=0;j<rows-1;j++) {
        cout<<matrix[j+offset][cols-1-offset]<<",";
    }
    for(int m=cols-1;m>0;m--) {
        cout<<matrix[rows-1-offset][m+offset]<<",";
    }
    for(int n=rows-1;n>0;n--) {
        cout<<matrix[n+offset][0+offset]<<",";
    }
    printSpiral(matrix, offset+1, rows-2, cols-2);
    return 0;
}

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

bool comparebyscore(const vector<int>& a, const vector<int>& b) {
    if(a[1]>=b[1]) {
        return true;
    }
    return false;
}

vector<vector<int>> sorting(vector<vector<int>>& input) {
    vector<vector<int>> result=input;
    sort(result.begin(), result.end(), comparebyscore);
    return result;
}

class Solution207 {
public:
    vector<int> majority(vector<int> array) {
        // write your solution here
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
            if(comptime==ks.size()-1) {
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

class Solution212 {
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

class Solution214 {
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

class Solution219 {
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

class Solution235 {
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

class Solution315 {
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

class Solution342 {
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

class Solution348 {
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

class Solution350 {
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

// To execute C++, please define "int main()"
int main() {
    Solution400* s400 = new Solution400();
    s400->rainbowSortIII({1}, 1);
    s400->rainbowSortIII({1, 3, 2, 1, 2} , 3);
    s400->rainbowSortIII({3, 1, 5, 5, 1, 4, 2}, 5);
    
    Solution399* s399 = new Solution399();
    s399->rainbowSortII({0} );
    s399->rainbowSortII({1,0} );
    s399->rainbowSortII({1, 3, 1, 2, 0} );
//    Solution383* s383 = new Solution383();
//    s383->reverseWords(" I  love  Google  ");
//    Solution350* s350 = new Solution350();
//    int r350 = s350->minReplacements("bbbbbaaaab");
//    r350 = s350->minReplacements("aaabbabbaaaabba");
//    r350 = s350->minReplacements("aaaaaaaa");
//    Solution348* s348 = new Solution348();
//    s348->reverse("abbegi");
//    Solution342* s342 = new Solution342();
//    cout<<s342->isomorphic("aba", "aaa")<<endl;
//    cout<<s342->isomorphic("hhkkhhkkk", "ccddcceee")<<endl;
//    cout<<s342->isomorphic( "fgh","ghf" )<<endl;
//    Solution315* s315 = new Solution315();
//    vector<int> r315 = s315->dedup({1, 2, 2, 3, 3, 3});
//    r315 = s315->dedup({2, 1, 2, 2, 2, 3});
//    r315 = s315->dedup({4,4,4,1,2,3,3,3});
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
	//    largestAndSecond({2, 1, 5, 4, 3});
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
	//    Solution261* new261 = new Solution261();
	//    vector<int> result261 = new261->sortSpecial({4,2,1,3}, {});
	//    printintArray(result261);
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
Solution91* s91 = new Solution91();
s91->minJump({1, 3, 1, 2, 2}, 2);
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
	//    Solution34* new34 = new Solution34();
	//    ListNode* n1=new ListNode(1);
	//    ListNode* n3=new ListNode(3);
	//    ListNode* n5=new ListNode(5);
	//    ListNode* n7=new ListNode(7);
	//    ListNode* n9=new ListNode(9);
	//    n1->next=n3;
	//    n3->next=n5;
	//    n5->next=n7;
	//    n7->next=n9;
	//    ListNode* result34 = new34->reverse(n1);
	//    cout<<result34->value<<endl;
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
