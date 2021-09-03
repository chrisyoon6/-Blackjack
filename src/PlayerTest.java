import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void tryRaisingThreeTimesWithOneNeg() {
        Deck deck = new Deck();
        Player player1 = new Player("Player1", 50);

        // initial
        player1.addCardToHand(deck.deal()); // D 1
        player1.addCardToHand(deck.deal()); // D 2

        player1.raise(10);
        player1.raise(-10);
        player1.raise(10);

        assertEquals('D', player1.getHand().get(0).getSuite());
        assertEquals(1, player1.getHand().get(0).getValue());
        assertEquals('D', player1.getHand().get(1).getSuite());
        assertEquals(2, player1.getHand().get(1).getValue());

        assertEquals(30, player1.getChips());
        assertEquals(20, player1.getCurrentBet());

        player1.raise(40);

        assertEquals(20, player1.getCurrentBet());

    }

}