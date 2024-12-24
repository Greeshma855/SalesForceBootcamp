// Write a java program to determine if a number n is a happy number.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will remain), or it loops endlessly in a cycle that does not include 1.
// If the number eventually reaches 1, then the number is happy. Otherwise, it is not.

// Constraints:
// -------------
// 1 ≤ n ≤ 2³¹ - 1
// You must handle the case of both happy and non-happy numbers.

// Input Format:
// -------------
// Line-1: A single integer n, representing the number to be checked.

// Output Format:
// ---------------
// Line-1: Return true if the input number is a happy number, otherwise return false.


// Sample Input-1: 
// ----------------
// 19

// Sample Output-1: 
// -----------------
// true

// Explanation:
// Process to determine if 19 is a happy number:
// 1² + 9² = 1 + 81 = 82
// 8² + 2² = 64 + 4 = 68
// 6² + 8² = 36 + 64 = 100
// 1² + 0² + 0² = 1 (since the number reached 1, 19 is a happy number)


// Sample Input-2: 
// ----------------
// 2

// Sample Output-2: 
// -----------------
// false

// Explanation:
// The process does not reach 1 and starts repeating numbers. Hence, 2 is not a happy number.


import java.util.Scanner;
public class HappyNumber {
    static int getSquareSum(int n) {
        int sum=0;
        while(n>0) 
        {
            int d=n%10;    
            sum+=d*d;  
            n=n/10;
        }
        return sum;
    }
    static boolean isHappy(int n) {
        if (n==1) 
            return true;
        else if (n==4) 
            return false;
        return isHappy(getSquareSum(n));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappy(n));
        sc.close();
    }
}