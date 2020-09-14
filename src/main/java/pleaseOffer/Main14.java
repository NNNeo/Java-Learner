package pleaseOffer;

import java.util.HashMap;
import java.util.Scanner;

public class Main14 {

    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); // 小于等于k
        int d = sc.nextInt(); // 最大值 > d

        int[][][] dp = new int[n][k][d];

        // 和
        for (int i = 1; i <= n; ++ i) {
            for (int j = 1; j <= k; ++ j) {
                for (int m = 1; m <= d; ++ j) {

                }
            }
        }

        dfs(n, 0, k, d);
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static void dfs(int target, int max, int k, int d) {
        if (target == 0 && max >= d) {
            res ++;
            return;
        }

        for (int i = 1; i <= target && i <= k; ++ i) {
            if (map.containsKey(target)) {
                return;
            }
            int tmp = max;
            if (i > max) {
                max = i;
            }
            dfs(target - i, max, k, d);
            max = tmp;
        }
    }
}
