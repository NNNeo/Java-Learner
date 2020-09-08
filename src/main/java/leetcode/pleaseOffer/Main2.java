package leetcode.pleaseOffer;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String article = sc.next();
        int n = article.length();
        char[] arts = article.toCharArray();
        int[] upcase = new int[n];
        // 从i到j 共有j-i+1 个字符，upcase[i][j] 个大写
        upcase[0] = (arts[0] >= 'A' && arts[0] <= 'Z') ? 1 : 0;
        for (int i = 1; i < n; ++ i) {
            if (arts[i] >= 'A' && arts[i] <= 'Z') {
                upcase[i] ++;
            } else {
                upcase[i] = upcase[i-1];
            }

        }
        // dp[i:j] 为从i到j最少修改多少个字符优雅
        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i --) {

            for (int j = i + 1; j < n; j = j + 2) {

                if (isDiff(arts[i], arts[j])) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = dp[i+1][j-1] + 1;
                    int up = upcase[i] - upcase[j] + 1; // 大写个数
                    int down = j - i + 1 - up; // 小写个数
//                    if (arts[i] >= 'A' && arts[i] <= 'Z') {
//                        up += 2;
//                    } else  {
//                        down += 2;
//                    }
                    dp[i][j] = Math.min(dp[i][j], Math.abs(up - (up + down) / 2));
                }

            }
        }
        System.out.println(dp[0][n-1]);
    }

    private static boolean isDiff(char art, char art1) {

        if (art >= 'A' && art <= 'Z' && art1 >= 'a' && art1 <= 'z') {
            return true;
        }
        return art1 >= 'A' && art1 <= 'Z' && art >= 'a' && art <= 'z';
    }
}
