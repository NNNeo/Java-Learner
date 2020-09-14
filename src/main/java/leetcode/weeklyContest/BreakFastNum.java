package leetcode.weeklyContest;

import java.util.Arrays;

public class BreakFastNum {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int m = staple.length;
        int r = drinks.length - 1;

        long res = 0;
        for(int i = 0; i < m; ++ i) {
            while(r >= 0 && drinks[r] + staple[i] > x) {
                r --;
            }
            res += r - 1;
        }
        return (int)(res % 1000000007);
    }

    public static void main(String[] args) {
        new BreakFastNum().breakfastNumber(new int[] {10, 20, 5}, new int[]{5,5,2},15);
    }
}