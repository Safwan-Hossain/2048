/**
 * @file: Display.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Represents the view of the game.
 */

package src;

import java.util.HashSet;

public class Display {
    /**
     * @brief Displays a welcome screen
     */
    public static void printWelcomeScreen() {
        System.out.println("============================");
        System.out.println("            2048            ");
        System.out.println("============================");
        System.out.println();
    }

    /**
     * @brief Displays a new game message
     */
    public static void printNewGame() {
        System.out.println("New Game");
        System.out.println("----------------------------");
    }
    /**
     * @brief Displays a message asking for the desired board size.
     */
    public static void askForBoardSize() {
        System.out.println("Please enter the size of the game board. " +
                "For example to play the original 4 by 4 version, please enter 4:");
    }

    /**
     * @brief Displays a message asking for the desired number of random numbers inserted every move
     */
    public static void askForNumberOfPushes() {
        System.out.println("Please enter the number of random numbers to be inserted after every move. ");
        System.out.println("For example to have only 1 random number inserted after every move (like in the original game), " +
                "please enter 1:");
    }
    /**
     * @brief Displays a game over screen
     * @param score - the final score of the game
     */
    public static void printGameOverScreen(int score) {
        System.out.println("===================");
        System.out.println("     GAME OVER     ");
        System.out.println("Score: " + score);
        System.out.println("===================");
        System.out.println("Start new game? (y/n): ");
    }
    /**
     * @brief Displays an exit message
     */
    public static void printExitScreen() {
        System.out.println("Thanks for playing. Game ended.");
    }

    /**
     * @brief converts an integer array into in ASCII text
     * @details calculates the number of digits of the highest number in the baord. The method then
     * uses that length to set the cell size so that each cell has equal size.
     * @param row - the row that is to be converted into string
     * @param largest - the largest number in the board
     */
    public static String rowToString(int[] row, int largest) {
        String rowString = "";
        for (int i = 0; i < row.length; i++) {
            int padding = largest - String.valueOf(row[i]).length();
            String paddingString = "";
            for (int j = 0; j < padding/2; j++) {
                paddingString += " ";
            }

            rowString += "|";

            if (padding % 2 == 1) {
                rowString += " ";
            }

            if (row[i] == 0) {
                rowString += paddingString + " " + paddingString;
            }
            else {
                rowString += paddingString + row[i] + paddingString;
            }
        }
        rowString += "|";
        return rowString;
    }

    /**
     * @brief Displays a board visually in ASCII text
     * @details prints each row one by one using the rowToString() method
     * @param board - the board that is to be displayed
     */
    public static void printGameBoard(Board board) {
        // gets the current largest number and gets the string length
        int largestNumOfDigits = String.valueOf(board.getLargestCurrentNumber()).length();

        System.out.println("=================");
        System.out.println("Score: " + board.getScore());
        for (int row = 0; row < board.getBoardSize(); row++) {
            System.out.println(rowToString(board.getRow(row), largestNumOfDigits));
        }
        System.out.println("=================");
    }

}
