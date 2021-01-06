import java.util.*;

public class Day6 {

    public int day6() {
        int total = 0;
        List<String> lines = Utils.readLines("src/main/resources/day6.txt");
        Set<Character> answers = new HashSet<>();
        for (String line : lines) {
            if (!line.equals("")) {
                for (int i = 0; i < line.length(); i++) {
                    answers.add(line.charAt(i));
                }
            } else {
                total = total + answers.size();
                answers = new HashSet<>();
            }
        }
        return total + answers.size();
    }
}
