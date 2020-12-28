package com.cjl.leetcode;

/**
 * 37. Sudoku Solver
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * Example 1:
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 *
 * @author chenjinlong
 * @date : 2020/12/28
 */
public class Solution0037 {

    public void solveSudoku(char[][] board) {
        // 第一次循环得到需要填充的个数及对应可能的值
        solve(board);
        return;
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isPick(board, i, j, c)) {
                            // 匹配成功
                            board[i][j] = c;
                            // 递归匹配直到返回true
                            if (solve(board)) {
                                return true;
                            }
                        }
                    }
                    // 走到这一步说明前面匹配的值不符合，错需返回false重新选择
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPick(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            // 校验行
            if (board[row][i] == c) {
                return false;
            }
            // 校验列
            if (board[i][col] == c) {
                return false;
            }
            // 校验方格
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

}
