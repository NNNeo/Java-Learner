package pleaseOffer;

import java.util.Scanner;

public class Main29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; ++ i) {
            num[i] = sc.nextInt();
        }

        int res = 0;
        for(int i = 0; i < n-2; ++ i) {
            for(int j = i + 1; j < n-1; ++ j) {
                for (int k = j + 1; k < n; ++ k) {
                    if (num[i] <= num[j] && num[j] <= num[k]) {
                        res ++;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
