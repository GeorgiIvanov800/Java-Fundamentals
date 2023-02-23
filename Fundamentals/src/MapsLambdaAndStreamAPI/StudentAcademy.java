package MapsLambdaAndStreamAPI;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //key: student name -> value: list of grades
        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int student = 1; student <= countStudents; student++) {
            String name = scanner.nextLine(); //student name
            double grade = Double.parseDouble(scanner.nextLine()); //student grade
            //1. not in the map
            if (!studentsGrade.containsKey(name)) {
                studentsGrade.put(name, new ArrayList<>());
            }
            //2. in the map
            studentsGrade.get(name).add(grade);
        }

        //records: student name (key) -> av. value
        Map<String, Double> averageGradeStudents = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()) {
            //entry: (key)student name -> (value)list of grades
            String studentName = entry.getKey(); //student name
            List<Double> listGrades = entry.getValue(); //list of grades for each student
            double averageGrade = getAverageGrade(listGrades); //average grade
            //student -> grade list -> avg. arithmetic evaluation
            if (averageGrade >= 4.50) {
                averageGradeStudents.put(studentName, averageGrade);
            }
        }

        //print: averageGradeStudents
        //entry: name(key) -> av.grade (value)
        averageGradeStudents.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }

    private static double getAverageGrade(List<Double> listGrades) {
        //{4.60, 3.50, 5.90, 4.70, 2.50}
        //wed. arithmetic = sum of marks / number of marks
        double sumGrades = 0; //sum of grades
        for (double grade : listGrades) {
            sumGrades += grade;
        }
        return sumGrades / listGrades.size();
    }
}
