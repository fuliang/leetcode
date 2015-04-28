/**
 * Created by fuliang on 2015/4/9.
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has
 * a certain amount of money stashed, the only constraint stopping you from robbing
 * each of them is that adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 */

public class HouseRobber {
    /**
     * Dynamic programming
     *
     * dp[i] = max {dp[i-1], dp[i-2] + num[i]}
     * dp[0] = num[0]
     * dp[1] = max{num[0], num[1]}
     * @param num
     * @return
     */
    public int rob(int[] num) {
        if (num.length == 0)
            return 0;

        if (num.length == 1)
            return num[0];

        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);

        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + num[i]);
        }

        return dp[num.length - 1];
    }

    public int rob2(int[] num) {
        if (num.length == 0)
            return 0;

        if (num.length == 1)
            return num[0];

        int m = num[0], n = Math.max(num[0], num[1]);
        int r = n;
        for (int i = 2; i < num.length; i++) {
            r = Math.max(n, m + num[i]);
            m = n;
            n = r;
        }
        return r;
    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        System.out.println(sol.rob2(new int[]{1,2,1,1,5}));
    }
}
