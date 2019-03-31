package com.badalchowdhary.algos.tree;

import com.badalchowdhary.datastructures.BinaryNode;
import com.badalchowdhary.datastructures.BinaryTree;

public class InvertTree
{

    public static BinaryNode invertTree(BinaryNode root)
    {
        BinaryNode node = root;
        
        if (node != null)
        {
            BinaryNode left = node.getLeft();
            BinaryNode right = node.getRight();
            node.setLeft(right);
            node.setRight(left);
            
            invertTree(node.getLeft());
            invertTree(node.getRight());
            
        }
        
        
        return root;
    }
    
    
    public static void main(String[] args)
    {
        //BinaryNode root = BinaryTree.getBinaryTree();
        BinaryNode root = new BinaryNode(1, null, null);
        
        BinaryNode inverted = invertTree(root);
        
        TreeTraversal.inOrder(inverted);
        
        
        

    }

}
