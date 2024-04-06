
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        minimum();
        average();
        primenumbers();
        factorial();
        fibonacci();
        power();
        permutations();
        digits();
        bincoef();
        gcd();
    }
    //task1

    public static int findMinimum(int n, int[] arr) {
        // Check if the array is empty
        if (n == 0) {
            return Integer.MIN_VALUE; // Or you can throw an exception or handle it differently
        }

        // Initialize min_value with the first element of the array
        int min_value = arr[0];

        // Iterate through the array to find the minimum value
        for (int i = 1; i < n; i++) {
            if (arr[i] < min_value) {
                min_value = arr[i];
            }
        }

        return min_value;
    }


    public static void minimum() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMinimum(n, arr));

    }

    //task2
    public static double findAverage(int n, int[] arr) {
        // Check if the array is empty
        if (n == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        return (double) sum / n;
    }

    public static void average() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findAverage(n, arr));
    }

    // task3

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void primenumbers() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
    }

    //task4

    public static int findFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * findFactorial(n - 1);
        }
    }

    public static void factorial() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findFactorial(n));
    }

    //task5

    public static int findFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return findFibonacci(n - 1) + findFibonacci(n - 2);
        }
    }

    public static void fibonacci() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findFibonacci(n));
    }

    //task6

    public static int findPower(int a, int n) {
        return (int) Math.pow(a, n);
    }

    public static void power() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(findPower(a, n));
    }

    // task7

    public static void findPermutations(char[] chars, int ind) {
        if (ind == chars.length - 1) {
            System.out.println(String.valueOf(chars));
        } else {
            for (int i = ind; i < chars.length; i++) {
                swap(chars, ind, i);
                findPermutations(chars, ind + 1);
                swap(chars,ind, i);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j]= temp;
    }

    public static void permutations() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        findPermutations(input.toCharArray(), 0);
    }

    // task8

    public static boolean isDigits(String n) {
        for (char a: n.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }
        }
        return true;
    }

    public static void digits() {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        System.out.println(isDigits(n) ? "Yes" : "No");
    }

    //task9

    public static int findBinCoef(int n, int k) {
        int[][] dp = new int[n + 1][k + 1]; //dynamic programming

        // Base case: C(n, 0) = C(n, n) = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][Math.min(i, k)] = 1;
        }

        // Calculate C(n, k)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    public static void bincoef() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(findBinCoef(n, k));
    }

    //task 10

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    public static void gcd() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(findGCD(a, b));
    }
}