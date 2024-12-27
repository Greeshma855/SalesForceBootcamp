//PROGRAM

import java.util.*;

class KthSmallestSubarraySum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] a = new int[n];
        
        int totalSums = (n * (n + 1)) / 2;
        
        int[] minSumArray = new int[totalSums];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += a[j];
                minSumArray[index++] = currentSum; 
            }
        }
        
        Arrays.sort(minSumArray);
        
        System.out.println(minSumArray[k - 1]);
        
        sc.close();
    }
} 