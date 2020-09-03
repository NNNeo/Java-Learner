package leetcode.dynamicPromgramming;

/**
 *
 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。

 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。

 返回多边形进行三角剖分后可以得到的最低分。
 */
public class MinScoreTriangulation {


    public static void main(String[] args) {
        System.out.println(new MinScoreTriangulation().minScoreTriangulation(new int[]{1,3,1,4,1,5}));
    }

    public int minScoreTriangulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];

        // 三角形边长为3，遍历长度至少为3
        for (int len = 3; len <= n; ++ len) {
            // 起点遍历范围
            for (int i = 0; i <= n - len; ++ i) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++ k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + a[k] * a[i] * a[j]);
                }
            }

        }
        return dp[0][n-1];
    }

}
