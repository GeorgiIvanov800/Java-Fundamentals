package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        //1. length -> Password must be between 6 and 10 characters
        boolean isPasswordLengthValid = isValidLength(password);
        //true -> valid length
        //false -> invalid length
        if (!isPasswordLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        //2.content
        boolean isPasswordContentValid = isValidContent(password);
        if (!isPasswordContentValid) {
            System.out.println("Password must consist only of letters and digits");
        }

        //3.number of digits
        boolean isPasswordCountDigitsValid = isValidCountDigits(password);
        //true -> no. numbers >= 2
        //false -> no. numbers < 2
        if (!isPasswordCountDigitsValid) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isPasswordLengthValid && isPasswordContentValid && isPasswordCountDigitsValid) {
            System.out.println("Password is valid");
        }

    }

    //length validation method
    //true -> if the length is valid
    //false -> if the length is not valid
    private static boolean isValidLength (String password) {
        //length is valid: 6 - 10
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        //length is not valid: Password must be between 6 and 10 characters
        else {
            return false;
        }
        //return password.length() >= 6 && password.length() <= 10;
    }

    //content validation method
    //true -> if the content is valid
    //false -> if the content is not valid
    private static boolean isValidContent (String password) {
        //valid content: letters or numbers
        //invalid content: anything other than a letter or number
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        //iterate all symbols
        return true;
    }

    //method that validates a number of digits
    //true -> no. digits >= 2
    //false -> no. digits < 2
    private static boolean isValidCountDigits (String password) {
        int countDigits = 0; //number of digits
        //JavaIsTheBest123
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }

        /*if (countDigits >= 2) {
            return true;
        } else {
            return false;
        }*/

        return countDigits >= 2;
    }
}
