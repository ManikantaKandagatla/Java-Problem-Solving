package com.mywork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class OrganizationTree
{
    public int[][][] testCases = { { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 8 }, { 2, 6 },
            { 7, 10 }, { 7, 9 }, { 100, 1 }, { 100, 7 }, { 2, 12 }, { 12, 14 }, { 14, 16 } }, 
            { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 8 }, { 2, 6 },
                { 7, 10 }, { 7, 9 }, { 100, 1 }, { 100, 7 }, { 12, 14 }, { 14, 16 }, { 2, 12 }}};

    public HashMap<Integer, NaryNode> parentBuffer;

    public HashMap<Integer, Integer> parentLookup;

    public OrganizationTree()
    {
        parentBuffer = new HashMap<Integer, NaryNode>();
        parentLookup = new HashMap<Integer, Integer>();
    }

    /**
     * Insert a node parent, child edge in tree
     * 
     * @param node
     * @param i
     * @param j
     * @return
     */
    private NaryNode insertOrganizationTree(NaryNode node, int i, int j)
    {
        parentLookup.put(j, i);
        if (node == null)
        {
            node = new NaryNode(i);
            NaryNode child = new NaryNode(j);
            node.children.put(j, child);
            parentLookup.put(i, -1);
            parentBuffer.put(i, node);
        }
        else
        {
            NaryNode directParent = parentBuffer.get(i);
            if (directParent == null)
            {
                if (parentLookup.get(i) != null)
                {
                    int parent = j;
                    List<Integer> parentsPath = new ArrayList<Integer>();
                    while (true)
                    {
                        parent = parentLookup.get(parent);
                        if (parentLookup.get(parent) == -1)
                            break;
                        parentsPath.add(parent);
                    }
                    directParent = parentBuffer.get(parent);
                    for (int index = parentsPath.size() - 1; index >= 0; index--)
                    {
                        directParent = directParent.children.get(parentsPath.get(index));
                    }
                    directParent.children.put(j, new NaryNode(j));
                }
                else
                {
                    NaryNode newParentBufferNode = new NaryNode(i);
                    NaryNode childInParentBuffer = parentBuffer.get(j);
                    if (childInParentBuffer == null)
                    {
                        NaryNode child = new NaryNode(j);
                        newParentBufferNode.children.put(j, child);
                    }
                    else
                    {
                        newParentBufferNode.children.put(j, childInParentBuffer);
                        parentBuffer.remove(j);
                    }
                    parentLookup.put(i, -1);
                    parentBuffer.put(i, newParentBufferNode);
                }

            }
            else
            {
                NaryNode childInParentBuffer = parentBuffer.get(j);
                if (childInParentBuffer == null)
                {
                    directParent.children.put(j, new NaryNode(j));
                }
                else
                {
                    directParent.children.put(j, childInParentBuffer);
                    parentBuffer.remove(j);
                }
            }
        }
        return node;
    }

    private void printNaryTree(NaryNode root)
    {
        Queue<NaryNode> parseQueue = new LinkedList<NaryNode>();
        parseQueue.add(root);
        while (true)
        {
            int levelCount = parseQueue.size();
            if (levelCount == 0)
                break;
            for (int i = 0; i < levelCount; i++)
            {
                NaryNode currentNode = parseQueue.peek();
                Set<Integer> children = currentNode.children.keySet();
                for (int child : children)
                {
                    parseQueue.add(currentNode.children.get(child));
                }
                System.out.print("" + currentNode.value + ",");
                parseQueue.remove();
            }
            System.out.println("");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        OrganizationTree orgTreeObj = new OrganizationTree();
        for (int i = 0; i < orgTreeObj.testCases.length; i++)
        {
            System.out.println("#############################################################");
            NaryNode root = null;
            for (int j = 0; j < orgTreeObj.testCases[i].length; j++)
            {
                root = orgTreeObj.insertOrganizationTree(root, orgTreeObj.testCases[i][j][0],
                        orgTreeObj.testCases[i][j][1]);
                // System.out.println(root.toString());
            }
            //
            System.out.println("Organization Tree: ");
            Iterator<Entry<Integer, NaryNode>> it = orgTreeObj.parentBuffer.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<Integer, NaryNode> pair = (Map.Entry<Integer, NaryNode>) it.next();
                orgTreeObj.printNaryTree((NaryNode) pair.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }
            orgTreeObj.parentBuffer.clear();
            orgTreeObj.parentLookup.clear();
        }
    }

}
