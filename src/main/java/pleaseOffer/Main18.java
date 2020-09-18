package pleaseOffer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main18 {

    private static int ans = 1;
    private static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; ++ i) {
            nodes[i] = sc.nextInt();
        }
        memo = new int[n][n];
        for (int i = 0; i < n; ++ i) {
            Arrays.fill(memo[i], -1);
        }
        Arrays.sort(nodes);
        if (nodes.length <= 2) {
            System.out.println(1);
            return;
        }
        if (nodes.length == 3) {
            System.out.println(getKinds(nodes, 0, 2));
            return;
        }

        genTree(nodes);
        System.out.println(ans);

    }

    // 长度<=3
    private static int getKinds(int[] nodes, int left, int right) {
        if (right - left + 1 != 3) {
            return 0;
        }
        // nodes 有序
        // 1 1 1
        int mid = left + 1;
        if (nodes[left] == nodes[mid] && nodes[mid] == nodes[right]) {
            return 1;
        }
        // 1 1 2
        if (nodes[left] == nodes[mid] && nodes[mid] < nodes[right]) {
            return 3;
        }
        // 1 2 2
        if (nodes[left] < nodes[mid] && nodes[mid] == nodes[right]) {
            return 2;
        }
        if (nodes[left] < nodes[mid] && nodes[mid] < nodes[right]) {
            return 5;
        }
        return -1;
    }
    private static void genTree(int[] nodes) {


        genTrees(nodes, 0, nodes.length - 1);
    }

    private static int genTrees(int[] nodes, int left, int right) {

        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        if (right - left + 1 == 3) return getKinds(nodes, left, right);
        if (left == right) {
            if (left + 1 < nodes.length && nodes[left] == nodes[left+1]) {
                return 0;
            }
        }
        if (nodes[right] == nodes[right - 1]) {
            return genTrees(nodes, left, right - 1);
        }


        int tmp = 0;

        for (int i = left; i <= right; ++ i) {
            if (i - 1> 0 && nodes[i] == nodes[i-1]) {
                continue;
            }
            int res = 1;
            if (i == left) {
                res *= genTrees(nodes, left + 1, right);
            } else if (i == right) {
                res *= genTrees(nodes, left, right - 1);
            } else {
                int leftK = genTrees(nodes, left, i - 1);
                res *= leftK;
                int rightK = genTrees(nodes, i + 1, right);
                res *= rightK;
            }
            tmp +=res;
        }
        if (left == 0 && right == nodes.length - 1) {
            ans += tmp;
        }
        memo[left][right] = tmp;
        return tmp;
    }


}
