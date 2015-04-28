/**
 * Created by Administrator on 2015/4/5.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int eIndex = 0;
        int i = 0;

        while (i < A.length) {
            while (i < A.length && A[i] != elem) {
                A[eIndex++] = A[i++];
            }
            while (i < A.length && A[i] == elem) {
                ++i;
            }
        }
        return eIndex;
    }

    public static void main(String[] args) {
        RemoveElement sol = new RemoveElement();
        int[] a = {};
        int len = sol.removeElement(a, 1);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}