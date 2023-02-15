package Arrays;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countWagons = Integer.parseInt(scanner.nextLine());

        int [] wagons = new int[countWagons];
        for (int wagon = 0; wagon < countWagons; wagon++) {
            int countPeople = Integer.parseInt(scanner.nextLine());
            wagons[wagon] = countPeople;
        }
        //[13, 24, 8]
        //2. print
        //2.1. for -> indexes
        /*for (int index = 0; index <= wagons.length - 1; index++) {
            int currentElement = wagons[index];
            System.out.print(currentElement + " ");
        }
        System.out.println();*/

        //2.2. foreach -> element
        int sum = 0;
        for (int number : wagons) {

            System.out.print(number + " ");
            sum += number;
        }
        System.out.println();
        System.out.println(sum);
        //System.out.println(Arrays.stream(wagons).sum());
    }
}
