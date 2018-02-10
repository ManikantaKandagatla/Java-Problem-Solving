package com.mywork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class SortedLevelOrder extends BinaryTree
{
    private TreeSet<Node> currentLevel = null;

    private TreeSet<Node> nextLevel = null;

    private int[][] testCases = { { 1, 14, 8, -1, 34, 17, 19, 15, 11, 6, 39 },
            { 23, 56, 1, -3, 100, 76, 34, 0 },
            {1,2},
            {1},
            {1,3,2,7,4,6,5,11,8,12,9,10}};

    public SortedLevelOrder()
    {
        Comparator<Node> nodeComparator = new Comparator<Node>()
        {

            @Override
            public int compare(Node node1, Node node2)
            {
                return node1.value > node2.value ? -1 : 1;
            }
        };
        currentLevel = new TreeSet<Node>(nodeComparator);
        nextLevel = new TreeSet<Node>(nodeComparator);
    }

    /**
     * Given a node prints the level order in sorted order
     * 
     * @param root
     */
    public void levelOrder(Node root)
    {
        currentLevel.add(root);
        while (true)
        {
            if (currentLevel.size() == 0)
                break;
            else
            {
                nextLevel.clear();
                for (Node currentNode : currentLevel)
                {
                    System.out.print(currentNode.value + ",");
                    if (currentNode.left != null)
                    {
                        nextLevel.add(currentNode.left);
                    }
                    if (currentNode.right != null)
                    {
                        nextLevel.add(currentNode.right);
                    }
                }
                currentLevel.clear();
                currentLevel.addAll(nextLevel);
            }
            System.out.println("");
        }
    }

    private void printSortedQueue(TreeSet<Node> q)
    {
        for (Node node : q)
        {
            System.out.print("" + node.value + ",");
        }
    }

    public static void main(String[] args)
    {
        SortedLevelOrder sortedLevelOrder = new SortedLevelOrder();
        for (int i = 0; i < sortedLevelOrder.testCases.length; i++)
        {
            Node root = null;
            System.out.println("#################################################################");
            System.out.println("Input: " +Arrays.toString( sortedLevelOrder.testCases[i]));
            System.out.println("Sorted Level order: ");
            for (int j = 0; j < sortedLevelOrder.testCases[i].length; j++)
            {
                Node node = new Node(sortedLevelOrder.testCases[i][j]);
                root = sortedLevelOrder.btInsert(node);
            }
            sortedLevelOrder.btQueu.clear();
            sortedLevelOrder.levelOrder(root);
        }

    }
}
