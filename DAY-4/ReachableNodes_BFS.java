/* You are given an undirected graph represented by a set of vertices and edges as input. The graph contains N vertices and M edges. 
Your task is to determine the number of reachable and non-reachable nodes from each vertex in the graph using Breadth-First Search (BFS).

Node B is reachable from a node A if there exists a path between A and B through one or more edges. Otherwise, the node is considered non-reachable.

Input Format:
-------------
Line-1: Two integers N and M — the number of vertices and edges.
Line-2 to M: The next M lines each contain two integers u and v, indicating an undirected edge between vertices u and v.

Output Format:
--------------
For each vertex v (1 to N)
Print the number of reachable nodes and the number of non-reachable nodes.

Sample Input-1:
---------------
6 6
1 2
1 3
2 3
3 4
1 4
5 6

Sample Output-1:
----------------
1
4 2
2
4 2
3
4 2
4
4 2
5
2 4
6
2 4


*/
import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void bfs(int startNode) {
        //System.out.println("From vertex \"" + startNode + "\"");
	System.out.println(startNode);
        boolean[] visited = new boolean[vertices + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        int reachableCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            reachableCount++;
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        //System.out.println("No. of reachable nodes are :" + reachableCount);
        //System.out.println("No. of non-reachable nodes are :" + (vertices - reachableCount) + "\n");
	System.out.println(reachableCount + " "+ (vertices - reachableCount));
    }
}

public class ReachableNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of vertices and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph graph = new Graph(n);

        //System.out.println("Enter the edges (u v):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        for (int i = 1; i <= n; i++) {
            graph.bfs(i);
        }
    }
}

/*
Test cases:
case =1
input =6 6
1 2
1 3
2 3
3 4
1 4
5 6
output =1
4 2
2
4 2
3
4 2
4
4 2
5
2 4
6
2 4

case =2
input =4 2
1 2
3 4
output=1
2 2
2
2 2
3
2 2
4
2 2

case =3
input =5 0
output =1
1 4
2
1 4
3
1 4
4
1 4
5
1 4

case =4
input =7 7
1 2
2 3
3 4
4 1
5 6
6 7
7 5
output =1
4 3
2
4 3
3
4 3
4
4 3
5
3 4
6
3 4
7
3 4

*/