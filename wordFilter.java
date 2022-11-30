import java.util.Arrays;
import java.util.Scanner;
//Read an array of strings, and take only words whose length is even. Print each word on a new line.
public class wordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);
    }
}

