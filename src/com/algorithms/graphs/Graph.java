package com.algorithms.graphs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vidya on 9/11/16.
 */
public class Graph {
    public Node[] nodes;

    class Node{
        public String name;
        public boolean visited;
        public Node[] children;

    }
    public void visit(Node node)
    {
        System.out.println(node.name);
    }

    public void setVisited(Node node, boolean visit)
    {
        node.visited = visit;
    }

    public Node[] getAdjacentNodes(Node node)
    {
        return node.children;
    }
    public void depthFirstSearch(Node root)
    {
        if (root==null)
        {
            return;
        }
        visit(root);
        setVisited(root, true);
        for(Node n: root.children)
        {
            if(!n.visited)
            {
                visit(n);
                setVisited(n,true);
                depthFirstSearch(n);
            }
        }
    }

    public void breadthFirstSearch(Node root)
    {
        if(root == null)
        {
            return;
        }
        BlockingQueue<Node> queue = new ArrayBlockingQueue(1024);
        setVisited(root,true);
       queue.add(root);
        while(!queue.isEmpty())
        {
            Node n = queue.remove();
            for(Node r : n.children)
            {
                if(!r.visited)
                {
                    r.visited = true;
                    visit(r);
                    queue.add(r);
                }
            }
        }



    }
}
