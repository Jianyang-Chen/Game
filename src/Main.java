
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String response = "y";
        String name = scan.nextLine();
        while (response.equalsIgnoreCase("y")) {
            BlackJack game = new BlackJack(name);
            game.startGame();
            while (!game.isGameOver()) {
                game.playerTurn();
            }
            game.dealerTurn();
            game.winner();

            System.out.println("Would you like to play again?");
            response = scan.nextLine();

        }
        scan.close();

    }
}
