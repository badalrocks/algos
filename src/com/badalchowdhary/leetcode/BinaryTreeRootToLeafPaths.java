package com.badalchowdhary.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.badalchowdhary.datastructures.BinaryNode;
import com.badalchowdhary.datastructures.BinaryTree;

public class BinaryTreeRootToLeafPaths
{
    public static List<String> getAllPaths(BinaryNode node)
    {
        List<String> allPaths = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        getAllPathsHelper(node, allPaths, path);

        return allPaths;

    }

    private static void getAllPathsHelper(BinaryNode node, List<String> allPaths, StringBuilder path)
    {
        if (node == null)
        {
            return;
        }
        
        path.append(node.getData() + " ");
        
        if (node.getLeft() == null && node.getRight() == null)
        {
            allPaths.add(path.toString());
            return;
        }

        getAllPathsHelper(node.getLeft(), allPaths, new StringBuilder(path));

        getAllPathsHelper(node.getRight(), allPaths, new StringBuilder(path));

    }

    public static void main(String[] args)
    {
        System.out.println(getAllPaths(BinaryTree.getBinaryTree()));

    }

}
