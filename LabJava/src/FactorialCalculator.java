import java.util.Scanner;

public class FactorialCalculator {

    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        long fact = factorial(num);
        if (fact != -1) {
            System.out.println("Factorial of " + num + " is " + fact);
        }

        scanner.close();
    }
}
