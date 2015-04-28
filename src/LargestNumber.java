import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fuliang on 2015/4/9.
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Credits:Special thanks to @ts for adding this problem and creating all test cases.
 *
 */

public class LargestNumber {
    public String largestNumber(int[] num) {
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strs[i] = Integer.toString(num[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });

        if (strs[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber sol = new LargestNumber();
        String result = sol.largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(result);
    }
}
