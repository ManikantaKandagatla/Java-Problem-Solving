package com.mywork.graphs;

import java.util.LinkedList;

public class Graph {

  private int v;
  LinkedList<Integer> adjList[];

  public Graph(int v) {
    this.v = v;
    adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adjList[u].add(v);
  }

  public LinkedList<Integer>[] getAdjList() {
    return this.adjList;
  }
}
