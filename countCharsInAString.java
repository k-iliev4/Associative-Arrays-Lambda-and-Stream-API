import java.util.*;
//Write a program that counts all characters in a string except space (' ').
//Print all occurrences in the following format:
//"{char} -> {occurrences}"

public class countCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        int sameLetterCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ' || map.containsKey(input.charAt(i))){
                break;
            }
            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(i) == input.charAt(j)){
                    sameLetterCounter++;
                }
            }
            map.put(input.charAt(i),sameLetterCounter);
            sameLetterCounter = 0;
            System.out.println(input.charAt(i) + " -> " +map.get(input.charAt(i)));

        }
    }
}
