package advent2023.day5;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public static String input= """
            seeds: 79 14 55 13
                        
            seed-to-soil map:
            50 98 2
            52 50 48
                        
            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15
                        
            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4
                        
            water-to-light map:
            88 18 7
            18 25 70
                        
            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13
                        
            temperature-to-humidity map:
            0 69 1
            1 0 69
                        
            humidity-to-location map:
            60 56 37
            56 93 4
            """;

    public static List<List<String>> readInput( String input ){
        //Split the input by empty lines
        String[] parts = input.split("\\n\\s*\\n");

        //Create a list of lists to store the extracted data
        List<List<String>> data = new ArrayList<>();

        //Loop through each part of the input
        for (String part : parts) {
            //Split the part by line breaks
            String[] lines = part.split("\\n");
            //Create a sublist to store the current part
            List<String> sublist = new ArrayList<>();
            //Loop through each line of the part
            for (String line : lines) {
                //Trim the line to remove any leading or trailing spaces
                line = line.trim();
                //If the line contains a colon, it is the title of the part
                if (line.contains(":")) {
                    //Remove the colon and store the title as the first element of the sublist
                    sublist.add(line.replace(":", ""));
                } else {
                    //Otherwise, the line is a row of numbers
                    //Split the line by spaces and store each number as an element of the sublist
                    String[] numbers = line.split("\\s+");
                    for (String number : numbers) {
                        sublist.add(number);
                    }
                }
            }
            //Add the sublist to the data list
            data.add(sublist);
        }

        //Print the data list
        System.out.println(data);
        return data;
    }

    public static int calculate(List<List<String>> inputList){
        //Seeds
        String[] strSeeds =inputList.get( 0 ).get(0).split(" ");
        List<Integer> seeds= new ArrayList<>();
        for(int i=1;i<strSeeds.length;i++){
            seeds.add(Integer.valueOf( strSeeds[i] ));
        }
        System.out.println("seeds:"+seeds);

        int maxSeed= seeds.stream().max( (i,j)->i.compareTo( j )).get();

        //initialize seed-to-soil
        List<String> strSeed2Soils =inputList.get( 1 );
        List<List<Integer>> seed2Soils= new ArrayList<>();
        strSeed2Soils.remove( 0 );
        for(int i=0;i<strSeed2Soils.size();i=i+3){
            List<Integer> _mapping=new ArrayList<>();
            _mapping.add(Integer.valueOf(strSeed2Soils.get(i)));
            _mapping.add(Integer.valueOf(strSeed2Soils.get(i+1)));
            _mapping.add(Integer.valueOf(strSeed2Soils.get(i+2)));
            seed2Soils.add(_mapping);
        }
        System.out.println("seed2Soils:"+seed2Soils);

        //map seed to soils
        List<Integer> soilsIndexes= new ArrayList<>();
        List<Integer> tmp=seed2Soils.get( 1 );
        for(int i=0; i<tmp.get(1);i++){
            soilsIndexes.add(i);
        }
//        for(int i=1;i<maxSeed; i++;){
//            soilsIndexes.add(tmp.get())
//        }




        return 0;
    }

    public static void main( String[] args ) {
        calculate(readInput( input));
    }
}
