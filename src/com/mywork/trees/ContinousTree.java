package com.mywork.trees;

import java.util.Arrays;
import java.util.Objects;

public class ContinousTree extends BinaryTree {

    private boolean isContinousTree(Node root) {
        if(Objects.isNull(root)) {
            return true;
        } else {
           boolean result =  isContinousTree(root.left) && isContinousTree(root.right);
           if(result) {
               if(Objects.nonNull(root.left)) {
                   result = Math.abs(root.value - root.left.value) == 1;
               }
               if(Objects.nonNull(root.right)) {
                   result = result && (Math.abs(root.value - root.right.value) == 1);
               }
           }
           return result;
        }
    }

    public static void runTestCases() {
        int i, j;
        int[][] testCases = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
                {3, 2, 4, 1, 3, 5} };
        for (i = 0; i < testCases.length; i++)
        {
            ContinousTree tree = new ContinousTree();
            System.out.println("\n\n################################################################");
            System.out.println("Input: "+ Arrays.toString(testCases[i]));
            Node root = null;
            for (j = 0; j < testCases[i].length; j++)
            {
                Node node = new Node(testCases[i][j]);
                root = tree.btInsert(node);
            }
            tree.inorder(root);
            System.out.println("Is continous tree: " + tree.isContinousTree(root));
        }
    }

    public static void main(String args[]) {
        runTestCases();
    }
}
