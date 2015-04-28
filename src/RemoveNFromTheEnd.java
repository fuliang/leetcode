/**
 * Created by Administrator on 2015/4/5.
 */
public class RemoveNFromTheEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        if (first == null) {
            head = head.next;
            return head;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }


    public static void main(String[] args) {
       ListNode l = ListNode.build(new int[]{1,2,3,4,5});
        RemoveNFromTheEnd sol = new RemoveNFromTheEnd();
        l = sol.removeNthFromEnd(l, 5);
        ListNode.print(l);
    }
}
