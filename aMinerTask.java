//Until you receive the "stop" command, you will be given a sequence of strings,each on a new line.
//Every odd line on the console represents a resource
//(e.g., Gold, Silver, Copper, etc.) and every even - quantity.
//Your task is to collect the resources and print them on a new line.
//Print the resources and their quantities in format: "{resource} –> {quantity}".
//The quantities inputs will be in the range [1 … 2 000 000 000].

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        int rowsCounter = 1;
        String lastKey = input;

        while (!input.equals("stop")) {
            if (rowsCounter % 2 != 0) {
                if (!map.containsKey(input)) {
                    map.put(input, 0);
                }
            } else {
                int value = Integer.parseInt(input);
                for (Map.Entry<String, Integer> set : map.entrySet()) {
                    if (set.getKey().equals(lastKey)) {
                        map.put(lastKey, set.getValue() + value);
                    }
                }
            }
            lastKey = input;
            input = scanner.nextLine();
            rowsCounter++;
        }
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println(set.getKey() + " -> "+ set.getValue());
        }
    }
}
