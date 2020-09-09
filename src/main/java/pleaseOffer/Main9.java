package pleaseOffer;

import java.util.*;

public class Main9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++ i) {
            int t = sc.nextInt();
            a[i] = t;
            b[i] = t;
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; ++ i) {
            List<Integer> list = map.getOrDefault(a[i], new ArrayList<>());
            list.add(i);
            map.put(a[i], list);
        }
        for(int bb : b) {
            List<Integer> list = map.get(bb);
            if (list != null && list.size() > 0) {
                int idx = list.get(0);
                if (idx >= n/2) {
                    System.out.println(a[n/2]);
                } else  {
                    System.out.println(a[n/2-1]);
                }
                list.remove(0);
                if (list.size() > 0) {
                    map.put(bb, list);
                }
            }
            
        }
    }
}
