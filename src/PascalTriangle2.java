import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/6.
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> curRow = new ArrayList<Integer>();

        curRow.add(1);
        List<Integer> preRow = curRow;
        for (int i = 1; i <= rowIndex; i++) {
            curRow = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                int valJ = (j - 1 >= 0 ? preRow.get(j-1) : 0) + (j < i ?  preRow.get(j) : 0);
                curRow.add(valJ);
            }
            preRow = curRow;
        }
        return curRow;
    }

    public static void main(String[] args) {
        PascalTriangle2 sol = new PascalTriangle2();
        List<Integer> row = sol.getRow(3);
        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
