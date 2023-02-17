package List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.list of numbers -> input data
        List<Integer> numbers = Arrays.stream(scanner.nextLine() //"4 5 3"
                        .split("\\s+")) //["4", "5", "3"]
                .map(Integer::parseInt) //[4, 5, 3]
                .collect(Collectors.toList()); // {4, 5, 3}

        int sumRemoved = 0; //sum of removed items

        //repeat: enter index (integer)
        //stop: list becomes empty -> size <= 0
        //we continue: the list is full -> size > 0
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            //1.index in list -> >= 0 and <= last
            if (index >= 0 && index <= numbers.size() - 1) {
                //1.get the element at the given index
                int removedElement = numbers.get(index); //item removed
                //2.remove element from this index -> sum element
                sumRemoved += removedElement;
                numbers.remove(index);
                //3.modify the list to the removed number
                //{3, 4, 8, 9, 12}
                modifyList(numbers, removedElement);
            }
            //2. index < 0
            else if (index < 0) {
                //1.take the first element of the list
                int firstElement = numbers.get(0); //the removed item
                //2.remove the first element from the list -> sum the element
                sumRemoved += firstElement;
                numbers.remove(0);
                //3.we take the last element of the list
                int lastElement = numbers.get(numbers.size() - 1);
                //4.we put on index -> the last element
                numbers.add(0, lastElement);
                //5.modify the list relative to the removed element
                //{3, 4, 8, 9, 12}
                modifyList(numbers, firstElement);
            }
            //3. index > the last one
            else if (index > numbers.size() - 1) {
                //1.we take the last element
                int lastElement = numbers.get(numbers.size() - 1); //the removed item
                //2.we remove the last element -> sum the removed element
                sumRemoved += lastElement;
                numbers.remove(numbers.size() - 1);
                //3.take the first element
                int firstElement = numbers.get(0);
                //4.put the first element last
                numbers.add(firstElement); //we add firstElement to the end of the list
                //5.modify list -> removed element (lastElement)
                modifyList(numbers, lastElement);

            }

        }

        System.out.println(sumRemoved);

    }

    private static void modifyList(List<Integer> numbers, int removedElement) {
        for (int indexInList = 0; indexInList <= numbers.size() - 1; indexInList++) {
            int currentNumber = numbers.get(indexInList);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else {
                currentNumber -= removedElement;
            }
            numbers.set(indexInList, currentNumber);
        }
    }
}
