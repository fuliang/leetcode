/**
 * Created by Administrator on 2015/4/5.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int tmp = x;
        long reverse = 0L;
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        //System.out.println(reverse);
        return reverse == (long)x;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        System.out.println(sol.isPalindrome(1));
    }
}
