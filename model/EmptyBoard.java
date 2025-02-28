package campoMinado.model;

public class EmptyBoard extends Board {
    private final String[][] emptyBoard = new String[10][10];
    private FullBoard fullBoard;
    private int flagCorrect;
    private boolean alive;

    public EmptyBoard(FullBoard fullBoard) {
        setAlive(true);
        setFullBoard(fullBoard);
        setGrid(emptyBoard);
        makeEmptyBoard();
        setFlagCorrect(fullBoard.getNumberOfBombs());
    }

    public void makeEmptyBoard() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                setOnGrid(i, j, ".");
            }
        }
    }

    public void flag(int x, int y) {
        if (getOnGrid(x, y).equals(".") || getOnGrid(x, y).equals("P")) {
            if (getOnGrid(x, y).equals("P")) {
                setOnGrid(x, y, ".");
                if (fullBoard.getOnGrid(x, y).equals("*")) {
                    setFlagCorrect(+1);
                }
            } else {
                setOnGrid(x, y, "P");
                if (fullBoard.getOnGrid(x, y).equals("*")) {
                    setFlagCorrect(-1);
                }
            }
        } else {
            System.out.println("VOCE SO PODE MARCAR EM \".\"");
        }
    }

    public void click(int x, int y) {
        if (fullBoard.getOnGrid(x, y).equals("*") && getOnGrid(x, y).equals(".")) {
            showBombs();
            setAlive(false);

        } else if (getOnGrid(x, y).equals("P") || !getOnGrid(x, y).equals(".")) {
            System.out.println("VOCE SO PODE CLICAR EM \".\"");
            setAlive(true);
        } else {
            fill(emptyBoard, x, y, fullBoard.getGrid());
            setAlive(true);
        }
    }

    public void showBombs() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (fullBoard.getOnGrid(i, j).equals("*")) {
                    setOnGrid(i, j, "*");
                }
            }
        }
    }

    public void fill(String[][] emptyBoard, int x, int y, String[][] fullBoard) {

        if (x < 0 || x >= emptyBoard.length || y < 0 || y >= emptyBoard[0].length) {
            return;
        } else if (fullBoard[x][y].equals("*") || getOnGrid(x, y).equals("P")) {
            return;
        } else if (!fullBoard[x][y].equals("0")) {
            setOnGrid(x, y, fullBoard[x][y]);
            return;
        } else if (getOnGrid(x, y).equals(".")) {
            setOnGrid(x, y, "0");

            fill(emptyBoard, x + 1, y, fullBoard);
            fill(emptyBoard, x - 1, y, fullBoard);
            fill(emptyBoard, x, y + 1, fullBoard);
            fill(emptyBoard, x, y - 1, fullBoard);
        }

    }

    public void setFullBoard(FullBoard fullBoard) {
        this.fullBoard = fullBoard;
    }

    public int getFlagCorrect() {
        return flagCorrect;
    }

    public void setFlagCorrect(int flagCorrect) {
        this.flagCorrect += flagCorrect;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
