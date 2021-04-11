import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    final int boardSize = 4;
    // [row][column]
    int[][] numbers = new int[4][4];
    ArrayList<int[]> availablePositions = new ArrayList<>();
    int availableSize;
    int score = 0;
    boolean isRunning;

    public Game() {
        this.isRunning = true;
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                this.addAvailablePosition(i, j);
            }
        }
        this.availableSize = 16;
        this.pushRandomNumber();
        this.pushRandomNumber();
        this.printBoard();
    }

    public void up() {
        this.forceUp();
        System.out.println("up");

        this.printBoard();
        this.pushRandomNumber();
        System.out.println("after random insert");
        this.printBoard();
    }

    public void right() {
        this.rotate(1);
        this.forceUp();
        this.rotate(3);
        System.out.println("right");

        this.printBoard();
        this.pushRandomNumber();
        System.out.println("after random insert");
        this.printBoard();
    }

    public void down() {
        this.rotate(2);
        this.forceUp();
        this.rotate(2);
        System.out.println("down");

        this.printBoard();
        this.pushRandomNumber();
        System.out.println("after random insert");
        this.printBoard();
    }

    public void left() {
        this.rotate(3);
        this.forceUp();
        this.rotate(1);
        System.out.println("left");

        this.printBoard();
        this.pushRandomNumber();
        System.out.println("after random insert");
        this.printBoard();
    }


    // rotates 90 ccw
    public void rotate(int times) {
        for (int i = 0; i < times; i++) {
            int[][] newNumbers = new int[this.boardSize][this.boardSize];
            for (int row = 0; row < this.boardSize; row++) {
                for (int col = 0; col < this.boardSize; col++) {
                    newNumbers[row][col] = this.getNumber(col, this.boardSize - 1 - row);
                }
            }
            this.numbers = newNumbers;
        }
    }

    public void forceUp() {
        for (int row = 1; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (this.getNumber(row, col) != 0) {
                    this.floatUp(row, col);
                }
            }
        }
    }

    public void floatUp(int row, int col) {
        int num = getNumber(row, col);
        int prevRow = row - 1;

        while(prevRow >= 0) {
            int prevNum = getNumber(prevRow, col);
            if (num == prevNum) {
                this.setNumber(prevRow, col, num * 2);
                this.setNumber(row, col, 0);
                this.addAvailablePosition(row, col);
                break;
            }
            else if (prevNum == 0) {
                if (prevRow == 0) {
                    this.setNumber(prevRow, col, num);
                    this.setNumber(row, col, 0);
                    this.removeAvailablePosition(prevRow, col);
                    this.addAvailablePosition(row, col);
                    break;
                }
                prevRow--;
            }
            else {
                this.setNumber(prevRow + 1, col, num);
                this.setNumber(row, col, 0);
                this.removeAvailablePosition(prevRow + 1, col);
                this.addAvailablePosition(row, col);
                break;
            }
        }
    }

    public void setNumber(int row, int column, int number) {
        this.numbers[row][column] = number;
    }

    public int getNumber(int row, int column) {
        return this.numbers[row][column];
    }

    public boolean hasOpenPosition() {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (this.getNumber(i, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pushRandomNumber() {
        int[] pos = this.getRandomPosition();
        this.numbers[pos[0]][pos[1]] = getRandomNumber();

    }

    public int getRandomNumber() {
        int random = (int) (Math.random() * 10);
        if (random == 1) {
            return 4;
        }
        return 2;
    }

    public void addAvailablePosition(int row, int col) {
        this.availablePositions.add(new int[] {row, col});
        this.availableSize++;
    }

    public void removeAvailablePosition(int row, int col) {
        for (int i = 0; i < this.availableSize; i++) {
            int[] position = this.availablePositions.get(i);
            if (position[0] == row && position[1] == col) {
                this.availablePositions.remove(i);
                this.availableSize--;
            }
        }
    }

    public int[] numToPosition(int num) {
        int row = num / this.boardSize;
        int column = num % this.boardSize;
        return new int[] {row, column};
    }

    public int[] getRandomPosition() {
        while(true) {
            int row = (int) (Math.random() * this.boardSize);
            int column = (int) (Math.random() * this.boardSize);
            if (this.getNumber(row, column) == 0) {
                return new int[] {row, column};
            }
        }
//        int random = (int) (Math.random() * this.availableSize);
//        this.availableSize--;
//        return this.availablePositions.remove(random);
    }

    public void printBoard() {
        System.out.println("============");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(this.numbers[i]));
        }
        System.out.println("============");
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.up();
        g.right();
        g.right();
        g.down();
    }

}
