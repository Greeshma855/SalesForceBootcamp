//Solve the question using dynamic programming

// You are playing a game. There are N boxes placed in a row (0-indexed), 
// every box has some points. 

// You need to play the game with the following rules:
//     - Initially your score is  '0' points.
// 	- Suppose the box has P points in it.
// 	  if p>0 you will gain P points, if p<0 you will loose P points.
// 	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
   	
// You are given the points in the N boxes as points[]. 
// Your target is to maximize your score, and return the highest score possible. 
 
// Input Format:
// -------------
// Line-1: An integer N.
// Line-2: N space separated integers, points[].
  
// Output Format:
// --------------
// An integer, print the highest score.
    
// Sample Input-1:
// ---------------
// 9
// -3 1 -2 4 -2 2 3 -5 4
 
// Sample Output-1:
// ----------------
// 7
   
// Explanation:
// ------------
// By selecting consecutive boxes are [4,-2,2,3] has the highest score is 7
   
 
// Sample Input-2:
// ---------------
// 2
// 1 -2
  
// Sample Output-2:
// ----------------
// 1

// Explanation:
// ------------
// By picking the box is [1] has the highest score is 1.


import java.util.Scanner;
public class MaxSubArray
{
    public static int max(int[] points)
    {
        int curMax = points[0];
        int maxTillNow = points[0];
        
        for(int i=1;i<points.length;i++)
        {
            curMax = Math.max(points[i],curMax+points[i]);
            maxTillNow = Math.max(curMax, maxTillNow);
        }
        return maxTillNow;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int [] points = new int[n];
        for(int i=0;i<n;i++)
        {
            points[i] = Integer.parseInt(s[i]);
        }
        int score = max(points);
        System.out.println(score);
    }
}