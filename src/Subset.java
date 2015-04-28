import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/4/6.
 */
public class Subset {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return result;
        }

        Arrays.sort(S);
        bt(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void bt(int[] S, int index, List<Integer> list, List<List<Integer>> result) {
        if (index == S.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        list.add(S[index]);
        bt(S, index + 1, list, result);
        list.remove(list.size()-1);
        bt(S, index + 1, list, result);
    }

    public static void main(String[] args) {
        Subset sol = new Subset();
        List<List<Integer>> result = sol.subsets(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
