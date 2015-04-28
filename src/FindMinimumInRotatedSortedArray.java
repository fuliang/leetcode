/**
 * Created by fuliang on 2015/4/8.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num.length == 0)
            return num[0];

        int minIndex = searchRotateIndex(num);
        return num[minIndex];
    }

    //the function just copy from SearchInRotatedSortedArray
    public int searchRotateIndex(int [] A) {
        if (A[0] < A[A.length-1])
            return 0;

        int begin = 0;
        int end = A.length - 1;
        int mid = 0;
        while (begin <= end) {
            mid = (begin + end) / 2;

            if (mid > 0 && mid < A.length-1) {
                if (A[mid] < A[mid-1] && A[mid] < A[mid+1]) {
                    break;
                }
            }

            if (A[mid] < A[0]) {
                end = mid-1;
            } else {
                begin = mid + 1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
        int min = sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }
}
