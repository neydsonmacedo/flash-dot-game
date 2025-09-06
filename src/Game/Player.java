package Game;

public class Player {
    private int miss = 0;
    private int score = 0;

    public void mistake(){
        miss++;
    }

    public void scored(){
        score+=10;
    }

    public void levelBonus(){
        score+= 5;
    }

    public int getMistakes(){
        return miss;
    }

    public int getScore(){
        return score;
    }

    public boolean canPlay(){
        return miss < 3;
    }
}
