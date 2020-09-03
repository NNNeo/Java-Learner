package leetcode.dynamicPromgrammint;

import sun.nio.cs.ext.MacHebrew;

/**
 * no leet-code
 *
 *  һ���������� a�� ����sum�� sum(i, j) = a[i] + ... + a[j]
 *  ����������m�� �ҳ�m��i�� j�� ʹ��sum(i1, j1) + ... + sum(im, jm)  ���
 *  eg��-1 4 -2 3 -2 3�� m = 2
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
        // dp[i][j] �� ǰj���Ϊi�ε����ֵ
        // ��һά����ʵ��
        // ���ҳ�һ�Կ�ʼ
        int i, j;
        for (i = 1; i <= m; ++ i) {
            max = Integer.MIN_VALUE;
            //num�еĳ�������Ϊi�� �����Ϊi��
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
