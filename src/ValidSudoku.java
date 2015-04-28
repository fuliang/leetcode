/**
 * Created by Administrator on 2015/4/5.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++) {
            boolean[] isOccur = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (isOccur[c-'1']) {
                    return false;
                } else {
                    isOccur[c-'1'] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] isOccur = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (isOccur[c-'1']) {
                    return false;
                } else {
                    isOccur[c-'1'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] isOccur = new boolean[9];
                for (int k = i; k < i+3; k++) {
                    for (int v = j; v < j+3; v++) {
                        char c = board[k][v];
                        if (c == '.')
                            continue;
                        if (isOccur[c-'1']) {
                            return false;
                        } else {
                            isOccur[c-'1'] = true;
                        }
                    }
                }
            }
        }

        return  true;
    }

    public static void main(String[] args) {
        String[] strBoard = new String[] {
                ".......8.",
                ".......1.",
                ".4..9....",
                ".2.....3.",
                ".8....5..",
                ".........",
                ".6.......",
                "....6....",
                "....3...."
        };

        char[][] board = new char[9][9];
        for (int i = 0; i < strBoard.length; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = strBoard[i].charAt(j);
            }
        }

        ValidSudoku sol = new ValidSudoku();
        System.out.println(sol.isValidSudoku(board));
    }
}
