package week_2;

public class FibonacciDemo {

    // Naive recursion
    public static long fibRecursive(int n) {
        if (n <= 1) return n; // base case
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        int n = 20; // small n to test
        long startTime = System.nanoTime();
        long result = fibRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken (ns): " + (endTime - startTime));
    }
}
