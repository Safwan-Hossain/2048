/**
 * @file: Game.java
 * @Author: Safwan Hossain, hossam18, 400252391
 * @Date: 4/12/2021
 * @Description: Updates and controls the physics and logic of the game
 */

package model;

import enumeration.Move;

public class Game {
    Positions positions;
    Board board;
    int boardSize;
    int numOfRandomPerMove;
    int score;

    /**
     * @brief constructor
     * @param boardSize - size of the game board
     * @param numOfRandomPerMove - the number of random numbers that is to be inserted into the board after every move
     * @Assumption This class is only used by Controller.java, therefore proper indices
     * will be inputted.
     */
    public Game(int boardSize, int numOfRandomPerMove) {
        this.positions = new Positions(boardSize);
        this.board = new Board(boardSize, positions);
        this.boardSize = boardSize;
        this.numOfRandomPerMove = numOfRandomPerMove;
        this.score = 0;

        this.pushRandomNumber();
        this.pushRandomNumber();
    }

    /**
     * @brief slides the board towards a certain direction
     * @details the board can only slide upwards, so before the slide function is called
     * the board and positions are rotated so the direction is relatively facing upwards. After
     * the sliding function is called, the board and positions get rotated back to their original
     * orientation. For example if the player wants two move down, then the game is rotated 180 degrees,
     * the numbers are slided upwards (which is downwards in player's POV) then the game is rotated 180 degrees again.
     * @param direction - the direction that the player wants the board to slide
     */
    public void move(Move direction) {
        int numOfRotates = 0;
        switch (direction) {
            case up:
                numOfRotates = 0;
                break;
            case right:
                numOfRotates = 1;
                break;
            case down:
                numOfRotates = 2;
                break;
            case left:
                numOfRotates = 3;
                break;
            default:
                break;
        }

        this.rotateGame(numOfRotates);
        board.slideAllUp();
        positions.resetMergedPositions();
        this.score = board.getScore();
        this.rotateGame(4 - numOfRotates);

        if (board.wasChangeMade()) {
            board.resetChangeChecker();
            for (int i = 0; i < this.numOfRandomPerMove; i++) {
                this.pushRandomNumber();
            }
        }
    }


    /**
     * @brief gets the current score of the game
     * @return - the current score of the game
     */
    public int getScore() {
        return board.getScore();
    }
    /**
     * @brief gets the game board object. Used mainly for testing and displaying the board visually
     * @return - the game board for the current game
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * @brief rotates the game a desired number of times
     * @param times - the number of times the game is to be rotated
     */
    public void rotateGame(int times) {
        if (times == 4) {
            return;
        }

        for (int i = 0; i < times; i++) {
            board.rotate();
            positions.rotateAvailablePositions();
        }
    }

    /**
     * @brief finds out if a player can make a move or is the game over
     * @details more details in Board.java
     * @return True if player can make a move. Otherwise False.
     */
    public boolean isMovePossible() {
        return board.isMovePossible();
    }

    /**
     * @brief pushes a random number (2 or 4) to an empty cell. If no cells are empty do nothing.
     */
    public void pushRandomNumber() {
        int[] pos = positions.getRandomPosition();
        int row = pos[0];
        int col = pos[1];
        if (row == -1 && col == -1) {
            return;
        }
        positions.removeAvailablePosition(row, col);
        board.setNumber(row, col, getRandomNumber());
    }

    /**
     * @brief generates a random number which is either 2 or 4
     * @details generates a 2 or 4. The possibility of a 4 being generated is 10%.
     * @return the generated number
     */
    public int getRandomNumber() {
        int random = (int) (Math.random() * 10);
        if (random == 1) {
            return 4;
        }
        return 2;
    }
}
