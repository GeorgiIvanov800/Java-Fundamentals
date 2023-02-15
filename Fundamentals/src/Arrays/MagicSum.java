package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //"1 7 6 2 19 23".split(" ") -> ["1", "7", "6", "2", "19", "23"]
        //-> [1, 7, 6, 2, 19, 23]
        int magicSum = Integer.parseInt(scanner.nextLine());

        //1.get number from array -> loop through all numbers after it
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNumber = numbers[index];
            //loop through all the numbers after it
            for (int inIndex = index + 1; inIndex <= numbers.length - 1; inIndex++) {
                int inNumber = numbers[inIndex];

                if (currentNumber + inNumber == magicSum) {
                    System.out.println(currentNumber + " " + inNumber);
                }
            }
        }
    }
}
