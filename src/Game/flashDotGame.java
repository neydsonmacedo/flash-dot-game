package Game;

import java.util.Scanner;

public class flashDotGame {
    private Player player;
    private Scanner scanner;

    public flashDotGame(){
        player = new Player();
        scanner = new Scanner(System.in);
    }

    public void startMatch() throws InterruptedException{
        System.out.println("Welcome to FlashDots");

        int level = 1;

        while (player.canPlay()){
            Match match = new Match(player, level, scanner);
            boolean play = match.playMatch();
            level = match.getLevel();

            if(!play) break;
        }
        System.out.println("\nEnd Game! You make 3 mistakes.");
        System.out.println("Final Score: " + player.getScore());
        scanner.close();
    }
}
