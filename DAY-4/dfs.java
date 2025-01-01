// Java program to print DFS traversal from a graph

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list representation
class Graph 
{
	private int V;

	// Array of lists for Adjacency List Representation
	private List<Integer> adj[];

	// Constructor
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		// Add w to v's list
		adj[v].add(w);
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[])
	{
		// create a stack used to do iterative DFS
        Stack<Integer> stack = new Stack<>();
 
        // push the source node into the stack
        stack.push(v);
 
        // loop till stack is empty
        while (!stack.empty())
        {
            // Pop a vertex from the stack
            v = stack.pop();
 
            // if the vertex is already visited, ignore it
            if (visited[v]) {
                continue;
            }
 
            // we will reach here if the popped vertex `v` is not visited yet;
            // print `v` and process its unvisited adjacent nodes into the stack
            visited[v] = true;
            System.out.print(v + " ");
 
            // do for every edge (v, u)
            List<Integer> adjList = adj[v];
            for (int i = adjList.size() - 1; i >= 0; i--)
            {
                int u = adjList.get(i);
                if (!visited[u]) {
                    stack.push(u);
                }
            }
        }
	}

	// The function to do DFS traversal. It uses interactive DFSUtil()
	void DFS(int v)
	{
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[V];

		// Call the interactive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	public static void main(String args[])
	{
		Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
	    graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 3);

		System.out.println("Depth First Traversal (starting from vertex 0)");

		graph.DFS(0);	// Update with 2
	}
}