package com.mywork.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

  private void dfsUtil(int v, boolean[] visited, LinkedList<Integer>[] adjList) {
    visited[v] = true;
    System.out.print(v + " ");
    Iterator<Integer> it = adjList[v].listIterator();
    while (it.hasNext()) {
      int adjNode = it.next();
      if (!visited[adjNode]) {
        dfsUtil(adjNode, visited, adjList);
      }
    }
  }

  private void dfs(int v, LinkedList<Integer>[] adjList, int numOfNodes) {
    boolean visited[] = new boolean[numOfNodes];
    dfsUtil(v, visited, adjList);
  }

  public void runTestCases() {
    int[][][] testCases = {{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}}};
    for (int i = 0; i < testCases.length; i++) {
      Graph g = new Graph(4);
      for (int j = 0; j < testCases[i].length; j++) {
        g.addEdge(testCases[i][j][0], testCases[i][j][1]);
      }
      dfs(2, g.getAdjList(), 4);
    }
  }

  public  static void main(String args[]) {
    DFS dfsObj = new DFS();
    dfsObj.runTestCases();
  }

}
