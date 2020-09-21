package pleaseOffer;

public class Main24 {

    public static void main(String[] args) {
        int n = 8;
        int[] dp = new int[9];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // 1 1 1
        // 1 2
        // 2 1
        // 3
        dp[3] = 4;
        for (int i = 4; i <= 8; ++ i) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        System.out.println(dp[8]);
    }
}
