/**
 * Created by fuliang on 2015/4/12.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = findMid(head);
        ListNode qNode = midNode.next;
        midNode.next = null;

        ListNode p1 = sortList(head);
        ListNode p2 = sortList(qNode);
        return merge(p1, p2);
    }

    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        ListNode leftNode = p1 == null ? p2 : p1;

        while (leftNode != null) {
            tail.next = leftNode;
            tail = tail.next;
            leftNode = leftNode.next;
        }
        return head.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode p = head, q = head;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        return p;
    }

    private static void test(ListNode head) {
        SortList sol = new SortList();
        ListNode h = sol.sortList(head);
        ListNode.print(h);
    }

    public static void main(String[] args) {
        test(ListNode.build(new int[]{3,1,2,11,-4}));
    }
}
