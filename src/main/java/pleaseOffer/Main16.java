package pleaseOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (! set.contains(c)) {
                set.add(c);
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
