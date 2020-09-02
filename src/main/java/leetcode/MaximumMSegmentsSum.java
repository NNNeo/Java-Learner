package leetcode;

import sun.nio.cs.ext.MacHebrew;

/**
 * no leet-code
 *
 *  一个整数序列 a， 定义sum， sum(i, j) = a[i] + ... + a[j]
 *  给出正整数m， 找出m对i， j， 使得sum(i1, j1) + ... + sum(im, jm)  最大
 *  eg：-1 4 -2 3 -2 3， m = 2
 *
 */
public class MaximumMSegmentsSum {

    public static void main(String[] args) {
        System.out.println(mmss(new int[] {-1, 4, -2, 3, -2, 3},2));
//        System.out.println(mmss(new int[] {1, 2, 3}, 1));
    }

    private static int mmss(int[] num1, int m) {
        int n = num1.length;
        int[] dp = new int[n+1];

        int[] pre = new int[n+1];
        int[] num = new int[n+1];
        System.arraycopy(num1, 0, num, 1, n);
        int max = Integer.MIN_VALUE;
        dp[0] = max;
        // dp[i][j] ： 前j项分为i段的最大值
        // 用一维数组实现
        // 从找出一对开始
        int i, j;
        for (i = 1; i <= m; ++ i) {
            max = Integer.MIN_VALUE;
            //num中的长度至少为i， 满足分为i段
            for (j = i; j <= n; ++ j) {
                dp[j] = Math.max(dp[j-1], pre[j-1]) + num[j];
                pre[j-1] = max;
                max = Math.max(max, dp[j]);
            }
//            pre[j-1] = max;
        }

        return max;
    }

}
