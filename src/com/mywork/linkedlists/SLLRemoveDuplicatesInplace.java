package com.mywork.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ManiKanta Kandagatla
 */
public class SLLRemoveDuplicatesInplace<T>
{
    
    public SLLNode removeDuplicatesSLL(SLLNode<T> head)
    {
        SLLNode temp = head, prev = null;
        Set<T> uniqueNodes = new HashSet<T>();
        while (temp != null)
        {
            if (!uniqueNodes.contains(temp.data))
            {
                if (prev != null)
                {
                    prev.next = temp;
                    prev = prev.next;
                }
                else
                {
                    prev = temp;
                }
                uniqueNodes.add((T) temp.data);
            }
            else
            {
                prev.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public void runTestCasesForIntegers()
    {
        Integer[][] testCases = { { 1, 2, 3, 4, 6, 2, 2, 6, 6, 3, 10 }, { 1, 1, 1, 1, 1 } };
        SingleLinkedList<Integer> testLL = new SingleLinkedList<Integer>();
        System.out.println("LinkedList of Integer data type");
        for (int i = 0; i < testCases.length; i++)
        {
            System.out.println("########################################################");
            SLLNode head = testLL.createSLLfromArray(testCases[i]);
            System.out.print("Input Linkedlist: ");
            testLL.printSLL(head);
            head = removeDuplicatesSLL(head);
            System.out.print("Output Linkedlist without duplicates: ");
            testLL.printSLL(head);
        }
        System.out.println("\n\n");
    }

    public void runTestCasesForStrings()
    {
        String[][] testCases = { { "kmk", "kmk", "abc" }, { "aaa", "aaa", "aaaaaa" } };
        SingleLinkedList<String> testLL = new SingleLinkedList<String>();
        System.out.println("LinkedList of String data type");
        for (int i = 0; i < testCases.length; i++)
        {
            System.out.println("########################################################");
            SLLNode head = testLL.createSLLfromArray(testCases[i]);
            System.out.print("Input Linkedlist: ");
            testLL.printSLL(head);
            head = removeDuplicatesSLL(head);
            System.out.print("Output Linkedlist without duplicates: ");
            testLL.printSLL(head);
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args)
    {
        SLLRemoveDuplicatesInplace<Integer> testObj = new SLLRemoveDuplicatesInplace<>();
        testObj.runTestCasesForIntegers();
        testObj.runTestCasesForStrings();
    }

}
