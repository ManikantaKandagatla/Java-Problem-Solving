package com.mywork.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

class HeapNode
{
    char letter;

    int frequency;

    HeapNode left;

    HeapNode right;

    HeapNode(char letter, int frequecy)
    {
        this.letter = letter;
        this.frequency = frequecy;
        this.left = null;
        this.right = null;
    }
}

class MinHeap
{
    public int size;

    public List<HeapNode> heapArray;

    MinHeap(int size)
    {
        heapArray = new ArrayList<HeapNode>();
        this.size = heapArray.size();
    }

    public void perculateUp(int index)
    {
        if (getParent(index) == -1)
            return;
        if (heapArray.get(getParent(index)).frequency > heapArray.get(index).frequency)
        {
            swap(getParent(index), index);
            perculateUp(getParent(index));
        }
    }

    public void swap(int index1, int index2)
    {
        HeapNode temp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, temp);

    }

    public void perculateDown(int index)
    {
        int children[], min;
        children = getChildren(index);
        if (children[0] == -1 && children[1] == -1)
            return;
        else if (children[0] != -1
                && heapArray.get(children[0]).frequency > heapArray.get(index).frequency
                && children[1] != -1
                && heapArray.get(children[1]).frequency > heapArray.get(index).frequency)
            return;
        else if (children[0] != -1 && children[1] == -1
                && heapArray.get(children[0]).frequency < heapArray.get(index).frequency)
        {
            swap(children[0], index);
            perculateDown(children[0]);
        }
        else if ((children[0] != -1
                && heapArray.get(children[0]).frequency < heapArray.get(index).frequency)
                || (children[1] != -1
                        && heapArray.get(children[1]).frequency < heapArray.get(index).frequency))
        {
            min = heapArray.get(children[1]).frequency < heapArray.get(children[0]).frequency
                    ? children[1] : children[0];
            swap(min, index);
            perculateDown(min);
        }
    }

    public int getParent(int index)
    {
        if (index > 0 && index <= this.size)
            return (index - 1) / 2;
        else
            return -1;
    }

    public int[] getChildren(int index)
    {
        int[] children = { -1, -1 };
        if (index >= 0 && index < this.size)
            if (2 * index + 1 < this.size)
                children[0] = 2 * index + 1;
        if (2 * index + 2 < this.size)
            children[1] = 2 * index + 2;
        return children;
    }

    public void insert(HeapNode newNode)
    {
        heapArray.add(newNode);
        this.size = this.size + 1;
        perculateUp(this.size - 1);
    }

    public HeapNode delete()
    {
        HeapNode root = heapArray.get(0);
        swap(0, this.size - 1);
        heapArray.remove(this.size - 1);
        this.size = this.size - 1;
        perculateDown(0);
        return root;
    }

    public void printHeapArray()
    {
        for (int i = 0; i < heapArray.size(); i++)
            System.out.print(heapArray.get(i).frequency + " ");
    }

    public void generateHuffmanEncoding()
    {
        while (this.size != 1)
        {
            HeapNode min1 = delete();
            HeapNode min2 = delete();
            HeapNode newNode = new HeapNode('$', min1.frequency + min2.frequency);
            newNode.left = min1;
            newNode.right = min2;
            System.out.println("min1: " + min1.frequency + " min2: " + min2.frequency + "\n");
            insert(newNode);
        }
    }

    public void printHuffManCoding(HeapNode root, String arr)
    {
        if (root.left != null)
        {
            String temp = arr;
            arr = arr + "0";
            printHuffManCoding(root.left, arr);
            arr = temp;
        }
        if (root.right != null)
        {

            arr = arr + "1";
            printHuffManCoding(root.right, arr);
        }
        if (root.left == null && root.right == null)
        {
            System.out.println(root.letter + ": " + arr + "\n");
        }
    }
}

public class HuffmanEncoding
{
    public static Scanner in = new Scanner(System.in);

    public HashMap<Character, Integer> calculateFreq(String str)
    {
        HashMap<Character, Integer> freqmap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++)
        {
            if (freqmap.get(str.charAt(i)) == null)
            {
                freqmap.put(str.charAt(i), 1);
            }
        }
        return freqmap;
    }

    public static void main(String args[])
    {
        String str = "abcdefghi";
        int[] frequency = { 12, 3, 45, 67, 19, 5, 34, 22, 1 };
        // System.out.println("Enter a string:");
        // str = in.next();
        // String str = "abcdef";
        // int frequency[] = { 5, 9, 12, 13, 16, 45 };
        MinHeap minHeap = new MinHeap(9);
        for (int i = 0; i < str.length(); i++)
        {
            HeapNode node = new HeapNode(str.charAt(i), frequency[i]);
            minHeap.insert(node);
        }
        minHeap.printHeapArray();
        minHeap.generateHuffmanEncoding();
        System.out.println("\n");
        minHeap.printHuffManCoding(minHeap.heapArray.get(0), "");

    }

}
