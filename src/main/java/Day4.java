import java.util.List;

public class Day4 {

    public int day3(int right, int down) {
        List<String> lines = Utils.readLines("src/input/day4.txt");
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
