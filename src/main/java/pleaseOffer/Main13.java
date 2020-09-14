package pleaseOffer;

import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++ j) {
                mat[i][j] = sc.nextInt();
            }
        }

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mat, mid, right)) {
                right = mid;
            } else {
                for (int i = 0; i <= right; ++ i) {
                    for (int j = 0; j < m; ++ j) {
                        System.out.print(mat[i][j]);
                        if (j != m - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    private static boolean check(int[][] mat, int mid, int right) {
        int[][] half = new int[mat.length][mat[0].length];
        // 0 - mid , mid + 1 - right
        int i = mid;
        int j = mid + 1;
        while (i >= 0 && j <= right) {
            for(int k = 0; k < mat[0].length; ++ k) {
                if (mat[i][k] != mat[j][k]) {
                    return false;
                }
            }
            i --;
            j ++;
        }
        return true;
    }
}
