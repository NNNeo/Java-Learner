package leetcode;

/**
 * 730
 * 给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。
 * 通过从 S 中删除 0 个或多个字符来获得子序列。
 * 如果一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。
 * 如果对于某个i，A_i != B_i，那么A_1, A_2, ... 和B_1, B_2, ... 这两个字符序列是不同的。
 * https://leetcode-cn.com/problems/count-different-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPalindromicSubSequences {

    public static void main(String[] args) {

        System.out.println(new CountPalindromicSubSequences().countPalindromicSubSequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada"));
    }


    private int countPalindromicSubSequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        long[][] dp = new long[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    char c = s.charAt(i);
                    int left = i + 1;
                    int right = j - 1;
                    while (left < j && s.charAt(left) != c) {
                        left++;
                    }
                    while (right > i && s.charAt(right) != c) {
                        right--;
                    }
                    if (left == j) {
                        //i - j 之间没有c  2 是c 和cc 乘2是cc和 i + 1 到 j-1又可以形成新的回文子序列
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (left == right) {
                        //出现了一个c
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;//c已经出现过
                    } else {
                        //出现多个c
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                }
                if(dp[i][j] < 0) {
                    dp[i][j] += 1000000007;
                }
                dp[i][j] %= 1000000007;
            }
        }
        // //Because (a - b) % M = (a % M - b % M) + M when a % M - b % M < 0
        return (int)dp[0][n - 1];
    }
}
