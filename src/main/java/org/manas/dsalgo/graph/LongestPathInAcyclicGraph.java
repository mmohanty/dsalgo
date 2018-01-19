package org.manas.dsalgo.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 * 
 * @author manasmohanty
 *
 */
public class LongestPathInAcyclicGraph {

	static class Graph {
		int v; // No. of vertices'

		// Pointer to an array containing adjacency lists
		// AdjListNode[] adj;
		private LinkedList<AdjListNode> adj[];

		@SuppressWarnings("unchecked")
		public Graph(int v) // Constructor
		{
			this.v = v;
			// adj = new AdjListNode[v-1];
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList<AdjListNode>();
		}

		void addEdge(int u, int v, int weight) {
			AdjListNode node = new AdjListNode(v, weight);
			adj[u].add(node); // Add v to u's list
		}

		// A recursive function used by longestPath. See below
		// link for details
		// https://www.geeksforgeeks.org/topological-sorting/
		void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
			// Mark the current node as visited
			visited[v] = true;
			AdjListNode i;

			// Recur for all the vertices adjacent to this vertex
			Iterator<AdjListNode> it = adj[v].iterator();
			while (it.hasNext()) {
				i = it.next();
				if (!visited[i.getV()])
					topologicalSortUtil(i.getV(), visited, stack);
			}

			// Push current vertex to stack which stores topological
			// sort
			stack.push(v);
		}

		// The function to find longest distances from a given vertex.
		// It uses recursive topologicalSortUtil() to get topological
		// sorting.
		void longestPath(int s) {
			Stack<Integer> stack = new Stack<>();
			int[] dist = new int[v];

			// Mark all the vertices as not visited
			boolean[] visited = new boolean[v];
			for (int i = 0; i < v; i++)
				visited[i] = false;

			// Call the recursive helper function to store Topological
			// Sort starting from all vertices one by one
			for (int i = 0; i < v; i++)
				if (visited[i] == false)
					topologicalSortUtil(i, visited, stack);

			// Initialize distances to all vertices as infinite and
			// distance to source as 0
			for (int i = 0; i < v; i++)
				dist[i] = Integer.MIN_VALUE;
			dist[s] = 0;

			// Process vertices in topological order
			while (!stack.empty()) {
				// Get the next vertex from topological order
				int u = stack.peek();
				stack.pop();

				// Update distances of all adjacent vertices
				if (dist[u] != Integer.MIN_VALUE) {
					AdjListNode node;
					Iterator<AdjListNode> it = adj[u].iterator();
					while (it.hasNext()) {
						node = it.next();
						if (dist[node.getV()] < dist[u] + node.getWeight()) {
							dist[node.getV()] = dist[u] + node.getWeight();
						}
					}
				}
			}

			// Print the calculated longest distances
			for (int i = 0; i < v; i++)
				System.out.print(dist[i] == Integer.MIN_VALUE ? "INF" + " " : dist[i] + " ");
		}
	}

	public static void main(String[] args) {
		// Create a graph given in the above diagram.
		// Here vertex numbers are 0, 1, 2, 3, 4, 5 with
		// following mappings:
		// 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
		Graph g = new Graph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int s = 1;
		System.out.println("Following are longest distances from " + "source vertex " + s + " \n");
		g.longestPath(s);

	}

}

class AdjListNode {
	int v;
	int weight;

	AdjListNode(int v, int w) {
		this.v = v;
		this.weight = w;
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return weight;
	}
}
