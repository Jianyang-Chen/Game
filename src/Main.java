
public class Main {

    public static void main(String[] args) throws Exception {
        BlackJack game = new BlackJack("John");
        game.startGame();
        while (!game.isGameOver()) {
            game.playerTurn();
        }
        game.dealerTurn();
        game.winner();
    }
}
