package com.mywork.arrays;
/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Heap
{

    public List<Integer> heapArray;

    public int size;

    public Heap()
    {
        heapArray = new ArrayList<Integer>();
        this.size = 0;
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

    public int getParent(int index)
    {
        if (index > 0 && index < size)
            return (index - 1) / 2;
        else
            return -1;
    }

    public void insert(int element)
    {
        heapArray.add(element);
        this.size = this.size + 1;
        perculateUp(this.size - 1);
    }

    public void perculateUp(int index)
    {
        if (getParent(index) == -1)
            return;
        if (heapArray.get(getParent(index)) > heapArray.get(index))
        {
            swap(getParent(index), index);
            perculateUp(getParent(index));
        }
    }

    public void perculateDown(int index)
    {
        int children[], min;
        children = getChildren(index);
        if (children[0] == -1 && children[1] == -1)
            return;
        else if (children[0] != -1 && heapArray.get(children[0]) > heapArray.get(index)
                && children[1] != -1 && heapArray.get(children[1]) > heapArray.get(index))
            return;
        else if (children[0] != -1 && children[1] == -1
                && heapArray.get(children[0]) < heapArray.get(index))
        {
            swap(children[0], index);
            perculateDown(children[0]);
        }
        else if ((children[0] != -1 && heapArray.get(children[0]) < heapArray.get(index))
                || (children[1] != -1 && heapArray.get(children[1]) < heapArray.get(index)))
        {
            min = heapArray.get(children[1]) < heapArray.get(children[0]) ? children[1]
                    : children[0];
            swap(min, index);
            perculateDown(min);
        }
    }

    public void swap(int index1, int index2)
    {
        int temp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, temp);

    }

    public boolean delete(int element, int index)
    {
        boolean success = false;
        if (index > this.size)
            return false;
        else if (heapArray.get(index) < element)
            return false;
        if (heapArray.get(index) == element)
        {
            swap(index, this.size - 1);
            heapArray.remove(this.size - 1);
            this.size = this.size - 1;
            perculateDown(index);
            return true;
        }
        int[] children = getChildren(index);
        if (children[0] != -1 && heapArray.get(children[0]) > element)
            success = delete(element, children[0]);
        if (success == false && children[1] != -1 && heapArray.get(children[0]) > element)
            success = delete(element, children[0]);
        return success;
    }

    public static void main(String[] args)
    {
        int operations;
        Scanner in = new Scanner(System.in);
        operations = in.nextInt();
        System.out.println("Operations: " + operations);
        Heap solution = new Heap();
        int element;
        for (int i = 0; i < operations; i++)
        {
            int choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    element = in.nextInt();
                    solution.insert(element);
                    break;
                case 2:
                    element = in.nextInt();
                    boolean success = solution.delete(element, 0);
                    break;
                case 3:
                    System.out.println(solution.heapArray.get(0));
                    break;
            }
        }
    }
}