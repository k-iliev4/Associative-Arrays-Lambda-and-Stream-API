import java.util.*;

//Write a program that keeps a map with synonyms.
// The key to the map will be the word.
// The value will be a list of all the synonyms of that word.
// You will be given a number n. On the next 2 * n lines, you will be given the word and a synonym each on a separate line like this:
//• {word}
//• {synonym}
//If you get the same word for the second time, just add the new synonym to the list.
//Print the words in the following format:
//{word} - {synonym1, synonym2… synonymN}
public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> newMap = new LinkedHashMap<>();

        int followingWordsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < followingWordsCount; i++) {
            String key = scanner.nextLine();
            String value = scanner.nextLine();

            if (newMap.containsKey(key)){
                String currValue = newMap.get(key);
                newMap.put(key, value + ", " + currValue);
            }else{
                newMap.put(key, value);
            }
        }
        for (Map.Entry<String, String> set: newMap.entrySet()) {
            System.out.println(set.getKey() + " - " + set.getValue());
        }
    }
}
