/**
 * Created by Administrator on 2015/4/6.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int fi_2 = 1, fi_1 = 2;
        if (n == 1) {
            return fi_2;
        }

        if (n == 2) {
            return fi_1;
        }

        for (int i = 2; i < n; i++) {
            int fi = fi_1 + fi_2;
            fi_2 = fi_1;
            fi_1 = fi;
        }

        return fi_1;
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(5));
    }
}
