import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackTableTest {
    @Test
    void loopConditionUpdatesReturnValueOfFunc() {
        String testInput = "1\nPlayer1\n100\n10\nstay";
        BlackjackTable table = new BlackjackTable(new Scanner(testInput));

    }

}