package org.manas.dsalgo.graph;
/**
 * https://www.geeksforgeeks.org/strongly-connected-components/
 * Strongly Connected Components
A directed graph is strongly connected if there is a path between all pairs of vertices. 
A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph. 
For example, there are 3 SCCs in the following graph.

 * @author manasmohanty
 *
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgo {

	private int verticesCount;
	private LinkedList<Integer> []adj;
	
	@SuppressWarnings("unchecked")
	public KosarajuAlgo(int verticesCount) {
		this.verticesCount = verticesCount;
		adj = new LinkedList[verticesCount];
		 for (int i=0; i<verticesCount; ++i)
	            adj[i] = new LinkedList<>();
	}
	
	//Function to add an edge into the graph
    void addEdge(int v, int w)  { adj[v].add(w); }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    KosarajuAlgo getTranspose(){
    		KosarajuAlgo g = new KosarajuAlgo(verticesCount);
        for (int v = 0; v < verticesCount; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly
    // connected components
    void printSCCs()
    {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[verticesCount];
        for(int i = 0; i < verticesCount; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < verticesCount; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        KosarajuAlgo gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < verticesCount; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
    		KosarajuAlgo g = new KosarajuAlgo(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                           "in given graph ");
        g.printSCCs();
    }
}
