import org.junit.jupiter.api.Test;

public class Day3Test {

    @Test
    public void testDay3PartOne() {
        int one = new Day3().day3(1,1);
        int two = new Day3().day3(3,1);
        int three = new Day3().day3(5,1);
        int four = new Day3().day3(7,1);
        int five = new Day3().day3(1,2);
        int answer = one * two * three * four * five;
        System.out.println("Answer one: " + one);
        System.out.println("Answer two: " + two);
        System.out.println("Answer three: " + three);
        System.out.println("Answer four: " + four);
        System.out.println("Answer five: " + five);
        System.out.println("Answer total: " + answer);
    }
}