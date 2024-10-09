import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 30);
        ages.put("Charlie", 30);
        ages.put("David", 25);
        ages.put("Eve", 25);
        ages.put("Frank", 35);
        System.out.println("Original ages map"+ages);

        int maxOccurrences = 2;

        // Create a Map to store the occurrences of each value
        HashMap<Integer, Integer> valueOccurrences = new HashMap<>();

        // Iterator to traverse the entries
        Iterator<Map.Entry<String, Integer>> iterator = ages.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int value = entry.getValue();

            // Increment occurrences for the current value
            valueOccurrences.put(value, valueOccurrences.getOrDefault(value, 0) + 1);

            // Check if occurrences exceed the limit
            if (valueOccurrences.get(value) > maxOccurrences) {
                // Remove the current entry from the HashMap
                iterator.remove();

                // Decrement occurrences for the current value
                valueOccurrences.put(value, valueOccurrences.get(value) - 1);
            }
        }

        // Print the updated map
        System.out.println("Updated ages map: " + ages);
    }
}

