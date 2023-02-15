package Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine()); //number of rows of numbers
        String [] firstArray =  new String[rows];
        String [] secondArray =  new String[rows];

        //even row(2, 4, 6, 8, ...)
        // -> first number goes into the second; the second number goes into the first

        //odd order (1, 2, 5, 7, ...)
        // -> first number goes in the first; the second number goes into the second

        for (int row = 1; row <= rows; row++) {
            //"1 5".split(" ") -> ["1", "5"]
            String [] numbers = scanner.nextLine().split(" "); // ["1", "5"]
            String firstNumber = numbers[0];
            String secondNumber = numbers[1];

            if (row % 2 == 0) {
                //firstNumber goes in secondArray
                secondArray[row - 1] = firstNumber;
                //secondNumber goes in firstArray
                firstArray[row - 1] = secondNumber;
            } else {
                //firstNumber goes in firstArray
                firstArray[row - 1] = firstNumber;
                //secondNumber goes in secondArray
                secondArray[row - 1] = secondNumber;
            }
        }

        //print an array of texts:
        //1. for по index
        //2. foreach on elements
        //3. String.join !!!! only for text array only !!!!

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
    }
}
