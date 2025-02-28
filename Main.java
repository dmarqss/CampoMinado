package campoMinado;

import campoMinado.customExeptions.InvalidInputExeption;
import campoMinado.customExeptions.OutOFRangeExeption;
import campoMinado.model.EmptyBoard;
import campoMinado.model.FullBoard;

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
            dificulty = userInput(1,3);

            FullBoard fullBoard = new FullBoard(dificulty);
            EmptyBoard emptyBoard = new EmptyBoard(fullBoard);
            clearConsole();

            //comeco loop do jogo
            while (true) {
                emptyBoard.showGrid();
                int clicOrFlag = userInput(0,1);;
                int x;
                int y;
                switch (clicOrFlag) {
                    case 0:
                        System.out.println("CLICK X:");
                        x = userInput(0,9);
                        System.out.println("CLICK Y:");
                        y = userInput(0,9);
                        clearConsole();
                        emptyBoard.click(x, y);
                        break;
                    case 1:
                        System.out.println("FLAG X:");
                        x = userInput(0,9);
                        System.out.println("FLAG Y:");
                        y = userInput(0,9);
                        clearConsole();
                        emptyBoard.flag(x, y);
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
            if (userInput(0,1) == 0) {
                break;
            }
        }
    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int userInput(int min ,int max){
        while (true){
            try {
                return collectUserInput(min, max);
            }catch (OutOFRangeExeption e){
                System.out.println("ESTA FORA DAS OPCOES");
            }catch (InvalidInputExeption ex){
                System.out.println("LETRAS NAO SAO VALIDAS");
            }
        }
    }

    public static int collectUserInput(int min, int max) throws OutOFRangeExeption, InvalidInputExeption {
        Scanner scan = new Scanner(System.in);
        int input;
        try {
            input = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            throw new InvalidInputExeption();
        }
        if (input < min || input > max) {
            throw new OutOFRangeExeption();
        }
        return input;
    }
}

