package ArraysandStrings;

import java.util.Arrays;

public class SequenceGame {


    private static int row;
    private static int col;
    private static int[][] directions = {{1, 1}, {0, 1}, {1, 0}, {1, -1}};
    //, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}

    public static void main(String[] args) {

        char player = 'b';
        char[][] board = {{'0', '0', '0', '0', 'b', '0', '0', '0'}
                , {'0', '0', '0', '0', 'b', '0', '0', '0',},
                {'0', '0', '0', '0', 'b', '0', '0', '0'},
                {'0', '0', '0', '0', 'b', '0', '0', '0'},
                {'0', '0', '0', '0', 'b', '0', '0', 'b'},
                {'0', '0', '0', '0', '0', 'b', '0', 'b',},
                {'0', '0', '0', '0', '0', '0', 'b', 'b'},
                {'0', '0', '0', '0', '0', '0', '0', 'b'}
        };
        System.out.println(checkSequenceCount(board, player));
    }

    public static int checkSequenceCount(char[][] board, char player) {

        row = board.length;
        col = board[0].length;
        if (board == null || row == 0 || col == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        boolean cornerCell = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 && j == 0) || (i == row - 1 && j == col - 1) || (i == 0 && j == col - 1) || (i == row - 1 && j == 0)) {
                    cornerCell = true;
                }
                if (board[i][j] == player) {
                    for (int[] direction : directions) {
                        int[] newCell = new int[]{i + direction[0], j + direction[1]};
                        if (newCell[0] >= 0 && newCell[1] >= 0 && newCell[0] < row && newCell[1] < col && !visited[newCell[0]][newCell[1]]
                                && dfs(cornerCell, board, visited, 2, newCell, direction, player)) {
                            count++;
                        }
                    }
                }
                cornerCell = false;
            }
        }
        return count;
    }

    //seqCount : seq Counter of each cell
    public static boolean dfs(boolean cornerCell, char[][] board, boolean[][] visited, int seqCount, int[] cell, int[] direction, char player) {
        if (cell[0] < 0 || cell[1] < 0 || cell[0] >= row || cell[1] >= col || board[cell[0]][cell[1]] != player) {
            return false;
        }
        if ((seqCount == 5 && !cornerCell) || (seqCount==4 && cornerCell)|| (seqCount == 4 && checkIfCornerCell(cell[0], cell[1]))) {
            return true;
        }
        visited[cell[0]][cell[1]] = true;
        int[] newCell = new int[]{cell[0] + direction[0], cell[1] + direction[1]};
        boolean seqFound = dfs(cornerCell, board, visited, seqCount + 1, newCell, direction, player);
        if (!seqFound) {
            visited[cell[0]][cell[1]] = false;
        }
        return seqFound;
    }

    public static boolean checkIfCornerCell(int i, int j) {
        if ((i == 0 && j == 0) || (i == row - 1 && j == col - 1) || (i == 0 && j == col - 1) || (i == row - 1 && j == 0)) {
            return true;
        }
        return false;
    }
}
