package com.mywork;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

public class MixTraversal extends BinaryTree
{
    int depth;

    int nodes;

    Queue<Node> q = null;

    /**
     * 
     */
    public MixTraversal()
    {
        q = new LinkedList<Node>();
        // TODO Auto-generated constructor stub
    }

    public void preorder(Node root, int depth, int currentDepth)
    {
        if(root!=null && currentDepth!=depth+1)
        {
            System.out.print(root.value+ ",");
            preorder(root.left,depth, currentDepth+1);
            preorder(root.right,depth, currentDepth+1);
        }
        else if(root!=null)
            q.add(root);
        
    }

    public void LevelOrderWithPreOrder(Node root, int depth)
    {
        int i=1,levelCount=0;
        Node node;
        while (true)
        {
            levelCount = q.size();
            if(levelCount==0)
                break;
            while(levelCount > 0)
            {
                System.out.print(q.element().value + ",");
                node = q.peek();
                q.remove();
                if (node.left != null)
                {
                      q.add(node.left);
                }
                if(node.right!=null)
                {   
                     q.add(node.right);
                }
                levelCount--;
            }
            if(i==depth)
            {
                int nodesTobePreorder = q.size();
                while(nodesTobePreorder > 0)
                {
                    node = q.peek();
                    q.remove();
                    preorder(node,depth,1);
                    nodesTobePreorder--;
                }
                i=1;
            }
            i++;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int i, newNode;
        MixTraversal preorderLevelOrder = new MixTraversal();
        System.out.print("Enter no.of nodes:");
        preorderLevelOrder.nodes = in.nextInt();
        Node root = null;
        for (i = 0; i < preorderLevelOrder.nodes; i++)
        {
            newNode = in.nextInt();
            Node node = new Node(newNode);
            root = preorderLevelOrder.bstInsert(root, node);
        }
        preorderLevelOrder.inorder(root);
        
        System.out.print("Enter depth:");
        preorderLevelOrder.depth = in.nextInt();
        preorderLevelOrder.q.add(root);
        preorderLevelOrder.LevelOrderWithPreOrder(root, preorderLevelOrder.depth);

    }

}
