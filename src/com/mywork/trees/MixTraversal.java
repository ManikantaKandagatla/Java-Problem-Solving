package com.mywork.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

public class MixTraversal extends BinaryTree
{
    public int[][] testCases = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, -1, -5,
                    -11, -4, -23 },
            { 17, 15, 3, 78, 8, 10, 11, 36, 1, -6, 0, 12, 21, 14, 100, -8 },
            { 17, 15, 3, 78, 8, 10, 11, 36, 1, -6, 0, 12, 21, 14, 100, -8 } };

    public int[] testDepths = { 2, 3, 4, 4, 2, 3 };

    Queue<Node> q = null;

    /**
     * 
     */
    public MixTraversal()
    {
        q = new LinkedList<Node>();
        // TODO Auto-generated constructor stub
    }

    /**
     * Function print preorder for given depth d
     * @param root
     * @param depth
     * @param currentDepth
     */
    public void preorder(Node root, int depth, int currentDepth)
    {
        if (root != null && currentDepth != depth + 1)
        {
            System.out.print(root.value + ",");
            preorder(root.left, depth, currentDepth + 1);
            preorder(root.right, depth, currentDepth + 1);
        }
        else if (root != null)
            q.add(root);

    }
    
    /**
     * Function prints altering level order and preorder for each depth -d specified
     * @param root
     * @param depth
     */
    public void LevelOrderWithPreOrder(Node root, int depth)
    {
        int i = 1, levelCount = 0;
        Node node;
        while (true)
        {
            levelCount = q.size();
            if (levelCount == 0)
                break;
            while (levelCount > 0)
            {
                System.out.print(q.element().value + ",");
                node = q.peek();
                q.remove();
                if (node.left != null)
                {
                    q.add(node.left);
                }
                if (node.right != null)
                {
                    q.add(node.right);
                }
                levelCount--;
            }
            if (i == depth)
            {
                int nodesTobePreorder = q.size();
                while (nodesTobePreorder > 0)
                {
                    node = q.peek();
                    q.remove();
                    preorder(node, depth, 1);
                    nodesTobePreorder--;
                }
                i = 1;
            }
            i++;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int i,j;
        MixTraversal preorderLevelOrder = new MixTraversal();
        
        for (i = 0; i < preorderLevelOrder.testCases.length; i++)
        {
            System.out.println("\n\n################################################################");
            System.out.println("Input: "+ Arrays.toString(preorderLevelOrder.testCases[i]));
            Node root = null;
            for (j = 0; j < preorderLevelOrder.testCases[i].length; j++)
            {
                Node node = new Node(preorderLevelOrder.testCases[i][j]);
                root = preorderLevelOrder.bstInsert(root, node);
            }
            //preorderLevelOrder.inorder(root);
            preorderLevelOrder.q.add(root);
            preorderLevelOrder.LevelOrderWithPreOrder(root, preorderLevelOrder.testDepths[i]);
            preorderLevelOrder.q.clear();
        }
    }

}
