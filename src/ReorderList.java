/**
 * Created by fuliang on 2015/4/18.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode tailList = tailList(head);
        ListNode head2 = reverse(tailList);
        mergeList(head, head2);
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2;
        ListNode p1Next, p2Next;

        while (p1 != null && p2 != null) {
            p1Next = p1.next;
            p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head.next, q;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        head.next = null;

        while (p != null) {
            q = p.next;
            p.next = pHead.next;
            pHead.next = p;
            p = q;
        }
        return pHead.next;
    }

    private ListNode tailList(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        q = p;
        p = p.next;
        q.next = null;

        return p;
    }

    private static void test(ListNode head) {
        ReorderList sol = new ReorderList();
        sol.reorderList(head);
        ListNode.print(head);
    }

    public static void main(String[] args) {
        //test(ListNode.build(new int[]{1}));
        //test(ListNode.build(new int[]{1, 2, 3}));
        //test(ListNode.build(new int[]{1,2,3,4}));
        test(ListNode.build(new int[]{1,2,3,4, 5, 6}));
    }
}
