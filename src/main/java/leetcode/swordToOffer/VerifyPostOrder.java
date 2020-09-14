package leetcode.swordToOffer;

import java.util.LinkedHashMap;

public class VerifyPostOrder {

    public static void main(String[] args) {
        System.out.println(new VerifyPostOrder().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }


    public boolean verifyPostorder(int[] postorder) {

        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] order, int left, int right) {
        if(left >= right) {
            return true;
        }
        int target = order[right];

        int i = left;
        while(order[i] < target) {
            i ++;
        }

        // i 是第一个比target大的
        int tmp = i;
        i ++;
        while(i < right) {
            if(order[i] < target) {
                return false;
            } else {
                i ++;
            }
        }
        return check(order, left, tmp - 1) && check(order, tmp, right - 1);

    }
}