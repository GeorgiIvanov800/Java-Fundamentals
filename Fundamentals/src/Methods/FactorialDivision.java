package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.input data -> 2 integers
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        //2.long fact of the first number (number1)
        long fact1 = calculateFactorial(number1); //the factorial of the first number

        //3.long fact of the second number (number2)
        long fact2 = calculateFactorial(number2); //the factorial of the second number

        //4.fact. of the first number / fact. of the second number = fractional number
        double divisionResult = fact1 * 1.0 / fact2;
        System.out.printf("%.2f", divisionResult);
    }

    //method that finds the factorial (long) of a given number and returns it
    public static long calculateFactorial(int number) {
        //5! = 1 * 2 * 3 * 4 * 5 = 120
        //10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 3628800

        long fact = 1; //the value of the factorial
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
