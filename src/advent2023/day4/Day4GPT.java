package advent2023.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Day4GPT {


    // Import the concurrent package

    // Define a method to calculate the total number of scratchcards
    public static int calculateTotalScratchcards( String input ) {
        // Initialize the total number of scratchcards to zero
        int total = 0;
        // Split the input by newline characters to get the lines
        String[] lines = input.split( "\n" );
        // Create a ConcurrentHashMap to store the original and copied scratchcards
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        // Loop through each line
        for ( int i = 0; i < lines.length; i++ ) {
            // Split the line by colon to get the title and the data
            String[] bigSplit = lines[i].split( ":" );
            // Split the data by pipe to get the winning numbers and the data numbers
            String[] smallSplit = bigSplit[1].split( "\\|" );
            // Convert the winning numbers and the data numbers to lists of integers
            List<Integer> winningNumbers = Arrays.stream( smallSplit[0].trim()
                                                                       .split( " " ) )
                    .filter(str->!str.equals( "" ))
                                                 .map( Integer::parseInt )
                                                 .collect( Collectors.toList() );
            List<Integer> dataNumbers = Arrays.stream( smallSplit[1].trim()
                                                                    .split( " " ) )
                                              .filter(str->!str.equals( "" ))
                                              .map( Integer::parseInt )
                                              .collect( Collectors.toList() );
            // Initialize a counter to zero
            int counter = 0;
            // Loop through the data numbers and check if they contain the winning numbers
            for ( int dataNumber : dataNumbers ) {
                if ( winningNumbers.contains( dataNumber ) ) {
                    // If there is a match, increment the counter by one
                    counter++;
                }
            }
            // Put the card number and the counter in the map
            map.put( i + 1, counter );
        }
        // Loop through the map until no more scratchcards are won
        while ( true ) {
            // Create a flag to indicate if any scratchcard is won
            boolean flag = false;
            // Create a temporary map to store the new scratchcards
            ConcurrentHashMap<Integer, Integer> temp = new ConcurrentHashMap<>();
            // Loop through each entry in the map
            for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
                // Get the card number and the number of matches
                int card = entry.getKey();
                int matches = entry.getValue();
                // Check if the number of matches is positive
                if ( matches > 0 ) {
                    // If yes, set the flag to true
                    flag = true;
                    // Loop through the next cards equal to the number of matches
                    for ( int i = 1; i <= matches; i++ ) {
                        // Check if the next card is within the range of the input
                        if ( card + i <= lines.length ) {
                            // If yes, get the data of the next card
                            String[] bigSplit = lines[card + i - 1].split( ":" );
                            String[] smallSplit = bigSplit[1].split( "\\|" );
                            List<Integer> winningNumbers = Arrays.stream( smallSplit[0].trim()
                                                                                       .split( " " ) )
                                                                 .filter(str->!str.equals( "" ))
                                                                 .map( Integer::parseInt )
                                                                 .collect( Collectors.toList() );
                            List<Integer> dataNumbers = Arrays.stream( smallSplit[1].trim()
                                                                                    .split( " " ) )
                                                              .filter(str->!str.equals( "" ))
                                                              .map( Integer::parseInt )
                                                              .collect( Collectors.toList() );
                            // Initialize a counter to zero
                            int counter = 0;
                            // Loop through the data numbers and check if they contain the winning numbers
                            for ( int dataNumber : dataNumbers ) {
                                if ( winningNumbers.contains( dataNumber ) ) {
                                    // If there is a match, increment the counter by one
                                    counter++;
                                }
                            }
                            // Put the next card number and the counter in the temporary map
                            temp.put( card + i, counter );
                        }
                    }
                }
            }
            // Add the temporary map to the main map
            map.putAll( temp );
            // Break the loop if no scratchcard is won
            if ( !flag ) {
                break;
            }
        }
        // Sum the values of the map to get the total number of scratchcards
        total = map.values()
                   .stream()
                   .reduce( 0, Integer::sum );
        // Return the total number of scratchcards
        return total;
    }

    // Define the input
    static String input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
            """;

    public static void main( String[] args ) {
        // Call the method and print the result
        int total = calculateTotalScratchcards( input );
        System.out.println( "The total number of scratchcards is: " + total );
///
    }

}