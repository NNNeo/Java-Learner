package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().compute_entropy("AABB"));
    }

    public double compute_entropy(String content) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : content.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        int sum = content.length();
        double[] p = new double[map.keySet().size()];
        int idx = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            p[idx] = entry.getValue() / (sum*1.0);
//            System.out.println(p[idx]);
            idx ++;
        }

        double ret = 0.0;

        for (double pi : p) {
            ret += pi * (Math.log(pi) / Math.log(2));
        }

        ret = 0 - ret;
        return ret;

    }
}
