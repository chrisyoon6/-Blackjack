import java.util.Random;

/**
 * This class represents the Standard 52-suite deck of French-suited playing cards
 */
public class Deck {
    private Card[] cards;

    /**
     * Creates a new deck of cards
     */
    public Deck() {
        cards = new Card[52];
        make();
    }

    public Card[] getCards() {
        return cards;
    }

    /**
     * Initializes a new array of cards, meant to be called with the constructor
     */
    public void make() {
        final char[] suites = {'D', 'H', 'S', 'C'};
        final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int cardsInd = 0;
        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards[cardsInd] = new Card(suites[i], values[j]);
                cardsInd++;
            }
        }
    }

    /**
     * Shuffles the deck in random order
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randIndex = rand.nextInt(52);
            // swap
            Card temp = cards[i];
            cards[i] = cards[randIndex];
            cards[randIndex] = temp;
        }
    }

    /**
     * Deals out a card on the bottom of the deck, moving that card to the top
     *
     * @return a Card to be handed out
     */
    public Card deal() {
        Card dealtCard = cards[0];

        // card to top, rest moves down
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[cards.length - 1] = dealtCard;

        return dealtCard;
    }
}
