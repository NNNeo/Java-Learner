package leetcode.pleaseOffer;

import java.util.HashSet;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // teams[i] 中的x个人为一组
        int[][] teams = new int[m][];

        for (int i = 0; i < m; ++ i) {
            int x = sc.nextInt();
            teams[i] = new int[x];
            for (int j= 0; j < x; ++ j) {
                teams[i][j] = sc.nextInt();
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int[] team : teams) {
            boolean flag = false;
            for (int t : team) {
                if (t == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                for (int t : team) {
                    set.add(t);
                }
            }
        }
        while (true) {
            int size = set.size();
            for (int[] team : teams) {
                boolean flag = false;
                for (int t : team) {
                    if (set.contains(t)) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    for (int t : team) {
                        set.add(t);
                    }
                }
            }
            if (size == set.size()) {
                break;
            }
        }


        System.out.println(set.size());

    }

    private static int union(int[] fa, int[] team) {
        int change = 0;
        for (int t : team) {
            if (fa[t] != 0) {
                change ++;
                fa[t] = 0;
            }
        }
        return change;
    }

    private static int find(int[] fa, int t) {
        while (fa[t] != t) {
            t = fa[t];
        }
        return t;
    }
}
