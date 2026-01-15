
import java.util.Scanner;

public class BlackJack {

    private final Scanner scan = new Scanner(System.in);
    private final int WINNING_VALUE = 21;
    private final Deck deck = new Deck();
    private final Player player;
    private final Dealer dealer = new Dealer();

    public BlackJack(String playerName) {
        this.player = new Player(playerName);
    }

    public void startGame() {
        deck.shuffle();
        System.out.println("Dealing cards...");
        System.out.println("Aces are only worth 11 for simplicity.");
        Card dealerFirst = deck.dealCard();
        this.player.addToHandValue(deck.dealCard().getValue());
        this.player.addToHandValue(deck.dealCard().getValue());
        this.dealer.showCard(dealerFirst);
        this.dealer.addToHandValue(deck.dealCard().getValue());
        this.dealer.addToHandValue(dealerFirst.getValue());
    }

    public void playerTurn() {
        if (!this.player.isStanding()) {
            System.out.println(this.player.getName() + "'s turn:");
            System.out.println("Current hand value: " + this.player.getHandValue());
            System.out.print("Do you want to (h)it or (s)tand? ");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                this.player.addToHandValue(deck.dealCard().getValue());
                if (this.player.getHandValue() > this.WINNING_VALUE) {
                    System.out.println(this.player.getName() + " busts!");
                    System.out.println(this.player.getName() + " hand value: " + this.player.getHandValue());
                    this.player.setBust();
                } else if (this.player.getHandValue() == this.WINNING_VALUE) {
                    System.out.println(this.player.getName() + " hits 21!");
                    this.player.setStanding();
                }
            } else {
                this.player.setStanding();
            }
        }
    }

    public void dealerTurn() {
        while (this.dealer.getHandValue() < 17 && !this.player.isBust()) {
            System.out.println("Dealer hits.");
            this.dealer.addToHandValue(deck.dealCard().getValue());
        }
        if (this.dealer.getHandValue() > this.WINNING_VALUE) {
            System.out.println("Dealer busts!");
            this.dealer.setBust();
        }
        if (!this.dealer.isBust()) {
            System.out.println("Dealer stands.");
            this.dealer.setStanding();
        }

    }

    public boolean isGameOver() {
        return this.player.isBust() || this.dealer.isBust() || this.player.isStanding() || this.dealer.isStanding();
    }

    public void winner() {
        System.out.println("Dealer hand value: " + this.dealer.getHandValue());
        if (this.player.isBust()) {
            System.out.println("Dealer wins!");
        } else if (this.dealer.isBust()) {
            System.out.println(this.player.getName() + " wins!");
        } else if (this.player.getHandValue() > this.dealer.getHandValue()) {
            System.out.println(this.player.getName() + " wins!");
        } else if (this.player.getHandValue() < this.dealer.getHandValue()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
