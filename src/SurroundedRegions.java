import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fuliang on 2015/4/19.
 * **********************************************************************************
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *
 **********************************************************************************
 */

public class SurroundedRegions {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        int nRow = board.length;
        int nCol = board[0].length;

        Queue<Point> queue = new LinkedList<Point>();

        for(int i = 0; i < nRow; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'M';
                queue.offer(new Point(i, 0));
            }

            if (board[i][nCol-1] == 'O') {
                board[i][nCol-1] = 'M';
                queue.offer(new Point(i, nCol-1));
            }
        }

        for (int j = 0; j < nCol; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'M';
                queue.offer(new Point(0, j));
            }

            if (board[nRow-1][j] == 'O') {
                board[nRow-1][j] = 'M';
                queue.offer(new Point(nRow-1, j));
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x - 1 >= 0 && board[p.x - 1][p.y] == 'O') {
                board[p.x - 1][p.y] = 'M';
                queue.offer(new Point(p.x-1, p.y));
            }

            if (p.x + 1 < board.length && board[p.x + 1][p.y] == 'O') {
                board[p.x+1][p.y] = 'M';
                queue.offer(new Point(p.x + 1, p.y));
            }

            if (p.y - 1 >= 0 && board[p.x][p.y-1] == 'O') {
                board[p.x][p.y-1] = 'M';
                queue.offer(new Point(p.x, p.y-1));
            }

            if (p.y + 1 < board[0].length && board[p.x][p.y+1] == 'O') {
                board[p.x][p.y + 1] = 'M';
                queue.offer(new Point(p.x, p.y+1));
            }
        }

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    public static void test(char[][] board) {
        SurroundedRegions sol = new SurroundedRegions();
        sol.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test(new char[][]{
                {'X','X', 'X', 'X'},
                {'X','O', 'O', 'X'},
                {'X','X', 'O', 'X'},
                {'X','O', 'X', 'X'}
        });

        test(new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        });
    }
}
