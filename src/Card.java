public class Card {
    private char suite;
    private int value;

    public Card(char suite, int value) {
        this.suite = suite;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public char getSuite() {
        return suite;
    }
}
