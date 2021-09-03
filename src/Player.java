import java.util.ArrayList;

public class Player {
    private String name;
    private int chips;
    private int currentBet;
    private ArrayList<Card> hand;
    private int handValue;

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

    public void addCardToHand(Card card) {
        hand.add(card);
        handValue += card.getValue();
        if (handValue > 21) {
            handValue = 0;
        }
    }

    public void clearHand() {
        hand.clear();
        handValue = 0;
    }

    public void addChips(int amount) {
        if (amount > 0) {
            chips += amount;
        }
    }

    // only for dealer
    public void subtractChips(int amount) { // TODO deal w neg chips
        if (amount > 0) {
            chips -= amount;
        }
    }

    public void raise(int amount) {
        if (amount > 0 && chips - amount >= 0) {
            currentBet += amount;
            chips -= amount;
        }
    }

    public String toString() {
        String printHand = "";

        for (Card card : hand) {
            printHand += card.getSuite() + "" + card.getValue() + " ";
        }

        if (handValue == 0) {
            return name + ": " + printHand + "| busted";
        } else {
            return name + ": " + printHand + "| " + handValue + " showing | " + "bet: $" + currentBet
                    + ", chips: $" + chips;
        }
    }
}
