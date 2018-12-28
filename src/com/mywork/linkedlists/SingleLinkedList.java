package com.mywork.linkedlists;

/**
 * @author ManiKanta Kandagatla
 */
public class SingleLinkedList<T>
{
    public SLLNode<T> createNode(T data)
    {
        SLLNode<T> node = new SLLNode<T>();
        node.next = null;
        node.data = data;
        return node;
    }

    public SLLNode createSLLfromArray(T[] arr)
    {
        SLLNode<T> head = null, temp = head;
        for (int i = 0; i < arr.length; i++)
        {
            SLLNode<T> newNode = createNode(arr[i]);
            if (temp != null)
            {
                temp.next = newNode;
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

    public void printSLL(SLLNode<T> head)
    {
        SLLNode<T> temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("");
    }
}
