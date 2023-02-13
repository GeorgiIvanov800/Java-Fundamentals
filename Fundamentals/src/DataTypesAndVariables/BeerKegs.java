package DataTypesAndVariables;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input: number of kegs
        //for each keg repeat:
        //1.read the data - OK
        //2.volume = π * r^2 * h - OK
        //3.checking if it's the biggest keg

        //seek the maximum value
        //1.variable which will store this value
        double maxVolume = Double.MIN_VALUE; //smallest possible value
        String maxModelKeg = ""; //model of the keg with the largest volume

        int countKegs = Integer.parseInt(scanner.nextLine());
        for (int keg = 1; keg <= countKegs; keg++) {
            String kegModel = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;
            //2.checking if the volume given is greater than the maximum
            if (volume > maxVolume) {
                maxVolume = volume;
                maxModelKeg = kegModel;
            }
        }

        System.out.println(maxModelKeg); //the model of the largest keg
    }
}
