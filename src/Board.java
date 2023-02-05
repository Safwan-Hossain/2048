/**
 * @file: Board.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Represents the game board
 */

package src;

//import java.util.Arrays;

public class Board {
    // [row][column]
    int[][] numbers;
    int boardSize;
    int score;
    boolean wasChangeMade;
    Positions positions;

    /**
     * @brief constructor
     * @param boardSize - size of the game board
     * @param positions - positions object used for this board4
     * @Assumption This class is only used by Game.java and Demo.java, therefore proper indices
     * will be inputted.
     * @throws IllegalArgumentException - the value is less than 0
     */
    public Board(int boardSize, Positions positions) {
        if (boardSize < 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.boardSize = boardSize;
        this.positions = positions;
        this.wasChangeMade = false;
        this.numbers = new int[boardSize][boardSize];
        this.score = 0;
    }

    /**
     * @brief sets the board and resets some state variables. Used exclusively for testing.
     * @param newNumbers - the board matrix that overwrites the current one
     */
    //for testing
    public void setBoard(int[][] newNumbers) {
        this.numbers = newNumbers;
        this.score = 0;
        this.wasChangeMade = false;
        this.positions = new Positions(this.boardSize);
    }

    /**
     * @brief returns a number located at a given cell
     * @param row - the row index of the wanted cell
     * @param col - the column index of the wanted cell
     * @return Number located at the desired cell
     */
    public int getNumber(int row, int col) {
        return this.numbers[row][col];
    }

    /**
     * @brief returns the size of the board
     * @return the size of the board
     */
    public int getBoardSize() {
        return this.boardSize;
    }

    /**
     * @brief returns the current score
     * @return the current score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @brief returns the array of a desired row in the board
     * @param row - the row index
     * @return array located at the row index
     */
    public int[] getRow(int row) {
        return this.numbers[row];
    }

    /**
     * @brief returns whether a change was made during this move
     * @details resets this variable after every move. Used to track if the board
     * was changed to check if a new number should be inserted or not.
     * @return if any number moved or was merged or was replaced for the current move return True.
     * Otherwise False.
     */
    public boolean wasChangeMade() {
        return this.wasChangeMade;
    }


    /**
     * @brief changes a number at a given cell
     * @param row - the row index the cell that is to be changed
     * @param col - the column index the cell that is to be changed
     */
    public void setNumber(int row, int col, int number) {
        this.numbers[row][col] = number;
    }

    /**
     * @brief resets the variable that tracks if a change was made to False.
     * @details used at the end of every move
     */
    public void resetChangeChecker() {
        this.wasChangeMade = false;
    }

    /**
     * @brief finds the largest current number on the board
     */
    public int getLargestCurrentNumber() {
        int largest = 2;
        for (int row = 0; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                if (this.getNumber(row, col) > largest) {
                    largest = this.getNumber(row, col);
                }
            }
        }
        return largest;
    }
    /**
     * @brief finds out if a player can make a move or is the game over
     * @details applies the function canMove() to every cell on the board.
     * If one of the cells contains a zero or returns True for canMove(), then
     * the function returns True. Otherwise False.
     * @return True if player can make a move. Otherwise False.
     */
    public boolean isMovePossible() {
        if (positions.hasAvailablePosition()) {
            return true;
        }

        for (int row = 0; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                if (this.canMove(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @brief checks if a given cell can move to a neighbouring cell
     * @details a neighbouring cell is defined by a cell that is either 1 up, 1 right, 1 left
     * or 1 down from the current cell. If the current cell has a neighbouring cell such that both
     * cells contain the same value, then a move is possible, in this case return True. Otherwise False.
     * @param row - the row index the cell that is to be checked
     * @param col - the column index the cell that is to be checked
     * @return True if a move is possible, False otherwise.
     */
    public boolean canMove(int row, int col) {
        int currNum = this.getNumber(row, col);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row - i >= 0 && row - i < this.boardSize &&
                        col - j >= 0 && col - j < this.boardSize) {

                    int neighbourNum = this.getNumber(row - i, col - j);
                    if (currNum == neighbourNum && !(i == 0 && j == 0) && (i == 0 || j == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @brief rotates the values of board 90 degrees ccw.
     * @details When rotating a matrix 90 degrees ccw, the new row value is the current matrix size minus the
     * un-rotated column value, while the new column value is the un-rotated row value. Goes through every cell in
     * the board and inserts each value to a new rotated matrix. Then the new matrix is set as the current matrix. This
     * is used when slideUp() is called for a direction that is not pointing upwards.
     */
    public void rotate() {
        int[][] newNumbers = new int[this.boardSize][this.boardSize];

        for (int row = 0; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                newNumbers[row][col] = this.getNumber(col, this.boardSize - 1 - row);
            }
        }
        this.numbers = newNumbers;
    }

    /**
     * @brief slides or merges a number up if there is space
     * @details recursively slides a number up a board. If the number above was recently merged
     * or does not exist then the function stops. If the number above is equal to the current number
     * then the cells are merged and the current cell is replaced with a 0. If the number above is a 0
     * then the above cell is replaced by the current number, the current cell is replaced by 0, and then
     * slideUp() is called for the cell above.
     * @param row - the row index the desired cell
     * @param col - the column index the desired cell
     */
    public void slideUp(int row, int col) {
        int rowAbove = row - 1;

        if (rowAbove < 0 || positions.wasRecentlyMerged(rowAbove, col)) {
            return;
        }

        int currNum = this.getNumber(row, col);
        int numAbove = this.getNumber(rowAbove, col);

        if (currNum == numAbove) {
            this.setNumber(rowAbove, col, currNum * 2);
            this.setNumber(row, col, 0);
            this.score += currNum * 2;
            this.wasChangeMade = true;
            positions.merged(rowAbove, col);
            positions.addAvailablePosition(row, col);
            return;
        }
        if (numAbove == 0) {
            this.setNumber(rowAbove, col, currNum);
            this.setNumber(row, col, 0);
            this.wasChangeMade = true;
            positions.removeAvailablePosition(rowAbove, col);
            positions.addAvailablePosition(row, col);
            slideUp(rowAbove, col);
        }
    }
    /**
     * @brief calls slideUp() for all cells except the top row in the board.
     * @details the top row does not need to have slideUp() called because the number the top cannot go higher
     * and any numbers below it that can merge will be merged when their cell is called.
     */
    public void slideAllUp() {
        for (int row = 1; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                if (this.getNumber(row, col) != 0) {
                    this.slideUp(row, col);
                }
            }
        }
    }


//    public void printBoard() {
//        System.out.println("============");
//        for (int i = 0; i < this.boardSize; i++) {
//            System.out.println(Arrays.toString(this.numbers[i]));
//        }
//        System.out.println("============");
//    }
}
