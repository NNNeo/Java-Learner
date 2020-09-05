package leetcode.dynamicPromgramming;

/**
 * 给出整数数组 A，将该数组分隔为长度
 * 最多为 K 的
 * 几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值
 */
public class MaxSumAfterPartitioning {

    public static void main(String[] args) {
        System.out.println(new MaxSumAfterPartitioning().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++ i) {
            int max = arr[i];
            // i -> i - k + 1
            for (int j = 1; j <= k && i - j + 1 >= 0; ++ j) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], j * max + ((i - j) > 0 ? dp[i-j] : 0));
            }
        }
        return dp[n-1];
    }
}
