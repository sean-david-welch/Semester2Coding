public class Fibonacci {
    // memoization
    private static long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 50;
        fibonacciCache = new long[n + 1];
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        // to prevent stack overflow, we need a base case
        if (n <= 1) return n;

        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long fibNumber = (fibonacci(n - 1) + fibonacci(n - 2));
        fibonacciCache[n] = fibNumber;
        return fibNumber;
    }
}
