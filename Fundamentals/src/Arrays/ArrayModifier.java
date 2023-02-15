package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //repeat action -> enter commands
        //stop: input data == "end"
        // continue: input data!= "end"
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            //valid command to execute
            //command = "swap 2 3"
            //command = "multiply 4 6"
            //command = "decrease"
            if (command.contains("swap")) {
                //"swap {index1} {index2}" -> "swap 2 3".split(" ") -> ["swap", "2", "3"]
                int index1 = Integer.parseInt(command.split(" ")[1]); //the index of the first item to swap
                int index2 = Integer.parseInt(command.split(" ")[2]); //the index of the second item to swap
                //1.take the element at the first index
                int element1 = numbers[index1];
                //2.take the element at the second index
                int element2 = numbers[index2];
                //3.swap
                numbers[index1] = element2;
                numbers[index2] = element1;
            } else if (command.contains("multiply")) {
                //"multiply {index1} {index2}"
                int index1 = Integer.parseInt(command.split(" ")[1]); //индексът на първия елемент за умножение
                int index2 = Integer.parseInt(command.split(" ")[2]); //индексът на втория елемент за умножение
                //1.take the element at the first index
                int element1 = numbers[index1];
                //2.take the element at the second index
                int element2 = numbers[index2];

                int product = element1 * element2;
                numbers[index1] = product;
            } else if (command.equals("decrease")) {
                //decrease
                //loop through all the elements -> - 1
                //positions / indices -> 0 to last (array length - 1)
                for (int index = 0; index <= numbers.length - 1; index++) {
                    //the current element -> numbers[index]
                    //numbers[index]--;
                    //numbers[index] -= 1;
                    numbers[index] = numbers[index] - 1;
                }
            }
            command = scanner.nextLine();
        }

        //print: ", "

        for (int index = 0; index <= numbers.length - 1 ; index++) {
            int currentNumber = numbers[index];
            if (index != numbers.length - 1) {
                //not on the last number
                System.out.print(currentNumber + ", ");
            } else { //index == numbers.length - 1
                //last number
                System.out.print(currentNumber);
            }
        }
    }
}
