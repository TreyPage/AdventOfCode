import java.util.*;

public class Day07 {

    private List<Bag> allBags = new ArrayList<>();

    public long day07() {
        List<String> lines = Utils.readLines("src/main/resources/day07.txt");
        for (String line : lines) {
            String[] lineData = line.split(" bags contain ");

            if (lineData[1].equals("no other bags.")) continue;

            Bag bag = getBag(lineData[0]);

            String[] bagNames = lineData[1].replaceAll("( bag(s?)|\\.)", "")
                    .split(", ");
            for (String bagName : bagNames) {

                int bagAmount = Integer.parseInt(bagName.substring(0, 1));
                Bag bag1 = getBag(bagName.substring(2));

                for (int i = 0; i < bagAmount; i++) {
                    bag.addNewBag(bag1);
                }
            }
        }
        return bagsInside(getBag("shiny gold"), 0);
    }

    private long bagsInside(Bag bag, long amount) {
        amount += bag.getCanContain().size();
        for (Bag bag1 : bag.getCanContain()) amount = bagsInside(bag1, amount);
        return amount;
    }

    private Bag getBag(String name) {
        Optional<Bag> optionalBag = allBags.stream().filter(bag ->
                bag.getName().equals(name)).findFirst();
        if (optionalBag.isEmpty()) return new Bag(name);
        return optionalBag.get();
    }

    public class Bag {
        String name;
        List<Bag> canContain = new ArrayList<>();

        public Bag(String name) {
            this.name = name;
            allBags.add(this);
        }

        public String getName() {
            return name;
        }

        public List<Bag> getCanContain() {
            return canContain;
        }

        public void addNewBag(Bag bag) {
            this.canContain.add(bag);
        }
    }
}
