/**
 * Created by Administrator on 2015/4/6.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int eIndex = m + n -1;
        int i = m-1;
        int j = n-1;

        while (i >=0 && j >= 0) {
            if (A[i] > B[j]) {
                A[eIndex--] = A[i--];
            } else {
                A[eIndex--] = B[j--];
            }
        }

        while (i >= 0) {
            A[eIndex--] = A[i--];
        }

        while (j >= 0) {
            A[eIndex--] = B[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int A[] = new int[10];
        int j = 0;
        for (int i = 1; i <= 9; i+= 2) {
            A[j++] = i;
        }
        int B[] = new int[]{2,4,6,8, 10};
        m.merge(A, 5, B, 5);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
