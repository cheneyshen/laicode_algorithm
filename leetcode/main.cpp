//
//  main.cpp
//  leetcode
//
//  Created by spring  on 8/25/16.
//  Copyright © 2016 spring . All rights reserved.
//

#include <iostream>
#include <vector>
#include <stack>
#include <math.h>
#include <set>
#include <queue>
#include <string>
#include <unordered_map>
#include <map>
// C++ program to find largest rectangle with all 1s
// in a binary matrix
using namespace std;


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
    TreeNodeP(int v, TreeNodeP* p):
    value(v), left(NULL), right(NULL), parent(p) {}
};

//vector<int> search(vector<vector<int>> matrix, int target) {
//    // write your solution here.
//    int row=matrix.size(), col=matrix[0].size();
//    vector<int> result;
//    if(row==0 || col==0) {
//        return {-1, -1};
//    }
//    int left=0, right=row-1;
//    int mid=0;
//    while(left<=right) {
//        mid=left+(right-left)/2;
//        if(matrix[mid][0]==target) {
//            //left=mid;
//            result.push_back(mid);
//            result.push_back(0);
//            return result;
//        }
//        else if(matrix[mid][0]>target) {
//            right=mid-1;
//        }
//        else {
//            left=mid+1;
//        }
//    }
//    if(right<0) {
//        return {-1, -1};
//    }
//    int from=0, end=col-1;
//    mid=0;
//    while(from<=end) {
//        mid=(end+from)/2;
//        if(matrix[right][mid]==target) {
//            result.push_back(right);
//            result.push_back(mid);
//            return result;
//        }
//        else if(matrix[right][mid]>target) {
//            end=mid-1;
//        }
//        else {
//            from=mid+1;
//        }
//    }
//    return {-1,-1};
//}
//
//vector<int> kClosest(vector<int> array, int target, int k) {
//    if(array.size()==0)
//        return array;
//    
//    vector<int> result;
//    if(k==0) {
//        return result;
//    }
//    int left=0, right=array.size()-1;
//    int mid=0;
//    while(left<right-1) {
//        mid=left+(right-left)/2;
//        if(array[mid]==target) {
//            right=mid;
//        }
//        else if(array[mid]>target) {
//            right=mid;
//        }
//        else {
//            left=mid;
//        }
//    }
//    while(left>=0 && right<array.size() && k) {
//        if(abs(array[left]-target)<=abs(array[right]-target)) {
//            result.push_back(array[left]);
//            k--;left--;
//        }
//        else {
//            result.push_back(array[right]);
//            k--;right++;
//        }
//    }
//    while(left>=0 && k) {
//        result.push_back(array[left]);
//        k--;left--;
//    }
//    
//    while(right<array.size() && k) {
//        result.push_back(array[right]);
//        k--;right++;
//    }
//    return result;
//}
//
//
//void quickSortHelper(vector<int>& array, int left, int right) {
//    if(left>=right)
//        return;
//    int pivot=left+(right-left)/2;
//    swap(array[pivot], array[right]);
//    int idx=left;
//    for(int i=left;i<right;i++) {
//        if(array[i]<array[right]) {
//            swap(array[i], array[idx]);
//            idx++;
//        }
//    }
//    swap(array[idx], array[right]);
//    quickSortHelper(array, left, idx-1);
//    quickSortHelper(array, idx+1, right);
//}
//vector<int> quickSort(vector<int> array) {
//    if(array.size()==0 || array.size()==1)
//        return array;
//    vector<int> result=array;
//    quickSortHelper(result, 0, (int)array.size()-1);
//    return result;
//}
//// Returns area of the largest rectangle with all 1s in A[][]
//int maxRectangle(vector<vector<char>>& matrix) {
//    /*
//    if(matrix.empty())  return 0;
//    int rows=matrix.size(), cols=matrix[0].size();
//    pair<int,int> apair, bpair, cpair;
//    vector<vector<pair<int,int>>> area(rows, vector<pair<int,int>>(cols));
//    if(matrix[0][0]=='1') {
//        area[0][0]=make_pair(1,1);
//    }
//    else {
//        area[0][0]=make_pair(0,0);
//    }
//    for(int i=1;i<rows;++i) {
//        if(matrix[i-1][0]=='1' && matrix[i][0]=='1') {
//            area[i][0].first=area[i-1][0].first+1;
//        }
//        else if(matrix[i][0]=='1'){
//            area[i][0].first=1;
//        }
//        else {
//            area[i][0].first=0;
//        }
//        area[i][0].second=0;
//    }
//    for(int j=1;j<cols;++j) {
//        if(matrix[0][j]=='1' && matrix[0][j-1]=='1') {
//            area[0][j].second=area[0][j-1].second+1;
//        }
//        else if(matrix[0][j]=='1') {
//            area[0][j].second=1;
//        }
//        else {
//            area[0][j].second=0;
//        }
//        area[0][j].first=0;
//    }
//    int maxSize=area[0][0].first*area[0][0].second;
//    for (int i=1;i<rows;++i) {
//        for (int j=1;j<cols;++j) {
//            if (matrix[i][j]=='1' && matrix[i][j-1]=='1' && matrix[i-1][j]=='1') {
//                apair=area[i-1][j];
//                bpair=area[i][j-1];
//                
//                cpair.first=apair.first+1;
//                cpair.second=bpair.second+1;
//                maxSize=max(maxSize, cpair.first*cpair.second);
//                area[i][j]=cpair;
//            }
//            else if (matrix[i][j]=='1' && matrix[i-1][j]=='1') {
//                apair=area[i-1][j];
//                
//                cpair.first=apair.first+1;
//                cpair.second=1;
//                maxSize=max(maxSize, cpair.first*cpair.second);
//                area[i][j]=cpair;
//            }
//            else if (matrix[i][j]=='1' && matrix[i][j-1]=='1') {
//                bpair=area[i][j-1];
//                cpair.first=1;
//                cpair.second=bpair.second+1;
//                maxSize=max(maxSize, cpair.first*cpair.second);
//                area[i][j]=cpair;
//            }
//            else if(matrix[i][j]=='1') {
//                cpair=make_pair(1, 1);
//                maxSize=max(maxSize, cpair.first*cpair.second);
//                area[i][j]=cpair;
//            }
//            else {
//                cpair=make_pair(0, 0);
//                area[i][j]=cpair;
//            }
//        }
//    }
//    return maxSize;
//    */
//    /*
//    int rows=matrix.size(), cols=matrix[0].size();
//    if(rows==0||cols==0)
//        return 0;
//    vector<int> dp(rows, 0);
//    int maxarea=0;
//    for(int i=0;i<cols;i++) {
//        cout<<"i:"<<i<<endl;
//        stack<int> s;
//        for(int j=0;j<=rows;j++) {
//            if(j<rows) {
//                if(matrix[i][j]=='1')
//                    dp[j]=dp[j]+1;
//                else
//                    dp[j]=0;
//                cout<<"dp[j]:"<<dp[j]<<endl;
//            }
//            while(!s.empty() && (j==rows||dp[s.top()]>dp[j])) {
//                int h=dp[s.top()];
//                cout<<"h:"<<h<<endl;
//                while(!s.empty()&&dp[s.top()]==h)
//                    s.pop();
//                int idx=s.empty()?-1:s.top();
//                
//                cout<<"idx:"<<idx<<endl;
//                if(maxarea<h*(j-idx-1))
//                    maxarea=h*(j-idx-1);
//                
//                cout<<"maxarea:"<<maxarea<<endl;
//            }
//            s.push(j);
//            
//            cout<<"j:"<<j<<endl;
//        }
//    }
//    return maxarea;
//    if(matrix.empty())
//        return 0;
//    int rows=(int)matrix.size();
//    int cols=(int)matrix[0].size();
//    int left[cols]={0};
//    int right[cols]={cols};
//    int height[cols]={0};
//    int maxarea;
//    for(int i=0;i<rows;i++) {
//        int curleft=0, curright=cols;
//        cout<<"i:"<<i<<"rows:"<<rows<<endl;
//        for(int j=0;j<cols;j++) {
//            if(matrix[i][j]=='1')
//                height[j]++;
//            else
//                height[j]=0;
//            //cout<<"height[j]:"<<height[j]<<endl;
//        }
//        for(int j=0;j<cols;j++) {
//            if(matrix[i][j]=='1')
//                left[j]=max(left[j], curleft);
//            else {
//                left[j]=0;
//                curleft=j+1;
//            }
//        }
//        for(int j=cols-1;j>=0;j--) {
//            if(matrix[i][j]=='1')
//                right[j]=min(right[j], curright);
//            else {
//                right[j]=cols;
//                curright=j;
//            }
//        }
//        for(int j=0;j<cols;j++)
//            maxarea=max(maxarea, (right[j]-left[j])*height[j]);
//    }
//     return maxarea;
//     */
//    return 0;
//}
//string getHint(string secret, string guess) {
//    int m[256] = {0}, bulls = 0, cows = 0;
//    for (int i = 0; i < secret.size(); ++i) {
//        if (secret[i] == guess[i]) ++bulls;
//        else {
//            cout<<secret[i]<<"before:"<<m[secret[i]]<<endl;
//            if (m[secret[i]]++ < 0) ++cows;
//            cout<<secret[i]<<"after:"<<m[secret[i]]<<endl;
//            cout<<guess[i]<<"before:"<<m[guess[i]]<<endl;
//            if (m[guess[i]]-- > 0) ++cows;
//            cout<<guess[i]<<"after:"<<m[guess[i]]<<endl;
//        }
//    }
//    return to_string(bulls) + "A" + to_string(cows) + "B";
//}
//
///* This function takes last element as pivot, places
// the pivot element at its correct position in sorted
// array, and places all smaller (smaller than pivot)
// to left of pivot and all greater elements to right
// of pivot */
//
//
//int comparator(int a, int b) {
//    int x=(int)log10(a);
//    int y=(int)log10(b);
//    if(x>y) {
//        if(a>=b*pow(10, x-y))
//            return 1;//34>2
//        else
//            return 2;//34<5
//    }
//    else {
//        if(b>a*pow(10, y-x))
//            return 2;//5>34
//        else
//            return 1;//2<34
//    }
//    //a and b are unique, impossible equal
//}
//
//int partition (int arr[], int low, int high)
//{
//    int pivot = arr[high];    // pivot
//    int i = (low - 1);  // Index of smaller element
//    
//    for (int j = low; j <= high- 1; j++)
//    {
//        // If current element is smaller than or
//        // equal to pivot
//        if (comparator(arr[j], pivot)==2)
//        {
//            i++;    // increment index of smaller element
//            swap(arr[i], arr[j]);
//        }
//    }
//    swap(arr[i + 1], arr[high]);
//    return (i + 1);
//}
//
///* The main function that implements QuickSort
// arr[] --> Array to be sorted,
// low  --> Starting index,
// high  --> Ending index */
//void quickSort(int arr[], int low, int high)
//{
//    if (low < high)
//    {
//        /* pi is partitioning index, arr[p] is now
//         at right place */
//        int pi = partition(arr, low, high);
//        
//        // Separately sort elements before
//        // partition and after partition
//        quickSort(arr, low, pi - 1);
//        quickSort(arr, pi + 1, high);
//    }
//}
//
///* Function to print an array */
//void printArray(int arr[], int size)
//{
//    int i;
//    for (i=0; i < size; i++)
//        printf("%d ", arr[i]);
//    printf("\n");
//}
///*
//void quickSort(int arr[], int left, int right) {
//    int i=left, j=right;
//    int pivot=arr[(left+(right-left)/2)];
//    while(i<=j) {
//        while(comparator(arr[i], pivot)==2)
//            i++;
//        while(comparator(arr[j], pivot)==1)
//            j--;
//        if(i<=j) {
//            swap(arr[i], arr[j]);
//            i++;
//            j--;
//        }
//    }
//    if(left<j)
//        quickSort(arr, left, j);
//    if(right>i)
//        quickSort(arr, i, right);
//}
//
//*/
//struct comp{
//    bool operator()(const string& a, const string& b){
//        return string( a + b ) < string( b + a );
//    }
//};
//
//struct node
//{
//    int data;
//    node *left;
//    node *right;
//};
///*
//node *tree=NULL;
//int count=1;
//node *insert(node *tree,int ele)
//{
//    if(tree==NULL)
//    {
//        tree=new node;
//        tree->left=tree->right=NULL;
//        tree->data=ele;
//        count++;
//    }
//    else
//        if(count%2==0)
//            tree->left=insert(tree->left,ele);
//        else
//            tree->right=insert(tree->right,ele);
//    return(tree);
//}
//*/
//// Driver program to test above functions
//class TrieNode {
//public:
//    // Initialize your data structure here.
//    char val;
//    TrieNode* son[27]; //sons for "abcdefghijklmnopqrstuvwxyz\0"
//    TrieNode() {
//        memset(son, 0, sizeof(son));
//    }
//};
//
//class Trie {
//    
//public:
//    Trie() {
//        root = new TrieNode();
//        root->val='\0';
//    }
//    
//    // Inserts a word into the trie.
//    void insert(string word) {
//        TrieNode* cur=root;
//        for(int idx=0;idx<=word.length();idx++) {
//            if(word[idx]=='\0') {
//                cur->son[26]=new TrieNode();
//                cur->son[26]->val='\0';
//                return;
//            }
//            int val=word[idx]-'a';
//            if(cur->son[val]==nullptr) {
//                cur->son[val]=new TrieNode();
//                cur->son[val]->val=word[idx];
//            }
//            cur=cur->son[val];
//        }
//    }
//    
//    bool searchHelper(TrieNode* root, string& word, int idx) {
//        if(word[idx]=='\0') {
//            if(root->son[26]!=nullptr)
//                return true;
//            else
//                return false;
//        }
//        if(root->son[word[idx]-'a']==nullptr)
//            return false;
//        else
//            return searchHelper(root->son[word[idx]-'a'], word, idx+1);
//    }
//    // Returns if the word is in the trie.
//    bool search(string word) {
//        return searchHelper(root, word, 0);
//    }
//    
//    bool startsWithHelper(TrieNode* root, string& prefix, int idx) {
//        if(prefix[idx]=='\0')
//            return true;
//        if(root->son[prefix[idx]-'a']==nullptr) {
//            return false;
//        }
//        else
//            return startsWithHelper(root->son[prefix[idx]-'a'], prefix, idx+1);
//    }
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    bool startsWith(string prefix) {
//        return startsWithHelper(root, prefix, 0);
//    }
//    
//private:
//    TrieNode* root;
//};
//
//
//int HammingDistance(int num1, int num2) {
//    int find=0;
//    while(num1 || num2) {
//        find += (num1%2) ^ (num2%2);
//        num1=num1>>1;
//        num2=num2>>1;
//    }
//    return find;
//}
//
//
//vector<int> mergeSort(vector<int>& array, int left, int right) {
//    vector<int> result;
//    if(left==right) {
//        result.push_back(array[left]);
//        return result;
//    }
//    int mid=left+(right-left)/2;
//    vector<int> leftarray=mergeSort(array, left, mid);
//    vector<int> rightarray=mergeSort(array, mid+1, right);
//    int i=0, j=0;
//    while(i<leftarray.size() && j<rightarray.size()) {
//        if(leftarray[i]<=rightarray[j]) {
//            result.push_back(leftarray[i]);
//            i++;
//        }
//        else {
//            result.push_back(rightarray[j]);
//            j++;
//        }
//    }
//    while(i<leftarray.size()) {
//        result.push_back(leftarray[i]);
//        i++;
//    }
//    while(j<rightarray.size()) {
//        result.push_back(rightarray[j]);
//        j++;
//    }
//    return result;
//}
//
//void printArray(vector<int> A)
//{
//    int i;
//    for (i=0; i < A.size(); i++)
//        cout<<A[i]<<" ";
//    cout<<endl;
//}
//
//void allsubsetsi(string input, string& current, vector<string>& result) {
//    if(input.size()==0) {
//        result.push_back(current);
//        return;
//    }
//    current.push_back(input[0]);
//    allsubsetsi(input.substr(1), current, result);
//    current.pop_back();
//    allsubsetsi(input.substr(1), current, result);
//}
//
//vector<string> solve61(string input) {
//    vector<string> result;
//    if(input.length()==0) {
//        return result;
//    }
//    else if(input=="") {
//        result.push_back("");
//        return result;
//    }
//    string temp;
//    allsubsetsi(input, temp, result);
//    return result;
//}
//
//void allpermutationsi(string input, int index, vector<string>& result) {
//    if(index==input.size()) {
//        result.push_back(input);
//    }
//    for(int i=index;i<input.size();i++) {
//        swap(input[i], input[index]);
//        allpermutationsi(input, index+1, result);
//    }
//}
//vector<string> solve62(string input) {
//    vector<string> result;
//    if(input.size()==0)
//        return result;
//    allpermutationsi(input, 0, result);
//    return result;
//}
//
//void allvalidpermutationsofparenthesesi(string permu, int left, int right, int num, vector<string>& result) {
//    if(permu.size()==2*num) {
//        result.push_back(permu);
//        return;
//    }
//    if(left<num) {
//        permu+="(";
//        allvalidpermutationsofparenthesesi(permu, left+1, right, num, result);
//        permu.pop_back();
//    }
//    if(right<left) {
//        permu+=")";
//        allvalidpermutationsofparenthesesi(permu, left, right+1, num, result);
//        permu.pop_back();
//    }
//}
//
//vector<string> solve63(int num) {
//    vector<string> result;
//    string permu="";
//    int left=0, right=0;
//    if(num==0)
//        return result;
//    else if(num==1) {
//        result.push_back("()");
//        return result;
//    }
//    else {
//        allvalidpermutationsofparenthesesi(permu, left, right, num, result);
//        return result;
//    }
//}
//
//
//void combinationsofcoins(int target, const vector<int>& coins, int index, int combos[], vector<vector<int>>& result) {
//    if(index==coins.size()-1 && (target%coins[coins.size()-1]==0)) {
//        combos[index]=target/coins[coins.size()-1];
//        std::vector<int> v(combos, combos + coins.size());
//        result.push_back(v);
//        return;
//    }
//    else if(index<coins.size()-1){
//        for(int i=0;i<=target/coins[index];i++) {
//            combos[index]=i;
//            combinationsofcoins(target-coins[index]*i, coins, index+1, combos, result);
//        }
//    }
//}
//
//vector<vector<int> > solve64(int target, vector<int> coins) {
//    vector<vector<int>> result;
//    int length=(int)coins.size();
//    int combos[length];
//    sort(coins.begin(), coins.end(), [](const int a, const int b) {return a > b; });
////    sort(coins.begin(), coins.end());
//    combinationsofcoins(target, coins, 0, combos, result);
//    return result;
//}
//
//vector<vector<int> > solve65(TreeNode* root) {
//    
//    vector<vector<int> > resultset;
//    if(!root) {
//        return resultset;
//    }
//    queue<TreeNode*> q;
//    q.push(root);
//    while(!q.empty()) {
//        int leng=q.size();
//        vector<int> level;
//        for(int i=0;i<leng;i++) {
//            TreeNode* head=q.front();
//            q.pop();
//            level.push_back(head->value);
//            if(head->left) {
//                q.push(head->left);
//            }
//            if(head->right) {
//                q.push(head->right);
//            }
//        }
//        resultset.push_back(level);
//    }
//    return resultset;
//}


// struct Kfreq {
//   string Str;
//   int Freq;
//   Kfreq(string str, int freq):
//   Str(str), Freq(freq) {}
//   bool operator<(const Kfreq& a, const Kfreq& b) {
//     return a.Freq<b.Freq;
//   }
// };
class comphelper {
public:
    bool operator() (pair<string, int> left, pair<string, int> right) {
        return left.second< right.second;
    }
};
vector<string> topKFrequent(vector<string> combo, int k) {
    // write your solution here
    //     unordered_map<string, int> map;
    //     for(int i=0;i<combo.size();i++) {
    //         unordered_map<string, int>::const_iterator cursor=map.find(combo[i]);
    //         if(cursor==map.end()) {
    //             map.insert(pair<string,int>(combo[i],1));
    //         }
    //         else {
    //             map[combo[i]]=cursor->second+1;
    //         }
    //     }
    //     priority_queue<Kfreq> q;
    //     for(auto it=map.begin();it!=map.end();it++) {
    //         q.push(Kfreq{it->first, it->second});
    //     }
    //     vector<string> result;
    //     while(!q.empty()) {
    //         Kfreq kt = q.top();
    //         result.push_back(kt.Str);
    //         q.pop();
    //     }
    //    for(int i=0;i<k && i<result.size();i++) {
    //        cout<<result[i]<<" "<<endl;
    //    }
    //     return result;
    vector<string> result;
    if(k<=0 || combo.size()==0) {
        return result;
    }
    map<string ,int> mapper;
    for(int i=0;i<combo.size();i++) {
        mapper[combo[i]]++;
    }
    priority_queue<pair<string, int>, vector<pair<string, int>>, comphelper> pq;
    for(map<string, int>::iterator it=mapper.begin();it!=mapper.end();it++) {
        pq.push(*it);
//        if(pq.size()>k) {
//            pq.pop();
//        }
    }
    while(!pq.empty()) {
        result.push_back(pq.top().first);
        pq.pop();
    }
    for(int i=0;i<k;i++) {
        cout<<result[i]<<" "<<endl;
    }
    return result;
}

int missing(vector<int> array) {
//    // write your solution here
//    long result=0;
//    int i;
//    for(i=0;i<array.size();i++) {
//        result+=array[i];
//    }
//    return int(long((i+2)*(i+1)/2)-result);
//    int result=0;
//    for(int i=0;i<array.size();i++) {
//        result=i^array[i];
//    }
//    return result;
    if(array.size()==0) {
        return 1;
    }
    int x1=array[0];
    int x2=1;
    for(int i=1;i<array.size();i++) {
        x1^=array[i];
    }
    for(int i=2;i<=array.size()+1;i++) {
        x2^=i;
    }
    return x1^x2;
}


vector<int> common(vector<int> a, vector<int> b) {
    vector<int> result;
    if(a.size()==0 || b.size()==0) {
        return {};
    }
    unordered_map<int, int> map;
    unordered_map<int, int>::const_iterator cursor;
    for(int i:a) {
        cursor=map.find(i);
        if(cursor==map.end()) {
            map.insert(pair<int,int>(i,1));
        }
        else {
            map[i]=cursor->second+1;
        }
    }
    for(int i:b) {
        cursor=map.find(i);
        if(cursor!=map.end()) {
            if(map[i]>0) {
                result.push_back(i);
                map[i]--;
            }
        }
    }
    return result;
}

bool isPowerOfTwo(int number) {
    // write your solution here
    long lower=(long)number - 1;
    bool result = (long)number & lower;
    if(result==0) {
        return true;
    }
    else {
        return false;
    }
}


int diffBits(int a, int b) {
    // write your solution here
//    int count=0;
//    int a1=0, b1=0;
//    while(a!=0 || b!=0) {
//        a1=a&1;
//        b1=b&1;
//        count+=a1^b1;
//        a>>=1;
//        b>>=1;
//    }
//    return count;
    int count=0;
    int result=a^b;
    while(result) {
        count+=result&1;
        result>>=1;
    }
    return count;
}

string Change(int x) {
    string result;
    char cur;
    while(x>0) {
        int remainder=x%16;
        if(remainder<=9) {
            cur='0'+remainder;
        }
        else {
            cur='A'+remainder-10;
        }
        result.push_back(cur);
        x=x/16;
    }
    result.push_back('X');
    result.push_back('0');
    reverse(result.begin(),result.end());
    return result;
}


bool allUnique(string s) {
    int mapper[8]={0};
    for(int i=0;i<s.size();i++) {
        int aa=s[i]/32;
        int bb=s[i]%32;
        if(((mapper[aa]>>bb)&1)==true) {
            return false;
        }
        else {
            mapper[aa]|=(1<<bb);
        }
    }
    return true;
}

void spiralHelper(vector<vector<int>>& input, vector<int>& result, int offset, int size) {
    if(size==1) {
        result.push_back(input[0+offset][0+offset]);
        return;
    }
    else if(size==0) {
        return;
    }
    for(int i=0;i<size-1;i++) {
        result.push_back(input[0+offset][i+offset]);
    }
    for(int i=0;i<size-1;i++) {
        result.push_back(input[i+offset][offset+size-1]);
    }
    for(int j=size-1;j>0;j--) {
        result.push_back(input[offset+size-1][offset+j]);
    }
    for(int j=size-1;j>0;j--) {
        result.push_back(input[offset+j][0+offset]);
    }
    spiralHelper(input, result, offset+1, size-2);
}
vector<int> spiral(vector<vector<int>> input) {
    if(input.size()==0) {
        return {};
    }
    vector<int> result;
    spiralHelper(input, result, 0, (int)input.size());
    return result;
}

void spiralHelper2(vector<vector<int>>& matrix, vector<int>& result, int offset, int m, int n) {
    /*
     1个或者1行或者1列
     */
    if(m==0 && n==0) {
        return;
    }
    else if(m==1 && n==1) {
        result.push_back(matrix[offset+m-1][offset+n-1]);
        return;
    }
    else if(m==1) {
        for(int i=0;i<n;i++) {
            result.push_back(matrix[offset+m-1][offset+i]);
        }
        return;
    }
    else if(n==1) {
        for(int i=0;i<m;i++) {
            result.push_back(matrix[offset+i][offset+n-1]);
        }
        return;
    }
    for(int i=0;i<n-1;i++) {
        result.push_back(matrix[0+offset][i+offset]);
    }
    for(int i=0;i<m-1;i++) {
        result.push_back(matrix[i+offset][n-1+offset]);
    }
    for(int j=n-1;j>0;j--) {
        result.push_back(matrix[m-1+offset][j+offset]);
    }
    for(int j=m-1;j>0;j--) {
        result.push_back(matrix[j+offset][0+offset]);
    }
    spiralHelper2(matrix, result, offset+1, m-2, n-2);
}
vector<int> spiral2(vector<vector<int>> matrix) {
    int m=matrix.size(), n=matrix[0].size();
    vector<int> result;
    if(m==0) {
        return result;
    }
    else if(n==0) {
        return result;
    }
    spiralHelper2(matrix, result, 0, m, n);
    return result;
}

void solveHelper(vector<vector<int>>& matrix, int count, int offset, int m, int n) {
    int counter=count;
    if(m==0 || n==0) {
        return;
    }
    else if(m==1) {
        for(int i=0;i<n;i++) {
            matrix[m-1+offset][i+offset]=counter++;
        }
        return;
    }
    else if(n==1) {
        for(int i=0;i<m;i++) {
            matrix[i+offset][n-1+offset]=counter++;
        }
        return;
    }
    for(int i=0;i<n-1;i++) {
        matrix[0+offset][i+offset]=counter++;
    }
    for(int i=0;i<m-1;i++) {
        matrix[i+offset][n-1+offset]=counter++;
    }
    for(int j=n-1;j>0;j--) {
        matrix[m-1+offset][j+offset]=counter++;
    }
    for(int j=m-1;j>0;j--) {
        matrix[j+offset][0+offset]=counter++;
    }
    solveHelper(matrix, counter, offset+1, m-2, n-2);
}
vector<vector<int>> solve(int m, int n) {
    vector<vector<int>> result;
    if(m==0 || n==0) {
        return result;
    }
    else if(m==1) {
        vector<int> row;
        for(int i=0;i<n;i++) {
            row.push_back(i+1);
        }
        result.push_back(row);
        return result;
    }
    else if(n==1) {
        for(int i=0;i<m;i++) {
            vector<int> col;
            col.push_back(i+1);
            result.push_back(col);
        }
        return result;
    }
    for(int i=0;i<m;i++) {
        vector<int> col;
        for(int j=0;j<n;j++) {
            col.push_back(0);
        }
        result.push_back(col);
    }
    solveHelper(result, 1, 0, m, n);
    return result;
}

vector<vector<int>> generateMatrix(int m, int n) {
    vector<vector<int> > result(m, vector<int>(n));
    int size=m*n;
    int offset=0;
    int k=1;
    while (k<=size)
    {
        int j = offset;
        // four steps
        while( j < n - offset && k <= size)             // 1. horizonal, left to right
            result[offset][j++] = k++;
        j=offset+1;
        while( j < m - offset && k <= size)             // 2. vertical, top to bottom
            result[j++][n-offset-1] = k++;
        j = n - offset - 2;
        while( j > offset && k <= size)                  // 3. horizonal, right to left
            result[m-offset-1][j--] = k++;
        j = m - offset - 1;
        while( j > offset && k <= size)                  // 4. vertical, bottom to  top
            result[j--][offset] = k++;
        offset++;      // next loop
    }
    return result;
}

bool checkCombo(vector<int>& rows, int idx, int col) {
    for(int i=0;i<idx;i++) {
        if(col==rows[i]) {
            return false;
        }
        if(col-rows[i]==abs(idx-i)) {
            return false;
        }
    }
    return true;
}

void nQueen(vector<vector<int>>& result, vector<int>& combo, int current, const int n) {
    if(current==n) {
        result.push_back(combo);
    }
    for(int i=0;i<n;i++) {
        if(checkCombo(combo, current, i)) {
            combo[current]=i;
            nQueen(result, combo, current+1, n);
        }
    }
}

vector<vector<int>> solve(int n) {
    if(n==0) {
        return vector<vector<int>>();
    }
    vector<vector<int>> result;
    vector<int> combo(n, 0);
    nQueen(result, combo, 0, n);
    return result;
}

bool matchHelper(string& input, int id, string& pattern, int ip) {
    if(id==input.size() && ip==pattern.size()) {
        return true;
    }
    else if(input.size()==id || pattern.size()==ip) {
        return false;
    }
    if(isdigit(pattern[ip])) {
        int i=ip;
        int num=0;
        while(i<pattern.size() && isdigit(pattern[i])) {
            num=num*10+pattern[i]-'0';
            i++;
        }
        if(id+num>input.size()) {
            return false;
        }
        else {
            return matchHelper(input, id+num, pattern , i);
        }
    }
    else {
        if(input[id]!=pattern[ip]) {
            return false;
        }
        else {
            return matchHelper(input, id+1, pattern, ip+1);
        }
    }
}

bool match(string input, string pattern) {
    // Write your solution here.
    return matchHelper(input, 0, pattern, 0);
}

int longest(vector<int> input) {
    // write your solution here.
    if(input.size()==0) {
        return 0;
    }
    else if(input.size()==1) {
        return 1;
    }
    vector<int> result(input.size(), 1);
    int output=1;
    for(int i=1;i<input.size();i++) {
        if(input[i]>input[i-1]) {
            result[i]=result[i-1]+1;
            output=max(output, result[i]);
        }
    }
    return output;
}


bool canJump(vector<int> input) {
    // write your solution here.
    if(input.size()<1) {
        return false;
    }
    else if(input.size()==1) {
        return true;
    }
    vector<bool> memo(input.size(), false);
    memo[0]=true;
    for(int i=0;i<input.size();i++) {
        for(int j=0;j<i;j++) {
            if(j+input[j]>=i && memo[j]==true) {
                memo[i]=true;
            }
        }
    }
    return memo[input.size()-1];
}


int minJump(vector<int> input) {
    // write your solution here.
    if(input.size()==1) {
        return 1;
    }
    vector<int> mi(input.size(), INT_MAX);
    mi[input.size()-1]=0;
    for(int i=input.size()-2;i>=0;i--) {
        for(int j=input[i];j>0;j--) {
            if(mi[i+j]!=INT_MAX) {
                mi[i]=min(mi[i], mi[i+j]+1);
            }
        }
    }
    
    return mi[0]==INT_MAX?-1:mi[0];
}


bool canBreak(string input, vector<string> dict) {
    // write your solution here.
    if(input.size()==0) {
        return false;
    }
    vector<bool> vb(input.size()+1, false);
    for(int i=1;i<=input.size();i++) {
        if(std::find(dict.begin(), dict.end(), input.substr(0, i)) != dict.end())
        {
            vb[i]=true;
            continue;
        }
        for(int j=1;j<i;j++) {
            if(vb[j] && (std::find(dict.begin(), dict.end(), input.substr(j, i-j)) != dict.end())) {
                vb[i]=true;
                break;
            }
        }
    }
    return vb[input.size()];
}


int editDistance(string s1, string s2) {
    // write your solution here.
    vector<vector<int>> matrix(s1.size()+1, vector<int>(s2.size()+1, 0));
    matrix[0][0]=0;
    int m=s1.size(), n=s2.size();
    for(int i=1;i<=m;i++) {
        matrix[i][0]=i;
    }
    for(int j=1;j<=n;j++) {
        matrix[0][j]=j;
    }
    for(int i=1;i<=m;i++) {
        for(int j=1;j<=n;j++) {
            if(s1[i-1]==s2[j-1]) {
                matrix[i][j]=matrix[i-1][j-1];
            }
            else {
                matrix[i][j]=min(matrix[i-1][j-1], min(matrix[i-1][j], matrix[i][j-1]))+1;
            }
        }
    }
    return matrix[m][n];
}


int largest(vector<vector<int>> matrix) {
    // write your solution here.
    int row=matrix.size(), col=matrix[0].size();
    int result=0;
    vector<vector<int>> func(row, vector<int>(col, 1));
    for(int i=0;i<row;i++) {
        if(matrix[i][0]==0) {
            func[i][0]=0;
        }
        result=max(result, func[i][0]);
    }
    for(int j=0;j<col;j++) {
        if(matrix[0][j]==0) {
            func[0][j]=0;
        }
        result=max(result, func[0][j]);
    }
    for(int i=1;i<row;i++) {
        for(int j=1;j<col;j++) {
            if(matrix[i][j]==0) {
                func[i][j]=0;
            }
            else {
                func[i][j]=min(min(func[i-1][j-1], func[i][j-1]), func[i-1][j])+1;
                result=max(result, func[i][j]);
            }
        }
    }
    return result;
}

void permutation2(vector<string>& result, string input, int index) {
    if(index==input.size()) {
        result.push_back(input);
        return;
    }
    set<char> wordDict;
    for(int i=index;i<input.size();i++) {
        if(wordDict.count(input[i])==0) {
            wordDict.insert(input[i]);
            swap(input[i], input[index]);
            permutation2(result, input, index+1);
            swap(input[i], input[index]);
        }
    }
}
vector<string> solve(string input) {
    if(input=="") {
        return {""};
    }
    vector<string> output;
    permutation2(output, input, 0);
    return output;
}

string reverseWords(string s) {
    // write your solution here
    if(s.size()<=1) {
        return s;
    }
    for(int i=0, j=s.size()-1;i<=j;i++, j--){
        swap(s[i], s[j]);
    }
    for(int i=0;i<s.size();) {
        while(s[i]==' ') {
            i++;
        }
        int j=i;
        while(s[j]!=' ' && j<s.size()) {
            j++;
        }
        for(int m=i, n=j-1;m<=n;m++, n--) {
            swap(s[m], s[n]);
        }
        i=j;
    }
    return s;
}

void finderHelper(string& input, int index, string s, vector<pair<int, int>>& positions) {
    for(int i=index, j=0;i<input.size();) {
        while(input[i+j]==s[j] && j<s.size()) {
            j++;
        }
        //docomomomocomo    omo
        //0123456789
        //   i
        //docom
        if(j==s.size()) {
            positions.push_back(make_pair(i, j));
            i+=j;
            j=0;
        }
        else {
            i++;
            j=0;
        }
    }
    return;
}
void replaceHelper(string& input, string t, vector<pair<int, int>>& positions) {
    for(int i=0;i<positions.size();i++) {
        int j=positions[i].first+i*(t.size()-positions[i].second);
        input.replace(j, positions[i].second, t);
    }
    return;
}
string replace(string input, string s, string t) {
    //replaceHelper(input, s, t);
    if(input=="") {
        return input;
    }
    vector<pair<int, int>> positions;
    finderHelper(input, 0, s, positions);
    replaceHelper(input, t, positions);
    return input;
}

string decompress(string input) {
    // write your solution here
    if(input.size()<=1) {
        return input;
    }
    string result;
    for(int i=0;i<input.size();i++) {
        if(input[i]>='a' && input[i]<='z') {
            result.push_back(input[i]);
        }
        else {
            if(input[i]=='0') {
                result.pop_back();
            }
            else {
                for(int addt=input[i]-'0'-1;addt>0;addt--) {
                    result.push_back(result[result.size()-1]);
                }
            }
        }
    }
    return result;
}

void reorderHelper(vector<int>& array, int left, int right) {
    if(right-left<=1) {
        return;
    }
    
    int leng=right-left+1;
    int mid=left+leng/2;
    int offset=leng/4;
    int leftmid=left+offset;
    int rightmid=mid+offset;
    reverse(array.begin()+leftmid, array.begin()+mid);
    reverse(array.begin()+mid, array.begin()+rightmid);
    reverse(array.begin()+leftmid, array.begin()+rightmid);
    //reorderHelper(array, left, left+2*(leftmid-left)-1);
    //reorderHelper(array, left+2*(leftmid-left), right);
    reorderHelper(array, left, mid-1);
    reorderHelper(array, mid, right);
    return;
}

vector<int> reorder(vector<int> array) {
    //12345678   8/4=2
    //12 34 56 78
    //12 43 65 78
    //12 56 34 78
    //1526 3748
    reorderHelper(array, 0, array.size()-1);
    return array;
}

int longest(string input) {
    //efhrgsayekasdanfev
    int leng=input.size();
    if(leng<=1) {
        return leng;
    }
    int result=0;
    
    unordered_map<char,int> hashset;
    for(int slow=0, fast=0;fast<leng;fast++) {
        hashset[input[fast]]++;
        if(hashset[input[fast]]>1) {
            while(hashset[input[fast]]>1) {
                hashset[input[slow]]--;
                slow++;
            }
            
        }
        else {
            result=max(result, fast-slow+1);
        }
    }
    return result;
}

string rightShift(string input, int n) {
    if(input.size()<=1 || n==0) {
        return input;
    }
    else if(n>=input.size()) {
        n=n%input.size();
    }
    //abc defg 3
    //gfe dcba
    //efg abcd
    reverse(input.begin(), input.end());
    reverse(input.begin(), input.begin()+n);
    reverse(input.begin()+n, input.end());
    return input;
}


vector<int> allAnagrams(string s, string l) {
    int leng=l.size();
    if(leng==0) {
        return {};
    }
    unordered_map<char, int> hashset;
    unordered_map<char, int> worker;
    for(int i=0;i<s.size();i++) {
        hashset[s[i]]++;
    }
    worker=hashset;
    //aabc
    //zzzz cde bcaa b cyywww
    //          s
    //           f
    vector<int> result;
    for(int slow=0, fast=0;fast<leng-s.size()+1;fast++) {
        if(worker[l[fast]]>0) {
            slow=fast;
            while(slow<leng && worker[l[slow]]>0) {
                worker[l[slow]]--;
                slow++;
            }
            bool found=true;
            for(auto it = worker.begin(); it != worker.end(); ++it ) {
                if(it->second!=0) {
                    found=false;
                    break;
                }
            }
            worker=hashset;
            if(found==true) {
                result.push_back(fast);
            }
        }
    }
    return result;
}


int largestSum(vector<int> input) {
    int leng=input.size();
    if(leng<=0) {
        return 0;
    }
    else if(leng==1) {
        return input[0];
    }
    vector<int> msum(leng, INT_MIN);
    msum[0]=input[0];
    int result=msum[0];
    for(int i=1;i<leng;i++) {
        if(msum[i-1]<=0) {
            msum[i]=input[i];
        }
        else {
            msum[i]=input[i]+msum[i-1];
        }
        result=max(result, msum[i]);
    }
    return result;
}

int longest1s(vector<int> input) {
    int leng=input.size();
    if(leng<=0) {
        return 0;
    }
    else if(leng==1) {
        return input[0];
    }
    int result=0;
    vector<int> vlargest(leng, 0);
    vlargest[0]=(input[0]==0? 0: 1);
    for(int i=1;i<leng;i++) {
        if(input[i]==1) {
            vlargest[i]=vlargest[i-1]+1;
        }
        else {
            vlargest[i]=0;
        }
        result=max(result, vlargest[i]);
    }
    return result;
}

int largestcross(vector<vector<int>> matrix) {
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
    int rows=matrix.size(), cols;
    if(rows<=0) {
        return 0;
    }
    cols=matrix[0].size();
    if(rows==1) {
        for(auto i:matrix[0]) {
            if(i==1) {
                return 1;
            }
        }
        return 0;
    }
    vector<vector<int>> ups(rows, vector<int>(cols, 0));
    vector<vector<int>> downs(rows, vector<int>(cols, 0));
    vector<vector<int>> lefts(rows, vector<int>(cols, 0));
    vector<vector<int>> rights(rows, vector<int>(cols, 0));
    int result=0;
    // preprocess
    for(int i=0;i<cols;i++) {
        for(int j=0;j<rows;j++) {
            if(i==0) {
                lefts[j][i]=matrix[j][i];
            }
            else {
                if(matrix[j][i]==1) {
                    lefts[j][i]=lefts[j][i-1]+1;
                }
                else {
                    lefts[j][i]=0;
                }
            }
        }
    }
    for(int i=cols-1;i>=0;i--) {
        for(int j=0;j<rows;j++) {
            if(i==cols-1) {
                rights[j][i]=matrix[j][i];
            }
            else {
                if(matrix[j][i]==1) {
                    rights[j][i]=rights[j][i+1]+1;
                }
                else {
                    rights[j][i]=0;
                }
            }
        }
    }
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            if(i==0) {
                ups[i][j]=matrix[i][j];
            }
            else {
                if(matrix[i][j]==1) {
                    ups[i][j]=ups[i-1][j]+1;
                }
                else {
                    ups[i][j]=0;
                }
            }
        }
    }
    for(int i=rows-1;i>=0;i--) {
        for(int j=0;j<cols;j++) {
            if(i==rows-1) {
                downs[i][j]=matrix[i][j];
            }
            else {
                if(matrix[i][j]==1) {
                    downs[i][j]=downs[i+1][j]+1;
                }
                else {
                    downs[i][j]=0;
                }
            }
        }
    }
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            result=max(result, min(min(ups[i][j], downs[i][j]), min(lefts[i][j], rights[i][j])));
        }
    }
    return result;
}

