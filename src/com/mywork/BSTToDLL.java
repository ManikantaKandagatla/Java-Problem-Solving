package com.mywork;

/**
 * @author ManiKanta Kandagatla
 */
public class BSTToDLL extends BinaryTree
{
    private Node dllStart;

    private Node pre;

    public Node getPre()
    {
        return pre;
    }

    public void setPre(Node pre)
    {
        this.pre = pre;
    }

    public Node getDllStart()
    {
        return dllStart;
    }

    public void setDllStart(Node dllStart)
    {
        this.dllStart = dllStart;
    }

    /**
     * Recursively traverse the tree in inorder and link left as previous pointer and right as next
     * pointer
     * 
     * @param root
     */
    public void inorderToDLL(Node root)
    {
        if (root != null)
        {
            inorderToDLL(root.left);
            if (getPre() == null)
            {
                setDllStart(root);
            }
            else
            {
                root.left = pre;
                pre.right = root;
            }
            setPre(root);
            inorderToDLL(root.right);
        }
    }

    /**
     * Utility function to convert BST to DLL and print it
     * 
     * @param root
     */
    public void printBSTToDLL(Node root)
    {

        inorderToDLL(root);
        Node temp = getDllStart();
        while (temp != null)
        {
            System.out.print(temp.value + ", ");
            temp = temp.right;
        }
        System.out.println("");
    }

    public void testBSTToDLL()
    {
        int[][] testCases = { { 1, 14, 8, -1, 34, 17, 19, 15, 11, 6, 39 },
                { 23, 56, 1, -3, 100, 76, 34, 0 }, { 1, 2 }, { 1 },
                { 1, 3, 2, 7, 4, 6, 5, 11, 8, 12, 9, 10 } };
        Node root;
        for (int i = 0; i < testCases.length; i++)
        {
            root = null;
            setPre(null);
            for (int j = 0; j < testCases[i].length; j++)
            {
                Node newNode = new Node(testCases[i][j]);
                root = bstInsert(root, newNode);
            }
            printBSTToDLL(root);
        }
    }

    public static void main(String[] args)
    {
        BSTToDLL testObj = new BSTToDLL();
        testObj.testBSTToDLL();
    }
}
