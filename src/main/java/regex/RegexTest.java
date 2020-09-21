package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String pat = "^[_a-zA-Z][1-9a-zA-Z_]+";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher("1ab");
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        matcher = pattern.matcher("ab_c");
        if (matcher.find()) {
            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
        }

    }
}
