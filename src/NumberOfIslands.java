/**
 * Created by fuliang on 2015/4/9.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    flood(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void flood(char[][] grid,  int i, int j) {
        grid[i][j] = '0';
        if (i + 1 < grid.length && grid[i+1][j] == '1') {
            flood(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i-1][j] == '1') {
            flood(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j-1] == '1') {
            flood(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            flood(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1'}
                /*{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}*/
        };

        NumberOfIslands sol = new NumberOfIslands();
        int count = sol.numIslands(grid);
        System.out.println(count);
    }
}
