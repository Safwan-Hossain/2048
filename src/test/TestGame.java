///**
// * @file: TestGame.java
// * @Author: Safwan Hossain, hossam18, 400252391
// * @Date: 4/12/2021
// * @Description: tests module for Game.java.
// */
//
//package src;
//
//import enumeration.Move;
//import model.Board;
//import model.Game;
//import org.junit.*;
//
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
//public class TestGame
//{
//
//
//    @Test
//    public void testMove()
//    {
//        int[][] numbers1 =
//                        {{4, 0, 0, 0},
//                        {4, 0, 0, 0},
//                        {2, 0, 0, 0},
//                        {2, 0, 2, 0} };
//
//        int[][] numbers1L =
//                {{4, 0, 0, 0},
//                        {4, 0, 0, 0},
//                        {2, 0, 0, 0},
//                        {4, 0, 0, 0} };
//
//        int[][] numbers1D =
//                {{0, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {8, 0, 0, 0},
//                        {4, 0, 2, 0} };
//
//        int[][] numbers1U =
//                {{8, 0, 2, 0},
//                        {4, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0} };
//
//        int[][] numbers1R =
//                {{0, 0, 0, 4},
//                        {0, 0, 0, 4},
//                        {0, 0, 0, 2},
//                        {0, 0, 0, 4} };
//
//        int[][] numbers2 =
//                        {{4, 4, 4, 4},
//                        {0, 4, 4, 4},
//                        {0, 0, 0, 0},
//                        {2, 0, 0, 0} };
//
//
//        int[][] numbers2L =
//                {{8, 8, 0, 0},
//                        {8, 4, 0, 0},
//                        {0, 0, 0, 0},
//                        {2, 0, 0, 0} };
//
//
//        Game game = new Game(4, 0);
//        game.getBoard().setBoard(numbers1);
//        game.move(Move.up);
//        assertTrue(compareMatrices(numbers1U, game.getBoard()));
//
//        numbers1 = new int[][]{{4, 0, 0, 0},
//                {4, 0, 0, 0},
//                {2, 0, 0, 0},
//                {2, 0, 2, 0}};
//
//        game.getBoard().setBoard(numbers1);
//        game.move(Move.left);
//        assertTrue(compareMatrices(numbers1L, game.getBoard()));
//
//        numbers1 = new int[][]{{4, 0, 0, 0},
//                {4, 0, 0, 0},
//                {2, 0, 0, 0},
//                {2, 0, 2, 0}};
//
//        game.getBoard().setBoard(numbers1);
//        game.move(Move.down);
//        assertTrue(compareMatrices(numbers1D, game.getBoard()));
//
//        numbers1 = new int[][]{{4, 0, 0, 0},
//                {4, 0, 0, 0},
//                {2, 0, 0, 0},
//                {2, 0, 2, 0}};
//
//        game.getBoard().setBoard(numbers1);
//        game.move(Move.right);
//        assertTrue(compareMatrices(numbers1R, game.getBoard()));
//
//        game.getBoard().setBoard(numbers2);
//        game.move(Move.left);
//        assertTrue(compareMatrices(numbers2L, game.getBoard()));
//    }
//
//    @Test
//    public void testRotate()
//    {
//        int[][] num = {{0, 2, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 0, 2},
//                        {2, 2, 2, 2} };
//
//        int[][] num1 = {{2, 2, 2, 2},
//                        {2, 2, 0, 2},
//                        {2, 2, 2, 2},
//                        {0, 2, 2, 2} };
//
//
//        int[][] num2 = {{2, 2, 2, 2},
//                        {2, 0, 2, 2},
//                        {2, 2, 2, 2},
//                        {2, 2, 2, 0} };
//
//        int[][] num3 = {{2, 2, 2, 0},
//                {2, 2, 2, 2},
//                {2, 0, 2, 2},
//                {2, 2, 2, 2} };
//
//        Game game = new Game(4, 1);
//        game.getBoard().setBoard(num);
//        game.rotateGame(1);
//        assertTrue(compareMatrices(num1, game.getBoard()));
//
//        game.getBoard().setBoard(num);
//        game.rotateGame(2);
//        assertTrue(compareMatrices(num2, game.getBoard()));
//
//        game.getBoard().setBoard(num);
//        game.rotateGame(3);
//        assertTrue(compareMatrices(num3, game.getBoard()));
//
//        game = new Game(4, 1);
//        game.getBoard().positions.availablePositions = new HashSet<>();
//        game.getBoard().positions.availablePositions.add(new int[]{1, 1});
//        game.getBoard().positions.availablePositions.add(new int[]{2, 3});
//        game.rotateGame(1);
//        game.getBoard().positions.removeAvailablePosition(2, 1);
//        game.getBoard().positions.removeAvailablePosition(0, 2);
//        System.out.println(game.getBoard().positions.availablePositions.size());
//        assertTrue(game.getBoard().positions.availablePositions.size() == 0);
//    }
//
//    @Test
//    public void testIsMovePossible()
//    {
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
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 2, 8} };
//
//
//        int[][] numbers4 =
//                {{8, 2, 8, 2},
//                        {2, 8, 2, 8},
//                        {8, 2, 8, 2},
//                        {2, 8, 4, 4} };
//        Game game = new Game(4,1);
//        game.getBoard().setBoard(numbers1);
//        assertTrue(game.isMovePossible());
//
//        game.getBoard().setBoard(numbers2);
//        assertTrue(game.isMovePossible());
//
//        game.getBoard().setBoard(numbers3);
//        game.getBoard().positions.availablePositions = new HashSet<int[]>(0);
//        assertFalse(game.isMovePossible());
//
//        game.getBoard().setBoard(numbers4);
//        assertTrue(game.isMovePossible());
//    }
//
//    @Test
//    public void testPushRandomNumber()
//    {
//
//        Game game = new Game(4, 0);
//
//        game.move(Move.up);
//        int[][] numbers1U = cloneMatrix(game.getBoard());
//        game.pushRandomNumber();
//        assertFalse(compareMatrices(numbers1U, game.getBoard()));
//
//        game.move(Move.left);
//        int[][] numbers1L = cloneMatrix(game.getBoard());
//        game.pushRandomNumber();
//        assertFalse(compareMatrices(numbers1L, game.getBoard()));
//
//        game.move(Move.down);
//        int[][] numbers1D = cloneMatrix(game.getBoard());
//        game.pushRandomNumber();
//        assertFalse(compareMatrices(numbers1D, game.getBoard()));
//
//
//        game.move(Move.right);
//        int[][] numbers1 = cloneMatrix(game.getBoard());
//        assertTrue(compareMatrices(numbers1, game.getBoard()));
//
//    }
//
//
//    @Test
//    public void testGetRandomNumber()
//    {
//        boolean works = true;
//        Game game = new Game(4, 1);
//        for (int i = 0; i < 250; i++) {
//            int num = game.getRandomNumber();
//            if (num != 2 && num != 4) {
//                works = false;
//            }
//        }
//
//        assertTrue(works);
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
//
//
//    private int[][] cloneMatrix(Board board) {
//        int[][] m = new int[board.getBoardSize()][board.getBoardSize()];
//        for (int i = 0; i < board.getBoardSize(); i++) {
//            for (int j = 0; j < board.getBoardSize(); j++) {
//                m[i][j] = board.getNumber(i, j);
//            }
//        }
//        return m;
//    }
//}
