package advent2023.day4;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static advent2023.day4.Day4Part2BreakHelper.*;

public class Day4Part2Break {


    public static int cumulativeLineScores( ConcurrentHashMap<Map<Integer, Integer>, Integer> lineDataItems ) {

        ConcurrentHashMap<Map<Integer, Integer>, Integer> map = lineDataItems;

        // Print the original map
        System.out.println( "The original map is: " + map );

        // Get the entry set of the map
        Set<Map.Entry<Map<Integer, Integer>, Integer>> entrySet = map.entrySet();

        // Iterate over the entry set using a for-each loop
        for ( Map.Entry<Map<Integer, Integer>, Integer> entry : entrySet ) {
            Map<Integer, Integer> keyII = entry.getKey();
            int valueI = entry.getValue();

            Map.Entry<Integer, Integer> firstKeyII = keyII.entrySet()
                                                      .stream()
                                                      .findFirst()
                                                      .get();
            int subkeyI = firstKeyII.getKey();

            //add cumulative items
            for ( int i = subkeyI + 1; i <= subkeyI + valueI; i++ ) {

                Map.Entry<Map<Integer, Integer>, Integer> lineDataItem = findFirstMatchingItemVV( lineDataItems, i );
                System.out.println("loop item:"+lineDataItem.toString());
                if ( lineDataItem != null ) {
                    map.put( lineDataItem.getKey(), lineDataItem.getValue() + 1 );
                }


            }

        }
                System.out.println(lineDataItems);
        System.out.println( map );
        return map.values()
                  .stream()
                  .reduce( 0, Integer::sum );
    }



    public static void main( String[] args ) {

        // Call the method and print the result
        ConcurrentHashMap<Map<Integer, Integer>, Integer> lineScores = getLineScoresVV( inputVV );

        System.out.println( "The global score is: " + cumulativeLineScores( lineScores ) );

    }
}
