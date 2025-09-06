package Game;

import java.util.Random;
import java.util.Scanner;

import BoardGame.Board;
import BoardGame.Position;

public class Match {

    private Board board;
    private Player player;
    private Random random;
    private Scanner scanner;
    private int level;
    
    public Match(Player player, int level,Scanner scanner){
        this.board = new Board(10, 20);
        this.player = player;
        this.random = new Random();
        this.scanner = scanner;
        this.level = level; 
    }

    public boolean playMatch() throws InterruptedException{
        board.clearBoard();

        // logic to increase the level off dots (until 12)
        int maxDots = Math.min(3+ level , 12);
        int totalDots = random.nextInt(maxDots) + 1;

        for (int i = 0; i < totalDots; i++){
            Position position = new Position(random.nextInt(10), random.nextInt(20));
            board.addPosition(position);
        }
        
        board.showBoard();
        
        // never below 1 sec 
        int displayTime = Math.max(3000 - (level - 1) * 300, 1000);
        Thread.sleep(displayTime);

        clearScreen();

        System.out.print("How many * did you see:");

        int guess = scanner.nextInt();
        scanner.nextLine();


        if (guess == totalDots){
            System.out.println("Right Guess: " + guess);
            player.scored();
            player.levelBonus();
            level++;
            System.out.println("You pass to the next level " + level + "!");

        }
        else{
            System.out.println("Wrong Guess: " + guess);
            System.out.println("Right Number: " + totalDots);
            player.mistake();
            System.out.println("Mistakes " + player.getMistakes() + "/3");
        }

        System.out.println("Score: " + player.getScore());

        return player.canPlay();
    }

    public int getLevel(){
        return level;
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
