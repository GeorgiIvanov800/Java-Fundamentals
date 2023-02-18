package Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        //method that prints the middle character
        //odd text length -> 1 middle character
        //even text length -> 2 middle characters
        printMiddleCharacters(text);
    }

    private static void printMiddleCharacters (String text) {
        //odd length -> 1 middle character
        //"aString" -> ['a', 'S', 't', 'r', 'i', 'n', 'g']
        if (text.length() % 2 == 1) {
            int indexOfMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        }
        //even length -> 2 middle characters
        //"someText" -> ['s', 'o', 'm', 'e', 'T', 'e', 'x', 't']-> eT
        else {
            int indexFirstMiddleCharacter = text.length() / 2 - 1;
            int indexSecondMiddleCharacter = text.length() / 2;

            System.out.println("" + text.charAt(indexFirstMiddleCharacter) + text.charAt(indexSecondMiddleCharacter));
        }
    }
}
