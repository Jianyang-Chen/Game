
public class Player {

    private boolean stand = false;
    private String name;
    private boolean busts = false;
    private int handValue;

    public Player(String name) {
        this.name = name;
        this.handValue = 0;
    }

    public int addToHandValue(int value) {
        this.handValue += value;
        return this.handValue;
    }

    public int getHandValue() {
        return this.handValue;
    }

    public String getName() {
        return this.name;
    }

    public boolean isStanding() {
        return this.stand;
    }

    public boolean isBust() {
        return this.busts;
    }

    public void setBust() {
        this.busts = true;
    }

    public void setStanding() {
        this.stand = true;
    }
}
