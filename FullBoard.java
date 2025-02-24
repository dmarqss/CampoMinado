package campoMinado;

import java.util.Random;

public class FullBoard extends Board{
    private final String[][] fullBoard = new String[10][10];
    private int numberOfBombs;

    public FullBoard(int nuberOfBombs){
        setGrid(fullBoard);
        setNumberOfBombs(nuberOfBombs);
        makeFullBoard(getNumberOfBombs());
    }

    public void makeFullBoard(int numberOfBombs) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                setOnGrid(i, j, "0");
            }
        }
        addBombs(numberOfBombs);
    }

    public void addBombs(int numberOfBombs) {
        Random random = new Random();
        for (int i = 0; i < numberOfBombs; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (getOnGrid(x, y) != "*") {
                setOnGrid(x, y, "*");
                setAround(x, y);
            } else {
                i--;
            }

        }
    }

    public void setAround(int x, int y) {
        if (x - 1 >= 0 && getOnGrid(x - 1, y) != "*") {
            setOnGrid(x - 1, y, String.valueOf(getFullBoardInt(x - 1, y) + 1));
        }
        if (y - 1 >= 0 && getOnGrid(x, y - 1) != "*") {
            setOnGrid(x, y - 1, String.valueOf(getFullBoardInt(x, y - 1) + 1));
        }
        if (x + 1 <= 9 && getOnGrid(x + 1, y) != "*") {
            setOnGrid(x + 1, y, String.valueOf(getFullBoardInt(x + 1, y) + 1));
        }
        if (y + 1 <= 9 && getOnGrid(x, y + 1) != "*") {
            setOnGrid(x, y + 1, String.valueOf(getFullBoardInt(x, y + 1) + 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && getOnGrid(x - 1, y - 1) != "*") {
            setOnGrid(x - 1, y - 1, String.valueOf(getFullBoardInt(x - 1, y - 1) + 1));
        }
        if (y - 1 >= 0 && x + 1 <= 9 && getOnGrid(x + 1, y - 1) != "*") {
            setOnGrid(x + 1, y - 1, String.valueOf(getFullBoardInt(x + 1, y - 1) + 1));
        }
        if (y + 1 <= 9 && x - 1 >= 0 && getOnGrid(x - 1, y + 1) != "*") {
            setOnGrid(x - 1, y + 1, String.valueOf(getFullBoardInt(x - 1, y + 1) + 1));
        }
        if (y + 1 <= 9 && x + 1 <= 9 && getOnGrid(x + 1, y + 1) != "*") {
            setOnGrid(x + 1, y + 1, String.valueOf(getFullBoardInt(x + 1, y + 1) + 1));
        }
    }

    public int getFullBoardInt(int x, int y) {
        try {
            return Integer.valueOf(fullBoard[x][y]);
        } catch (Exception e) {
            return 0;
        }
    }


    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public void setNumberOfBombs(int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
    }
}
