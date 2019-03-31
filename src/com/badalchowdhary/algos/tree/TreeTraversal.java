package com.badalchowdhary.algos.tree;

import com.badalchowdhary.datastructures.BinaryNode;
import com.badalchowdhary.datastructures.BinaryTree;

public class TreeTraversal
{
    public static void inOrder(BinaryNode root)
    {
        BinaryNode node = root;
        
/*        if(node.getLeft() != null)
        {
            inOrder(node.getLeft());
        }
        
        System.out.println(node.getData());
        
        if (node.getRight() != null)
        {
            inOrder(node.getRight());
        }*/
        
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());
        
        
    }
    
    public static void main(String[] args)
    {
        inOrder(BinaryTree.getBinaryTree());
    }

}
