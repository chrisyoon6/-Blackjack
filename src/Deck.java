import java.util.Random;

public class Deck {
    private Card[] cards;

    public Deck() {
        cards = new Card[52];
        make();
    }

    public Card[] getCards() { return cards; }
    public void make() {
        final char[] suites = { 'D', 'H', 'S', 'C'};
        final int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
        int cardsInd = 0;
        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards[cardsInd] = new Card (suites[i], values[j]);
                cardsInd++;
            }
        }
    }

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

    public Card deal() {
        Card dealtCard = cards[0];

        // card to top, rest moves down
        for (int i = 0; i < cards.length-1; i++) {
            cards[i] = cards[i+1];
        }
        cards[cards.length - 1] = dealtCard;

        return dealtCard;
    }
}
