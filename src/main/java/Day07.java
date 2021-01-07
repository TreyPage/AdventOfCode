import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day07 {

    private static final String THE_GOLDEN_TICKET = "shiny gold";

    public int day07() {
        List<String> lines = Utils.readLines("src/main/resources/day07.txt");
        Map<Integer, String> tempRules = new HashMap<>();
        Map<String, String> rules = new HashMap<>();
        int start = 0;
        for (String line : lines) {
            tempRules.put(start++, line);
        }
        for (int i = 0; i < tempRules.size(); i++) {
            String[] bagRule = tempRules.get(i).split("contain");
            rules.put(bagRule[0].replace("contain", "").strip(), bagRule[1].strip());
        }
        int total = 0;
        for (String rule : rules.keySet()) {
            if (rules.get(rule).contains(THE_GOLDEN_TICKET)) {
                total++;
            } else if (checkOthers(rules, rule)) {
                total++;
            }
        }
        return total;
    }

    private boolean checkOthers(Map<String, String> rules, String rule) {
        String[] ruleToCheck = rules.get(rule).replaceAll("[0-9]", "").split(",");
        for (String check : ruleToCheck) {
            check = check.replace(".", "").strip();
            if (!check.endsWith("s")){
                check = check + "s";
            }
            if (check.equals("no other bags")) {
                return false;
            }
            try {
                if (rules.get(check).contains(THE_GOLDEN_TICKET)) {
                    return true;
                } else if (checkOthers(rules, check)) {
                    return true;
                }
            } catch (Exception e) {
                // Do Nothing
            }
        }
        return false;
    }
}
