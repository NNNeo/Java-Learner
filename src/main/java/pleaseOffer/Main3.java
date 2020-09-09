package pleaseOffer;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; ++ i) {
            a[i] = sc.nextInt();

        }

        int[] b = new int[n+1];
        for (int i = 1; i <= n; ++ i) {
            int[] mod = new int[n+1];
            for (int j = 1; j <= n; ++ j) {
                mod[j] = i % j;
            }

            b[i] = a[i] ^ mod[1];
            for (int j = 2; j <= n; ++ j) {
                b[i] ^= mod[j];
            }
        }

        int res = b[1];
        for (int i = 2; i <= n; ++ i) {
            res ^= b[i];
        }
        System.out.println(res);
    }
}
