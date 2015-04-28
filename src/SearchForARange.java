import java.util.Arrays;

/**
 * Created by fuliang on 2015/4/7.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {

        int beginIndex = Arrays.binarySearch(A, target);
        if (beginIndex <= 0) {
            return new int[]{-1, -1};
        } else {
            int larger = target + 1;
            int endIndex = Arrays.binarySearch(A, larger);
            if (endIndex < 0) {
                return new int[]{beginIndex, -endIndex-1};
            } else {
                return new int[]{beginIndex, endIndex-1};
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        SearchForARange sol = new SearchForARange();
        int[] rangeIndex = sol.searchRange(nums, 8);
        for (int index : rangeIndex) {
            System.out.println(index);
        }
    }
}
