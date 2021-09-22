/**
 * This class represents a French-suited playing card
 */

public class Card {
    private char suite;
    private int value;

    /**
     * Initializes the card
     *
     * @param suite the suite of the card
     * @param value the numeric value of the card, between 0 to 10
     */
    public Card(char suite, int value) {
        this.suite = suite;
        this.value = value;
    }

    /* getters and setters */
    public int getValue() {
        return value;
    }

    public char getSuite() {
        return suite;
    }
}
