package advent2023.Day3;

public class Day3 {


    // A Java snippet to calculate the sum of the part numbers in a puzzle input
    // A part number is any number adjacent to a symbol, even diagonally
    // Periods '.' do not count as a symbol

    // The puzzle input as a 2D array of characters
    static char[][] puzzle = {
            { '4', '6', '7', '.', '.', '1', '1', '4', '.' },
            { '.', '.', '.', '*', '.', '.', '.', '.', '.' },
            { '.', '.', '3', '5', '.', '.', '6', '3', '3' },
            { '.', '.', '.', '.', '.', '#', '.', '.', '.' },
            { '6', '1', '7', '*', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '+', '.', '5', '8' },
            { '.', '.', '5', '9', '2', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '7', '5', '5', '.' },
            { '.', '.', '.', '$', '.', '*', '.', '.', '.' },
            { '.', '6', '6', '4', '.', '5', '9', '8', '.' }
    };

    // A helper method to check if a character is a symbol
    // Returns true if the character is '*', '#', '$' or '+'
    // Returns false otherwise
    public static boolean isSymbol( char c ) {
        return c == '*' || c == '#' || c == '$' || c == '+';
    }

    // A helper method to check if a character is a digit
    // Returns true if the character is between '0' and '9'
    // Returns false otherwise
    public static boolean isDigit( char c ) {
        return c >= '0' && c <= '9';
    }

    // A helper method to check if a coordinate is valid
    // Returns true if the row and column are within the puzzle bounds
    // Returns false otherwise
    public static boolean isValid( int row, int col ) {
        return row >= 0 && row < puzzle.length && col >= 0 && col < puzzle[0].length;
    }

    // A method to calculate the sum of the part numbers in the puzzle
    // Returns the sum as an integer
    public static int sumOfPartNumbers() {
        // Initialize the sum to zero
        int sum = 0;

        // Loop through the puzzle rows
        for ( int i = 0; i < puzzle.length; i++ ) {
            // Loop through the puzzle columns
            for ( int j = 0; j < puzzle[0].length; j++ ) {
                // If the current character is a digit
                if ( isDigit( puzzle[i][j] ) ) {
                    // Check the eight adjacent cells for a symbol
                    // The offsets for the adjacent cells are:
                    // (-1, -1), (-1, 0), (-1, 1)
                    // (0, -1), (0, 1)
                    // (1, -1), (1, 0), (1, 1)
                    for ( int dx = -1; dx <= 1; dx++ ) {
                        for ( int dy = -1; dy <= 1; dy++ ) {
                            // Skip the current cell
                            if ( dx == 0 && dy == 0 ) {
                                continue;
                            }
                            // Calculate the adjacent row and column
                            int x = i + dx;
                            int y = j + dy;
                            // If the adjacent cell is valid and is a symbol
                            if ( isValid( x, y ) && isSymbol( puzzle[x][y] ) ) {
                                // Add the current digit to the sum
                                sum += puzzle[i][j] - '0';
                                // Break out of the inner loops
                                dx = 2;
                                dy = 2;
                            }
                        }
                    }
                }
            }
        }

        // Return the sum
        return sum;
    }

    // A main method to test the code
    public static void main( String[] args ) {
        // Print the puzzle input
        System.out.println( "The puzzle input is:" );
        for ( int i = 0; i < puzzle.length; i++ ) {
            for ( int j = 0; j < puzzle[0].length; j++ ) {
                System.out.print( puzzle[i][j] + " " );
            }
            System.out.println();
        }
        System.out.println();

        // Print the sum of the part numbers
        System.out.println( "The sum of the part numbers is:" );
        System.out.println( sumOfPartNumbers() );
    }

}