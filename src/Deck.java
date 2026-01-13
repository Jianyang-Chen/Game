
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private final String[] SUITS = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    private final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    public Deck() {
        this.cards = new ArrayList<>();
        for (String suit : this.SUITS) {
            for (String rank : this.RANKS) {
                this.cards.add(new Card(suit, rank));
            }
        }
        this.shuffle();
    }

    public Card dealCard() {
        if (this.cards.isEmpty()) {
            return null;
        }
        return this.cards.remove(this.cards.size() - 1);
    }

    public void resetDeck() {
        this.cards.clear();
        for (String suit : this.SUITS) {
            for (String rank : this.RANKS) {
                this.cards.add(new Card(suit, rank));
            }
        }
        this.shuffle();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();
        while (!this.cards.isEmpty()) {
            int index = (int) (Math.random() * this.cards.size());
            shuffled.add(this.cards.remove(index));
        }
        this.cards = shuffled;
    }
}
