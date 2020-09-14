package pleaseOffer;

import java.util.*;
public class Main15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> playerMap = new HashMap<>();
        for(int i = 0; i < n; ++ i) {
            List<Integer> list = new ArrayList<>();
            list.add(i+1);
            map.put(i+1, list); // i场地的人员
            playerMap.put(i+1, i+1); // i选手目前的场地
        }
        String[] orders = new String[m];
        int[] srcs = new int[m];
        int[] dess = new int[m];
        for (int i = 0; i < m; ++ i) {
            orders[i] = in.next();
            srcs[i] = in.nextInt();
            dess[i] = in.nextInt();
        }
        for(int i = 0; i < m; ++ i) {
            String c = orders[i];
            int src = srcs[i];
            int des = dess[i];
            if(c.equals("C")) {
                List<Integer> srclist = map.get(src);
                List<Integer> destlist = map.get(des);

                for(int sr : srclist) {
                    playerMap.put(sr, des);
                }

                destlist.addAll(new ArrayList<>(srclist));
                map.put(des, destlist);
                srclist.clear();
                map.put(src, srclist);
            } else if(c.equals("Q")){
                int ap = src;
                int bp = des;
                if(playerMap.get(ap) != playerMap.get(bp)) {
                    System.out.println(-1);
                } else {
                    List<Integer> targetlist = map.get(playerMap.get(ap));
                    int a = 0;
                    int b = 0;
                    for(int d = 0; d < targetlist.size() ; ++ d) {
                        if(ap == targetlist.get(d)) {
                            a = d;
                        }
                        if(bp == targetlist.get(d)) {
                            b = d;
                        }
                        if(b != 0 && a != 0) {
                            break;
                        }
                    }
                    System.out.println(Math.abs(a- b -1));
                }
            }
        }
    }
}