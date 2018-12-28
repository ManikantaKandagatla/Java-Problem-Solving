package com.mywork.linkedlists;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class DoubleLinkedList<T>
{
    public DLLNode<T> createNode(T data)
    {
        DLLNode<T> node = new DLLNode<T>();
        node.next = null;
        node.prev = null;
        node.data = data;
        return node;
    }

    public DLLNode createDLLfromArray(T[] arr)
    {
        DLLNode<T> head = null, temp = head;
        for (int i = 0; i < arr.length; i++)
        {
            DLLNode<T> newNode = createNode(arr[i]);
            if (temp != null)
            {
                temp.next = newNode;
                newNode.prev = temp;
                temp = temp.next;
            }
            else
            {
                temp = newNode;
                head = temp;
            }
        }
        return head;
    }

    public void printDLL(DLLNode<T> head)
    {
        DLLNode<T> temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("");
    }

}
