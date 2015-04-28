/**
 * Created by Administrator on 2015/4/5.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int num = Math.abs(x);
        long rnum = 0L;
        while (num > 0) {
            rnum *= 10;
            rnum += num % 10;
            num = num / 10;
        }

        if (rnum > Integer.MAX_VALUE)
            return 0;

        return (int)(x < 0 ? -rnum: rnum);
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        System.out.println(sol.reverse(-123));
        //System.out.println(Integer.MAX_VALUE);
    }
}
