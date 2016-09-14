package com.algorithms.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vidya on 9/11/16.
 */
public class SortedtoBST {
    
    BSTNode root;
    
    public class BSTNode{
        int data;
        BSTNode right;
        BSTNode left;
    }
    
    
    
    List sortedArray = new ArrayList();
    
    public void buildMinimalBST(ArrayList ll)
    {
        int length = ll.size();
        int start =0;
        int end = length;
        
        buildMinimalBST(ll, start, end);
    }

    private void buildMinimalBST(ArrayList ll, int start, int end) {
        // recurse and split here

    }


    public static void main(String[] args) {
    }
    
}
