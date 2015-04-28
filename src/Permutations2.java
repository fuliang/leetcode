import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fuliang on 2015/4/7.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
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
            if (isOk(num, index, k)) {
                swap(num, index, k);
                bt(num, index + 1, permutations);
                swap(num, index, k);
            }
        }
    }

    private  boolean isOk(int[] a, int b,int e){
        if(b < e){
            for(int i = b; i < e; i++){
                if(a[i] == a[e])
                    return false;
            }
        }
        return true;
    }
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations2 permutations = new Permutations2();
        List<List<Integer>> result = permutations.permuteUnique(new int[]{0, 1, 0, 0, 9});
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
