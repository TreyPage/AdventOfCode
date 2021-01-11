import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    @Test
    public void testDay07Sample() {
        long answer = new Day07().day07();
        assertEquals(126, answer);
    }

    @Test
    public void testDay07() {
        long answer = new Day07().day07();
        System.out.println(answer);
    }
}