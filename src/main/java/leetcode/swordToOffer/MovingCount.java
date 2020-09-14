package leetcode.swordToOffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingCount {

    private static int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }
    public static int movingCount(int m, int n, int k) {
        int res = 0;

        Queue<int[]> que = new LinkedList<>();
        HashSet<int[]> set = new HashSet<>();
        que.add(new int[]{0, 0});
        while(! que.isEmpty()) {

            int[] po = que.poll();
            for(int i = 0; i < dir.length; ++ i) {
                int nx = po[0] + dir[i][0];
                int ny = po[1] + dir[i][1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && ! set.contains(new int[]{nx, ny}) && check(nx, ny, k)) {
                    que.add(new int[]{nx, ny});
                    set.add(new int[]{nx, ny});
                }
            }
        }
        return set.size();

    }
    private static boolean check(int nx, int ny, int k) {
        int res= 0;
        while(nx > 0) {
            res = res + nx % 10;
            nx /= 10;
        }


        while(ny >0) {
            res += ny % 10;
            ny /= 10;
        }
        return res <= k;
    }
}