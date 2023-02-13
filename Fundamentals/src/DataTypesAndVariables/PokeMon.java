package DataTypesAndVariables;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input -> power, distance, factor
        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int factor = Integer.parseInt(scanner.nextLine());
        //repeat:
        //1. power -= distance -> no. poke++
        //2. fatigue check
        //stop: power < distance
        //continue: power >= distance
        int firstPower = power; //the initially introduced force
        int countPoke = 0;
        while (power >= distance) {
            //goes to target -> wastes energy
            power -= distance;
            //reach -> poke
            countPoke++;

            //checking fatigue
            if (power == firstPower / 2) {
                if (factor != 0) {
                    //allowed arithmetic operation division
                    power = power / factor;
                }
            }
        }

        System.out.println(power); //current strength
        System.out.println(countPoke); //number of successful pokes
    }
}
