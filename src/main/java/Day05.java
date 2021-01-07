import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day05 {

    public int day5() {
        List<String> lines = Utils.readLines("src/main/resources/day05.txt");
        List<Integer> answer = new ArrayList<>();
        for (String line : lines) {
            int maxRowNum = 127;
            int minRowNum = 0;
            int row = 0;
            for (int i = 0; i < 7; i++) {
                char letter = line.charAt(i);
                switch (letter) {
                    case 'F': {
                        maxRowNum = minRowNum + (maxRowNum - minRowNum) / 2;
                        row = maxRowNum;
                        break;
                    }
                    case 'B': {
                        minRowNum = minRowNum + (maxRowNum - minRowNum) / 2 + 1;
                        row = minRowNum;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Invalid character: " + letter);
                }
            }
            int minColNum = 0;
            int maxColNum = 7;
            int col = 0;

            for (int i = 7; i < line.length(); i++) {
                char letter = line.charAt(i);
                switch (letter) {
                    case 'L': {
                        maxColNum = minColNum + (maxColNum - minColNum) / 2;
                        col = maxColNum;
                        break;
                    }
                    case 'R': {
                        minColNum = minColNum + (maxColNum - minColNum) / 2 + 1;
                        col = minColNum;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Invalid character: " + letter);
                }
            }
            int tempAnswer = row * 8 + col;
            answer.add(tempAnswer);
        }
        int result = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (!answer.contains(i)) {
                result = i;
            }
        }
        return result;
    }
}
