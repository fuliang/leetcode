/**
 * Created by fuliang on 2015/4/22.
 */
public class PowXN {
    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        int N = Math.abs(n);
        double result = powxn(x, N);
        return n >= 0 ? result : 1 / result;
    }

    public double powxn(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;

        double m = powxn(x, n/2);
        if (n % 2 == 0) return m * m;
        else return m * m * x;
    }

    public static void test(double x, int n) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.pow(x, n));
    }

    public static void main(String[] args) {
        test(2,2);
        test(2,3);
        test(2, -2);
        test(3, -2);
        test(0, 1);
    }
}
