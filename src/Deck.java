
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private final String[] SUITS = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    private final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (String suit : this.SUITS) {
            for (String rank : this.RANKS) {
                this.cards.add(new Card(suit, rank));
            }
        }
        System.out.println(this.cards.get(0).getRank());
    }

    public Card dealCard() {
        if (this.cards.isEmpty()) {
            return null;
        }
        return this.cards.remove(this.cards.size() - 1);
    }

    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while (!this.cards.isEmpty()) {
            int index = (int) (Math.random() * this.cards.size());
            shuffled.add(this.cards.remove(index));
        }
        this.cards = shuffled;
    }
}
