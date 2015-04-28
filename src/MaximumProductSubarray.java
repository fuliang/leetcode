/**
 * Created by fuliang on 2015/4/11.
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int maxPro = A[0];
        int preMax = A[0], preMin = A[0];
        int curMax, curMin;

        for (int i = 1; i < A.length; i++) {
            curMax = Math.max(Math.max(preMax * A[i], preMin * A[i]), A[i]);
            curMin = Math.min(Math.min(preMax * A[i], preMin * A[i]), A[i]);
            maxPro = Math.max(maxPro, curMax);
            preMax = curMax;
            preMin = curMin;
        }

        return maxPro;
    }

    public static void main(String[] args) {
        int[] prod = new int[]{1,2,-1,3,-1,1};
        MaximumProductSubarray sol = new MaximumProductSubarray();
        System.out.println(sol.maxProduct(prod));
    }
}
