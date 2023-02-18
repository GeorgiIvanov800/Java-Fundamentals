package Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input data: 2 characters
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printCharactersInRange(symbol1, symbol2);
    }

    public static void printCharactersInRange(char symbol1, char symbol2) {
        //checking which is the smaller symbol -> start from the smaller one
        if (symbol1 < symbol2) {
            //start at symbol1 -> the symbols in (symbol1, symbol2)
            for (char symbol = (char)(symbol1 + 1); symbol < symbol2 ; symbol++) {
                System.out.print(symbol + " ");
            }
        } else { //symbol1 >= symbol2
            //start at symbol2 -> the symbols in (symbol2, symbol 1)
            for (char symbol = (char)(symbol2 + 1); symbol < symbol1 ; symbol++) {
                System.out.print(symbol + " ");
            }
        }
    }
}
