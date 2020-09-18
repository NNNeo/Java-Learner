package pleaseOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main22 {
    private static int[][] dir = new int[][] {{-1, 0}, {1, 0} ,{0, -1}, {0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t --;

            int n = sc.nextInt();
            int m = sc.nextInt();


            char[][] mat = new char[n][m];
            for (int i = 0; i < n; ++ i) {
                mat[i] = sc.next().toCharArray();
            }
            int sx = 0;
            int sy = 0;
            for (int i = 0; i < n; ++ i) {
                for (int j = 0; j < m; ++ j) {
                    if (mat[i][j] == 'S') {
                       sx = i;
                       sy = j;
                       break;
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            visited[sx][sy] = true;
            boolean flag = true;
            Queue<Integer> que = new LinkedList<>();
            que.add(sx * n + sy);
            while (! que.isEmpty()) {
                int cur = que.poll();
                int x = cur / n;
                int y = cur % n;
                if (mat[x][y] == 'E') {
                    System.out.println("YES");
                    flag = false;
                    break;
                }
                for (int i = 0; i < 4; ++ i) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && mat[nx][ny] != '#') {
                        visited[nx][ny] = true;
                        que.add(nx * n + ny);
                    }
                }
            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }
}
