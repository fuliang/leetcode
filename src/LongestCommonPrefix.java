/**
 * Created by Administrator on 2015/4/5.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str0 = strs[0];
            if (str0 == null || str0.length() <= i) {
                return sb.toString();
            }

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str == null || str.length() <= i) {
                    return sb.toString();
                }

                if (str0.charAt(i) != str.charAt(i) ) {
                    return sb.toString();
                }
            }
            sb.append(str0.charAt(i));
            ++i;
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"AAABB", "AAABCC", "AA"};
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
