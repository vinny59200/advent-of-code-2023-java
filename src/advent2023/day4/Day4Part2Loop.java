package advent2023.day4;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static advent2023.day4.Day4Part2BreakHelper.*;
import static advent2023.day4.Day4Part2BreakHelper2.*;

public class Day4Part2Loop {


    public static int cumulativeLineScores( Map<Integer, Integer> lineDataItems ) {

        Map<Integer, Integer> map = lineDataItems;

        // Print the original map
        System.out.println( "The original map is: " + map );


        List<String> accumulation = initializeAccumulation( map );
        // Print the original accumulation
        System.out.println( "The original accumulation is: " + accumulation );


        for ( int j = 1; j <= bigInputVV2.length(); j++ ) {
            int key = j;
            if ( map.get( key ) == null ) {
                break;
            }
            int value = map.get( key );


            //add cumulative items
            List<String> subAccumulation = new ArrayList<>();
            for ( int i = key + 1; i <= key + value; i++ ) {
                int _line = i;
                int _value = map.get( _line );
                final String pair = _line + "," + _value;
                subAccumulation.add( pair );
            }
            int _line = j;
            int _value = map.get( _line );
            final String pair = _line + "," + _value;
            int count = Collections.frequency( accumulation, pair );

            System.out.println( pair + " " + count );
            for ( int k = 0; k < count; k++ ) {
                accumulation.addAll(subAccumulation );
            }
            System.out.println( "accumulation for line:" + key + " = " + accumulation );
        }


        return accumulation.size();
    }

    private static List<String> initializeAccumulation( final Map<Integer, Integer> map ) {
        List<String> accumulation = new ArrayList<>();
        // Get the entry set of the map
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        // Iterate over the entry set using a for-each loop
        for ( Map.Entry<Integer, Integer> entry : entrySet ) {
            int _key = entry.getKey();
            int _value = entry.getValue();
            accumulation.add( _key + "," + _value );
        }
        return accumulation;
    }


    public static void main( String[] args ) {

        // Call the method and print the result
        Map<Integer, Integer> lineScores = getLineScoresVV2( bigInputVV );

        System.out.println( "The global score is: " + cumulativeLineScores( lineScores ) );

    }
}
