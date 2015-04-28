import java.util.*;

/**
 * Created by fuliang on 2015/4/7.
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)


 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < num.length-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            int low = i + 1;
            int high = num.length - 1;
            while (low < high) {
                if (num[i] + num[low] + num[high] == 0) {
                    result.add(Arrays.asList(num[i], num[low], num[high]));
                    while (low < num.length - 1 && num[low] == num[low+1]) ++low;
                    while (high > 0 && num[high] == num[high-1]) --high;
                    ++low;
                    --high;
                } else if (num[i] + num[low] + num[high] > 0) {
                    --high;
                } else {
                    ++low;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int num[] = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(num);
        for (List<Integer> list : result) {
            for (Integer e : list) {
                System.out.print(e);
                System.out.println(" ");
            }
            System.out.println();
        }
    }
}
