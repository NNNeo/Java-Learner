package leetcode.dynamicPromgramming;

import java.util.function.Function;

/**
 * 517
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 */
public class FindMinMoves {

    public int findMinMoves(int[] machines) {

        int sum = 0;
        int n = machines.length;
        for (int m : machines) {
            sum += m;
        }

        int avg = sum / n;
        for (int i = 0; i < n; ++ i) {
            machines[i] -= avg;
        }

        int max = 0; // 保存当前位置最大前缀和
        int cur = 0; // 当前和
        int res = 0; // 返回值

        for (int m : machines) {
            cur += m;
            max = Math.max(Math.abs(cur), max);
            res = Math.max(res, Math.max(m, max));

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new FindMinMoves().findMinMoves(new int[]{4, 0, 0, 4}));
    }

    static <A,B,C> Function<A, C> partialB(B b, Function<A, Function<B, C>> f) {
        return a -> f.apply(a).apply(b);
    }
}
