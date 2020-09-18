package pleaseOffer;

import java.util.*;
public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
//            st.equals()
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    st.push(c);
                } else {

                    if ((st.peek() == '(' && c != ')') || (st.peek() == '{' && c != '}') || (st.peek() == '[' && c != ']')) {
                        System.out.println(false);
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if (flag) {
                if (st.isEmpty()) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }

        }
    }
}