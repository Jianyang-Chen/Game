
public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public void showCard(Card card) {
        System.out.println("Dealer shows: " + card.getRank() + " of " + card.getSuit());
    }

}
