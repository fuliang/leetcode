import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/6.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return triangle;

        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = triangle.get(i-1);

            List<Integer> curRow = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                 int valJ = (j - 1 >= 0 ? preRow.get(j-1) : 0) + (j < i ?  preRow.get(j) : 0);
                curRow.add(valJ);
            }
            triangle.add(curRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();
        List<List<Integer>> result = sol.generate(2);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
