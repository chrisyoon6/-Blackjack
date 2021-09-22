import java.util.ArrayList;

/**
 * This class represents a player playing at the Blackjack table
 */
public class Player {
    private String name;
    private int chips;
    private int currentBet;
    /**
     * list representing the current cards in the player's hand
     */
    private ArrayList<Card> hand;
    /**
     * total card value of the player hand's; 0 if player has busted ( > 21)
     */
    private int handValue;

    /**
     * Creates a new player, with their name and starting chips
     *
     * @param name          name of the player
     * @param startingChips starting chip value to play with
     */
    public Player(String name, int startingChips) {
        this.name = name;
        chips = startingChips;
        currentBet = 0;
        hand = new ArrayList<>();
        handValue = 0;
    }

    public String getName() {
        return name;
    }

    public int getChips() {
        return chips;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        return handValue;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    /**
     * Adds a new card to the player's hand
     *
     * @param card card to be added, modifying the player's total handValue accordingly
     */
    public void addCardToHand(Card card) {

        hand.add(card);
        handValue += card.getValue();

        if (handValue > 21) {
            handValue = 0;
        }
    }

    /**
     * Clears the player's hand
     */
    public void clearHand() {
        hand.clear();
        handValue = 0;
    }

    /**
     * Adds chips to the player's total chip stack
     *
     * @param amount amount of chips to be added
     */
    public void addChips(int amount) {
        if (amount > 0) {
            chips += amount;
        }
    }

    /**
     * Only to be used by the dealer (player); mimics dealer handing out winnings
     *
     * @param amount amount to be handed out, amount > 0
     */
    public void subtractChips(
        int amount) { // TODO deal w neg chips - throw IllegalArguementException
        if (amount > 0) {
            chips -= amount;
        }
    }

    /**
     * Raises the player's current bet
     *
     * @param amount amount of chips raised, decreases the player's chip value by the same amount
     */
    public void raise(int amount) {
        if (amount > 0 && chips - amount >= 0) {
            currentBet += amount;
            chips -= amount;
        }
    }

    /**
     * @return string representation of the player's current state
     */
    @Override
    public String toString() {
        String printHand = "";

        for (Card card : hand) {
            printHand += card.getSuite() + "" + card.getValue() + " ";
        }

        if (handValue == 0) {
            return name + ": " + printHand + "| busted";
        } else {
            return name + ": " + printHand + "| " + handValue + " showing | " + "bet: $" +
                currentBet
                + ", chips: $" + chips;
        }
    }
}
