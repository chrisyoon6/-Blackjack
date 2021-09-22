import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a table where Blackjack is being played
 */
public class BlackjackTable {
    private Scanner scan;
    Deck deck;
    ArrayList<Player> players;

    /**
     * Creates a new Blackjack table
     * @param scanner scanner for the user input
     */
    public BlackjackTable(Scanner scanner) {
        this.scan = scanner;
        this.deck = new Deck();
        this.players = new ArrayList<>();
    }

    /**
     * Program loop; starts the Blackjack game // TODO: make changes to output format, divide code segments
     */
    public void start() {
        deck.shuffle();
        players.add(new Player("DEALER", 1000)); // TODO add variable for dealer or new class

        // prompt
        System.out.println("How many are playing?");
        int numPlayers = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Player " + i);
            System.out.print("name: ");
            String name = scan.nextLine();
            System.out.println("chips to buy in: ");
            int startingChips = Integer.parseInt(scan.nextLine());
            players.add(new Player(name, startingChips));
        }

        // game loop - each round

        while (true) {
            // prompt bets
            System.out.println("Bets - \"exit\" to abort game.");
            System.out.println("---------");
            for (int i = 1; i <= numPlayers; i++) {
                System.out.print(players.get(i).getName() + "'s starting bet: ");
                String input = scan.nextLine();
                if (input.equals("exit")) {
                    return;
                }
                int startingBet = Integer.parseInt(input);
                players.get(i).raise(startingBet);
            }
            System.out.println();

            // hand out cards
            for (Player player : players) {
                player.addCardToHand(deck.deal());
            }
            for (int i = 1; i <= numPlayers; i++) {
                players.get(i).addCardToHand(deck.deal());
            }
            printTable();

            // prompt action from each player
            for (int i = 1; i <= numPlayers; i++) {
                System.out.println(players.get(i).getName() + "'s turn");

                Boolean nextTurn = false;
                while (!nextTurn) {
                    System.out.println("hit, stay, or raise?");
                    String action = scan.nextLine();
                    switch (action) {
                        case "hit":
                            players.get(i).addCardToHand(deck.deal());
                            printTable();
                            break;
                        case "raise":
                            System.out.print("Raise amount: ");
                            int amount = scan.nextInt();
                            players.get(i).raise(amount);
                            printTable();
                            break;
                        case "stay":
                            nextTurn = true;
                            break;
                    }
                    if (players.get(i).getHandValue() == 0) {
                        System.out.println(players.get(i).getName() + " has busted.");
                        System.out.println();
                        nextTurn = true;
                    }
                }
            }

            // second card to dealer
            players.get(0).addCardToHand(deck.deal());
            printTable();

            // dealer's turn
            while (players.get(0).getHandValue() != 0 && players.get(0).getHandValue() < 17) {
                players.get(0).addCardToHand(deck.deal());
                System.out.println("Dealer hits");
                printTable();
            }

            // result
            int dealerHandVal = players.get(0).getHandValue();
            System.out.println("Winnings for this round:");
            for (int i = 1; i <= numPlayers; i++) {
                int playerHandVal = players.get(i).getHandValue();
                int playerBet = players.get(i).getCurrentBet();

                if (playerHandVal > dealerHandVal) {
                    players.get(i).addChips(playerBet*2);
                    players.get(0).subtractChips(playerBet);

                    System.out.println(players.get(i).getName() + " wins $" + playerBet);
                } else {
                    players.get(0).addChips(playerBet);
                }
            }
            System.out.println();

            // reset for new round
            for (Player player : players) {
                player.setCurrentBet(0);
                player.clearHand();
            }
        }
    }

    /**
     * Prints the Blackjack table to the command prompt
     */
    public void printTable() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
            if (i == 0) {
                System.out.println("------------------------------");
            }
        }
        System.out.println();
    }
}
