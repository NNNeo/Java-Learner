package leetcode.array;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpGame {

    public int jump(int[] arr) {

        int steps = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < arr.length; ++ i) {
            max = Math.max(max, i + arr[i]);
            if (i == end) {
                end = max;
                steps ++;
            }
        }
        return steps;

    }

    public static void main(String[] args) {
        new JumpGame().jump(new int[]{2,3,1,1,4});
    }
}
