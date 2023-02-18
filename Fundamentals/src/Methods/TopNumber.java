package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            //checking if it is a top number
            //1.the sum of the digits is divisible by 8 - ok
            //2.contains at least one even digit - ok
            if (isSumOfDigitsDivisibleBy8(number) && isContainsOddDigit(number)) {
                System.out.println(number);
            }
        }

    }
    //method that checks if the sum of the digits is divisible by 8
    //true -> the sum is divisible by 8
    //false -> the sum is not divisible by 8
    public static boolean isSumOfDigitsDivisibleBy8 (int number) {
        //1.sum of the digits
        int sumDigits = 0;
        while (number > 0) {
            //last digit
            int lastDigit = number % 10;
            //sum last digit
            sumDigits += lastDigit;
            //remove last digit
            number = number / 10;
        }
        //2.checksum for division by 8
        return sumDigits % 8 == 0;
        /*if (sumDigits % 8 == 0) {
            return true;
        } else {
            return false;
        }*/
    }

    //method that checks if we have at least one even digit in the number
    //true -> have at least one odd number
    //false -> don't have odd digit
    public static boolean isContainsOddDigit (int number) {
        //loop through each digit in a number -> check if it's odd
        while (number > 0) {
            //take last digit
            int lastDigit = number % 10;
            //check if it is odd
            if (lastDigit % 2 != 0) {
                return true;
            } else {
                //the number is even -> remove
                number = number / 10;
            }
        }

        //took all the numbers and none were odd
        return false;
    }
}
