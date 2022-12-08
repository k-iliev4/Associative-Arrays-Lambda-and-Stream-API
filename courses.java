//Write a program which keeps the information about courses. Each course has a name and registered students.
//You will receive the course name and student name until you receive the command "end".
// Check if such a course already exists and if not - add the course. Register the user into the course. When you do receive the command "end", print the courses with their names and total registered users. For each contest, print the registered users.
//Input
//    • Until you receive "end", the input come in the format: "{courseName} : {studentName}".
//    • The product data is always delimited by " : ".
//Output
//    • Print information about each course, following the format:
//"{courseName}: {registeredStudents}"
//    • Print information about each student, following the format:
//"-- {studentName}"

import java.util.*;

public class courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> course = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" : ");

        while(!input[0].equals("end")){

            if (course.containsKey(input[0])) {
                for (Map.Entry<String, String> set : course.entrySet()) {
                    if (input[0].equals(set.getKey())) {
                        course.replace(set.getKey(), set.getValue(), set.getValue() + "," + input[1]);
                    }
                }
            }else{
                course.put(input[0],input[1]);

            }

            input = scanner.nextLine().split(" : ");
        }
        for (Map.Entry<String, String> set : course.entrySet()) {
            String[] array = set.getValue().split(",");
            System.out.println(set.getKey()+ ": " + array.length);
            for (int i = 0; i < array.length; i++) {
                System.out.println("-- " + array[i]);
            }
        }
    }
}