int largestx(vector<vector<int>> input) {
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
    int rows=input.size(), cols;
    if(rows<=0) {
        return 0;
    }
    cols=input[0].size();
    if(rows==1) {
        for(auto i:input[0]) {
            if(i==1) {
                return 1;
            }
        }
        return 0;
    }
    vector<vector<int>> leftups(rows, vector<int>(cols, 0));
    vector<vector<int>> rightups(rows, vector<int>(cols, 0));
    vector<vector<int>> leftdowns(rows, vector<int>(cols, 0));
    vector<vector<int>> rightdowns(rows, vector<int>(cols, 0));
    int result=0;
    // preprocess
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            if(i==0 || j==0) {
                leftups[i][j]=input[i][j];
            }
            else {
                if(input[i][j]==1) {
                    leftups[i][j]=leftups[i-1][j-1]+1;
                }
                else {
                    leftups[i][j]=0;
                }
            }
        }
    }
    for(int i=0;i<rows;i++) {
        for(int j=cols-1;j>=0;j--) {
            if(i==0 || j==cols-1) {
                rightups[i][j]=input[i][j];
            }
            else {
                if(input[i][j]==1) {
                    rightups[i][j]=rightups[i-1][j+1]+1;
                }
                else {
                    rightups[i][j]=0;
                }
            }
        }
    }
    for(int i=rows-1;i>=0;i--) {
        for(int j=0;j<cols;j++) {
            if(i==rows-1 || j==0) {
                leftdowns[i][j]=input[i][j];
            }
            else {
                if(input[i][j]==1) {
                    leftdowns[i][j]=leftdowns[i+1][j-1]+1;
                }
                else {
                    leftdowns[i][j]=0;
                }
            }
        }
    }
    for(int i=rows-1;i>=0;i--) {
        for(int j=cols-1;j>=0;j--) {
            if(i==rows-1 || j==cols-1) {
                rightdowns[i][j]=input[i][j];
            }
            else {
                if(input[i][j]==1) {
                    rightdowns[i][j]=rightdowns[i+1][j+1]+1;
                }
                else {
                    rightdowns[i][j]=0;
                }
            }
        }
    }
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            result=max(result, min(min(leftups[i][j], leftdowns[i][j]), min(rightdowns[i][j], rightups[i][j])));
        }
    }
    return result;
}

