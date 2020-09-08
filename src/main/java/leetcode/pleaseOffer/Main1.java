package leetcode.pleaseOffer;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();

        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        for (int i = 0; i < p; ++ i) {
            a.add(sc.nextInt());
        }

        for (int i = 0; i < q; ++ i) {
            b.add(sc.nextInt());
        }

        HashSet<Integer> c = new HashSet<>();

        for (int bb : b) {
            if (a.contains(bb)) {
                c.add(bb);
            }
        }

        for (int aa : a) {
            if (b.contains(aa)) {
                c.add(aa);
            }
        }

        for (int cc : c) {
            a.remove(cc);
            b.remove(cc);
        }

        System.out.println(a.size() + " " + b.size() + " " + c.size());
    }
}
