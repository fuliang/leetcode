/**
 * Created by fuliang on 2015/4/11.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int begin = 0;
        int end = num.length - 1;

        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if ((mid == 0 || num[mid] > num[mid - 1]) && (mid == num.length - 1 ||  num[mid] > num[mid + 1])) {
                return mid;
            }

            if (mid > 0 && num[mid-1] > num[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return begin;
    }

    private static void printTestCase(int[] nums) {
        FindPeakElement sol = new FindPeakElement();
        int result = sol.findPeakElement(nums);
        System.out.println(result);
    }

    public static void main(String[] args) {
        printTestCase(new int[] {1,2,3,1});
        printTestCase(new int[]{1,2,3,4});
        printTestCase(new int[]{3,2});
        printTestCase(new int[]{1,2,1,2,3,1});
    }
}
