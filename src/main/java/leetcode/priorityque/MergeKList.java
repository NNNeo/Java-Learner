package leetcode.priorityque;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKList {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] listNodes) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        ListNode res= new ListNode(0);
        ListNode tail = res;

        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }
        while (! priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();

            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return res.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
