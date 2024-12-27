

import java.util.*;

class MaxOfSizeK {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        
        int[] sales = new int[n];
        
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }
        
        int max;

        for (int i = 0; i <= n - k; i++) {
            max = sales[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, sales[i + j]);
            }
            System.out.print(max + " ");

            sc.close();
        }
    }
}
