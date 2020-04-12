package com.mywork.trees;

import java.util.*;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

public class BinaryTree
{
    public static Scanner in = new Scanner(System.in);

    public Queue<Node> btQueu;
    private int maxLevel;

    public BinaryTree()
    {
        btQueu = new LinkedList<Node>();
    }

    public void print(String s)
    {
        System.out.print(s);
    }

    public void setMaxLevel(int level) {
        this.maxLevel = level;
    }

    public int getMaxLevel() {
       return this.maxLevel;
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
            print(root.value + ", ");
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


    public void bottomView(Node root) {
        if(root == null) {
            return;
        }
        int hd = 0;
        Map<Integer, Integer> hdNodes = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.hd = hd;
        queue.add(root);
        while(!queue.isEmpty()) {
            Node n = queue.remove();
            hd = n.hd;
            hdNodes.put(hd,n.value);
            if(n.left !=null) {
                n.left.hd = hd - 1;
                queue.add(n.left);
            }
            if(n.right !=null) {
                n.right.hd = hd + 1;
                queue.add(n.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hdNodes.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
        System.out.print(hdNodes);
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> me = it.next();
            System.out.print(me.getValue()+" ");
        }
    }

    public void leftView(Node root) {
        this.setMaxLevel(0);
        leftView(root, 1);
    }

    public void rightView(Node root) {
        this.setMaxLevel(0);
        rightView(root, 1);
    }

    private void rightView(Node root, int level) {
        if(root == null) {
            return;
        }
        if(this.getMaxLevel() < level) {
            this.setMaxLevel(level);
            System.out.println(root.value+" ");
        }
        rightView(root.right, level+1);
        rightView(root.left, level+1);
    }

    private void leftView(Node root, int level) {
        if(root == null) {
            return;
        }
        if(this.getMaxLevel() < level) {
            this.setMaxLevel(level);
            System.out.println(root.value);
        }
        leftView(root.left, level+1);
        leftView(root.right, level+1);
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
//        bstTree.print("inOrder :");
//        bstTree.inorder(root);
//        bstTree.print("\n");
//        bstTree.print("PostOrder :");
//        bstTree.postOrder(root);
//        bstTree.print("\n");
//        bstTree.print("PreOrder :");
//        bstTree.preOrder(root);
        bstTree.print("Bottom view :");
        bstTree.bottomView(root);
    }
}