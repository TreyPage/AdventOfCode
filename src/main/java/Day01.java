import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Day01 {

    //Main method code to run this:
    //System.out.println(new Day1().day1());
    public int day1() throws FileNotFoundException {

        String path = "src/main/resources/day01.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        int[] numbers = new int[200];

        while (true) {
            try {
                for (int i = 0; i < 200; i++) {
                    numbers[i] = Integer.parseInt(scanner.nextLine());
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        for (int a : numbers) {
            for (int b : numbers) {
                for (int c : numbers) {
                    int sum = a + b + c;
                    if (sum == 2020) {
                        return a * b * c;
                    }
                }
            }
        }
        return 0;
    }
}