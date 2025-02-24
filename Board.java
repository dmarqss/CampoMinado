package campoMinado;

public abstract class Board {
    private String[][] grid;

    public void showGrid(){


        System.out.println("Y 0 1 2 3 4 5 6 7 8 9 ");
        System.out.println(" ---------------------  X");


        for (int i = 0; i <= 9; i++) {
            System.out.print("| ");
            for (int j = 0; j <= 9; j++) {
                System.out.print(getOnGrid(i, j) + " ");
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println(" ---------------------");
        System.out.println(" CLICK(0) --- FLAG(1)");
    }

    public String getOnGrid(int x, int y){
        return this.grid[x][y];
    }

    public void setOnGrid(int x, int y, String character){
        this.grid[x][y] = character;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public String[][] getGrid(){
        return this.grid;
    }
}


