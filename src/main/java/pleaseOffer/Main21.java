package pleaseOffer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] input = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length; ) {
            if (input[i] < '1' || input[i] > '3') {
                i ++;
                continue;
            }
            if (check(input, i) != -1) {
                list.add(String.valueOf(input, i, 4));
                i += 5;
            } else {
                i ++;
            }
        }
        int idx = 0;
        for (String t : list) {
            System.out.print(t);
            if (idx != list.size() - 1) {
                System.out.print(" ");
            }
            idx ++;
        }
    }


    private static int check(char[] ss, int start) {
        if (ss[start] < '1' || ss[start] > '3') {
            return -1;
        }
        if (start + 3 >= ss.length) {
            return -1;
        }
        int year = ss[start] - '0';
        int i;
        for (i = start + 1; i <= start + 3; ++ i) {
            if (ss[i] < '0' || ss[i] > '9') {
                return -1;
            } else {
                year = year * 10 + (ss[i]-'0');
            }
        }
//        System.out.println(i);
//        System.out.println(ss[i]);
        if (start - 1 >= 0 && ss[start-1] >= '0' && ss[start-1] <= '9') {
            return -1;
        }
        if (i < ss.length && ss[i] >= '0' && ss[i] <= '9') {
            return -1;
        }
        if (year < 1000 || year > 3999) {
            return -1;
        }
        return year;
    }
}
