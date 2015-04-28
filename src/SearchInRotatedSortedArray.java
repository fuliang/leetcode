import java.util.Arrays;

/**
 * Created by fuliang on 2015/4/7.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return A[0] == target ? 0 : -1;
        }

        int rotateIndex = searchRotateIndex(A);
        int index = Arrays.binarySearch(A, 0, rotateIndex, target);
        if (index < 0) {
            index = Arrays.binarySearch(A, rotateIndex, A.length, target);
        }
        return index < 0 ? -1 : index;
    }

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
        int[] a = new int[] {1,3};
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int index = sol.search(a, 2);
        System.out.println(index);
    }
}
