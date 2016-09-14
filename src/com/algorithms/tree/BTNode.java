package com.algorithms.tree;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * Created by vidya on 9/1/16.
 */
public class BTNode <T extends Comparable<?>> {
    BTNode left;
    BTNode right;
    int data;

    /**
     * constructor
     */
    public BTNode()
    {
        left = null;
        right = null;
        data =0;
    }
    public BTNode(int d)
    {
        left = null;
        right = null;
        data =d;
    }
    public void setData(int d)
    {
       data=d;
    }

    public int getData()
    {
        return data;
    }

    public BTNode getLeft()
    {
        return left;
    }
    public BTNode getRight()
    {
        return right;
    }

    public void setLeft(BTNode n)
    {
        left =n;
    }
    public void setRight(BTNode n)
    {
        right = n;
    }

}

