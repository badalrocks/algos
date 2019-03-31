package com.badalchowdhary.datastructures;

public class BinaryTree
{
    private BinaryNode root;
    
    public void add(BinaryNode node)
    {
        
    }
    
    public void delete(BinaryNode node)
    {
        
    }
    
    public static BinaryNode getBinaryTree()
    {
        BinaryNode three = new BinaryNode(3, null, null);
        BinaryNode eight = new BinaryNode(8, null, null);
        BinaryNode twelve = new BinaryNode(12, null, null);
        BinaryNode twenty = new BinaryNode(20, null, null);
        
        BinaryNode five = new BinaryNode(5, three, eight);
        BinaryNode fifteen = new BinaryNode(15, twelve, twenty);
        
        BinaryNode root = new BinaryNode(10, five, fifteen);
        
        
        return root;
    }
    

    
}
