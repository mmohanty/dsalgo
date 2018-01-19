package org.manas.dsalgo.graph;

import java.util.LinkedList;

/**
 * Union-Find Algorithm | (Union By Rank and Find by Optimized Path Compression)
 * https://www.geeksforgeeks.org/union-find-algorithm-union-rank-find-optimized-path-compression/
 * @author manasmohanty
 *
 */
public class UnionFindAlgorithm {

	
	static class Graph{
		private int v;
		private LinkedList<Integer> []adj;
		
		@SuppressWarnings("unchecked")
		Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++) {
				adj[v] = new LinkedList<>();
			}
		}
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}
	}
}
