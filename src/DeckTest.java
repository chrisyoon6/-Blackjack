import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    void dealTest() {
        Deck deck = new Deck();
        Card expectedDealt = new Card('D', 1);
        Card expectedOnTop = expectedDealt;
        Card dealt = deck.deal();
        // suite
        assertEquals(expectedDealt.getSuite(), dealt.getSuite());
        assertEquals(expectedOnTop.getSuite(), deck.getCards()[51].getSuite());
        // value
        assertEquals(expectedDealt.getValue(), dealt.getValue());
        assertEquals(expectedOnTop.getValue(), deck.getCards()[51].getValue());
    }

    @Test
    void deckDealtThreeTimes() {
        Deck deck = new Deck();
        Card expected1 = new Card('D', 1);
        Card expected2 = new Card('D', 2);
        Card expected3 = new Card('D', 3);
        Card dealt1, dealt2, dealt3;
        dealt1 = deck.deal();

        assertEquals(expected1.getSuite(), dealt1.getSuite());
        assertEquals(expected1.getValue(), dealt1.getValue());
        assertEquals(expected1.getSuite(), deck.getCards()[51].getSuite());
        assertEquals(expected1.getValue(), deck.getCards()[51].getValue());

        dealt2 = deck.deal();

        assertEquals(expected2.getSuite(), dealt2.getSuite());
        assertEquals(expected2.getValue(), dealt2.getValue());
        assertEquals(expected2.getSuite(), deck.getCards()[51].getSuite());
        assertEquals(expected2.getValue(), deck.getCards()[51].getValue());

        dealt3 = deck.deal();

        assertEquals(expected3.getSuite(), dealt3.getSuite());
        assertEquals(expected3.getValue(), dealt3.getValue());
        assertEquals(expected3.getSuite(), deck.getCards()[51].getSuite());
        assertEquals(expected3.getValue(), deck.getCards()[51].getValue());

    }
}