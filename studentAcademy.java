//Write a program that keeps the information about students and their grades.
//On the first line, you will receive number n. After that, you will receive n pair of rows. First, you will receive the student's name, after that, you will receive his grade. Check if the student already exists and if not - add him. Keep track of all grades for each student.
//When you finish reading data, keep students with an average grade higher or equal to 4.50.
//Print the students and their average grade in the format:
//"{name} –> {averageGrade}"
//Format the average grade to the 2nd decimal place.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class studentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int feed = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsAndGrades = new HashMap<>();
        for (int i = 0; i < feed; i++) {
            String student = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsAndGrades.containsKey(student)) {
                studentsAndGrades.put(student, grade);
            }else{
                for (Map.Entry<String,Double> set:studentsAndGrades.entrySet()) {
                    if (set.getKey().equals(student)){
                        studentsAndGrades.replace(student,(set.getValue() + grade) / 2);
                    }
                }
            }
        }
        for (Map.Entry<String,Double> set:studentsAndGrades.entrySet()) {
            if (set.getValue() >= 4.5){
                System.out.printf("%s -> %.2f\n",set.getKey(), set.getValue());
            }
        }
    }
    
}
