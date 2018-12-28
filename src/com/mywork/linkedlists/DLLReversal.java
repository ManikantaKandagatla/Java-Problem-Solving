package com.mywork.linkedlists;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class DLLReversal
{
    @SuppressWarnings("unused")
    public static DLLNode reverseDLL(DLLNode head)
    {
        DLLNode temp = head;
        DLLNode prev = null;
        while (temp != null)
        {
            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            temp = temp.prev;
        }
        if (prev != null)
        {
            head = prev.prev;
        }
        return head;
    }

    public static void runTestCases()
    {
        Integer[][] testCases = { { 1, 2, 3, 4, 5 }, { 1 }, { 1, 2 }, { 3, 10, 7, 12 } };
        DoubleLinkedList dll = new DoubleLinkedList<Integer>();
        for (Integer[] arr : testCases)
        {
            DLLNode head = dll.createDLLfromArray(arr);
            System.out.print("Input: ");
            dll.printDLL(head);
            DLLNode revHead = reverseDLL(head);
            System.out.print("Reversal: ");
            dll.printDLL(revHead);
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
