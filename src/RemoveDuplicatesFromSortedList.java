/**
 * Created by Administrator on 2015/4/6.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode preNode = head;
        ListNode curNode = head;

        while (true) {
            preNode = curNode;
            curNode = curNode.next;
            if (curNode == null)
                break;

            if (curNode.val == preNode.val) {
                preNode.next = curNode.next;
                curNode.next = null;
                curNode = preNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = ListNode.build(new int[]{1,1});
        RemoveDuplicatesFromSortedList sol = new RemoveDuplicatesFromSortedList();
        lst = sol.deleteDuplicates(lst);
        ListNode.print(lst);
    }
}
