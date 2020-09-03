package leetcode;

import java.util.Arrays;

/**
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * 链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values
 */
public class MctFromLeafValues {

    public static void main(String[] args) {
        System.out.println(new MctFromLeafValues().mctFromLeafValues(new int[]{6 , 2, 4}));
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] max = new int[n][n];

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; ++ j) {
            int m = arr[j];
            for (int i = j; i >= 0; -- i) {
                m = Math.max(m, arr[i]);
                max[i][j] = m;
            }
        }

        // dp[i][j] 是 arr[i:j] 组成的最小代价生成树
        for (int j = 0; j < n; ++ j) {
            for (int i = j; i >= 0; -- i) {
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; ++ k) {
                    min = Math.min(min, dp[i][k] + dp[k+1][j] + max[i][k] * max[k+1][j]);
                    dp[i][j] = min;
                }

            }
        }
        return dp[0][n-1];

    }


}
