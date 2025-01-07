//Solve using Dynamic Programming

// You are given an undirected graph with n vertices labeled from 0 to n−1. 
// The graph is represented as an adjacency list. 
// Your task is to determine the number of connected components in the graph.

// A connected component is a subgraph where any two vertices are connected to each other 
// by a path, and which is connected to no additional vertices in the supergraph.

// Write a function to calculate the number of connected components in the graph.

// Input Format:
// --------------
// Line-1: Two integers n (number of vertices) and m (number of edges).
// Line-2 to m: The next m lines contain two integers each, representing an edge between two vertices 
// u and v (0-based indexing).

// Output Format:
// ---------------
// Print a single integer representing the number of connected components.

// Sample Input-1:
// ---------------
// 6 5
// 0 1
// 0 2
// 1 2
// 3 4
// 5 5

// Sample Output-1:
// ----------------
// 3

// Explanation:
// -------------
// The graph has three connected components: {0, 1, 2}, {3, 4}, {5}

// Sample Input-2:
// ---------------
// 5 3
// 0 1
// 1 2
// 3 4

// Sample Output-2:
// ----------------
// 2


import java.util.*;

public class ConnectedComponents {

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
    
    private static int countComponents(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                components++;
            }
        }
        
        return components;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(countComponents(n, adj));
        
        sc.close();
    }
}