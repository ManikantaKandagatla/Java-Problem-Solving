package com.mywork.trees;

import java.util.*;

/**
 * @author ManiKanta Kandagatla
 */
public class BinaryTreeFromParentTree extends BinaryTree {
    public void runTestCases() {
        int tcs[][] = {{1, 5, 5, 2, 2, -1, 3}, {-1, 0, 0, 1, 1, 3, 5}, {1, 5, 5, 2, 2, -1, 3, 0, 4, 4},
                {-1, 0, 1, 2, 3, 4, 5}, {-1, 0}};
        for (int[] tc : tcs) {
            Map<Integer, List<Integer>> parentChildMap = getparentChildMap(tc);
            Node root = new Node(parentChildMap.get(-1).get(0));
            Queue<Node> insertQueue = new LinkedList<>();
            insertQueue.add(root);
            while (!insertQueue.isEmpty()) {
                Node currentNode = insertQueue.peek();
                //System.out.println(currentNode.value);
                List<Integer> nextChilds = parentChildMap.get(currentNode.value);
                if (nextChilds != null && !nextChilds.isEmpty()) {
                    currentNode.left = new Node(nextChilds.get(0));
                    insertQueue.add(currentNode.left);
                    if (nextChilds.size() == 2) {
                        currentNode.right = new Node(nextChilds.get(1));
                        insertQueue.add(currentNode.right);
                    }
                }
                insertQueue.remove();
            }
            System.out.println("Input: " + Arrays.toString(tc));
            System.out.print("Preorder: ");
            preOrder(root);
            System.out.println("\n\n");
        }
    }

    private static Map<Integer, List<Integer>> getparentChildMap(int[] parentArray) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        for (int i = 0; i < parentArray.length; i++) {
            if (parentChildMap.containsKey(parentArray[i])) {
                parentChildMap.get(parentArray[i]).add(i);
            } else {
                List<Integer> childs = new ArrayList<>();
                childs.add(i);
                parentChildMap.put(parentArray[i], childs);
            }
        }
        //System.out.println(parentChildMap);
        return parentChildMap;
    }

    public static void main(String args[]) {
        BinaryTreeFromParentTree bt = new BinaryTreeFromParentTree();
        bt.runTestCases();
    }
}
