public class PrimeChecker {

    // Method to check if a number is prime (brute force)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 0 and 1 are not prime
        for (int i = 2; i < n; i++) {  // check all numbers from 2 to n-1
            if (n % i == 0) {  // divisible
                return false;
            }
        }
        return true;  // no divisors found
    }

    public static void main(String[] args) {
        int[] testNumbers = {101, 4999, 10007, 49999, 99991};  // numbers to test

        for (int n : testNumbers) {
            long startTime = System.nanoTime();
            boolean prime = isPrime(n);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;  // in nanoseconds

            System.out.println("Number: " + n +
                    " | Prime: " + prime +
                    " | Time taken: " + duration + " ns");
        }
    }
}

