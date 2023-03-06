package RegularExpressions;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namesParticipants = scanner.nextLine(); //"George, Peter, Bill, Tom"
        List<String> names = Arrays.stream(namesParticipants.split(", ")).collect(Collectors.toList());
        //"George, Peter, Bill, Tom".split(", ")
        //масив: ["George", "Peter", "Bill", "Tom"].toList()
        //лист: {"George", "Peter", "Bill", "Tom"}

        //racer -> distance
        Map<String, Integer> racerDistances = new LinkedHashMap<>();
        names.forEach(name -> racerDistances.put(name, 0));

        //REGEX
        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters); //pattern for letters

        String regexDigits = "[0-9]";
        Pattern patterDigits = Pattern.compile(regexDigits); //pattern for Digits

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            //input = "G4e@55or%6g6!68e!!@"
            //1. racer name -> all letters
            StringBuilder racerName = new StringBuilder();
            Matcher matcherLetters = patternLetters.matcher(input);
            //matcher = "G", "e", "or", "g", "e"
            while (matcherLetters.find()) {
                racerName.append(matcherLetters.group());
            }

            //2. distance -> digits sum
            int distance = 0;
            Matcher matcherDigits = patterDigits.matcher(input);
            //matcher = "4", "5", "5", "6", "6", "6", "8"
            while (matcherDigits.find()) {
                distance += Integer.parseInt(matcherDigits.group());
            }

            if (names.contains(racerName.toString())) {
                //name of the player in the list
                int currentDistance = racerDistances.get(racerName.toString()); //текущата дистанция избягана от играча
                racerDistances.put(racerName.toString(), currentDistance + distance);
            }

            input = scanner.nextLine();
        }


        //sort distance descending order
        //comparingByValue -> ascending order
        List<String> top3Names = racerDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3) //let only the first three places
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()); // {"George", "Peter", "Tom"}

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));
    }
}
