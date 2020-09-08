package leetcode.pleaseOffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++ i) {
            set.add(sc.nextInt());
        }
        int m = sc.nextInt();

        for (int i = 0; i < m; ++ i) {
            int tmp = sc.nextInt();
            if (set.contains(tmp)) {
                list.add(tmp);
            }
        }


        for (int i = 0; i < list.size(); ++ i) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }


    }
}

