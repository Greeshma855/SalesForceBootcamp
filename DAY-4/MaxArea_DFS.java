/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

=== testcases ===
case =1
input =5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0
output =5

case =2
input =5 5
0 1 1 1 1
1 0 0 0 1
1 1 0 1 0
0 1 0 1 1
0 1 1 1 0
output =15

case =3
input =7 5
1 1 1 0 1
0 0 1 0 0
1 1 0 1 0
0 1 1 0 0
0 0 0 0 0
0 1 0 0 0
0 0 1 1 0
output =9

case =4
input =8 9
0 1 0 0 0 0 1 1 0
1 1 0 0 1 0 0 0 1
0 0 0 0 1 0 1 0 0
0 1 1 1 0 1 0 1 1
0 1 1 1 0 0 1 1 0
0 1 0 1 1 0 1 1 0
0 1 0 0 1 1 0 1 1
1 0 1 1 1 1 0 0 0
output =29

case =5
input =13 18
0 0 0 0 0 0 0 1 0 0 0 1 0 1 0 1 0 1
1 1 1 1 0 1 1 1 0 0 0 0 1 1 0 1 1 1
0 1 1 1 1 1 1 0 0 1 0 1 1 1 0 1 0 1
0 1 1 1 1 0 0 1 1 0 1 0 1 0 0 1 0 0
0 0 0 1 1 0 0 0 1 1 0 1 1 1 0 1 1 1
0 1 1 1 1 1 0 0 1 1 1 1 0 1 0 1 1 1
1 0 0 1 1 1 0 0 1 1 1 1 1 1 1 0 1 0
0 0 1 0 0 0 0 1 1 1 1 1 0 1 0 1 0 1
0 1 1 1 1 1 0 0 1 0 0 0 1 1 1 1 1 0
1 0 1 0 0 1 1 0 1 1 1 1 1 0 1 1 0 1
0 1 1 0 0 1 1 1 1 1 1 0 0 0 1 0 0 1
0 0 0 1 0 0 1 1 1 1 0 1 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 0 1 0 0 1 1 0 0
output =125

case =6
input =15 18
1 0 1 1 1 1 1 0 1 0 0 1 1 0 0 1 1 1
0 0 1 1 1 1 1 1 1 0 0 0 0 0 1 0 1 1
1 0 1 1 1 0 0 0 0 0 1 1 0 1 1 0 1 1
1 0 0 0 1 0 0 0 0 1 1 0 0 1 1 0 1 0
1 0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 0 0
1 0 0 1 1 0 1 0 0 0 0 1 0 0 1 1 0 1
1 1 1 1 0 1 0 0 0 0 1 1 1 1 1 0 1 0
1 1 1 1 1 0 1 1 1 0 1 0 1 1 0 0 1 0
0 1 0 0 0 0 0 0 1 0 0 1 0 0 1 1 1 0
1 0 1 0 1 0 0 1 1 1 0 1 1 1 0 0 0 0
0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 0 0 1
0 1 0 1 0 0 1 1 0 0 1 1 0 1 0 1 0 1
0 1 0 0 1 1 1 1 0 1 1 1 0 0 0 0 1 0
1 0 0 0 0 1 0 1 0 0 1 0 0 1 1 1 0 0
1 0 1 1 1 0 0 1 0 0 1 1 0 1 1 0 0 1
output =70

case =7
input =15 25
1 0 1 1 1 0 0 0 1 0 1 0 1 0 0 0 1 0 0 1 1 0 0 0 0
0 0 1 1 1 1 0 1 1 1 0 0 1 0 0 0 1 0 1 1 1 1 0 1 1
1 1 1 1 1 0 0 0 1 1 0 0 1 1 1 0 0 0 0 0 1 0 0 0 0
1 1 1 1 1 0 1 1 0 0 0 0 1 0 1 1 0 1 0 1 0 1 1 0 0
1 1 1 1 0 1 0 0 1 0 0 1 1 1 1 1 1 1 1 1 0 0 1 0 0
0 1 0 0 0 1 0 0 0 1 0 1 0 1 1 0 0 1 1 1 1 1 1 0 0
0 1 1 1 0 1 1 1 0 1 1 1 0 1 0 1 0 1 0 1 0 1 1 1 1
1 0 1 1 0 1 0 0 0 0 0 1 0 1 1 0 1 1 1 1 0 1 0 1 0
1 0 1 0 0 1 0 1 0 0 1 1 0 1 0 1 1 0 0 1 0 1 1 1 1
1 1 1 1 1 0 0 0 1 0 0 1 0 1 1 1 0 1 0 0 1 0 1 1 0
0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0
0 0 1 0 0 0 0 1 0 0 1 1 1 1 1 0 1 1 1 0 1 0 0 0 0
1 1 0 0 1 0 1 0 0 1 0 1 0 0 0 1 1 1 0 0 0 1 1 1 1
1 1 1 0 1 0 1 0 1 1 0 1 1 1 1 1 0 0 1 0 1 0 0 1 1
1 0 1 0 1 0 1 1 0 1 1 0 1 0 0 1 0 1 0 1 0 1 0 0 1
output =177

