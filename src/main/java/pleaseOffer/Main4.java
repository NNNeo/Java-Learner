package pleaseOffer;

import java.util.*;

/**
 * 在小团的公司中，有n位员工。除了最高领导——小团外，每位员工有且仅有一位直接领导。所以，公司内从属关系可以看成一棵树。
 * 现在，公司接到一个项目，需要重新划分这n位员工的从属关系。新的划分描述如下：
 * 1.每个人要么没有下属，要么有至少两个直接下属（即至少有两人的直接领导为这个人）
 * 2.第 i 个人的下属（包括自己）有恰好 ai 个。
 * 请注意，直接下属和下属（包括自己）可分别看做树上点的"儿子"和"子树"。
 * 请问是否存在这么一种关系？注意，输入不会给出最高领导的编号。
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++ i) {
                a[i] = sc.nextInt();
            }
            boolean flag = true;
            int leaf = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int aa : a) {
                if (aa == 2) {
                    flag = false;
                    break;
                }
                if (aa == 1) {
                    leaf ++;
                } else {
                    list.add(aa);
                }
            }
            if (! flag) {
                System.out.println("NO");
                continue;
            }
            PriorityQueue<Integer> que = new PriorityQueue<Integer>();
            while (leaf > 0) {
//                resource.add(1);
                leaf --;
            }

            Collections.sort(list);
            for (int node : list) {
                int tmp = node - 1;

            }

        }
    }
}
