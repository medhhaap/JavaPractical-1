import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        char choice;

        do {
            System.out.print("Enter a string: ");
            input = scanner.nextLine();

            if (isPalindrome(input)) {
                System.out.println(input + " is a palindrome.");
            } else {
                System.out.println(input + " is not a palindrome.");
            }

            System.out.print("Do you want to check another string? (y/n): ");
            choice = scanner.nextLine().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}
