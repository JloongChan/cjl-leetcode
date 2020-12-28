package com.cjl.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * <p>
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 *
 * @author chenjinlong
 * @date : 2020/12/23
 */
public class Solution0036 {

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            // 横
            if (checkRepeat(board[i])) {
                return false;
            }
            // 竖
            if (checkRepeat(board[0][i],
                    board[1][i],
                    board[2][i],
                    board[3][i],
                    board[4][i],
                    board[5][i],
                    board[6][i],
                    board[7][i],
                    board[8][i]
            )) {
                return false;
            }
            // 正方
            int x = i / 3;
            int y = i % 3;
            if (checkRepeat(board[x * 3][y * 3],
                    board[x * 3][y * 3 + 1],
                    board[x * 3][y * 3 + 2],
                    board[x * 3 + 1][y * 3],
                    board[x * 3 + 1][y * 3 + 1],
                    board[x * 3 + 1][y * 3 + 2],
                    board[x * 3 + 2][y * 3],
                    board[x * 3 + 2][y * 3 + 1],
                    board[x * 3 + 2][y * 3 + 2]
            )) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRepeat(char... chars) {
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (c != '.' && !set.add(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        }));
    }
}