int matrixSumHelper(vector<int>& array) {
    int leng=array.size();
    if(leng<=0) {
        return 0;
    }
    else if(leng==1) {
        return array[0];
    }
    vector<int> msum(leng, INT_MIN);
    msum[0]=array[0];
    int result=msum[0];
    for(int i=1;i<leng;i++) {
        if(msum[i-1]>0) {
            msum[i]=msum[i-1]+array[i];
        }
        else {
            msum[i]=array[i];
        }
        result=max(msum[i], result);
    }
    return result;
}

int largestSubMatrixSum(vector<vector<int>> matrix) {
    int rows=matrix.size();
    if(rows<=0) {
        return 0;
    }
    else if(rows==1) {
        return matrixSumHelper(matrix[0]);

    }
    int cols=matrix[0].size();
    //  preprocess
//      { {1, -2, -1, 4},
//        {1, -1,  1, 1},
//        {0, -1, -1, 1},
//        {0,  0,  1, 1} }
    vector<vector<int>> matrixSum(rows, vector<int>(cols, INT_MIN));
    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            if(j==0) {
                matrixSum[i][j]=matrix[i][j];
            }
            else {
                matrixSum[i][j]=matrixSum[i][j-1]+matrix[i][j];
            }
        }
    }
    int result=INT_MIN;
    for(int i=0;i<cols;i++) {
        for(int j=i;j<cols;j++) {
            vector<int> testing;
            for(int m=0;m<rows;m++) {
                testing.push_back(matrixSum[m][j]-matrixSum[m][i]+matrix[m][i]);
            }
            result=max(result, matrixSumHelper(testing));
        }
    }
    return result;
}

