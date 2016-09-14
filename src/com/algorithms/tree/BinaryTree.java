package com.algorithms.tree;

import java.util.Scanner;

/**
 * Created by vidya on 9/1/16.
 */
public class BinaryTree {

  BTNode root;
    public BinaryTree()
    {
        root = null;
    }
    public boolean isEmpty()
    {
        return root==null;
    }

    public void insert(int data)
    {
    // root=insert(this.root,data);
        root=balancedInsert(this.root,data);
    }

    public BTNode insert(BTNode node, int data)
    {
        if(node == null)
        {
            node = new BTNode(data);
        }
        else
        {
            //add balancing here
            /**
             * if rightheight > left height , fill in left
             *
             */


            if (node.getRight()==null)
            {
                node.right = insert(node.right,data);
            }
            else
            {
                node.left = insert(node.left,data);
            }

        }
        return node;
    }

    /**
     * Balanced Insert
     * @return
     */
    public BTNode balancedInsert(BTNode node, int data) {
        if (node == null) {
            node = new BTNode(data);
        }
        else
        {
            int rh  = getHeight(node.getRight()) ;
            int lh = getHeight(node.getLeft());
            if(lh >= rh)
            {

                node.setRight(balancedInsert(node.right,data));
                //node.right = balancedInsert(node.right,data);
            }else
            {
                node.setLeft(balancedInsert(node.left,data));
            }

        }
        return node;
    }

    public int countNodes()
    {
       return countNodes(this.root);
    }

    private int countNodes(BTNode root) {
        int count =0;
        if(root!=null)
        {
            count = countNodes(root.getLeft()) + countNodes(root.getRight());
        }
        return count;
    }

     public boolean search(int d)
     {
         return search(root, d);
     }

    private boolean search(BTNode node, int d) {

        if(node==null)
        {
            return false;
        }

        if(node.getData() == d)
            return true;
        if(node.getLeft()!=null)
            if(search(node.getLeft(),d))
                return true;

         if(node.getRight()!=null)
             if(search(node.getRight(),d))
                 return true;

        return false;
        /*
        else
        {
            if(node.getData()==d)
            {
                return true;
            }
            else
            {
                return (search(node.getRight(),d)|| search(node.getLeft(),d));
            }

        }
        */
    }

    private void inorder()
    {
         inorder(root);
    }

    private void inorder(BTNode node) {

        if(node==null)
            return;
        else
        {
            inorder(node.getLeft());
            System.out.print(" " + node.getData());
            inorder(node.getRight());
        }
    }

    private void preorder()
    {
        preorder(root);
    }

    private void preorder(BTNode node) {
        if(node==null)
            return;
        else
        {
            System.out.print(" " + node.getData());
            preorder(node.getLeft());
            preorder(node.getRight());

        }
    }

    private void postorder()
    {
        postorder(root);
    }
    private void postorder(BTNode node) {
        if(node==null)
            return;
        else
        {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(" " + node.getData());


        }
    }

    private int getHeight()
    {
        return getHeight(this.root);
    }

    private int getHeight(BTNode node) {
        int height =0;
        int leftHeight =0;
        int rightHeight =0;
        if(node == null )
        {
            return height;
        }
        leftHeight = getHeight(node.getLeft());
        rightHeight = getHeight(node.getRight());

        height = 1 + Math.max(leftHeight,rightHeight);
        return height;
      }
    //inorder
    //preorder
    //postorder

    /**
     * Print all nodes at height 3
     */

    public void printallatLevel(int level)
    {
          printatLevel(this.root,level);
    }

    private void printatLevel(BTNode node, int level) {

        if( node!=null) {
            if (level == 0) {

                System.out.print(" " + node.getData());
                return;
            } else {
                printatLevel(node.getLeft(), level - 1);
                printatLevel(node.getRight(), level - 1);

            }
        }
    }

    private void printTree()
    {
        printTree(this.root);
    }

    private void printTree(BTNode node)
    {
        if(node!=null)
        {
            System.out.println(node.getData());
            System.out.println("");
        }
    }



    /**
     *                1
     *               / \
     *              2   3
     *             / \   \
     *            4   5   7
     *           / \   \
     *          8   9   6
     */


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BT */
        BinaryTree bt = new BinaryTree();
        /*  Perform tree operations  */
        System.out.println("Binary Tree Test\n");
        char ch;
        do
        {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. check height");
            System.out.println("6. print elements at level");
            System.out.println("7. Print Tree");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");

                    int t;
                   do
                    {
                        System.out.println("Enter integer element to insert");
                        t = scan.nextInt();
                        if(t!=0)
                        bt.insert(t);
                    }
                   while(t!=0);
                   // bt.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ bt.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Nodes = "+ bt.countNodes());
                    break;
                case 4 :
                    System.out.println("Empty status = "+ bt.isEmpty());
                    break;
                case 5 :
                    System.out.println("Height of the tree = "+ bt.getHeight());
                    break;
                case 6 :
                    System.out.println("Enter integer element at level");
                    System.out.println("print al level= ");
                    bt.printallatLevel(scan.nextInt());
                    break;
                case 7 :
                    System.out.println("PrintTree");
                    BTreePrinter.printNode(bt.root);
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display tree  */
            System.out.print("\nPost order : ");
            bt.postorder();
            System.out.print("\nPre order : ");
            bt.preorder();
            System.out.print("\nIn order : ");
            bt.inorder();

            System.out.println("\n\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y'||ch =='1');
    }

    //height of a tree
    //depth of tree
    //height of node
    //depth of node
    //same level of tree
}
