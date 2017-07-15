//
//  main.c
//  laicodeC
//
//  Created by Fei Shen on 2017/7/11.
//  Copyright © 2017年 Fei Shen. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
typedef struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
} TreeNode;


int main(int argc, const char * argv[]) {
    TreeNode t1;
    t1.val=1;
    t1.left=NULL;
    t1.right=NULL;
    TreeNode t2;
    t2.val=2;
    t2.left=NULL;
    t2.right=NULL;
    TreeNode t3;
    t3.val=3;
    TreeNode t4;
    t4.val=4;
    printf("Hello, World!%d\t%d\t%d\t%d\n", t1.val, t2.val, t3.val, t4.val);
    return 0;
}
