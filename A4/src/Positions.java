/**
 * @file: Positions.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Keeps track of information about positions in the board.
 */

package src;

//import java.util.Arrays;
import java.util.HashSet;


public class Positions {
    int boardSize;
    HashSet<int[]> availablePositions;
    HashSet<int[]> recentlyMerged;

    /**
     * @brief constructor
     * @details keeps track of the cells in the game. Each empty cell is stored in a set and is
     * updated everytime a cell is changed. Every time the player makes a move if any cells were merged
     * during that move, it gets added to a set that keeps track of the resulting cell of the two merging cells. After
     * the move is done the merged cells set is emptied.
     * @param boardSize - size of the game board
     * @Assumption This class is only used by Game.java and Board.java, therefore proper indices
     * will be inputted.
     */
    public Positions(int boardSize) {
        this.boardSize = boardSize;
        this.availablePositions = new HashSet<>();
        this.recentlyMerged = new HashSet<>();
        this.addAllAvailablePositions();
    }

    /**
     * @brief rotates all the locations for all current empty cells by 90 degrees ccw.
     * @details When a player makes a move, the board is rotated so that the direction always goes upwards,
     * and then the board gets rotated back. During the rotation the program needs to access the empty cell locations,
     * thus the empty cell locations are rotated to keep the position matching the board.
     */

    public void rotateAvailablePositions() {
        HashSet<int[]> rotatedPositions = new HashSet<>();
        for (int[] position: this.availablePositions) {
            rotatedPositions.add(this.getRotatedPosition(position));
        }
        this.availablePositions = rotatedPositions;
    }

    /**
     * @brief rotates a given location by 90 degrees ccw.
     * @details Treats the location like it is a cell in matrix. When rotating a matrix 90 degrees ccw, the new
     * row value is the matrix size minus the given column value, while the new column value is the given row value.
     * @param position - position that is to be rotated.
     * @return the rotated version of the given position
     */
    public int[] getRotatedPosition(int[] position) {
        int row = this.boardSize - 1 - position[1];
        int column = position[0];
        return new int[] {row, column};
    }

    /**
     * @brief marks all cells as empty.
     */
    public void addAllAvailablePositions() {
        for (int row = 0; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                this.addAvailablePosition(row, col);
            }
        }
    }

    public boolean positionIsAvailable(int row, int col) {
        for (int[] position: this.availablePositions) {
            if (position[0] == row && position[1] == col) {
                return true;
            }
        }
        return false;
    }
    /**
     * @brief marks a single cell as empty.
     * @param row - the row of the cell that is to be marked
     * @param col - the column of the cell that is to be marked
     */
    public void addAvailablePosition(int row, int col) {
        if (positionIsAvailable(row, col)) {
            return;
        }
        this.availablePositions.add(new int[] {row, col});
    }

    /**
     * @brief marks an empty cell as taken (not empty).
     * @param row - the row of the cell that is to be marked
     * @param col - the column of the cell that is to be marked
     */
    public void removeAvailablePosition(int row, int col) {
        int[] position = new int[2];
        for (int[] currPosition: this.availablePositions) {
            if (currPosition[0] == row && currPosition[1] == col) {
                position = currPosition;
            }
        }
        this.availablePositions.remove(position);
    }

    /**
     * @brief gets a random empty cell in the game.
     * @details calculates a random index between 0 and one less than the size of the number of empty cells.
     * then the method returns the empty cell located at the index. If no empty cells exist, the method returns
     * a position of [-1, -1] to indicate there are no cells left.
     * @return a random empty cell in the board if available. Otherwise returns an out of bound location.
     */
    public int[] getRandomPosition() {
        int randomIndex = (int) (Math.random() * this.availablePositions.size());
        int currentIndex = 0;
        for (int[] position: this.availablePositions) {
            if (currentIndex == randomIndex) {
                return position;
            }
            currentIndex++;
        }
        return new int[] {-1, -1};
    }

    /**
     * @brief checks if there are any empty cells in the game.
     * @return True if there is at least one empty cell in the game. False otherwise.
     */
    public boolean hasAvailablePosition() {
        return !this.availablePositions.isEmpty();
    }

    /**
     * @brief marks a given cell as recently merged.
     * @details this is used to avoid chain merges in a single move.
     * @param row - the row of the cell that is to be marked
     * @param col - the column of the cell that is to be marked
     */
    public void merged(int row, int col) {
        this.recentlyMerged.add(new int[] {row, col});
    }

    /**
     * @brief resets all merged cells so that no cells were recently merged (unmarks all merged cells).
     * @details used after every move to make sure previous moves have no influence over current move
     */
    public void resetMergedPositions() {
        this.recentlyMerged.clear();
    }


    /**
     * @brief finds out if a given cell was recently merged in current move.
     * @param row - the row of the cell that is to be marked
     * @param col - the column of the cell that is to be marked
     * @return True if given cell was merged. False otherwise.
     */
    public boolean wasRecentlyMerged(int row, int col) {
        for (int[] position: this.recentlyMerged) {
            int mergedRow = position[0];
            int mergedCol = position[1];
            if (mergedRow == row && mergedCol == col) {
                return true;
            }
        }
        return false;
    }

//    public void printBoard() {
//        int[][] positions = new int[this.boardSize][this.boardSize];
//        for (int[] pos: this.availablePositions) {
//            positions[pos[0]][pos[1]] = 1;
//        }
//        System.out.println("======Pos======");
//        for (int i = 0; i < this.boardSize; i++) {
//            System.out.println(Arrays.toString(positions[i]));
//        }
//        System.out.println("======Pos======");
//    }
}
