package com.algorithms.tree;

/**
 * Created by vidya on 9/8/16.
 */
public class BinarySearchTree {
    BTNode root;
    BTNode left;
    BTNode right;

    public void insertElement(int n)
    {
        insertElement(root, n);
    }

    //recursive look at the 
    private void insertElement(BTNode node, int n) {
            if( node==null)
            {
               node = new BTNode(n) ;
                return;
            }

        if(n > node.getData())
        {
            insertElement(node.getLeft(),n);
        }
        else
        {
            insertElement(node.getRight(),n);
        }

    }
     
    private boolean isBST()
    {
        return isBST(root);
    }

    private boolean isBST(BTNode node) {

        if(node.getData() < node.getLeft().getData() || !isBST(node.getLeft()))
        {
            return false;
        }

        if(node.getData() > node.getRight().getData() || !isBST(node.getRight()))
        {
            return false;
        }
        return true;
    }

}
