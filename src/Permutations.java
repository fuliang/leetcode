import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuliang on 2015/4/7.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        bt(num, 0, permutations);
        return permutations;
    }

    private void bt(int[] num, int index, List<List<Integer>> permutations) {
        if (index == num.length) {
            List<Integer> permutation = new ArrayList<Integer>();
            for (int i : num) {
                permutation.add(i);
            }
            permutations.add(permutation);
            return;
        }

        for (int k = index; k < num.length; k++) {
            swap(num, index, k);
            bt(num, index + 1, permutations);
            swap(num, index, k);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(new int[]{1, 2, 3});
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
