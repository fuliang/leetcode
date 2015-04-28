/**
 * Created by Administrator on 2015/4/6.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1)
            return true;

        int i = 0, j = s.length()-1;

        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (i >= j) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        String s = "1a2";
        System.out.println(sol.isPalindrome(s));
    }
}
