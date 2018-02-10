package com.mywork;
import java.util.*;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class DetectGraphLoop
{
    int V;
    Map<Integer,List<Integer>> adjacency = null;
    Map<Integer,Boolean> visited = null;
    Map<Integer,Boolean> recStack;
    
    public static Scanner in = new Scanner(System.in);
    
    public void print(String s)
    {
        System.out.println(s);
    }
    
    private void addEdge(int u,int v)
    {
        if(adjacency.get(u)==null)
        {
            this.adjacency.put(u, new ArrayList<Integer>() );
        }
            
        adjacency.get(u).add(v);
        visited.put(u, false);
        visited.put(v, false);
    }
    
    private int getV()
    {
        return this.V;
    }

    private void setV(int v)
    {
        this.V = v;
    }
    
    private DetectGraphLoop()
    {
        visited = new HashMap<Integer,Boolean>();
        adjacency = new HashMap<Integer,List<Integer>>();
        recStack = new HashMap<Integer,Boolean>();
    }
    
     
    private boolean isLoop(int u)
    {
        
        if(!visited.get(u))
        {
            recStack.put(u,true);
            visited.put(u, true);
            List<Integer> adjacent = adjacency.get(u);
            for(int node: adjacent)
            {
                if(!visited.get(node) && isLoop(node))
                    return true;
                else if(recStack.get(node))
                    return true;
                    
            }
        }
        recStack.put(u,false);
        return false;
    }
    
    private boolean checkLoop()
    {
        for(Map.Entry<Integer, List<Integer>> entry : adjacency.entrySet())
        {
            int key = entry.getKey();
            if(isLoop(key))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        int edgeCount,i,u,v;
        boolean containsLoop;
        DetectGraphLoop dfs = new DetectGraphLoop();
        dfs.print("Enter no.of Edges in graphs:");
        edgeCount = in.nextInt();
        for(i = 0 ;i< edgeCount ;i++)
        {
             u = in.nextInt();
             v = in.nextInt();
             dfs.recStack.put(u,false);
             dfs.recStack.put(v,false);
             dfs.visited.put(u, false);
             dfs.visited.put(v, false);
             dfs.addEdge(u, v);
        }
        
        containsLoop = dfs.checkLoop();
        dfs.print("Contains loop:" + containsLoop);
    }
}