case =8
input =20 25
1 0 0 0 0 1 1 0 0 0 0 0 1 1 1 1 1 0 1 1 1 1 0 0 0
1 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 0 1 1 0 1
0 1 1 0 1 0 0 1 1 0 0 0 0 1 1 0 1 1 0 0 1 0 1 0 0
1 0 1 0 0 0 0 0 0 0 1 1 0 0 0 0 1 0 1 1 1 1 0 0 1
1 0 1 0 0 0 0 1 0 0 0 1 1 0 0 0 0 0 0 0 0 0 1 0 1
1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 1 0 0 0 0 0 0
1 0 0 1 0 0 0 0 1 0 0 0 1 0 1 0 0 1 0 1 1 1 0 0 0
0 1 1 1 1 1 1 0 0 1 1 1 0 0 0 0 0 1 0 0 0 0 0 0 1
1 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 1 0
1 0 0 0 1 0 1 1 1 0 1 0 0 1 1 1 1 1 1 0 0 0 0 0 1
1 1 1 0 1 0 1 0 0 0 0 0 1 1 1 0 0 0 1 1 1 1 1 1 0
1 0 0 0 0 1 1 0 1 0 1 0 0 1 1 0 1 1 0 1 0 1 1 0 0
1 0 1 1 0 0 1 1 1 1 0 0 0 1 0 1 1 0 0 1 0 0 1 1 0
0 0 0 1 1 0 1 1 1 1 0 0 1 1 0 0 1 0 0 1 1 1 0 1 1
0 1 0 0 1 0 0 0 0 1 0 1 0 1 0 1 0 0 0 1 1 0 0 1 0
1 0 0 0 0 1 0 1 0 1 1 1 0 1 1 1 0 1 0 1 0 0 0 0 1
0 1 0 1 1 0 0 0 0 1 0 1 1 1 1 1 0 0 0 0 0 0 0 1 1
0 1 0 1 1 1 1 1 0 0 0 1 1 1 1 0 0 1 1 0 1 0 1 1 1
0 0 0 1 1 0 1 0 1 0 1 1 0 0 1 1 1 0 1 0 0 0 0 1 1
0 1 1 1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 1 0 0 1 1 1 1
output =141

case =9
input =20 20
1 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 1 0 1 0 0 1 1 1 0 0 0 1
0 0 1 1 1 0 1 0 1 0 1 1 0 1 1 1 0 0 1 1
1 1 1 1 1 0 0 1 0 1 0 0 0 1 1 0 0 1 0 1
0 1 1 1 0 0 1 1 0 1 0 0 0 0 1 0 0 1 1 0
0 1 1 0 1 1 1 0 0 0 0 1 1 1 0 1 0 0 0 0
0 0 1 0 1 1 1 0 0 0 1 0 1 1 0 0 1 1 1 1
1 1 1 1 0 1 1 0 1 1 0 1 0 1 0 0 1 1 0 1
1 1 0 1 1 0 0 0 0 0 0 1 1 1 0 0 1 1 1 1
1 0 0 0 0 0 0 0 1 1 0 0 1 0 1 1 1 1 0 1
1 1 0 0 1 1 0 1 0 0 0 0 1 0 1 1 1 1 0 0
0 0 1 1 1 0 1 1 0 1 1 1 1 1 1 0 1 0 0 1
1 1 0 1 0 0 1 1 1 0 1 1 0 0 0 0 1 0 0 0
0 0 1 1 0 0 1 0 1 1 0 0 0 0 1 0 1 0 0 1
0 1 1 0 0 0 0 0 1 0 1 0 1 0 1 0 0 0 0 0
1 1 0 0 1 0 0 0 0 1 1 0 1 0 0 0 0 0 1 1
1 1 1 1 0 1 0 0 1 1 0 0 0 1 0 1 0 1 0 1
1 1 0 1 0 1 1 0 0 1 1 0 1 0 0 0 0 0 1 1
0 0 0 1 1 0 1 0 0 1 1 1 0 0 0 1 0 0 1 0
1 1 1 1 0 1 0 1 1 1 0 1 0 1 1 0 1 1 0 1
output =171

