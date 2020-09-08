package leetcode.pleaseOffer;

import javafx.util.Pair;

import java.util.*;

public class Main8 {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        PriorityQueue<Pair<String, Integer>> que = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        PriorityQueue<Pair<String, Integer>> que2 = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o1.getValue() - o2.getValue();
            }
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue() - o2.getValue();
        });
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            Pair<String, Integer> pair = new Pair<>(entry.getKey(), entry.getValue());
            que.add(pair);
            que2.add(pair);
        }

        Object[] tmp = que.toArray();
        for (int i = 0; i < k; ++ i) {
            String[] str = tmp[i].toString().split("=");
            System.out.println(str[0] + " " + str[1]);
        }
        tmp = que2.toArray();
        for (int i = 0; i < k ; ++ i) {
            String[] str = tmp[i].toString().split("=");
            System.out.println(str[0] + " " + str[1]);
        }
//        for ()
    }

//    static class Pair<K, V> {
//        K key;
//        V value;
//
//        private K getKey(){
//            return key;
//        }
//
//        private V getValue() {
//            return value;
//        }
//
//        Pair(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public String toString() {
//            return key + "=" + value;
//        }
//    }
}
