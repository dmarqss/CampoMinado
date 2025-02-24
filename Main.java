package campoMinado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        clearConsole();
        System.out.println("========================");
        System.out.println("     CAMPO MINADO");
        System.out.println("========================");
        System.out.println("\nESCOLHA A DIFICULDADE\n\nFACIL(1)\nMEDIO(2)\nDIFICIL(3)");

        int dificulty = scan.nextInt() * 5;

        FullBoard fullBoard = new FullBoard(dificulty);
        EmptyBoard emptyBoard = new EmptyBoard(fullBoard);

        //comeco loop do jogo
        while(true) {
            clearConsole();
            emptyBoard.showGrid();
            int clicOrFlag = scan.nextInt();
            int x;
            int y;
            switch(clicOrFlag) {
                case 0:
                    try {
                        System.out.println("CLICK X:");
                        x = scan.nextInt();
                        System.out.println("CLICK Y:");
                        y = scan.nextInt();
                        emptyBoard.click(x, y);
                    }
                    catch (Exception e) {
                        System.out.println("CORDENADA INVALIDA");
                    }
                    break;
                case 1:
                    try {
                        System.out.println("FLAG X:");
                        x = scan.nextInt();
                        System.out.println("FLAG Y:");
                        y = scan.nextInt();
                        emptyBoard.flag(x, y);
                    }
                    catch (Exception e) {
                        System.out.println("CORDENADA INVALIDA");
                    }

                    break;

            }
            if(!emptyBoard.isAlive()){
                clearConsole();
                System.out.println("VOCE PERDEU");
                emptyBoard.showGrid();
                break;
            }
            if(emptyBoard.getFlagCorrect() == 0){
                System.out.println("VOCE GANHOU");
                break;
            }
            
        }

    }





    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
