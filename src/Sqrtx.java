/**
 * Created by fuliang on 2015/4/18.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int start = 0;
        int end = x/2 + 1;

        while (start <= end) {
            int mid = start + (end - start)  / 2;

            if (mid == 0) {
                start = mid + 1;
                continue;
            }
            //long ex = mid * mid;
            int div = x / mid;
            if (div == mid) {
                return mid;
            } else if(div > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static void test(int x) {
        Sqrtx sqrtx = new Sqrtx();
        int sqrt = sqrtx.mySqrt(x);
        System.out.println(sqrt);
    }

    public static void main(String[] args) {
        test(1);
        test(4);
        test(3);
        test(5);
    }
}
