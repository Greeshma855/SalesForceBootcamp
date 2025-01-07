//Solve the question using dynamic programming

// A township has constructed N villas in a row, 
// and they plan to paint these villas with three colors: snow-white, sky-blue, and light-green. 
// However, the township imposes the following rule:
// Adjacent villas must not be painted with the same color.

// You are given the cost of painting each villa with these three colors as a 2D list cost[N][3]:
// cost[i][0]: Cost of painting the i-th villa with snow-white.
// cost[i][1]: Cost of painting the i-th villa with sky-blue.
// cost[i][2]: Cost of painting the i-th villa with light-green.

// Your task is to determine the minimum total cost to paint all the villas 
// while adhering to the given rule.

// Input Format:
// -------------
// Line-1: An integer N, number of villas.
// Next N lines: 3 space separated integers, cost to paint the villas.

// Output Format:
// --------------
// Print an integer, minimum cost to paint all the villas.


// Sample Input-1:
// ---------------
// 3
// 17 2 17
// 16 4 5
// 14 3 19

// Sample Output-1:
// ----------------
// 10

// Explanation: 
// ------------
// Paint the 1st villa with sky-blue (cost: 2).
// Paint the 2nd villa with light-green (cost: 5).
// Paint the 3rd villa with sky-blue (cost: 3).
// Total cost = 2+5+3=10.

// Sample Input-2:
// ---------------
// 4
// 10 5 7
// 8 6 3
// 7 3 9
// 4 6 10

// Sample Output-2:
// ----------------
// 18

// Explanation:
// -------------
// Paint the 1st villa with sky-blue (cost: 5).
// Paint the 2nd villa with light-green (cost: 3).
// Paint the 3rd villa with sky-blue (cost: 3).
// Paint the 4th villa with snow-white (cost: 7).
// Total cost = 5+3+3+7=18.


import java.util.Scanner;

public class MinCostToPaint {
    public static int minCost(int[][] cost) {
        int n = cost.length;
        int[][] dp = new int[n][3];
        
        dp[0][0] = cost[0][0];  
        dp[0][1] = cost[0][1];  
        dp[0][2] = cost[0][2];  
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            cost[i][0] = sc.nextInt(); 
            cost[i][1] = sc.nextInt();  
            cost[i][2] = sc.nextInt();  
        }
        System.out.println(minCost(cost));
    }
}