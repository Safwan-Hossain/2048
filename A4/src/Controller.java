/**
 * @file: Controller.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Controls the model and view of the game.
 */

package src;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner;
    private static Game game;

    public static int tryInt(int min) {
        String errorMsg = "Please enter a number that is " + min + " or above: ";
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num >= min) {
                    return num;
                }
                System.out.println(errorMsg);
            } catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
    }

    public static void start() {
        scanner = new Scanner(System.in);
        Display.printWelcomeScreen();
        newGame();
        runGame();
    }

    public static void newGame() {
        Display.askForBoardSize();
        int boardSize = tryInt(2);
        Display.askForNumberOfPushes();
        int numOfRandomPerMove = tryInt(1);
        game = new Game(boardSize, numOfRandomPerMove);
    }

    public static void gameOver() {
        Display.printGameOverScreen(game.getScore());
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                newGame();
                runGame();
                return;
            }
            else if (input.equals("n") || input.equals("no")) {
                Display.printExitScreen();
                return;
            }
            else {
                System.out.println("Invalid input. Try again: ");
            }

        }
    }

    public static void runGame() {
        Display.printGameBoard(game.getBoard());
        while (game.isMovePossible()) {
            String move = scanner.next().toLowerCase();
            Move direction = Move.up;
            switch(move) {
                case "w":
                    direction = Move.up;
                    break;
                case "s":
                    direction = Move.down;
                    break;
                case "d":
                    direction = Move.right;
                    break;
                case "a":
                    direction = Move.left;
                    break;
                default:
                    break;
            }
            game.move(direction);
            Display.printGameBoard(game.getBoard());
        }
        gameOver();
    }
}
