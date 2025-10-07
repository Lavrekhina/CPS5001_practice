package week_2;

import java.util.Arrays;

public class FibonacciDP {

    // Memoization array
    private static long[] memo;

    public static long fibDP(int n) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n]; // return cached result
        memo[n] = fibDP(n - 1) + fibDP(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 50; // larger n
        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        long startTime = System.nanoTime();
        long result = fibDP(n);
        long endTime = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken (ns): " + (endTime - startTime));
    }
}
