/**
 * Created by Administrator on 2015/4/5.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0 || A.length == 1)
            return A.length;

        int eIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[eIndex]) {
                A[++eIndex] = A[i];
            }
        }
        return eIndex + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
        int[] a = new int[]{1,1};
        int len = sol.removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}
