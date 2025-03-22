import java.util.Scanner;

public class TransformDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter single decimal digit range 0-9: ");

        if (scanner.hasNextInt()) {
            int digit = scanner.nextInt();
            if (digit < 0 || digit > 9) {
                System.out.println("Incorrect input. Must be single digit between 0 and 9");
                return;
            }

            int result = computeTotal(digit);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid input. Please enter a single digit between 0 and 9");
        }

        scanner.close();
    }

    private static int computeTotal(int digit) {
        String digitToString = Integer.toString(digit);
        String contactStringDigit = "";
        int sum = 0;

        for (int i = 1; i <= 4; i++) {
            contactStringDigit = contactStringDigit + digitToString;
            sum = sum + Integer.parseInt(contactStringDigit);
        }

        return sum;
    }
}
