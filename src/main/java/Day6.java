import java.util.*;

public class Day6 {

    public int day6() {
        int total = 0;
        List<String> lines = Utils.readLines("src/main/resources/day6.txt");
        int users = 0;
        String group = "";
        for (String line : lines) {
            if (!line.equals("")) {
                users++;
                group = group + line;
            } else {
                total = checkChar(total, users, group);
                group = "";
                users = 0;
            }
        }
        total = checkChar(total, users, group);
        return total;
    }

    private int checkChar(int total, int users, String group) {
        int compareLength = group.length();
        for (Character letter : group.toCharArray()) {
            group = group.replaceAll(letter.toString(), "");
            if (compareLength - group.length() == users) {
                total++;
            }
            compareLength = group.length();
            if (group.equals("")) {
                break;
            }
        }
        return total;
    }
}