void addParen(string& combo, int left, int right, vector<string>& result) {
    if(left<0||right<0) {
        return;
    }
    else if(left==0&&right==0) {
        result.push_back(combo);
        return;
    }
    else {
        if(left>0) {
            combo+="if {\n";
            addParen(combo, left-1, right, result);
            combo.resize(combo.size()-5);
        }
        if(right>left) {
            combo+=" }\n";
            addParen(combo, left, right-1, result);
            combo.resize(combo.size()-3);
        }
    }
}

vector<string> printpermutationif(int n) {
    vector<string> result;
    if(n==0) {
        return result;
    }
    string combos;
    addParen(combos, n, n, result);
    return result;
}
int getMinHelper(string input) {
    int leng=input.size();
    if(leng<2) {
        return 0;
    }
    vector<vector<int>> cuts(leng, vector<int>(leng, 0));
    vector<vector<bool>> huiwen(leng, vector<bool>(leng, false));
    for(int i=0;i<leng;i++) {
        cuts[i][i]=0;
        huiwen[i][i]=true;
    }
    
    for(int dist=2;dist<=leng;dist++) {	//分段的大小
        for(int i=0;i<leng-dist+1;i++) {	//分段的起点
            int j=i+dist-1;					//分段的终点
            if(dist==2) {
                if(input[i]==input[j]) {
                    huiwen[i][j]=true;
                }
            }
            else {
                huiwen[i][j]=(input[i]==input[j]) && huiwen[i+1][j-1];
            }
            if(huiwen[i][j]) {
                cuts[i][j]=0;
            }
            else {
                cuts[i][j]=INT_MAX;
                for(int k=i;k<j;k++) {
                    cuts[i][j]=min(cuts[i][j], cuts[i][k]+cuts[k+1][j]+1);
                }
            }
        }
    }
    return cuts[0][leng-1];
}

