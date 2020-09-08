package leetcode.pleaseOffer;

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return
//            }
//        });
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++ i) {
            int call = sc.nextInt();
            if (! set.contains(call)) {
                list.add(0, call);
                set.add(call);

            } else {
                int idx = 0;
                for (int j = 0; j < list.size(); ++ j) {
                    if (list.get(j) == call) {
                        idx = j;
                    }
                }
                list.remove(idx);

                list.add(0, call);
            }
        }

        for (int n : list) {
            System.out.println(n);
        }
    }
}
