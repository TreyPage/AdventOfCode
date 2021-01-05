import java.util.*;

public class Day4 {

    //pid
    //byr
    //iyr
    //eyr
    //hgt
    //hcl
    //ecl
    public int day4() {
        final Set<String> requiredFields = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        List<String> lines = Utils.readLines("src/main/resources/day4.txt");
        List<String> passports = new ArrayList<>();
        String partialPassport = "";
        for (String line : lines) {
            if (!line.equals("")) {
                partialPassport = partialPassport + " " + line;
            } else {
                passports.add(partialPassport);
                partialPassport = "";
            }
        }
        passports.add(partialPassport);
        int count = 0;
        for (String passportRaw : passports) {
            Set<String> fields = new HashSet<>();
            String passportStripped = passportRaw.strip();
            String[] pieces = passportStripped.split(" ");
            Map<String, String> combos = new HashMap<>();
            for (String piece : pieces) {
                fields.add(piece.split(":")[0]);
                combos.put(piece.split(":")[0], piece.split(":")[1]);
            }
            if (fields.containsAll(requiredFields)) {
                if (checkBirth(combos) && checkIssue(combos) && checkExp(combos) && checkHeight(combos) &&
                        checkHair(combos) && checkEye(combos) && checkPass(combos)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkPass(Map<String, String> combos) {
        String pid = combos.get("pid");
        return pid.length() == 9;
    }

    private boolean checkHair(Map<String, String> combos) {
        String hcl = combos.get("hcl");
        return hcl.length() == 7 && hcl.charAt(0) == '#';
    }

    private boolean checkEye(Map<String, String> combos) {
        Set<String> eyeColors = Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        String ecl = combos.get("ecl");
        return eyeColors.contains(ecl);
    }

    private boolean checkHeight(Map<String, String> combos) {
        String hgt = combos.get("hgt");
        String blah = hgt.substring(hgt.length() - 2);
        try {
            int heightNumber = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            if (blah.equals("cm")) {
                return heightNumber >= 150 && heightNumber <= 193;
            } else if (blah.equals("in")) {
                return heightNumber >= 59 && heightNumber <= 76;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkExp(Map<String, String> combos) {
        int year = Integer.parseInt(combos.get("eyr"));
        return year >= 2020 && year <= 2030;
    }

    private boolean checkIssue(Map<String, String> combos) {
        int year = Integer.parseInt(combos.get("iyr"));
        return year >= 2010 && year <= 2020;
    }

    private boolean checkBirth(Map<String, String> combos) {
        int byr = Integer.parseInt(combos.get("byr"));
        return byr >= 1920 && byr <= 2002;
    }
}
