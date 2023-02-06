/**
 * @file: Controller.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Controls the model and view of the game.
 */

package controller;

import enumeration.Move;
import model.Game;
import view.Display;

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

        Display.printNewGame();
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
            Move directionInput = takeDirectionInput();
            game.move(directionInput);
            Display.printGameBoard(game.getBoard());
        }
        gameOver();
    }

    private static Move takeDirectionInput() {
        String move = scanner.next().toLowerCase();
        return switch (move) {
            case "w" -> Move.up;
            case "s" -> Move.down;
            case "d" -> Move.right;
            case "a" -> Move.left;
            default -> Move.up;
        };
    }
}
