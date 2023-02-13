package DataTypesAndVariables;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Integer
        //•	Floating point -> contains the symbol '.'
        //•	Characters -> length 1 and code < 48 || code > 57
        //•	Boolean -> true or false
        //•	Strings -> if we have a sequence of only characters (code < 45 || code > 57)
        String input = scanner.nextLine();
        //stop: input == "END"
        while (!input.equals("END")) {
            String type = "";
            //type checking
            //boolean
            if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                type = "boolean";
            }
            //character
            else if(input.length() == 1) {
                char symbol = input.charAt(0);
                //symbol
                if(symbol < 47 || symbol > 58) {
                    type = "character";
                }
                //integer
                else {
                    type = "integer";
                }
            } else { //string, floating point, integer
                boolean isString  = false;
                boolean isFloat = false;
                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    //checking if it is a character
                    if(currentSymbol < 45 || currentSymbol > 57) {
                        isString = true;
                    }

                    if(currentSymbol == 46) {
                        isFloat = true;
                    }
                }
                if(isString) {
                    type = "string";
                } else {
                    //number
                    if(isFloat) {
                        type = "floating point";
                    } else {
                        type = "integer";
                    }

                }
            }
            System.out.printf("%s is %s type%n", input, type);
            input = scanner.nextLine();
        }
    }
}
