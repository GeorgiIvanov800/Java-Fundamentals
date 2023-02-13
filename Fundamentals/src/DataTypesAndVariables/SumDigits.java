package DataTypesAndVariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        //stop: number <= 0
        //continue: number > 0
        //repeat
        // 1. take the last digit -> % 10
        // 2. sum digits
        // 3. remove last digit -> / 10
        //print
        int sum = 0;
       /* int number = Integer.parseInt(scanner.nextLine());
        while (number > 0) {
            int lastDigit = number % 10; //last digit
            sum += lastDigit;
            number = number / 10; //remove the last digit
        }*/

        for (int number = Integer.parseInt(scanner.nextLine()); number > 0; number = number / 10) {
            int lastDigit = number % 10; //last digit
            sum += lastDigit;
        }

        System.out.println(sum);
    }
}
