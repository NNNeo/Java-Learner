package pleaseOffer;

import java.util.Scanner;

public class Main23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000_000_007;
        while (n > 0) {
            n --;

            int a = sc.nextInt();
            int b = sc.nextInt();
            String op = sc.next();

            if ("-".equals(op)) {
                System.out.println((a-b) % mod);
            } else if ("+".equals(op)) {
                System.out.println((a+b) % mod);
            } else if ("^".equals(op)) {
                System.out.println(power(a, b));
            } else {

                if (a * b < Math.abs(a) || a * b < Math.abs(b)) {
                    System.out.println(-1);
                } else {
                    System.out.println((a * b) % mod);
                }

            }
        }
    }

    private static double power(int x, int n) {
        if(n == 0)
            return 1;
        double t = power(x,n/2);
        t %= 1000_000_007;
        t = t*t;
        if(n%2 == 1)
            t = t*x;
        return (t % 1000_000_007);
    }

}
