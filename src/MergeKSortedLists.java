import java.util.*;

/**
 * Created by Administrator on 2015/4/6.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty())
            return null;
        if (lists.size() == 1) {
            return lists.get(0);
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            ListNode head = lists.get(i);
            if (head !=  null) {
                queue.add(head);
            }
        }

        ListNode head = null;
        ListNode curNode = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

            if (head == null) {
                head = new ListNode(node.val);
                curNode = head;
            } else {
                curNode.next = new ListNode(node.val);
                curNode = curNode.next;
            }

            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1,2,3,4});
        ListNode l2 = ListNode.build(new int[]{200,7000,10000});
        ListNode l3 = ListNode.build(new int[]{3,6,21});

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode result = sol.mergeKLists(list);
        ListNode.print(result);
    }
}
