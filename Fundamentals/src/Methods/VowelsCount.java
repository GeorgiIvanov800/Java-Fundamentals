package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни -> текст
        String text = scanner.nextLine();
        printVowelsCount(text.toLowerCase());

        //"GeorgiIvaNoV".toLowerCase() -> "georgiivanov"
        //"GeorGiIvANov".toUpperCase() -> "GEORGIIVANOV"
    }
    //method that prints the number of vowels
    public static void printVowelsCount (String text) {
        //!!! text is all lowercase
        //text = "Georgi" -> ['G', 'e', 'o', 'r', ...] -> 6
        int count = 0; //number of vowels
        for (char symbol : text.toCharArray()) {
            //checking if it is a vowel -> a, e, i, o, u
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                //vowel
                count++;
            }
        }
        System.out.println(count);
    }
}
