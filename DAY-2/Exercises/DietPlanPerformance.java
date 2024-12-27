//QUESTION

// A dieter keeps track of their calorie intake using an array calories[], 
// where calories[i] represents the calories consumed on the i-th day. 
// Given an integer k, the dieter evaluates their performance for every consecutive sequence of k days 
// based on the total calorie intake during that period.

// For each subarray of length k (i.e., calories[i], calories[i+1], ..., calories[i+k-1] for all valid i), 
// the dieter calculates the total calorie intake T:

// If T < lower, the dieter performs poorly and loses 1 point.
// If T > upper, the dieter performs well and gains 1 point.
// Otherwise, the dieter performs normally and no points are gained or lost.
// Initially, the dieter has 0 points. 
// The goal is to calculate the total number of points the dieter has after evaluating all possible sequences of k days.

// Input Format:
// -------------
// Line-1: An integer n, the size of the calories array.
// Line-2: An array of integers calories[] of size n, representing daily calorie consumption.
// Line-3: Three space-separated integers: k (window size), lower (lower threshold), and upper (upper threshold).

// Output Format:
// ---------------
// A single integer representing the total number of points after evaluating all subarrays of length k.

// Constraints
// ------------
// 1. 1 ≤ k ≤ n ≤ 10^5
// 2. 0 ≤ calories[i] ≤ 20000
// 3. 0 ≤ lower ≤ upper

// Sample Input-1:
// ---------------
// 5
// 1 2 3 4 5
// 1 3 3

// Sample Output-1:
// ----------------
// 0

// Explanation:
// -------------
// Since k = 1, each day's calories are evaluated individually:
// 1 < 3: Lose 1 point.
// 2 < 3: Lose 1 point.
// 3 == 3: No change.
// 4 > 3: Gain 1 point.
// 5 > 3: Gain 1 point.
// Total points = -1 - 1 + 0 + 1 + 1 = 0.

// Sample Input-2:
// ---------------
// 2
// 3 2
// 2 0 1

// Sample Output-2:
// ----------------
// 1

// Explanation:
// -------------
// Subarray [3, 2] has a sum 3 + 2 = 5, which is greater than upper = 1.
// Total points = 1.

// Sample Input-3:
// ---------------
// 4
// 6 5 0 0
// 2 1 5

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// Subarrays:
// [6, 5]: Sum = 11 → Gain 1 point.
// [5, 0]: Sum = 5 → No change.
// [0, 0]: Sum = 0 → Lose 1 point.
// Total points = 1 + 0 - 1 = 0.


//PROGRAM
import java.util.Scanner;
public class DietPlanPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cal = new int[n];
        for (int i = 0; i < n; i++) 
        {
            cal[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int points = 0;
        if (k == n) {
            int total = 0;
            for (int c : cal)
            {
                total += c;
            }
            if (total < lower)
            {
                points = -1;
            }
            else if (total > upper) 
            {
                points = 1;
            }
            System.out.println(points);
        }
        int winsum = 0;
        for (int i = 0; i < k; i++) {
            winsum += cal[i];
        }
        if (winsum < lower) {
            points--;
        } else if (winsum > upper) {
            points++;
        }
        for (int i = k; i < n; i++) 
        {
            winsum = winsum - cal[i - k] + cal[i];
            if (winsum < lower) 
            {
                points--;
            } 
            else if (winsum > upper)
            {
                points++;
            }
        }
        System.out.println(points);
    }
}
