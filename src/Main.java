
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        BlackJack game = new BlackJack(name);

        game.startGame();
        while (!game.isGameOver()) {
            game.playerTurn();
        }
        game.dealerTurn();
        game.winner();

        scan.close();

    }
}
