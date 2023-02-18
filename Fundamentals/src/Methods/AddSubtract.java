package Methods;

import java.util.Scanner;

public class AddSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input -> 3 Integers
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        //(number1 + number2) - number3

        int sumOfNumbers = sum(number1, number2);
        int subtractOfNumbers = subtract(sumOfNumbers, number3);

        System.out.println(subtractOfNumbers);
    }

    //method that takes 2 integers -> we get the sum
    public static int sum (int n1, int n2) {
        return n1 + n2;
    }

    //method that takes 2 integers -> we get difference
    public static int subtract (int n1, int n2) {
        return n1 - n2;

    }
}
