package com.mywork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

public class BinaryTree
{
    public static Scanner in = new Scanner(System.in);

    public Queue<Node> btQueu;

    public BinaryTree()
    {
        btQueu = new LinkedList<Node>();
    }

    public void print(String s)
    {
        System.out.print(s);
    }
    
    /**
     * Function to insert a node into a BST
     * @param root
     * @param node
     * @return
     */
    public Node bstInsert(Node root, Node node)
    {
        if (root == null)
        {
            return node;
        }
        else if (node.value > root.value)
        {
            root.right = bstInsert(root.right, node);
        }
        else
        {
            root.left = bstInsert(root.left, node);
        }

        return root;
    }
    
    /**
     * Function to insert a node to a binary tree
     * @param newNode
     * @return
     */
    public Node btInsert(Node newNode)
    {
        if (btQueu.isEmpty())
        {
            btQueu.add(newNode);
        }
        else
        {
            btQueu.add(newNode);
            for (Node node : btQueu)
            {
                if (node.left == null)
                {
                    node.left = newNode;
                    break;
                }
                if (node.right == null)
                {
                    node.right = newNode;
                    break;
                }
            }
        }
        return btQueu.peek();
    }
    
    /**
     * Prints postorder Traversal of a tree- LRC
     * @param root
     */
    public void postOrder(Node root)
    {
        if (root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            print(root.value + "->");
        }
    }
    
    /**
     * Prints inorder Traversal of a tree- LCR
     * @param root
     */
    public void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            print(root.value + ",");
            inorder(root.right);

        }

    }
    
    /**
     * Prints preorder Traversal of a tree- CLR
     * @param root
     */
    public void preOrder(Node root)
    {

        if (root != null)
        {
            print(root.value + ",");
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        int count, i, temp;
        BinaryTree bstTree = new BinaryTree();
        bstTree.print("Enter no.of elements:");
        count = in.nextInt();
        Node root = null;
        for (i = 0; i < count; i++)
        {
            temp = in.nextInt();
            Node node = new Node(temp);
            root = bstTree.bstInsert(root, node);
            // sbstTree.inorder(root);
        }
        bstTree.print("inOrder :");
        bstTree.inorder(root);
        bstTree.print("\n");
        bstTree.print("PostOrder :");
        bstTree.postOrder(root);
        bstTree.print("\n");
        bstTree.print("PreOrder :");
        bstTree.preOrder(root);
    }
}