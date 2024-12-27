// QUESTION

// Given a string S, your task is to find the longest repeated substring in the string. 
// A repeated substring is a contiguous sequence of characters that appears at least twice in the string. 
// If there are multiple such substrings of the same maximum length, return the lexicographically smallest one. 
// If no repeated substring exists, return "None".

// Constraints:
// * 1 ≤ length of S ≤ 10^3
// * S contains only lowercase English letters.

// Input Format:
// --------------
// A single string S.

// Output Format:
// ---------------
// A single string, the longest repeated substring or "None".


// Sample Input 1:
// ---------------
// banana

// Sample Output 1:
// ---------------
// ana

// Explanation:
// The substrings "ana" and "na" are repeated, but "ana" is the longest.

// Sample Input 2:
// --------------
// abcdef

// Sample Output 2:
// ----------------
// None

// Explanation:
// No repeated substrings exist.

// Sample Input 3:
// ---------------
// aabaaab

// Sample Output 3:
// ----------------
// aab

// Explanation:
// The substring "aab" appears twice and is the longest repeated substring.



//PROGRAM
import java.util.HashSet;
import java.util.Scanner;

public class LongestRepeatedSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();  
        int n = S.length();
        String r = "None";
        for (int i = n - 1; i > 0; i--) {
            HashSet<String> seen = new HashSet<>();
            for (int j = 0; j <= n - i; j++) {
                String sub = S.substring(j, j + i);
                if (seen.contains(sub)) {
                    if (r.equals("None") || sub.compareTo(r) < 0) 
                    {
                        r = sub;
                    }
                } 
                else 
                {
                    seen.add(sub);
                }
            }
            if (!r.equals("None"))
            {
                break;
            }
        }
    
        System.out.println(r);
    }
}
