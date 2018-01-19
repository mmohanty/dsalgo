package org.manas.dsalgo.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Detect Cycle in a Directed Graph 2.8 Given a directed graph, check whether
 * the graph contains a cycle or not. Your function should return true if the
 * given graph contains at least one cycle, else return false. For example, the
 * following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your
 * function must return true.
 * 
 * https://www.geeksforgeeks.org/?p=18516
 * 
 * @author manasmohanty
 *
 */
public class CycleInDirectedGraph {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		if (g.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

	static class Graph {
		LinkedList<Integer>[] adj;
		Integer v;

		@SuppressWarnings("unchecked")
		Graph(Integer v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {

			if (!visited[v]) {
				visited[v] = true;
				recStack[v] = true;

				// Recur for all the vertices adjacent to this
				// vertex
				Integer i = null;
				Iterator<Integer> it = adj[v].iterator();
				while (it.hasNext()) {
					i = it.next();
					if (!visited[i] && isCyclicUtil(i, visited, recStack))
						return true;
					else if (recStack[i])
						return true;
				}
			}
			recStack[v] = false;
			return false;
		}

		boolean isCyclic() {
			// Mark all the vertices as not visited and not part of recursion
			// stack
			boolean[] visited = new boolean[v];
			boolean[] recStack = new boolean[v];
			for (int i = 0; i < v; i++) {
				visited[i] = false;
				recStack[i] = false;
			}

			// Call the recursive helper function to detect cycle in different
			// DFS trees
			for (int i = 0; i < v; i++) {
				if (isCyclicUtil(i, visited, recStack)) {
					return true;
				}
			}
			return false;
		}
	}
}
