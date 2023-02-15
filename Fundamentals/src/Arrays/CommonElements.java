package Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. input -> two String Array
        //2. for each on the second array
        // for each on the first array -> ел2 == ел1

        String [] firstArray = scanner.nextLine().split(" ");
        //"Hey hello 2 4".split(" ") -> ["Hey", "hello", "2", "4"]
        String [] secondArray = scanner.nextLine().split(" ");
        //"10 hey 4 hello".split(" ") -> ["10", "hey", "4", "hello"]


        for (String elementSecondArray : secondArray) {
            //block of code that reapets for each element
            for (String elementFirstArray : firstArray) {
                if (elementSecondArray.equals(elementFirstArray)) {
                    System.out.print(elementFirstArray + " ");
                    break;
                }
            }
        }
    }
}
