/**
 * Created by fuliang on 2015/4/11.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }

    private static void printTest(int[] A) {
        SingleNumber sol = new SingleNumber();
        System.out.println(sol.singleNumber(A));
    }
    public static void main(String[] args) {
        printTest(new int[]{1,2,2,3,1});
    }
}
