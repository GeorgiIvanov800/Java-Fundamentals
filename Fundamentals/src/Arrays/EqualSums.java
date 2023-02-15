package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine() //"1 2 3 3"
                        .split(" "))  //["1", "2", "3", "3"]
                .mapToInt(el -> Integer.parseInt(el))  //[1, 2, 3, 3]
                .toArray();

        boolean isFound = false;
        //true -> have such an element
        //false -> have not such an element
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentElement = numbers[index];
            int leftSum = 0; //the sum of the elements on the left
            int rightSum = 0; //the sum of the elements on the right

            //left sum -> all elements from index 0 to mine (not included)
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }

            //right sum -> all items my index + 1 to last
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }
            //checking if the sums are equal
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("no");
        }
    }
}
