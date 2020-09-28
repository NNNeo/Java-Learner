package pleaseOffer;

import java.util.Scanner;
import java.util.TreeSet;

public class Main28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] num = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; ++ i) {
            num[i] = sc.nextInt();
            treeSet.add(num[i]);
        }

        while (q>0) {
            q --;
            int qq = sc.nextInt();
            int floor = -1;
            if (treeSet.floor(qq) != null) {
                floor = treeSet.floor(qq);
            }
            int ceil = -1;
            if (treeSet.ceiling(qq) != null) {
                ceil = treeSet.ceiling(qq);
            }

            if (floor == -1) {
                System.out.println(ceil);
            } else if (ceil == -1) {
                System.out.println(floor);
            } else if (Math.abs(qq-floor) == Math.abs(qq-ceil)) {
                System.out.println(floor);
            } else if (Math.abs(qq-floor) < Math.abs(qq-ceil)) {
                System.out.println(floor);
            } else {
                System.out.println(ceil);
            }
        }
    }

}
