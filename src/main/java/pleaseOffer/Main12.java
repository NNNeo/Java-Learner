package pleaseOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] ss = s.toCharArray();
        int n = ss.length;
        int[][] dp = new int[n][n];
        for(int i = n - 2; i >= 0; i --) {
            for(int j = i; j < n; ++ j) {
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    if(ss[i] == ss[j]) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                    }
                }
            }
        }

        if(dp[0][n-1] > 1) {
            System.out.println("false");
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char sss : ss) {
            map.put(sss, map.getOrDefault(sss, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1 && entry.getValue() % 2 != 0) {
                System.out.println(entry.getKey());
            }
        }

    }
}

