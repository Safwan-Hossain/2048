///**
// * @file: TestBoard.java
// * @Author: Safwan Hossain, hossam18, 400252391
// * @Date: 4/12/2021
// * @Description: test module for Board.java.
// */
//
//package src;
//
//import model.Board;
//import model.Positions;
//import org.junit.*;
//
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
//public class TestBoard
//{
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testBoard() {
//        Board board = new Board(-1, new Positions(-1));
//    }
//
//    @Test
//    public void testGetScore()
//    {
//
//        int[][] numbers1 = {{4, 0, 0, 0},
//                            {4, 0, 0, 0},
//                            {2, 0, 0, 0},
//                            {2, 0, 2, 0} };
//        int score1 = 12;
//
//        int[][] numbers2 = {{4, 0, 0, 0},
//                            {4, 0, 0, 0},
//                            {0, 0, 0, 0},
//                            {0, 0, 0, 0} };
//        int score2 = 8;
//
//        int[][] numbers3 = {{2, 4, 8, 4},
//                            {2, 4, 8, 8},
//                            {0, 0, 0, 0},
//                            {0, 0, 0, 0} };
//        int score3 = 28;
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.slideAllUp();
//        assertEquals(board.getScore(), score1);
//
//        board.setBoard(numbers2);
//        board.slideAllUp();
//        assertEquals(board.getScore(), score2);
//
//        board.setBoard(numbers3);
//        board.slideAllUp();
//        assertEquals(board.getScore(), score3);
//    }
//
//
//    @Test
//    public void testWasChangeMade()
//    {
//
//        int[][] numbers1 =
//                {{4, 0, 0, 0},
//                {4, 0, 0, 0},
//                {2, 0, 0, 0},
//                {2, 0, 2, 0} };
//
//        int[][] numbers2 =
//                {{4, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {2, 0, 0, 0} };
//
//        int[][] numbers3 =
//                {{2, 4, 8, 4},
//                {4, 8, 4, 2},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0} };
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.slideAllUp();
//        assertTrue(board.wasChangeMade());
//
//        board.setBoard(numbers2);
//        board.slideAllUp();
//        assertTrue(board.wasChangeMade());
//
//        board.setBoard(numbers3);
//        board.slideAllUp();
//        assertFalse(board.wasChangeMade());
//    }
//
//    @Test
//    public void testResetChangeChecker()
//    {
//
//        int[][] numbers1 =
//                {{4, 0, 0, 0},
//                        {4, 0, 0, 0},
//                        {2, 0, 0, 0},
//                        {2, 0, 2, 0} };
//
//        int[][] numbers2 =
//                {{4, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {2, 0, 0, 0} };
//
//        int[][] numbers3 =
//                {{2, 4, 8, 4},
//                        {4, 8, 4, 2},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0} };
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.slideAllUp();
//        board.resetChangeChecker();
//        assertFalse(board.wasChangeMade());
//
//        board.setBoard(numbers2);
//        board.slideAllUp();
//        board.resetChangeChecker();
//        assertFalse(board.wasChangeMade());
//
//        board.setBoard(numbers3);
//        board.slideAllUp();
//        board.resetChangeChecker();
//        assertFalse(board.wasChangeMade());
//    }
//
//
//    @Test
//    public void testGetLargestCurrentNumber()
//    {
//
//        int[][] numbers1 =
//                {{0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {2, 0, 2, 0} };
//
//        int[][] numbers2 =
//                {{2048, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 256, 0, 0},
//                        {2, 0, 0, 0} };
//
//        int[][] numbers3 =
//                {{2, 4, 8, 4},
//                        {4, 8, 4, 2},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0} };
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        assertEquals(board.getLargestCurrentNumber(), 2);
//
//        board.setBoard(numbers2);
//        assertEquals(board.getLargestCurrentNumber(), 2048);
//
//        board.setBoard(numbers3);
//        assertEquals(board.getLargestCurrentNumber(), 8);
//    }
//
//    //NOTE: testing moveIsPossible() also tests canMove()
//    @Test
//    public void testIsMovePossible()
//    {
//
//        int[][] numbers1 =
//                {{0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {2, 0, 2, 0} };
//
//        int[][] numbers2 =
//                {{2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2} };
//
//        int[][] numbers3 =
//                        {{8, 2, 8, 2},
//                         {2, 8, 2, 8},
//                         {8, 2, 8, 2},
//                         {2, 8, 2, 8} };
//
//
//        int[][] numbers4 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 4, 4} };
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        assertTrue(board.isMovePossible());
//
//        board.setBoard(numbers2);
//        assertTrue(board.isMovePossible());
//
//        board.setBoard(numbers3);
//        board.positions.availablePositions = new HashSet<int[]>(0);
//        assertFalse(board.isMovePossible());
//
//        board.setBoard(numbers4);
//        assertTrue(board.isMovePossible());
//    }
//
//    @Test
//    public void testRotate()
//    {
//
//        int[][] numbers1 =
//                        {{2, 0, 0, 0},
//                        {0, 2, 0, 0},
//                        {0, 4, 0, 0},
//                        {0, 0, 8, 0} };
//
//        int[][] numbers1R =
//                {{0, 0, 0, 0},
//                        {0, 0, 0, 8},
//                        {0, 2, 4, 0},
//                        {2, 0, 0, 0} };
//
//        int[][] numbers2 =
//                {{2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2} };
//
//        int[][] numbers3 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 2, 8} };
//
//        int[][] numbers4 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 4, 4} };
//
//        int[][] numbers4R =
//                {{4, 4, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 2, 8} };
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.rotate();
//
//        assertTrue(compareMatrices(numbers1R, board));
//
//        board.setBoard(numbers2);
//        board.rotate();
//        assertTrue(compareMatrices(numbers2, board));
//
//        board.setBoard(numbers3);
//        board.rotate();
//        board.rotate();
//        assertTrue(compareMatrices(numbers3, board));
//
//        board.setBoard(numbers4);
//        board.rotate();
//        board.rotate();
//        assertTrue(compareMatrices(numbers4R, board));
//    }
//
//
//    @Test
//    public void testSlideUp()
//    {
//
//        int[][] numbers1 =
//                {{2, 0, 0, 0},
//                        {0, 2, 0, 0},
//                        {0, 4, 0, 0},
//                        {0, 0, 8, 0} };
//
//        int[][] numbers2 =
//                {{2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2} };
//
//        int[][] numbers2S =
//                {{4, 2, 2, 2},
//                        {0, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2} };
//        int[][] numbers3 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 2, 8} };
//
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.slideUp(0, 0);
//
//        assertTrue(compareMatrices(numbers1, board));
//
//        board.setBoard(numbers2);
//        board.slideUp(1, 0);
//        assertTrue(compareMatrices(numbers2S, board));
//
//        board.setBoard(numbers3);
//        board.slideUp(0, 0);
//        board.slideUp(1, 1);
//        board.slideUp(2, 2);
//        board.slideUp(3, 3);
//        assertTrue(compareMatrices(numbers3, board));
//    }
//
//
//    @Test
//    public void testSlideAllUp()
//    {
//
//        int[][] numbers1 =
//                {{2, 0, 0, 0},
//                        {0, 2, 0, 0},
//                        {0, 4, 0, 0},
//                        {0, 0, 8, 0} };
//
//
//        int[][] numbers1S =
//                {{2, 2, 8, 0},
//                        {0, 4, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0} };
//
//        int[][] numbers2 =
//                {{2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 2} };
//
//        int[][] numbers2S =
//                {{4, 4, 4, 4},
//                        {4, 4, 4, 4},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0} };
//        int[][] numbers3 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 2, 8} };
//
//
//        Board board = new Board(4, new Positions(4));
//        board.setBoard(numbers1);
//        board.slideAllUp();
//        assertTrue(compareMatrices(numbers1S, board));
//
//        board.setBoard(numbers2);
//        board.slideAllUp();
//        assertTrue(compareMatrices(numbers2S, board));
//
//        board.setBoard(numbers3);
//        board.slideAllUp();
//        assertTrue(compareMatrices(numbers3, board));
//    }
//
//    private boolean compareMatrices(int[][] m1, Board board) {
//        for (int i = 0; i < board.getBoardSize(); i++) {
//            for (int j = 0; j < board.getBoardSize(); j++) {
//                if (m1[i][j] != board.getNumber(i, j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
