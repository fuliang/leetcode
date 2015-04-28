import java.util.Arrays;

/**
 * Created by Administrator on 2015/4/5.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int i = digits.length - 1;
        int addNext = 1;
        while (i >= 0) {
            int digit = digits[i];
            int sum = digit + addNext;
            addNext = sum / 10;
            result[i] = sum % 10;
            i--;
        }

        if (addNext > 0) {
            int[] newResult = new int[digits.length + 1];
            System.arraycopy(result, 0, newResult, 1, digits.length);
            newResult[0] = addNext;
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9, 9, 9})));
    }
}
