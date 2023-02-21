package MapsLambdaAndStreamAPI;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //courseName -> list of student names
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while(!input.equals("end")) {
            //"{course name} : {person name}" -> split (" : ") -> ["{courseName}", "{personName}"]
            String courseName = input.split(" : ")[0];
            String personName = input.split(" : ")[1];
            //check for such a course
            //if there is not such a course
            if(!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }

            //if the course is new -> returns an empty list
            //if the course is old -> returns the current list of people
            courses.get(courseName).add(personName);

            input = scanner.nextLine();
        }
        //courseName -> List<String>
        courses.entrySet()
                .forEach(entry -> {
                    //key: name of the course
                    //value: list of people
                    //name of course -> no. the people
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
                    //ascending order
                });
    }
}
