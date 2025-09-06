package BoardGame;

public class Board {
    private String[][] grid;
    private int rows;
    private int columns;

    public Board(int rows,int columns){
        this.rows = rows;
        this.columns = columns;
        grid = new String[rows][columns];
        clearBoard();
    }

    public void clearBoard(){
        for (int r = 0; r < rows; r++ ){
            for (int c = 0; c < columns; c++){
                grid[r][c] = ".";
            }
        }
    }

    public void showBoard(){
        for (int r = 0; r < rows; r++ ){
            for (int c = 0; c < columns; c++){
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }  
    }

    public void addPosition(Position position){
        grid[position.getRow()][position.getColumn()] = "*";
    }

}
