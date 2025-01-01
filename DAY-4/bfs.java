// bfs traversal

import java.util.*;

class Graph 
{
    private int numVertices;
    private List<Integer>[] adjList;

    public Graph(int numVertices)
	{
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) 
	{
        adjList[source].add(destination);
    }

    public void BFS(int startVertex) 
	{
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) 
		{
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjList[currentVertex]) 
			{
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

class Main 
{
    public static void main(String[] args) 
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

        System.out.println("Breadth-First Traversal (starting from vertex 0):");
		graph.BFS(0);	// Update with 2
    }
}
