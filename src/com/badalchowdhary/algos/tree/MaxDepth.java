package com.badalchowdhary.algos.tree;

import com.badalchowdhary.datastructures.BinaryNode;
import com.badalchowdhary.datastructures.BinaryTree;

public class MaxDepth
{
    
    public static int maxDepth (BinaryNode root)
    {
        if (root == null) return 0;
        int left = 1 + maxDepth(root.getLeft());
        int right = 1 + maxDepth(root.getRight());
        
        return left > right ? left : right;
        
    }
    
    public static void main(String[] args)
    {
        BinaryNode root = BinaryTree.getBinaryTree();
        
        int maxDepth = maxDepth(root);
        
        System.out.println(maxDepth);
    }

}
