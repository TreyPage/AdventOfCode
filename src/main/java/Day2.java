import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Day2 {

    //Main method code to run this:
    //System.out.println(new Day2().day2());
    public int day2() throws FileNotFoundException {
        int valid = 0;

        String path = "src/main/resources/day2.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        while (true) {
            try {
                String string = scanner.nextLine();
                valid = checkValidity(string) ? valid + 1 : valid;
            } catch (NoSuchElementException e) {
                //End of file reached
                return valid;
            }
        }
    }

    private boolean checkValidity(String string) {
        int colon = string.indexOf(":");
        int dash = string.indexOf("-");
        String rule = string.substring(0, colon);
        String password = string.substring(colon + 2);
        int positionOne = Integer.parseInt(rule.substring(0, dash));
        int positionTwo = Integer.parseInt(rule.substring(dash + 1, colon - 2));
        String ruleLetter = String.valueOf(rule.toCharArray()[colon - 1]);
        String firstLetter = password.substring(positionOne - 1, positionOne);
        String secondLetter = password.substring(positionTwo - 1, positionTwo);
        if (firstLetter.equals(ruleLetter) && secondLetter.equals(ruleLetter)) {
            return false;
        } else return firstLetter.equals(ruleLetter) || secondLetter.equals(ruleLetter);
    }
}