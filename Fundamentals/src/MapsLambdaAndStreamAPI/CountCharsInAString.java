package MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().replaceAll("\\s+", "");
        //"text text text".replaceAll -> "texttexttext"
        //symbol -> no. the meetings
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        //HashMap -> the order of the elements does not matter
        //LinkedHashMap -> elements are sorted in order of addition
        //TreeMap -> elements are sorted by their key

        for (char symbol : text.toCharArray()) {
            //"John" -> ['J', 'o', 'h', 'n']
            /*if (symbol == ' ') {
                continue; //skips everything down and moves on to the next symbol
            }*/
            //1.have never met such a symbol
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            }
            //2.met such a symbol
            else {
                int currentCount = symbolsCount.get(symbol);
                symbolsCount.put(symbol, currentCount + 1);
            }
        }

        //print
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
