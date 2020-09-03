package leetcode.dynamicPromgramming;

/**
 * 1140
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * 游戏一直持续到所有石子都被拿走。
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGame {

    // 从头开始拿不好判断
    // 从尾部开始
    public int stoneGame(int[] piles) {
        // dp[i][j] : [i:len-1] 的石头， M = j，最大的情况，拿走最多的石头
        int n = piles.length;
        int[][] dp = new int[n][2*n];
        int sum = 0;
        for (int i = n-1; i >= 0; -- i) {
            sum += piles[i];
            for (int j = 1; j <= n; ++ j) {
                if (i + 2 * j >= n) {
                    dp[i][j] = sum;
                } else {
                    for (int x = 1; x <= 2 * j; ++ x) {
                        dp[i][j] = Math.max(dp[i][j], sum - dp[i+x][Math.max(x, j)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
