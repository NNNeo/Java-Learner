package leetcode.stack;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

//判断是否正确的出栈顺序
public class OutStackSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st = new Stack<>();

        int i = 0;
        int j = 0;
        while(j < popped.length && i < pushed.length) {

            if(! st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j ++;
                continue;
            }


            st.push(pushed[i]);

                i ++;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        new OutStackSeq().validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }

}