case =10
input =30 30
0 1 0 1 1 0 1 1 1 1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 1 0 0 0 0 1
0 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 0 0 1 0 0 0 0 1 1 0 0 1 1 0
1 1 1 0 1 1 0 1 0 0 1 1 1 0 1 1 0 0 0 0 0 0 1 0 1 0 0 1 0 1
0 1 1 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 0 1 1 0 0 1 0 1 0 1 0 0
0 0 1 0 1 1 0 1 1 0 1 1 1 0 0 1 0 1 1 0 0 0 1 1 0 0 1 0 1 0
0 1 1 1 1 0 0 1 1 1 1 1 1 0 0 0 1 0 0 0 1 1 0 0 0 0 1 0 1 0
1 1 0 0 1 0 0 0 0 0 0 0 1 0 1 0 0 0 1 1 0 1 0 0 1 0 0 0 1 0
1 1 1 0 0 0 0 0 0 0 1 1 1 0 0 1 0 0 1 1 0 1 1 1 0 1 1 0 0 1
0 0 0 0 1 0 1 0 0 0 1 1 1 1 0 0 1 1 1 0 0 0 1 1 0 0 1 0 0 1
1 0 1 1 1 1 0 1 1 1 1 1 1 1 0 1 0 1 1 1 0 0 1 1 0 1 0 1 0 0
0 0 1 1 0 1 1 0 1 0 1 1 0 0 0 1 1 0 1 1 0 1 1 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 1 0 1 0 1 0 0 0 1 1 0 0 1 1 1 0 1 1 1 1
0 0 0 1 1 1 0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1
1 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 0 0 1 0 0 0 0 1 1 0 0 1 1 1
1 0 0 1 1 0 0 0 0 0 1 0 0 1 0 1 1 1 0 1 1 0 0 1 0 1 1 0 1 0
0 0 1 1 1 1 0 0 0 1 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 1 0 0 0 1
0 1 0 0 1 1 0 0 0 1 0 0 0 0 1 1 0 0 1 0 0 0 1 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 1 1 1 1 1 1 0 1 1 1 0 1 0 1 1 0 1 0 1 1 1 1
1 0 1 1 1 1 1 1 0 1 0 1 0 1 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0
0 1 0 1 1 1 0 0 1 0 1 0 1 1 1 1 0 0 0 1 0 0 0 0 0 0 0 0 1 1
1 1 0 0 0 1 1 0 1 1 1 0 0 1 1 0 1 1 1 0 1 0 0 1 0 0 0 1 0 0
1 0 0 1 0 1 1 0 1 1 1 0 1 1 0 1 0 0 0 0 1 1 0 0 0 0 1 1 1 1
0 0 0 0 0 1 1 0 1 1 0 0 1 0 0 1 1 0 0 0 1 1 0 0 0 0 0 0 1 1
0 0 1 0 1 1 1 0 1 1 0 0 0 0 0 1 1 1 0 0 1 0 1 1 1 1 0 0 0 0
0 0 0 1 0 0 0 1 0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 0 0 1 1 0 1
1 1 0 0 1 0 0 1 0 0 0 1 0 0 1 1 1 1 0 0 1 0 0 1 0 0 1 1 1 0
0 1 1 1 0 0 0 0 0 0 1 1 0 0 1 1 0 0 1 1 1 1 0 0 1 1 1 0 1 0
1 0 0 0 1 1 0 1 0 1 0 1 0 1 1 1 1 0 1 1 0 1 1 0 1 1 0 1 0 1
0 1 0 1 1 0 0 0 1 0 0 1 1 0 0 1 1 1 0 1 0 0 0 1 0 0 0 0 1 0
0 1 1 1 0 1 1 0 0 0 0 1 0 1 0 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0
output =358
*/

import java.util.*;

public class MaxArea_DFS 
{
    static boolean[][] visited;
    static int[][] matrix;

    private static void solve(int[][] m) 
	{
        int biggest = 0;
        matrix = m;
        visited = new boolean[m.length][m[0].length];

        for (int i = 0; i < visited.length; i++) 
		{
            for (int j = 0; j < visited[i].length; j++) 
			{
                if (!visited[i][j]) 
				{
                    int area = dfs(i, j);
                    if (area > biggest) biggest = area;
                }
            }
        }
        System.out.println(biggest);
    }

    private static int dfs(int i, int j) 
	{
		System.out.println("i " + i + " j " + j);
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) 
			return 0;

        if (matrix[i][j] == 0) 
			return 0;
        if (visited[i][j]) 
			return 0;

        visited[i][j] = true;
        int[][] neighbors = {{i-1, j-1}, {i-1,j}, {i-1, j+1}, {i, j-1}, {i, j+1}, {i+1, j-1}, {i+1,j}, {i+1,j+1}};
        int result = 1;
        for (int n = 0; n < neighbors.length; n++) 
		{
            result += dfs(neighbors[n][0], neighbors[n][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        solve(board);
    }
}