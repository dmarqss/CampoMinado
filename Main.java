package campoMinado;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dificulty;
        while (true) {
            System.out.println("========================");
            System.out.println("     CAMPO MINADO");
            System.out.println("========================");
            System.out.println("\nESCOLHA A DIFICULDADE\n\nFACIL(1)\nMEDIO(2)\nDIFICIL(3)");
            try {
                 dificulty = Integer.parseInt(scan.nextLine());
                 if(dificulty != 1 && dificulty != 2 && dificulty != 3){
                     throw new IllegalArgumentException();
                 }
            }catch (Exception e){
                clearConsole();
                System.out.println("INPUT INVALIDO");
                continue;
            }


            FullBoard fullBoard = new FullBoard(dificulty);
            EmptyBoard emptyBoard = new EmptyBoard(fullBoard);
            clearConsole();

            //comeco loop do jogo
            while (true) {
                emptyBoard.showGrid();
                int clicOrFlag;
                int x;
                int y;
                try{
                    clicOrFlag = Integer.parseInt(scan.nextLine());
                    if(clicOrFlag != 0 && clicOrFlag != 1){
                        throw new IllegalArgumentException();
                    }
                }
                catch (Exception e){
                    clearConsole();
                    System.out.println("INPUT INVALIDO");
                    continue;
                }
                switch (clicOrFlag) {
                    case 0:
                        try {
                            System.out.println("CLICK X:");
                            x = Integer.parseInt(scan.nextLine());
                            System.out.println("CLICK Y:");
                            y = Integer.parseInt(scan.nextLine());
                            clearConsole();
                            emptyBoard.click(x, y);
                        } catch (Exception e) {
                            clearConsole();
                            System.out.println("CORDENADA INVALIDA");
                            continue;
                        }
                        break;
                    case 1:
                        try {
                            System.out.println("FLAG X:");
                            x = Integer.parseInt(scan.nextLine());
                            System.out.println("FLAG Y:");
                            y = Integer.parseInt(scan.nextLine());
                            clearConsole();
                            emptyBoard.flag(x, y);
                        } catch (Exception e) {
                            clearConsole();
                            System.out.println("CORDENADA INVALIDA");
                            continue;
                        }

                        break;

                }
                if (!emptyBoard.isAlive()) {
                    clearConsole();
                    System.out.println("VOCE PERDEU");
                    emptyBoard.showGrid();
                    break;
                }
                if (emptyBoard.getFlagCorrect() == 0) {
                    clearConsole();
                    System.out.println("VOCE GANHOU");
                    emptyBoard.showGrid();
                    break;

                }

            }
            System.out.println("===================");
            System.out.println("JOGAR DE NOVO?\nSIM(1)\nNAO(0)");
            if (scan.nextInt() == 0) {
                break;
            }
        }
    }


    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}

