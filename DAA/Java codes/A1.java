public class A1 {
    public static long calculateFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacciRecursive(n - 1) + calculateFibonacciRecursive(n - 2);
    }

    public static long calculateFibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        int n = 20;  // Change this to the desired value of 'n'

        long startTime = System.nanoTime();
        calculateFibonacciRecursive(n);
        long endTime = System.nanoTime();
        long elapsedRecursive = endTime - startTime;
        System.out.println("Recursive Fibonacci(" + n + ") took " + elapsedRecursive + " nanoseconds.");

        startTime = System.nanoTime();
        calculateFibonacciIterative(n);
        endTime = System.nanoTime();
        long elapsedIterative = endTime - startTime;
        System.out.println("Iterative Fibonacci(" + n + ") took " + elapsedIterative + " nanoseconds.");
    }
}
