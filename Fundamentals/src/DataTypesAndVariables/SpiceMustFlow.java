package DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int source = Integer.parseInt(scanner.nextLine()); //number of spices in the field
        //repeat every day -> yield = yield - 26;reduce the field strength by 10
        //stop: no.spices in the field < 100
        //continue: no. spices in field >= 100

        int days = 0; //No. days of mining
        int totalAmountSpices = 0; //total amount of spices harvested
        while (source >= 100) {
            int spices = source - 26; //yield
            totalAmountSpices += spices;
            days++;
            source = source - 10;
        }

        System.out.println(days);
        //eat 26 spices on the journey to the next level
        if (totalAmountSpices >= 26) {
            totalAmountSpices -= 26;
        }
        System.out.println(totalAmountSpices);
    }
}
