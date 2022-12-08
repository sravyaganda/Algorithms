package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args)
    {
        List<String> list=readAOC2();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).charAt(2));
        }
    }
    public static List<String> readAOC1() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc1.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                 input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };
    public static List<String> readAOC2() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc2.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };
    public static List<String> readAOC3() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc3.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };
    public static List<String> readAOC4() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc4.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };

    public static List<String> readAOC5() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc5.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };


    public static String readAOC6() {
        StringBuilder input = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc6.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.append(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input.toString();
    };

    public static List<String> readAOC7() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc7.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };


    public static List<String> readAOC201509() {
        List<String> input = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/sravyaganda/AdventOfCode/aoc201509.txt"));
            int index = 0;
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine().toString()) ;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    };
}
