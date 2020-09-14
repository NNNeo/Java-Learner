package pleaseOffer;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11 {
    private static int[][] dir = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stx = sc.nextInt();
        int sty = sc.nextInt();
        int enx = sc.nextInt();
        int eny = sc.nextInt();
        String[] mat = new String[n];
        for(int i = 0; i < n; ++ i) {
            mat[i] = sc.next();
        }
        char[][] matrix = new char[n][n];
        int idx = 0;
        for (String mats : mat) {
            matrix[idx ++] = mats.toCharArray();
        }

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(stx, sty, 0));
        int[][] memo = new int[n][n];
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }
        while (! que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;
            int v = p.v;
            if (x >= 0 && x < n && y >= 0 && y < n && memo[x][y] == -1 && matrix[x][y] != '@' && matrix[x][y] != '#') {
                memo[x][y] = v + 1;
                que.add(new Point(x + 1, y, v + 1));
                que.add(new Point(x -1 , y, v + 1));
                que.add(new Point(x, y + 1, v + 1));
                que.add(new Point(x, y - 1, v + 1));
            }
        }
        System.out.println(memo[enx][eny]);
    }


}

class Point {
    int x;
    int y;
    int v;
    Point(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x) + Integer.hashCode(y);
    }
}

/**
 * n=int(input())
 * [x,y,x1,y1]=[int(i) for i in str(input()).split(' ')]
 * mat=[]
 * for i in range(n):
 *     mat.append([1 if c in ['#','@'] else 0 for c in str(input())])
 * def func(x,y,x1,y1,mat):
 *     if mat[x1][y1]==1:
 *         return -1
 *     memo=dict()
 *     memo[(x1,y1)]=0
 *
 *     def dfs(x,y,x1,y1,mat):
 *         if (x,y) in memo:
 *             return memo[(x,y)]
 *         if not (0<=x<n and 0<=y<n):
 *             return 1e9
 *         if mat[x][y]==1:
 *             return 1e9
 *         memo[(x,y)]=1e9
 *         r1=dfs(x+1,y,x1,y1,mat)
 *         r2=dfs(x-1,y,x1,y1,mat)
 *         r3=dfs(x,y+1,x1,y1,mat)
 *         r4=dfs(x,y-1,x1,y1,mat)
 *         memo[(x,y)]=min([r1,r2,r3,r4])+1
 *         return memo[(x,y)]
 *     ret=dfs(x,y,x1,y1,mat)
 *     return ret if ret<1e9 else -1
 * print(func(x,y,x1,y1,mat))
 */
