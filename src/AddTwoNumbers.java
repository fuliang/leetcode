/**
 * Created by fuliang on 2015/4/5.
 *
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pL1 = l1, pL2 = l2;
        int sum = pL1.val + pL2.val;

        ListNode headNode = new ListNode(sum % 10);
        ListNode preNode = headNode;
        pL1 = pL1.next;
        pL2 = pL2.next;

        int nextAdd = sum / 10;

        while (pL1 != null && pL2 != null) {
            sum = pL1.val + pL2.val + nextAdd;
            ListNode sumNode = new ListNode(sum % 10);
            preNode.next = sumNode;
            preNode = sumNode;
            nextAdd = sum / 10;
            pL1 = pL1.next;
            pL2 = pL2.next;
        }

        ListNode leftNode = pL1 == null ? pL2 : pL1;

        while (leftNode != null) {
            sum = leftNode.val + nextAdd;

            ListNode sumNode = new ListNode(sum % 10);
            preNode.next = sumNode;
            nextAdd = sum / 10;
            preNode = sumNode;
            leftNode = leftNode.next;
        }

        if (nextAdd != 0) {
            preNode.next = new ListNode(nextAdd);
        }
        return headNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = ListNode.build(new int[]{9, 9});
        ListNode l2 = ListNode.build(new int[]{1});
        ListNode.print(l1);
        ListNode.print(l2);
        ListNode sumNode = addTwoNumbers.addTwoNumbers(l1, l2);
        ListNode.print(sumNode);
    }
}
