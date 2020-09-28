package pleaseOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
public class Main27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean p =false;
        boolean o = false;
        HashMap<String, Integer> map = new HashMap<>(); // 存员工发单数
        HashMap<String, HashSet<String>> map1 = new HashMap<>(); //领导-员工
        HashMap<String, HashSet<String>> map2 = new HashMap<>(); //员工-外包
        String str;
        while (! (str = sc.nextLine()).equals("eof")) {

            if (str.equals("performance")) {
                p = true;
                continue;
            } else if (str.equals("organization")) {
                o = true;
                p = false;
                continue;
            }

            if (p && str.length() > 0) {
                String[] deliver = str.split(",");
                map.put(deliver[0], Integer.valueOf(deliver[1]));
            }

            if (o && str.length() > 0) {
                String[] fellows = str.split(",");
                String leader = fellows[0];
                String mentor = fellows[1];
                String intern = fellows[2];
                HashSet<String> set1 = map1.getOrDefault(leader, new HashSet<>());
                set1.add(mentor);
                HashSet<String> set2 = map2.getOrDefault(mentor, new HashSet<>());
                set2.add(intern);
                int bills = map.get(intern);
                int mentorbill = map.getOrDefault(mentor, 0) + bills;
                map.put(mentor, mentorbill);
                map1.put(leader, set1);
                map2.put(mentor, set2);
            }
        }

        for (Map.Entry<String, HashSet<String>> entry : map1.entrySet()) {
            String leader = entry.getKey();
            int bills = 0;
            for (String mentor : entry.getValue()) {
                bills += map.get(mentor);
            }
            map.put(leader, bills);
        }
        for (Map.Entry<String,HashSet<String>> entry : map1.entrySet()) {

            String leader = entry.getKey();
            System.out.println(leader+"<" + map.get(leader) + ">");
            HashSet<String> mentors = entry.getValue();
            for (String mentor : mentors) {
                System.out.println("-" + mentor + "<" + map.get(mentor) + ">");
                HashSet<String> interns = map2.get(mentor);
                for (String intern : interns) {
                    System.out.println("--" +intern+"<" +map.get(intern) + ">");
                }
            }
        }
    }
}