int minCuts(string input) {
    return getMinHelper(input);
}

vector<int> zigZag(TreeNode* root) {
    vector<int> result;
    if(root==NULL) {
        return result;
    }
    /*
                5
            3       8
        1     4        11
     2   6  7   9   10    12
     */
    deque<TreeNode*> mydeque;
    bool isEven=true;
    mydeque.push_back(root);
    while(!mydeque.empty()) {
        if(!isEven) {
            int leng=(int)mydeque.size();
            while(leng>0) {
                TreeNode* current=mydeque.front();
                mydeque.pop_front();
                result.push_back(current->value);
                if(current->left) {
                    mydeque.push_back(current->left);
                }
                if(current->right) {
                    mydeque.push_back(current->right);
                }
                leng--;
            }
            
            isEven=!isEven;
        }
        else {
            int leng=(int)mydeque.size();
            while(leng>0) {
                TreeNode* current=mydeque.back();
                mydeque.pop_back();
                result.push_back(current->value);
                if(current->right) {
                    mydeque.push_front(current->right);
                }
                if(current->left) {
                    mydeque.push_front(current->left);
                }
                leng--;
            }
            
            isEven=!isEven;
        }
    }
    return result;
}

vector<int> dedup1(vector<int> input) {
    int leng=(int)input.size();
    if(leng<=1) {
        return input;
    }
    //1, 2, 3, 4, 3, 3, 4, 4
    //            s
    //                  f
    int slow=1, fast=1;
    while(fast<leng) {
        if(input[fast]!=input[slow-1]) {
            input[slow]=input[fast];
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


vector<int> dedup2(vector<int> input) {
    int leng=(int)input.size();
    if(leng<=2) {
        return input;
    }
    //1, 2, 2, 3, 3, 4, 4, 4
    //                  s
    //                     f
    int slow=2, fast=2;
    while(fast<leng) {
        if(input[fast]!=input[slow-2]) {
            input[slow]=input[fast];
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

vector<int> dedup3(vector<int> array) {
    int leng=(int)array.size();
    if(leng<=1) {
        return array;
    }
    //{1, 2, 2, 3, 3, 3, 4} → {1}
    //    s
    //                   f1
    //                   f2
    int slow=0, fast1=0, fast2=0;
    while(fast2<leng) {
        if(array[fast2]==array[fast1]) {
            while(fast2<leng && array[fast2]==array[fast1]) {
                fast2++;
            }
            
        }
        if(fast2>fast1+1) {
            fast1=fast2;
        }
        else {
            array[slow]=array[fast1];
            slow++;
            fast1++;
        }
    }
    array.resize(slow);
    return array;
}

vector<int> dedup4(vector<int> input) {
    int leng=(int)input.size();
    if(leng<=1) {
        return input;
    }
    vector<int> result;
    //{1, 2, 3, 3, 3, 2}
    //       slow
    //                fast
    for(int fast=0;fast<leng;) {
        if(result.size()>0 && result.back()==input[fast]) {
            while(fast<leng && result.back()==input[fast]) {
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

int solve114(vector<int> values) {
//    95 Percentile
    vector<int> counts(4097, 0);
    for(auto i:values) {
        counts[i]++;
    }
    int sum=0;
    int leng=4097;
    while(sum<=0.05*values.size()) {
        sum+=counts[--leng];
    }
    return leng;
}

vector<int> largestAndSmallest(vector<int> input) {
    int leng=(int)input.size();
    if(leng<1) {
        return {0, 0};
    }
    else if(leng==1) {
        return {input[0], input[0]};
    }
    else if(leng==2) {
        return {max(input[0], input[1]), min(input[0], input[1])};
    }
    vector<int> large;
    vector<int> small;
    int largest=INT_MIN, smallest=INT_MAX;
    for(int i=0;i<leng;i+=2) {
        if(i+1<leng) {
            large.push_back(max(input[i], input[i+1]));
        }
        else {
            large.push_back(input[i]);
        }
        largest=max(largest, large.back());
        if(i+1<leng) {
            small.push_back(min(input[i], input[i+1]));
        }
        else {
            small.push_back(input[i]);
        }
        smallest=min(smallest, small.back());
    }
    
    return {largest, smallest};
}

vector<int> largestAndSecond(vector<int> array) {
    int leng=(int)array.size();
    if(leng<1) {
        return {0, 0};
    }
    else if(leng==1) {
        return {array[0], array[0]};
    }
    else if(leng==2) {
        return {max(array[0], array[1]), min(array[0], array[1])};
    }
    int leng2=2*leng;
    int secondlarge=-1;
    int index;
    vector<int> heaper(leng2, -1);
    for(index=leng;index<leng2;index++) {
        heaper[index]=array[index-leng];
    }
    for(index=leng2-2;index>=2;index-=2) {
        heaper[index/2]=max(heaper[index], heaper[index+1]);
    }
    int largest=heaper[1];
    for(index=1;index<leng;) {
        if(heaper[2*index]==heaper[index]) {
            if(secondlarge<heaper[2*index+1]) {
                secondlarge=heaper[2*index+1];
            }
            index=2*index;
        }
        else {
            if(secondlarge<heaper[2*index]) {
                secondlarge=heaper[2*index];
            }
            index=2*index+1;
        }
    }
    return {largest, secondlarge};
}

void solve125Helper(vector<vector<int>>& matrix, int offset, int size) {
    if(size<=1) {
        return;
    }
    for(int i=0;i<size-1;i++) {
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
        int temp=matrix[0+offset][i+offset];
        matrix[0+offset][i+offset]=matrix[size-1+offset-i][0+offset];
        matrix[size-1+offset-i][0+offset]=matrix[size-1+offset][size-1+offset-i];
        matrix[size-1+offset][size-1+offset-i]=matrix[i+offset][size-1+offset];
        matrix[i+offset][size-1+offset]=temp;
    }
    solve125Helper(matrix, offset+1, size-2);
    return;
}
void solve125(vector<vector<int>> matrix) {
    //vector<vector<int>>& result=matrix;
    solve125Helper(matrix,0, 4);
    return;
}

int solve127Helper(TreeNodeP* one) {
    int result=0;
    TreeNodeP* someone=one;
    while(someone!=NULL) {
        result++;
        someone=someone->parent;
    }
    delete someone;
    return result;
}

TreeNodeP* solve127(TreeNodeP* one, TreeNodeP* two) {
    int height_one=solve127Helper(one);
    int height_two=solve127Helper(two);
    if(height_one>height_two) {
        int diff=abs(height_one-height_two);
        while(diff>0) {
            one=one->parent;
            diff--;
        } // same level
    }
    else if(height_two>height_one) {
        int diff=abs(height_one-height_two);
        while(diff>0) {
            two=two->parent;
            diff--;
        } // same level
    }
    while(one!=NULL && two!=NULL && one != two) {
        one=one->parent;
        two=two->parent;
    }
    return one;
    
}


TreeNode* solve129(TreeNode* root, vector<TreeNode*> nodes) {
    if(root==NULL) {
        return root;
    }
    for(auto node_i:nodes) {
        if(root==node_i) {
            return root;
        }
    }
    TreeNode* left_node=solve129(root->left, nodes);
    TreeNode* right_node=solve129(root->right, nodes);
    if(left_node!=NULL && right_node!=NULL) {
        return root;
    }
    return left_node!=NULL?left_node:right_node;
}

vector<int> moveZero(vector<int> array) {
    // 0 3 1 0 1
    //   s
    //     f
    int leng=array.size();
    if(leng<=1) {
        return array;
    }
    int slow=0, fast=0;
    for(fast=0;fast<leng;fast++) {
        if(array[fast]!=0) {
            array[slow]=array[fast];
            slow++;
        }
    }
    for(fast=slow;fast<leng;fast++) {
        array[fast]=0;
    }
    return array;
}

int searcher(vector<int>& A2, int key) {
    for(int i=0;i<A2.size();i++) {
        if(A2[i]==key) {
            return i;
        }
    }
    return -1;
}

struct data {
    int value;
    int index;
};


static bool compare_by_A2(const data& a, const data& b) {
    if(a.index>=0 && b.index>=0) {
        return a.index<b.index;
    }
    else if(a.index>=0 && b.index<0) {
        return true;
    }
    else if(a.index<0 && b.index>=0) {
        return false;
    }
    else {
        //a.index == -1 && b.index == -1
        return a.value<b.value;
    }
}
vector<int> sortSpecial(vector<int> A1, vector<int> A2) {
    vector<data> result;
    unordered_map<int, int> indexer;
    for(int i=0;i<A1.size();i++) {
        indexer[A1[i]]=-1;
    }
    for(int i=0;i<A2.size();i++) {
        indexer[A2[i]]=i;
    }
    data temp;
    for(auto i:A1) {
        int idx=indexer[i];
        temp.index=idx;
        temp.value=i;
        result.push_back(temp);
    }
    sort(result.begin(), result.end(), compare_by_A2);
    vector<int> output;
    for(auto i:result) {
        output.push_back(i.value);
    }
    return output;
}

class Solution113 {
public:
    priority_queue<int,vector<int>, less<int>> max_heap;
    priority_queue<int,vector<int>, greater<int>> min_heap;
    Solution113() {
    }
    double median() {
        int size=max_heap.size() + min_heap.size();
        if(size!=0) {
            if(size%2==0) {
                return (double)(max_heap.top()+min_heap.top())/2.0;
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
        if(max_heap.size()>min_heap.size()) {
            if(i>=max_heap.top()) {
                min_heap.push(i);
            }
            else {
                int other=max_heap.top();
                max_heap.pop();
                min_heap.push(other);
                max_heap.push(i);
            }
        }
        else if(max_heap.size()==min_heap.size()){
            if(max_heap.size()==0 || i<=min_heap.top()) {
                max_heap.push(i);
            }
            else {
                int other=min_heap.top();
                min_heap.pop();
                max_heap.push(other);
                min_heap.push(i);
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
        srand(time(NULL));
    }
    int solve() {
        // use rand5() here.
        //5^3=125, 5^5=125*25>1000, so we call rand5 5 times to get result
        
        while(1) {
            int num=0;
            for(int i=0;i<5;i++) {
                num=num*5+rand5();
            }
            if(num<1000) {
                return num;
            }
            else {
                return num%1000;
            }
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
        srand(time(NULL));
    }
    int solve() {
        // use rand5() here.
        while(1) {
            int num=0;
            for(int i=0;i<2;i++) {
                num=num*5+rand5();
            }
            if(num<21) {
                return num%7;
            }
        }
    }
};

class Solution109 {
private:
    int count=0;
    int result;
public:
    int sample() {
        return result;
    }
    
    void read(int i) {
        count++;
        int prob=rand()%count;
        //prob has the probability 1/count to be the 0th current sample
        if(prob==0) {
            result=i;
        }
    }
};

class Solution51 {
public:
    TreeNode* insert(TreeNode* root, int value) {
        // Write your solution here.
        if(root==NULL) {
            root=new TreeNode(value);
            return root;
        }
        TreeNode* parent=NULL;
        TreeNode* current=root;
        while(current!=NULL) {
            if(current->value==value) {
                return root;
            }
            else if(current->value>value) {
                parent=current;
                current=current->left;
            }
            else {
                parent=current;
                current=current->right;
            }
        }
        if(parent->value<value) {
            parent->right=new TreeNode(value);
        }
        else {
            parent->left=new TreeNode(value);
        }
        return root;
    }
};

class Solution52 {
public:
    TreeNode* solve(TreeNode* root, int value) {
        if(root==NULL) {
            return NULL;
        }
        TreeNode* temp=root;
        while(temp!=NULL) {
            if(temp->value==value) {
                return temp;
            }
            else if(temp->value>value) {
                temp=temp->left;
            }
            else {
                temp=temp->right;
            }
        }
        return NULL;
    }
};

class Solution53 {
public:
    TreeNode* solve(TreeNode* root, int value) {
        if(root==NULL) {
            return root;
        }
        if(root->value>value) {
            //删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
            root->left = solve(root->left, value);
        }
        else if(root->value<value) {
            //删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
            root->right = solve(root->right, value);
        }
        else {
            if(root->left==NULL && root->right==NULL) {
                //不需要改
                return NULL;
            }
            else if(root->left==NULL || root->right==NULL) {
                //只返回另一个子树
                return root->left==NULL ? root->right : root->left;
            }
            else {
                //find the node with smallest value in the right subtree
                //copy its value to root
                //recurse delete the smallest node from right of this root
                TreeNode* closet=root->right;
                while(closet->left!=NULL) {
                    closet=closet->left;
                }
                root->value=closet->value;
                root->right=solve(root->right, closet->value);
            }
        }
        return root;
    }
};

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

class Solution131 {
public:
    RandomListNode* solve(RandomListNode* n) {
        return n;
    }
};

int main() {
    
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
//    Solution113* new113=new Solution113();
//    new113->read(1);
//    cout<<new113->median();
//    new113->read(2);
//    cout<<new113->median();
//    new113->read(3);
//    cout<<new113->median();
//    new113->read(10);
//    cout<<new113->median();
//    sortSpecial({4,2,1,3}, {});
//    vector<int> result=moveZero({1,0,2,0,1});
//    for(auto i:result) {
//        cout<<i<<" ";
//    }
//           5
//        3     8
//      1   4     11
//     2 6 7 9  10  12
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
//    TreeNode* result = solve129(root, {root->left->right->left, root->left->right->right, root->right->right->left});
//    cout<<result->value;
////    TreeNodeP* root=new TreeNodeP(5, NULL);
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
//    solve127(node2, node8);
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
//    cout<<minCuts("ababbbabbababa");
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
//    vector<int> result=allAnagrams("a", "aaa");
//    cout<<rightShift("abcdefg", 39);
//    cout<<longest("abcabcbbcda");
//    reorder({1,2,3,4,5,6,7,8});
//    cout<<decompress("a1c0b2c4");
//    vector<string> tcs = {"a", "a", "b"};
//    topKFrequent(tcs, 1);
//
//    vector<int> array = {1,3,4};
//    int i=missing(array);
//    cout<<i<<endl;
//    vector<int> a={1,1,2,4,4,6,6,6};
//    vector<int> b={1,3,5,5,6,6};
//    vector<int> result=common(a, b);
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
//    vector<vector<int> > solve64(int target, vector<int> coins)
//    int target=11;
//    vector<int> coins={5, 2, 1};
//    vector<vector<int> > result64=solve64(target, coins);
//    for(int i=0;i<result64.size();i++) {
//        for(int j=0;j<result64[i].size();j++) {
//            cout<<result64[i][j]<<" ";
//        }
//        cout<<endl;
//    }
//    cout<<endl;
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
    
    return 0;
}

