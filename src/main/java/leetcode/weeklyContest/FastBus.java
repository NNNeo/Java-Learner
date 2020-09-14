package leetcode.weeklyContest;

import java.util.HashMap;

/**
 * 小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：
 * 小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
 * 小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
 * 现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。
 * 假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
 * 注意：小扣可在移动过程中到达编号大于 target 的站点。
 * 示例 1：
 * 输入：target = 31, inc = 5, dec = 3, jump = [6], cost = [10]
 * 输出：33
 * 解释：
 * 小扣步行至 1 号站点，花费时间为 5；
 * 小扣从 1 号站台搭乘 0 号公交至 6 * 1 = 6 站台，花费时间为 10；
 * 小扣从 6 号站台步行至 5 号站台，花费时间为 3；
 * 小扣从 5 号站台搭乘 0 号公交至 6 * 5 = 30 站台，花费时间为 10；
 * 小扣从 30 号站台步行至 31 号站台，花费时间为 5；
 * 最终小扣花费总时间为 33。
 */
public class FastBus {

    private HashMap<Long, Long> mp;
    int[] jump;
    int[] cost;
    static int mod = 1000000007;
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        mp = new HashMap<>();
        this.jump = jump;
        this.cost = cost;
        long ans = solve(target, inc, dec);
        return (int)(ans % mod);
    }

    private long solve(int target, int inc, int dec) {
        if(target == 0) {
            return 0;
        }
        if (target == 1) {
            return inc;
        }

        if (mp.containsKey(target)) {
            return mp.get(target);
        }
        long ans = inc * target;

        for (int i = 0; i < jump.length; ++ i) {

            int u = target / jump[i]; // 上一个节点， u
            int v = target % jump[i]; // 不到上一个节点， 多出了一些

            if (v == 0) {
                ans = Math.min(ans, solve(u, inc, dec) + cost[i]);
            } else {
                ans = Math.min(ans, solve(u, inc, dec) + cost[i] + v * inc);
                ans = Math.min(ans, solve(u + 1, inc, dec) + cost[i] + (jump[i] - v) * dec);
            }
        }
        return ans;
    }
}
