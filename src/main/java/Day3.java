import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Day3 {

    public int day3(int right, int down) {
        List<String> lines = Utils.readLines("src/main/resources/day3.txt");
        int answer = 0;
        int j = 0;
        for (int i = down; i < lines.size(); i += down) {
            String line = lines.get(i);
            j += right;
            if (j >= line.length()) {
                j -= line.length();
            }
            if (lines.get(i).charAt(j) == '#') {
                answer++;
            }
        }
        return answer;
    }
}
