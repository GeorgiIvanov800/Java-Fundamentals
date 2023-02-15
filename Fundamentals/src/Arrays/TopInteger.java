package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //"1 4 3 2".split(" ") -> ["1", "4", "3", "2"].map -> [1, 4, 3, 2]

        //for each element of the array -> checking if it is a top
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNumber = numbers[index];
            //always the element of the last index is our top
            if(index == numbers.length - 1) {
                System.out.print(currentNumber + " ");
                break;
            }
            //обхождам всички индекси след моя
            //следващото число -> index + 1
            boolean isTop = false; //
            for (int i = index + 1; i <= numbers.length - 1; i++) { //обходя всички числа след моето
                int nextNumber = numbers[i];
                if (currentNumber > nextNumber) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            //проверка дали моето число е топ
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
