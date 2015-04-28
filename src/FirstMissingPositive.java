/**
 * Created by fuliang on 2015/4/7.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;

        if (A.length == 1) {
            return A[0] != 1 ? 1 : 2;
        }

        int tmp, swapIndex;
        for (int i = A.length-1; i >=0; ) {
            if (A[i] > 0 && A[i] != i+1) {
                if (A[i] > A.length - 1) {
                    swapIndex = A.length-1;
                    A[swapIndex] = -1;
                } else {
                    swapIndex = A[i]-1;
                }

                if (A[i] == A[swapIndex]) {
                    i--;
                } else {
                    tmp = A[i];
                    A[i] = A[swapIndex];
                    A[swapIndex] = tmp;
                }
            } else {
                i--;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive sol = new FirstMissingPositive();
        int result = sol.firstMissingPositive(new int[]{1,2,2, -1, 4, -3});
        System.out.println(result);
    }
}
