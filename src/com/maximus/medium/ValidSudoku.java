package com.maximus.medium;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] lines = new boolean[10][9];
        boolean[][] boxes = new boolean[9][10];
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                int b = board[i][j] - '0';
                if(b >= 0 && b <= 9) {
                    if (rows[i][b]) {
                        return false;
                    }
                    if (lines[b][j]) {
                        return false;
                    }
                    int box = (i / 3) * 3 + j / 3;
                    if (boxes[box][b]) {
                        return false;
                    }
                    rows[i][b] = true;
                    lines[b][j] = true;
                    boxes[box][b] = true;
                }
            }
        }
        return true;
    }
}
