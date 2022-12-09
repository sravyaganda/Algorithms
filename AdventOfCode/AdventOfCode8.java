package AdventOfCode;

import java.util.List;

public class AdventOfCode8 {

    public static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        List<String> input = ReadInput.readAOC8();
        int[][] grid = getGrid(input);
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int totalCount = 2 * (rowLen) + 2 * (rowLen - 2);
        //  System.out.println(totalCount);
        //  System.out.println(getTreeCount(grid) + totalCount);
        System.out.println(getMaxHeight(grid));
    }

    public static int[][] getGrid(List<String> input) {
        int[][] grid = new int[input.get(0).length()][input.size()];
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        return grid;
    }


    public static int getMaxHeight(int[][] grid) {
        int maxHeight = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    continue;
                }
                int count = 1;
                for (int d = 0; d < directions.length; d++) {

                   // System.out.println("CurrentCell" + " - " + grid[i][j]);
                    //System.out.println("Height" + " - " + dfs2(grid, new int[]{i, j}, directions[d], grid[i][j], 0));
                   count *= dfs2(grid, new int[]{i, j}, directions[d], grid[i][j], 0);
                   // System.out.println(count);
                }
                maxHeight = Math.max(count, maxHeight);
            }
        }

        return maxHeight;

    }

    public static int dfs2(int[][] grid, int[] currentCell, int[] newCell, int value, int treeHeight) {
        if (currentCell[0] < 0 || currentCell[1] < 0 || currentCell[0] >= grid.length || currentCell[1] >= grid[0].length) {
            return treeHeight;
        }

        int newRow = currentCell[0] + newCell[0];
        int newCol = currentCell[1] + newCell[1];
        if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {

          //  System.out.println(grid[newRow][newCol]);
            if (grid[newRow][newCol] < value) {

             return dfs2(grid, new int[]{newRow, newCol}, newCell, value, treeHeight+1);
            }

            if(grid[newRow][newCol] >= value)
            {
                return treeHeight+1;
            }
        }
        return treeHeight;
    }


    public static int getTreeCount(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    continue;
                }
                int trees = 0;
                for (int d = 0; d < directions.length; d++) {
                    int newRow = i + directions[d][0];
                    int newCol = i + directions[d][1];

                    if (dfs(grid, new int[]{i, j}, directions[d], grid[i][j])) {
                        System.out.println("true");
                        trees++;
                    }
                }
                if (trees >= 1) {
                    count++;
                }

            }
        }
        return count;
    }

    public static boolean dfs(int[][] grid, int[] currentCell, int[] newCell, int value) {
        if (currentCell[0] < 0 || currentCell[1] < 0 || currentCell[0] >= grid.length || currentCell[1] >= grid[0].length) {
            return true;
        }

        int newRow = currentCell[0] + newCell[0];
        int newCol = currentCell[1] + newCell[1];
        boolean result = true;
        if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {

            System.out.println(grid[newRow][newCol]);
            if (grid[newRow][newCol] >= value) {
                result = false;
            } else {
                result = dfs(grid, new int[]{newRow, newCol}, newCell, value);
            }
        }
        return result;
    }
}
