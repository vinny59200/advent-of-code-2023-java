package advent2023.day4;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class MiniTest {
    public static void main( String[] args ) {
        // Import the concurrent package

        // Create a ConcurrentHashMap of integers
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        // Put some elements in the map
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        // Print the original map
        System.out.println("The original map is: " + map);

        // Get the entry set of the map
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        // Iterate over the entry set using a for-each loop
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            // Get the key and value of the current entry
            int key = entry.getKey();
            int value = entry.getValue();
            // Check if the key is 2
            if (key == 2) {
                // If yes, add a new element to the map with key 4 and value 40
                map.put(4, 40);
            }
            System.out.println("k:"+key+", v:"+value);
        }

        // Print the updated map
        System.out.println("The updated map is: " + map);

    }
}
